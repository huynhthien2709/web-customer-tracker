package thienht.lab9.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import thienht.lab9.main.entity.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//9.6
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> listCutomer = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = listCutomer.getResultList(); 
		return customers;
	}

}
