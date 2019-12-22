package project.auto.test.tests;

import org.junit.Before;
import org.junit.Test;
import project.auto.test.core.homePage.HomePage;
import project.auto.test.core.loginPage.LoginPage;
import project.auto.test.model.TestBot;

public class LikePhoto extends TwoBotsBase {
    private HomePage homeBot1;
    private HomePage homeBot2;
    private TestBot bot1 = new TestBot("TechoBot15", "TechnoPolis19");
    private TestBot bot2 = new TestBot("TechoBot7", "TechnoPolis19");

//    @Before
    public void login(){
        homeBot1 = new LoginPage(driver1)
                .doLogin(bot1);
        homeBot2 = new LoginPage(driver2)
                .doLogin(bot2);
    }

//    @Test
    public void likeUserAvatar(){
//        homeBot2.
    }

}
