package com.HenryNews.repository;

import com.HenryNews.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository <Noticias, Integer> {
}
