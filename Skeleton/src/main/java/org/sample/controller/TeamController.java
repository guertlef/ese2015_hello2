package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.pojos.TeamForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeamController {
    @Autowired
    SampleService sampleService;
    
    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public ModelAndView team() {
        ModelAndView model = new ModelAndView("new-team");
        model.addObject("teamForm", new TeamForm());
        return model;
    }
    
    @RequestMapping(value = "/createTeam", method = RequestMethod.POST)
    public ModelAndView createTeam(@Valid TeamForm teamForm, BindingResult result, RedirectAttributes redirectAttributes) {
        ModelAndView model;
        if (!result.hasErrors()) {
            try {
                sampleService.saveFrom(teamForm);
                model = new ModelAndView("show");
            } catch (InvalidTeamException e) {
                model = new ModelAndView("new-team");
                model.addObject("page_error", e.getMessage());
            }
        } else {
            model = new ModelAndView("team");
        }
        return model;
    }
    
}
