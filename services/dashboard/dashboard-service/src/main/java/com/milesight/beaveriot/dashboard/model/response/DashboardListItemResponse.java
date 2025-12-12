package com.milesight.beaveriot.dashboard.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.milesight.beaveriot.context.integration.enums.DashboardCoverType;
import com.milesight.beaveriot.dashboard.model.DashboardAttribute;
import lombok.Data;

import java.util.Map;

/**
 * @author loong
 * @date 2024/10/18 9:45
 */
@Data
public class DashboardListItemResponse implements Comparable<DashboardListItemResponse> {

    private String dashboardId;
    private String userId;
    private String name;
    private Boolean home;
    private String description;
    private DashboardCoverType coverType;
    private String coverData;
    private String mainCanvasId;
    private String createdAt;
    private Map<String, Object> attributes;

    @JsonIgnore
    public Integer getOrder() {
        if (attributes == null) {
            return null;
        }

        return (Integer) attributes.get(DashboardAttribute.ATTRIBUTE_ORDER);
    }

    @Override
    public int compareTo(DashboardListItemResponse other) {
        int homeCompare = compareHome(this.getHome(), other.getHome());
        if (homeCompare != 0) {
            return homeCompare;
        }

        int orderCompare = compareOrder(this.getOrder(), other.getOrder());
        if (orderCompare != 0) {
            return orderCompare;
        }

        return compareCreatedAt(this.getCreatedAt(), other.getCreatedAt());
    }

    private int compareOrder(Integer order1, Integer order2) {
        if (order1 == null || order2 == null) {
            return 0;
        }

        return order1.compareTo(order2);
    }

    private int compareHome(Boolean home1, Boolean home2) {
        return compareNullsLastReverse(home1, home2);
    }

    private int compareCreatedAt(String createdAt1, String createdAt2) {
        return compareNullsLastReverse(createdAt1, createdAt2);
    }

    private <T extends Comparable<T>> int compareNullsLastReverse(T value1, T value2) {
        if (value1 == null && value2 == null) {
            return 0;
        }

        if (value1 == null) {
            return 1;
        }

        if (value2 == null) {
            return -1;
        }

        return value2.compareTo(value1);
    }
}