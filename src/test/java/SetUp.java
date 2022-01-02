import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SetUp {
    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) {
        Configuration.timeout = 20000;
        System.setProperty("selenide.browser", browser);
        Configuration.browser = browser;
    }
    @AfterTest
    public void quitBrowser(){
        Selenide.closeWebDriver();
    }
}