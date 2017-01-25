package com.samray.services;

import com.samray.domains.Post;
import com.samray.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/10/17
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepositories;
    public Page<Post> findAllPostByEnable(int pageNum,int pageSize){
        return postRepositories.findByEnable(true,
                new PageRequest(pageNum,pageSize, Sort.Direction.DESC,"createAt"));
    }
    public List<Post> findAllByEnable(int pageNum,int pageSize){
        return postRepositories.findByEnable(true);
    }
}
