package Contexts;
import PageObjects.OrderPage;
import PageObjects.DeliveryPage;
import Utils.Waiters;

public class InputCustomer {
    public static DeliveryPage inputInfo(OrderPage page){
        page.nameAndSurname.inputValue("Vova Moskalenko");
        page.phone.inputValue("+380936666666");
        page.email.inputValue("myemail@gmail.com");
        Waiters.sleepInMillis(2000);
        return clickOnContinueButton(page);
    }
    public static DeliveryPage clickOnContinueButton(OrderPage page)
    {
        while(page.continueButton.isDisplayed()&& page.continueButton.isEnabled())
        {
            page.continueButton.click();
            Waiters.sleepInMillis(5000);
        }
        return new DeliveryPage(page.getDriver());
    }
}
