package selenium_test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageObject {
   WebDriver driver;
   @Autowired WebDriverWait wait;

   public PageObject(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }

   public void load() {
       driver.get(getPage());
   }

   protected abstract String getPage();
}

