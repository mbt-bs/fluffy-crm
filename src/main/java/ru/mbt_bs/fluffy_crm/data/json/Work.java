package ru.mbt_bs.fluffy_crm.data.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Work {
    private Long id;
    private CustomerLink customer;
    private Service service;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerLink getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerLink customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
