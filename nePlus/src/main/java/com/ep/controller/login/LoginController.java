package com.ep.controller.login;

import com.ep.model.param.LoginParam;
import com.ep.model.entity.User;
import com.ep.service.LoginService;
import com.ep.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Date: 2020/4/7 21:21
 * @Description:
 **/
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private HttpSession httpSession;

    /**
     * 登录跳转
     *
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String loginGet(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        httpSession.removeAttribute("user");
        return "login";
    }

    /**
     * 登录请求
     *
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String loginPost(Model model, LoginParam param) {
        //验证登录
        User user = loginService.checkLogin(param);
        if (user != null) {
            httpSession.setAttribute("user", user);
            model.addAttribute("user", user);
            boolean userType = user.getType().equals("admin");
            httpSession.setAttribute("userType", "admin");
            return "redirect:index";
        } else {
            model.addAttribute("msg", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @PostMapping("/register")
    public String registerPost(User user, Model model) {
        user.setId(UUIDUtils.getUuId());
        user.setType("user");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int count = loginService.registerUser(user);
        if (count > 0) {
            model.addAttribute("msg", "恭喜您，注册成功！");
            model.addAttribute("code", "200");
            return "login";
        }
        return "register";
    }

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String dashboard(Model model) {
        User user = (User) httpSession.getAttribute("user");
        return "index";
    }
}
