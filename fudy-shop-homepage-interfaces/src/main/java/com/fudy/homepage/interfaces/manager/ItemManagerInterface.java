package com.fudy.homepage.interfaces.manager;

import com.fudy.homepage.interfaces.dto.SimpleItemDTO;

import java.util.List;

public interface ItemManagerInterface {
    List<SimpleItemDTO> getItemList(Integer pageIndex,Integer pageSize );
}
