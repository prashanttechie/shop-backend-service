package com.jsr.shopbackendservice.mongo;

import com.jsr.shopbackendservice.model.Gift;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

public interface GiftDAL {

    List<Gift> getGiftList();
    Gift getGiftById(String id);
    Gift addGift(Gift gift);
    DeleteResult delete(String id);

}
