package com.spring.sanjeet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sanjeet.model.CustomerDao;
import com.spring.sanjeet.view.vo.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    
    public int processCustomer(Customer c) {
        return customerDao.save(c);
    }
}
