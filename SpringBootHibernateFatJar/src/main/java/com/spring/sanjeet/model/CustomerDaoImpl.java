package com.spring.sanjeet.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sanjeet.view.vo.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    @Autowired(required=true)
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(readOnly=false)
    public int save(Customer c) {
        return (Integer)hibernateTemplate.save(c);
    }

    @Override
    public void update(Customer c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int cid) {
        // TODO Auto-generated method stub

    }

    @Override
    public Customer get(int cid) {
        // TODO Auto-generated method stub
        return null;
    }

}
