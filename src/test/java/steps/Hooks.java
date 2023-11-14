package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("Setting up in cucumber before Hooks");
    }
    @Before(order = 1)
    public void setUpDatabase() {
        // Code to set up database
        System.out.println("code 1");
    }

    @Before(order = 2, value ="@ui")
    public void setUpWebdriver() {
        // Code to set up webdriver
        System.out.println("webdriver");
    }
    @After
    public void cleanUp(){
        System.out.println("Cleaning in cucumber");
    }
    @BeforeAll
    public static void globalSetup(){
        System.out.println("It shpuld only run once before all other things are ran");
    }
}
