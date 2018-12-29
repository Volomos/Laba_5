package PageObjects;
import CustomElements.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import Utils.Waiters;
import java.util.List;

public class SortOutPage extends MainPage {
    public SortOutPage (WebDriver driver){
        super(driver);
    }

    public SortOutPage start(String url){
        getDriver().get(url);
        return this;
    }

    @FindBy(id = "price[min]")
    private TextField minPrice;

    @FindBy(id = "price[max]")
    private TextField  maxPrice;

    @FindBy(id = "submitprice")
    private WebElement submitPrice;

    @FindBy(xpath = "//body/div[3]")
    @CacheLookup
    public WebElement progressBar;

    @FindBys(@FindBy(xpath = "//*[@id='sort_strana-proizvoditelj-103331']/li/label"))
    List<HtmlLabel> List;
    private HtmlLabel Selected;

    public SortOutPage submitprice(){
        submitPrice.sendKeys(Keys.ENTER);
        return this;
    }

    public SortOutPage inputMinPrice(Integer price){
        minPrice.inputValue(price.toString());
        return this;

    }

    public SortOutPage inputMaxPrice(Integer price){

        maxPrice.inputValue(price.toString());
        return this;
    }


    public GoodsPage selectCountry(String country){
        //choose correct contry
        int current = -1;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getNameOfLabel().equalsIgnoreCase(country.trim())){
                current = i;
                break;
            }
        }
        Selected = List.get(current);
        Selected.click();
        By path = new By.ByXPath("//*[@id='catalog_goods_block']/div/div/div/div/div/div/*[@class='g-i-tile-i-title clearfix']/a");
        Waiters.waitClickable(getDriver(), path, 6000, 5);
        List<WebElement> links = getDriver().findElements(path);
        links.get(0).click();
        return new GoodsPage(getDriver());
    }
}
