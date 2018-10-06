package com.jsr.shopbackendservice.mongo;

import com.jsr.shopbackendservice.model.Gift;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftDALImpl implements GiftDAL{

    private MongoTemplate mongoTemplate;

    @Autowired
    public GiftDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Gift> getGiftList() {
        return mongoTemplate.findAll(Gift.class);
    }

    @Override
    public Gift getGiftById(String id) {
        Query query= new Query();
        query.addCriteria(Criteria.where("giftId").is(id));
        return mongoTemplate.findOne(query,Gift.class);
    }

    @Override
    public Gift addGift(Gift gift) {
        mongoTemplate.save(gift);
        return gift;
    }

    @Override
    public DeleteResult delete(String id) {
        Query query= new Query();
        query.addCriteria(Criteria.where("giftId").is(id));
        return mongoTemplate.remove(query,Gift.class);
    }
}
