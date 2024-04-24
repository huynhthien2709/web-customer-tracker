package thienht.lab9.main.service;

import java.util.List;

import thienht.lab9.main.entity.Customer;

public interface ICustomerService {
	// 9.11
	public List<Customer> getCustomer();
	
	//10.6
	public void saveCustomer(Customer customer);
	
	//10.11
	public Customer getCustomer(int id);
}
