package info.devfiles.community.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import info.devfiles.community.entities.Profile;
import info.devfiles.community.repositories.CustomUserRepository;
import info.devfiles.community.web.forms.SignUpForm;
import info.devfiles.community.web.forms.SignUpFormValidator;
import info.devfiles.passport.tools.UserManager;

@Controller
public class MembersController {

	private CustomUserRepository userRepository;
	
	private UserManager UserManager;
	
	private SignUpFormValidator signUpFormValidator;
	
	@RequestMapping("/members")
	public String index(Model model) {
		model.addAttribute("profiles", getUserRepository().findAll());
		return "members/index";
	}
	
	@RequestMapping("/members/signup")
	public String signUp(HttpServletRequest request, HttpServletResponse response, 
			Model model, SignUpForm signUpForm, BindingResult result) {
		if (HttpMethod.POST.toString().equalsIgnoreCase(request.getMethod())) {
			getSignUpFormValidator().validate(signUpForm, result);
			if (!result.hasErrors()) {
				Profile profile = new Profile(signUpForm.getEmail(), signUpForm.getPassword());
				profile.setFirstName(signUpForm.getFirstName());
				profile.setLastName(signUpForm.getLastName());
				profile.setNickname(signUpForm.getNickname());
				getUserManager().registerUser(profile);
				return "members/myaccount";
			}
		}
		return "members/signup";
	}

	public CustomUserRepository getUserRepository() {
		return userRepository;
	}

	@Resource(name="userRepository")
	public void setUserRepository(CustomUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserManager getUserManager() {
		return UserManager;
	}

	@Autowired
	public void setUserManager(UserManager userManager) {
		UserManager = userManager;
	}

	public SignUpFormValidator getSignUpFormValidator() {
		return signUpFormValidator;
	}

	@Autowired
	public void setSignUpFormValidator(SignUpFormValidator signUpFormValidator) {
		this.signUpFormValidator = signUpFormValidator;
	}
	
}
