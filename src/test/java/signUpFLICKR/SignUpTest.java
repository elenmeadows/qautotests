package signUpFLICKR;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import readConf.ConfigProvider;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.FileFilters.withExtension;

public class SignUpTest extends BaseTest {
    private final SelenideElement signUpButton = $x("//a[@data-link-id='globalnav_signup_button']");

    SelenideElement firstName = $x("//input[@data-testid='identity-first-name-input']");
    SelenideElement lastName = $x("//input[@data-testid='identity-last-name-input']");
    SelenideElement age = $x("//input[@data-testid='no-test-id-given']");
    SelenideElement email = $x("//input[@data-testid='identity-email-input']");
    SelenideElement password = $x("//input[@data-testid='identity-password-input']");
    SelenideElement captchaCheckbox = $x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]");
    SelenideElement audioButton = $x("//iframe[starts-with(@name, 'c-') and starts-with(@src, 'https://www.google.com/recaptcha')]");
    SelenideElement downloadAudio = $x("//a[@class='rc-audiochallenge-tdownload-link']");
    SelenideElement uploadAudio = $x("//input[@type='file']");
    SelenideElement audioResponse = $x("//input[@id='audio-response']");

    @Test
    public void signUp() throws InterruptedException, FileNotFoundException {
        Selenide.open(ConfigProvider.MAIN_PAGE);
        signUpButton.click();
        Thread.sleep(10000);
        firstName.sendKeys(ConfigProvider.FIRST_NAME);
        lastName.sendKeys(ConfigProvider.LAST_NAME);
        age.sendKeys(String.valueOf(ConfigProvider.AGE));
        email.sendKeys(ConfigProvider.EMAIL);
        password.sendKeys(ConfigProvider.PASSWORD);

        switchTo().frame(captchaCheckbox);
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();
        switchTo().frame(audioButton);
        $("div.button-holder.audio-button-holder").click();
        switchTo().defaultContent();
        switchTo().frame(audioButton);
        File file = downloadAudio.download();

        Selenide.executeJavaScript("window.open();");
        Selenide.switchTo().window(1);
        Selenide.open(ConfigProvider.SPEECH_TEXT);
        Thread.sleep(2000);
        uploadAudio.uploadFile(file);
        Thread.sleep(7000);
        String result = $("div.tab-panels--tab-content").getText();
        System.out.println(result);

        Selenide.switchTo().window(0);
        switchTo().defaultContent();
        switchTo().frame(audioButton);
        audioResponse.sendKeys(result, Keys.ENTER);

        Thread.sleep(10000);
        int one = 1;
    }
}
