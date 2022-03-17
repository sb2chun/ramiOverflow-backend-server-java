package com.miracom.backendramioverflow.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Sort;

import java.util.*;


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

    public static boolean isEqual(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.equals(b)) {
            return true;
        } else if (a instanceof List && b instanceof List) {
            List<Object> aList = (List<Object>) a;
            List<Object> bList = (List<Object>) b;
            if (aList.isEmpty() && bList.isEmpty()) {
                return true;
            } else if (aList.size() != bList.size()) {
                return false;
            }
            int i = 0;
            for (Object aObj : aList) {
                if (isNotEqual(aObj, bList.get(i++))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isNotEqual(Object a, Object b) {
        return !isEqual(a, b);
    }
}
