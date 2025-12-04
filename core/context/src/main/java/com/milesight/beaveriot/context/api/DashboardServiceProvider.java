package com.milesight.beaveriot.context.api;

import com.milesight.beaveriot.context.integration.model.request.DashboardBatchDeleteRequest;
import com.milesight.beaveriot.context.integration.model.request.DashboardInfoRequest;
import com.milesight.beaveriot.context.integration.model.response.CreateDashboardResponse;

/**
 * @author Luxb
 * @date 2025/12/4 9:30
 **/
public interface DashboardServiceProvider {
    CreateDashboardResponse createDashboard(DashboardInfoRequest dashboardInfoRequest);
    void deleteDashboard(DashboardBatchDeleteRequest deleteRequest);
}
