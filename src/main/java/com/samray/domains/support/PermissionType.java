package com.samray.domains.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/10/17
 */
public enum PermissionType {
    MENU("Menu"),
    OPERATION("Operation");

    private String name;
    private final static Logger logger= LoggerFactory.getLogger(PermissionType.class);
    PermissionType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId(){
        return name();
    }

    @Override
    public String toString() {
        return getName();
    }
    public static PermissionType getEnum(String value) {
        PermissionType permissionType=null;//default
        for(PermissionType v : PermissionType.values())
            if(v.getName().equalsIgnoreCase(value)) {
                permissionType=v;
            }else {
                logger.warn("cannot find proper enum value");
                throw new IllegalArgumentException();
            }
            return permissionType;
    }
}
