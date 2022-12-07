import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AuthPage;

import java.util.stream.Stream;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("yryry_21")
@Feature("Авторизация")
public class AuthTest {
    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name ="{displayName} {0}" )
    @DisplayName("Авторизация с неккоректными данными:")
    public void  shoudntAuthorizeTest(String type, String email, String password){
        step("Открыть  страницу", () -> {
            open("https://automationexercise.com/login");
        });
        step("Заполнить импуты логина и пароля", () -> {
            AuthPage.loginInput()
                .sendKeys(email);
            AuthPage.passwordInput()
                .sendKeys(password);
        });
        step("Нажать кнопку login", () -> {
            AuthPage.loginButton()
                .click();
        });
        step("Проверить, что авторизация не прошла", () -> {
            AuthPage.TextAuth()
                .shouldBe(Condition.visible);
        });
    }
    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments("зарегистрированный емейл и неправильный пароль", "marisha2112@bk.ru", "123456789Qq"),
                arguments("незарегистрированный емейл и правильный пароль", "nemarisha2112@bk.ru","123456789Qq"),
                arguments("незарегистрированный емейл и неправильный пароль", "nemarisha2112@bk.ru", "123456789Q")
        );
    }

}
