package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        // sleep(2);
        
        // WebElement element = driver.findElement(By.linkText("login"));
        // element.click();

        // sleep(2);

        // element = driver.findElement(By.name("username"));
        // element.sendKeys("pekka");
        // element = driver.findElement(By.name("password"));
        // element.sendKeys("akkep");
        // element = driver.findElement(By.name("login"));
        
        // sleep(2);
        // element.submit();

        // sleep(3);

        // Failed logging in: correct user, wrong password
        // sleep(2);
        
        // WebElement element = driver.findElement(By.linkText("login"));
        // element.click();

        // sleep(2);

        // element = driver.findElement(By.name("username"));
        // element.sendKeys("pekka");
        // element = driver.findElement(By.name("password"));
        // element.sendKeys("wrong");
        // element = driver.findElement(By.name("login"));
        
        // sleep(2);
        // element.submit();

        // sleep(3);

        // Creating a new user
        // sleep(2);
        
        // WebElement element = driver.findElement(By.linkText("register new user"));
        // element.click();

        // sleep(2);

        // element = driver.findElement(By.name("username"));
        // element.sendKeys("new");
        // element = driver.findElement(By.name("password"));
        // element.sendKeys("test");
        // element = driver.findElement(By.name("passwordConfirmation"));
        // element.sendKeys("test");
        // element = driver.findElement(By.name("signup"));
        
        // sleep(2);
        // element.submit();

        // sleep(3);

        // Logging out after successfully creating a user
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("another");
        element = driver.findElement(By.name("password"));
        element.sendKeys("test");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("test");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
