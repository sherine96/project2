package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class P03_homePage {
    public P03_homePage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(id="customerCurrency")
    public WebElement currency;
    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/img")
    public WebElement sliderImg;
    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/a[1]")
    public WebElement slider2;

    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/a[2]")
    public WebElement slider1;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    public WebElement hoverComputers;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    public WebElement desktopsub;

    @FindBy(partialLinkText ="Facebook" )
    public WebElement facebook;

    @FindBy(partialLinkText ="Twitter" )
    public WebElement twitter;
    @FindBy(partialLinkText ="RSS" )
    public WebElement rss;
    @FindBy(partialLinkText ="YouTube" )
    public WebElement youtube;
    @FindBy(css = "p[class=\"content\"]")
    public WebElement msg;
    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement bar;
    @FindBy(css = "a[href=\"/wishlist\"]")
    public WebElement wishlistbtn;
    @FindBy(className ="qty-input" )
    public WebElement qty;
    @FindBy(xpath ="/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]" )
    public WebElement wishbtn;

    public List<WebElement> prices()
    {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    @FindBy(id="small-searchterms")
    public WebElement search;
    @FindBy(linkText = "Search")
    public WebElement sbtn;

    public List<WebElement> results()
    {
        return Hooks.driver.findElements(By.className("product-title"));
    }


}
