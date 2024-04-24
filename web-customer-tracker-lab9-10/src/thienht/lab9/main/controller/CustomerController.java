package thienht.lab9.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thienht.lab9.main.dao.ICustomerDAO;
import thienht.lab9.main.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	//9.7
	@Autowired
	private ICustomerDAO customerDAO;
	
	//9.7
//	@RequestMapping("/list")
	@GetMapping("/list") //9.10
	public String listCustomer(Model model) {
		
		List<Customer> customers = customerDAO.getCustomer();
		model.addAttribute("customers", customers);
		return "list-customer";
	}
}
