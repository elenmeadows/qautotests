import org.junit.Test;

public class AppleTest extends BaseTest {

    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";

    @Test
    public void checkHref() {
        MainPage mainPage = new MainPage();
        mainPage.openWebSite(BASE_URL);
        int a = 0;
    }
}
