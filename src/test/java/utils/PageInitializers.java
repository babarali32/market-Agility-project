package utils;

import Pages.LoginPage;

public class PageInitializers {

    public static LoginPage loginPage;


    public static void initializePageObjects() {
        loginPage=new LoginPage();
    }
}
