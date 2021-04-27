package com.HenryNews.base.service;

import com.HenryNews.base.model.Escritor;
import com.HenryNews.base.repository.EscritorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class EscritorService {

    @Autowired
    private EscritorRepository escritorRepository;

    public Escritor getEscritor(Integer id){
        return escritorRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Escritor> getEscritor() {
        return  escritorRepository.findAll();
    }


    public Escritor addEscritor(Escritor escritores) {
        return escritorRepository.save(escritores);
    }
}
