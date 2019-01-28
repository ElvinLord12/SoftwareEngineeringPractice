package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    /**
     * @tests for valid withdraw attempts outlined in BankAccount.java javadoc
     * tries to withdraw more than we have also tries to withdraw a negative amount to raise our balance both work
     * prior to code update
     */
    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        bankAccount.withdraw(200);
        assertEquals(0,bankAccount.getBalance());
        bankAccount.withdraw(-300);
        assertEquals(0,bankAccount.getBalance());
        BankAccount bankAccount1 = new BankAccount("a@b.com",1000);
        bankAccount1.withdraw(400.123);
        assertEquals(1000,bankAccount1.getBalance());
    }

    /**
     * @tests for valid emails based on rules outlined in the BankAccount.java javadoc
     */
    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertTrue(BankAccount.isEmailValid("a-b@b.com"));
        assertTrue(BankAccount.isEmailValid("a@b.net"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse( BankAccount.isEmailValid(null));
        assertFalse( BankAccount.isEmailValid("-a@b.com"));
        assertFalse( BankAccount.isEmailValid("#a@b.com"));
        assertFalse( BankAccount.isEmailValid("a-@b.com"));
        assertFalse( BankAccount.isEmailValid("a@bcom"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        //checks for exception thrown for bad starting bal
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("bill@g.com",-200));
        //checks for exception thrown for bad starting bal
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("bill@g.com",200.123));

    }

    @Test
    void isValidAmountTest(){
        BankAccount bankAccount = new BankAccount("a@b.com",200);

        assertEquals(true,bankAccount.isAmountValid(100));
        assertEquals(true,bankAccount.isAmountValid(305.29));
        assertEquals(false,bankAccount.isAmountValid(-200));
        assertEquals(false,bankAccount.isAmountValid(212.1342));

    }

}