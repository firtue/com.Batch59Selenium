package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    // ...Exercise3...
    // go to url : https://www.techlistic.com/p/selenium-practice-form.html
    //fill the firstname
    //fill the lastname
    //check the gender
    //check the experience
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.findElement(By.id("cookieChoiceDismiss")).click(); // çıkan cookies sorusunu cevapladık

        driver.findElement(By.name("firstname")).sendKeys("Erdem");
        driver.findElement(By.name("lastname")).sendKeys("Ergin");

        driver.findElement(By.id("sex-0")).click();

        driver.findElement(By.id("exp-0")).click();

        driver.findElement(By.id("datepicker")).sendKeys("01.10.2002");

        driver.findElement(By.id("profession-1")).click();

        driver.findElement(By.id("tool-2")).click();

        driver.findElement(By.className("input-xlarge")).click();
        driver.findElement(By.xpath("//option[.='Antartica']")).click();

        driver.findElement(By.xpath("//option[.='Browser Commands']")).click();

        driver.findElement(By.xpath("//button[@id='submit']")).click();

    }
}
