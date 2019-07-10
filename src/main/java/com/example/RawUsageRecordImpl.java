package com.example;

import org.joda.time.LocalDate;
import org.killbill.billing.usage.api.RawUsageRecord;

import java.util.UUID;

public class RawUsageRecordImpl implements RawUsageRecord {

    public RawUsageRecordImpl(UUID subscriptionId, LocalDate date, String unitType, Long amount, String trackingId) {
        this.subscriptionId = subscriptionId;
        this.date = date;
        this.unitType = unitType;
        this.amount = amount;
        this.trackingId = trackingId;
    }

    private UUID subscriptionId;
    private LocalDate date;
    private String unitType;
    private Long amount;
    private String trackingId;

    @Override
    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getUnitType() {
        return unitType;
    }

    @Override
    public Long getAmount() {
        return amount;
    }

    @Override
    public String getTrackingId() {
        return trackingId;
    }
}
