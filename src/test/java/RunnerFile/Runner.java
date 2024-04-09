package RunnerFile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src\\test\\feature\\Assignment4.feature" ,
        glue = "StepDef" ,
        //tags="@assignment1",   //to add multiple tags"" or "",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"}
)

public class Runner
{

}
