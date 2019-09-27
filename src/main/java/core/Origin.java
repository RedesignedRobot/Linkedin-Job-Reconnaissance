package core;

import config.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.TextEdit;
import util.UrlFactory;

public class Origin {
    public static void main(String[] args) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        UrlFactory urlFactory = new UrlFactory();
        TextEdit textEdit = new TextEdit();

        driver.get(urlFactory.buildUrl("Singapore", "2", "Java"));
        driver.findElement(By.xpath(Xpath.expButton)).click();
        String val = driver.findElement(By.xpath(Xpath.jobCount)).getText();
        System.out.println(textEdit.trimBrackets(val));
    }
}
