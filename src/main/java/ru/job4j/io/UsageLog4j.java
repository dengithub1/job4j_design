package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 8;
        LOG.debug("Age is {} years old", age);

        byte smallNumber = 12;
        LOG.debug("File is {} byte", smallNumber);

        short weight = 44;
        LOG.debug("Weight is {} kg", weight);

        long id = 5345234L;
        LOG.debug("User id : {}", id);

        float pi = 3.14f;
        LOG.debug("Value of  is : {}", pi);

        double balance = 10.4;
        LOG.debug("Account balance is {} USD", balance);

        boolean isActive = true;
        LOG.debug("Parameter is active: {}", isActive);

        char symbol = 'F';
        LOG.debug("Symbol is {}", symbol);
    }
}