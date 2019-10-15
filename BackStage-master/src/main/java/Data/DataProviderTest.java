package Data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name="user")
    public Object[][] Users(){
        return new Object[][]{
                {"18827040216","123456"},
                //{"cnblogs.com", "tankxiao"},
                //{"tank","xiao"}
        };
    }

    @Test(dataProvider="user")
    public void verifyUser(String userName, String password){
        System.out.println("Username: "+ userName + " Password: "+ password);
    }
}
