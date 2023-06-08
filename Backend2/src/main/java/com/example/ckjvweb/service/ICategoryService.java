package com.example.ckjvweb.service;

import com.example.ckjvweb.entity.book.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
}
