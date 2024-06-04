package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    //1.2 This method should click on the menu whatever name is passed as parameter.
        public void selectMenu(String menu) {
            WebElement menuElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]"));
            menuElement.click();
}

@Before
    public void setUp(){
        openBrowser(baseUrl);
}
@After
    public void tearDown(){
        closeBrowser();
}
@Test
//1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
// select the Menu and click on it and verify the page navigation.
    public void verifyPageNavigation(){
        selectMenu("Menu");
}






}
