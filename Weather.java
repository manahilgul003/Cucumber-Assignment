package com.tau.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Weather {
    WebDriver driver;
    String temperatureText;
    int currentTemperature;
    String totaltext;
    int currentTotal;

    @Before
    public void before_setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayesha Noor\\eclipse-workspace\\tau-tester-course\\src\\test\\resources\\chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
    }

    @Given("I am on the Weather Shopper homepage")
    public void i_am_on_the_Weather_Shopper_homepage() {
        driver.get("https://weathershopper.pythonanywhere.com/");
    }

    @When("the temperature is checked")
    public void the_temperature_is_checked() {
        WebElement temperatureElement = driver.findElement(By.id("temperature"));
        temperatureText = temperatureElement.getText();
        currentTemperature = Integer.parseInt(temperatureText.replaceAll("[^\\d]", "").trim());
    }

    @Then("I choose the appropriate product category based on the temperature")
    public void i_choose_the_appropriate_product_category_based_on_the_temperature() {
        if (currentTemperature < 19) {
            WebElement moisturizersButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/a/button"));
            moisturizersButton.click();
        } else if (currentTemperature > 34) {
            WebElement sunscreensButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/a/button"));
            sunscreensButton.click();
        }
    }
    @Then("I add the necessary products to the cart")
    public void i_add_the_necessary_products_to_the_cart() throws InterruptedException {
        List<WebElement> products, products1;
        
        if (currentTemperature < 19) {
            // Aloe products
            products = driver.findElements(By.xpath("//p[contains(text(), 'Aloe')]/following-sibling::p[contains(text(), 'Price')]/following-sibling::button"));
            PriorityQueue<WebElement> pqAloe = new PriorityQueue<>(Comparator.comparingInt(p -> {
                String priceText = p.findElement(By.xpath("preceding-sibling::p[contains(text(), 'Price')]")).getText();
                return Integer.parseInt(priceText.replaceAll("[^\\d]", "").trim());
            }));
            pqAloe.addAll(products);
            WebElement cheapestAloeProduct = pqAloe.peek(); // This will be the element with the lowest price
            cheapestAloeProduct.click();
            Thread.sleep(2000);
            
            // Almond products
            products1 = driver.findElements(By.xpath("//p[contains(text(), 'Almond')]/following-sibling::p[contains(text(), 'Price')]/following-sibling::button"));
            PriorityQueue<WebElement> pqAlmond = new PriorityQueue<>(Comparator.comparingInt(p -> {
                String priceText1 = p.findElement(By.xpath("preceding-sibling::p[contains(text(), 'Price')]")).getText();
                return Integer.parseInt(priceText1.replaceAll("[^\\d]", "").trim());
            }));
            pqAlmond.addAll(products1);
            WebElement cheapestAlmondProduct = pqAlmond.peek(); // This will be the element with the lowest price
            cheapestAlmondProduct.click();
            Thread.sleep(2000);

        } else if (currentTemperature > 34) {
            // SPF-30 products
            products = driver.findElements(By.xpath("//p[contains(text(), 'SPF-30')]/following-sibling::p[contains(text(), 'Price')]/following-sibling::button"));
            PriorityQueue<WebElement> pqSPF30 = new PriorityQueue<>(Comparator.comparingInt(p -> {
                String priceText = p.findElement(By.xpath("preceding-sibling::p[contains(text(), 'Price')]")).getText();
                return Integer.parseInt(priceText.replaceAll("[^\\d]", "").trim());
            }));
            pqSPF30.addAll(products);
            WebElement cheapestSPF30Product = pqSPF30.peek(); // This will be the element with the lowest price
            cheapestSPF30Product.click();
            Thread.sleep(2000);
            
            // SPF-50 products
            products1 = driver.findElements(By.xpath("//p[contains(text(), 'SPF-50')]/following-sibling::p[contains(text(), 'Price')]/following-sibling::button"));
            PriorityQueue<WebElement> pqSPF50 = new PriorityQueue<>(Comparator.comparingInt(p -> {
                String priceText1 = p.findElement(By.xpath("preceding-sibling::p[contains(text(), 'Price')]")).getText();
                return Integer.parseInt(priceText1.replaceAll("[^\\d]", "").trim());
            }));
            pqSPF50.addAll(products1);
            WebElement cheapestSPF50Product = pqSPF50.peek(); // This will be the element with the lowest price
            cheapestSPF50Product.click();
            Thread.sleep(2000);
        }
    }

    @Then("I click on the cart")
    public void i_click_on_the_cart() {
        WebElement cartButton = driver.findElement(By.xpath("/html/body/nav/ul/button"));
        cartButton.click();
    }

    @Then("I verify that the shopping cart looks correct")
    public void i_verify_that_the_shopping_cart_looks_correct() {
        // Verify cart has the correct items
        if (currentTemperature < 19) {
        	
            WebElement aloeMoisturizerCart_Price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
           String aloetext =  aloeMoisturizerCart_Price.getText();
           int aloeprice=Integer.parseInt(aloetext);
            WebElement almondMoisturizerCart_Price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]"));
            String almondtext =  almondMoisturizerCart_Price.getText();
            int almondprice=Integer.parseInt(almondtext);
            WebElement totalElement = driver.findElement(By.xpath("//*[@id=\"total\"]"));
            totaltext = totalElement.getText();
            currentTotal= Integer.parseInt(totaltext.replaceAll("[^0-9]", "").trim());
            int sum=aloeprice+almondprice;
           assertEquals(sum,currentTotal);
           
           ;
            
            
            
            
        } else if (currentTemperature > 34) {
        	
            WebElement spf50SunscreenCart_Price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]"));
            String spf50Text =  spf50SunscreenCart_Price.getText();
            int spf50price=Integer.parseInt(spf50Text);
            WebElement spf30SunscreenCart_Price = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
            String spf30Text =   spf30SunscreenCart_Price.getText();
            int spf30price=Integer.parseInt(spf30Text);
            WebElement totalElement2 = driver.findElement(By.xpath("//*[@id=\"total\"]"));
           String totaltext2 = totalElement2.getText();
            int currentTotal2= Integer.parseInt(totaltext2.replaceAll("[^0-9]", "").trim());
            int sum2=spf30price+spf50price;
           assertEquals(sum2,currentTotal2);
            
        }
    }

    @Then("I fill out my payment details")
    public void i_fill_out_my_payment_details() throws InterruptedException {
//    	WebElement payButton=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")); 
//    	payButton.click();
//        WebElement stripeIframe = driver.findElement(By.className("stripeInFrame appView iframe desktop en"));
//        driver.switchTo().frame(stripeIframe);
    	WebElement CheckoutPage= driver.findElement(By.cssSelector("body > div.container.top-space-50"));
    	CheckoutPage.click();
    	 WebElement payButton=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button")); 
 	payButton.click();
 	 driver.switchTo().frame(0);
 	 Thread.sleep(5000);
 	
        // Fill out the payment form
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test@example.com");

        WebElement cardNumberField = driver.findElement(By.id("card_number"));
        cardNumberField.sendKeys("4242424242424242");

        WebElement cardExpiryField = driver.findElement(By.id("cc-exp"));
        cardExpiryField.sendKeys("12/26");

        WebElement cardCvcField = driver.findElement(By.id("cc-csc"));
        cardCvcField.sendKeys("123");

Thread.sleep(5000);
    }
    @Then("Submit the Form")
    public void submit_the_form() {
    	
    	 WebElement SubmitField = driver.findElement(By.xpath("//*[@id=\"submitButton\"]/span/span"));
    	 SubmitField.click();
    	 WebElement PaymentSuccess=driver.findElement(By.xpath("/html/body/div"));
    	 assertTrue(PaymentSuccess.isDisplayed());
    }
 // Method to get the product price (assuming it can be extracted from the WebElement)
    private double getProductPrice(WebElement product) {
        // Implementation will depend on how the price is represented on the page
        String priceText = product.findElement(By.xpath("//p[contains(text(), '\" + productType + \"')]/following-sibling::p[contains(text(), 'Price')]/following-sibling::button\"")).getText();
        return Double.parseDouble(priceText.replace("[^\\d]", "").trim());
    }
    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
