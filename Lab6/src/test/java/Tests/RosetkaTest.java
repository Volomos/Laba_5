package Tests;
import java.io.*;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import java.util.regex.Pattern;

public class RosetkaTest {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public static WebDriver driver;

    @BeforeClass
    public static void startService() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\кпишка\\тестировка\\Lab6\\chromedriver.exe");

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() throws Exception {
        driver.get("https://www.rozetka.com.ua");
        driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div[2]/div[1]/div/button")).click(); // catalog
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div[2]/div[1]/div/fat-menu/div/ul/li[16]/a")).click(); // all categories
        ///html/body/app-root/div/div/rz-header/header/div/div[2]/div[2]/div/fat-menu/div/ul/li[16]/a"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='14939']/div/div/ul[1]/li[11]/a")).click(); //category
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement minField = driver.findElement(By.xpath("//*[@id='price[min]']"));
        WebElement okButton = driver.findElement(By.xpath("//*[@id='submitprice']"));
        String minimalPrice = "500";
        try {
            minField.clear();
            minField.sendKeys(minimalPrice);
            okButton.click();
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        ////*[@id="goods_price_block_4965946"]/div[2]/div/text()
        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='g-price-uah']"));
        int numb = 0;
        boolean correct = true;
        for(WebElement price:prices){
            numb+=1;
            if (Integer.valueOf(price.getText().replaceAll("[^0-9]", "")) < 500)
            {
                System.out.println("Program hasn't sorted elements correctly");
                break;
            }
        }
        if(correct) System.out.println(numb+" elements passed test");
        Thread.sleep(15000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            long start=System.currentTimeMillis();
            String targetUrl = driver.getCurrentUrl();
            String targetImg="RozetkaTest.png";
            String command = "D:\\кпишка\\тестировка\\Lab6\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs D:\\кпишка\\тестировка\\Lab6\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\examples\\rasterize.js "+targetUrl + " " +targetImg;
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
