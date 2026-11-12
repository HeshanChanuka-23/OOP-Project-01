package com.econest.reports.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Objects;

/** Monthly confirmations and cancellation adjustments (not order status snapshots). */
public final class SalesReport {
    private final YearMonth month;
    private final BigDecimal grossConfirmedRevenue;
    private final BigDecimal cancellationAmount;
    private final BigDecimal totalRevenue;
    private final int confirmedOrderCount;
    private final int cancelledOrderCount;
    private final LocalDateTime generatedAt;

    public SalesReport(YearMonth month, BigDecimal grossConfirmedRevenue, BigDecimal cancellationAmount,
                       int confirmedOrderCount, int cancelledOrderCount, LocalDateTime generatedAt) {
        this.month = Objects.requireNonNull(month);
        this.grossConfirmedRevenue = nonNegative(grossConfirmedRevenue);
        this.cancellationAmount = nonNegative(cancellationAmount);
        if (confirmedOrderCount < 0 || cancelledOrderCount < 0) throw new IllegalArgumentException("Negative counts");
        this.confirmedOrderCount = confirmedOrderCount;
        this.cancelledOrderCount = cancelledOrderCount;
        this.generatedAt = Objects.requireNonNull(generatedAt);
        this.totalRevenue = this.grossConfirmedRevenue.subtract(this.cancellationAmount);
    }
    private static BigDecimal nonNegative(BigDecimal number) {
        if (number == null || number.signum() < 0) throw new IllegalArgumentException("Amount must be nonnegative");
        return number;
    }
    public YearMonth getMonth() { return month; }
    public BigDecimal getGrossConfirmedRevenue() { return grossConfirmedRevenue; }
    public BigDecimal getCancellationAmount() { return cancellationAmount; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }
    public int getConfirmedOrderCount() { return confirmedOrderCount; }
    public int getCancelledOrderCount() { return cancelledOrderCount; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public String getSummary() {
        return "Sales " + month + " | Gross: " + grossConfirmedRevenue
             + " | Cancellations: " + cancellationAmount + " | Net revenue: " + totalRevenue
             + " | Confirmed: " + confirmedOrderCount + " | Cancelled: " + cancelledOrderCount;
    }
}
