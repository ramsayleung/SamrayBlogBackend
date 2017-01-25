package com.samray.services;

import com.samray.domains.Tag;
import com.samray.repositories.TagRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@Service
public class TagService {
    @Autowired
    private TagRepositories tagRepositories;
    public Page<Tag> findAllTag(int pageNum, int pageSize){
        return  tagRepositories.findAll(new PageRequest(pageNum,pageSize, Sort.Direction.DESC,"createAt"));
    }
    public void  deleteById(long id){
         tagRepositories.delete(id);
    }
}
