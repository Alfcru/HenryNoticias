package com.HenryNews.base.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PaginacionResponse<T> implements Serializable {

    private List<T> response;
    private int totalPages;
    private Long totalElements;
}
