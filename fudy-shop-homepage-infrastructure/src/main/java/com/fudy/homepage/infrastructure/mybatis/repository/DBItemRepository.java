package com.fudy.homepage.infrastructure.mybatis.repository;

import com.fudy.homepage.domain.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.infrastructure.mybatis.convertor.ItemConvertor;
import com.fudy.homepage.infrastructure.mybatis.data.ItemDO;
import com.fudy.homepage.infrastructure.mybatis.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DBItemRepository")
public class DBItemRepository implements ItemRepository {
    @Autowired
    private ItemMapper mapper;
    @Autowired
    private ItemConvertor convertor;

    public List<Item> getItemList(Integer pageIndex,Integer pageSize ) {
        List<ItemDO> list = mapper.selectList(pageIndex, pageSize);
        return convertor.toItemList(list);
    }

    @Override
    public void saveItemList(List<Item> itemList) {
        throw new RuntimeException("not available");
    }

    @Override
    public void saveItem(Item item) {
        throw new RuntimeException("not available");
    }
}
