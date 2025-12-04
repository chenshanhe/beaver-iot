package com.milesight.beaveriot.context.integration.model.request;

import com.milesight.beaveriot.context.integration.model.dto.CanvasWidgetDTO;
import com.milesight.beaveriot.context.integration.constants.CanvasDataFieldConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

/**
 * CanvasUpdateRequest class.
 *
 * @author simon
 * @date 2025/9/10
 */
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class CanvasUpdateRequest {
    @Size(max = CanvasDataFieldConstants.CANVAS_NAME_MAX_LENGTH)
    @NotBlank
    private String name;

    @Size(max = CanvasDataFieldConstants.WIDGET_MAX_COUNT_PER_CANVAS)
    private List<CanvasWidgetDTO> widgets;

    @Size(max = CanvasDataFieldConstants.ENTITY_MAX_COUNT_PER_CANVAS)
    private List<Long> entityIds;

    @Size(max = CanvasDataFieldConstants.DEVICE_MAX_COUNT_PER_CANVAS)
    private List<Long> deviceIds;
}
