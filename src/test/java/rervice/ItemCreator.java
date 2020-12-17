package rervice;

import model.Item;

public class ItemCreator {
    protected static final String id = "testdata.item.id";
    protected static final String name = "testdata.item.name";

    public static Item withFieldsFromProperty(){
        return new Item(TestDataReader.getItem(id),
                        TestDataReader.getItem(name)
        );
    }
}
