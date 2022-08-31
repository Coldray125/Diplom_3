package site.stellarburgers.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static site.stellarburgers.configuration.EndPointList.USER_CREATE;
import static site.stellarburgers.configuration.ListURL.BurgerURL;

public class PostCreateUser {

    @Step("Отправка запроса на endpoint POST /api/auth/register для создания учетной записи пользователя")
    public Response UserCreate(Object object) {
        return given()
                .spec(BurgerURL)
                .header("Content-type", "application/json")
                .body(object)
                .when()
                .post(USER_CREATE)
                .then()
                .statusCode(SC_OK)
                .extract()
                .response();
    }
}
