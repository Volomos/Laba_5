package Tests;
import java.io.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import java.util.regex.Pattern;

public class GoogleTest2 {
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
        driver.get("https://www.google.com.ua");
        WebElement searchField = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String searchWord = "Subaru";
        int found = 1;
        String word = "Subaru в Украине";
        try {
            searchField.clear();
            searchField.sendKeys(searchWord);
            searchField.sendKeys(Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }catch (Throwable e)
        {
            e.printStackTrace();
        }

        try{
            driver.findElement(By.partialLinkText(word));
        }
        catch(NoSuchElementException e){
            System.out.println("There is no such element on the 1-st page!");
            found = 0;
        }
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            long start=System.currentTimeMillis();
            String targetUrl = driver.getCurrentUrl();
            String targetImg= "GoogleTest2.png";
            String command = "D:\\кпишка\\тестировка\\Lab6\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs D:\\кпишка\\тестировка\\Lab6\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\examples\\rasterize.js "+targetUrl + " " +targetImg;
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(found!=0) System.out.println("Element is on the 1-st page!");
        Thread.sleep(5000);

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
