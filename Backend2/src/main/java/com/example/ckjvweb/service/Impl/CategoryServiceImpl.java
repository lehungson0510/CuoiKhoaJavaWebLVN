package com.example.ckjvweb.service.Impl;

import com.example.ckjvweb.entity.book.Category;
import com.example.ckjvweb.repository.ICategoryRepository;
import com.example.ckjvweb.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
