package selenium_test.demo;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.*;
import java.util.Locale;

@Component
@Scope("prototype")
public class AmazonPage extends PageObject {
   WebElement twotabsearchtextbox;

   public AmazonPage(WebDriver driver) {
       super(driver);
   }

   @Override
   protected String getPage() {
       return "http://www.amazon.com";
   }

   public void search(String string) {
       twotabsearchtextbox.clear();
       twotabsearchtextbox.sendKeys(string);
       twotabsearchtextbox.submit();
   }

   public long getResultCount() throws ParseException {
       WebElement resultCount = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/h1/div/div[1]/div/div/span[1]"));
       String resultCountText = resultCount.getText();
       String results = StringUtils.substringBetween(resultCountText, "of ", " results");
       results = StringUtils.replace(results, "over", "").trim();
       return (long) NumberFormat.getNumberInstance(Locale.US).parse(results);
   }
}

