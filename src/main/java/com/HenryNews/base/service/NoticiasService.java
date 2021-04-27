package com.HenryNews.base.service;


import com.HenryNews.base.model.Escritor;
import com.HenryNews.base.model.Noticias;
import com.HenryNews.base.model.NoticiasEnum;
import com.HenryNews.base.model.PaginacionResponse;
import com.HenryNews.base.repository.NoticiasRepository;
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
    private EscritorService escritorService;

    public Noticias getNoticiaById(Integer id) {
        return noticiasRepository.findById(id).orElse(new Noticias() {
            @Override
            public NoticiasEnum noticiasEnum() {
                return null;
            }
        });
    }

    public PaginacionResponse<Noticias> getAll(Integer page, Integer size) {
        if(!Objects.isNull(page) && !Objects.isNull(size)) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Noticias> noticiasPage = noticiasRepository.findAll(pageable);
            return new PaginacionResponse<>(noticiasPage.getContent(), noticiasPage.getTotalPages(), noticiasPage.getTotalElements());
        }
            List<Noticias> noticiasList = noticiasRepository.findAll();
            return new PaginacionResponse<>(noticiasList, 1, (long) noticiasList.size());
    }

    public Noticias addNoticia(Noticias noticias) {
        return noticiasRepository.save(noticias);
    }

    public void deleteEscritor(Integer id) {
        noticiasRepository.deleteById(id);
    }

    public void addEscritor(Integer id, Integer writerID) {
        Noticias noticias = getNoticiaById(id);
        Escritor writer = escritorService.getEscritor(writerID);
        noticias.setOwner(writer);
        noticiasRepository.save(noticias);
    }
}
