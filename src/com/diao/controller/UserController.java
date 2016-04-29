package com.diao.controller;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diao.model.User;
import com.diao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/save")
    public ModelAndView saveUser(User user) {

        ModelAndView mav = new ModelAndView("/user/index");
        logger.info("save:" + user);
        System.out.println(user);
        userService.saveUser(user);

        return mav;
    }

    @RequestMapping("/find")
    public ModelAndView findUser(User user) {

        ModelAndView mav = new ModelAndView("/user/index");
        User u = userService.findUserByName(user.getName());
        logger.info("find:" + u);
        System.out.println(u);
        Map<String, User> map=new HashMap<String, User>();
        map.put("user", u);
        mav.addAllObjects(map);
        return mav;
    }
}
