package com.samray.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/10/17
 */
@Service
public class RedisService {
    private final static Logger LOGGER= LoggerFactory.getLogger(RedisService.class);
    private String blogName = "Smaray's Blog";
    private String blogSlogan = "Samray is mumbling";
    private int adminPerPageSize = 10;//后台每页的展示数据
    private int displayPerPageSize=5;//前端每页展示数据
    public static final String BLOG_NAME = "blog_name";
    public static final String BLOG_SLAGON = "blog_slogan";
    public static final String DISPLAY_PER_PAGE_SIZE = "display_per_page_size";
    public static final String ADMIN_PER_PAGE_SIZE="admin_per_page_size";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    public String getBlogName() {
        LOGGER.info("get blog name");
        if (stringRedisTemplate.opsForValue().get(BLOG_NAME)==null){
            setBlogName(blogName);
            return blogName;
        }else{
            return stringRedisTemplate.opsForValue().get(BLOG_NAME);
        }
    }

    public void setBlogName(String blogName) {
        LOGGER.info("set blog name:"+blogName);
        stringRedisTemplate.opsForValue().set(BLOG_NAME,blogName);
    }

    public String getBlogSlogan() {
        LOGGER.info("get blog'slogan");
        if (stringRedisTemplate.opsForValue().get(BLOG_SLAGON)==null){
            setBlogSlogan(blogSlogan);
            return blogSlogan;
        }else {
            return stringRedisTemplate.opsForValue().get(BLOG_SLAGON);
        }
    }

    public void setBlogSlogan(String blogSlogan) {
        LOGGER.info("set blog slogan");
       stringRedisTemplate.opsForValue().set(BLOG_SLAGON,blogSlogan);
    }

    public int getAdminPerPageSize() {
        LOGGER.info("get admin per pageSize");
        if (redisTemplate.opsForValue().get(ADMIN_PER_PAGE_SIZE)==null){
            setAdminPerPageSize(adminPerPageSize);
            return adminPerPageSize;
        }else{
            return (int)redisTemplate.opsForValue().get(ADMIN_PER_PAGE_SIZE);
        }
    }

    public void setAdminPerPageSize(int adminPerPageSize) {
        LOGGER.info("set admin per pagesize:"+adminPerPageSize);
        redisTemplate.opsForValue().set(ADMIN_PER_PAGE_SIZE, adminPerPageSize);
    }
    public int getDisplayPerPageSize(){
        LOGGER.info("get display per page size");
        if(redisTemplate.opsForValue().get(DISPLAY_PER_PAGE_SIZE)==null){
            setDisplayPerPageSize(displayPerPageSize);
            return displayPerPageSize;
        }else{
            return (int)redisTemplate.opsForValue().get(DISPLAY_PER_PAGE_SIZE);
        }
    }
    public void setDisplayPerPageSize(int displayPerPageSize){
        LOGGER.info("set display per page:"+displayPerPageSize);
        redisTemplate.opsForValue().set(DISPLAY_PER_PAGE_SIZE,displayPerPageSize);
    }

}
