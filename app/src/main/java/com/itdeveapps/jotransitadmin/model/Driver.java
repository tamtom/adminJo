package com.itdeveapps.jotransitadmin.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Omar Al-Tamimi on 4/5/2017.
 */

public class Driver implements Serializable {
    public static final String HAS_BUSE = "has_bus";
    public static final String ACCEPTED = "accepted";
    public static final String REJECTED = "rejected";
    public static final String PENDING = "pending";

    @SerializedName("driverId")
    private long id;
    private String status;
    private String statusReason;
    private String drvierEmail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }


    public String getDrvierEmail() {
        return drvierEmail;
    }

    public void setDrvierEmail(String drvierEmail) {
        this.drvierEmail = drvierEmail;
    }
}
