package selenium_test.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GooglePage extends PageObject {
   @FindBy(name = "q") WebElement searchBox;

   public GooglePage(WebDriver driver) {
       super(driver);
   }

   @Override
   protected String getPage() {
       return "http://www.google.com";
   }

   public void search(String string) {
       searchBox.clear();
       searchBox.sendKeys(string);
       searchBox.submit();
   }

   public String getTitle() {
       wait.until(ExpectedConditions.titleContains("bugs bunny"));
       return driver.getTitle();
   }
}

