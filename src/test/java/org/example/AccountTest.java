package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
// i couldn't figure out how to test a method that has no argument and also didn't return anything
// so i found this guy on youtube called "Random Code" who has tutorials and this was how it was shown to
// test scanners by using byteinputstream
class AccountTest {
    @Test
    void getPasswordTest(){
        Account user1 = new Account("Test1", "Test1");
        String result = user1.getPassword();

        Assertions.assertEquals("Test1", result);
    }

    @Test
    void depositTest(){
        Account user1 = new Account("Test1", "Test1");

        String input = "100.0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        user1.deposit();

        Assertions.assertEquals(100.0, user1.getBalance());
        System.setIn(System.in);
    }
}