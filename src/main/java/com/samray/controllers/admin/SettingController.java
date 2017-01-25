package com.samray.controllers.admin;

import com.samray.dto.SettingDto;
import com.samray.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/19/17
 */
@RestController
@RequestMapping("admin/setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @RequestMapping(method = RequestMethod.GET,value = "")
    public HashMap<String,Object> listSetting(){
        HashMap<String,Object> reponseBody=settingService.listSetting();
        return reponseBody;
    }
    @RequestMapping(method = RequestMethod.PUT,value = "")
    public HashMap<String,Object> modifySetting(@RequestBody SettingDto settingDto){
        return settingService.modifySetting(settingDto.getBlogName(), settingDto.getBlogSlogan(), settingDto.getAdminPerPageSize(),settingDto.getDisplayPerPageSize());
    }
}
