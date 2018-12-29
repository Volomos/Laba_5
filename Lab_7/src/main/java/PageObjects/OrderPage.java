package PageObjects;
import CustomElements.TextField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends MainPage {

    public OrderPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id = "reciever_name")
    public TextField nameAndSurname;

    @FindBy(id = "suggest_locality")
    public TextField locality;

    @FindBy(id = "reciever_phone")
    public TextField phone;

    @FindBy(id = "reciever_email")
    public TextField email;

    @FindBy(css = ".btn-link.btn-link-green.check-step-btn-link.opaque>button")
    public WebElement continueButton;
}
