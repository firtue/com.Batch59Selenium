package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) {
        /*
        Main method oluşturun ve aşağıdaki görevi tamamlayın.
    a. http://a.testaddressbook.com adresine gidiniz.
    b. Sign in butonuna basin
    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        i. Username : testtechproed@gmail.com
        ii. Password : Test1234!
    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    3. Sayfada kac tane link oldugunu bulun.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        WebElement signInLinki= driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextbox = driver.findElement(By.id("session_email"));
        WebElement passwordTextbox = driver.findElement(By.name("session[password]"));
        WebElement signInButonu = driver.findElement(By.name("commit"));

        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //     i. Username : testtechproed@gmail.com
        //     ii. Password : Test1234!
        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextbox.sendKeys("Test1234!");
        signInButonu.click();

        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement actualKullaniciAdi = driver.findElement(By.className("navbar-text"));
        System.out.println(actualKullaniciAdi.getText());
            // *** bir WebElement'in üzerinde ne yazdığını görmek istersek WebElementIsmi.getText() kullanırız
        String expectedUserMail="testtechproed@gmail.com";

        if (expectedUserMail.equals(actualKullaniciAdi.getText())){
            System.out.println("Expected kullanıcı testi PASSED");
        } else {
            System.out.println("Expected kullanıcı testi FAILED");
        }

        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini(displayed) doğrulayin(verify).
        WebElement addressesElementi = driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi = driver.findElement(By.linkText("Sign out"));
        if (addressesElementi.isDisplayed()){
            System.out.println("addresses testi PASSED");
        } else {
            System.out.println("addresses testi FAILED");
        }

        if (signOutElementi.isDisplayed()){
            System.out.println("signOut testi PASSED");
        } else {
            System.out.println("signOut testi FAILED");
        }

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkListesi= driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki link sayisi : " + linkListesi.size());

        // linklerini yazdıralım
            // Listemiz WebElement'lerden oluştuğu için, direk yazarsak referansları yazdırır
            // onun yerine for-each loop yapıp her bir link WebElement'inin üzerindeki yazıyı yazdırmalıyız
        for (WebElement each: linkListesi
             ) {
            System.out.println(each.getText());
        }

        driver.close();
    }
}
