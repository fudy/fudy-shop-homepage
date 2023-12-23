package com.fudy.homepage.domain.repository;


import com.fudy.homepage.domain.model.ad.Ad;
import com.fudy.homepage.domain.model.ad.AdType;

import java.util.List;

public interface AdRepository {
    List<Ad> getAdList();

    AdType getType();
}
