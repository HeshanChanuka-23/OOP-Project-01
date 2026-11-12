package com.econest.reports.service;

import com.econest.catalog.model.Product;
import com.econest.reports.dao.ReportDAO;
import com.econest.reports.model.InventoryReport;
import com.econest.reports.model.SalesReport;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;

/** Task 7 service: monthly reports are derived, never stored as extra database tables. */
public class ReportService {
    private final ReportDAO dao;
    public ReportService() { this(new ReportDAO()); }
    public ReportService(ReportDAO dao) { this.dao=Objects.requireNonNull(dao); }
    public SalesReport generateMonthlySalesReport(YearMonth month) {
        try { return dao.readSales(Objects.requireNonNull(month)); }
        catch(SQLException ex) { throw new IllegalStateException("Unable to generate monthly sales report: "+ex.getMessage(),ex); }
    }
    public InventoryReport generateMonthlyInventoryReport(YearMonth month) {
        try { return dao.readInventory(Objects.requireNonNull(month)); }
        catch(SQLException ex) { throw new IllegalStateException("Unable to generate inventory report: "+ex.getMessage(),ex); }
    }
    public List<Product> getLowStockAlerts() {
        try { return dao.readCurrentLowStock(); }
        catch(SQLException ex) { throw new IllegalStateException("Unable to load low-stock alerts: "+ex.getMessage(),ex); }
    }
    /** Table display helper; the master class diagram lists only the three core report methods. */
    public List<Object[]> getMonthlyStockRows(YearMonth month) {
        try { return dao.readMonthlyStockRows(Objects.requireNonNull(month)); }
        catch(SQLException ex) { throw new IllegalStateException("Unable to load monthly stock rows: "+ex.getMessage(),ex); }
    }
    public List<Object[]> getCurrentLowStockRows() {
        try { return dao.readLowStockRows(); }
        catch(SQLException ex) { throw new IllegalStateException("Unable to load low-stock rows: "+ex.getMessage(),ex); }
    }
}
