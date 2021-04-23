package com.HenryNews.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "noticiasEnum")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoticiasImagenes.class, name = "IMAGENES"),
        @JsonSubTypes.Type(value = NoticiasTexto.class, name = "TEXTO"),
        @JsonSubTypes.Type(value = NoticiasVideo.class, name = "VIDEO")
})


public abstract class Noticias {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private Writer owner;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract NoticiasEnum noticiasEnum();

}
