package com.fudy.homepage.application.repository;

import com.fudy.homepage.interfaces.dto.AdDTO;

import java.util.List;

public interface AdRepository {
    List<AdDTO> getAdList();
}
