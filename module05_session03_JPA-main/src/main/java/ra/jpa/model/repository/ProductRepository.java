package ra.jpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.jpa.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
