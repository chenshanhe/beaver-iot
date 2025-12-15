package com.milesight.beaveriot.context.api;

import java.util.List;

/**
 * author: chensh
 * create: 2025/12/8
 **/
public interface EntityTagServiceProvider {
    Long createEntityTag(String name, String description, String color);
    Boolean isEntityTagExist(Long id);
    void addTagsToEntities(List<Long> entityIds, List<Long> tagIds);
}
