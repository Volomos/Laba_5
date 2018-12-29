package CustomElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtmlLabel extends  Element {
    public HtmlLabel(WebElement element) {
        super(element);
    }

    public String getNameOfLabel(){
        return super.findElement(new By.ByClassName("filter-parametrs-i-l-i-default-title")).getText() ;
    }
}
