package StepDefs;

import hookFiles.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pageObject.Selectors;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class mbIOStepDefinition {

    @Given("the user is on Mercedes-benz United Kingdom market")
    public void openWebsite() throws InterruptedException {
        hooks.driver.navigate().to("https://www.mercedes-benz.co.uk");
        hooks.driver.manage().window().maximize();
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getAgreeToAllButton());
    }

    @And("Under “Our Models” - Select “Model: Hatchbacks”")
    public void selectModelType() throws InterruptedException {
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getOurModelsItemButton());
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getHatchBackModel());
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getAClassModel());
    }

    @And("Mouse over the “A Class” model available and proceed to “Build your car”")
    public void buildCar() {
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getBuildYourCarButton());
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @And("Filter by Fuel type “Diesel”")
    public void selectFuelType() {
        ((JavascriptExecutor) hooks.driver).executeScript("window.scrollBy(0,600)", "");
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getFuelDropDownButton());
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].click();", Selectors.getFuelDieselButton());

        Actions action = new Actions(hooks.driver);
        action.sendKeys(Keys.ESCAPE);
    }

    @And("Take and save a screenshot of the results")
    public void takeAndSaveScreenshot() throws IOException {
        String fileName = System.getProperty("user.dir") + File.separator + "snapshots" + File.separator + "screenshot.png";
        //Taking full page screenshot using Ashot library and saving it on above path
        helpers.utility.takeScreenshot(fileName);
    }

    @When("Save the value “£” of the highest and lowest price results in a text file")
    public void savePriceValuesInTextFile() throws IOException {
        String priceValues = System.getProperty("user.dir") + File.separator + "PricesOfCars" + File.separator + "priceValues.txt";
        helpers.utility.deleteFileIfExists(priceValues);
        for (WebElement webElement : Selectors.getPriceValues()) {
            String priceValuesFromUi = webElement.getText();
            //Saving the values of the prices in a text file on the above mentioned path
            helpers.utility.writeToFile(priceValues, priceValuesFromUi);
        }
    }

    @Then("Validate A Class models price are between {int} and {int}")
    public void validatePriceLiesInRange(int min, int max) throws IOException {
        String priceValues = System.getProperty("user.dir") + File.separator + "PricesOfCars" + File.separator + "priceValues.txt";
        for (int i = 0; i < helpers.utility.minMaxValue(priceValues).size(); i++) {
            assertTrue(helpers.utility.minMaxValue(priceValues).get(i) > min);
            assertTrue(helpers.utility.minMaxValue(priceValues).get(i) < max);
        }
    }
}
