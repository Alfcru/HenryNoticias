package com.HenryNews.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class NoticiasImagenes extends Noticias{
    private List<String> urlImagenes;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.IMAGENES;
    }
}
