package com.miracom.backendramioverflow.utils;

import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.Map;

public class BaseUtil {
    private static final String ASCENDING = "asc";
    private static final String DESCENDING = "desc";

    public static Sort sortByColumn(String column, String order) {
        Sort sort = null;

        if (ASCENDING.endsWith(order)) {
            sort = Sort.by(column).ascending();
        } else if (DESCENDING.equals(order)) {
            sort = Sort.by(column).descending();
        } else {
            sort = Sort.by("id").descending();
        }

        return sort;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String || obj instanceof StringBuffer) {
            String str = obj.toString().trim();
            return str.isEmpty() || str.equalsIgnoreCase("null");
        } else if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        } else if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        } else if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        return false;
    }
}
