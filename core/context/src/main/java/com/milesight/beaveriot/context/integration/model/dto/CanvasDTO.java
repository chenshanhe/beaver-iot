package com.milesight.beaveriot.context.integration.model.dto;

import com.milesight.beaveriot.context.integration.enums.CanvasAttachType;
import lombok.Data;

/**
 * CanvasDTO class.
 *
 * @author simon
 * @date 2025/9/10
 */
@Data
public class CanvasDTO {
    private Long id;

    private String name;

    private CanvasAttachType attachType;

    private String attachId;
}
