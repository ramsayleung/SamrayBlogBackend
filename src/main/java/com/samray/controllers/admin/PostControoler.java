package com.samray.controllers.admin;

import com.samray.domains.Post;
import com.samray.services.PaginationService;
import com.samray.services.PostService;
import com.samray.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/9/17
 */
@RestController
@RequestMapping("admin/post")
public class PostControoler {
    @Autowired
    private PostService postService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private PaginationService paginationService;
    @RequestMapping(method = RequestMethod.GET,value = "")
    public HashMap<String, Object> index(@RequestParam(defaultValue = "0") int pageNum,HttpServletRequest request) {
        String path=request.getRequestURL().toString();
        pageNum = pageNum < 1 ? 0 : pageNum - 1;
        Page<Post> posts=postService.findAllPostByEnable(pageNum,redisService.getAdminPerPageSize());
        HashMap<String,Object> responseBody=paginationService.getResponseBody(posts.getContent(),
                pageNum,redisService.getAdminPerPageSize(),posts.getTotalElements(),path);
        return responseBody;
    }

    @RequestMapping(method = RequestMethod.POST,value = "")
    public HashMap<String,Object> addPost(){
       HashMap<String,Object>  responseBody=new HashMap<>();
       return responseBody;
       //pass
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "")
    public HashMap<String,Object> deletePost(@RequestParam int postId){
        HashMap<String,Object>  responseBody=new HashMap<>();
        return responseBody;
        //pass
    }
    @RequestMapping(method = RequestMethod.PUT,value = "")
    public HashMap<String,Object> modifyPost(){
        HashMap<String,Object>  responseBody=new HashMap<>();
        return responseBody;
        //pass
    }
}
