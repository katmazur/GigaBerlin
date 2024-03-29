import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class WikiGigaBerlinPage {
    public static String GigaBerlinAddress = "Grünheide, 15537 Grünheide (Mark)";

    @FindBy(css = "#Site_description, #Logistics")
    private ElementsCollection articleHeaders;

    @FindBy(css = "span.geo-dec")
    private SelenideElement coordinates;

    public String getCoordinates() {
        return coordinates.getText();
    }

    public ElementsCollection getArticleHeaders() {
        return articleHeaders;
    }

}

