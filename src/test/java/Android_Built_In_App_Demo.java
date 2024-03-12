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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

        Thread.sleep(15000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        AndroidElement skip_to_login = (AndroidElement) driver.findElement(By.xpath("(//android.widget.Button)[1]"));
        wait.until(ExpectedConditions.visibilityOf(skip_to_login)).click();


        AndroidElement mobile_field = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText"));
        wait.until(ExpectedConditions.visibilityOf(mobile_field)).sendKeys("543938266");
        AndroidElement send_code_button = (AndroidElement) driver.findElement(By.xpath("(//android.widget.Button)[2]"));
        wait.until(ExpectedConditions.visibilityOf(send_code_button)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        AndroidElement allow_button = (AndroidElement) driver.findElement(By.xpath("//android.widget.Button[@text='Allow']"));
        wait.until(ExpectedConditions.visibilityOf(allow_button)).click();

        Thread.sleep(5000);
        AndroidElement otp_field = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText"));
        wait.until(ExpectedConditions.elementToBeClickable(otp_field)).sendKeys("786786");
        Thread.sleep(5000);


        wait.until(ExpectedConditions.alertIsPresent());
        AndroidElement allow2_button = (AndroidElement) driver.findElement(By.id("permission_allow_button"));
        wait.until(ExpectedConditions.visibilityOf(allow2_button)).click();

        AndroidElement explore_all_button = (AndroidElement) driver.findElement(By.id("navigation_bar_item_small_label_view"));
        explore_all_button.click();


        // ScrollDown
        scrollDown();
        AndroidElement devices = (AndroidElement) driver.findElement(By.xpath("//android.view.View[@index='4']"));
        actions.tap(ElementOption.element(devices)).perform();
        scrollDown();
        AndroidElement samsung = (AndroidElement) driver.findElement(By.id("iv_overlay"));
        actions.tap(ElementOption.element(devices)).perform();


           /* AndroidElement color = (AndroidElement) driver.findElement(By.xpath(""));
            color.click();
            AndroidElement storage = (AndroidElement) driver.findElement(By.xpath(""));
            storage.click();
            AndroidElement buy_button = (AndroidElement) driver.findElement(By.xpath(""));
            buy_button.click();
            AndroidElement one_time_button = (AndroidElement) driver.findElement(By.xpath(""));
            one_time_button.click();


            Send request to API
            Response response = RestAssured.get("API_ENDPOINT_URL");

        // Parse JSON response and extract price
            String listPriceIncVat = response.jsonPath().getString("listPriceIncVat");



        // Assert.assertEquals(appPrice, apiPrice, "Price displayed in the application does not match the API response price");

            */
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}