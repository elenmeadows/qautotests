package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    /**
     * Загрузка conf-файла и получение значений из него
     */
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String MAIN_PAGE = readConfig().getString("testURLs.mainPageURL");
    String LOGIN_PAGE = readConfig().getString("testURLs.loginPageURL");
    String PROFILE_PAGE = readConfig().getString("testURLs.profilePageURL");
    String SETTINGS_PAGE = readConfig().getString("testURLs.settingsPageURL");
    String SPEECH_TEXT = readConfig().getString("testURLs.speechToTextURL");

    String LOGIN = readConfig().getString("usersParams.login");
    String PASSWORD = readConfig().getString("usersParams.password");
    String NEW_PASSWORD = readConfig().getString("usersParams.newPassword");
}