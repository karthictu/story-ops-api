package com.tantec.socials.anonymousstoryapi.beans;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.tantec.socials.anonymousstoryapi.constants.CommonConstants;

import org.springframework.data.jpa.domain.Specification;

public class StorySpecification implements Specification<Story> {

    private SearchQueryRequest searchQueryRequest;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Predicate toPredicate(Root<Story> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        searchQueryRequest.getFilter().get().getFilterType().equalsIgnoreCase(CommonConstants.AND);
        return null;
    }

}