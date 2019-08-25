package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/features", glue="seleniumgluecode")
public class RunTest {
public static  WebDriver driver;
private TestNGCucumberRunner testNGCucumberRunner;

public static WebDriver getDriver()
{
	return driver;
}
@BeforeClass(alwaysRun=true)
public void setUpClass(){
testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
}
@AfterClass(alwaysRun = true)
public void tearDownClass() throws Exception {
    testNGCucumberRunner.finish();
}
@DataProvider
public Object[][] features() {
    return testNGCucumberRunner.provideFeatures();
}
@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
    testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
}

}
