package com.HenryNews.controller;

import com.HenryNews.model.Writer;
import com.HenryNews.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService writerService;

    @GetMapping
    @Operation(summary = "Lista de Escritores")
    public List<Writer> getWriters(){
        return writerService.getWriters();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar escritor por su ID")
    public Writer getWriter(@PathVariable Integer id){
        return writerService.getWriter(id);
    }

//    @GetMapping("/writerDTO/{id}")
//    @Operation(summary = "Consulta de escritorDTO por su ID")
//    public WriterDTO getWriterDTO(@PathVariable Integer id){
//        return conversionService.convert(writerService.getWriter(id), WriterDTO.class);
//    }


}
