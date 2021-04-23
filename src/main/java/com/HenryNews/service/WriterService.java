package com.HenryNews.service;

import com.HenryNews.model.Writer;
import com.HenryNews.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public Writer getWriter(Integer id){
        return writerRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
