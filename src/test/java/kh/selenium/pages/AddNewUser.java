package kh.selenium.pages;

import kh.selenium.model.User;
import kh.selenium.pages.pages.TestBase;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 23.07.2015.
 */
public class AddNewUser extends TestBase{

    @Test
    public void addNewUserOk(){
        String username = "user" + System.currentTimeMillis();
        User user = new User()
                .setLogin(username)
                .setPassword("password")
                .setEmail(username + "@test.com");

        app.getUserHelper().loginAs(ADMIN);
        app.getUserHelper().createUser(user);
        app.getUserHelper().logout();
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user));
    }
}
