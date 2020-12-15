package Service;

import model.Item;

public class ItemCreator {
    protected static final String id = "testdata.item.id";

    public static Item withFieldsFromProperty(){
        return new Item(TestDataReader.getItem(id));
    }
}
