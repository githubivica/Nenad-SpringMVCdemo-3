package springmvc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Admin;
import springmvc.model.Role;
import springmvc.model.User;
import springmvc.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/registracionaForma")
	public String prikaziRegistracionuFormu(Model model) {
		User user = new User();
		model.addAttribute("automatskiUser", user);
		return "registracija";
	}
	
	@RequestMapping("/procesuiranjeRegistracije")
	public String procesuirajRegistraciju(@ModelAttribute("automatskiUser")@Valid User user, BindingResult bindingResult, @RequestParam("repeatPassword")String repeatPassword) {
			
		if(bindingResult.hasErrors()) {
			return "registracija";
		}else {
			if(user.getPassword().equals(repeatPassword)) {
				boolean daLiPostojiUserUbazi = userService.daLiPostojiUser(user.getUserName());
					if(!(daLiPostojiUserUbazi)) {
						if(user.getUserName().equals(Admin.getAdminusername()) && 
								user.getPassword().equals(Admin.getAdminpassword())) {
							user.setRole(Role.ADMIN);
						}else {
							user.setRole(Role.KORISNIK);
						}
						userService.saveUser(user);
						return "redirect: ../index.jsp ";
					}else {
						return "redirect: registracionaForma";
					}
			}else {
				return "redirect: registracionaForma";
			}
		
		}
	}
		
	
	@RequestMapping("/loginForma")
	public String prikaziLoginFormu(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/procesuiranjeLogin")
	public String procesuirajLogin(@Valid @ModelAttribute("user")User user, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "login";
		}else {
			boolean daLiPostojiUserUbazi = userService.daLiPostojiUser(user.getUserName());
			if(daLiPostojiUserUbazi) {
				boolean uporediPassword = userService.daLiPasswordOdgovaraUseru(user);
					if(uporediPassword) {
						User userIzBaze = userService.vratiUseraPoUserName(user.getUserName());
							request.getSession().setAttribute("userIzBaze",userIzBaze);
							if(userIzBaze.getRole().equals(Role.ADMIN)) {
								return "redirect: ../admin/listOfUsers";
							}else {
								return "redirect: ../korisnik/korisnikPage";
							}
					}else {
						return "loginError";
					}
			}else {
				return "loginError";
			}
		}
		
	}
	

	
	
	
	
	
	
	
}
