package org.chris.automationtestingweb.contact_form;

public class ContactFormStarter {
    public static void main(String[] args) throws InterruptedException {
        ContactFormTest.fillContactForm("Dan", "Darby", "dan.d@gmail.com", "Hi, I did this via selenium webdriver");
    }
}
