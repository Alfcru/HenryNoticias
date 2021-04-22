package com.HenryNews.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@JsonTypeInfo()


public abstract class Noticias {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private Writer owner;

}
