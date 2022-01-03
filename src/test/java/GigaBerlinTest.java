import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;

import java.util.Objects;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GigaBerlinTest {

    @Test
    public void wikiGigaBerlinTest() {
        //1 . Open Google page
        GooglePage googlePage = open(GooglePage.googleUrl, GooglePage.class);

        //2. Accept Cookies
        googlePage.acceptCookies();

        //3. Click on search field and insert a search query
        googlePage.searchForWiki();

        //4. Click on Wikipedia link from search result list
        WikiHomePage wikiHomePage = googlePage.chooseWikiLink();

        //5. Assert that the page found is Wikipedia
        wikiHomePage.getWikiName().shouldHave(text("Wikipedia"));

        //6. Click on search field Wiki and insert a search query
        WikiGigaBerlinPage wikiGigaBerlinPage = wikiHomePage.searchForGigaBerlin();

        //7. Assert that the page has logistics and site concerns
        ElementsCollection pageHeaders = wikiGigaBerlinPage.getArticleHeaders();
        pageHeaders.shouldHave(size(2));

        //8. Found and save coordinates
        String coordinates = wikiGigaBerlinPage.getCoordinates();

        //9. Open new tab with Google Maps
        WebDriverRunner.getWebDriver().switchTo().newWindow(WindowType.TAB);
        GoogleMapsPage googleMapsPage = open(GoogleMapsPage.googleMapsUrl, GoogleMapsPage.class);
        if (Configuration.browser.equals("safari")) {
            googleMapsPage.acceptMapCookies();
        }

        //10. Search for saved coordinates
        googleMapsPage.searchForCoordinates(coordinates);

        //11. Assert that coordinates founded match the point address
        googleMapsPage.getFoundedAddress().shouldHave(text(WikiGigaBerlinPage.GigaBerlinAddress));

    }
}

