package com.wordpress.loginpage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WritePostPage {

    WebDriver driver;

    By post = By.xpath("//div[contains(text(),'Posts')]");
    By addpost = By.xpath("//a[@href='post-new.php']");
    By allpost =By.xpath("//a[contains(text(),'All Posts')]");
    By categories = By.xpath("//a[contains(text(),'Categories')]");
    By tags = By.xpath("//a[contains(text(),'Tags')]");
    By titleofpost=By.xpath("//*[@id=\"title-prompt-text\"]");
    By mediabutton=By.xpath("//*[@id=\"insert-media-button\"]");
    By tilecontent=By.xpath("/html");
    
    public WritePostPage(WebDriver driver)
        {
            this.driver = driver;
        }


    public void ClickOnPostButton(WebDriver driver){
        driver.findElement(post).click();
		
    }
   // WebDriverWait wait = new WebDriverWait(driver, 40);

    public String addpost(){
      //  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea.textarea-autosize.editor-title__input")));
        driver.findElement(addpost).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return null;
    }
    public String allpost(){
        driver.findElement(allpost).click();
		return null;
        
    }
    public String categories(){
        driver.findElement(categories).click();
		return null;
    }
    public String tags(){
       // WebElement elemen1t = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button.editor-publish-button.is-primary")));
        driver.findElement(tags).click();
		return null;

    }
    
    public String  titleofpost(String data) {
    	driver.findElement(titleofpost).sendKeys(data);
		return null;
    }
    public String mediabutton() {
    	driver.findElement(mediabutton).click();
		return null;
    }
    public String tilecontent() {
    	driver.findElement(tilecontent).click();
		return null;
    }
   
   

}