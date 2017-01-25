package com.samray.services;

import com.samray.domains.Permission;
import com.samray.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Permission> findFirstLevelMenu(long pid){
       return  menuRepository.findByPid(pid);
    }
}
