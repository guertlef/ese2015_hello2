package org.sample.controller;

import org.sample.controller.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.sample.model.Team;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    SampleService sampleService;
        
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

            model.addObject("user", user);

            model.addObject("team", team);
        } else {
            model.addObject("signupForm", new SignupForm());
        }
        return model;
    }
}
