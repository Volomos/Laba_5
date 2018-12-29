package CustomElements.decorator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

import CustomElements.Element;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.
        DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
public class FieldDecorator extends DefaultFieldDecorator {
    public FieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    /**
     * Метод вызывается фабрикой для каждого поля в классе
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<Element> decoratableClass = decoratableClass(field);
        // если класс поля декорируемый
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass);
            }

            return createElement(loader, locator, decoratableClass);
        }
        return super.decorate(loader, field);
    }

    /**
     * Возвращает декорируемый класс поля,
     * либо null если класс не подходит для декоратора
     */
    @SuppressWarnings("unchecked")
    private Class<Element> decoratableClass(Field field) {

        Class<?> clas = field.getType();

        if (List.class.isAssignableFrom(clas)) {

            // для списка обязательно должна быть задана аннотация
            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null) {
                return null;
            }
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            clas = (Class<?>) ((ParameterizedType) genericType).
                    getActualTypeArguments()[0];
        }

        if (Element.class.isAssignableFrom(clas)) {
            return (Class<Element>) clas;
        }
        else {
            return null;
        }
    }


    protected Element createElement(ClassLoader loader,  ElementLocator locator, Class<Element> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(clazz, proxy);
    }

    @SuppressWarnings("unchecked")
    protected List<Element> createList(ClassLoader loader,  ElementLocator locator,  Class<Element> clazz) {
        InvocationHandler handler = new LocatingCustomElementListHandle(locator, clazz);
        List<Element> elements = (List<Element>) Proxy.newProxyInstance( loader, new Class[] {List.class}, handler);
        return elements;
    }
}
