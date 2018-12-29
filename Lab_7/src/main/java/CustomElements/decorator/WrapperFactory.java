package CustomElements.decorator;
import CustomElements.Element;
import org.openqa.selenium.WebElement;

public class WrapperFactory {

    /**
     * Создает экземпляр класса,
     * реализующий IElement интерфейс,
     * вызывая конструктор с аргументом WebElement
     */
    public static Element createInstance(Class<Element> clas, WebElement element) {
        try {
            return clas.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clas);
        }
    }
}