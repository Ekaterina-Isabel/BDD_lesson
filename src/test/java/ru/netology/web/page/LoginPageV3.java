package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.page;

//классический вариант, когда не было Selenide, включает в себя Page Factory
//меняется процесс инициализации элементов, запускается инициализация полей и запись их по локатору
//причина использования этого варианта - есть некоторые фреймворки, которые основаны на идее "фабрики страниц"
public class LoginPageV3 {
    @FindBy(css = "[data-test-id=login] input")
    private SelenideElement loginField;
    @FindBy(css = "[data-test-id=password] input")
    private SelenideElement passwordField;
    @FindBy(css = "[data-test-id=action-login]")
    private SelenideElement loginButton;

    public VerificationPage validaLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        //создание нового экземпляра класса VerificationPage
        // и если там есть приватные поля, помеченные FindBy, то он их инициализирует
        return page(VerificationPage.class);
    }
}
