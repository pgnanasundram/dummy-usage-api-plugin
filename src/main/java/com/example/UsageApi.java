package com.example;

import org.joda.time.LocalDate;
import org.killbill.billing.usage.api.RawUsageRecord;
import org.killbill.billing.usage.plugin.api.UsagePluginApi;
import org.killbill.billing.util.callcontext.TenantContext;
import org.osgi.service.log.LogService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class UsageApi implements UsagePluginApi {

    private LogService logService;

    public UsageApi(LogService logService) {
        this.logService = logService;
    }

    @Override
    public List<RawUsageRecord> geUsageForAccount(LocalDate startDate, LocalDate endDate, TenantContext context) {
        logService.log(LogService.LOG_INFO, "Entering getUsageForAccount");

        return Collections.singletonList(
                new RawUsageRecordImpl(UUID.randomUUID(), LocalDate.now(), "myProduct", 9L, "myTrackingId")
        );
    }
}
