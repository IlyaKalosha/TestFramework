package Service;

import model.User;

public class UserCreator {
    protected static final String UserName = "testdata.user.name";
    protected static final String UserPassword = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getUser(UserName),TestDataReader.getUser(UserPassword));
    }

    public static User withEmptyUsername(){
        return new User("",TestDataReader.getUser(UserPassword));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getUser(UserName),"");
    }
}
