package com.fudy.homepage.infrastructure.spring;

import com.fudy.homepage.domain.model.ad.AdType;
import com.fudy.homepage.domain.repository.AdRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class BeanConfiguration {
    @Bean
    public Map<AdType, AdRepository> adRepositoryMap(Collection<AdRepository> adRepositories) {
        return adRepositories.stream()
                .collect(Collectors.toMap(AdRepository::getType, Function.identity()));
    }
}
