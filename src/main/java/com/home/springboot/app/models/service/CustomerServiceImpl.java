package com.home.springboot.app.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.springboot.app.models.dao.CustomerRepository;
import com.home.springboot.app.models.dao.ICustomerDao;
import com.home.springboot.app.models.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private CustomerRepository custRepo;

	@Transactional
	@Override
	public List<Customer> getCustomerById(Long id) {
		return customerDao.getCustomerById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> getProcedureCursor() throws SQLException {
		List<ResultSet> rscustomers = custRepo.fetchCustomer();

		List<Customer> customers = new ArrayList<Customer>();

		for (int i = 0; i < rscustomers.size(); i++) {
			ResultSet rs = rscustomers.get(i);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setCreatedDate(rs.getDate("created_date"));
				customers.add(customer);
			}
		}
		return customers;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> getProcedureCursorById(Long p_cursor_id) throws SQLException {
		List<ResultSet> rscustomers = custRepo.fetchCustomerById(p_cursor_id);
		List<Customer> customers = new ArrayList<Customer>();

		for (int i = 0; i < rscustomers.size(); i++) {
			ResultSet rs = rscustomers.get(i);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setCreatedDate(rs.getDate("created_date"));
				customers.add(customer);
			}
		}
		return customers;
	}

}
