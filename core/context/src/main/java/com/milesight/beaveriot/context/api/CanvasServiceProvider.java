package com.milesight.beaveriot.context.api;

import com.milesight.beaveriot.context.integration.enums.CanvasAttachType;
import com.milesight.beaveriot.context.integration.model.dto.CanvasDTO;
import com.milesight.beaveriot.context.integration.model.request.CanvasUpdateRequest;

/**
 * @author Luxb
 * @date 2025/12/4 9:42
 **/
public interface CanvasServiceProvider {
    CanvasDTO createCanvas(String name, CanvasAttachType attachType, String attachId);
    void updateCanvas(Long canvasId, CanvasUpdateRequest updateRequest);
}
