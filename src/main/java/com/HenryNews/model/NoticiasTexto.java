package com.HenryNews.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NoticiasTexto extends Noticias{
    private String texto;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.TEXTO;
    }
}
