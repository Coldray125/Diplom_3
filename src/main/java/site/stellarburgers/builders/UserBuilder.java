package site.stellarburgers.builders;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import site.stellarburgers.pojo.request.AuthUserRequest;
import site.stellarburgers.pojo.request.CreateUserRequest;
import site.stellarburgers.requests.PostAuthUser;
import site.stellarburgers.requests.DeleteUser;
import site.stellarburgers.requests.PostCreateUser;

import java.util.HashMap;

public class UserBuilder {

    @Step("Создание учетной записи пользователя с генерированным учетными данными через запрос POST /api/auth/register")
    public String createRandomUserReturnToken(HashMap <String,String> data) {
      Response response = new PostCreateUser().UserCreate(new CreateUserRequest(data.get("email"), data.get("password"), data.get("name")));
         JsonPath js = new JsonPath(response.getBody().asString());
        return js.getString("accessToken");
    }

    @Step("Удаление пользователя через запрос Delete /api/auth/user c использованием Access Token")
    public void deleteUserWithAccessToken(String token) {
        new DeleteUser().UserDelete(token);
    }

    @Step("Авторизация пользователя через запрос POST /api/auth/login")
    public String AuthUserGetToken(HashMap<String, String> data) {
        Response response = new PostAuthUser().AuthUserResponse(new AuthUserRequest(data.get("email"), data.get("password"), data.get("name")));
        JsonPath js = new JsonPath(response.getBody().asString());
        return js.getString("accessToken");
    }
}