package com.HenryNews.base.repository;

import com.HenryNews.base.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository <Noticias, Integer> {
}
