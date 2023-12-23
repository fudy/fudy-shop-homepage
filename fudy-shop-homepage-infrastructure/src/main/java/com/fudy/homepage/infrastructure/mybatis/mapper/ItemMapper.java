package com.fudy.homepage.infrastructure.mybatis.mapper;

import com.fudy.homepage.infrastructure.data.ItemDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,name,category_id,description,image,sub_images,seller_id,status,price,item_id";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    /**
     * 查询商品列表
     * @param start 开始位置，包含
     * @param size 每次查询的大小
     * @return
     */
    @Select("select " + COLUMNS + " from item where status = 'PUB' order by id limit #{start},#{size}")
    List<ItemDO> selectList(int start, int size);
}
