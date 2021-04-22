package com.HenryNews.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity

public abstract class Noticias {
    private String titulo;
    private String descripcion;
    private Writer owner;

}
