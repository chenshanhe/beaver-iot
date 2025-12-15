package com.milesight.beaveriot.context.api;

/**
 * author: chensh
 * create: 2025/12/8 13:17
 **/
public interface DeviceGroupServiceProvider {
    Long createDeviceGroup(String deviceGroupName);
    Boolean isDeviceGroupExist(Long deviceGroupId);
}
