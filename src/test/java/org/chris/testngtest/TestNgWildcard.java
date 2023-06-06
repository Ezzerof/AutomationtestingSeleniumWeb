package org.chris.testngtest;

import org.testng.annotations.Test;

public class TestNgWildcard {

    /**
     * <include name="Tablet.*"></include>
     * <include name="Laptop.*"></include>
     */


    @Test
    public void Tablet_login() {
        System.out.println("Tablet login");
    }
    @Test
    public void Tablet_addItem() {
        System.out.println("Tablet added item");
    }

    @Test
    public void Desktop_login() {
        System.out.println("Desktop login");
    }
    @Test
    public void Desktop_addItem() {
        System.out.println("Desktop added item");
    }

    @Test
    public void Laptop_login() {
        System.out.println("Laptop login");
    }
    @Test
    public void Laptop_addItem() {
        System.out.println("Laptop added item");
    }

}
