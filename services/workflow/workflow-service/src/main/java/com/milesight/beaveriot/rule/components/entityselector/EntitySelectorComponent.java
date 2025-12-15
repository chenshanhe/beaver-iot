package com.milesight.beaveriot.rule.components.entityselector;

import com.milesight.beaveriot.base.utils.JsonUtils;
import com.milesight.beaveriot.context.api.EntityValueServiceProvider;
import com.milesight.beaveriot.context.integration.model.ExchangePayload;
import com.milesight.beaveriot.entity.repository.EntityTagMappingRepository;
import com.milesight.beaveriot.rule.annotations.OutputArguments;
import com.milesight.beaveriot.rule.annotations.RuleNode;
import com.milesight.beaveriot.rule.annotations.UriParamExtension;
import com.milesight.beaveriot.rule.api.ProcessorNode;
import com.milesight.beaveriot.rule.components.entityselector.model.EntityDataContent;
import com.milesight.beaveriot.rule.constants.RuleNodeType;
import com.milesight.beaveriot.rule.support.SpELExpressionHelper;
import com.milesight.beaveriot.rule.util.WorkflowEntityHelper;
import lombok.Data;
import org.apache.camel.Exchange;
import org.apache.camel.spi.UriParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author loong
 * @date 2024/12/18 8:47
 */
@RuleNode(value = "entitySelector", type = RuleNodeType.ACTION, description = "EntitySelector", testable = false)
@Data
public class EntitySelectorComponent implements ProcessorNode<Exchange> {

    //    @OutputArguments
//    @UriParam(javaType = "java.util.List", prefix = "bean", displayName = "Entity Select Setting")
//    @UriParamExtension(uiComponent = "entityMultipleSelect")
    private List<String> entities;

    @OutputArguments
    @UriParamExtension(uiComponent = "entityDataSelect")
    @UriParam(prefix = "bean", displayName = "Entity Select Setting", description = "The entities select")
    private EntityDataContent entityData;


    @Autowired
    EntityValueServiceProvider entityValueServiceProvider;

    @Autowired
    WorkflowEntityHelper workflowEntityHelper;

    @Autowired
    EntityTagMappingRepository entityTagMappingRepository;

    @Override
    public void processor(Exchange exchange) {

        List<String> entityList = new ArrayList<>();

        if (entityData != null && !CollectionUtils.isEmpty(entityData.getTags())) {
            List<Long> tags = entityData.getTags().stream().filter(Objects::nonNull).map(o -> Long.parseLong(o)).collect(Collectors.toList());
            entityList = entityTagMappingRepository.findEntityKeysByTagIdIn(tags);
        }

        if (!CollectionUtils.isEmpty(entities)) {
            entityList = entities;
        }
        if (entityData != null && !CollectionUtils.isEmpty(entityData.getKeys())) {
            entityList = entityData.getKeys();
        }
        List<String> entitiesVariables = SpELExpressionHelper.resolveExpression(exchange, entityList);
        workflowEntityHelper.checkEntityExist(entitiesVariables);
        Map<String, Object> entityValues = entityValueServiceProvider.findValuesByKeys(entitiesVariables);
        ExchangePayload exchangePayload = ExchangePayload.create(entityValues);
        exchange.getIn().setBody(exchangePayload);
    }


    public void setEntityData(String entityDataStr) {
        this.entityData = JsonUtils.fromJSON(entityDataStr, EntityDataContent.class);
    }
}
