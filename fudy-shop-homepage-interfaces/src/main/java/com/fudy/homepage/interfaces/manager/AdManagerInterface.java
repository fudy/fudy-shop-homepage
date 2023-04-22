package com.fudy.homepage.interfaces.manager;

import com.fudy.homepage.interfaces.dto.AdDTO;

import java.util.List;

public interface AdManagerInterface {
    List<AdDTO> getAdList(String type);
}
