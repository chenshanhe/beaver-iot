package com.milesight.beaveriot.context.integration.model.request;

import com.milesight.beaveriot.context.integration.constants.DashboardDataFieldConstants;
import com.milesight.beaveriot.context.integration.enums.DashboardCoverType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Map;

/**
 * @author simon
 * @date 2025/9/8
 */
@Data
public class DashboardInfoRequest {
    @Size(max = DashboardDataFieldConstants.DASHBOARD_NAME_MAX_LENGTH)
    @NotBlank
    private String name;

    @Size(max = DashboardDataFieldConstants.DASHBOARD_DESCRIPTION_MAX_LENGTH)
    private String description;

    private DashboardCoverType coverType;

    private String coverData;

    private Map<String, Object> attributes;

    private Map<String, Object> mainCanvasAttributes;
}
