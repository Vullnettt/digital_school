package com.zerogravitysolutuins.training_service.training;

import com.zerogravitysolutuins.training_service.commons.BaseDto;

public class TrainingDto extends BaseDto {

    private String title;
    private String description;
    private Double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
