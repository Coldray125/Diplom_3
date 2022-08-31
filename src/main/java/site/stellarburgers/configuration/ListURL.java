package site.stellarburgers.configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public interface ListURL {
    public static final String burgerMainURL = "https://stellarburgers.nomoreparties.site/";
    public static final String burgerLoginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String burgerProfileURL = "https://stellarburgers.nomoreparties.site/account/profile";

    RequestSpecification BurgerURL = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.nomoreparties.site")
            .build();
}