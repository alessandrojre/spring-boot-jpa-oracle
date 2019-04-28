package com.avatar.springboot.app.models.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avatar.springboot.app.models.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


    @Procedure(name = "getProcedureCursor")
    List<ResultSet> fetchCustomer();
    
    @Procedure(name = "getProcedureCursorById")
    List<ResultSet> fetchCustomerById(Long p_cursor_id);
    
}