package resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay
 */
public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getCredential() {
        Object[][] data = new Object[][]{
                {" ", " ", "Required"},
                {"test123@gmail.com", " ", "Required"},
                {" ", "test123", "Required"}

        };
        return data;
    }

    @DataProvider(name = "Invalid Input")
    public Object[][] getErrorMessage() {
        Object[][] data = new Object[][]{
                {"test123@gmail.com", "test123", "Invalid credentials"}
        };
        return data;
    }


    @DataProvider(name = "Data Set")
    public Object[][] getData() {
        Object[][] data = new Object[][]{

                {"Admin", "Admin", "Paul Collings", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enable"}
        };
        return data;
    }
}
