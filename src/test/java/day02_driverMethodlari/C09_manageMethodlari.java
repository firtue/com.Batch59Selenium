package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_manageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com.tr");

        /*
        İleride wait konusunu daha geniş olarak ele alacağız
        Bir sayfa açılırken, ilk başat sayfanın içerisinde bulunan elementlere göre
        bir yükleme süresine ihtiyaç vardır
        veya bir web elementinin kullanılabilmesi için zamana ihtiyaç olabilir
        implicitlyWait bize sayfanın yüklenmesi ve sayfadaki elementlere ulaşım için beklenecek
        MAXİMUM süreyi belirleme olanağı tanır
         */

        driver.close();
    }
}
