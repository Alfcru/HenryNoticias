package com.HenryNews.base.controller;

import com.HenryNews.base.model.Noticias;
import com.HenryNews.base.model.PaginacionResponse;
import com.HenryNews.base.service.NoticiasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")

public class NoticiasController {

    @Autowired
    private NoticiasService noticiasService;

    @GetMapping("/{id}")
    @Operation(summary = "Trae Noticia por Id")
    public Noticias getNoticiaById(@PathVariable("id") Integer id){
        return noticiasService.getNoticiaById(id);
    }

    @GetMapping
    @Operation(summary = "Trae todas las Noticias")
    public PaginacionResponse<Noticias> getAll(@RequestParam(value = "size", defaultValue = "10") Integer size,
                                               @RequestParam(value = "page", defaultValue = "0") Integer page){
        return noticiasService.getAll(page, size);
    }

    @PostMapping
    @Operation(summary = "Crear una Noticia")
    public String addNoticia(@RequestBody Noticias noticias){
        Noticias noticia = noticiasService.addNoticia(noticias);
        return ("Se dio Alta la Noticia: " + noticia);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Noticia por Id")
    public String deleteNoticia(@PathVariable("id") Integer id){
        noticiasService.deleteWrite(id);
        return ("Noticias eliminada por id: "+ id);
    }

    @PutMapping("/{id}/write/{writeId}")
    @Operation(summary = "Agregar Escritor a la Noticia")
    public String addWriter(@PathVariable("id") Integer id, @PathVariable("writeId") Integer writeId){
        noticiasService.addWriter(id, writeId);
        return ("Agregado el Escritor id: "+ writeId);
    }
}
