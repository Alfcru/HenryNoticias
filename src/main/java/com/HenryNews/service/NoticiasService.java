package com.HenryNews.service;


import com.HenryNews.model.Noticias;
import com.HenryNews.model.NoticiasEnum;
import com.HenryNews.model.PaginationResponse;
import com.HenryNews.model.Writer;
import com.HenryNews.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Objects;

@Service

public class NoticiasService {

    @Autowired
    private NoticiasRepository noticiasRepository;
    private WriterService writerService;

    public Noticias getNoticiaById(Integer id) {
        return noticiasRepository.findById(id).orElse(new Noticias() {
            @Override
            public NoticiasEnum noticiasEnum() {
                return null;
            }
        });
    }

    public PaginationResponse<Noticias> getAll(Integer page, Integer size) {
        if(!Objects.isNull(page) && !Objects.isNull(size)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Noticias> noticiasPage = noticiasRepository.findAll(pageable);
            return new PaginationResponse<>(noticiasPage.getContent(), noticiasPage.getTotalPages(), noticiasPage.getTotalElements());
        }
            List<Noticias> noticiasList = noticiasRepository.findAll();
            return new PaginationResponse<>(noticiasList, 1, (long) noticiasList.size());
    }

    public Noticias addNoticia(Noticias noticias) {
        return noticiasRepository.save(noticias);
    }

    public void deleteWrite(Integer id) {
        noticiasRepository.deleteById(id);
    }

    public void addWriter(Integer id, Integer writerID) {
        Noticias noticias = getNoticiaById(id);
        Writer writer = writerService.getWriter(writerID);
        noticias.setOwner(writer);
        noticiasRepository.save(noticias);
    }
}
