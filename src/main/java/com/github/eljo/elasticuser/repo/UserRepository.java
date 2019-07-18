package com.github.eljo.elasticuser.repo;

import com.github.eljo.elasticuser.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {
}
