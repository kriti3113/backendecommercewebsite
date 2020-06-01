package com.example.demo.repository;


import com.example.demo.model.OrderHistory;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface OrderHistoryRepository  extends JpaRepository <OrderHistory, Long>
{

    List<OrderHistory> findAllByUser(Optional<Users> users);
}
