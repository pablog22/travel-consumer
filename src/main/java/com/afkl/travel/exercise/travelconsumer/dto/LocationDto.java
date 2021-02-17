package com.afkl.travel.exercise.travelconsumer.dto;

import lombok.Data;

@Data
public class LocationDto {

    private String code;
    private String name;
    private String type;
    private Double latitude;
    private Double longitude;
    private String description;
    private String parentCode;
    private String parentType;


}
