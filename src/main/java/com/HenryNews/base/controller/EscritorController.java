package com.HenryNews.base.controller;

import com.HenryNews.base.model.Escritor;
import com.HenryNews.base.model.Noticias;
import com.HenryNews.base.service.EscritorService;
import com.HenryNews.base.service.NoticiasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escritor")
public class EscritorController {

    @Autowired
    private EscritorService escritorService;

    @GetMapping
    @Operation(summary = "Lista de Escritores")
    public List<Escritor> getWriters(){
        return escritorService.getEscritor();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar escritor por su ID")
    public Escritor getWriter(@PathVariable Integer id){
        return escritorService.getEscritor(id);
    }

    @PostMapping
    @Operation(summary = "agregar un escritor")
    public String postEscritor(@RequestBody Escritor escritores){
        Escritor escritor = escritorService.addEscritor(escritores);
        return ("Se dio Alta la escritor: " + escritor);
    }

//    @GetMapping("/writerDTO/{id}")
//    @Operation(summary = "Consulta de escritorDTO por su ID")
//    public WriterDTO getWriterDTO(@PathVariable Integer id){
//        return conversionService.convert(writerService.getWriter(id), WriterDTO.class);
//    }

}
