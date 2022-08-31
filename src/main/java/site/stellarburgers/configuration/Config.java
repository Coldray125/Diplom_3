package site.stellarburgers.configuration;

import com.codeborne.selenide.Configuration;

public class Config {
    public void chrome() {
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    public void firefox() {
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
        Configuration.browser = "firefox";
    }
}