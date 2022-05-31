package com.api.tboa.DTO;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
