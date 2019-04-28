package com.avatar.springboot.app.models.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avatar.springboot.app.models.entity.Customer;
import com.avatar.springboot.app.models.service.ICustomerService;

@Controller
@RequestMapping("/v1")
public class CustomerController {

	@Autowired
	ICustomerService customerService;



	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getCustomerId(@PathVariable("id") Long idCustomer) {
		List<Customer> customers = new ArrayList<>();

		customers = customerService.getCustomerById(idCustomer);

		if (customers != null && !customers.isEmpty() ) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/cursor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getCursor(@PathVariable("id") Long idCustomer) throws SQLException {
		List<Customer> customers = new ArrayList<>();

		customers = customerService.getProcedureCursor();

		if (customers != null && !customers.isEmpty()) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/prueba/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getPrueba(@PathVariable("id") Long idCustomer) throws SQLException {
		List<Customer> customers = new ArrayList<>();

		customers = customerService.getProcedureCursorById(idCustomer);

		if (customers != null && !customers.isEmpty()) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
	}
	

	


}