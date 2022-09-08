package site.stellarburgers.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static site.stellarburgers.configuration.EndPointList.USER_AUTH;
import static site.stellarburgers.configuration.ListURL.BurgerURL;

public class PostAuthUser {

    @Step("Отправка запроса на endpoint POST /api/auth/login для авторизации учетной записи пользователя")
    public Response AuthUserResponse(Object object) {
        return given()
                .spec(BurgerURL)
                .header("Content-type", "application/json")
                .body(object)
                .post(USER_AUTH)
                .then()
                .extract()
                .response();
    }
}