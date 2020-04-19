package application.repository;

import application.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    CategoryEntity findOneByCode(String code);
}
