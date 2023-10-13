package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String name;

    private String type;

    private String dimension;

    public Location(LocationRecord locationRecord) {
        this.name = locationRecord.name();
        this.type = locationRecord.type();
        this.dimension = locationRecord.dimension();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Nome: "+name.replace("unknown", "indefinido")+ "\nTipo: "+
                type.replace("unknown", "indefinido")+"\nDimensão: "+
                dimension.replace("unknown", "indefinido");
    }
}
