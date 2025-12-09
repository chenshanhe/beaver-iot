package com.milesight.beaveriot.canvas.service;

import com.milesight.beaveriot.canvas.facade.ICanvasFacade;
import com.milesight.beaveriot.context.api.CanvasServiceProvider;
import com.milesight.beaveriot.context.integration.enums.CanvasAttachType;
import com.milesight.beaveriot.context.integration.model.dto.CanvasDTO;
import com.milesight.beaveriot.context.integration.model.request.CanvasUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Luxb
 * @date 2025/12/4 9:42
 **/
@Service
public class CanvasServiceProviderImpl implements CanvasServiceProvider {
    private final ICanvasFacade canvasFacade;

    public CanvasServiceProviderImpl(ICanvasFacade canvasFacade) {
        this.canvasFacade = canvasFacade;
    }

    @Override
    public CanvasDTO createCanvas(String name, CanvasAttachType attachType, String attachId, Map<String, Object> attributes) {
        return canvasFacade.createCanvas(name, attachType, attachId, attributes);
    }

    @Override
    public void updateCanvas(Long canvasId, CanvasUpdateRequest updateRequest) {
        canvasFacade.updateCanvas(canvasId, updateRequest);
    }
}
