package com.hashira.wherehouse.services;


import com.hashira.wherehouse.models.Item;
import com.hashira.wherehouse.repositories.ItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemsService {

    private ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @Transactional
    public void saveOrUpdate(Item item){
        itemsRepository.save(item);
    }
}
