package com.milesight.beaveriot.context.integration.model;

import com.milesight.beaveriot.base.enums.EntityErrorCode;
import com.milesight.beaveriot.base.error.ErrorHolder;
import com.milesight.beaveriot.base.utils.ValidationUtils;
import com.milesight.beaveriot.context.api.DeviceServiceProvider;
import com.milesight.beaveriot.context.api.IntegrationServiceProvider;
import com.milesight.beaveriot.context.constants.IntegrationConstants;
import com.milesight.beaveriot.context.integration.enums.AccessMod;
import com.milesight.beaveriot.context.integration.enums.EntityType;
import com.milesight.beaveriot.context.integration.enums.EntityValueType;
import com.milesight.beaveriot.context.integration.enums.ValueStoreMod;
import com.milesight.beaveriot.context.integration.support.ValueStoreModSupport;
import com.milesight.beaveriot.context.support.EntityValidator;
import com.milesight.beaveriot.context.support.SpringContext;
import com.milesight.beaveriot.eventbus.api.IdentityKey;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author chensh
 */
@Getter
@Setter
public class WorkFlow {
    private String id;

    private String name;

    private String remark;

    private Boolean enabled = false;

    private String designData;

    private Integer version;
}
