package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;


public class P02_Login extends Hooks{


    public P02_Login()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    public WebElement logbtn;

    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(className = "button-1 login-button")
    public WebElement loginbtn;

    @FindBy(className = "ico-account")
    public WebElement account;

    @FindBy(className = "message-error validation-summary-errors")
    public WebElement errMsg;
}
