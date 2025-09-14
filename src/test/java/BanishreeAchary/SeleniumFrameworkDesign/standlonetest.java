package BanishreeAchary.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class standlonetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String productname ="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
				
				WebDriver driver ;
				driver= new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofNanos(10));
				driver.get("https://rahulshettyacademy.com/client");
				driver.findElement(By.id("userEmail")).sendKeys("banishree_achary@yahoo.co.in");
				driver.findElement(By.id("userPassword")).sendKeys("Banishree23");
			//	driver.findElement(By.className("btn btn-block login-btn")).click();
				driver.findElement(By.name("login")).click();
				driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				List<WebElement>  products =driver.findElements(By.cssSelector(".mb-3"));
				
			//	products.forEach(System.out::println);
				
		        for (WebElement webElement : products) {
		            String name = webElement.getText();
		            System.out.println(name);
		        }


				
    WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText()
	.equals(productname)).findFirst().orElse(null);
    //prod.findElement(By.xpath("//div[@class='card-body']//button[2]")).click();
    
    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    
   // driver.findElement(By.)
    
    
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
   
    		
    		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector(".ng-animating"))));		
//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    		System.out.println("clicked");
    		
    List<WebElement>  cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
    
  for(WebElement g1:cartProducts) {
	  
   	System.out.println(g1.getText());
   	
   	
  }
  
 // JavascriptExecutor =
  
  System.out.println("scrolled");
	//  driver.findElement(By.cssSelector(".totalRow button")).click();
driver.findElement(By.xpath("//div[@class=\"subtotal cf ng-star-inserted\"]//ul//li[@class=\"totalRow\"] //button[@class=\"btn btn-primary\" and  text()='Checkout']")).click();
System.out.println("click checkout");

    
    
  // Stream<WebElement> v =  cartProducts.stream().filter(cartProduct-> cartProduct.getText().equalsIgnoreCase(productname));
	
   //Boolean match =v;
 //   Stream<WebElement> v =  cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productname));
	Boolean match =cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productname));
	//System.out.println(cartProduct);
System.out.println(match);
Assert.assertTrue(match);
driver.findElement(By.cssSelector(".totalRow button")).click();
//driver.findElement(By.cssSelector(".totalRow btn btn-primary")).click();
System.out.println("clicked");

driver.close();
System.out.println("closed");
	}
}

//div[@class="card-body"]/button/i[@class="fa fa-shopping-cart"]
	
	


