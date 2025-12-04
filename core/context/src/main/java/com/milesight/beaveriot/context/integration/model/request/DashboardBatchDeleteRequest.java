package com.milesight.beaveriot.context.integration.model.request;

import lombok.Data;

import java.util.List;

/**
 * DashboardBatchDeleteRequest class.
 *
 * @author simon
 * @date 2025/9/9
 */
@Data
public class DashboardBatchDeleteRequest {
    private List<Long> dashboardIds;
}
