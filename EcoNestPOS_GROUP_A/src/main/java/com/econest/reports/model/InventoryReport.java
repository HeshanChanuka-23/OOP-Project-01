package com.econest.reports.model;

import com.econest.catalog.model.Product;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Month-end reconstructed from journal. Low-stock list is current, not historical. */
public final class InventoryReport {
    private final YearMonth month;
    private final LocalDateTime generatedAt;
    private final int monthEndTotalUnits;
    private final int currentLowStockCount;
    private final int stockInUnits;
    private final int stockOutUnits;
    private final List<Product> currentLowStockProducts;

    public InventoryReport(YearMonth month, LocalDateTime generatedAt, int monthEndTotalUnits,
            int stockInUnits, int stockOutUnits, List<Product> currentLowStockProducts) {
        this.month = Objects.requireNonNull(month);
        this.generatedAt = Objects.requireNonNull(generatedAt);
        if (monthEndTotalUnits < 0 || stockInUnits < 0 || stockOutUnits < 0)
            throw new IllegalArgumentException("Negative stock totals in journal");
        this.monthEndTotalUnits = monthEndTotalUnits;
        this.stockInUnits = stockInUnits;
        this.stockOutUnits = stockOutUnits;
        this.currentLowStockProducts = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(currentLowStockProducts)));
        this.currentLowStockCount = this.currentLowStockProducts.size();
    }
    public YearMonth getMonth() { return month; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public int getMonthEndTotalUnits() { return monthEndTotalUnits; }
    public int getCurrentLowStockCount() { return currentLowStockCount; }
    public int getStockInUnits() { return stockInUnits; }
    public int getStockOutUnits() { return stockOutUnits; }
    public List<Product> getCurrentLowStockProducts() { return currentLowStockProducts; }
    public List<Product> getLowStockProducts() { return currentLowStockProducts; }
    public String getSummary() {
        return "Inventory " + month + " | Month-end units: " + monthEndTotalUnits
             + " | In: " + stockInUnits + " | Out: " + stockOutUnits
             + " | Low stock now: " + currentLowStockCount;
    }
}
