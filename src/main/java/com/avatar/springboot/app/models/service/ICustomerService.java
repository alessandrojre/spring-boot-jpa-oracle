package com.avatar.springboot.app.models.service;

import java.sql.SQLException;
import java.util.List;

import com.avatar.springboot.app.models.entity.Customer;

public interface ICustomerService {

	public List<Customer> getCustomerById(Long id);

	public List<Customer> getProcedureCursor() throws SQLException;
	
	public List<Customer> getProcedureCursorById(Long p_cursor_id) throws SQLException;
}
