package io.vnc.moviecatalog.models;

import java.util.Objects;

public class CatalogItem {

    private String name;
    private String desc;
    private int ratting;


    public CatalogItem(String name, String desc, int ratting) {
        this.name = name;
        this.desc = desc;
        this.ratting = ratting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRatting() {
        return ratting;
    }

    public void setRatting(int ratting) {
        this.ratting = ratting;
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", ratting=" + ratting +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogItem that = (CatalogItem) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
