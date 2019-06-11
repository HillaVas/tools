package com.hillavas.toolbox.eventBusModels;

import com.hillavas.toolbox.dbModel.ItemModel;

public class ItemEventBusModel {

    public ItemEventBusModel (ItemModel item , String action)
    {
        this.itemModel = item;
        this.action = action;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private ItemModel itemModel;
    private String action;
}
