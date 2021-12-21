package games.seac.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import games.seac.domain.User;
import games.seac.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Honmono
 * @date 2021/11/19 - 11:37
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串方法
     * 返回值自动拼接进转发路径
     * 默认为转发
     * @return
     */
    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running...");
        //return "redirect:/jsp/success.jsp";
        //return "forward:/jsp/success.jsp";
        return "success";
    }

    /**
     * 返回ModelAndView方法
     * 获取方法：new
     * @return
     */
    @RequestMapping("/quick2")
    public ModelAndView save2(){

        ModelAndView modelAndView = new ModelAndView();
        /*
            Model：模型 封装数据
            View：视图 展示数据
         */
        //设置模型数据
        modelAndView.addObject("username","honmono");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 返回ModelAndView方法
     * 获取方法：传形式参数，前端控制器注入
     * @param modelAndView
     * @return
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){

        //设置模型数据
        modelAndView.addObject("username","chihonmono");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 返回字符串方法
     * 返回值自动拼接进转发路径
     * 传递一个Model
     * @param model
     * @return
     */
    @RequestMapping("/quick4")
    public String save4(Model model){

        model.addAttribute("username","本物");
        return "success";
    }

    /**
     * 获取request对象，将数据存入request域
     * @param request
     * @return
     */
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){

        request.setAttribute("username","honmono");
        return "success";
    }

    /**
     * 通过response对象回写
     * @param response
     * @throws IOException
     */
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {

        response.getWriter().println("hello seac");
    }


    @RequestMapping("/quick7")
    @ResponseBody //该注解告知Spring不进行视图跳转，直接回写return的数据
    public String save7() {
        return "hello seac";
    }

    /**
     * 返回json格式字符串
     * @return
     */
    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    /**
     * 使用json转换工具返回json字符串
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {

        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json转换工具转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    /**
     * SpringMVC自动将user转换成json格式字符串
     * 需要在spring-mvc.xml中配置配置处理器映射器
     * @return
     */
    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);

        return user;

    }

    /*
        ===获得请求参数===
     */

    /**
     * 业务方法参数与请求参数的name一致，参数值自动映射匹配
     * @param username
     * @param age
     */
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age) {
        System.out.println(username);
        System.out.println(age);

    }

    /**
     * 业务方法的pojo参数属性名与请求参数的name一致，参数值自动映射匹配
     * @param user
     */
    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);

    }

    /**
     * 业务方法名称与请求参数的name一致，参数会自动映射匹配
     * @param strs
     */
    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    /**
     * 获取集合参数时，要将集合参数包装到一个pojo中才可以
     * @param vo 内容是user的list
     */
    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    /**
     * ajax直接提交list参数
     * @param userList
     */
    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    /**
     * @RequestParam 该注解表示将前端传递的name参数映射到方法中的username变量上
     *               参数：
     *               value:请求参数名称
     *               required:在此指定的请求参数是否必须包括，默认为true，提交时无此参数则报错
     *               defaultValue:没有指定请求参数时使用的默认值
     * @param username
     */
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "honmono") String username) {
        System.out.println(username);
    }

    /**
     * restful风格的数据获取
     * 请求方式：
     * GET 获取资源
     * POST 新建资源
     * PUT 更新资源
     * DELETE 删除资源
     *
     * localhost/user/quick17/zhangsan
     * @PathVariable 该注解用于绑定占位符
     * @param username
     */
    @RequestMapping(value = "/quick17/{username}",method = RequestMethod.GET)
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) {
        System.out.println(username);
    }

    /**
     * 自定义日期转换器 p71
     * @param date
     */
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    /**
     * SpringMVC获取http对象
     * @param request
     * @param response
     * @param session
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    /**
     * SpringMVC获取请求头信息
     * @RequestHeader 获取请求头信息
     * @param user_agent
     */
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent") String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    /**
     * 单文件上传
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);

        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("G:\\ProgramFiles\\idea\\workspace\\upload\\"+originalFilename));

    }

    /**
     * 多文件上传
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);

        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("G:\\ProgramFiles\\idea\\workspace\\upload\\"+originalFilename));
        }


    }



}
