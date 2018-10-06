package com.jsr.shopbackendservice.model;

import java.util.List;

public class GiftProductResponse {

    List<Gift> listOfGiftsAvailable;

    public GiftProductResponse(List<Gift> listOfGiftsAvailable) {
        this.listOfGiftsAvailable = listOfGiftsAvailable;
    }

    public List<Gift> getListOfGiftsAvailable() {
        return listOfGiftsAvailable;
    }
}
