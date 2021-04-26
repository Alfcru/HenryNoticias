package com.HenryNews.base.model;

public enum NoticiasEnum {

    IMAGENES("NoticiasImagen"),
    TEXTO("NoticiasTexto"),
    VIDEO("NoticiasVideo");

    private String descripcion;

    NoticiasEnum(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public static NoticiasEnum find(String value){
        for(NoticiasEnum n : values()){
            if(n.toString().equalsIgnoreCase(value)){
                return n;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid NoticaType", value));
    }

}
