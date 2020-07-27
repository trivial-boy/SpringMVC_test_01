package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行testString");
        User user = new User();
        user.setAge(12);
        user.setUsername("ddf");
        user.setPassword("123");
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/testVoid")
    public String testVoid(HttpServletResponse response, HttpServletRequest request){
        System.out.println("执行testString");

        return "success";
    }
    @RequestMapping("/testExption")
    public String testException() throws SysException{
        System.out.println("testException 执行了");
        try{
            //模拟异常
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException ("查询所有用户出现了错误");
        }
        return "successs";
    }
}
