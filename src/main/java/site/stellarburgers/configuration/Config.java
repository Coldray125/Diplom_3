package site.stellarburgers.configuration;

import com.codeborne.selenide.Configuration;

public class Config {
    public void chrome() {
        Configuration.headless = true;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    public void firefox() {
        Configuration.headless = true;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
    }
}