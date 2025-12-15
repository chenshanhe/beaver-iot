package com.milesight.beaveriot.context.api;

import com.milesight.beaveriot.context.integration.model.WorkFlow;

/**
 * author: chensh
 * create: 2025/12/10
 **/
public interface WorkFlowServiceProvider {
    String createWorkflow(WorkFlow workFlow);

}
