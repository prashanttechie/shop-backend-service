package com.jsr.shopbackendservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Gift {

    private String giftId;
    private String name;
    private Double price;
    private String thumbnail;
    private String category;

    @JsonCreator
    public Gift(@JsonProperty("giftId") String giftId,
                @JsonProperty("name") String name,
                @JsonProperty("price") Double price,
                @JsonProperty("thumbnail") String thumbnail,
                @JsonProperty("category") String category) {
        this.giftId = giftId;
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public String getGiftId() {
        return giftId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCategory() {
        return category;
    }
}
