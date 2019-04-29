package com.home.springboot.app.models.dao;

import java.util.List;

import com.home.springboot.app.models.entity.Customer;

public interface ICustomerDao {

	public List<Customer> getCustomerById(Long id);

}
