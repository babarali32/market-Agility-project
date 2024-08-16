package utils;

import Pages.AdminFuntionalityPage;
import Pages.LoginPage;

public class PageInitializers {

    public static LoginPage loginPage;

public static AdminFuntionalityPage adminFuntionalityPage;
    public static void initializePageObjects() {
        loginPage=new LoginPage();

        adminFuntionalityPage=new AdminFuntionalityPage();
    }
}
