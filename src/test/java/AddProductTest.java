import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
@Owner("yryry_2112")
@Feature("Добавление товара в корзину")
public class AddProductTest {
    @Test
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void addProduct() {
        step("Открыть  страницу", () -> {
            open("https://automationexercise.com/");
        });
        step("Навести курсор на товар", () -> {
            MainPage.productsName()
                    .hover();
        });
        step("Нажать на кнопку 'Add to cart'", () -> {
            MainPage.addButton()
                    .click();
        });
        step("Проверить, что появилась модалка с успешным добавлением в корзину", () -> {
            MainPage.modalAdd()
                .shouldBe(Condition.visible);
        });
        step("Зайти в корзину и убедиться, что товар добавлен", () -> {
            MainPage.cartButton()
                    .click();
            MainPage.cart()
                .shouldBe(Condition.visible);

        });
        }

}


