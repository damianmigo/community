package info.devfiles.community.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.devfiles.community.entities.Profile;
import info.devfiles.community.web.forms.SignUpForm;
import info.devfiles.passport.tools.UserManager;

@Controller
public class MembersController {

	private MongoRepository<Profile, String> userRepository;
	
	private UserManager UserManager;
	
	@RequestMapping("/members")
	public String index(Model model) {
		model.addAttribute("profiles", getUserRepository().findAll());
		return "members/index";
	}
	
	@RequestMapping("/members/signup")
	public String signUp(Model model, SignUpForm signUpForm, HttpServletRequest request) {
		if (HttpMethod.POST.toString().equalsIgnoreCase(request.getMethod())) {
			Profile profile = new Profile(signUpForm.getEmail(), signUpForm.getPassword());
			profile.setFirstName(signUpForm.getFirstName());
			profile.setLastName(signUpForm.getLastName());
			profile.setNickname(signUpForm.getNickname());
			getUserManager().registerUser(profile);
			return "members/signUp";
		} else {
			return "members/signUp";
		}
	}

	public MongoRepository<Profile, String> getUserRepository() {
		return userRepository;
	}

	@Resource(name="userRepository")
	public void setUserRepository(MongoRepository<Profile, String> userRepository) {
		this.userRepository = userRepository;
	}

	public UserManager getUserManager() {
		return UserManager;
	}

	@Autowired
	public void setUserManager(UserManager userManager) {
		UserManager = userManager;
	}
	
}
