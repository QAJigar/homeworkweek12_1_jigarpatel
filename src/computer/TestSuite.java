package computer;

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

public class TestSuite extends Utility {

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
    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        //1.2 Click on Desktop
        //1.3 Select Sort By position "Name: Z to A"
        //1.4 Verify the Product will arrange in Descending order.
    }

    @Test
    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessFully() {
        // 2.1 Click on Computer Menu.
        clicksOnElement(By.linkText("Computers"));
        // 2.2 Click on Desktop
        clicksOnElement(By.linkText("Desktops"));
        // 2.3 Select Sort By position "Name: A to Z"
        selectDropdownOptionByValue(By.id("products-orderby"), "Name: A to Z");
        // 2.4 Click on "Add To Cart" from 'Build your own computer' product
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-productid='1']//button[1]")));  ////div[@data-productid='1']//button[contains(@class, 'add-to-cart')]
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartButton);
        // 2.5 Verify the Text "Build your own computer"
        Assert.assertEquals("text is not displayed", "Build your own computer", getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")));
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectDropdownOptionByValue(By.name("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectDropdownOptionByValue(By.id("product_attribute_2"), "8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clicksOnElement(By.xpath("//label[text()='400 GB [+$100.00]']"));
        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clicksOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clicksOnElement(By.xpath("//label[text()='Total Commander [+$5.00]']"));
        // 2.11 Verify the price "$1,475.00"
        //  Assert.assertEquals("invalid total", "$1,475.00", getTextFromElement(By.xpath("//div[@class='product-price']/span")));
        // 2.12 Click on "ADD TO CART" Button.
        clicksOnElement(By.xpath("//button[text()='Add to cart']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("text is not displayed", "The product has been added to your shopping cart", getTextFromElement(By.xpath("//div[@class='bar-notification success']")));
        //  After that close the bar clicking on the cross button.
        clicksOnElement(By.xpath("//span[@title='Close']"));


        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clicksOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals("text is not displayed", "Shopping cart", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clicksOnElement(By.xpath("//div[@class='quantity up']"));
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals("invalid totla", "$2,950.00", getTextFromElement(By.xpath("//tr/td[6]//span")));
        //2.18 click on checkbox “I agree with the terms of service”
        clicksOnElement(By.id("termsofservice"));
        // 2.19 Click on “CHECKOUT”
        clicksOnElement(By.id("checkout"));
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("text in incorrect", "Welcome, Please Sign In!", getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clicksOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Jigar");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "jigswe17@gmail.com");
        selectDropdownOptionByValue(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "391, city road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "EC1V 1NW");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07496667474");
        //2.23 Click on “CONTINUE”
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//*[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//*[@id='shipping-method-buttons-container']/button"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//*[@id='payment-method-block']/li[2]/div/div[2]/label"));
        clickOnElement(By.xpath("//*[@id='payment-method-buttons-container']/button"));
        // 2.27 Select “Master card” From Select credit card dropdown
        selectDropdownOptionByValue(By.id("CreditCardType"), "Master card");
        // 2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Jigar Patel ");
        sendTextToElement(By.id("CardNumber"), "5555555555554444");
        selectDropdownOptionByValue(By.id("ExpireMonth"), "12");
        selectDropdownOptionByValue(By.id("ExpireYear"), "2030");
        sendTextToElement(By.id("CardCode"), "932");
        // 2.29 Click on “CONTINUE”
        //clicksOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; PaymentInfo.save()']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("invalid payment method", "Credit Card", getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]")));
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        Assert.assertEquals("invalid shipping method", "Next Day Air", getTextFromElement(By.cssSelector("li[class='shipping-method'] span[class='value']")));
        // 2.33 Verify Total is “$2,950.00”
        Assert.assertEquals("Total is invalid", "$2,950.00", getTextFromElement(By.xpath("//tr[@class='order-total']//span/strong")));
        // 2.34 Click on “CONFIRM”
        clicksOnElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; ConfirmOrder.save()']"));
        // 2.35 Verify the Text “Thank You”
        Assert.assertEquals("text is not correct", "Thank you", getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        // 2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("text is not displayed", "Your order has been successfully processed!", getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        // 2.37 Click on “CONTINUE”
        clicksOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.37 Verify the text “Welcome to our store”
        Assert.assertEquals("text is not displayed", "Welcome to our store", getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));
    }

    }
