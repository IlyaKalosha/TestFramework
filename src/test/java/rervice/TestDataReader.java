package rervice;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle item = ResourceBundle.getBundle(System.getProperty("item"));
    private static final ResourceBundle user = ResourceBundle.getBundle(System.getProperty("user"));
    private static final ResourceBundle page = ResourceBundle.getBundle(System.getProperty("page"));
    private static final ResourceBundle searchStatement = ResourceBundle.getBundle(System.getProperty("searchStatement"));

    public static String getItem(String key) {
        return item.getString(key);
    }

    public static String getUser(String key) {
        return user.getString(key);
    }

    public static String getPage(String key) {
        return page.getString(key);
    }

    public static String getSearchStatement(String key) {
        return searchStatement.getString(key);
    }

}
