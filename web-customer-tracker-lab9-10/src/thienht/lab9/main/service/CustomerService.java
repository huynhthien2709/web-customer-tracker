package thienht.lab9.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thienht.lab9.main.dao.ICustomerDAO;
import thienht.lab9.main.entity.Customer;


//lab 9.11
@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		List<Customer> customers = customerDAO.getCustomer();
		return customers;
	}

}
