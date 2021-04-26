package com.HenryNews.base.repository;


import com.HenryNews.base.model.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscritorRepository extends JpaRepository <Escritor, Integer> {
}
