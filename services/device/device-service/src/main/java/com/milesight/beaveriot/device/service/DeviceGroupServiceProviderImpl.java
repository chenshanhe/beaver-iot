package com.milesight.beaveriot.device.service;

import com.milesight.beaveriot.base.annotations.shedlock.DistributedLock;
import com.milesight.beaveriot.base.utils.snowflake.SnowflakeUtil;
import com.milesight.beaveriot.context.api.DeviceGroupServiceProvider;
import com.milesight.beaveriot.device.po.DeviceGroupPO;
import com.milesight.beaveriot.device.repository.DeviceGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chensh
 * @date 2025/12/8
 */
@Service
@Slf4j
public class DeviceGroupServiceProviderImpl implements DeviceGroupServiceProvider {
    @Autowired
    private DeviceGroupRepository deviceGroupRepository;

    @Override
    @DistributedLock(name = "device-group-#{#p0}", waitForLock = "5s")
    public Long createDeviceGroup(String deviceGroupName) {
        Long id = SnowflakeUtil.nextId();
        DeviceGroupPO deviceGroupPO = new DeviceGroupPO();
        deviceGroupPO.setId(id);
        deviceGroupPO.setName(deviceGroupName);
        deviceGroupRepository.save(deviceGroupPO);
        return id;
    }

    @Override
    public Boolean isDeviceGroupExist(Long deviceGroupId) {
        return deviceGroupRepository.existsById(deviceGroupId);
    }
}
