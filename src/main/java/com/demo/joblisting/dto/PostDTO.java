package com.demo.joblisting.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;

public class PostDTO {

    @Schema(description = "profile", example = "Senior Manager")
    private String profile;

    @Schema(description = "description", example = "Manager for onsite projects in US and UK")
    private String description;

    @Schema(description = "experience", example = "2")
    private int experience;

    @Schema(description = "techs", example = "[java, android, datascience]")
    private String[] techs;

    public PostDTO() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
