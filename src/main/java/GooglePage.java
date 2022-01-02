import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {
    public static String googleUrl = "https://www.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private SelenideElement searchField;
    @FindBy(tagName = "h3")
    private SelenideElement searchWikiResult;
    @FindBy(xpath = "//*[@id='L2AGLb']")
    private SelenideElement CookiesAcceptButton;


    public void searchForWiki() {
        searchField.setValue("wikipedia.com").submit();
    }

    public WikiHomePage chooseWikiLink() {
        String resultText = searchWikiResult.getText();
        if (resultText.equals("Wikipedia")) {
            searchWikiResult.click();
        }
        return page(WikiHomePage.class);

    }

    public void acceptCookies() {
        if (CookiesAcceptButton.exists()) {
            CookiesAcceptButton.click();
        }
    }
}

