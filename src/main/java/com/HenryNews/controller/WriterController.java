package com.HenryNews.controller;

import com.HenryNews.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService writerService;


}
