package changePasswordWithCaptcha;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.TimeoutException;
import core.BaseTest;
import org.junit.Test;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void changePassword() throws InterruptedException {
        MainPage mainPage = new MainPage();
//        try {
//            mainPage = new MainPage();
//        } catch (org.openqa.selenium.TimeoutException ignore) {
//            try {
//                System.out.println("pizdec #1");
//                mainPage = new MainPage();
//            } catch (org.openqa.selenium.TimeoutException ignore2) {
//                try {
//                    System.out.println("pizdec #2");
//                    mainPage = new MainPage();
//                } catch (org.openqa.selenium.TimeoutException ignore3) {
//                    System.out.println("pizdec #3");
//                    mainPage = new MainPage();
//                }
//            }
//        }

        mainPage.loginButton();

        Thread.sleep(2000);
        int one = 1;
    }
}
