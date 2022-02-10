import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver myDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        myDriver = new ChromeDriver();
        myDriver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown() {
        myDriver.quit();
    }

    @Test
    public void testPart1() {
        myDriver.get("https://kulibin.com.ua/");

        myDriver.findElement(By.id("catalog-menu")).click();
        myDriver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']")).click();
        myDriver.findElement(By.xpath("//*[contains(@title,'Дрели')]")).click();

        WebElement item1 = myDriver.findElement(By.id("bx_2040626179_3858_pict"));
        item1.click();
        WebElement oldPrice1 = myDriver.findElement(By.id("bx_117848907_3858_old_price"));
        WebElement newPrice1 = myDriver.findElement(By.id("bx_117848907_3858_price"));

        myDriver.navigate().back();

        WebElement item2 = myDriver.findElement(By.id("bx_2040626179_3132_pict"));
        item2.click();
        WebElement oldPrice2 = myDriver.findElement(By.id("bx_117848907_3132_old_price"));
        WebElement newPrice2 = myDriver.findElement(By.id("bx_117848907_3132_price"));

        myDriver.navigate().back();

        WebElement item3 = myDriver.findElement(By.id("bx_2040626179_6488_pict"));
        item3.click();
        WebElement oldPrice3 = myDriver.findElement(By.id("bx_117848907_6488_old_price"));
        WebElement newPrice3 = myDriver.findElement(By.id("bx_117848907_6488_price"));

        myDriver.navigate().to("https://kulibin.com.ua/");
    }

    @Test
    public void testPart2() {

        myDriver.get("https://kulibin.com.ua/");
        myDriver.findElement(By.id("catalog-menu")).click();
        myDriver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']")).click();
        myDriver.findElement(By.xpath("//*[contains(@title,'Перфораторы')]")).click();
        myDriver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
        myDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        myDriver.findElement(By.xpath("//*[contains(@class,'next btn-blue')]")).click();
        myDriver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
        myDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        myDriver.navigate().back();
    }

    @Test
    public void testPart3() {
        myDriver.get("https://kulibin.com.ua/");
        myDriver.findElement(By.id("catalog-menu")).click();
        myDriver.findElement(By.xpath("//a[@href='/catalog/elektroinstrument/']")).click();
        myDriver.findElement(By.xpath("//a[@title='Шуруповерты']")).click();

        List<WebElement> iconUSA = myDriver.findElements(By.xpath("//img[@src = '/upload/resize_cache/iblock/0f5/30_20_1/United_states.jpg']"));
        for (int i = 0; i <iconUSA.size(); i++) {
            Assert.assertTrue(iconUSA.size() != 0);
            System.out.println(iconUSA.get(i));
        }
    }
}
