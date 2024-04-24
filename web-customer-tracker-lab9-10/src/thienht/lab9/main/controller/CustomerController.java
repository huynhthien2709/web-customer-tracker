package thienht.lab9.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thienht.lab9.main.dao.ICustomerDAO;
import thienht.lab9.main.entity.Customer;
import thienht.lab9.main.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	//9.7
	/*
	 * @Autowired 
	 * private ICustomerDAO customerDAO;
	 */
	
	//9.12
	@Autowired
	private ICustomerService customerService;
	
	//9.7
//	@RequestMapping("/list")
//	@PostMapping("/list") //9.10 not allow
	@GetMapping("list") //9.10 allow
	public String listCustomer(Model model) {
		
//		List<Customer> customers = customerDAO.getCustomer();
		List<Customer> customers = customerService.getCustomer();
		model.addAttribute("customers", customers);
		return "list-customer";
	}
}
