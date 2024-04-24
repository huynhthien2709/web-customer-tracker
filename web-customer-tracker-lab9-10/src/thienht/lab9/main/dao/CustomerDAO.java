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

	// 9.6
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> listCutomer = currentSession.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = listCutomer.getResultList();
		return customers;
	}

	// 10.7
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer); //10.13 save/saveOrUpdate

	}

	// 10.11
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}

}
