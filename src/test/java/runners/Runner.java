package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",}, //html:target/cucumber-reports/regression.html (raporlama icin bu plugin kullanilacak **)
        features = "src/test/resources/Features",
        glue = "stepDefinitions",
        tags = "@apk",
        dryRun = false
)

public class Runner {
}

/*
** raporlamayi gormek icin:
* targets -->  cucumber-reports --> regression.html
* Open In --> Browser --> Chrome
*/
