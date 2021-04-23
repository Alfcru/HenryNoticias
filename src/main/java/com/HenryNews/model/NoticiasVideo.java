package com.HenryNews.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity(name = "NoticiasVideo")
@EqualsAndHashCode(callSuper = true)

public class NoticiasVideo extends Noticias{
    private String titulo;
    private String descripcion;
    private String urlvideo;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.VIDEO;
    }
}
