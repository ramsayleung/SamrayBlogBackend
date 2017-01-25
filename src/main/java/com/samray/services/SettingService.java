package com.samray.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/19/17
 */
@Service
public class SettingService {
    private static final Logger LOGGER= LoggerFactory.getLogger(SettingService.class);
    @Autowired
    private RedisService redisService;
    public HashMap<String,Object> listSetting(){
        HashMap<String,Object> responseBody=new HashMap<>();
        responseBody.put("blog_name",redisService.getBlogName());
        responseBody.put("blog_slogan",redisService.getBlogSlogan());
        responseBody.put("admin_per_page_size",redisService.getAdminPerPageSize());
        responseBody.put("display_per_page_size",redisService.getDisplayPerPageSize());
        return responseBody;
    }
    public HashMap<String,Object>  modifySetting(String blogName,String blogSlogan,int adminPerPageSize,int displayPerPageSize ){
        HashMap<String,Object> responseBody=new HashMap<>();
        redisService.setDisplayPerPageSize(displayPerPageSize);
        redisService.setAdminPerPageSize(adminPerPageSize);
        redisService.setBlogName(blogName);
        redisService.setBlogSlogan(blogSlogan);
        responseBody.put("status","success");
//        }catch (Exception e){
//            LOGGER.error("modify SettingDto error");
//            responseBody.put("status","failure");
//        }
        return responseBody;
    }
}
