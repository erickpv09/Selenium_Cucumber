package GlueCode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import lombok.SneakyThrows;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {

    private ChromeDriver driver;


    @Given("^i am in the index page$")
    public void i_am_in_the_index_page() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/Chromedriver/chromedriver.exe");
        ChromeOptions opcionesChrome = new ChromeOptions();
        opcionesChrome.addArguments("--incognito");
        driver = new ChromeDriver(opcionesChrome);
        driver.get("https://certfinflowtest.asicom.cl/#/login");
        driver.manage().window().maximize();
    }
    @When("^sign in like ejecutivo de cuentas$")
    public void sign_in_like_ejecutivo_de_cuentas(){
        WebElement usertxt = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[1]/input"));
        usertxt.sendKeys("ejecutivodecuentas@finflowitau.cl");
        WebElement passtxt = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[2]/input"));
        passtxt.sendKeys("asa12345");
        WebElement ingresar = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[3]/button/span"));
        System.out.println("MENSAJE ANTES DEL WAIT");
        ingresar.click();
        //boolean expiro = driver.findElements(By.xpath("/html/body/div[2]/div/div[3]/button")).size() != 0;
        //WebElement rol = driver.findElement(By.xpath("/html/body/div/div/nav/section[3]/p[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/nav/section[3]/p[2]")));
        //Declare and initialise a fluent wait

        // thread.sleep(1000);
        //Specify the timout of the wait
        System.out.println("MENSAJE DESPUÉS DEL WAIT");
        WebElement rol = driver.findElement(By.xpath("/html/body/div/div/nav/section[3]/p[2]"));
        //wait.until(elementToBeClickable(rol));
        Assert.assertTrue("No estamos en el home page", rol.isDisplayed());
        boolean rol2 = driver.findElements(By.xpath("/html/body/div/div/nav/section[3]/p[2]")).size() != 0;
        if (!rol2){
        System.out.println("NO se encontró el rol");
        }
         else {System.out.println("SÍ TENEMOS el rol"+rol.getText());}
        Assert.assertEquals("Ejecutivo de cuentas", rol.getText());
    }

    @When("^create a flow Vivienda Nueva$")
    public void create_a_flow_Vivienda_Nueva(){
        System.out.println("Pasé por el When 2 OK");
    }

    @Then("^we have a new item in the inbox of Vivienda nueva$")
    public void we_have_a_new_item_in_the_inbox_of_Vivienda_nueva(){
        System.out.println("Pasé por el Then OK");
    }


}
