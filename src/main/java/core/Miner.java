package core;

import config.Xpath;
import model.Jobs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ui.ColorPrint;
import util.ExcelWriter;
import util.TextEdit;
import util.UrlFactory;

import java.util.ArrayList;
import java.util.Collections;

public class Miner {

    private String[] master = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Colombia", "Comoros", "Congo", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Vatican City State", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kuwait", "Kyrgyzstan", "Lao", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};


    public void mine(String exp, String job, String title) {
        ColorPrint cp = new ColorPrint();
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        UrlFactory urlFactory = new UrlFactory();
        TextEdit textEdit = new TextEdit();
        ArrayList<Jobs> jobsArrayList = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        ExcelWriter excelWriter = new ExcelWriter();

        Collections.addAll(countries, master);


        countries.forEach(country -> {
            driver.get(urlFactory.buildUrl(country, exp, job));
            driver.findElement(By.xpath(Xpath.expButton)).click();
            String val = textEdit.trimBrackets(driver.findElement(By.xpath(Xpath.jobCount)).getText());
            String cleanVal = val.replace(",", "");
            jobsArrayList.add(new Jobs(country, Integer.parseInt(cleanVal)));
        });
        Collections.sort(jobsArrayList);
        excelWriter.write(jobsArrayList, title);
        driver.close();
        cp.green(title+".xlsx created.");
        cp.green("All done!");


    }

    public void mine(String exp, String job, String title, boolean headless) {
        WebDriver driver;
        if (headless) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            driver = new FirefoxDriver();
        }


        UrlFactory urlFactory = new UrlFactory();
        TextEdit textEdit = new TextEdit();
        ArrayList<Jobs> jobsArrayList = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        ExcelWriter excelWriter = new ExcelWriter();

        Collections.addAll(countries, master);

        countries.forEach(country -> {
            driver.get(urlFactory.buildUrl(country, exp, job));
            driver.findElement(By.xpath(Xpath.expButton)).click();
            String val = textEdit.trimBrackets(driver.findElement(By.xpath(Xpath.jobCount)).getText());
            String cleanVal = val.replace(",", "");
            jobsArrayList.add(new Jobs(country, Integer.parseInt(cleanVal)));
        });
        Collections.sort(jobsArrayList);
        excelWriter.write(jobsArrayList, title);
        driver.close();
    }

}
