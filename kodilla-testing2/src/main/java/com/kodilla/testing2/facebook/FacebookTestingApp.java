package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_DAY = "//select[@id=\"day\"]";
    public static final String XPATH_MONTH = "//select[@id=\"month\"]";
    public static final String XPATH_YEAR = "//select[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement fieldDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(fieldDay);
        selectDay.selectByValue("10");

        WebElement fieldMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(fieldMonth);
        selectMonth.selectByValue("3");

        WebElement fieldYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(fieldYear);
        selectYear.selectByValue("1995");
    }
}
