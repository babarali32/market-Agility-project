package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void precondition() {
        openBrowserAndLaunchApplication();

    }

    @After
    public void postCondition() throws Exception {
        closeBrowser();
    }
}

