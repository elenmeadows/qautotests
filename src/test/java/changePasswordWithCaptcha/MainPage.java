package changePasswordWithCaptcha;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import readProperties.ConfigProvider;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
        private final SelenideElement loginButton = $(byXpath("//a[@class='site-auth-control']"));

    /**
     * Открывается главная страница сайта
     * last.fm
     */
    public MainPage() {
        Selenide.open(ConfigProvider.MAIN_PAGE);
    }

    public void loginButton() {
        loginButton.click();
    }
}
