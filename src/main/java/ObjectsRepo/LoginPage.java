package ObjectsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   private WebDriver driver;

   public LoginPage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
   }

   @FindBy(id = "username")
   WebElement usernameField;

   @FindBy(id = "password")
   WebElement passwordField;

   @FindBy(id = "login")
   WebElement loginButton;

   public WebElement usernameField() {
      return usernameField;
   }

   public WebElement passwordField() {
      return passwordField;
   }

   public WebElement loginButton() {
      return loginButton;
   }
}
