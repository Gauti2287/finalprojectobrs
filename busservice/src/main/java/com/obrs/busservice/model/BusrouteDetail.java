package com.obrs.busservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busroutedetails")
public class BusrouteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "busno")
    private Integer busno;

    @Column(name = "busname", length = 50)
    private String busname;

    @Column(name = "bustype", length = 50)
    private String bustype;

    @Column(name = "source", length = 50)
    private String source;

    @Column(name = "destination", length = 50)
    private String destination;

    @Column(name = "price")
    private Integer price;

    public Integer getBusno() {
        return busno;
    }

    public void setBusno(Integer busno) {
        this.busno = busno;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}