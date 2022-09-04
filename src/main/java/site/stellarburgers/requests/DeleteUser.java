package site.stellarburgers.requests;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static site.stellarburgers.configuration.EndPointList.USER_INFO;
import static site.stellarburgers.configuration.ListURL.BurgerURL;

public class DeleteUser {

    @Step("Отправка запроса на endpoint DELETE /api/auth/login для удаления учетной записи пользователя")
    public void UserDelete(String accessToken) {
        given()
                .spec(BurgerURL)
                .header("Authorization", accessToken)
                .when()
                .delete(USER_INFO)
                .then()
                .statusCode(SC_ACCEPTED);
    }
}