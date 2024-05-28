package uni.pu.fmi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features="src/test/resources/uni.pu.fmi.trendyOutfitView", plugin ={"pretty", "html:target/report.html"} )
public class TrendyOutfitStarter {
}
