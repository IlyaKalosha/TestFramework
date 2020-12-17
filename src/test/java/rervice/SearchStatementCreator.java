package rervice;

import model.SearchStatement;

public class SearchStatementCreator {
    protected static final String text = "testdata.searchStatement.text";
    public static SearchStatement withFieldsFromProperty(){
        return new SearchStatement(TestDataReader.getSearchStatement(text));
    }
}
