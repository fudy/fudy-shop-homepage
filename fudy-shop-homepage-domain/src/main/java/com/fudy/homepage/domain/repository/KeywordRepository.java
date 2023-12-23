package com.fudy.homepage.domain.repository;

import com.fudy.homepage.domain.model.search.Keyword;

import java.util.List;

public interface KeywordRepository {
    List<Keyword> getKeywordList();
}
