package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderHireLogic {

    @DataProvider(name = "position")
    public Object[][] providePositionsName() {
        return new Object[][]{
                {"Sample Position"}, {"Trainee Position"}, {"Test Position"},
        };
    }
    @DataProvider
    public Object[][] provideCandidateName() {
        return new Object[][]{
                {"John"}, {"Grace"}, {"Meridith Grey"}, {"Stephen"}
        };
    }



}
