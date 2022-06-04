package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.LoginPageV2;
import ru.netology.web.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var loginPage = new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(verificationCode);
//        var LoginPage = open("http://locaihost;9999", LoginPageV1.class);
    }

    //тест для первого и второго варианта выглядят одинаково
    //в Selenide инициализация полей происходит только при установке значений.
    // Пока мы ничего не хотим установить в поля, Selenide эти поля по локаторам не ищет
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
//        var LoginPage = open("http://locaihost;9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validaLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    //инициализация полей происходит уже при открытии сайта по URL
    //"фабричные методы" - паттерн, в который мы передем описание того, что хотим получить,
    // либо неинициализированный класс, который хотим инициализировать (Н: методы open, page)
    @Test
    void shouldTransferMoneyBetweenOwnCardsV3() {
        //нужно прогонять класс через "фабрику элементов", которая его наполнит
        var loginPage = open("http://localhost:9999", LoginPageV3.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validaLogin(authInfo);
//        var LoginPage = open("http://locaihost;9999", LoginPageV2.class);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }
}
