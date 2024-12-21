package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/scenarios.feature"}, glue = {"utils", "steps"}, plugin = {"pretty"})

public class CucumberRunnerTest {

}