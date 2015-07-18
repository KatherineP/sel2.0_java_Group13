package kh.selenium.applogic1;

import kh.selenium.applogic.UserHelper;
import kh.selenium.model.User;
import kh.selenium.pages.UserProfilePage;

public class UserHelper1 extends DriverBasedHelper implements UserHelper {

  public UserHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

    @Override
    public void loginAs(User user) {
        pages.loginPage.ensurePageLoaded()
                .setUsernameField(user.getLogin())
                .setPasswordField(user.getPassword())
                .clickSubmitButton();
    }

  @Override
  public void logout() {
    pages.internalPage
      .clickLogoutLink();
  }

  @Override
  public boolean isLoggedIn() {
    return pages.internalPage.waitPageLoaded();
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn()
        && getLoggedUser().getLogin().equals(user.getLogin());
  }

  @Override
  public boolean isNotLoggedIn() {
    return pages.loginPage.waitPageLoaded();
  }
  
  private User getLoggedUser() {
    UserProfilePage userProfile = pages.internalPage
      .clickUserProfilePage()
      .ensurePageLoaded();
    return new User()
      .setLogin(userProfile.getUsername())
      .setEmail(userProfile.getEmail())
      .setRole(userProfile.getRole());
  }

}
