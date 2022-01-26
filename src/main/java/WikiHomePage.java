import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class WikiHomePage {
    @FindBy(css = "[id=searchInput]")
    private SelenideElement searchFieldWiki;
    @FindBy(css = ".central-textlogo")
    private SelenideElement wikiName;


    public WikiGigaBerlinPage searchForGigaBerlin() {
        searchFieldWiki.setValue("Giga Berlin").submit();
        return page(WikiGigaBerlinPage.class);
    }

    public SelenideElement getWikiName() {
        return wikiName;
    }
}
