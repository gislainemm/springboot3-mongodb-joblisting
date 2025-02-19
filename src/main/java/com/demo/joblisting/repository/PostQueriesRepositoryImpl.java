package com.demo.joblisting.repository;

import com.demo.joblisting.model.Post;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


@Component
public class PostQueriesRepositoryImpl implements PostQueriesRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Post> findByText(String text) {
        Query query = new Query()
                .addCriteria(new Criteria().orOperator(
                        Criteria.where("desc").regex(text, "i"),
                        Criteria.where("profile").regex(text, "i"),
                        Criteria.where("techs").regex(text, "i")
                ))
                .with(Sort.by(Sort.Order.desc("exp")))
                .limit(5);

        return mongoTemplate.find(query, Post.class);
    }
}
