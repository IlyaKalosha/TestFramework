package Service;

import model.User;

public class UserCreator {
    protected static final String UserName = "testdata.user.name";
    protected static final String UserPassword = "testdata.user.password";
    protected static final String UserSurname = "testdata.user.surname";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getUser(UserName),
                        TestDataReader.getUser(UserPassword),
                        TestDataReader.getUser(UserSurname));
    }
}
