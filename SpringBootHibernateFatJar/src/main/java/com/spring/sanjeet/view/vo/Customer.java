package com.spring.sanjeet.view.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

    private int cid;

    @Size(min = 3, max = 20, message = "Customer name must be  between 3 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Customer Name must be Alphabetic")
    private String cname;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "Invalid Email Format")
    private String emailId;

    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10-digits numeric number")
    private String mobile;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
