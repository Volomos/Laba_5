package Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiters {
    public static void waitClickable(final WebDriver driver, By by, int time1, int time2){

        Wait waiter =  new FluentWait(driver).withTimeout(Duration.ofMillis(time1))
                .pollingEvery(Duration.ofMillis(time2)).ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        waiter.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void sleepInMillis(int time){
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException e){
        }
    }
}
