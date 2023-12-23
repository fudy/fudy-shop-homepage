package com.fudy.homepage.domain.model;

public interface Entity<T extends Identifier<?>> {
    T getId();
}
