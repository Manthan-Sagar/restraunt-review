package com.manthan.restraunt.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.manthan.restraunt.domain.entities.Restraunt;

@Repository
public interface RestrauntRepository extends ElasticsearchRepository<Restraunt, String> {
    
}
