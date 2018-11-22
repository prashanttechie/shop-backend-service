package com.jsr.shopbackendservice.controller;

import com.jsr.shopbackendservice.model.Gift;
import com.jsr.shopbackendservice.model.GiftProductRequest;
import com.jsr.shopbackendservice.model.GiftProductResponse;
import com.jsr.shopbackendservice.mongo.GiftDAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GiftDetailsController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private GiftDAL giftDAL;

    @Autowired
    public GiftDetailsController( GiftDAL giftDAL) {
        this.giftDAL = giftDAL;
    }

    @RequestMapping(value = "/gift",method = RequestMethod.POST)
    public ResponseEntity<Object> getGiftDetail(@RequestBody @Valid GiftProductRequest giftProductRequest){

        Gift gift = new Gift(giftProductRequest.getGiftId(),"car",23.5,"","birthday");
        List<Gift> giftList= new ArrayList<>();
        giftList.add(gift);

        GiftProductResponse giftProductResponse = new GiftProductResponse(giftList);

        return new ResponseEntity<>(giftProductResponse, HttpStatus.OK);

    }

    @RequestMapping(value = "/gift/save", method = RequestMethod.POST)
    public ResponseEntity<Object> insertNewGift(@RequestBody @Valid Gift insertGiftRequest){
        LOG.info("saving user");
        return new ResponseEntity<>(giftDAL.addGift(insertGiftRequest),HttpStatus.OK);
    }

    @RequestMapping(value = "/gift/get/{giftId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getGiftDetails(@PathVariable String giftId){
        LOG.info("Fetching the Gift Details");
        return new ResponseEntity<>(giftDAL.getGiftById(giftId),HttpStatus.OK);
    }

    @RequestMapping(value = "gift/delete/{giftId}", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteGift(@PathVariable String giftId){
        LOG.info("Deleting the Gift Details");
        return new ResponseEntity<>(giftDAL.delete(giftId),HttpStatus.OK);
    }

    @RequestMapping(value = "/gift/get", method = RequestMethod.GET)
    public ResponseEntity<Object> getGiftDetails(){
        LOG.info("Fetching the Gift Details");
        return new ResponseEntity<>(giftDAL.getGiftList(),HttpStatus.OK);
    }


}
