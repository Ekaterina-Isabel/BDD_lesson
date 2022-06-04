package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        var verificatiobCode = DataHelper.getVerificationCodeFor(authInfo);
        var loginPage = new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(verificatiobCode);
//        var LoginPage = open("http://locaihost;9999", LoginPageV1.class);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
//        var LoginPage = open("http://locaihost;9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validaLogin(authInfo);
        var verificatiobCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificatiobCode);
    }
}
