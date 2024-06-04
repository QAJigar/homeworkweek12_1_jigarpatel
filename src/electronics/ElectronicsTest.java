package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utility;

import java.time.Duration;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    //1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("Text not Match", "Cell phones", getTextFromElement(By.xpath("//*[@id='main']/div/div[3]/div/div[1]/h1")));
    }

    @Test
    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        clicksOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        Assert.assertEquals("Text not Match", "Cell phones", getTextFromElement(By.xpath("//*[@id='main']/div/div[3]/div/div[1]/h1")));
        //2.4 Click on List View Tab
        clicksOnElement(By.xpath("//*[@id='main']/div/div[3]/div/div[2]/div[1]/div[1]/a[2]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement clickOnProduct = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Nokia Lumia 1020")));  ////div[@data-productid='1']//button[contains(@class, 'add-to-cart')
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickOnProduct);

        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("text is not displayed", "Nokia Lumia 1020", getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
        // 2.7 Verify the price “$349.00”
        Assert.assertEquals("value is incorrect", "$349.00", getTextFromElement(By.xpath("//span[text()=' $349.00 ']")));
        // 2.8 Change quantity to 2
        driver.findElement(By.className("qty-input")).clear();
        sendTextToElement(By.className("qty-input"),"2");
        // 2.9 Click on “ADD TO CART” tab
        clicksOnElement(By.xpath("(//button[@id='add-to-cart-button-20'])[1]"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("text is not displayed", "The product has been added to your shopping cart", getTextFromElement(By.xpath("//p[@class='content']")));
        // After that close the bar clicking on the cross button.
        clicksOnElement(By.xpath("//span[@title='Close']"));
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//a[@class='ico-cart']"));
        clicksOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        // 2.12 Verify the message "Shopping cart"
        Assert.assertEquals("text is not displayed", "Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        // 2.13 Verify the quantity is 2
        Assert.assertEquals("incorrect quantity","2",getAttributeFromElement(By.className("qty-input")));
        // 2.14 Verify the Total $698.00
        Assert.assertEquals("total is incorrect","$698.00",getTextFromElement(By.xpath("//td[@class='cart-total-right']//span/strong")));
        // 2.15 click on checkbox “I agree with the terms of service”
        clicksOnElement(By.id("termsofservice"));
        // 2.16 Click on “CHECKOUT”
        clicksOnElement(By.id("checkout"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Title is not displayed","Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        // 2.18 Click on “REGISTER” tab
        clicksOnElement(By.xpath("//button[contains(text(),'Register')]"));
        // 2.19 Verify the text “Register”
        Assert.assertEquals("Title is not displayed","Register",getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));
        // 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Jigar");
        sendTextToElement(By.id("LastName"),"Patel");
        sendTextToElement(By.id("Email"),"jigaswet4@gmail.com");
        sendTextToElement(By.id("Password"),"prime1@04");
        sendTextToElement(By.id("ConfirmPassword"),"prime1@04");
        // 2.21 Click on “REGISTER” Button
        clicksOnElement(By.id("register-button"));
        // 2.22 Verify the message “Your registration completed”
        Assert.assertEquals("Title is not displayed","Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));

        // 2.23 Click on “CONTINUE” tab
        clicksOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        // 2.24 Verify the text “Shopping cart”
        Assert.assertEquals("Text is not displayed","Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        // 2.25 click on checkbox “I agree with the terms of service”
        clicksOnElement(By.id("termsofservice"));
        // 2.26 Click on “CHECKOUT”
        clicksOnElement(By.id("checkout"));
        // 2.27 Fill the Mandatory fields
        selectDropdownOptionByValue(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"391,city road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"EC1V 1NW");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"0789456123");
        // 2.28 Click on “CONTINUE”
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clicksOnElement(By.xpath("//label[contains(text(),'2nd Day Air')]"));

        // 2.30 Click on “CONTINUE”
        // clicksOnElement(By.className("shipping-method-next-step-button"));
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ShippingMethod.save()']"));
        // 2.31 Select Radio Button “Credit Card”
        clicksOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentMethod.save()']"));
        // 2.32 Select “Visa” From Select credit card dropdown
        selectDropdownOptionByValue(By.id("CreditCardType"),"Visa");
        // 2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"Jigar");
        sendTextToElement(By.id("CardNumber"),"4444333322221111");
        selectDropdownOptionByValue(By.id("ExpireMonth"),"11");
        selectDropdownOptionByValue(By.id("ExpireYear"),"2030");
        sendTextToElement(By.id("CardCode"),"391");
        // 2.34 Click on “CONTINUE”
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentInfo.save()']"));
        // 2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("payment method is incorrect","Credit Card",getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("shipping method is incorrect","2nd Day Air",getTextFromElement(By.cssSelector("li[class='shipping-method'] span[class='value']")));

        // 2.37 Verify Total is “$698.00”
        Assert.assertEquals("Total is incorrect","$698.00",getTextFromElement(By.xpath("//tr[@class='order-total']//span/strong")));
        // 2.38 Click on “CONFIRM”
        clicksOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // 2.39 Verify the Text “Thank You”
        Assert.assertEquals("text is not correct", "Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        // 2.40 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("text is not displayed", "Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        // 2.41 Click on “CONTINUE”
        clicksOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        // 2.42 Verify the text “Welcome to our store”
        Assert.assertEquals("Text is incorrect","Welcome to our store",getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
        // 2.43 Click on “Logout” link
        clicksOnElement(By.linkText("Log out"));
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Assert.assertEquals("url is incorrect","https://demo.nopcommerce.com/",driver.getCurrentUrl());

    }
}