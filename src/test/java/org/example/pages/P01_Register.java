package org.example.pages;
import org.example.stepDefs.Hooks ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class P01_Register {
    public P01_Register()
    {
        PageFactory.initElements(Hooks.driver,this);
    }


    /**public void ProductListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }*/

    /*public WebElement registerlink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }*/

   /** **/
   @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
   public WebElement rbtn;

    @FindBy(id="gender-male")
    public WebElement male;
    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id="LastName")
    public WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    public WebElement dayList;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthList;

    @FindBy(name = "DateOfBirthYear")
    public WebElement yearList;

    @FindBy(id = "Email")
    public WebElement Email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindAll({
            @FindBy(id = "ConfirmPassword"),
            @FindBy(name = "ConfirmPassword")

    })
    public WebElement ConfirmPassword;



    @FindBy(how = How.ID, using = "register-button")
    public WebElement registerBtn;


    @FindBy(className = "result")
    public WebElement successMsg;
}