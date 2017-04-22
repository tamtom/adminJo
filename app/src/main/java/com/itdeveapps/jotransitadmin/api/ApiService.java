package com.itdeveapps.jotransitadmin.api;

import com.itdeveapps.jotransitadmin.model.Driver;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Omar Al-Tamimi on 3/3/2017.
 */

public interface ApiService {
    @POST("/driverLogin")
    Observable<Driver> login(@Query("driverEmail") String email
            , @Query("driverPassword") String password);

    @GET("/getDriver")
    Observable<ArrayList<Driver>> getDrivers();

}
