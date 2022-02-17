package com.wenqi.doudou.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumFirst {
    public static void main(String[] args) throws InterruptedException {
//        https://www.selenium.dev/documentation/getting_started/installing_browser_drivers
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");


        String currentUrl = driver.getCurrentUrl();
        System.out.printf("currentUrl is %s%n", currentUrl);

//        driver.navigate().back();
        Thread.sleep(5000L);
//        driver.navigate().forward();
//        Thread.sleep(5000L);
//        driver.navigate().refresh();

        System.out.printf("title is %s%n", driver.getTitle());

        driver.manage().window().maximize();

//
//        // 存储原始窗口的 ID
//        String originalWindow = driver.getWindowHandle();
//
//        // 检查一下，我们还没有打开其他的窗口
//        assert driver.getWindowHandles().size() == 1;
//
//        // 点击在新窗口中打开的链接
//        driver.findElement(By.linkText("new window")).click();

        // 等待新窗口或标签页
//        wait.until(numberOfWindowsToBe(2));
//
//        // 循环执行，直到找到一个新的窗口句柄
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//        // 等待新标签完成加载内容
//        wait.until(titleIs("Selenium documentation"));

    }

}
