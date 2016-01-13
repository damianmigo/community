package info.devfiles.community.web.forms;

import javax.annotation.Resource;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import info.devfiles.community.entities.Profile;
import info.devfiles.community.repositories.CustomUserRepository;

@Service
public class SignUpFormValidator implements Validator {

	private CustomUserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpFormValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "SignUpForm.firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "SignUpForm.lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "SignUpForm.email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "SignUpForm.password.required");
		
		if (!errors.hasErrors()) {
			SignUpForm signUpForm = (SignUpForm) target;
			
			Profile profile = getUserRepository().findByEmail(signUpForm.getEmail());
			if (profile != null) {
				errors.rejectValue("email", "SignUpForm.email.alreadyExists");
			}
			
			profile = getUserRepository().findByNickname(signUpForm.getNickname());
			if (profile != null) {
				errors.rejectValue("nickname", "SignUpForm.nickname.alreadyTaken");
			}
			
			try {
				new InternetAddress(signUpForm.getEmail());
			} catch (AddressException ae) {
				errors.rejectValue("email", "SignUpForm.email.invalid");
			}
			
		}
	}

	public CustomUserRepository getUserRepository() {
		return userRepository;
	}

	@Resource(name="userRepository")
	public void setUserRepository(CustomUserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
