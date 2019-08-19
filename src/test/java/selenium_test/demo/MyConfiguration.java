package selenium_test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;

@Configuration
public class MyConfiguration {
   @Bean
   public WebDriver getChrome() {
       System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       return driver;
   }

   @Bean
   public WebDriverWait getWait(WebDriver driver) {
       return new WebDriverWait(driver, 10);  //timeout in 10 seconds
   }
}
