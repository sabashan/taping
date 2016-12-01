package com.excelsoft.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excelsoft.model.LabelValue;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;


/**
 * Utility class to convert one object to another.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class ConvertUtil {
    private static final Log log = LogFactory.getLog(ConvertUtil.class);

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private ConvertUtil() {
    }

    /**
     * Method to convert a ResourceBundle to a Map object.
     *
     * @param rb a given resource bundle
     * @return Map a populated map
     */
    public static Map<String, String> convertBundleToMap(ResourceBundle rb) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }

        return map;
    }

    /**
     * Convert a java.util.List of LabelValue objects to a LinkedHashMap.
     *
     * @param list the list to convert
     * @return the populated map with the label as the key
     */
    public static Map<String, String> convertListToMap(List<LabelValue> list) {
        Map<String, String> map = new LinkedHashMap<String, String>();

        for (LabelValue option : list) {
            map.put(option.getLabel(), option.getValue());
        }

        return map;
    }

    /**
     * Method to convert a ResourceBundle to a Properties object.
     *
     * @param rb a given resource bundle
     * @return Properties a populated properties object
     */
    public static Properties convertBundleToProperties(ResourceBundle rb) {
        Properties props = new Properties();

        for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
            String key = keys.nextElement();
            props.put(key, rb.getString(key));
        }

        return props;
    }

    /**
     * Convenience method used by tests to populate an object from a
     * ResourceBundle
     *
     * @param obj an initialized object
     * @param rb a resource bundle
     * @return a populated object
     */
    public static Object populateObject(Object obj, ResourceBundle rb) {
        try {
            Map<String, String> map = convertBundleToMap(rb);
            BeanUtils.copyProperties(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception occurred populating object: " + e.getMessage());
        }

        return obj;
    }
    
    /**
     * 
     * @param String number
     * @return Long
     */
    public static Long getlongs(String number){
    	Long key1=0l;
    	try {
			key1=new Long(number);
		} catch (Exception e) {
			key1=0L;
		}
    	return key1;
    }
    
    /**
     * 
     * @param number
     * @return BigDecimal
     */
    public static BigDecimal getDecimal(String number){
    	// parse the string
    	BigDecimal bigDecimal=new BigDecimal(0);
    	try {
    		bigDecimal= new BigDecimal(number);
    	System.out.println(bigDecimal);
    	} catch (Exception e) {
    		bigDecimal=new BigDecimal(0);
		}
    	return bigDecimal;
    }
    /**
     * 
     * @param number
     * @return BigDecimal
     */
    public static BigDecimal getDecimal(Long number){
    	// parse the string
    	BigDecimal bigDecimal=new BigDecimal(0);
    	try {
    		bigDecimal= new BigDecimal(number);
    	System.out.println(bigDecimal);
    	} catch (Exception e) {
    		bigDecimal=new BigDecimal(0);
		}
    	return bigDecimal;
    }
    
    /**
     * 
     * @param number
     * @return integer
     */
    public static Integer getINT(String number){
    	// parse the string
    	Integer integer=0;
    	try {
    		integer= new Integer(number);
    	System.out.println(integer);
    	} catch (Exception e) {
    		integer=new Integer(0);
		}
    	return integer;
    }
}
