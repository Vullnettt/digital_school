package com.zerogravitysolutions.subjectservice.subject;

import com.zerogravitysolutions.subjectservice.commons.BaseDto;

public class SubjectDto extends BaseDto {

    private String title;
    private String description;
    private Long trainingId;

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


    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }
}
