package games.seac.controller;

import games.seac.domain.Account;
import games.seac.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/15 - 11:08
 */
@Controller
@RequestMapping(value = "/account",produces = "text/html;charset=UTF-8")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }


    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }

}
