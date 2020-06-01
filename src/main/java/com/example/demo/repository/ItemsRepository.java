
package com.example.demo.repository;

        import com.example.demo.model.items;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import org.springframework.web.bind.annotation.CrossOrigin;

        import java.util.List;
@CrossOrigin("*")
@Repository
public interface ItemsRepository extends JpaRepository<items,Long> {

    List<items> findAllByCategory(String category);
    List<items> findAllByName(String name);

    List<items> findAllByDescriptionContaining(String description);
}
