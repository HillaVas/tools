package com.hillavas.toolbox.manager.db;

import com.hillavas.toolbox.dbModel.ItemModel;

import java.util.List;

public interface DBManager {

    ItemModel addNewItem (ItemModel itemModel);

    List<ItemModel> getAllItem();

    List<ItemModel> getListItem_list(String type);

    ItemModel getItemById(Long id);

    void deleteById(ItemModel item);

    void updateItemById(ItemModel item);
}
