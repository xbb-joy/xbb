package com.ep.controller.user;

import com.ep.model.entity.User;
import com.ep.service.UserService;
import com.ep.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2020/4/8 15:53
 * @Description:
 **/
@Controller
public class UserController {

    @Resource
    private HttpSession httpSession;

    @Resource
    private UserService userService;

    /**
     * 个人中心编辑页面
     *
     * @param model
     * @return
     */
    @GetMapping("/editUser")
    public String dashboard(Model model) {
        User user = (User) httpSession.getAttribute("user");
        User newUser = userService.selectById(user.getId());
        model.addAttribute("user", newUser);
        return "user/userManage";
    }

    /**
     * 个人中心编辑
     *
     * @param model
     * @param user
     * @param httpSession
     * @return
     */
    @PostMapping("/editUser")
    public String userManagePost(Model model, User user, HttpSession httpSession) {
        User newUser = userService.selectById(user.getId());
        String msg = null;
        Date date = new Date();
        user.setUpdateTime(date);
        user.setType(newUser.getType());
        int update = userService.update(user);
        if (update > 0) {
            msg = "信息修改成功";
            httpSession.setAttribute("user", user);
        } else {
            msg = "信息修改失败";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("user", user);
        return "user/userManage";
    }

    @GetMapping("user/list")
    public String userList(Model model, String nameParam) {
        //查询列表数据
        List<User> userList = userService.userList(nameParam);
        //模糊查询参数
        model.addAttribute("nameParam", nameParam);
        model.addAttribute("userList", userList);
        return "user/userList";
    }

    /**
     * 新增或修改用户页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("user/edit")
    public String userEdit(Model model, String id) {
        User user = new User();
        String add = null;
        if (StringUtils.isNotEmpty(id)) {
            //查询列表数据
            user = userService.selectById(id);
            add = "true";
        }
        //模糊查询参数
        model.addAttribute("user", user);
        model.addAttribute("add", add);
        return "user/userEdit";
    }

    /**
     * 新增或修改用户请求
     *
     * @param model
     * @param user
     * @return
     */
    @PostMapping("user/edit")
    public String userEditOrAnd(Model model, User user) {
        int count = 0;
        //判断新增还是修改
        if (StringUtils.isEmpty(user.getId())) {
            //新增
            //判断用户名不能重复
            int userNum = userService.checkName(user.getUsername());
            if (userNum > 0) {
                model.addAttribute("msg", "用户名不能重复");
                user.setId(null);
                return "user/userEdit";
            }
            user.setId(UUIDUtils.getUuId());
            user.setType("user");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            count = userService.insert(user);
            model.addAttribute("msg", "添加成功");
        } else {
            //修改
            user.setUpdateTime(new Date());
            count = userService.update(user);
            model.addAttribute("msg", "修改成功");
        }
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    /**
     * 删除数据
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("user/delete")
    public String userDelete(Model model, String id) {
        model.addAttribute("msg", "删除成功");
        userService.delete(id);
        return "redirect:/user/list";
    }
}
