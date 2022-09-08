package site.stellarburgers.configuration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ListURL {
    public static final String burgerMainURL = "https://stellarburgers.nomoreparties.site/";
    public static final String burgerLoginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String burgerProfileURL = "https://stellarburgers.nomoreparties.site/account/profile";

    public static final RequestSpecification BurgerURL = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.nomoreparties.site")
            .build();
}