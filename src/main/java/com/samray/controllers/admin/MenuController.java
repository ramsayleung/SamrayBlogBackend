package com.samray.controllers.admin;

import com.samray.domains.Permission;
import com.samray.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@RestController
@RequestMapping("admin/menu")
public class MenuController {
    private final long PID=1;//pid 为１,代表是一级菜单
    @Autowired
    private MenuService menuService;
    @RequestMapping(method = {RequestMethod.GET},value = "listMenu")
    public HashMap<String,Object> menuList(){
        HashMap<String,Object> responseBody=new HashMap<>();
        List<Permission> menus=menuService.findFirstLevelMenu(PID);
       responseBody.put("menus",menus);
       return responseBody;
    }
}
