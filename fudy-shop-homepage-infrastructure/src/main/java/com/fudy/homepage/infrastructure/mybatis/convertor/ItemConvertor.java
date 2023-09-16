package com.fudy.homepage.infrastructure.mybatis.convertor;

import com.fudy.homepage.domain.item.Item;
import com.fudy.homepage.infrastructure.mybatis.data.ItemDO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemConvertor {

    Item toItem(ItemDO itemDO);

    ItemDO toItemDO(Item item);

    List<Item> toItemList(List<ItemDO> itemDOList);
}
