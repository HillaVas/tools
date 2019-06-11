package com.hillavas.toolbox.manager.db;

import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.dbModel.ItemModel_;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.query.Query;

@Singleton
public final class AppDbManager implements DBManager {

    @Inject
    BoxStore boxStore;

    @Inject
    AppDbManager(){}

    private <T> Box<T> getTable(Class<T> entityClass) {
        return boxStore.boxFor(entityClass);
    }

    private <T> void addRowsToTable(ArrayList<T> collections, Class<T> aClass) {
        getTable(aClass).put(collections);
    }

    private <T> void addRowsToTable(T entity, Class<T> aClass) {
        getTable(aClass).put(entity);
    }

    private <T> void removeRow(ArrayList<T> collections, Class<T> aClass) {
        getTable(aClass).remove(collections);
    }

    private <T> void removeRow(T object, Class<T> aClass) {
        getTable(aClass).remove(object);
    }

    private <T> void removeAllRow(Class<T> aClass) {
        getTable(aClass).removeAll();
    }

    private <T> T getObject(Class<T> aClass, long objectId) {
        return getTable(aClass).get(objectId);
    }

    private <T> List<T> getAllObject(Class<T> aClass) {
        return getTable(aClass).getAll();
    }

    private <T> List<T> getLimitObject(Class<T> aClass, long offset, long limit) {
        Query<T> query = getTable(aClass).query().build();
        return query.find(/** offset by */offset, /** limit to */limit /** results */);
    }

    private <T> T getObjectByProperty(Class<T> aClass, Property property, String id) {

        Query<T> query = getTable(aClass).query().contains(property, id).build();
        return query.findFirst();
    }

    private <T> List<T> getObjectsByProperty(Class<T> aClass, Property property, String id) {
        Query<T> query = getTable(aClass).query().contains(property, id).build();
        return query.find();
    }

    @Override
    public ItemModel addNewItem(ItemModel itemModel) {
        addRowsToTable(itemModel, ItemModel.class);
        return itemModel;
    }

    @Override
    public List<ItemModel> getAllItem() {
        return getAllObject(ItemModel.class);
    }

    @Override
    public List<ItemModel> getListItem_list(String type) {
        return null;
    }


    @Override
    public ItemModel getItemById(Long id) {
        return getObject(ItemModel.class,id);
    }

    @Override
    public void deleteById(ItemModel item) {
        long id = item.getId();
        ItemModel itemModel = getItemById(id);

//         removeRow(itemModel,ItemModel.class);
        addRowsToTable(itemModel, ItemModel.class);


    }

    @Override
    public void updateItemById(ItemModel item) {

        long id = item.getId();
        ItemModel itemModel = getItemById(id);
        addRowsToTable(itemModel, ItemModel.class);

    }


}
