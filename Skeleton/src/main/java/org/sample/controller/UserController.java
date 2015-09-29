package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    SampleService sampleService;
    
    private UserDao userDao;
    private TeamDao teamDao;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView displayAllUsers() {
        ModelAndView model = new ModelAndView("users");
        model.addObject("users", sampleService.getAllUsers());
        return model;
    }
    
    @RequestMapping(value = "/userId={id}", method = RequestMethod.GET)
    public ModelAndView displayUser(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("profile");
        if (id != null) {
            User user = sampleService.getUserById(id);
            Team team = user.getTeam();
            if (user != null) {
                model.addObject("user", user);
            }
            if (team != null) {
                model.addObject("team", team);
            }
        }
        else {
            model.addObject("signupForm", new SignupForm());
        }
        return model;
    }
}
