package com.spring.sanjeet.model;

import com.spring.sanjeet.view.vo.Customer;

public interface CustomerDao {

    public int save(Customer c);

    public void update(Customer c);

    public void delete(int cid);

    public Customer get(int cid);
}
