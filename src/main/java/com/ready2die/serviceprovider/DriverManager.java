package com.ready2die.serviceprovider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sunghee on 2015. 12. 16..
 */
public class DriverManager {

    private DriverManager() {}

    private static final Map<String, Driver> drivers = new ConcurrentHashMap<String, Driver>();
    public static final String DEFAULT_DRIVER_NAME = "default";

    public static void registerDefaultPrivider(Driver driver) {
        System.out.printf("Driver register");
        registerDriver(DEFAULT_DRIVER_NAME, driver);
    }

    private static void registerDriver(String name, Driver driver) {
        drivers.put(name, driver);
    }

    public static Connection getConnection() {
        return getConnection(DEFAULT_DRIVER_NAME);
    }

    public static Connection getConnection(String name) {
        Driver driver = drivers.get(name);
        if (driver == null) {
            throw new IllegalArgumentException();
        }
        return driver.getConnection();
    }
}
