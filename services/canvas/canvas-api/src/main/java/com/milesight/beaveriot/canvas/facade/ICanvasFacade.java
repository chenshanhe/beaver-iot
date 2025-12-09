package com.milesight.beaveriot.canvas.facade;

import com.milesight.beaveriot.context.integration.enums.CanvasAttachType;
import com.milesight.beaveriot.context.integration.model.dto.CanvasDTO;
import com.milesight.beaveriot.context.integration.model.request.CanvasUpdateRequest;
import com.milesight.beaveriot.canvas.model.response.CanvasResponse;

import java.util.List;
import java.util.Map;

/**
 * ICanvasFacade class.
 *
 * @author simon
 * @date 2025/9/10
 */
public interface ICanvasFacade {

    CanvasResponse getCanvasData(Long canvasId);

    CanvasDTO createCanvas(String name, CanvasAttachType attachType, String attachId);

    CanvasDTO createCanvas(String name, CanvasAttachType attachType, String attachId, Map<String, Object> attributes);

    void updateCanvas(Long canvasId, CanvasUpdateRequest canvasUpdateRequest);

    void deleteCanvasByAttach(CanvasAttachType attachType, List<String> attachIdList);

    void deleteCanvasByIds(List<Long> canvasIdList);

    List<CanvasDTO> getCanvasByAttach(CanvasAttachType attachType, List<String> attachIdList);
}
