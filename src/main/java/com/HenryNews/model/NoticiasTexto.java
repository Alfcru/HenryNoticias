package com.HenryNews.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "NoticasTexto")

public class NoticiasTexto extends Noticias{

    private String texto;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.TEXTO;
    }
}
