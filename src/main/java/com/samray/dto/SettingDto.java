package com.samray.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/19/17
 */
@Getter
@Setter
public class SettingDto {
    private String blogName;
    private  String blogSlogan;
    private int displayPerPageSize;
    private int adminPerPageSize;
}
