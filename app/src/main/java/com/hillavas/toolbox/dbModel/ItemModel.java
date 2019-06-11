package com.hillavas.toolbox.dbModel;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class ItemModel {

    @Id
    private long id;
    private String name;
    private String address;
    private int imageAddress;
    private String url;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(int imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
