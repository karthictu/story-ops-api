package com.tantec.socials.anonymousstoryapi.validators;

import java.util.Map;

import com.tantec.socials.anonymousstoryapi.beans.SearchFilter;
import com.tantec.socials.anonymousstoryapi.beans.SearchQueryRequest;
import com.tantec.socials.anonymousstoryapi.beans.SortSpec;
import com.tantec.socials.anonymousstoryapi.constants.CommonConstants;

public class SearchQueryValidator {

    public boolean isRequestValid(SearchQueryRequest request) {
        if (!(request.getFilter().isPresent() && validateFilter(request.getFilter().get()))) {
            if (!(request.getSort().isPresent() && validateSort(request.getSort().get(), request.getFilter().get().getConditions())))
                return false;
        }
        if (!(request.getQuery().isPresent() && validateQuery(request.getQuery().get()))) {
            return false;
        }        
        return true;
    }

    private boolean validateFilter(SearchFilter filter) {
        switch (filter.getFilterType().toLowerCase()) {
            case CommonConstants.AND:
            case CommonConstants.OR:
            case CommonConstants.NOT:
                break;
            default:
                return false;
        }
        for (String key : filter.getConditions().keySet()) {
            switch (key) {
                case CommonConstants.AUTHOR_USER_ID:
                case CommonConstants.STORY_ID:
                case CommonConstants.CATEGORY_ID:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private boolean validateSort(SortSpec sort, Map<String, String> filterMap) {
        if ((filterMap.containsKey(sort.getSortBy())
            || sort.getSortBy().equalsIgnoreCase(CommonConstants.CREATED_TIMESTAMP)
            || sort.getSortBy().equalsIgnoreCase(CommonConstants.LAST_UPDATED_TIMESTAMP)) &&
        (sort.getSortOrder().equalsIgnoreCase(CommonConstants.SORT_ASCENDING)
            || sort.getSortOrder().equalsIgnoreCase(CommonConstants.SORT_DESCENDING)))
            return true;
        else
            return false;
    }

    private boolean validateQuery(String query) {
        return !query.isBlank();
    }

}