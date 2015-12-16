package com.ready2die.serviceprovider;

import org.apache.commons.logging.LogFactory;



/**
 * Created by sunghee on 2015. 12. 16..
 */
public class MyDriver implements Driver {
    private org.apache.commons.logging.Log looger = LogFactory.getLog(MyDriver.class);


    private static Driver defaultDriver;

    static {
        defaultDriver = new MyDriver();
        DriverManager.registerDefaultPrivider(defaultDriver);

    }

    @Override
    public Connection getConnection() {
        System.out.printf("MyDriver's Connection return");
        return null;
    }
}
