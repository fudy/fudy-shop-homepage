package com.fudy.homepage.application.repository;

import com.fudy.homepage.application.assembler.SimpleItemAssembler;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.infrastructure.mybatis.convertor.ItemConvertor;
import com.fudy.homepage.infrastructure.mybatis.data.ItemDO;
import com.fudy.homepage.infrastructure.mybatis.mapper.ItemMapper;
import com.fudy.homepage.interfaces.dto.PaginationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    @Autowired
    private ItemMapper mapper;
    @Autowired
    private ItemConvertor convertor;

    public List<Item> getItemList(PaginationQuery query) {
        List<ItemDO> list = mapper.selectList(query.getPageIndex(), query.getPageSize());
        return convertor.toItemList(list);
    }
}
