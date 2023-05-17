package org.chris.utils;

import java.io.IOException;

public class DriversKiller {

    public static void main(String[] args) {
        try {
            // Execute a command to close all instances of chromedriver.exe
            Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
            Runtime.getRuntime().exec("taskkill /f /im msedge.exe");

            System.out.println("Successfully closed all instances of chromedriver and msedgedriver");
        } catch (IOException e) {
            System.err.println("Error closing chromedriver.exe: " + e.getMessage());
        }
    }

}
