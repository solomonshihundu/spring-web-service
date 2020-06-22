package com.appsystems.restfulwebservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class House
{
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("location")
    private String location;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private String price;
}
