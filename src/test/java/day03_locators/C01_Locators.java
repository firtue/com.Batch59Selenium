package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon'a gidip Nutella aratalım

        driver.get("https://www.amazon.com");
        // findElement(By.id ..... locator) istedigimiz web elementini bize dondurur
        // istedigimiz web elementini bize dondurur

        //WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        /*WebElement aramaKutusu= driver.findElement(By.className("nav-search-field "));
          bU locator çalışmadı
          Locator alırken gözümüzden kaçan detaylar olabilir
          aldığımız bir Locator çalışmazsa alternatif locator'lar denemeliyiz
        */
        WebElement aramaKutusu= driver.findElement(By.name("field-keywords"));

        /*
        <input type="text" id="twotabsearchtextbox" value=""
        name="field-keywords" autocomplete="off" placeholder=""
        class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">
         */

        // herhangi bir webelementine istedigimiz yaziyi yollamak istersek

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

    }
}
