package by.uladzimirmakei.automation.service;

import by.uladzimirmakei.automation.model.User;

public class UserCreator {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserCreator() {
    }

    public static User withCredentialFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyName() {
        return new User("", TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(TESTDATA_USER_NAME, "");
    }
}
