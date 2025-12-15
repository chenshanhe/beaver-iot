package com.milesight.beaveriot.rule.manager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.milesight.beaveriot.base.utils.JsonUtils;
import com.milesight.beaveriot.context.api.WorkFlowServiceProvider;
import com.milesight.beaveriot.context.integration.model.WorkFlow;
import com.milesight.beaveriot.context.integration.wrapper.AnnotatedEntityWrapper;
import com.milesight.beaveriot.permission.enums.OperationPermissionCode;
import com.milesight.beaveriot.permission.helper.TemporaryPermission;
import com.milesight.beaveriot.rule.manager.model.request.SaveWorkflowRequest;
import com.milesight.beaveriot.rule.manager.model.response.SaveWorkflowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: chensh
 * create: 2025/12/10
 **/
@Service
@Slf4j
public class WorkflowServiceProviderImpl implements WorkFlowServiceProvider {
    @Autowired
    private WorkflowService workflowService;

    @Override
    public String createWorkflow(WorkFlow workFlow) {
        SaveWorkflowRequest request = new SaveWorkflowRequest();
        BeanUtils.copyProperties(workFlow, request);
        SaveWorkflowResponse saveWorkflowResponse = TemporaryPermission.with(OperationPermissionCode.WORKFLOW_ADD).supply(() ->
                workflowService.createWorkflow(request, null)
        );
        return saveWorkflowResponse.getFlowId();
    }
}
