package com.HenryNews.repository;

import com.HenryNews.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository <Writer, Integer> {
}
