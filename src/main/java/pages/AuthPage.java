package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    public static SelenideElement loginInput() {
        return $("[data-qa='login-email']").as("Поле логина");
    }

    public static SelenideElement passwordInput() {
        return $("[data-qa='login-password']").as("Поле логина");
    }

    public static SelenideElement loginButton() {
        return $("[data-qa='login-button']").as("Кнопка логин");
    }

    public static SelenideElement TextAuth() {
        return $(byText("Your email or password is incorrect!")).as("Текст авторизация не прошла");
    }
}
