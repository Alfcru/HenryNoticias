package com.HenryNews.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor


public abstract class Noticias {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private Writer owner;

}
