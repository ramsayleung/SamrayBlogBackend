package com.samray.controllers.admin;

import com.samray.domains.Tag;
import com.samray.services.PaginationService;
import com.samray.services.RedisService;
import com.samray.services.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@RestController
@RequestMapping("admin/tag")
public class TagController {
    public final static Logger LOGGER= LoggerFactory.getLogger(TagController.class);
    @Autowired
    private PaginationService paginationService;
    @Autowired
    private TagService tagService;
    @Autowired
    private RedisService redisService;
    @RequestMapping(method = RequestMethod.GET,value = "")
    public HashMap<String,Object> listTags(@RequestParam(defaultValue = "1") int pageNum, HttpServletRequest request){
        pageNum=pageNum<1?0:pageNum-1;
        String path=request.getRequestURL().toString();
        Page<Tag> tags=tagService.findAllTag(pageNum,redisService.getAdminPerPageSize());
        HashMap<String,Object> responseBody=paginationService.getResponseBody(tags.getContent(),pageNum,redisService.getAdminPerPageSize(),tags.getTotalElements(),path);
        return  responseBody;
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "{id:[0-9]+}")
    public HashMap<String,String> deleteTag(@PathVariable("id") int id){
        LOGGER.info("id:"+id);
        HashMap<String,String> responseBody=new HashMap<>();
        try {
            tagService.deleteById(id);
            responseBody.put("status","success");
        }catch (Exception e){
        LOGGER.warn("delete tag by id fail");
        responseBody.put("status","failure");
        }
        return responseBody;
    }
}
