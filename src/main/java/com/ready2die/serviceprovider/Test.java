package com.ready2die.serviceprovider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by sunghee on 2015. 12. 16..
 */
public class Test {

    private Log logger = LogFactory.getLog(Test.class);

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("MyDriver");
        Connection connection = DriverManager.getConnection();
    }
}
