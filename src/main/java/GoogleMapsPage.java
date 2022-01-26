import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Configuration;

public class GoogleMapsPage {
    public static String googleMapsUrl = "https://www.google.com/maps/";

    @FindBy(css = ".tactile-searchbox-input")
    private SelenideElement searchMapField;
//    @FindBy(css = "button[data-tooltip ='Copy address']")
//    private SelenideElement address;

    public void searchForCoordinates(String coordinates) {
        searchMapField.setValue(coordinates);
        $("#searchbox-searchbutton").click();
    }

    public SelenideElement getFoundedAddress() {
        return $("button[jsaction='pane.clickPhoneNumber']+*").should(Condition.exist);

    }

    public void ifSafari() {
        if (Configuration.browser.equals("safari")) {
            $("button[aria-label]")
                    .should(Condition.exist)
                    .click();
        }
    }

}
