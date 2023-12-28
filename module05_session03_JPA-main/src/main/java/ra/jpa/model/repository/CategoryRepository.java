package ra.jpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.jpa.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
