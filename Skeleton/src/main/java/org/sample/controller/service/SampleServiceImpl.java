package org.sample.controller.service;

import java.util.Date;
import org.sample.controller.exceptions.InvalidTeamException;
import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.controller.pojos.TeamForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired    TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        user.setTeam(teamDao.findOne(signupForm.getTeam()));
        
        user = userDao.save(user);   // save object to DB
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
    
    @Transactional
    public TeamForm saveFrom(TeamForm teamForm) throws InvalidTeamException {
        Team team = new Team();
        
        if (teamForm.getTeamName().isEmpty()) {
            throw new InvalidTeamException("Please enter a team name.");
        }

        team.setTeamName(teamForm.getTeamName());
        team.setDate(new Date());
        
        team = teamDao.save(team);
        
        teamForm.setId(team.getId());
        return teamForm;
    }

    public Iterable<Team> getSelectableTeams() {
        return teamDao.findAll();
    }

    
    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }
    
    public User getUserById(Long id) {
        return userDao.findOne(id);
    }

}
