package PageObjects;
import org.openqa.selenium.WebDriver;

public class DeliveryPage extends MainPage{
    public DeliveryPage(WebDriver driver) {
        super(driver);
    }
    private static final String result = "https://my.rozetka.com.ua/checkout/?#step=delivery";
    public boolean match(){
         return getDriver().getCurrentUrl().equalsIgnoreCase(result);
    }
}
