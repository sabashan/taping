package com.excelsoft.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import com.excelsoft.Constants;
import com.excelsoft.model.Mstuser;
import com.excelsoft.service.UserExistsException;
import com.excelsoft.service.UserManager;
import com.excelsoft.webapp.util.RequestUtil;
import org.springframework.mail.MailException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 *
 * <p><a href="UserFormController.java.html"><i>View Source</i></a>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/userform*")
public class UserFormController extends BaseFormController {



    public UserFormController() {
        setCancelView("redirect:/home");
        setSuccessView("redirect:/admin/users");
    }

    @Override
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        super.initBinder(request, binder);
        binder.setDisallowedFields("password", "confirmPassword");
    }

    /**
     * Load user object from db before web data binding in order to keep properties not populated from web post.
     * 
     * @param request
     * @return
     */
    @ModelAttribute("user")
    protected Mstuser loadUser(final HttpServletRequest request) {
        final String userId = request.getParameter("id");
        if (isFormSubmission(request) && StringUtils.isNotBlank(userId)) {
            return getUserManager().getUser(userId);
        }
        return new Mstuser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") final Mstuser user, final BindingResult errors, final HttpServletRequest request,
            final HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            if (!StringUtils.equals(request.getParameter("from"), "list")) {
                return getCancelView();
            } else {
                return getSuccessView();
            }
        }

        if (validator != null) { // validator is null during testing
            validator.validate(user, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "userform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        final Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            getUserManager().removeUser(user.getUserId().toString());
            saveMessage(request, getText("user.deleted", user.getUserName(), locale));

            return getSuccessView();
        } else {

            // only attempt to change roles if user is admin for other users,
            // showForm() method will handle populating
            if (request.isUserInRole(Constants.ADMIN_ROLE)) {
                final String userRoles = request.getParameter("userGroup");

              // if (userRoles != null) {
               // //    user.getRoles().clear();
                 //   for (final String roleName : userRoles) {
                        user.setUserGroup(userRoles);
                 //   }
               // }
            } else {
                // if user is not an admin then load roles from the database
                // (or any other user properties that should not be editable
                // by users without admin role)
                final Mstuser cleanUser = getUserManager().getUserByUsername(
                        request.getRemoteUser());
                user.setUserGroup(cleanUser.getUserGroup());
            }

           // final Integer originalVersion = user.getVersion();

            // set a random password if user is added by admin
           // if (originalVersion == null && StringUtils.isBlank(user.getPassword())) {
               // user.setUserPw(UUID.randomUUID().toString()); 
                // UUID is a
                // good choice
                // here
           // }

            try {
                getUserManager().saveUser(user);
            } catch (final AccessDeniedException ade) {
                // thrown by UserSecurityAdvice configured in aop:advisor userManagerSecurity
                log.warn(ade.getMessage());
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return null;
            } catch (final UserExistsException e) {
                errors.rejectValue("username", "errors.existing.user",
                        new Object[] { user.getUsername(), user.getEMailAddress() }, "duplicate user");

                // reset the version # to what was passed in

                return "userform";
            }

            if (!StringUtils.equals(request.getParameter("from"), "list")) {
                saveMessage(request, getText("user.saved", user.getUsername(), locale));

                // return to main Menu
                return getCancelView();
            } else {
                if (StringUtils.isBlank(request.getParameter("version"))) {
                    saveMessage(request, getText("user.added", user.getUserName(), locale));

                    // Send an account information e-mail
                    message.setSubject(getText("signup.email.subject", locale));

                    try {
                        final String resetPasswordUrl = getUserManager().buildRecoveryPasswordUrl(user,
                                UpdatePasswordController.RECOVERY_PASSWORD_TEMPLATE);
                        sendUserMessage(user, getText("newuser.email.message", user.getUserName(), locale),
                                RequestUtil.getAppURL(request) + resetPasswordUrl);
                    } catch (final MailException me) {
                        saveError(request, me.getCause().getLocalizedMessage());
                    }

                    return getSuccessView();
                } else {
                    saveMessage(request, getText("user.updated.byAdmin", user.getUserName(), locale));
                }
            }
        }

        return "userform";
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Mstuser showForm(final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {
        // If not an administrator, make sure user is not trying to add or edit another user
        if (!request.isUserInRole(Constants.ADMIN_ROLE) && !isFormSubmission(request)) {
            if (isAdd(request) || request.getParameter("id") != null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                log.warn("Mstuser '" + request.getRemoteUser() + "' is trying to edit user with id '" +
                        request.getParameter("id") + "'");

                throw new AccessDeniedException("You do not have permission to modify other users.");
            }
        }

        if (!isFormSubmission(request)) {
            final String userId = request.getParameter("id");

            Mstuser user;
            if (userId == null && !isAdd(request)) {
                user = getUserManager().getUserByUsername(request.getRemoteUser());
            } else if (!StringUtils.isBlank(userId)) {
                user = getUserManager().getUser(userId);
            } else {
                user = new Mstuser();

                user.setUserGroup(Constants.USER_ROLE);
                user.setUserType("user");
            }

            return user;
        } else {
            // populate user object from database, so all fields don't need to be hidden fields in form
            return getUserManager().getUser(request.getParameter("id"));
        }
    }

    private boolean isFormSubmission(final HttpServletRequest request) {
        return request.getMethod().equalsIgnoreCase("post");
    }

    protected boolean isAdd(final HttpServletRequest request) {
        final String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
}
