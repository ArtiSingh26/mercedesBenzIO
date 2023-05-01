package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/Features/mbIO.feature"},
        glue = {"StepDefs","hookFiles"},
        plugin = {"pretty"}
)
public class testRunner{
}
