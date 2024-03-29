package com.spring.sanjeet.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sanjeet.services.CustomerService;
import com.spring.sanjeet.view.vo.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController{ //Generally controller class handles HTTP requests
    @Autowired
    private CustomerService custService;
    
    @RequestMapping(value="/registration/form")
    public String registerCustomer(Map<String, Object> m){ //end point
        m.put("customer", new Customer());
        return "NewCustomer"; //logical name which is mapped with WEB-INF/views/NewCustomer.jsp
    }
    
    @RequestMapping(value="/create")
    public String insertCustomer(@Valid Customer customer, Errors errors) throws Exception { //end point 
        if(errors.hasErrors()){ //In case of validation errors
            return "NewCustomer"; //redirected back to request page
        }

        Integer cid = custService.processCustomer(customer);
        customer.setCid(cid);
        
        return "success";
    }
}
