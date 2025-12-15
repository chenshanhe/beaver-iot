package com.milesight.beaveriot.entity.service;

import com.milesight.beaveriot.base.utils.snowflake.SnowflakeUtil;
import com.milesight.beaveriot.context.api.EntityTagServiceProvider;
import com.milesight.beaveriot.entity.po.EntityTagPO;
import com.milesight.beaveriot.entity.repository.EntityTagMappingRepository;
import com.milesight.beaveriot.entity.repository.EntityTagRepository;
import com.milesight.beaveriot.permission.enums.DataPermissionType;
import com.milesight.beaveriot.permission.helper.TemporaryPermission;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chensh
 * @date 2025/12/8
 */
@Slf4j
@Service
public class EntityTagProviderServiceImpl implements EntityTagServiceProvider {
    @Autowired
    private EntityTagRepository entityTagRepository;

    @Autowired
    private EntityTagService entityTagService;

    @Autowired
    private EntityTagMappingRepository entityTagMappingRepository;

    @Autowired
    private EntityService entityService;


    @Override
    public Long createEntityTag(String name, String description, String color) {
        Long id = SnowflakeUtil.nextId();
        val entityTag = EntityTagPO.builder()
                .id(id)
                .name(name)
                .description(description)
                .color(color)
                .build();
        entityTagRepository.save(entityTag);
        return id;
    }

    @Override
    public Boolean isEntityTagExist(Long id) {
        return entityTagRepository.existsById(id);
    }

    @Override
    public void addTagsToEntities(List<Long> entityIds, List<Long> tagIds) {

        TemporaryPermission.with(DataPermissionType.ENTITY, "system")
                .run(() -> {
                    entityTagService.addTagsToEntities(entityIds, tagIds);
                });
    }

}
