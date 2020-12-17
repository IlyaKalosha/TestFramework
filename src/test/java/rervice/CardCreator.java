package rervice;

import model.Card;

public class CardCreator {
    protected static final String number = "testdata.card.number";
    protected static final String cvv = "testdata.card.cvv";
    protected static final String month = "testdata.card.month";
    protected static final String year = "testdata.card.year";
    protected static final String name = "testdata.card.name";
    protected static final String errorCode = "testdata.card.errorCode";

    public static Card withFieldsFromProperty(){
        return new Card(TestDataReader.getCard(number),
                        TestDataReader.getCard(cvv),
                        TestDataReader.getCard(month),
                        TestDataReader.getCard(year),
                        TestDataReader.getCard(name),
                        TestDataReader.getCard(errorCode)
        );
    }
}
