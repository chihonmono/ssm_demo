package games.seac.controller;

import games.seac.domain.Role;
import games.seac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author Honmono
 * @date 2021/11/22 - 11:44
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }*/

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }

}
