import PageObjects.*;
import Contexts.*;
import Utils.Screen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.*;
import static Utils.Waiters.sleepInMillis;


public class Lab7_finalTest {
    private static WebDriver driver;
    public static String mainpage = "https://bt.rozetka.com.ua/ir_heaters/c80247/";
    @BeforeClass
    public static void startService() throws IOException{
        System.setProperty("webdriver.chrome.driver", "D:\\кпишка\\тестировка\\Lab6\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @Test
    public void test() throws Exception {
        SortOutPage catalog = new SortOutPage(driver);
        catalog.start(mainpage);
        
        int min = 100;
        int max = 2000;
        String country = "Украина";

        Filter.setPrice(catalog, min, max);
        sleepInMillis(4000);
        GoodsPage fittingProduct = Filter.setCountry(catalog, country);
        OrderPage productToOrder = Purchase.submitPurchase(fittingProduct);

        DeliveryPage deliverProduct = MakeOrder.input_Info(productToOrder);
        if(deliverProduct.match()) System.out.println("We are on the right delivery page!!");
        else System.out.println("We are not on the right delivery page...");

        Screen.getscreenshot(driver);
        sleepInMillis(1000);
    }
    @AfterClass
    public static void Close(){
        driver.quit();
    }
}
