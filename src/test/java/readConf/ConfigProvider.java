package readConf;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    /**
     * Загрузка readConf-файла и получение значений из него
     */
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String MAIN_PAGE = readConfig().getString("testURLs.mainPageURL");
    String SPEECH_TEXT = readConfig().getString("testURLs.speechToTextURL");

    String FIRST_NAME = readConfig().getString("usersParams.firstName");
    String LAST_NAME = readConfig().getString("usersParams.lastName");
    Integer AGE = readConfig().getInt("usersParams.age");
    String EMAIL = readConfig().getString("usersParams.email");
    String PASSWORD = readConfig().getString("usersParams.password");
}