package ra.jpa.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.jpa.model.entity.Category;
import ra.jpa.model.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
//        cach 1:
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);

//        cach 2:
//        return categoryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
//        cach 1:
        categoryRepository.deleteById(id);

//        cach 2:
//        categoryRepository.delete(findById(id));
    }
}
