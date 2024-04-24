package thienht.lab9.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thienht.lab9.main.dao.ICustomerDAO;
import thienht.lab9.main.entity.Customer;
import thienht.lab9.main.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// 9.7
	/*
	 * @Autowired private ICustomerDAO customerDAO;
	 */

	// 9.12
	@Autowired
	private ICustomerService customerService;

	// 9.7
//	@RequestMapping("/list")
//	@PostMapping("/list") //9.10 not allow
	@GetMapping("list") // 9.10 allow
	public String listCustomer(Model model) {

//		List<Customer> customers = customerDAO.getCustomer();
		List<Customer> customers = customerService.getCustomer();
		model.addAttribute("customers", customers);
		return "list-customer";
	}

	// 10.2
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// 10.3
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	// 10.6
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	// 10.10
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	// 10.17
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
