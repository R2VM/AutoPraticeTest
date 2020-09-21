package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SigninStepDefinition {

    WebDriver driver;
    String title;

    @Given("^User enters correct userid and password on sign in page and clicks signin button$")
    public void user_enters_correct_userid_and_password_on_sign_in_page_and_clicks_signin_button() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.findElement(By.className("login")).click();
        driver.findElement(By.xpath("//input[@ id='email']")).sendKeys("vk@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Test@123");
        driver.findElement(By.id("SubmitLogin")).click();
        }

    @When("^user clicks on home button and enters Summer Dresses in search section$")
    public void user_clicks_on_home_button_and_enters_Summer_Dresses_in_search_section() throws Throwable {
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("Summer Dresses");
        driver.findElement(By.className("button-search")).click();

    }

    @Then("^user selects dresses and clicks on Add to Cart button$")
    public void user_selects_dresses_and_clicks_on_Add_to_Cart_button()
    {
        driver.findElement(By.linkText("Printed Summer Dress")).click();
        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

    }

    @Then("^user clicks on Continue shoppting button and selects another dress and clicks Add to cart button$")
    public void user_clicks_on_Continue_shoppting_button_and_selects_another_dress_and_clicks_Add_to_cart_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")).click();

    }

    @Then("^user clicks on Proceed to Checkout button$")
    public void user_clicks_on_Proceed_to_Checkout_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

    }

    @Then("^Summary page displays with product & price details and user clicks Proceed to Checkout button$")
    public void summary_page_displays_with_product_price_details_and_user_clicks_Proceed_to_Checkout_button() throws Throwable {
        Assert.assertEquals("Order - My Store, SHOPPING-CART SUMMARY", title);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

    }

    @Then("^Delivery and Billing Address page displays and click on Proceed to Checkout button$")
    public void delivery_and_Billing_Address_page_displays_and_click_on_Proceed_to_Checkout_button() throws Throwable {
        Assert.assertEquals("Order - My Store", title);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();

    }

    @Then("^Shipping page displays and click on Terms of Service check box field$")
    public void shipping_page_displays_and_click_on_Terms_of_Service_check_box_field() throws Throwable {
        Assert.assertEquals("Order - My Store, SHIPPING", title);
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
    }

    @Then("^click on Proceed to Checkout button for Payment page to display with all details\\.$")
    public void click_on_Proceed_to_Checkout_button_for_Payment_page_to_display_with_all_details() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", title);
    }


}
