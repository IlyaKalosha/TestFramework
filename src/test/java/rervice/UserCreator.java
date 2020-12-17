package rervice;

import model.User;

public class UserCreator {
    protected static final String userName = "testdata.user.name";
    protected static final String userPassword = "testdata.user.password";
    protected static final String userSurname = "testdata.user.surname";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getUser(userName),
                        TestDataReader.getUser(userPassword),
                        TestDataReader.getUser(userSurname));
    }
}
