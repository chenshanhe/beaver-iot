package com.milesight.beaveriot.context.integration.enums;

/**
 * CanvasAttachType class.
 *
 * @author simon
 * @date 2025/9/8
 */
public enum CanvasAttachType {
    DASHBOARD, DEVICE;

    @Override
    public String toString() {
        return name();
    }
}
