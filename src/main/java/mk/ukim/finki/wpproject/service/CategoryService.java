package mk.ukim.finki.wpproject.service;

import mk.ukim.finki.wpproject.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category create(String name);

    Category update(String name);

    void delete(String name);

    List<Category> listCategories();

    List<Category> searchCategories(String searchText);

    Optional<Category> findById(Long id);
}
