package kh.selenium.pages.pages;

import kh.selenium.applogic1.ApplicationManager1;
import kh.selenium.model.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import kh.selenium.applogic.ApplicationManager;

public class TestBase {

    public static User ADMIN = new User().setLogin("admin").setPassword("admin");
  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}

    @AfterSuite
    public void stop(){
        app.stop();
    }
}
