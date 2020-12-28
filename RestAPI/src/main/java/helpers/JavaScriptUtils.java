package helpers;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    public JavaScriptUtils(){

    }

    public static void scrollDownToElement(WebElement element, ChromeDriver driver){
        Point p = element.getLocation();
        int horizontalPosition = p.getX();
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + horizontalPosition + " )");
    }
}
