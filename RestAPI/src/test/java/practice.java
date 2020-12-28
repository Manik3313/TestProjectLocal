import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.URL;


public class practice
{
    public static  void main(String args[]) throws Throwable {
        EdgeOptions caps=new EdgeOptions();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "manikgupta5's First Test");
       // caps.setCapability(
         //       TestProjectCapabilityType.CLOUD_URL, cloudUrl);
        //EdgeDriver driver=new EdgeDriver("SmBwObq_TzSPkKuuWV8hQobhRwkX7f8tHKXXPZj4bYY1",caps);
        EdgeDriver driver1 = new DriverBuilder<EdgeDriver>(new EdgeOptions())
                .withRemoteAddress(new URL("http://localhost:8585"))
                .withToken("SmBwObq_TzSPkKuuWV8hQobhRwkX7f8tHKXXPZj4bYY1")
                .withProjectName("PracticeDemo")
                .withJobName("PracticeDemoJob")
                .build(EdgeDriver.class);
        driver1.get("https://www.google.com/");
        driver1.report().step("Url open",true);


        /*driver.get("https://www.google.com/");
        driver.report().test("Practice").submit();
        driver.quit();*/
    }
}
