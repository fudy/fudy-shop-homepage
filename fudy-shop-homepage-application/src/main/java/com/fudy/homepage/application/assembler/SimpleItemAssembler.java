package com.fudy.homepage.application.assembler;


import com.fudy.homepage.domain.Item;
import com.fudy.homepage.application.dto.SimpleItemDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleItemAssembler {

    SimpleItemDTO toSimpleItemDTO(Item item);

    List<SimpleItemDTO> toSimpleItemDTOList(List<Item> itemList);

    default String toPriceStr(BigDecimal price) {
        if (null == price) {
            return null;
        }
        return new DecimalFormat("0.00").format(price);
    }
}
