package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenu;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNotebooksText;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;


    public void selectMenu(String menu) {
        CustomListeners.test.log(Status.PASS, "topMenu");
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By) topMenu);
        }
    }

    public void mouseHoverOnDesktopLinkAndClick() {
        CustomListeners.test.log(Status.PASS, "mouse hover on desktop link and click");
        mouseHoverToElementAndClick(desktopsLink);
    }

    public String getDesktopsText() {
        CustomListeners.test.log(Status.PASS, "get desktop text");
        return getTextFromElement(desktopsText);
    }

    public void mouseHoverOnLaptopAndNotebooksLinkAndClick() {
        CustomListeners.test.log(Status.PASS, "mouse hover on laptop and notebooks link and click");
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public String getLaptopsAndNotebooksText() {
        CustomListeners.test.log(Status.PASS, "get laptops and notebooks text");
        return getTextFromElement(laptopAndNotebooksText);
    }

    public void mouseHoverOnComponentsLinkAndClick() {
        CustomListeners.test.log(Status.PASS, "mouse hover on components link and click");
        mouseHoverToElementAndClick(componentsLink);
    }

    public String getComponentsText() {
        CustomListeners.test.log(Status.PASS, "get components text");
        return getTextFromElement(componentsText);
    }

}
