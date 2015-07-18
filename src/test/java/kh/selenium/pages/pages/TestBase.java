package kh.selenium.pages.pages;

import kh.selenium.applogic1.ApplicationManager1;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import kh.selenium.applogic.ApplicationManager;

public class TestBase {

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
