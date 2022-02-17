package com.wenqi.doudou.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumSecond {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dmcazsysinthc1-dm-internal-azure-az-sysint-execution.cfapps.eu20.hana.ondemand.com/cp.portal/site#DMEOrderPOD-Display?sap-ui-app-id-hint=sap.dm.dme.pod");


        String currentUrl = driver.getCurrentUrl();
        System.out.printf("currentUrl is %s%n", currentUrl);


        System.out.printf("title is %s%n", driver.getTitle());

        driver.manage().window().maximize();


    }
}
