package rervice;

import model.Card;
import model.User;

public class UserCreator {
    protected static final String userName = "testdata.user.name";
    protected static final String userPassword = "testdata.user.password";
    protected static final String userSurname = "testdata.user.surname";
    protected static final String faberlicMoney = "testdata.user.faberlicMoney";
    protected static final String email = "testdata.user.email";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getUser(userName),
                        TestDataReader.getUser(userPassword),
                        TestDataReader.getUser(userSurname),
                        TestDataReader.getUser(faberlicMoney));
    }

    public static User withCard(Card card){
        return new User(TestDataReader.getUser(userName),
                TestDataReader.getUser(userPassword),
                TestDataReader.getUser(userSurname),
                TestDataReader.getUser(faberlicMoney),
                card,
                TestDataReader.getUser(email));
    }
}
