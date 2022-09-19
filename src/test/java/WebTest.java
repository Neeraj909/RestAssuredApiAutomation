import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebTest {

    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='navFooterLinkCol navAccessibility']//div[text()='Connect with Us']//following-sibling::ul/li/a"));
       for(int i=0;i<list.size();i++){
           String text=list.get(i).getText();
           list.get(i).click();
          // String parentWindow=driver.
           String s1 = driver.getWindowHandle();
           driver.switchTo().window(s1);
           SoftAssert softAssert=new SoftAssert();
           softAssert.assertEquals(driver.getTitle(),text);
           driver.close();

       }
    }
}
