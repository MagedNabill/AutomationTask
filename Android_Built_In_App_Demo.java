import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android_Built_In_App_Demo {
        AppiumDriver driver;
        public AndroidTouchAction actions;

        @BeforeTest
        public void setUp() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("platformVersion", "14.0");
            caps.setCapability("deviceName", "Maged");
            caps.setCapability("app", System.getProperty("user.dir") + "/apps/Smiles_Sprint132_DEV_164_Automation.apk");


            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

        }
    private void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }
        @Test
       public void click_test() throws InterruptedException {
            actions = new AndroidTouchAction(driver);
            Thread.sleep(25000);

           AndroidElement login_button =
                    (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text=\\\"Skip to login\\");

            actions.tap(ElementOption.element(login_button)).perform();

           Thread.sleep(10000);
           driver.findElement(By.id("")).sendKeys("543938266");

           driver.findElement(By.id("")).click();

           //OTP
           driver.findElement(By.id("")).sendKeys("786786");
            //Allow
          driver.findElement(By.xpath("")).click();

          //clickonthexbutton
            driver.findElement(By.xpath("")).click();

            //Exploreall
            driver.findElement(By.xpath("")).click();


            //scrolldown

            // ScrollDown
            scrollDown();
            AndroidElement devices = (AndroidElement) driver.findElementByAccessibilityId("devices");
            actions.tap(ElementOption.element(devices)).perform();
          // WebDriverWait wait = new WebDriverWait(driver,30);

           // Thread.sleep(5000);

          // Assert.assertEquals(driver.findElement(By.xpath("");
          /*  AndroidElement views =
                    (AndroidElement) driver.findElementByAccessibilityId("");
            // Tap
            actions = new AndroidTouchAction(driver);
            actions.tap(ElementOption.element(views)).perform();


           */
       }

        @AfterTest
        public void tearDown() {
            if (null != driver) {
                driver.quit();
            }
        }
    }