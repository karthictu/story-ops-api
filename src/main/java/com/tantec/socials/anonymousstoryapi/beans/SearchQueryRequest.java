package com.tantec.socials.anonymousstoryapi.beans;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

public class SearchQueryRequest {

    @Getter
    @Setter
    private Optional<SearchFilter> filter;

    @Getter
    @Setter
    private Optional<SortSpec> sort;

    @Getter
    @Setter
    private Optional<String> query;

    @Getter
    @Setter
    private Optional<String> pageSize;

    @Getter
    @Setter
    private Optional<String> pageOffset;

    public SearchQueryRequest() {
        this.filter = Optional.of(new SearchFilter());
        this.sort = Optional.of(new SortSpec());
        this.query = Optional.of("");
        this.pageSize = Optional.of("0");
        this.pageOffset = Optional.of("0");
    }
}