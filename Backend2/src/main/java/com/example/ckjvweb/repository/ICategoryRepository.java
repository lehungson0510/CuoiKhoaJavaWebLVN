package com.example.ckjvweb.repository;

import com.example.ckjvweb.entity.book.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ICategoryRepository  extends JpaRepository<Category,Integer> {

}
