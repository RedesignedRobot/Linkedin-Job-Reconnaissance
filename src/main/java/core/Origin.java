package core;

import com.jakewharton.fliptables.FlipTable;
import config.Xpath;
import model.Jobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.TextEdit;
import util.UrlFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Origin {


    public static void main(String[] args) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        UrlFactory urlFactory = new UrlFactory();
        TextEdit textEdit = new TextEdit();
        ArrayList<Jobs> jobsArrayList = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();


        countries.add("Saudi Arabia");
        countries.add("Singapore");
        countries.add("United Kingdom");


        for(String country : countries){

            driver.get(urlFactory.buildUrl(country, "2", "Software Developer"));
            driver.findElement(By.xpath(Xpath.expButton)).click();
            String val = textEdit.trimBrackets(driver.findElement(By.xpath(Xpath.jobCount)).getText());
            String cleanVal = val.replace(",","");

            jobsArrayList.add(new Jobs(country, Integer.parseInt(cleanVal)));
        }
        Collections.sort(jobsArrayList);
        for(Jobs job : jobsArrayList){
            System.out.println(job.getCountryName() + " " +job.getJobCount());
        }
    }
}
