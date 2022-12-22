package com.hashira.wherehouse.repositories;

import com.hashira.wherehouse.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item,Integer> {
}
