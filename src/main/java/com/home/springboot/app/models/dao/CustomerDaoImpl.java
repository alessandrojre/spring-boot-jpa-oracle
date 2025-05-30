package com.home.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.home.springboot.app.models.entity.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Customer> getCustomerById(Long id) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("getCustomerById");
		query.setParameter("p_customerid", id);
		query.execute();

		Customer customer = new Customer();
		customer.setId(id);
		customer.setName((String) query.getOutputParameterValue("o_name"));
		customer.setEmail((String) query.getOutputParameterValue("o_email"));
		customer.setCreatedDate((Date) query.getOutputParameterValue("o_createdDate"));
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		return customers;
	}

}
