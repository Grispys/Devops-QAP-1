package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void getPasswordTest() {
        Account user1 = new Account("Test1", "Test1");
        String result = user1.getPassword();

        Assertions.assertEquals("Test1", result);
    }

    @Test
    void depositTest() {
        Account user1 = new Account("Test1", "Test1");
        user1.depositAdd(100.00);

        double result = user1.getBalance();
        Assertions.assertEquals(100.00, result);
    }

    @Test
    void withdrawalTest() {
        Account user1 = new Account("Test1", "Test1");
        boolean result = user1.withdrawalAdd(300.00);

        assertFalse(result);
    }
}