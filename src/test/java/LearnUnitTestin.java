import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LearnUnitTestin {
    protected static WebDriver driver;

    @Before
    public void setup() {


        System.setProperty("webdriver.chrome.driver", "src\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //implicit wait applied to driver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //asking driver to get the url
        driver.get("https://demo.nopcommerce.com/");
    }


    @Test
    public void userShouldBeRegisteredSuccessfully() {
        //register for new user
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //First name
        driver.findElement(By.xpath("//Input[@name='FirstName']")).sendKeys("Bhumi");
        //Last Name
        driver.findElement(By.xpath("//Input[@name='LastName']")).sendKeys("Patel");
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
        String emailId = "Maria" + userName + "@gmail.com";

        driver.findElement(By.xpath("//Input[@name='Email']")).sendKeys(emailId);
        //System.out.println(emailID);
        //enter password
        driver.findElement(By.xpath("//Input[@name='Password']")).sendKeys("bhumi26");
        //Enter Confirm password
        driver.findElement(By.xpath("//Input[@name='ConfirmPassword']")).sendKeys("bhumi26");
        //Click registration button
        driver.findElement(By.xpath("//Input[@name='register-button']")).click();

        //actual register message appears
        String actualRegisterationSuccessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals("Your registration completed", actualRegisterationSuccessMessage);


    }

    @Test
    public void usershouldbeabletonavigatetonotebookcategory() {
        // click on computer
        driver.findElement(By.xpath("//a[@href=\"/computers\"]")).click();
       // click on notebook
        driver.findElement(By.partialLinkText("Notebooks")).click();

        String usershouldbeabletoseenotebookcategory = driver.findElement(By.xpath("//div [@class=\"page-title\"]")).getText();
         //actual result
        System.out.println("usershouldbeabletonavigatetonotebookcatergory");
        Assert.assertEquals("Notebooks", usershouldbeabletoseenotebookcategory);


    }


    @Test
    public void usershouldbeabletonavigatetocellphonepage() {
        //click on electronics
        driver.findElement(By.xpath("//a[@href=\"/electronics\"]")).click();
        //click on cellphone
        driver.findElement(By.partialLinkText("Cell phones")).click();
        String usershouldbeabletoseecellphonecategory = driver.findElement(By.xpath("//div[@class=\"page-title\"]")).getText();
        //actual result
        System.out.println("usershouldbealbetonavigatetocellphonepage");
        Assert.assertEquals("Cell phones", usershouldbeabletoseecellphonecategory);

    }

    @Test
    public void usershouldbeabletologinsuccessfully() {
        //click on login
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
         String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);
        String emailId = "Maria" + userName  + "@gmail.com";
        //Enter emailID
        driver.findElement(By.xpath("//input[@class=\"email\"]")).sendKeys("bhumi11@gmail.com");
        //Enter password
        driver.findElement(By.xpath("//input[@class=\"password\"]")).sendKeys("bhumi26");
        //Click on login button
        driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
        String usershouldbeabletologinsuccessfully= driver.findElement(By.xpath("//a[@class=\"ico-logout\"]") ).getText();
        //Actual result
        System.out.println("usershouldbeabletologinsuccessfully");
        Assert.assertEquals("Log out", usershouldbeabletologinsuccessfully);


    }
    @Test
    public void usershouldbeabletoaddproducttoshoppingcart() {
         // click on book category
        driver.findElement(By.xpath("//a[@href=\"/books\"]")).click();
        //select a book
        driver.findElement(By.xpath("//a[@href=\"/first-prize-pies\"]")).click();
        //click on add to cart button
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-38\"]")).click();
        //priduct added to cart
        String usershouldbeabletoseeproducttoshoppingcart = driver.findElement(By.xpath("//p[@class=\"content\"]")).getText();
        // Actual result
        System.out.println("product is added to shopping cart");
        Assert.assertEquals("The product has been added to your shopping cart", usershouldbeabletoseeproducttoshoppingcart);
    }

      @After
    public void closeBrowser(){
         // driver instance
           driver.quit();


      }

        }



