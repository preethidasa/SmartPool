package com.tw.smartpool.controller;

import com.tw.smartpool.model.User;
import com.tw.smartpool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    private HomeController() {
    }

    public HomeController(UserService userService) {//for test
        this.userService = userService;
    }

    @RequestMapping(value="/")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUser(HttpServletResponse response,@ModelAttribute("name") String name) throws IOException{
        List<User> users = userService.getUserListByName(name);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("emp_id") String empId,@ModelAttribute("first_name") String firstName,@ModelAttribute("last_name") String lastName, @ModelAttribute("location") String location){
        if(userService.addUser(empId,firstName,lastName,location))
            return new ModelAndView("success");
        return new ModelAndView("error");
    }
}
