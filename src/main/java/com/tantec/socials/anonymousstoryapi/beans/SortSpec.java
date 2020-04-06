package com.tantec.socials.anonymousstoryapi.beans;

import lombok.Getter;
import lombok.Setter;

public class SortSpec {

    @Getter
    @Setter
    private String sortBy;

    @Getter
    @Setter
    private String sortOrder;

    public SortSpec() {
        this.sortBy = "";
        this.sortOrder = "desc";
    }

}