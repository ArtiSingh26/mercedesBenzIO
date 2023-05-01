package pageObject;

import hookFiles.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Selectors {

     private static final By agreeToAllShadowHost = By.cssSelector("cmm-cookie-banner[settings-id='fph8XBqir']");
     private static final By agreeToAllButton = By.cssSelector("div > div > div.cmm-cookie-banner__content > cmm-buttons-wrapper > div > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all");
     private static final By ourModelsItemsShadowHost = By.cssSelector("body > div.root.responsivegrid.owc-content-container > div > owc-header");
     private static final By OurModelsItemsButton = By.cssSelector("header > div > nav.owc-header__header-navigation > div > ul > li.owc-header-navigation-topic.owc-header-navigation-topic--desktop-nav.owc-header-navigation-topic__model-flyout > button");
     private static final By hatchBackModelShadowHost = By.cssSelector("body > div.root.responsivegrid.owc-content-container > div > owc-header > vmos-flyout");
     private static final By hatchBackModelButton = By.cssSelector("#app-vue > div > ul > li:nth-child(3) > ul > li:nth-child(4) > div");
     private static final By aClassModelButton = By.cssSelector("#app-vue > div > owc-header-flyout > ul > li > ul > li:nth-child(1) > a");
     private static final By buildYouCarShadowHost = By.cssSelector("owc-stage[component-id='cea4a4a51557a29073a51c4f3fc4d9e3']");
     private static final By buildYourCarButton = By.cssSelector("div > div.owc-stage__content-wrapper > div > div.owc-stage__cta-wrapper.wb-grid-row > div > div > a.owc-stage-cta-buttons__button.wb-button.wb-button--medium.wb-button--theme-dark.wb-button--large.wb-button--secondary.owc-stage-cta-buttons__button--secondary");
     private static final By fuelDropdownShadowHost = By.cssSelector("owcc-car-configurator[component-id='8f90efb9b25acd626539281bf797a113']");
     private static final By fuelDropDownShadowContent = By.cssSelector("#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div > div.cc-motorization-filters-form__primary > div > cc-motorization-filters-primary-filters > div > fieldset > div > ccwb-multi-select");
     private static final By fuelTypeShadowHost = By.xpath("//*[@component-id='8f90efb9b25acd626539281bf797a113']");
     private static final By fuelTypeShadowContent = By.cssSelector("#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div >div > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div >div.cc-motorization-filters-form__primary > div > cc-motorization-filters-primary-filters > div > fieldset > div > ccwb-multi-select> ccwb-checkbox");
     private static final By fuelTypeButton = By.cssSelector("input[name='Diesel']");
     private static final By priceValuesShadowHost = By.xpath("//*[@component-id='8f90efb9b25acd626539281bf797a113']");
     private static final By priceValues = By.cssSelector("#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div > cc-motorization > cc-motorization-comparison > div > div > div > ccwb-card > div.cc-motorization-comparison-header-wrapper > cc-motorization-header > div > div > ccwb-text");

     public static WebElement getAgreeToAllButton(){
        WebElement shadowHost = hooks.driver.findElement(agreeToAllShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(agreeToAllButton);
        return shadowContent;
    }

    public static WebElement getOurModelsItemButton(){
        WebElement shadowHost = hooks.driver.findElement(ourModelsItemsShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(OurModelsItemsButton);
        return shadowContent;
    }

    public static WebElement getHatchBackModel(){
        WebElement shadowHost = hooks.driver.findElement(hatchBackModelShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(hatchBackModelButton);
        return shadowContent;
    }

    public static WebElement getAClassModel(){
        WebElement shadowHost = hooks.driver.findElement(hatchBackModelShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(aClassModelButton);
        return shadowContent;
    }

    public static WebElement getBuildYourCarButton(){
        WebElement shadowHost = hooks.driver.findElement(buildYouCarShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(buildYourCarButton);
        return shadowContent;
    }

    public static WebElement getFuelDropDownButton() {
        WebElement shadowHost = hooks.driver.findElement(fuelDropdownShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(fuelDropDownShadowContent);
        return shadowContent;
    }

    public static WebElement getFuelDieselButton(){
        WebElement shadowHost = hooks.driver.findElement(fuelTypeShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(fuelTypeShadowContent);
        SearchContext shadowRootNew = shadowContent.getShadowRoot();
        WebElement fuelType = shadowRootNew.findElement(fuelTypeButton);
        return fuelType;
    }

    public static List<WebElement> getPriceValues(){
        WebElement shadowHost = hooks.driver.findElement(priceValuesShadowHost);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        List<WebElement> shadowContent = shadowRoot.findElements(priceValues);
        return shadowContent;
    }
}
