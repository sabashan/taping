package com.excelsoft.model;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@SuppressWarnings("deprecation")
@Entity
@Table(name="mstuser")
@Indexed
@XmlRootElement
public class Mstuser extends AuditFields implements Serializable,UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5704065491742564801L;
	protected final transient Log log = LogFactory.getLog(getClass());
	private String userId;
    private String EMailAddress;
    private String activeInactiveFlag;
    private Date lastLoginDate;
    private String lastLoginDetails;
    private String locationCode;
    private String multistkLocation;
    private String reason;
    private String userGroup;
    private String userName;
    private String userPw;
    private String userSignature;
    private String userType;

    public Mstuser(){}
    
    public Mstuser(final String username) {
        this.userId = username;
    }
    
    
    @Id  @DocumentId   
	@Column(name="user_id", length=50 ,columnDefinition="CHAR(50)")	
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="e_mail_address", length=50,nullable=true ,columnDefinition="CHAR(50)")
    @Field
    public String getEMailAddress() {
        return this.EMailAddress;
    }
    
    public void setEMailAddress(String EMailAddress) {
        this.EMailAddress = EMailAddress;
    }
    
    @Column(name="active_inactive_flag", length=1 ,columnDefinition="CHAR(1)")
    @Field
    public String getActiveInactiveFlag() {
        return this.activeInactiveFlag;
    }
    
    public void setActiveInactiveFlag(String activeInactiveFlag) {
        this.activeInactiveFlag = activeInactiveFlag;
    }
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_login_date", length=19)
    @Field
    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }
    
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    
    @Column(name="last_login_details", length=150 , columnDefinition="VARCHAR(150)")
    public String getLastLoginDetails() {
        return this.lastLoginDetails;
    }
    
    public void setLastLoginDetails(String lastLoginDetails) {
        this.lastLoginDetails = lastLoginDetails;
    }
    
    @Column(name="location_code", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getLocationCode() {
        return this.locationCode;
    }
    
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
     
    @Column(name="multistk_location", length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getMultistkLocation() {
        return this.multistkLocation;
    }
    
    public void setMultistkLocation(String multistkLocation) {
        this.multistkLocation = multistkLocation;
    }
    
    @Column(name="reason" , columnDefinition="MEDIUMTEXT")
    @Lob
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    @Column(name="user_group", length=10 ,columnDefinition="CHAR(10)")
    @Field
    public String getUserGroup() {
        return this.userGroup;
    }
    
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
    
    @Column(name="user_name", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="user_pw", nullable=false, length=20 ,columnDefinition="CHAR(20)")
    @Field
    public String getUserPw() {
        return this.userPw;
    }
    
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    
    @Column(name="user_signature" , columnDefinition="MEDIUMTEXT")
    @Lob
    public String getUserSignature() {
        return this.userSignature;
    }
    
    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }
    
    @Column(name="user_type", nullable=false, length=6 ,columnDefinition="CHAR(6)")
    @Field
    public String getUserType() {
        return this.userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        try{
	        if(getUserGroup().equals("ADM")){
	        	authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
	        }else{
	        	log.debug(getUserGroup());
	        	authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
	        }
        }
        catch(Exception e){
        	log.debug(e);
        	authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        }
        return authorities;
    }

    /**
     * Convert user roles to LabelValue objects for convenience.
     *
     * @return a list of LabelValue objects with role information
     */
    @Transient
    public List<LabelValue> getRoleList() {
        List<LabelValue> userRoles = new ArrayList<LabelValue>();
                // convert the user's roles to LabelValue Objects
        	userRoles.add(new LabelValue(getUserGroup(), getUserGroup()));
        return userRoles;
    }
    
	@Override
	 @Transient
	public String getPassword() {	
		return getUserPw();
	}

	@Override
	@Transient
	public String getUsername() {	
		return getUserName();
	}

	@Override
	 @Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	 @Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	 @Transient
	public boolean isCredentialsNonExpired() {	
		return true;
	}

	@Override
	 @Transient
	public boolean isEnabled() {
		return true;
	}
    
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mstuser pojo = (Mstuser) o;

        if (EMailAddress != null ? !EMailAddress.equals(pojo.EMailAddress) : pojo.EMailAddress != null) return false;
        if (activeInactiveFlag != null ? !activeInactiveFlag.equals(pojo.activeInactiveFlag) : pojo.activeInactiveFlag != null) return false;
        if (createdAt != null ? !createdAt.equals(pojo.createdAt) : pojo.createdAt != null) return false;
        if (createdBy != null ? !createdBy.equals(pojo.createdBy) : pojo.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(pojo.createdOn) : pojo.createdOn != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(pojo.lastLoginDate) : pojo.lastLoginDate != null) return false;
        if (lastLoginDetails != null ? !lastLoginDetails.equals(pojo.lastLoginDetails) : pojo.lastLoginDetails != null) return false;
        if (locationCode != null ? !locationCode.equals(pojo.locationCode) : pojo.locationCode != null) return false;
        if (modifiedAt != null ? !modifiedAt.equals(pojo.modifiedAt) : pojo.modifiedAt != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(pojo.modifiedBy) : pojo.modifiedBy != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(pojo.modifiedOn) : pojo.modifiedOn != null) return false;
        if (multistkLocation != null ? !multistkLocation.equals(pojo.multistkLocation) : pojo.multistkLocation != null) return false;
        if (reason != null ? !reason.equals(pojo.reason) : pojo.reason != null) return false;
        if (userGroup != null ? !userGroup.equals(pojo.userGroup) : pojo.userGroup != null) return false;
        if (userName != null ? !userName.equals(pojo.userName) : pojo.userName != null) return false;
        if (userPw != null ? !userPw.equals(pojo.userPw) : pojo.userPw != null) return false;
        if (userSignature != null ? !userSignature.equals(pojo.userSignature) : pojo.userSignature != null) return false;
        if (userType != null ? !userType.equals(pojo.userType) : pojo.userType != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (EMailAddress != null ? EMailAddress.hashCode() : 0);
        result = 31 * result + (activeInactiveFlag != null ? activeInactiveFlag.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (lastLoginDetails != null ? lastLoginDetails.hashCode() : 0);
        result = 31 * result + (locationCode != null ? locationCode.hashCode() : 0);
        result = 31 * result + (modifiedAt != null ? modifiedAt.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (multistkLocation != null ? multistkLocation.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (userGroup != null ? userGroup.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPw != null ? userPw.hashCode() : 0);
        result = 31 * result + (userSignature != null ? userSignature.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);

        return result;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mstuser [userId=").append(userId)
				.append(", EMailAddress=").append(EMailAddress)
				.append(", activeInactiveFlag=").append(activeInactiveFlag)
				.append(", lastLoginDate=").append(lastLoginDate)
				.append(", lastLoginDetails=").append(lastLoginDetails)
				.append(", locationCode=").append(locationCode)
				.append(", multistkLocation=").append(multistkLocation)
				.append(", reason=").append(reason).append(", userGroup=")
				.append(userGroup).append(", userName=").append(userName)
				.append(", userPw=").append(userPw).append(", userSignature=")
				.append(userSignature).append(", userType=").append(userType)
				.append("]");
		return builder.toString();
	}

	

}
