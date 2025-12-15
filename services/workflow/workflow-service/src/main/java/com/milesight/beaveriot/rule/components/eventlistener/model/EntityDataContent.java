package com.milesight.beaveriot.rule.components.eventlistener.model;

import lombok.Data;

import java.util.List;

/**
 * author: chensh
 * create: 2025/12/10
 **/

@Data
public class EntityDataContent {
    List<String> keys;
    List<String> tags;
}
