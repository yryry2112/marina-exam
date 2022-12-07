package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement productsName() {
        return $(byText("Rs. 500")).as("Карточка");
    }
    public static SelenideElement addButton() {
        return $(".overlay-content a[data-product-id='1']").as("Кнопка добавления в корзину");
    }

    public static SelenideElement modalAdd() {
        return $(".modal-content").as("Модалка добавлении товара в корзину");
    }
    public static SelenideElement cartButton() {
        return $(byText("View Cart")).as("Кнопка перехода в корзину");
    }
    public static SelenideElement cart() {
        return $(byText("Blue Top")).as("Товар в корзине");
    }

}
