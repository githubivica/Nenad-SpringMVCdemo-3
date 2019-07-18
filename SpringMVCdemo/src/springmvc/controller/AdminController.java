package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Hrana;
import springmvc.model.Pice;
import springmvc.model.User;
import springmvc.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/listOfUsers")
	public String listaUsera(Model model) {
		
		List<User> listaUsera = adminService.vratiSveUsere();
		model.addAttribute("listaUsera", listaUsera);
		return "admin";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect: ../index.jsp";
	}
	
	@RequestMapping("/editUser")
	public String showFormForEdit(@RequestParam("idUser")String idUser, Model model) {
		User user = new User();
		user = adminService.vratiUseraPoId(Long.parseLong(idUser));
		model.addAttribute("editThisUser", user);
		return "editUser";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@ModelAttribute("editThisUser")User user) {
		adminService.updateUser(user);
		return "redirect: listOfUsers";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@ModelAttribute("editThisUser")User user){
		adminService.deleteUser(user);
		return "redirect: listOfUsers";
	}
	
	@PostMapping("/addBalance")
	public String addBalance(@ModelAttribute("editThisUser") User user, @RequestParam("balanceAdd") String balanceAdd) {
		adminService.addBalance(user, balanceAdd);
		return "redirect: listOfUsers";
	}
	
	@RequestMapping("/pice-list")
	public String listaPica(Model model) {
		List<Pice> listaPica = adminService.vratiSvoPice();
		model.addAttribute("listaPica",listaPica);
		return "lista-pica";
	}
	
	@RequestMapping("/dodajPice")
	public String dodajPice(Model model) {
		model.addAttribute("pice", new Pice());
		return "dodaj-pice";
	}
	
	@GetMapping("/dodajPiceUBazu")
	public String dodajPiceUBazu(@ModelAttribute("pice")Pice pice) {
		adminService.dodajPiceUBazu(pice);
		return "redirect: pice-list";
	}
	
	@RequestMapping("/editPice")
	public String editPice(@RequestParam("idPice")String idPice, Model model) {	
		Pice pice = adminService.editPice(idPice);
		model.addAttribute("piceIzBaze",pice);
		return "edit-pice";
	}
	
	@GetMapping("/uradiUpdatePica")
	public String updatePice(@ModelAttribute("piceIzBaze")Pice pice) {
		adminService.updatePice(pice);
		return "redirect: pice-list";
	}
	
	@PostMapping("/deletePice")
	public String deletePice(@ModelAttribute("piceIzBaze")Pice pice) {
		adminService.deletePice(pice);
		return "redirect: pice-list";
	}
	
	@RequestMapping("/hrana-list")
	public String listaHrane(Model model) {
		List<Hrana> listaHrane = adminService.vratiSvuHranu();
		model.addAttribute("listaHrane", listaHrane);
		return "lista-hrane";
	}
	
	@RequestMapping("/dodajHranu")
	public String dodajHranu(Model model) {
		model.addAttribute("hrana", new Hrana());
		return "dodaj-hranu";
	}
	
	@GetMapping("/dodajHranuUBazu")
	public String dodajHranuUBazu(@ModelAttribute("hrana") Hrana hrana) {
		adminService.dodajHranuUBazu(hrana);
		return "redirect: hrana-list";
	}
	
	@RequestMapping("/editHrana")
	public String editHrana(Model model, @RequestParam("idHrana") String idHrana) {
		Hrana hrana = adminService.vratiHranuPoId(idHrana);
		model.addAttribute("hranaIzBaze", hrana);
		return "edit-hrana";
		
	}
	
	@GetMapping("/uradiUpdateHrane")
	public String updateHrana(@ModelAttribute("hranaIzBaze") Hrana hrana) {
		adminService.updateHrana(hrana);
		return "redirect: hrana-list ";
	}
	
	@PostMapping("/deleteHrana")
	public String deleteHrana(@ModelAttribute("hranaIzBaze")Hrana hrana) {
		adminService.deleteHrana(hrana);
		return "redirect: hrana-list";
	}
	
	
	

}
