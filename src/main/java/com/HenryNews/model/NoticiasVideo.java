package com.HenryNews.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode
public class NoticiasVideo extends Noticias{
    private String titulo;
    private String descripcion;
    private String urlvideo;
}
