package com.fudy.homepage.infrastructure.mybatis.convertor;

import com.fudy.homepage.domain.Item;
import com.fudy.homepage.infrastructure.mybatis.data.ItemDO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemConvertor {

    Item toItem(ItemDO itemDO);

    List<Item> toItemList(List<ItemDO> itemDOList);
}
