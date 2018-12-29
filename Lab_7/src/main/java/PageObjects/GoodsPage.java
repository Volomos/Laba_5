package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utils.Waiters;
public class GoodsPage extends MainPage{
    public GoodsPage (WebDriver driver){
        super(driver);
    }
    //*[@id='price_container']/div[2]/div/form/span/span/button
    //*[@id='price_container']/div[2]/div/form/span

    @FindBy(xpath = "//*[@id='price_container']/div[2]/div/form/span/span/button")
    private WebElement gooodsBuyButton;

    private WebElement goodsSubmitButton;


    public OrderPage submitBuying(){
        gooodsBuyButton.click();
        Waiters.sleepInMillis(2000);
        //*[@id='popup-checkout']
        By path = new By.ByXPath("//*[@id='popup-checkout']");
        goodsSubmitButton = getDriver().findElement(path);
        goodsSubmitButton.click();
        return new OrderPage(getDriver()) ;
    }
}
