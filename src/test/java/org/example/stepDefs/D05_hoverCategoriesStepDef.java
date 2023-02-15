package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class D05_hoverCategoriesStepDef {
    String text="";
    P03_homePage h = new P03_homePage();

    @When("User hovers over computers main categories")
    public void user_hovers_over_computers_main_categories() {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(h.hoverComputers).perform();



    }
    @When("user hovers over desktops subcategories")
    public void user_hovers_over_desktops_subcategories() {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(h.desktopsub).perform();
    }
    @When("get sub categories text and click")
    public void get_sub_categories_text_and_click() {
        text=h.desktopsub.getText().trim();
        h.desktopsub.click();


    }
    @Then("compare text and title page")
    public void compare_text_and_title_page() {
        Assert.assertEquals(text.toLowerCase(),Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText().toLowerCase().trim());
    }

}
