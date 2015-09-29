package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamForm;
import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    SampleService sampleService;
    
     @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView specificUser(@RequestParam("userId") Long id) {
    	
    	ModelAndView model;
        User user = sampleService.getUserById(id);
        if (user != null) {
            model = new ModelAndView("profile");
            model.addObject("user", user);
        } else {
            model = new ModelAndView("nosuchuser");
        }
        return model;
    }
}
