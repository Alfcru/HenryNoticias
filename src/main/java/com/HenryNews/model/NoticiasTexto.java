package com.HenryNews.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class NoticiasTexto extends Noticias{
    private String texto;
}
