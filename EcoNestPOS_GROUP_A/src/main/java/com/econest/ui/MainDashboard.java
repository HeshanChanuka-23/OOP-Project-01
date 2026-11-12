package com.econest.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * EcoNest shared dashboard — fully NetBeans GUI Builder managed.
 *
 * Every visible panel, label and button is defined in MainDashboard.form,
 * with corresponding generated component code in initComponents().
 * There are no dynamically constructed UI elements.
 *
 * The only non-GUI-builder code below switches between EXISTING CardLayout
 * panels that are already defined in MainDashboard.form.
 */
public class MainDashboard extends javax.swing.JFrame {

    private static final Color FOREST = new Color(24, 55, 45);
    private static final Color ACTIVE = new Color(40, 83, 65);

    public MainDashboard() {
        initComponents();
        setMinimumSize(new Dimension(1020, 680));
        setSize(1220, 780);
        setLocationRelativeTo(null);
        prepareProductTable();
        prepareInventoryTables();
        prepareClientTable();
        prepareAgentTable();
        prepareOrderTables();
        prepareDeliveryTables();
        prepareReportTables();
        prepareEmailTable();
        configureConsistentScrolling();
        showPage("dashboard");
    }

    /** Show a panel that ALREADY EXISTS in the GUI Builder CardLayout. */
    public final void showPage(String pageKey) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, pageKey);
        if ("dashboard".equals(pageKey)) refreshDashboardMetrics();
        if ("products".equals(pageKey)) refreshProductTable();
        if ("inventory".equals(pageKey)) refreshInventoryData();
        if ("clients".equals(pageKey)) refreshClientTable();
        if ("agents".equals(pageKey)) refreshAgentTable();
        if ("orders".equals(pageKey)) refreshOrdersData();
        if ("deliveries".equals(pageKey)) refreshDeliveriesData();
        if ("emails".equals(pageKey)) refreshEmailTable();
        switch (pageKey) {
            case "dashboard": headerTitleLabel.setText("Overview Dashboard"); break;
            case "products": headerTitleLabel.setText("Products"); break;
            case "inventory": headerTitleLabel.setText("Inventory"); break;
            case "clients": headerTitleLabel.setText("Clients"); break;
            case "agents": headerTitleLabel.setText("Delivery Agents"); break;
            case "orders": headerTitleLabel.setText("Orders"); break;
            case "deliveries": headerTitleLabel.setText("Deliveries"); break;
            case "reports": headerTitleLabel.setText("Reports"); break;
            case "emails": headerTitleLabel.setText("Email Notifications"); break;
            default: throw new IllegalArgumentException("Unknown page: " + pageKey);
        }
        headerSubtitleLabel.setText("dashboard".equals(pageKey)
                ? "Your sustainable retail workspace"
                : "EcoNest POS / " + headerTitleLabel.getText());
        statusLabel.setText("EcoNest POS  |  " + headerTitleLabel.getText() + "  |  Store operations");
        btnDashboard.setBackground("dashboard".equals(pageKey) ? ACTIVE : FOREST);
        btnProducts.setBackground("products".equals(pageKey) ? ACTIVE : FOREST);
        btnInventory.setBackground("inventory".equals(pageKey) ? ACTIVE : FOREST);
        btnClients.setBackground("clients".equals(pageKey) ? ACTIVE : FOREST);
        btnDeliveryAgents.setBackground("agents".equals(pageKey) ? ACTIVE : FOREST);
        btnOrders.setBackground("orders".equals(pageKey) ? ACTIVE : FOREST);
        btnDeliveries.setBackground("deliveries".equals(pageKey) ? ACTIVE : FOREST);
        btnReports.setBackground("reports".equals(pageKey) ? ACTIVE : FOREST);
        btnEmailNotifications.setBackground("emails".equals(pageKey) ? ACTIVE : FOREST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        sidebarPanel = new javax.swing.JPanel();
        brandPanel = new javax.swing.JPanel();
        brandTitleLabel = new javax.swing.JLabel();
        brandTaglineLabel = new javax.swing.JLabel();
        navigationPanel = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnClients = new javax.swing.JButton();
        btnDeliveryAgents = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        btnDeliveries = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnEmailNotifications = new javax.swing.JButton();
        sidebarFooterLabel = new javax.swing.JLabel();
        workspacePanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerTitleBlock = new javax.swing.JPanel();
        headerTitleLabel = new javax.swing.JLabel();
        headerSubtitleLabel = new javax.swing.JLabel();
        headerModeLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        dashboardPage = new javax.swing.JPanel();
        heroPanel = new javax.swing.JPanel();
        heroTextPanel = new javax.swing.JPanel();
        heroEyebrowLabel = new javax.swing.JLabel();
        heroHeadlineLabel = new javax.swing.JLabel();
        heroDescriptionLabel = new javax.swing.JLabel();
        homeBodyPanel = new javax.swing.JPanel();
        metricsSectionPanel = new javax.swing.JPanel();
        metricsHeadingPanel = new javax.swing.JPanel();
        metricsHeadingPanelTitle = new javax.swing.JLabel();
        metricsHeadingPanelCaption = new javax.swing.JLabel();
        metricGridPanel = new javax.swing.JPanel();
        metricProductsPanel = new javax.swing.JPanel();
        metricProductsTitle = new javax.swing.JLabel();
        metricProductsValue = new javax.swing.JLabel();
        metricProductsCaption = new javax.swing.JLabel();
        metricInventoryPanel = new javax.swing.JPanel();
        metricInventoryTitle = new javax.swing.JLabel();
        metricInventoryValue = new javax.swing.JLabel();
        metricInventoryCaption = new javax.swing.JLabel();
        metricOrdersPanel = new javax.swing.JPanel();
        metricOrdersTitle = new javax.swing.JLabel();
        metricOrdersValue = new javax.swing.JLabel();
        metricOrdersCaption = new javax.swing.JLabel();
        metricSalesPanel = new javax.swing.JPanel();
        metricSalesTitle = new javax.swing.JLabel();
        metricSalesValue = new javax.swing.JLabel();
        metricSalesCaption = new javax.swing.JLabel();
        quickSectionPanel = new javax.swing.JPanel();
        quickHeadingPanel = new javax.swing.JPanel();
        quickHeadingPanelTitle = new javax.swing.JLabel();
        quickHeadingPanelCaption = new javax.swing.JLabel();
        quickGridPanel = new javax.swing.JPanel();
        quickProductsPanel = new javax.swing.JPanel();
        quickProductsTextPanel = new javax.swing.JPanel();
        quickProductsTitle = new javax.swing.JLabel();
        quickProductsCaption = new javax.swing.JLabel();
        quickProductsButton = new javax.swing.JButton();
        quickInventoryPanel = new javax.swing.JPanel();
        quickInventoryTextPanel = new javax.swing.JPanel();
        quickInventoryTitle = new javax.swing.JLabel();
        quickInventoryCaption = new javax.swing.JLabel();
        quickInventoryButton = new javax.swing.JButton();
        quickOrdersPanel = new javax.swing.JPanel();
        quickOrdersTextPanel = new javax.swing.JPanel();
        quickOrdersTitle = new javax.swing.JLabel();
        quickOrdersCaption = new javax.swing.JLabel();
        quickOrdersButton = new javax.swing.JButton();
        quickReportsPanel = new javax.swing.JPanel();
        quickReportsTextPanel = new javax.swing.JPanel();
        quickReportsTitle = new javax.swing.JLabel();
        quickReportsCaption = new javax.swing.JLabel();
        quickReportsButton = new javax.swing.JButton();
        productsPage = new javax.swing.JPanel();
        productsIntroPanel = new javax.swing.JPanel();
        productsEyebrow = new javax.swing.JLabel();
        productsHeading = new javax.swing.JLabel();
        productsDescription = new javax.swing.JLabel();
        productsDetailsPanel = new javax.swing.JPanel();
        productsTilesPanel = new javax.swing.JPanel();
        productFormPanel = new javax.swing.JPanel();
        productFormHeading = new javax.swing.JPanel();
        productFormTitle = new javax.swing.JLabel();
        productFormCaption = new javax.swing.JLabel();
        productFieldsPanel = new javax.swing.JPanel();
        productNameRow = new javax.swing.JPanel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        productCategoryRow = new javax.swing.JPanel();
        lblProductCategory = new javax.swing.JLabel();
        cmbProductCategory = new javax.swing.JComboBox<>();
        productDescriptionRow = new javax.swing.JPanel();
        lblProductDescription = new javax.swing.JLabel();
        productDescriptionScroll = new javax.swing.JScrollPane();
        txtProductDescription = new javax.swing.JTextArea();
        productPriceRow = new javax.swing.JPanel();
        lblProductPrice = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        productRatingRow = new javax.swing.JPanel();
        lblEcoRating = new javax.swing.JLabel();
        spnEcoRating = new javax.swing.JSpinner();
        productIdRow = new javax.swing.JPanel();
        lblCurrentProduct = new javax.swing.JLabel();
        lblSelectedProductId = new javax.swing.JLabel();
        productActionsPanel = new javax.swing.JPanel();
        btnAddProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnClearProduct = new javax.swing.JButton();
        productTablePanel = new javax.swing.JPanel();
        productTableHeading = new javax.swing.JPanel();
        productTableTitleArea = new javax.swing.JPanel();
        productTableTitle = new javax.swing.JLabel();
        productTableCaption = new javax.swing.JLabel();
        productSearchPanel = new javax.swing.JPanel();
        txtProductSearch = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        btnRefreshProducts = new javax.swing.JButton();
        productTableScroll = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        productTableHint = new javax.swing.JLabel();
        productsModuleStatus = new javax.swing.JLabel();
        inventoryPage = new javax.swing.JPanel();
        inventoryIntroPanel = new javax.swing.JPanel();
        inventoryEyebrow = new javax.swing.JLabel();
        inventoryHeading = new javax.swing.JLabel();
        inventoryDescription = new javax.swing.JLabel();
        inventoryDetailsPanel = new javax.swing.JPanel();
        inventoryTilesPanel = new javax.swing.JPanel();
        invControlsPanel = new javax.swing.JPanel();
        invControlsHeading = new javax.swing.JLabel();
        invControlsScroll = new javax.swing.JScrollPane();
        invInputsPanel = new javax.swing.JPanel();
        lblInvWriteOffSection = new javax.swing.JLabel();
        lblInvReorderSection = new javax.swing.JLabel();
        lblInvReceiveSection = new javax.swing.JLabel();
        invProductRow = new javax.swing.JPanel();
        lblInvProductRow = new javax.swing.JLabel();
        cmbInvProduct = new javax.swing.JComboBox();
        invSupplierRow = new javax.swing.JPanel();
        lblInvSupplierRow = new javax.swing.JLabel();
        cmbInvSupplier = new javax.swing.JComboBox();
        invReceiveQtyRow = new javax.swing.JPanel();
        lblInvReceiveQtyRow = new javax.swing.JLabel();
        spnInvReceiveQty = new javax.swing.JSpinner();
        btnReceiveStock = new javax.swing.JButton();
        invReorderRow = new javax.swing.JPanel();
        lblInvReorderRow = new javax.swing.JLabel();
        spnInvReorder = new javax.swing.JSpinner();
        btnSetReorder = new javax.swing.JButton();
        invWriteOffQtyRow = new javax.swing.JPanel();
        lblInvWriteOffQtyRow = new javax.swing.JLabel();
        spnInvWriteOffQty = new javax.swing.JSpinner();
        invReasonRow = new javax.swing.JPanel();
        lblInvReasonRow = new javax.swing.JLabel();
        txtInvWriteOffReason = new javax.swing.JTextField();
        btnWriteOff = new javax.swing.JButton();
        lblRegisterSupplier = new javax.swing.JLabel();
        invSupplierNameRow = new javax.swing.JPanel();
        lblInvSupplierNameRow = new javax.swing.JLabel();
        txtInvSupplierName = new javax.swing.JTextField();
        invSupplierPhoneRow = new javax.swing.JPanel();
        lblInvSupplierPhoneRow = new javax.swing.JLabel();
        txtInvSupplierPhone = new javax.swing.JTextField();
        invSupplierEmailRow = new javax.swing.JPanel();
        lblInvSupplierEmailRow = new javax.swing.JLabel();
        txtInvSupplierEmail = new javax.swing.JTextField();
        btnRegisterSupplier = new javax.swing.JButton();
        invDataPanel = new javax.swing.JPanel();
        invStockToolbar = new javax.swing.JPanel();
        lblInventoryTable = new javax.swing.JLabel();
        btnShowAllStock = new javax.swing.JButton();
        btnLowStock = new javax.swing.JButton();
        btnReloadInventory = new javax.swing.JButton();
        invStockScroll = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        invHistoryPanel = new javax.swing.JPanel();
        lblStockHistory = new javax.swing.JLabel();
        invHistoryScroll = new javax.swing.JScrollPane();
        tblInvMovements = new javax.swing.JTable();
        inventoryModuleStatus = new javax.swing.JLabel();
        clientsPage = new javax.swing.JPanel();
        clientsIntroPanel = new javax.swing.JPanel();
        clientsEyebrow = new javax.swing.JLabel();
        clientsHeading = new javax.swing.JLabel();
        clientsDescription = new javax.swing.JLabel();
        clientsDetailsPanel = new javax.swing.JPanel();
        clientsTilesPanel = new javax.swing.JPanel();
        clientFormPanel = new javax.swing.JPanel();
        clientFormHeading = new javax.swing.JPanel();
        clientFormTitle = new javax.swing.JLabel();
        clientFormCaption = new javax.swing.JLabel();
        clientFieldsPanel = new javax.swing.JPanel();
        clientNameRow = new javax.swing.JPanel();
        lblClientName = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        clientTypeRow = new javax.swing.JPanel();
        lblClientType = new javax.swing.JLabel();
        cmbClientType = new javax.swing.JComboBox<>();
        clientAddressRow = new javax.swing.JPanel();
        lblClientAddress = new javax.swing.JLabel();
        clientAddressScroll = new javax.swing.JScrollPane();
        txtClientAddress = new javax.swing.JTextArea();
        clientEmailRow = new javax.swing.JPanel();
        lblClientEmail = new javax.swing.JLabel();
        txtClientEmail = new javax.swing.JTextField();
        clientPhoneRow = new javax.swing.JPanel();
        lblClientPhone = new javax.swing.JLabel();
        txtClientPhone = new javax.swing.JTextField();
        clientIdRow = new javax.swing.JPanel();
        lblCurrentClient = new javax.swing.JLabel();
        lblSelectedClientId = new javax.swing.JLabel();
        clientActionsPanel = new javax.swing.JPanel();
        btnAddClient = new javax.swing.JButton();
        btnUpdateClient = new javax.swing.JButton();
        btnDeleteClient = new javax.swing.JButton();
        btnClearClient = new javax.swing.JButton();
        clientTablePanel = new javax.swing.JPanel();
        clientTableHeading = new javax.swing.JPanel();
        clientTableTitleArea = new javax.swing.JPanel();
        clientTableTitle = new javax.swing.JLabel();
        clientTableCaption = new javax.swing.JLabel();
        clientSearchPanel = new javax.swing.JPanel();
        txtClientSearch = new javax.swing.JTextField();
        btnSearchClient = new javax.swing.JButton();
        btnRefreshClients = new javax.swing.JButton();
        clientTableScroll = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        clientTableHint = new javax.swing.JLabel();
        clientsModuleStatus = new javax.swing.JLabel();
        agentsPage = new javax.swing.JPanel();
        agentsIntroPanel = new javax.swing.JPanel();
        agentsEyebrow = new javax.swing.JLabel();
        agentsHeading = new javax.swing.JLabel();
        agentsDescription = new javax.swing.JLabel();
        agentsDetailsPanel = new javax.swing.JPanel();
        agentsTilesPanel = new javax.swing.JPanel();
        agentFormPanel = new javax.swing.JPanel();
        agentFormHeading = new javax.swing.JPanel();
        agentFormTitle = new javax.swing.JLabel();
        agentFormCaption = new javax.swing.JLabel();
        agentFieldsPanel = new javax.swing.JPanel();
        agentNameRow = new javax.swing.JPanel();
        lblAgentName = new javax.swing.JLabel();
        txtAgentName = new javax.swing.JTextField();
        agentVehicleTypeRow = new javax.swing.JPanel();
        lblAgentVehicleType = new javax.swing.JLabel();
        cmbAgentVehicleType = new javax.swing.JComboBox<>();
        agentVehicleNumberRow = new javax.swing.JPanel();
        lblAgentVehicleNumber = new javax.swing.JLabel();
        agentVehicleNumberScroll = new javax.swing.JScrollPane();
        txtAgentVehicleNumber = new javax.swing.JTextArea();
        agentEmailRow = new javax.swing.JPanel();
        lblAgentEmail = new javax.swing.JLabel();
        txtAgentEmail = new javax.swing.JTextField();
        agentPhoneRow = new javax.swing.JPanel();
        lblAgentPhone = new javax.swing.JLabel();
        txtAgentPhone = new javax.swing.JTextField();
        agentIdRow = new javax.swing.JPanel();
        lblCurrentAgent = new javax.swing.JLabel();
        lblSelectedAgentId = new javax.swing.JLabel();
        agentActionsPanel = new javax.swing.JPanel();
        btnAddAgent = new javax.swing.JButton();
        btnUpdateAgent = new javax.swing.JButton();
        btnDeleteAgent = new javax.swing.JButton();
        btnClearAgent = new javax.swing.JButton();
        agentTablePanel = new javax.swing.JPanel();
        agentTableHeading = new javax.swing.JPanel();
        agentTableTitleArea = new javax.swing.JPanel();
        agentTableTitle = new javax.swing.JLabel();
        agentTableCaption = new javax.swing.JLabel();
        agentSearchPanel = new javax.swing.JPanel();
        txtAgentSearch = new javax.swing.JTextField();
        btnSearchAgent = new javax.swing.JButton();
        btnRefreshAgents = new javax.swing.JButton();
        agentTableScroll = new javax.swing.JScrollPane();
        tblAgents = new javax.swing.JTable();
        agentTableHint = new javax.swing.JLabel();
        agentsModuleStatus = new javax.swing.JLabel();
        ordersPage = new javax.swing.JPanel();
        ordersIntroPanel = new javax.swing.JPanel();
        ordersEyebrow = new javax.swing.JLabel();
        ordersHeading = new javax.swing.JLabel();
        ordersDescription = new javax.swing.JLabel();
        ordersDetailsPanel = new javax.swing.JPanel();
        ordersTilesPanel = new javax.swing.JPanel();
        ordControlsPanel = new javax.swing.JPanel();
        ordControlsHeading = new javax.swing.JLabel();
        ordControlsScroll = new javax.swing.JScrollPane();
        ordInputsPanel = new javax.swing.JPanel();
        lblOrdFinalizeSection = new javax.swing.JLabel();
        lblOrdItemsSection = new javax.swing.JLabel();
        lblOrdStartSection = new javax.swing.JLabel();
        ordClientRow = new javax.swing.JPanel();
        lblOrdClient = new javax.swing.JLabel();
        cmbOrdClient = new javax.swing.JComboBox();
        ordProductRow = new javax.swing.JPanel();
        lblOrdProduct = new javax.swing.JLabel();
        cmbOrdProduct = new javax.swing.JComboBox();
        ordQtyRow = new javax.swing.JPanel();
        lblOrdQty = new javax.swing.JLabel();
        spnOrdQty = new javax.swing.JSpinner();
        btnAddOrderItem = new javax.swing.JButton();
        ordLineCountRow = new javax.swing.JPanel();
        lblOrdLineCount = new javax.swing.JLabel();
        spnOrdLineCount = new javax.swing.JSpinner();
        btnRemoveOrderItem = new javax.swing.JButton();
        ordStockRow = new javax.swing.JPanel();
        lblOrdStock = new javax.swing.JLabel();
        spnOrdStock = new javax.swing.JSpinner();
        ordTotalRow = new javax.swing.JPanel();
        lblOrdTotal = new javax.swing.JLabel();
        txtOrdTotal = new javax.swing.JTextField();
        btnConfirmOrder = new javax.swing.JButton();
        lblOrdDetailsHeading = new javax.swing.JLabel();
        ordSearchRow = new javax.swing.JPanel();
        lblOrdSearch = new javax.swing.JLabel();
        txtOrdSearch = new javax.swing.JTextField();
        ordOrderIdRow = new javax.swing.JPanel();
        lblOrdSelectedOrder = new javax.swing.JLabel();
        txtOrdSelectedOrder = new javax.swing.JTextField();
        ordOrderStatusRow = new javax.swing.JPanel();
        lblOrdStatus = new javax.swing.JLabel();
        txtOrdStatus = new javax.swing.JTextField();
        btnCancelOrder = new javax.swing.JButton();
        ordDataPanel = new javax.swing.JPanel();
        ordOrdersToolbar = new javax.swing.JPanel();
        lblOrdersTable = new javax.swing.JLabel();
        btnCreateOrder = new javax.swing.JButton();
        btnCalculateOrderTotal = new javax.swing.JButton();
        btnRefreshOrders = new javax.swing.JButton();
        ordOrdersScroll = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        ordItemsPanel = new javax.swing.JPanel();
        lblOrderItems = new javax.swing.JLabel();
        ordItemsScroll = new javax.swing.JScrollPane();
        tblOrderItems = new javax.swing.JTable();
        ordersModuleStatus = new javax.swing.JLabel();
        deliveriesPage = new javax.swing.JPanel();
        deliveriesIntroPanel = new javax.swing.JPanel();
        deliveriesEyebrow = new javax.swing.JLabel();
        deliveriesHeading = new javax.swing.JLabel();
        deliveriesDescription = new javax.swing.JLabel();
        deliveriesDetailsPanel = new javax.swing.JPanel();
        deliveriesTilesPanel = new javax.swing.JPanel();
        delControlsPanel = new javax.swing.JPanel();
        delControlsHeading = new javax.swing.JLabel();
        delControlsScroll = new javax.swing.JScrollPane();
        delInputsPanel = new javax.swing.JPanel();
        lblDelScheduleSection = new javax.swing.JLabel();
        lblDelAssignSection = new javax.swing.JLabel();
        delOrderRow = new javax.swing.JPanel();
        lblDelOrder = new javax.swing.JLabel();
        cmbDelOrder = new javax.swing.JComboBox();
        delAgentRow = new javax.swing.JPanel();
        lblDelAgent = new javax.swing.JLabel();
        cmbDelAgent = new javax.swing.JComboBox();
        delScheduleRow = new javax.swing.JPanel();
        lblDelSchedule = new javax.swing.JLabel();
        txtDelSchedule = new javax.swing.JTextField();
        btnDelAssign = new javax.swing.JButton();
        delIdRow = new javax.swing.JPanel();
        lblDelId = new javax.swing.JLabel();
        txtDelId = new javax.swing.JTextField();
        btnDelSchedule = new javax.swing.JButton();
        delStatusRow = new javax.swing.JPanel();
        lblDelStatus = new javax.swing.JLabel();
        txtDelStatus = new javax.swing.JTextField();
        delReasonRow = new javax.swing.JPanel();
        lblDelReason = new javax.swing.JLabel();
        txtDelReason = new javax.swing.JTextField();
        btnDelDispatch = new javax.swing.JButton();
        lblDelActionsHeading = new javax.swing.JLabel();
        delSearchRow = new javax.swing.JPanel();
        lblDelSearch = new javax.swing.JLabel();
        txtDelSearch = new javax.swing.JTextField();
        delAgentInfoRow = new javax.swing.JPanel();
        lblDelAgentInfo = new javax.swing.JLabel();
        txtDelAgentInfo = new javax.swing.JTextField();
        delScheduleInfoRow = new javax.swing.JPanel();
        lblDelScheduleInfo = new javax.swing.JLabel();
        txtDelScheduleInfo = new javax.swing.JTextField();
        btnDelCancel = new javax.swing.JButton();
        delDataPanel = new javax.swing.JPanel();
        delDeliveriesToolbar = new javax.swing.JPanel();
        lblDeliveriesTable = new javax.swing.JLabel();
        btnDelDelivered = new javax.swing.JButton();
        btnDelFailed = new javax.swing.JButton();
        btnDelRefresh = new javax.swing.JButton();
        delDeliveriesScroll = new javax.swing.JScrollPane();
        tblDeliveries = new javax.swing.JTable();
        delOrdersPanel = new javax.swing.JPanel();
        lblDelOrders = new javax.swing.JLabel();
        delOrdersScroll = new javax.swing.JScrollPane();
        tblDelOrders = new javax.swing.JTable();
        deliveriesModuleStatus = new javax.swing.JLabel();
        reportsPage = new javax.swing.JPanel();
        reportsIntroPanel = new javax.swing.JPanel();
        reportsEyebrow = new javax.swing.JLabel();
        reportsHeading = new javax.swing.JLabel();
        reportsDescription = new javax.swing.JLabel();
        reportsDetailsPanel = new javax.swing.JPanel();
        reportsTilesPanel = new javax.swing.JPanel();
        reportToolbarPanel = new javax.swing.JPanel();
        reportPickerPanel = new javax.swing.JPanel();
        lblReportMonth = new javax.swing.JLabel();
        cmbReportMonth = new javax.swing.JComboBox();
        lblReportYear = new javax.swing.JLabel();
        txtReportYear = new javax.swing.JTextField();
        btnGenerateReport = new javax.swing.JButton();
        reportBodyPanel = new javax.swing.JPanel();
        reportMetricsPanel = new javax.swing.JPanel();
        reportCardGross = new javax.swing.JPanel();
        reportCardTitleGross = new javax.swing.JLabel();
        lblReportGross = new javax.swing.JLabel();
        reportCardCancelled = new javax.swing.JPanel();
        reportCardTitleCancelled = new javax.swing.JLabel();
        lblReportCancelled = new javax.swing.JLabel();
        reportCardNet = new javax.swing.JPanel();
        reportCardTitleNet = new javax.swing.JLabel();
        lblReportNet = new javax.swing.JLabel();
        reportCardOrderCount = new javax.swing.JPanel();
        reportCardTitleOrderCount = new javax.swing.JLabel();
        lblReportOrderCount = new javax.swing.JLabel();
        reportCardEndUnits = new javax.swing.JPanel();
        reportCardTitleEndUnits = new javax.swing.JLabel();
        lblReportEndUnits = new javax.swing.JLabel();
        reportCardStockIn = new javax.swing.JPanel();
        reportCardTitleStockIn = new javax.swing.JLabel();
        lblReportStockIn = new javax.swing.JLabel();
        reportCardStockOut = new javax.swing.JPanel();
        reportCardTitleStockOut = new javax.swing.JLabel();
        lblReportStockOut = new javax.swing.JLabel();
        reportCardLowCount = new javax.swing.JPanel();
        reportCardTitleLowCount = new javax.swing.JLabel();
        lblReportLowCount = new javax.swing.JLabel();
        reportTablesOuterScroll = new javax.swing.JScrollPane();
        reportTablesPanel = new javax.swing.JPanel();
        reportFlowPanel = new javax.swing.JPanel();
        lblReportFlowHeading = new javax.swing.JLabel();
        reportFlowScroll = new javax.swing.JScrollPane();
        tblReportMonthlyStock = new javax.swing.JTable();
        reportLowPanel = new javax.swing.JPanel();
        lblReportLowHeading = new javax.swing.JLabel();
        reportLowScroll = new javax.swing.JScrollPane();
        tblReportLowStock = new javax.swing.JTable();
        lblReportNotice = new javax.swing.JLabel();
        reportsModuleStatus = new javax.swing.JLabel();
        emailsPage = new javax.swing.JPanel();
        emailsIntroPanel = new javax.swing.JPanel();
        emailsEyebrow = new javax.swing.JLabel();
        emailsHeading = new javax.swing.JLabel();
        emailsDescription = new javax.swing.JLabel();
        emailsDetailsPanel = new javax.swing.JPanel();
        emailsTilesPanel = new javax.swing.JPanel();
        emailToolbarPanel = new javax.swing.JPanel();
        emailToolbarTitlePanel = new javax.swing.JPanel();
        lblEmailHeading = new javax.swing.JLabel();
        lblEmailSubtitle = new javax.swing.JLabel();
        emailButtonsPanel = new javax.swing.JPanel();
        cmbEmailFilter = new javax.swing.JComboBox();
        btnEmailRefresh = new javax.swing.JButton();
        btnEmailRetry = new javax.swing.JButton();
        btnEmailRetryAgent = new javax.swing.JButton();
        emailTablePanel = new javax.swing.JPanel();
        lblEmailHistoryHeading = new javax.swing.JLabel();
        emailTableScroll = new javax.swing.JScrollPane();
        tblEmailNotifications = new javax.swing.JTable();
        emailInfoPanel = new javax.swing.JPanel();
        lblEmailConfig = new javax.swing.JLabel();
        lblEmailStats = new javax.swing.JLabel();
        lblEmailNotice = new javax.swing.JLabel();
        emailsModuleStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoNest POS | Management System");
        getContentPane().setLayout(new java.awt.BorderLayout());

        sidebarPanel.setBackground(new java.awt.Color(24, 55, 45));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(235, 700));
        sidebarPanel.setLayout(new java.awt.BorderLayout());

        brandPanel.setBackground(new java.awt.Color(24, 55, 45));
        brandPanel.setPreferredSize(new java.awt.Dimension(235, 98));
        brandPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 7, 8));
        brandPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 0));

        brandTitleLabel.setText("EcoNest");
        brandTitleLabel.setForeground(new java.awt.Color(239, 250, 241));
        brandTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 25));
        brandPanel.add(brandTitleLabel);

        brandTaglineLabel.setText("Sustainable retail POS");
        brandTaglineLabel.setForeground(new java.awt.Color(176, 213, 190));
        brandTaglineLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        brandPanel.add(brandTaglineLabel);


        sidebarPanel.add(brandPanel, java.awt.BorderLayout.NORTH);

        navigationPanel.setBackground(new java.awt.Color(24, 55, 45));
        navigationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 10, 14));
        navigationPanel.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        btnDashboard.setText("   Dashboard");
        btnDashboard.setBackground(new java.awt.Color(40, 83, 65));
        btnDashboard.setForeground(new java.awt.Color(218, 243, 224));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnDashboard.setFocusPainted(false);
        btnDashboard.setBorderPainted(false);
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnDashboardActionPerformed(evt);
            }
        });
        navigationPanel.add(btnDashboard);

        btnProducts.setText("   Products");
        btnProducts.setBackground(new java.awt.Color(24, 55, 45));
        btnProducts.setForeground(new java.awt.Color(218, 243, 224));
        btnProducts.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnProducts.setFocusPainted(false);
        btnProducts.setBorderPainted(false);
        btnProducts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnProductsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnProducts);

        btnInventory.setText("   Inventory");
        btnInventory.setBackground(new java.awt.Color(24, 55, 45));
        btnInventory.setForeground(new java.awt.Color(218, 243, 224));
        btnInventory.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnInventory.setFocusPainted(false);
        btnInventory.setBorderPainted(false);
        btnInventory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnInventoryActionPerformed(evt);
            }
        });
        navigationPanel.add(btnInventory);

        btnClients.setText("   Clients");
        btnClients.setBackground(new java.awt.Color(24, 55, 45));
        btnClients.setForeground(new java.awt.Color(218, 243, 224));
        btnClients.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnClients.setFocusPainted(false);
        btnClients.setBorderPainted(false);
        btnClients.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnClientsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnClients);

        btnDeliveryAgents.setText("   Delivery Agents");
        btnDeliveryAgents.setBackground(new java.awt.Color(24, 55, 45));
        btnDeliveryAgents.setForeground(new java.awt.Color(218, 243, 224));
        btnDeliveryAgents.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnDeliveryAgents.setFocusPainted(false);
        btnDeliveryAgents.setBorderPainted(false);
        btnDeliveryAgents.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeliveryAgents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnDeliveryAgentsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnDeliveryAgents);

        btnOrders.setText("   Orders");
        btnOrders.setBackground(new java.awt.Color(24, 55, 45));
        btnOrders.setForeground(new java.awt.Color(218, 243, 224));
        btnOrders.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnOrders.setFocusPainted(false);
        btnOrders.setBorderPainted(false);
        btnOrders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnOrdersActionPerformed(evt);
            }
        });
        navigationPanel.add(btnOrders);

        btnDeliveries.setText("   Deliveries");
        btnDeliveries.setBackground(new java.awt.Color(24, 55, 45));
        btnDeliveries.setForeground(new java.awt.Color(218, 243, 224));
        btnDeliveries.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnDeliveries.setFocusPainted(false);
        btnDeliveries.setBorderPainted(false);
        btnDeliveries.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeliveries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnDeliveriesActionPerformed(evt);
            }
        });
        navigationPanel.add(btnDeliveries);

        btnReports.setText("   Reports");
        btnReports.setBackground(new java.awt.Color(24, 55, 45));
        btnReports.setForeground(new java.awt.Color(218, 243, 224));
        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnReports.setFocusPainted(false);
        btnReports.setBorderPainted(false);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnReportsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnReports);

        btnEmailNotifications.setText("   Email Notifications");
        btnEmailNotifications.setBackground(new java.awt.Color(24, 55, 45));
        btnEmailNotifications.setForeground(new java.awt.Color(218, 243, 224));
        btnEmailNotifications.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnEmailNotifications.setFocusPainted(false);
        btnEmailNotifications.setBorderPainted(false);
        btnEmailNotifications.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmailNotifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnEmailNotificationsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnEmailNotifications);


        sidebarPanel.add(navigationPanel, java.awt.BorderLayout.CENTER);

        sidebarFooterLabel.setText("SUSTAINABLE RETAIL SOLUTIONS");
        sidebarFooterLabel.setForeground(new java.awt.Color(176, 213, 190));
        sidebarFooterLabel.setFont(new java.awt.Font("Segoe UI", 0, 11));
        sidebarFooterLabel.setPreferredSize(new java.awt.Dimension(235, 44));
        sidebarFooterLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 21, 12, 0));
        sidebarPanel.add(sidebarFooterLabel, java.awt.BorderLayout.SOUTH);


        getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);

        workspacePanel.setBackground(new java.awt.Color(255, 255, 255));
        workspacePanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setPreferredSize(new java.awt.Dimension(700, 88));
        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 28, 12, 28));
        headerPanel.setLayout(new java.awt.BorderLayout());

        headerTitleBlock.setBackground(new java.awt.Color(255, 255, 255));
        headerTitleBlock.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        headerTitleLabel.setText("Overview Dashboard");
        headerTitleLabel.setForeground(new java.awt.Color(35, 55, 44));
        headerTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 22));
        headerTitleBlock.add(headerTitleLabel);

        headerSubtitleLabel.setText("Your sustainable retail workspace");
        headerSubtitleLabel.setForeground(new java.awt.Color(110, 128, 117));
        headerSubtitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 12));
        headerTitleBlock.add(headerSubtitleLabel);


        headerPanel.add(headerTitleBlock, java.awt.BorderLayout.CENTER);

        headerModeLabel.setText("STORE OPERATIONS");
        headerModeLabel.setForeground(new java.awt.Color(30, 100, 59));
        headerModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 11));
        headerModeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 14, 9, 14));
        headerModeLabel.setBackground(new java.awt.Color(225, 244, 231));
        headerModeLabel.setOpaque(true);
        headerPanel.add(headerModeLabel, java.awt.BorderLayout.EAST);


        workspacePanel.add(headerPanel, java.awt.BorderLayout.NORTH);

        contentPanel.setBackground(new java.awt.Color(246, 249, 247));
        contentPanel.setLayout(new java.awt.CardLayout());

        dashboardPage.setBackground(new java.awt.Color(246, 249, 247));
        dashboardPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 27, 18, 27));
        dashboardPage.setLayout(new java.awt.BorderLayout());

        heroPanel.setBackground(new java.awt.Color(40, 83, 65));
        heroPanel.setPreferredSize(new java.awt.Dimension(820, 145));
        heroPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 26, 12, 26));
        heroPanel.setLayout(new java.awt.BorderLayout());

        heroTextPanel.setBackground(new java.awt.Color(40, 83, 65));
        heroTextPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 2));

        heroEyebrowLabel.setText("ECONEST / MANAGEMENT SYSTEM");
        heroEyebrowLabel.setForeground(new java.awt.Color(192, 232, 204));
        heroEyebrowLabel.setFont(new java.awt.Font("Segoe UI", 0, 11));
        heroTextPanel.add(heroEyebrowLabel);

        heroHeadlineLabel.setText("Grow a better business.");
        heroHeadlineLabel.setForeground(new java.awt.Color(255, 255, 255));
        heroHeadlineLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        heroTextPanel.add(heroHeadlineLabel);

        heroDescriptionLabel.setText("One place for products, inventory, orders and deliveries.");
        heroDescriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        heroDescriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        heroTextPanel.add(heroDescriptionLabel);


        heroPanel.add(heroTextPanel, java.awt.BorderLayout.CENTER);


        dashboardPage.add(heroPanel, java.awt.BorderLayout.NORTH);

        homeBodyPanel.setBackground(new java.awt.Color(246, 249, 247));
        homeBodyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 0, 0));
        homeBodyPanel.setLayout(new java.awt.BorderLayout());

        metricsSectionPanel.setBackground(new java.awt.Color(246, 249, 247));
        metricsSectionPanel.setPreferredSize(new java.awt.Dimension(820, 204));
        metricsSectionPanel.setLayout(new java.awt.BorderLayout());

        metricsHeadingPanel.setBackground(new java.awt.Color(246, 249, 247));
        metricsHeadingPanel.setPreferredSize(new java.awt.Dimension(820, 54));
        metricsHeadingPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        metricsHeadingPanelTitle.setText("At a glance");
        metricsHeadingPanelTitle.setForeground(new java.awt.Color(35, 55, 44));
        metricsHeadingPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        metricsHeadingPanel.add(metricsHeadingPanelTitle);

        metricsHeadingPanelCaption.setText("Live database totals — refreshed whenever you open Dashboard.");
        metricsHeadingPanelCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricsHeadingPanelCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        metricsHeadingPanel.add(metricsHeadingPanelCaption);


        metricsSectionPanel.add(metricsHeadingPanel, java.awt.BorderLayout.NORTH);

        metricGridPanel.setBackground(new java.awt.Color(246, 249, 247));
        metricGridPanel.setLayout(new java.awt.GridLayout(1, 4, 13, 0));

        metricProductsPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricProductsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricProductsPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricProductsTitle.setText("PRODUCTS");
        metricProductsTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricProductsTitle.setFont(new java.awt.Font("Segoe UI", 1, 10));
        metricProductsPanel.add(metricProductsTitle);

        metricProductsValue.setText("—");
        metricProductsValue.setForeground(new java.awt.Color(35, 55, 44));
        metricProductsValue.setFont(new java.awt.Font("Segoe UI", 1, 28));
        metricProductsPanel.add(metricProductsValue);

        metricProductsCaption.setText("Catalogue items");
        metricProductsCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricProductsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        metricProductsPanel.add(metricProductsCaption);


        metricGridPanel.add(metricProductsPanel);

        metricInventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricInventoryPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricInventoryPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricInventoryTitle.setText("INVENTORY");
        metricInventoryTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricInventoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 10));
        metricInventoryPanel.add(metricInventoryTitle);

        metricInventoryValue.setText("—");
        metricInventoryValue.setForeground(new java.awt.Color(35, 55, 44));
        metricInventoryValue.setFont(new java.awt.Font("Segoe UI", 1, 28));
        metricInventoryPanel.add(metricInventoryValue);

        metricInventoryCaption.setText("Units available");
        metricInventoryCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricInventoryCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        metricInventoryPanel.add(metricInventoryCaption);


        metricGridPanel.add(metricInventoryPanel);

        metricOrdersPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricOrdersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricOrdersPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricOrdersTitle.setText("ORDERS");
        metricOrdersTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricOrdersTitle.setFont(new java.awt.Font("Segoe UI", 1, 10));
        metricOrdersPanel.add(metricOrdersTitle);

        metricOrdersValue.setText("—");
        metricOrdersValue.setForeground(new java.awt.Color(35, 55, 44));
        metricOrdersValue.setFont(new java.awt.Font("Segoe UI", 1, 28));
        metricOrdersPanel.add(metricOrdersValue);

        metricOrdersCaption.setText("Orders recorded");
        metricOrdersCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricOrdersCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        metricOrdersPanel.add(metricOrdersCaption);


        metricGridPanel.add(metricOrdersPanel);

        metricSalesPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricSalesPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricSalesPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricSalesTitle.setText("SALES");
        metricSalesTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricSalesTitle.setFont(new java.awt.Font("Segoe UI", 1, 10));
        metricSalesPanel.add(metricSalesTitle);

        metricSalesValue.setText("—");
        metricSalesValue.setForeground(new java.awt.Color(35, 55, 44));
        metricSalesValue.setFont(new java.awt.Font("Segoe UI", 1, 28));
        metricSalesPanel.add(metricSalesValue);

        metricSalesCaption.setText("Monthly revenue");
        metricSalesCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricSalesCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        metricSalesPanel.add(metricSalesCaption);


        metricGridPanel.add(metricSalesPanel);


        metricsSectionPanel.add(metricGridPanel, java.awt.BorderLayout.CENTER);


        homeBodyPanel.add(metricsSectionPanel, java.awt.BorderLayout.NORTH);

        quickSectionPanel.setBackground(new java.awt.Color(246, 249, 247));
        quickSectionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 0, 0, 0));
        quickSectionPanel.setLayout(new java.awt.BorderLayout());

        quickHeadingPanel.setBackground(new java.awt.Color(246, 249, 247));
        quickHeadingPanel.setPreferredSize(new java.awt.Dimension(820, 55));
        quickHeadingPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        quickHeadingPanelTitle.setText("Quick access");
        quickHeadingPanelTitle.setForeground(new java.awt.Color(35, 55, 44));
        quickHeadingPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        quickHeadingPanel.add(quickHeadingPanelTitle);

        quickHeadingPanelCaption.setText("Open a workspace to build and test a team module.");
        quickHeadingPanelCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickHeadingPanelCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        quickHeadingPanel.add(quickHeadingPanelCaption);


        quickSectionPanel.add(quickHeadingPanel, java.awt.BorderLayout.NORTH);

        quickGridPanel.setBackground(new java.awt.Color(246, 249, 247));
        quickGridPanel.setLayout(new java.awt.GridLayout(2, 2, 12, 12));

        quickProductsPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickProductsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 16, 9, 13));
        quickProductsPanel.setLayout(new java.awt.BorderLayout());

        quickProductsTextPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickProductsTextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 3));

        quickProductsTitle.setText("Product catalogue");
        quickProductsTitle.setForeground(new java.awt.Color(35, 55, 44));
        quickProductsTitle.setFont(new java.awt.Font("Segoe UI", 1, 13));
        quickProductsTextPanel.add(quickProductsTitle);

        quickProductsCaption.setText("Manage plants, planters and kits");
        quickProductsCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickProductsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        quickProductsTextPanel.add(quickProductsCaption);


        quickProductsPanel.add(quickProductsTextPanel, java.awt.BorderLayout.CENTER);

        quickProductsButton.setText("Open  ›");
        quickProductsButton.setBackground(new java.awt.Color(225, 244, 231));
        quickProductsButton.setForeground(new java.awt.Color(30, 100, 59));
        quickProductsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
        quickProductsButton.setFocusPainted(false);
        quickProductsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        quickProductsButton.setBorderPainted(false);
        quickProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onQuickProductsActionPerformed(evt);
            }
        });
        quickProductsPanel.add(quickProductsButton, java.awt.BorderLayout.EAST);


        quickGridPanel.add(quickProductsPanel);

        quickInventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickInventoryPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 16, 9, 13));
        quickInventoryPanel.setLayout(new java.awt.BorderLayout());

        quickInventoryTextPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickInventoryTextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 3));

        quickInventoryTitle.setText("Inventory control");
        quickInventoryTitle.setForeground(new java.awt.Color(35, 55, 44));
        quickInventoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 13));
        quickInventoryTextPanel.add(quickInventoryTitle);

        quickInventoryCaption.setText("Monitor stock and supplier entries");
        quickInventoryCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickInventoryCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        quickInventoryTextPanel.add(quickInventoryCaption);


        quickInventoryPanel.add(quickInventoryTextPanel, java.awt.BorderLayout.CENTER);

        quickInventoryButton.setText("Open  ›");
        quickInventoryButton.setBackground(new java.awt.Color(225, 244, 231));
        quickInventoryButton.setForeground(new java.awt.Color(30, 100, 59));
        quickInventoryButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
        quickInventoryButton.setFocusPainted(false);
        quickInventoryButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        quickInventoryButton.setBorderPainted(false);
        quickInventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onQuickInventoryActionPerformed(evt);
            }
        });
        quickInventoryPanel.add(quickInventoryButton, java.awt.BorderLayout.EAST);


        quickGridPanel.add(quickInventoryPanel);

        quickOrdersPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickOrdersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 16, 9, 13));
        quickOrdersPanel.setLayout(new java.awt.BorderLayout());

        quickOrdersTextPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickOrdersTextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 3));

        quickOrdersTitle.setText("Order management");
        quickOrdersTitle.setForeground(new java.awt.Color(35, 55, 44));
        quickOrdersTitle.setFont(new java.awt.Font("Segoe UI", 1, 13));
        quickOrdersTextPanel.add(quickOrdersTitle);

        quickOrdersCaption.setText("Process and track client orders");
        quickOrdersCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickOrdersCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        quickOrdersTextPanel.add(quickOrdersCaption);


        quickOrdersPanel.add(quickOrdersTextPanel, java.awt.BorderLayout.CENTER);

        quickOrdersButton.setText("Open  ›");
        quickOrdersButton.setBackground(new java.awt.Color(225, 244, 231));
        quickOrdersButton.setForeground(new java.awt.Color(30, 100, 59));
        quickOrdersButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
        quickOrdersButton.setFocusPainted(false);
        quickOrdersButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        quickOrdersButton.setBorderPainted(false);
        quickOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onQuickOrdersActionPerformed(evt);
            }
        });
        quickOrdersPanel.add(quickOrdersButton, java.awt.BorderLayout.EAST);


        quickGridPanel.add(quickOrdersPanel);

        quickReportsPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickReportsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 16, 9, 13));
        quickReportsPanel.setLayout(new java.awt.BorderLayout());

        quickReportsTextPanel.setBackground(new java.awt.Color(255, 255, 255));
        quickReportsTextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 3));

        quickReportsTitle.setText("Sales reporting");
        quickReportsTitle.setForeground(new java.awt.Color(35, 55, 44));
        quickReportsTitle.setFont(new java.awt.Font("Segoe UI", 1, 13));
        quickReportsTextPanel.add(quickReportsTitle);

        quickReportsCaption.setText("Review monthly performance");
        quickReportsCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickReportsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        quickReportsTextPanel.add(quickReportsCaption);


        quickReportsPanel.add(quickReportsTextPanel, java.awt.BorderLayout.CENTER);

        quickReportsButton.setText("Open  ›");
        quickReportsButton.setBackground(new java.awt.Color(225, 244, 231));
        quickReportsButton.setForeground(new java.awt.Color(30, 100, 59));
        quickReportsButton.setFont(new java.awt.Font("Segoe UI", 0, 12));
        quickReportsButton.setFocusPainted(false);
        quickReportsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        quickReportsButton.setBorderPainted(false);
        quickReportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onQuickReportsActionPerformed(evt);
            }
        });
        quickReportsPanel.add(quickReportsButton, java.awt.BorderLayout.EAST);


        quickGridPanel.add(quickReportsPanel);


        quickSectionPanel.add(quickGridPanel, java.awt.BorderLayout.CENTER);


        homeBodyPanel.add(quickSectionPanel, java.awt.BorderLayout.CENTER);


        dashboardPage.add(homeBodyPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(dashboardPage, "dashboard");

        productsPage.setBackground(new java.awt.Color(246, 249, 247));
        productsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        productsPage.setLayout(new java.awt.BorderLayout());

        productsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        productsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        productsIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        productsEyebrow.setText("ECONEST / PRODUCTS");
        productsEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        productsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        productsIntroPanel.add(productsEyebrow);

        productsHeading.setText("Product Catalogue");
        productsHeading.setForeground(new java.awt.Color(35, 55, 44));
        productsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        productsIntroPanel.add(productsHeading);

        productsDescription.setText("Manage plants, planters, gardening kits, prices and eco-ratings.");
        productsDescription.setForeground(new java.awt.Color(110, 128, 117));
        productsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        productsIntroPanel.add(productsDescription);


        productsPage.add(productsIntroPanel, java.awt.BorderLayout.NORTH);

        productsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        productsDetailsPanel.setLayout(new java.awt.BorderLayout());

        productsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        productsTilesPanel.setLayout(new java.awt.BorderLayout(13, 0));

        productFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        productFormPanel.setPreferredSize(new java.awt.Dimension(343, 445));
        productFormPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        productFormPanel.setLayout(new java.awt.BorderLayout(0, 12));

        productFormHeading.setBackground(new java.awt.Color(255, 255, 255));
        productFormHeading.setPreferredSize(new java.awt.Dimension(310, 50));
        productFormHeading.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        productFormTitle.setText("Product details");
        productFormTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        productFormTitle.setForeground(new java.awt.Color(35, 55, 44));
        productFormHeading.add(productFormTitle);
        productFormCaption.setText("Add or edit a catalogue item");
        productFormCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        productFormCaption.setForeground(new java.awt.Color(110, 128, 117));
        productFormHeading.add(productFormCaption);
        productFormPanel.add(productFormHeading, java.awt.BorderLayout.NORTH);

        productFieldsPanel.setBackground(new java.awt.Color(255, 255, 255));
        productFieldsPanel.setLayout(new java.awt.GridLayout(6, 1, 0, 10));

        productNameRow.setBackground(new java.awt.Color(255, 255, 255));
        productNameRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblProductName.setText("Product name");
        lblProductName.setPreferredSize(new java.awt.Dimension(105, 25));
        productNameRow.add(lblProductName, java.awt.BorderLayout.WEST);
        productNameRow.add(txtProductName, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productNameRow);

        productCategoryRow.setBackground(new java.awt.Color(255, 255, 255));
        productCategoryRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblProductCategory.setText("Category");
        lblProductCategory.setPreferredSize(new java.awt.Dimension(105, 25));
        productCategoryRow.add(lblProductCategory, java.awt.BorderLayout.WEST);
        cmbProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLANT", "PLANTER", "GARDENING_KIT" }));
        productCategoryRow.add(cmbProductCategory, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productCategoryRow);

        productDescriptionRow.setBackground(new java.awt.Color(255, 255, 255));
        productDescriptionRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblProductDescription.setText("Description");
        lblProductDescription.setPreferredSize(new java.awt.Dimension(105, 25));
        productDescriptionRow.add(lblProductDescription, java.awt.BorderLayout.WEST);
        txtProductDescription.setLineWrap(true);
        txtProductDescription.setWrapStyleWord(true);
        productDescriptionScroll.setPreferredSize(new java.awt.Dimension(210, 57));
        productDescriptionScroll.setViewportView(txtProductDescription);
        productDescriptionRow.add(productDescriptionScroll, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productDescriptionRow);

        productPriceRow.setBackground(new java.awt.Color(255, 255, 255));
        productPriceRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblProductPrice.setText("Unit price");
        lblProductPrice.setPreferredSize(new java.awt.Dimension(105, 25));
        productPriceRow.add(lblProductPrice, java.awt.BorderLayout.WEST);
        productPriceRow.add(txtProductPrice, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productPriceRow);

        productRatingRow.setBackground(new java.awt.Color(255, 255, 255));
        productRatingRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblEcoRating.setText("Eco rating");
        lblEcoRating.setPreferredSize(new java.awt.Dimension(105, 25));
        productRatingRow.add(lblEcoRating, java.awt.BorderLayout.WEST);
        spnEcoRating.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        productRatingRow.add(spnEcoRating, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productRatingRow);

        productIdRow.setBackground(new java.awt.Color(255, 255, 255));
        productIdRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblCurrentProduct.setText("Selected ID");
        lblCurrentProduct.setPreferredSize(new java.awt.Dimension(105, 25));
        productIdRow.add(lblCurrentProduct, java.awt.BorderLayout.WEST);
        lblSelectedProductId.setText("New product");
        lblSelectedProductId.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblSelectedProductId.setForeground(new java.awt.Color(66, 130, 97));
        productIdRow.add(lblSelectedProductId, java.awt.BorderLayout.CENTER);
        productFieldsPanel.add(productIdRow);
        productFormPanel.add(productFieldsPanel, java.awt.BorderLayout.CENTER);

        productActionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        productActionsPanel.setPreferredSize(new java.awt.Dimension(310, 98));
        productActionsPanel.setLayout(new java.awt.GridLayout(2, 2, 9, 9));
        btnAddProduct.setText("Add product");
        btnAddProduct.addActionListener(evt -> onAddProduct(evt));
        productActionsPanel.add(btnAddProduct);
        btnUpdateProduct.setText("Update");
        btnUpdateProduct.addActionListener(evt -> onUpdateProduct(evt));
        productActionsPanel.add(btnUpdateProduct);
        btnDeleteProduct.setText("Delete");
        btnDeleteProduct.addActionListener(evt -> onDeleteProduct(evt));
        productActionsPanel.add(btnDeleteProduct);
        btnClearProduct.setText("Clear fields");
        btnClearProduct.addActionListener(evt -> onClearProduct(evt));
        productActionsPanel.add(btnClearProduct);
        productFormPanel.add(productActionsPanel, java.awt.BorderLayout.SOUTH);
        productsTilesPanel.add(productFormPanel, java.awt.BorderLayout.WEST);

        productTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        productTablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        productTablePanel.setLayout(new java.awt.BorderLayout(0, 10));
        productTableHeading.setBackground(new java.awt.Color(255, 255, 255));
        productTableHeading.setPreferredSize(new java.awt.Dimension(500, 93));
        productTableHeading.setLayout(new java.awt.BorderLayout(0, 6));
        productTableTitleArea.setBackground(new java.awt.Color(255, 255, 255));
        productTableTitleArea.setPreferredSize(new java.awt.Dimension(400, 44));
        productTableTitleArea.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        productTableTitle.setText("Available products");
        productTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        productTableTitle.setForeground(new java.awt.Color(35, 55, 44));
        productTableTitleArea.add(productTableTitle);
        productTableCaption.setText("Select a row to update or remove a product");
        productTableCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        productTableCaption.setForeground(new java.awt.Color(110, 128, 117));
        productTableTitleArea.add(productTableCaption);
        productTableHeading.add(productTableTitleArea, java.awt.BorderLayout.NORTH);

        productSearchPanel.setBackground(new java.awt.Color(255, 255, 255));
        productSearchPanel.setPreferredSize(new java.awt.Dimension(500, 38));
        productSearchPanel.setLayout(new java.awt.BorderLayout(8, 0));
        productSearchPanel.add(txtProductSearch, java.awt.BorderLayout.CENTER);
        txtProductSearch.addActionListener(evt -> onSearchProduct(evt));
        btnSearchProduct.setText("Search");
        btnSearchProduct.addActionListener(evt -> onSearchProduct(evt));
        productSearchPanel.add(btnSearchProduct, java.awt.BorderLayout.EAST);
        btnRefreshProducts.setText("Refresh");
        btnRefreshProducts.addActionListener(evt -> onRefreshProducts(evt));
        productSearchPanel.add(btnRefreshProducts, java.awt.BorderLayout.WEST);
        productTableHeading.add(productSearchPanel, java.awt.BorderLayout.SOUTH);
        productTablePanel.add(productTableHeading, java.awt.BorderLayout.NORTH);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Name", "Category", "Price", "Eco", "Description" }
        ) {
            Class[] types = new Class[] { Integer.class, String.class, String.class, java.math.BigDecimal.class, Integer.class, String.class };
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tblProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { onProductTableClick(evt); }
        });
        productTableScroll.setViewportView(tblProducts);
        productTablePanel.add(productTableScroll, java.awt.BorderLayout.CENTER);

        productTableHint.setText("Tip: Search products or select a row to load its details.");
        productTableHint.setForeground(new java.awt.Color(110, 128, 117));
        productTableHint.setFont(new java.awt.Font("Segoe UI", 0, 11));
        productTableHint.setPreferredSize(new java.awt.Dimension(500, 25));
        productTablePanel.add(productTableHint, java.awt.BorderLayout.SOUTH);
        productsTilesPanel.add(productTablePanel, java.awt.BorderLayout.CENTER);

        productsDetailsPanel.add(productsTilesPanel, java.awt.BorderLayout.CENTER);

        productsModuleStatus.setText("Product catalogue | Create, update and manage product details");
        productsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        productsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        productsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        productsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        productsDetailsPanel.add(productsModuleStatus, java.awt.BorderLayout.SOUTH);


        productsPage.add(productsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(productsPage, "products");

        inventoryPage.setBackground(new java.awt.Color(246, 249, 247));
        inventoryPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        inventoryPage.setLayout(new java.awt.BorderLayout());

        inventoryIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        inventoryIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        inventoryIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        inventoryEyebrow.setText("ECONEST / INVENTORY");
        inventoryEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        inventoryEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        inventoryIntroPanel.add(inventoryEyebrow);

        inventoryHeading.setText("Inventory Management");
        inventoryHeading.setForeground(new java.awt.Color(35, 55, 44));
        inventoryHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        inventoryIntroPanel.add(inventoryHeading);

        inventoryDescription.setText("Receive supplier stock, configure reorder levels and record stock losses.");
        inventoryDescription.setForeground(new java.awt.Color(110, 128, 117));
        inventoryDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        inventoryIntroPanel.add(inventoryDescription);


        inventoryPage.add(inventoryIntroPanel, java.awt.BorderLayout.NORTH);

        inventoryDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        inventoryDetailsPanel.setLayout(new java.awt.BorderLayout());

        inventoryTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        inventoryTilesPanel.setLayout(new java.awt.BorderLayout(12, 0));
        invControlsPanel.setBackground(new java.awt.Color(255, 255, 255));
        invControlsPanel.setPreferredSize(new java.awt.Dimension(350, 480));
        invControlsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 11, 12, 11));
        invControlsPanel.setLayout(new java.awt.BorderLayout(0, 6));
        invControlsHeading.setText("Inventory operations");
        invControlsHeading.setFont(new java.awt.Font("Segoe UI", 1, 15));
        invControlsHeading.setPreferredSize(new java.awt.Dimension(330, 38));
        invControlsPanel.add(invControlsHeading, java.awt.BorderLayout.NORTH);

        invInputsPanel.setBackground(new java.awt.Color(255, 255, 255));
        invInputsPanel.setLayout(new java.awt.GridLayout(17, 1, 0, 5));
        invProductRow.setBackground(new java.awt.Color(255, 255, 255));
        invProductRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invProductRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvProductRow.setText("Product");
        lblInvProductRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invProductRow.add(lblInvProductRow, java.awt.BorderLayout.WEST);

        invProductRow.add(cmbInvProduct, java.awt.BorderLayout.CENTER);
        invSupplierRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierRow.setText("Supplier");
        lblInvSupplierRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierRow.add(lblInvSupplierRow, java.awt.BorderLayout.WEST);

        invSupplierRow.add(cmbInvSupplier, java.awt.BorderLayout.CENTER);
        invReceiveQtyRow.setBackground(new java.awt.Color(255, 255, 255));
        invReceiveQtyRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReceiveQtyRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReceiveQtyRow.setText("Receive qty");
        lblInvReceiveQtyRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReceiveQtyRow.add(lblInvReceiveQtyRow, java.awt.BorderLayout.WEST);

        invReceiveQtyRow.add(spnInvReceiveQty, java.awt.BorderLayout.CENTER);
        btnReceiveStock.setText("RECEIVE STOCK");
        btnReceiveStock.addActionListener(evt -> onReceiveStock(evt));
        invReorderRow.setBackground(new java.awt.Color(255, 255, 255));
        invReorderRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReorderRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReorderRow.setText("Reorder level");
        lblInvReorderRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReorderRow.add(lblInvReorderRow, java.awt.BorderLayout.WEST);

        invReorderRow.add(spnInvReorder, java.awt.BorderLayout.CENTER);
        btnSetReorder.setText("SAVE REORDER LEVEL");
        btnSetReorder.addActionListener(evt -> onSetReorder(evt));
        invWriteOffQtyRow.setBackground(new java.awt.Color(255, 255, 255));
        invWriteOffQtyRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invWriteOffQtyRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvWriteOffQtyRow.setText("Write-off qty");
        lblInvWriteOffQtyRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invWriteOffQtyRow.add(lblInvWriteOffQtyRow, java.awt.BorderLayout.WEST);

        invWriteOffQtyRow.add(spnInvWriteOffQty, java.awt.BorderLayout.CENTER);
        invReasonRow.setBackground(new java.awt.Color(255, 255, 255));
        invReasonRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReasonRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReasonRow.setText("Reason");
        lblInvReasonRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReasonRow.add(lblInvReasonRow, java.awt.BorderLayout.WEST);

        invReasonRow.add(txtInvWriteOffReason, java.awt.BorderLayout.CENTER);
        btnWriteOff.setText("RECORD WRITE-OFF");
        btnWriteOff.addActionListener(evt -> onWriteOffStock(evt));
        lblRegisterSupplier.setText("04   REGISTER SUPPLIER");
        lblRegisterSupplier.setOpaque(true);
        lblRegisterSupplier.setBackground(new java.awt.Color(231, 243, 235));
        lblRegisterSupplier.setForeground(new java.awt.Color(30, 94, 64));
        lblRegisterSupplier.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblRegisterSupplier.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        invSupplierNameRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierNameRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierNameRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierNameRow.setText("Name");
        lblInvSupplierNameRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierNameRow.add(lblInvSupplierNameRow, java.awt.BorderLayout.WEST);

        invSupplierNameRow.add(txtInvSupplierName, java.awt.BorderLayout.CENTER);
        invSupplierPhoneRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierPhoneRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierPhoneRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierPhoneRow.setText("Phone");
        lblInvSupplierPhoneRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierPhoneRow.add(lblInvSupplierPhoneRow, java.awt.BorderLayout.WEST);

        invSupplierPhoneRow.add(txtInvSupplierPhone, java.awt.BorderLayout.CENTER);
        invSupplierEmailRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierEmailRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierEmailRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierEmailRow.setText("Email");
        lblInvSupplierEmailRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierEmailRow.add(lblInvSupplierEmailRow, java.awt.BorderLayout.WEST);

        invSupplierEmailRow.add(txtInvSupplierEmail, java.awt.BorderLayout.CENTER);
        btnRegisterSupplier.setText("ADD SUPPLIER");
        btnRegisterSupplier.addActionListener(evt -> onRegisterSupplier(evt));
        lblInvReceiveSection.setText("01   RECEIVE STOCK");
        lblInvReceiveSection.setOpaque(true);
        lblInvReceiveSection.setBackground(new java.awt.Color(231, 243, 235));
        lblInvReceiveSection.setForeground(new java.awt.Color(30, 94, 64));
        lblInvReceiveSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblInvReceiveSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        invInputsPanel.add(lblInvReceiveSection);
        invInputsPanel.add(invProductRow);
        invInputsPanel.add(invSupplierRow);
        invInputsPanel.add(invReceiveQtyRow);
        invInputsPanel.add(btnReceiveStock);
        lblInvReorderSection.setText("02   REORDER THRESHOLD");
        lblInvReorderSection.setOpaque(true);
        lblInvReorderSection.setBackground(new java.awt.Color(231, 243, 235));
        lblInvReorderSection.setForeground(new java.awt.Color(30, 94, 64));
        lblInvReorderSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblInvReorderSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        invInputsPanel.add(lblInvReorderSection);
        invInputsPanel.add(invReorderRow);
        invInputsPanel.add(btnSetReorder);
        lblInvWriteOffSection.setText("03   RECORD STOCK LOSS");
        lblInvWriteOffSection.setOpaque(true);
        lblInvWriteOffSection.setBackground(new java.awt.Color(231, 243, 235));
        lblInvWriteOffSection.setForeground(new java.awt.Color(30, 94, 64));
        lblInvWriteOffSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblInvWriteOffSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        invInputsPanel.add(lblInvWriteOffSection);
        invInputsPanel.add(invWriteOffQtyRow);
        invInputsPanel.add(invReasonRow);
        invInputsPanel.add(btnWriteOff);
        invInputsPanel.add(lblRegisterSupplier);
        invInputsPanel.add(invSupplierNameRow);
        invInputsPanel.add(invSupplierPhoneRow);
        invInputsPanel.add(invSupplierEmailRow);
        invInputsPanel.add(btnRegisterSupplier);
        invControlsScroll.setViewportView(invInputsPanel);
        invControlsPanel.add(invControlsScroll, java.awt.BorderLayout.CENTER);
        inventoryTilesPanel.add(invControlsPanel, java.awt.BorderLayout.WEST);
        invDataPanel.setBackground(new java.awt.Color(246, 249, 247));
        invDataPanel.setLayout(new java.awt.BorderLayout(0, 10));
        invStockToolbar.setBackground(new java.awt.Color(246, 249, 247));
        invStockToolbar.setPreferredSize(new java.awt.Dimension(700, 40));
        invStockToolbar.setLayout(new java.awt.GridLayout(1, 4, 5, 0));
        lblInventoryTable.setText("STOCK ON HAND");
        lblInventoryTable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        invStockToolbar.add(lblInventoryTable);
        btnShowAllStock.setText("All products");
        btnShowAllStock.addActionListener(evt -> onShowAllInventory(evt));
        invStockToolbar.add(btnShowAllStock);
        btnLowStock.setText("Low-stock only");
        btnLowStock.addActionListener(evt -> onShowLowStock(evt));
        invStockToolbar.add(btnLowStock);
        btnReloadInventory.setText("Refresh");
        btnReloadInventory.addActionListener(evt -> onRefreshInventory(evt));
        invStockToolbar.add(btnReloadInventory);
        invDataPanel.add(invStockToolbar, java.awt.BorderLayout.NORTH);

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"ID", "Product", "Category", "In Stock", "Reorder", "Status"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tblInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent evt) { onInventoryRowClick(evt); }
        });
        invStockScroll.setViewportView(tblInventory);
        invDataPanel.add(invStockScroll, java.awt.BorderLayout.CENTER);
        invHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        invHistoryPanel.setPreferredSize(new java.awt.Dimension(700, 235));
        invHistoryPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        invHistoryPanel.setLayout(new java.awt.BorderLayout(0, 5));
        lblStockHistory.setText("STOCK MOVEMENT HISTORY  •  Latest 500 entries");
        lblStockHistory.setFont(new java.awt.Font("Segoe UI", 1, 13));
        invHistoryPanel.add(lblStockHistory, java.awt.BorderLayout.NORTH);

        tblInvMovements.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"When", "Movement", "Product", "Qty", "Supplier ID", "Order ID", "Reason"}) {
            Class[] types = new Class[] {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        invHistoryScroll.setViewportView(tblInvMovements);
        invHistoryPanel.add(invHistoryScroll, java.awt.BorderLayout.CENTER);
        invDataPanel.add(invHistoryPanel, java.awt.BorderLayout.SOUTH);
        inventoryTilesPanel.add(invDataPanel, java.awt.BorderLayout.CENTER);

        inventoryDetailsPanel.add(inventoryTilesPanel, java.awt.BorderLayout.CENTER);

        inventoryModuleStatus.setText("Inventory | Live stock levels and transaction history");
        inventoryModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        inventoryModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        inventoryModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        inventoryModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        inventoryDetailsPanel.add(inventoryModuleStatus, java.awt.BorderLayout.SOUTH);


        inventoryPage.add(inventoryDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(inventoryPage, "inventory");

        clientsPage.setBackground(new java.awt.Color(246, 249, 247));
        clientsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        clientsPage.setLayout(new java.awt.BorderLayout());

        clientsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        clientsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        clientsIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        clientsEyebrow.setText("ECONEST / CLIENTS");
        clientsEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        clientsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        clientsIntroPanel.add(clientsEyebrow);

        clientsHeading.setText("Client Management");
        clientsHeading.setForeground(new java.awt.Color(35, 55, 44));
        clientsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        clientsIntroPanel.add(clientsHeading);

        clientsDescription.setText("Create and maintain household and office client information.");
        clientsDescription.setForeground(new java.awt.Color(110, 128, 117));
        clientsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        clientsIntroPanel.add(clientsDescription);


        clientsPage.add(clientsIntroPanel, java.awt.BorderLayout.NORTH);

        clientsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        clientsDetailsPanel.setLayout(new java.awt.BorderLayout());

        clientsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        clientsTilesPanel.setLayout(new java.awt.BorderLayout(13, 0));

        clientFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientFormPanel.setPreferredSize(new java.awt.Dimension(343, 445));
        clientFormPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        clientFormPanel.setLayout(new java.awt.BorderLayout(0, 12));

        clientFormHeading.setBackground(new java.awt.Color(255, 255, 255));
        clientFormHeading.setPreferredSize(new java.awt.Dimension(310, 50));
        clientFormHeading.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        clientFormTitle.setText("Client details");
        clientFormTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        clientFormTitle.setForeground(new java.awt.Color(35, 55, 44));
        clientFormHeading.add(clientFormTitle);
        clientFormCaption.setText("Add or edit household / office clients");
        clientFormCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientFormCaption.setForeground(new java.awt.Color(110, 128, 117));
        clientFormHeading.add(clientFormCaption);
        clientFormPanel.add(clientFormHeading, java.awt.BorderLayout.NORTH);

        clientFieldsPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientFieldsPanel.setLayout(new java.awt.GridLayout(6, 1, 0, 10));

        clientNameRow.setBackground(new java.awt.Color(255, 255, 255));
        clientNameRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblClientName.setText("Client name");
        lblClientName.setPreferredSize(new java.awt.Dimension(105, 25));
        clientNameRow.add(lblClientName, java.awt.BorderLayout.WEST);
        clientNameRow.add(txtClientName, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientNameRow);

        clientTypeRow.setBackground(new java.awt.Color(255, 255, 255));
        clientTypeRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblClientType.setText("Client type");
        lblClientType.setPreferredSize(new java.awt.Dimension(105, 25));
        clientTypeRow.add(lblClientType, java.awt.BorderLayout.WEST);
        cmbClientType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOUSEHOLD", "OFFICE" }));
        clientTypeRow.add(cmbClientType, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientTypeRow);

        clientAddressRow.setBackground(new java.awt.Color(255, 255, 255));
        clientAddressRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblClientAddress.setText("Address");
        lblClientAddress.setPreferredSize(new java.awt.Dimension(105, 25));
        clientAddressRow.add(lblClientAddress, java.awt.BorderLayout.WEST);
        txtClientAddress.setLineWrap(true);
        txtClientAddress.setWrapStyleWord(true);
        clientAddressScroll.setPreferredSize(new java.awt.Dimension(210, 57));
        clientAddressScroll.setViewportView(txtClientAddress);
        clientAddressRow.add(clientAddressScroll, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientAddressRow);

        clientEmailRow.setBackground(new java.awt.Color(255, 255, 255));
        clientEmailRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblClientEmail.setText("Email");
        lblClientEmail.setPreferredSize(new java.awt.Dimension(105, 25));
        clientEmailRow.add(lblClientEmail, java.awt.BorderLayout.WEST);
        clientEmailRow.add(txtClientEmail, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientEmailRow);

        clientPhoneRow.setBackground(new java.awt.Color(255, 255, 255));
        clientPhoneRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblClientPhone.setText("Phone");
        lblClientPhone.setPreferredSize(new java.awt.Dimension(105, 25));
        clientPhoneRow.add(lblClientPhone, java.awt.BorderLayout.WEST);
        clientPhoneRow.add(txtClientPhone, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientPhoneRow);

        clientIdRow.setBackground(new java.awt.Color(255, 255, 255));
        clientIdRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblCurrentClient.setText("Selected ID");
        lblCurrentClient.setPreferredSize(new java.awt.Dimension(105, 25));
        clientIdRow.add(lblCurrentClient, java.awt.BorderLayout.WEST);
        lblSelectedClientId.setText("New client");
        lblSelectedClientId.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblSelectedClientId.setForeground(new java.awt.Color(66, 130, 97));
        clientIdRow.add(lblSelectedClientId, java.awt.BorderLayout.CENTER);
        clientFieldsPanel.add(clientIdRow);
        clientFormPanel.add(clientFieldsPanel, java.awt.BorderLayout.CENTER);

        clientActionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientActionsPanel.setPreferredSize(new java.awt.Dimension(310, 98));
        clientActionsPanel.setLayout(new java.awt.GridLayout(2, 2, 9, 9));
        btnAddClient.setText("Add client");
        btnAddClient.addActionListener(evt -> onAddClient(evt));
        clientActionsPanel.add(btnAddClient);
        btnUpdateClient.setText("Update");
        btnUpdateClient.addActionListener(evt -> onUpdateClient(evt));
        clientActionsPanel.add(btnUpdateClient);
        btnDeleteClient.setText("Delete");
        btnDeleteClient.addActionListener(evt -> onDeleteClient(evt));
        clientActionsPanel.add(btnDeleteClient);
        btnClearClient.setText("Clear fields");
        btnClearClient.addActionListener(evt -> onClearClient(evt));
        clientActionsPanel.add(btnClearClient);
        clientFormPanel.add(clientActionsPanel, java.awt.BorderLayout.SOUTH);
        clientsTilesPanel.add(clientFormPanel, java.awt.BorderLayout.WEST);

        clientTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        clientTablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        clientTablePanel.setLayout(new java.awt.BorderLayout(0, 10));
        clientTableHeading.setBackground(new java.awt.Color(255, 255, 255));
        clientTableHeading.setPreferredSize(new java.awt.Dimension(500, 93));
        clientTableHeading.setLayout(new java.awt.BorderLayout(0, 6));
        clientTableTitleArea.setBackground(new java.awt.Color(255, 255, 255));
        clientTableTitleArea.setPreferredSize(new java.awt.Dimension(400, 44));
        clientTableTitleArea.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        clientTableTitle.setText("Registered clients");
        clientTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        clientTableTitle.setForeground(new java.awt.Color(35, 55, 44));
        clientTableTitleArea.add(clientTableTitle);
        clientTableCaption.setText("Select a row to update or permanently delete a client");
        clientTableCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientTableCaption.setForeground(new java.awt.Color(110, 128, 117));
        clientTableTitleArea.add(clientTableCaption);
        clientTableHeading.add(clientTableTitleArea, java.awt.BorderLayout.NORTH);

        clientSearchPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientSearchPanel.setPreferredSize(new java.awt.Dimension(500, 38));
        clientSearchPanel.setLayout(new java.awt.BorderLayout(8, 0));
        clientSearchPanel.add(txtClientSearch, java.awt.BorderLayout.CENTER);
        txtClientSearch.addActionListener(evt -> onSearchClient(evt));
        btnSearchClient.setText("Search");
        btnSearchClient.addActionListener(evt -> onSearchClient(evt));
        clientSearchPanel.add(btnSearchClient, java.awt.BorderLayout.EAST);
        btnRefreshClients.setText("Refresh");
        btnRefreshClients.addActionListener(evt -> onRefreshClients(evt));
        clientSearchPanel.add(btnRefreshClients, java.awt.BorderLayout.WEST);
        clientTableHeading.add(clientSearchPanel, java.awt.BorderLayout.SOUTH);
        clientTablePanel.add(clientTableHeading, java.awt.BorderLayout.NORTH);

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Name", "Type", "Email", "Phone", "Address" }
        ) {
            Class[] types = new Class[] { Integer.class, String.class, String.class, String.class, String.class, String.class };
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { onClientTableClick(evt); }
        });
        clientTableScroll.setViewportView(tblClients);
        clientTablePanel.add(clientTableScroll, java.awt.BorderLayout.CENTER);

        clientTableHint.setText("Tip: Search clients or select a row to load the contact details.");
        clientTableHint.setForeground(new java.awt.Color(110, 128, 117));
        clientTableHint.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientTableHint.setPreferredSize(new java.awt.Dimension(500, 25));
        clientTablePanel.add(clientTableHint, java.awt.BorderLayout.SOUTH);
        clientsTilesPanel.add(clientTablePanel, java.awt.BorderLayout.CENTER);

        clientsDetailsPanel.add(clientsTilesPanel, java.awt.BorderLayout.CENTER);

        clientsModuleStatus.setText("Client records | Household and office customers");
        clientsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        clientsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        clientsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        clientsDetailsPanel.add(clientsModuleStatus, java.awt.BorderLayout.SOUTH);


        clientsPage.add(clientsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(clientsPage, "clients");

        agentsPage.setBackground(new java.awt.Color(246, 249, 247));
        agentsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        agentsPage.setLayout(new java.awt.BorderLayout());

        agentsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        agentsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        agentsIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        agentsEyebrow.setText("ECONEST / DELIVERY AGENTS");
        agentsEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        agentsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        agentsIntroPanel.add(agentsEyebrow);

        agentsHeading.setText("Delivery Agent Management");
        agentsHeading.setForeground(new java.awt.Color(35, 55, 44));
        agentsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        agentsIntroPanel.add(agentsHeading);

        agentsDescription.setText("Maintain delivery agents and their assigned vehicle details.");
        agentsDescription.setForeground(new java.awt.Color(110, 128, 117));
        agentsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        agentsIntroPanel.add(agentsDescription);


        agentsPage.add(agentsIntroPanel, java.awt.BorderLayout.NORTH);

        agentsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        agentsDetailsPanel.setLayout(new java.awt.BorderLayout());

        agentsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        agentsTilesPanel.setLayout(new java.awt.BorderLayout(13, 0));

        agentFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentFormPanel.setPreferredSize(new java.awt.Dimension(343, 445));
        agentFormPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        agentFormPanel.setLayout(new java.awt.BorderLayout(0, 12));

        agentFormHeading.setBackground(new java.awt.Color(255, 255, 255));
        agentFormHeading.setPreferredSize(new java.awt.Dimension(310, 50));
        agentFormHeading.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        agentFormTitle.setText("Delivery agent details");
        agentFormTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        agentFormTitle.setForeground(new java.awt.Color(35, 55, 44));
        agentFormHeading.add(agentFormTitle);
        agentFormCaption.setText("Register personnel and vehicle information");
        agentFormCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentFormCaption.setForeground(new java.awt.Color(110, 128, 117));
        agentFormHeading.add(agentFormCaption);
        agentFormPanel.add(agentFormHeading, java.awt.BorderLayout.NORTH);

        agentFieldsPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentFieldsPanel.setLayout(new java.awt.GridLayout(6, 1, 0, 10));

        agentNameRow.setBackground(new java.awt.Color(255, 255, 255));
        agentNameRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblAgentName.setText("Agent name");
        lblAgentName.setPreferredSize(new java.awt.Dimension(105, 25));
        agentNameRow.add(lblAgentName, java.awt.BorderLayout.WEST);
        agentNameRow.add(txtAgentName, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentNameRow);

        agentVehicleTypeRow.setBackground(new java.awt.Color(255, 255, 255));
        agentVehicleTypeRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblAgentVehicleType.setText("Vehicle type");
        lblAgentVehicleType.setPreferredSize(new java.awt.Dimension(105, 25));
        agentVehicleTypeRow.add(lblAgentVehicleType, java.awt.BorderLayout.WEST);
        cmbAgentVehicleType.setEditable(true);
        cmbAgentVehicleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motorbike", "Van", "Car", "Bicycle", "Truck" }));
        agentVehicleTypeRow.add(cmbAgentVehicleType, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentVehicleTypeRow);

        agentVehicleNumberRow.setBackground(new java.awt.Color(255, 255, 255));
        agentVehicleNumberRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblAgentVehicleNumber.setText("Vehicle no.");
        lblAgentVehicleNumber.setPreferredSize(new java.awt.Dimension(105, 25));
        agentVehicleNumberRow.add(lblAgentVehicleNumber, java.awt.BorderLayout.WEST);
        txtAgentVehicleNumber.setLineWrap(false);
        txtAgentVehicleNumber.setWrapStyleWord(false);
        txtAgentVehicleNumber.setRows(1);
        agentVehicleNumberScroll.setPreferredSize(new java.awt.Dimension(210, 57));
        agentVehicleNumberScroll.setViewportView(txtAgentVehicleNumber);
        agentVehicleNumberRow.add(agentVehicleNumberScroll, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentVehicleNumberRow);

        agentEmailRow.setBackground(new java.awt.Color(255, 255, 255));
        agentEmailRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblAgentEmail.setText("Email");
        lblAgentEmail.setPreferredSize(new java.awt.Dimension(105, 25));
        agentEmailRow.add(lblAgentEmail, java.awt.BorderLayout.WEST);
        agentEmailRow.add(txtAgentEmail, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentEmailRow);

        agentPhoneRow.setBackground(new java.awt.Color(255, 255, 255));
        agentPhoneRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblAgentPhone.setText("Phone");
        lblAgentPhone.setPreferredSize(new java.awt.Dimension(105, 25));
        agentPhoneRow.add(lblAgentPhone, java.awt.BorderLayout.WEST);
        agentPhoneRow.add(txtAgentPhone, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentPhoneRow);

        agentIdRow.setBackground(new java.awt.Color(255, 255, 255));
        agentIdRow.setLayout(new java.awt.BorderLayout(8, 0));
        lblCurrentAgent.setText("Selected ID");
        lblCurrentAgent.setPreferredSize(new java.awt.Dimension(105, 25));
        agentIdRow.add(lblCurrentAgent, java.awt.BorderLayout.WEST);
        lblSelectedAgentId.setText("New agent");
        lblSelectedAgentId.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblSelectedAgentId.setForeground(new java.awt.Color(66, 130, 97));
        agentIdRow.add(lblSelectedAgentId, java.awt.BorderLayout.CENTER);
        agentFieldsPanel.add(agentIdRow);
        agentFormPanel.add(agentFieldsPanel, java.awt.BorderLayout.CENTER);

        agentActionsPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentActionsPanel.setPreferredSize(new java.awt.Dimension(310, 98));
        agentActionsPanel.setLayout(new java.awt.GridLayout(2, 2, 9, 9));
        btnAddAgent.setText("Add agent");
        btnAddAgent.addActionListener(evt -> onAddAgent(evt));
        agentActionsPanel.add(btnAddAgent);
        btnUpdateAgent.setText("Update");
        btnUpdateAgent.addActionListener(evt -> onUpdateAgent(evt));
        agentActionsPanel.add(btnUpdateAgent);
        btnDeleteAgent.setText("Delete");
        btnDeleteAgent.addActionListener(evt -> onDeleteAgent(evt));
        agentActionsPanel.add(btnDeleteAgent);
        btnClearAgent.setText("Clear fields");
        btnClearAgent.addActionListener(evt -> onClearAgent(evt));
        agentActionsPanel.add(btnClearAgent);
        agentFormPanel.add(agentActionsPanel, java.awt.BorderLayout.SOUTH);
        agentsTilesPanel.add(agentFormPanel, java.awt.BorderLayout.WEST);

        agentTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        agentTablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 15, 15, 15));
        agentTablePanel.setLayout(new java.awt.BorderLayout(0, 10));
        agentTableHeading.setBackground(new java.awt.Color(255, 255, 255));
        agentTableHeading.setPreferredSize(new java.awt.Dimension(500, 93));
        agentTableHeading.setLayout(new java.awt.BorderLayout(0, 6));
        agentTableTitleArea.setBackground(new java.awt.Color(255, 255, 255));
        agentTableTitleArea.setPreferredSize(new java.awt.Dimension(400, 44));
        agentTableTitleArea.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        agentTableTitle.setText("Delivery agents");
        agentTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 17));
        agentTableTitle.setForeground(new java.awt.Color(35, 55, 44));
        agentTableTitleArea.add(agentTableTitle);
        agentTableCaption.setText("Select an agent to edit, update vehicle details or delete");
        agentTableCaption.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentTableCaption.setForeground(new java.awt.Color(110, 128, 117));
        agentTableTitleArea.add(agentTableCaption);
        agentTableHeading.add(agentTableTitleArea, java.awt.BorderLayout.NORTH);

        agentSearchPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentSearchPanel.setPreferredSize(new java.awt.Dimension(500, 38));
        agentSearchPanel.setLayout(new java.awt.BorderLayout(8, 0));
        agentSearchPanel.add(txtAgentSearch, java.awt.BorderLayout.CENTER);
        txtAgentSearch.addActionListener(evt -> onSearchAgent(evt));
        btnSearchAgent.setText("Search");
        btnSearchAgent.addActionListener(evt -> onSearchAgent(evt));
        agentSearchPanel.add(btnSearchAgent, java.awt.BorderLayout.EAST);
        btnRefreshAgents.setText("Refresh");
        btnRefreshAgents.addActionListener(evt -> onRefreshAgents(evt));
        agentSearchPanel.add(btnRefreshAgents, java.awt.BorderLayout.WEST);
        agentTableHeading.add(agentSearchPanel, java.awt.BorderLayout.SOUTH);
        agentTablePanel.add(agentTableHeading, java.awt.BorderLayout.NORTH);

        tblAgents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Name", "Email", "Phone", "Vehicle Type", "Vehicle No." }
        ) {
            Class[] types = new Class[] { Integer.class, String.class, String.class, String.class, String.class, String.class };
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tblAgents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAgents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { onAgentTableClick(evt); }
        });
        agentTableScroll.setViewportView(tblAgents);
        agentTablePanel.add(agentTableScroll, java.awt.BorderLayout.CENTER);

        agentTableHint.setText("Tip: You can search all agent fields. Active assignments prevent deletion.");
        agentTableHint.setForeground(new java.awt.Color(110, 128, 117));
        agentTableHint.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentTableHint.setPreferredSize(new java.awt.Dimension(500, 25));
        agentTablePanel.add(agentTableHint, java.awt.BorderLayout.SOUTH);
        agentsTilesPanel.add(agentTablePanel, java.awt.BorderLayout.CENTER);

        agentsDetailsPanel.add(agentsTilesPanel, java.awt.BorderLayout.CENTER);

        agentsModuleStatus.setText("Delivery personnel | Contact and vehicle records");
        agentsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        agentsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        agentsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        agentsDetailsPanel.add(agentsModuleStatus, java.awt.BorderLayout.SOUTH);


        agentsPage.add(agentsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(agentsPage, "agents");

        ordersPage.setBackground(new java.awt.Color(246, 249, 247));
        ordersPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        ordersPage.setLayout(new java.awt.BorderLayout());

        ordersIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordersIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        ordersIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        ordersEyebrow.setText("ECONEST / ORDERS");
        ordersEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        ordersEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        ordersIntroPanel.add(ordersEyebrow);

        ordersHeading.setText("Client Order Management");
        ordersHeading.setForeground(new java.awt.Color(35, 55, 44));
        ordersHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        ordersIntroPanel.add(ordersHeading);

        ordersDescription.setText("Create drafts, manage line items and confirm or cancel client orders.");
        ordersDescription.setForeground(new java.awt.Color(110, 128, 117));
        ordersDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersIntroPanel.add(ordersDescription);


        ordersPage.add(ordersIntroPanel, java.awt.BorderLayout.NORTH);

        ordersDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordersDetailsPanel.setLayout(new java.awt.BorderLayout());

        ordersTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordersTilesPanel.setLayout(new java.awt.BorderLayout(12, 0));
        ordControlsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordControlsPanel.setPreferredSize(new java.awt.Dimension(350, 480));
        ordControlsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 11, 12, 11));
        ordControlsPanel.setLayout(new java.awt.BorderLayout(0, 6));
        ordControlsHeading.setText("Order workflow");
        ordControlsHeading.setFont(new java.awt.Font("Segoe UI", 1, 15));
        ordControlsHeading.setPreferredSize(new java.awt.Dimension(330, 38));
        ordControlsPanel.add(ordControlsHeading, java.awt.BorderLayout.NORTH);

        ordInputsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordInputsPanel.setLayout(new java.awt.GridLayout(19, 1, 0, 5));
        ordClientRow.setBackground(new java.awt.Color(255, 255, 255));
        ordClientRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordClientRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdClient.setText("Client");
        lblOrdClient.setPreferredSize(new java.awt.Dimension(105, 28));
        ordClientRow.add(lblOrdClient, java.awt.BorderLayout.WEST);

        ordClientRow.add(cmbOrdClient, java.awt.BorderLayout.CENTER);
        ordProductRow.setBackground(new java.awt.Color(255, 255, 255));
        ordProductRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordProductRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdProduct.setText("Product");
        lblOrdProduct.setPreferredSize(new java.awt.Dimension(105, 28));
        ordProductRow.add(lblOrdProduct, java.awt.BorderLayout.WEST);

        ordProductRow.add(cmbOrdProduct, java.awt.BorderLayout.CENTER);
        ordQtyRow.setBackground(new java.awt.Color(255, 255, 255));
        ordQtyRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordQtyRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdQty.setText("Quantity");
        lblOrdQty.setPreferredSize(new java.awt.Dimension(105, 28));
        ordQtyRow.add(lblOrdQty, java.awt.BorderLayout.WEST);

        spnOrdQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999999, 1));
        ordQtyRow.add(spnOrdQty, java.awt.BorderLayout.CENTER);
        btnAddOrderItem.setText("ADD ITEM");
        btnAddOrderItem.addActionListener(evt -> onAddOrderItem(evt));
        ordLineCountRow.setBackground(new java.awt.Color(255, 255, 255));
        ordLineCountRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordLineCountRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdLineCount.setText("Order lines");
        lblOrdLineCount.setPreferredSize(new java.awt.Dimension(105, 28));
        ordLineCountRow.add(lblOrdLineCount, java.awt.BorderLayout.WEST);

        spnOrdLineCount.setEnabled(false);
        ordLineCountRow.add(spnOrdLineCount, java.awt.BorderLayout.CENTER);
        btnRemoveOrderItem.setText("REMOVE SELECTED ITEM");
        btnRemoveOrderItem.addActionListener(evt -> onRemoveOrderItem(evt));
        ordStockRow.setBackground(new java.awt.Color(255, 255, 255));
        ordStockRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordStockRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdStock.setText("Available stock");
        lblOrdStock.setPreferredSize(new java.awt.Dimension(105, 28));
        ordStockRow.add(lblOrdStock, java.awt.BorderLayout.WEST);

        spnOrdStock.setEnabled(false);
        ordStockRow.add(spnOrdStock, java.awt.BorderLayout.CENTER);
        ordTotalRow.setBackground(new java.awt.Color(255, 255, 255));
        ordTotalRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordTotalRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdTotal.setText("Order total");
        lblOrdTotal.setPreferredSize(new java.awt.Dimension(105, 28));
        ordTotalRow.add(lblOrdTotal, java.awt.BorderLayout.WEST);

        txtOrdTotal.setEditable(false);
        ordTotalRow.add(txtOrdTotal, java.awt.BorderLayout.CENTER);
        btnConfirmOrder.setText("CONFIRM ORDER");
        btnConfirmOrder.addActionListener(evt -> onConfirmOrder(evt));
        lblOrdDetailsHeading.setText("04   FIND & CANCEL ORDER");
        lblOrdDetailsHeading.setOpaque(true);
        lblOrdDetailsHeading.setBackground(new java.awt.Color(231, 243, 235));
        lblOrdDetailsHeading.setForeground(new java.awt.Color(30, 94, 64));
        lblOrdDetailsHeading.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblOrdDetailsHeading.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        ordSearchRow.setBackground(new java.awt.Color(255, 255, 255));
        ordSearchRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordSearchRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdSearch.setText("Search");
        lblOrdSearch.setPreferredSize(new java.awt.Dimension(105, 28));
        ordSearchRow.add(lblOrdSearch, java.awt.BorderLayout.WEST);

        ordSearchRow.add(txtOrdSearch, java.awt.BorderLayout.CENTER);
        ordOrderIdRow.setBackground(new java.awt.Color(255, 255, 255));
        ordOrderIdRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordOrderIdRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdSelectedOrder.setText("Order ID");
        lblOrdSelectedOrder.setPreferredSize(new java.awt.Dimension(105, 28));
        ordOrderIdRow.add(lblOrdSelectedOrder, java.awt.BorderLayout.WEST);

        txtOrdSelectedOrder.setEditable(false);
        ordOrderIdRow.add(txtOrdSelectedOrder, java.awt.BorderLayout.CENTER);
        ordOrderStatusRow.setBackground(new java.awt.Color(255, 255, 255));
        ordOrderStatusRow.setPreferredSize(new java.awt.Dimension(270, 34));
        ordOrderStatusRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblOrdStatus.setText("Status");
        lblOrdStatus.setPreferredSize(new java.awt.Dimension(105, 28));
        ordOrderStatusRow.add(lblOrdStatus, java.awt.BorderLayout.WEST);

        txtOrdStatus.setEditable(false);
        ordOrderStatusRow.add(txtOrdStatus, java.awt.BorderLayout.CENTER);
        btnCancelOrder.setText("CANCEL ORDER");
        btnCancelOrder.addActionListener(evt -> onCancelOrder(evt));
        lblOrdStartSection.setText("01   CREATE A CLIENT DRAFT");
        lblOrdStartSection.setOpaque(true);
        lblOrdStartSection.setBackground(new java.awt.Color(231, 243, 235));
        lblOrdStartSection.setForeground(new java.awt.Color(30, 94, 64));
        lblOrdStartSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblOrdStartSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        lblOrdItemsSection.setText("02   ADD OR REMOVE ITEMS");
        lblOrdItemsSection.setOpaque(true);
        lblOrdItemsSection.setBackground(new java.awt.Color(231, 243, 235));
        lblOrdItemsSection.setForeground(new java.awt.Color(30, 94, 64));
        lblOrdItemsSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblOrdItemsSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        lblOrdFinalizeSection.setText("03   REVIEW & CONFIRM");
        lblOrdFinalizeSection.setOpaque(true);
        lblOrdFinalizeSection.setBackground(new java.awt.Color(231, 243, 235));
        lblOrdFinalizeSection.setForeground(new java.awt.Color(30, 94, 64));
        lblOrdFinalizeSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblOrdFinalizeSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        ordInputsPanel.add(lblOrdStartSection);
        ordInputsPanel.add(ordClientRow);
        ordInputsPanel.add(btnCreateOrder);
        ordInputsPanel.add(lblOrdItemsSection);
        ordInputsPanel.add(ordProductRow);
        ordInputsPanel.add(ordQtyRow);
        ordInputsPanel.add(btnAddOrderItem);
        ordInputsPanel.add(ordLineCountRow);
        ordInputsPanel.add(btnRemoveOrderItem);
        ordInputsPanel.add(lblOrdFinalizeSection);
        ordInputsPanel.add(ordStockRow);
        ordInputsPanel.add(ordTotalRow);
        ordInputsPanel.add(btnCalculateOrderTotal);
        ordInputsPanel.add(btnConfirmOrder);
        ordInputsPanel.add(lblOrdDetailsHeading);
        ordInputsPanel.add(ordSearchRow);
        ordInputsPanel.add(ordOrderIdRow);
        ordInputsPanel.add(ordOrderStatusRow);
        ordInputsPanel.add(btnCancelOrder);
        ordControlsScroll.setViewportView(ordInputsPanel);
        ordControlsPanel.add(ordControlsScroll, java.awt.BorderLayout.CENTER);
        ordersTilesPanel.add(ordControlsPanel, java.awt.BorderLayout.WEST);
        ordDataPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordDataPanel.setLayout(new java.awt.BorderLayout(0, 10));
        ordOrdersToolbar.setBackground(new java.awt.Color(246, 249, 247));
        ordOrdersToolbar.setPreferredSize(new java.awt.Dimension(700, 40));
        ordOrdersToolbar.setLayout(new java.awt.GridLayout(1, 2, 5, 0));
        lblOrdersTable.setText("CLIENT ORDERS  •  Select to manage");
        lblOrdersTable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        ordOrdersToolbar.add(lblOrdersTable);
        btnCreateOrder.setText("Create draft");
        btnCreateOrder.addActionListener(evt -> onCreateOrder(evt));

        btnCalculateOrderTotal.setText("Calculate total");
        btnCalculateOrderTotal.addActionListener(evt -> onCalculateOrderTotal(evt));

        btnRefreshOrders.setText("Refresh");
        btnRefreshOrders.addActionListener(evt -> onRefreshOrders(evt));
        ordOrdersToolbar.add(btnRefreshOrders);
        ordDataPanel.add(ordOrdersToolbar, java.awt.BorderLayout.NORTH);

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Order ID", "Client", "Status", "Lines", "Total", "Created"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.math.BigDecimal.class, java.lang.String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent evt) { onOrderRowClick(evt); }
        });
        ordOrdersScroll.setViewportView(tblOrders);
        ordDataPanel.add(ordOrdersScroll, java.awt.BorderLayout.CENTER);
        ordItemsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordItemsPanel.setPreferredSize(new java.awt.Dimension(700, 235));
        ordItemsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        ordItemsPanel.setLayout(new java.awt.BorderLayout(0, 5));
        lblOrderItems.setText("ORDER ITEMS  •  Select a line before removing it");
        lblOrderItems.setFont(new java.awt.Font("Segoe UI", 1, 13));
        ordItemsPanel.add(lblOrderItems, java.awt.BorderLayout.NORTH);

        tblOrderItems.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Product ID", "Product name", "Qty", "Unit price", "Subtotal"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.math.BigDecimal.class, java.math.BigDecimal.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        ordItemsScroll.setViewportView(tblOrderItems);
        ordItemsPanel.add(ordItemsScroll, java.awt.BorderLayout.CENTER);
        ordDataPanel.add(ordItemsPanel, java.awt.BorderLayout.SOUTH);
        ordersTilesPanel.add(ordDataPanel, java.awt.BorderLayout.CENTER);

        ordersDetailsPanel.add(ordersTilesPanel, java.awt.BorderLayout.CENTER);

        ordersModuleStatus.setText("Order processing | Create drafts, confirm and manage order history");
        ordersModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        ordersModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        ordersModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        ordersDetailsPanel.add(ordersModuleStatus, java.awt.BorderLayout.SOUTH);


        ordersPage.add(ordersDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(ordersPage, "orders");

        deliveriesPage.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        deliveriesPage.setLayout(new java.awt.BorderLayout());

        deliveriesIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesIntroPanel.setPreferredSize(new java.awt.Dimension(820, 94));
        deliveriesIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        deliveriesEyebrow.setText("ECONEST / DELIVERIES");
        deliveriesEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        deliveriesIntroPanel.add(deliveriesEyebrow);

        deliveriesHeading.setText("Delivery Assignment & Tracking");
        deliveriesHeading.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        deliveriesIntroPanel.add(deliveriesHeading);

        deliveriesDescription.setText("Assign agents, schedule dispatches and monitor each shipment.");
        deliveriesDescription.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesIntroPanel.add(deliveriesDescription);


        deliveriesPage.add(deliveriesIntroPanel, java.awt.BorderLayout.NORTH);

        deliveriesDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesDetailsPanel.setLayout(new java.awt.BorderLayout());

        deliveriesTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesTilesPanel.setLayout(new java.awt.BorderLayout(12, 0));
        delControlsPanel.setBackground(new java.awt.Color(255, 255, 255));
        delControlsPanel.setPreferredSize(new java.awt.Dimension(335, 480));
        delControlsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 11, 12, 11));
        delControlsPanel.setLayout(new java.awt.BorderLayout(0, 6));
        delControlsHeading.setText("Delivery workflow");
        delControlsHeading.setFont(new java.awt.Font("Segoe UI", 1, 15));
        delControlsHeading.setPreferredSize(new java.awt.Dimension(305, 38));
        delControlsPanel.add(delControlsHeading, java.awt.BorderLayout.NORTH);

        delInputsPanel.setBackground(new java.awt.Color(255, 255, 255));
        delInputsPanel.setPreferredSize(new java.awt.Dimension(270, 620));
        delInputsPanel.setLayout(new java.awt.GridLayout(18, 1, 0, 5));
        delOrderRow.setBackground(new java.awt.Color(255, 255, 255));
        delOrderRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delOrderRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelOrder.setText("Order");
        lblDelOrder.setPreferredSize(new java.awt.Dimension(105, 28));
        delOrderRow.add(lblDelOrder, java.awt.BorderLayout.WEST);

        delOrderRow.add(cmbDelOrder, java.awt.BorderLayout.CENTER);
        delAgentRow.setBackground(new java.awt.Color(255, 255, 255));
        delAgentRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delAgentRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelAgent.setText("Delivery agent");
        lblDelAgent.setPreferredSize(new java.awt.Dimension(105, 28));
        delAgentRow.add(lblDelAgent, java.awt.BorderLayout.WEST);

        delAgentRow.add(cmbDelAgent, java.awt.BorderLayout.CENTER);
        delScheduleRow.setBackground(new java.awt.Color(255, 255, 255));
        delScheduleRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delScheduleRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelSchedule.setText("Schedule (local)");
        lblDelSchedule.setPreferredSize(new java.awt.Dimension(105, 28));
        delScheduleRow.add(lblDelSchedule, java.awt.BorderLayout.WEST);

        txtDelSchedule.setToolTipText("Example: 2026-11-15 14:30 (24-hour local time)");
        delScheduleRow.add(txtDelSchedule, java.awt.BorderLayout.CENTER);
        btnDelAssign.setText("ASSIGN / REASSIGN");
        btnDelAssign.addActionListener(evt -> onAssignDelivery(evt));
        delIdRow.setBackground(new java.awt.Color(255, 255, 255));
        delIdRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delIdRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelId.setText("Delivery ID");
        lblDelId.setPreferredSize(new java.awt.Dimension(105, 28));
        delIdRow.add(lblDelId, java.awt.BorderLayout.WEST);

        txtDelId.setEditable(false);
        delIdRow.add(txtDelId, java.awt.BorderLayout.CENTER);
        btnDelSchedule.setText("SCHEDULE DELIVERY");
        btnDelSchedule.addActionListener(evt -> onScheduleDelivery(evt));
        delStatusRow.setBackground(new java.awt.Color(255, 255, 255));
        delStatusRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delStatusRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelStatus.setText("Status");
        lblDelStatus.setPreferredSize(new java.awt.Dimension(105, 28));
        delStatusRow.add(lblDelStatus, java.awt.BorderLayout.WEST);

        txtDelStatus.setEditable(false);
        delStatusRow.add(txtDelStatus, java.awt.BorderLayout.CENTER);
        delReasonRow.setBackground(new java.awt.Color(255, 255, 255));
        delReasonRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delReasonRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelReason.setText("Failure reason");
        lblDelReason.setPreferredSize(new java.awt.Dimension(105, 28));
        delReasonRow.add(lblDelReason, java.awt.BorderLayout.WEST);

        txtDelReason.setEditable(true);
        delReasonRow.add(txtDelReason, java.awt.BorderLayout.CENTER);
        btnDelDispatch.setText("DISPATCH DELIVERY");
        btnDelDispatch.addActionListener(evt -> onDispatchDelivery(evt));
        lblDelActionsHeading.setText("03   MONITOR & RESOLVE");
        lblDelActionsHeading.setOpaque(true);
        lblDelActionsHeading.setBackground(new java.awt.Color(231, 243, 235));
        lblDelActionsHeading.setForeground(new java.awt.Color(30, 94, 64));
        lblDelActionsHeading.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDelActionsHeading.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        delSearchRow.setBackground(new java.awt.Color(255, 255, 255));
        delSearchRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delSearchRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelSearch.setText("Search");
        lblDelSearch.setPreferredSize(new java.awt.Dimension(105, 28));
        delSearchRow.add(lblDelSearch, java.awt.BorderLayout.WEST);

        delSearchRow.add(txtDelSearch, java.awt.BorderLayout.CENTER);
        delAgentInfoRow.setBackground(new java.awt.Color(255, 255, 255));
        delAgentInfoRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delAgentInfoRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelAgentInfo.setText("Assigned agent");
        lblDelAgentInfo.setPreferredSize(new java.awt.Dimension(105, 28));
        delAgentInfoRow.add(lblDelAgentInfo, java.awt.BorderLayout.WEST);

        txtDelAgentInfo.setEditable(false);
        delAgentInfoRow.add(txtDelAgentInfo, java.awt.BorderLayout.CENTER);
        delScheduleInfoRow.setBackground(new java.awt.Color(255, 255, 255));
        delScheduleInfoRow.setPreferredSize(new java.awt.Dimension(270, 34));
        delScheduleInfoRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblDelScheduleInfo.setText("Scheduled for");
        lblDelScheduleInfo.setPreferredSize(new java.awt.Dimension(105, 28));
        delScheduleInfoRow.add(lblDelScheduleInfo, java.awt.BorderLayout.WEST);

        txtDelScheduleInfo.setEditable(false);
        delScheduleInfoRow.add(txtDelScheduleInfo, java.awt.BorderLayout.CENTER);
        btnDelCancel.setText("CANCEL DELIVERY");
        btnDelCancel.addActionListener(evt -> onCancelDelivery(evt));
        lblDelAssignSection.setText("01   ASSIGN AN AGENT");
        lblDelAssignSection.setOpaque(true);
        lblDelAssignSection.setBackground(new java.awt.Color(231, 243, 235));
        lblDelAssignSection.setForeground(new java.awt.Color(30, 94, 64));
        lblDelAssignSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDelAssignSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        lblDelScheduleSection.setText("02   SCHEDULE & DISPATCH");
        lblDelScheduleSection.setOpaque(true);
        lblDelScheduleSection.setBackground(new java.awt.Color(231, 243, 235));
        lblDelScheduleSection.setForeground(new java.awt.Color(30, 94, 64));
        lblDelScheduleSection.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDelScheduleSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 2));
        delInputsPanel.add(lblDelAssignSection);
        delInputsPanel.add(delOrderRow);
        delInputsPanel.add(delAgentRow);
        delInputsPanel.add(btnDelAssign);
        delInputsPanel.add(lblDelScheduleSection);
        delInputsPanel.add(delIdRow);
        delInputsPanel.add(delStatusRow);
        delInputsPanel.add(delScheduleRow);
        delInputsPanel.add(btnDelSchedule);
        delInputsPanel.add(btnDelDispatch);
        delInputsPanel.add(lblDelActionsHeading);
        delInputsPanel.add(delSearchRow);
        delInputsPanel.add(delAgentInfoRow);
        delInputsPanel.add(delScheduleInfoRow);
        delInputsPanel.add(delReasonRow);
        delInputsPanel.add(btnDelDelivered);
        delInputsPanel.add(btnDelFailed);
        delInputsPanel.add(btnDelCancel);
        delControlsScroll.setViewportView(delInputsPanel);
        delControlsPanel.add(delControlsScroll, java.awt.BorderLayout.CENTER);
        deliveriesTilesPanel.add(delControlsPanel, java.awt.BorderLayout.WEST);
        delDataPanel.setBackground(new java.awt.Color(246, 249, 247));
        delDataPanel.setLayout(new java.awt.BorderLayout(0, 10));
        delDeliveriesToolbar.setBackground(new java.awt.Color(246, 249, 247));
        delDeliveriesToolbar.setPreferredSize(new java.awt.Dimension(700, 40));
        delDeliveriesToolbar.setLayout(new java.awt.GridLayout(1, 2, 5, 0));
        lblDeliveriesTable.setText("DELIVERIES  •  Select to update");
        lblDeliveriesTable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        delDeliveriesToolbar.add(lblDeliveriesTable);
        btnDelDelivered.setText("Mark delivered");
        btnDelDelivered.addActionListener(evt -> onMarkDelivered(evt));

        btnDelFailed.setText("Mark failed");
        btnDelFailed.addActionListener(evt -> onMarkFailed(evt));

        btnDelRefresh.setText("Refresh");
        btnDelRefresh.addActionListener(evt -> onRefreshDeliveries(evt));
        delDeliveriesToolbar.add(btnDelRefresh);
        delDataPanel.add(delDeliveriesToolbar, java.awt.BorderLayout.NORTH);

        tblDeliveries.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDeliveries.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Delivery ID", "Order ID", "Agent", "Status", "Scheduled for", "Dispatched at", "Delivered at", "Failure"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) {return types[columnIndex];}
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit[columnIndex];}
        });
        tblDeliveries.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent evt) { onDeliveryRowClick(evt); }
        });
        delDeliveriesScroll.setViewportView(tblDeliveries);
        delDataPanel.add(delDeliveriesScroll, java.awt.BorderLayout.CENTER);
        delOrdersPanel.setBackground(new java.awt.Color(255, 255, 255));
        delOrdersPanel.setPreferredSize(new java.awt.Dimension(700, 170));
        delOrdersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 8, 7, 8));
        delOrdersPanel.setLayout(new java.awt.BorderLayout(0, 5));
        lblDelOrders.setText("CONFIRMED ORDERS  •  Select one to assign an agent");
        lblDelOrders.setFont(new java.awt.Font("Segoe UI", 1, 13));
        delOrdersPanel.add(lblDelOrders, java.awt.BorderLayout.NORTH);

        tblDelOrders.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Order ID", "Client", "Order status", "Total"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.math.BigDecimal.class};
            boolean[] canEdit = new boolean[] {false, false, false, false};
            public Class getColumnClass(int columnIndex) {return types[columnIndex];}
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit[columnIndex];}
        });
        delOrdersScroll.setViewportView(tblDelOrders);
        delOrdersPanel.add(delOrdersScroll, java.awt.BorderLayout.CENTER);
        delDataPanel.add(delOrdersPanel, java.awt.BorderLayout.SOUTH);
        deliveriesTilesPanel.add(delDataPanel, java.awt.BorderLayout.CENTER);

        deliveriesDetailsPanel.add(deliveriesTilesPanel, java.awt.BorderLayout.CENTER);

        deliveriesModuleStatus.setText("Delivery operations | Assign, schedule and monitor shipments");
        deliveriesModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesModuleStatus.setPreferredSize(new java.awt.Dimension(700, 28));
        deliveriesModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 3, 0));
        deliveriesDetailsPanel.add(deliveriesModuleStatus, java.awt.BorderLayout.SOUTH);


        deliveriesPage.add(deliveriesDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(deliveriesPage, "deliveries");

        reportsPage.setBackground(new java.awt.Color(246, 249, 247));
        reportsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        reportsPage.setLayout(new java.awt.BorderLayout());

        reportsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 94));
        reportsIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        reportsEyebrow.setText("ECONEST / REPORTS");
        reportsEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        reportsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        reportsIntroPanel.add(reportsEyebrow);

        reportsHeading.setText("Monthly Reports");
        reportsHeading.setForeground(new java.awt.Color(35, 55, 44));
        reportsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        reportsIntroPanel.add(reportsHeading);

        reportsDescription.setText("Generate monthly sales, inventory and low-stock reports from live data.");
        reportsDescription.setForeground(new java.awt.Color(110, 128, 117));
        reportsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        reportsIntroPanel.add(reportsDescription);


        reportsPage.add(reportsIntroPanel, java.awt.BorderLayout.NORTH);

        reportsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportsDetailsPanel.setLayout(new java.awt.BorderLayout());

        reportsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportsTilesPanel.setLayout(new java.awt.BorderLayout(0, 9));
        reportToolbarPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportToolbarPanel.setPreferredSize(new java.awt.Dimension(810, 56));
        reportToolbarPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 8, 14));
        reportToolbarPanel.setLayout(new java.awt.BorderLayout(6, 0));
        reportPickerPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportPickerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 9, 6));
        lblReportMonth.setText("MONTH");
        lblReportMonth.setForeground(new java.awt.Color(37, 61, 48));
        lblReportMonth.setFont(new java.awt.Font("Segoe UI", 1, 11));
        reportPickerPanel.add(lblReportMonth);
        cmbReportMonth.setPreferredSize(new java.awt.Dimension(190, 32));
        cmbReportMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        reportPickerPanel.add(cmbReportMonth);
        lblReportYear.setText("YEAR");
        lblReportYear.setForeground(new java.awt.Color(37, 61, 48));
        lblReportYear.setFont(new java.awt.Font("Segoe UI", 1, 11));
        reportPickerPanel.add(lblReportYear);
        txtReportYear.setPreferredSize(new java.awt.Dimension(84, 30));
        reportPickerPanel.add(txtReportYear);
        reportToolbarPanel.add(reportPickerPanel, java.awt.BorderLayout.WEST);
        btnGenerateReport.setText("GENERATE REPORT");
        btnGenerateReport.setBackground(new java.awt.Color(222, 241, 229));
        btnGenerateReport.setForeground(new java.awt.Color(24, 72, 48));
        btnGenerateReport.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnGenerateReport.setPreferredSize(new java.awt.Dimension(180, 36));
        btnGenerateReport.addActionListener(evt -> onGenerateReport(evt));
        reportToolbarPanel.add(btnGenerateReport, java.awt.BorderLayout.EAST);
        reportsTilesPanel.add(reportToolbarPanel, java.awt.BorderLayout.NORTH);
        reportBodyPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportBodyPanel.setLayout(new java.awt.BorderLayout(0, 9));
        reportMetricsPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportMetricsPanel.setPreferredSize(new java.awt.Dimension(810, 110));
        reportMetricsPanel.setLayout(new java.awt.GridLayout(2, 4, 9, 8));
        reportCardGross.setBackground(new java.awt.Color(255, 255, 255));
        reportCardGross.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardGross.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleGross.setText("GROSS CONFIRMED");
        reportCardTitleGross.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleGross.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardGross.add(reportCardTitleGross, java.awt.BorderLayout.NORTH);
        lblReportGross.setText("—");
        lblReportGross.setForeground(new java.awt.Color(29, 71, 48));
        lblReportGross.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardGross.add(lblReportGross, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardGross);
        reportCardCancelled.setBackground(new java.awt.Color(255, 255, 255));
        reportCardCancelled.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardCancelled.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleCancelled.setText("CANCELLATION AMOUNT");
        reportCardTitleCancelled.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleCancelled.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardCancelled.add(reportCardTitleCancelled, java.awt.BorderLayout.NORTH);
        lblReportCancelled.setText("—");
        lblReportCancelled.setForeground(new java.awt.Color(29, 71, 48));
        lblReportCancelled.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardCancelled.add(lblReportCancelled, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardCancelled);
        reportCardNet.setBackground(new java.awt.Color(255, 255, 255));
        reportCardNet.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardNet.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleNet.setText("NET REVENUE");
        reportCardTitleNet.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleNet.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardNet.add(reportCardTitleNet, java.awt.BorderLayout.NORTH);
        lblReportNet.setText("—");
        lblReportNet.setForeground(new java.awt.Color(29, 71, 48));
        lblReportNet.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardNet.add(lblReportNet, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardNet);
        reportCardOrderCount.setBackground(new java.awt.Color(255, 255, 255));
        reportCardOrderCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardOrderCount.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleOrderCount.setText("CONFIRMED / CANCELLED");
        reportCardTitleOrderCount.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleOrderCount.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardOrderCount.add(reportCardTitleOrderCount, java.awt.BorderLayout.NORTH);
        lblReportOrderCount.setText("—");
        lblReportOrderCount.setForeground(new java.awt.Color(29, 71, 48));
        lblReportOrderCount.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardOrderCount.add(lblReportOrderCount, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardOrderCount);
        reportCardEndUnits.setBackground(new java.awt.Color(255, 255, 255));
        reportCardEndUnits.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardEndUnits.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleEndUnits.setText("MONTH-END UNITS");
        reportCardTitleEndUnits.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleEndUnits.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardEndUnits.add(reportCardTitleEndUnits, java.awt.BorderLayout.NORTH);
        lblReportEndUnits.setText("—");
        lblReportEndUnits.setForeground(new java.awt.Color(29, 71, 48));
        lblReportEndUnits.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardEndUnits.add(lblReportEndUnits, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardEndUnits);
        reportCardStockIn.setBackground(new java.awt.Color(255, 255, 255));
        reportCardStockIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardStockIn.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleStockIn.setText("UNITS IN");
        reportCardTitleStockIn.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleStockIn.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardStockIn.add(reportCardTitleStockIn, java.awt.BorderLayout.NORTH);
        lblReportStockIn.setText("—");
        lblReportStockIn.setForeground(new java.awt.Color(29, 71, 48));
        lblReportStockIn.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardStockIn.add(lblReportStockIn, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardStockIn);
        reportCardStockOut.setBackground(new java.awt.Color(255, 255, 255));
        reportCardStockOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardStockOut.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleStockOut.setText("UNITS OUT");
        reportCardTitleStockOut.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleStockOut.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardStockOut.add(reportCardTitleStockOut, java.awt.BorderLayout.NORTH);
        lblReportStockOut.setText("—");
        lblReportStockOut.setForeground(new java.awt.Color(29, 71, 48));
        lblReportStockOut.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardStockOut.add(lblReportStockOut, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardStockOut);
        reportCardLowCount.setBackground(new java.awt.Color(255, 255, 255));
        reportCardLowCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 12, 9, 8));
        reportCardLowCount.setLayout(new java.awt.BorderLayout(0, 3));
        reportCardTitleLowCount.setText("LOW STOCK NOW");
        reportCardTitleLowCount.setForeground(new java.awt.Color(91, 119, 103));
        reportCardTitleLowCount.setFont(new java.awt.Font("Segoe UI", 1, 10));
        reportCardLowCount.add(reportCardTitleLowCount, java.awt.BorderLayout.NORTH);
        lblReportLowCount.setText("—");
        lblReportLowCount.setForeground(new java.awt.Color(29, 71, 48));
        lblReportLowCount.setFont(new java.awt.Font("Segoe UI", 1, 17));
        reportCardLowCount.add(lblReportLowCount, java.awt.BorderLayout.CENTER);
        reportMetricsPanel.add(reportCardLowCount);
        reportBodyPanel.add(reportMetricsPanel, java.awt.BorderLayout.NORTH);
        reportTablesPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportTablesPanel.setPreferredSize(new java.awt.Dimension(730, 530));
        reportTablesPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 9));
        reportFlowPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportFlowPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        reportFlowPanel.setLayout(new java.awt.BorderLayout(0, 5));
        lblReportFlowHeading.setText("MONTHLY PRODUCT STOCK MOVEMENTS AND MONTH-END BALANCES");
        lblReportFlowHeading.setForeground(new java.awt.Color(32, 74, 51));
        lblReportFlowHeading.setFont(new java.awt.Font("Segoe UI", 1, 12));
        reportFlowPanel.add(lblReportFlowHeading, java.awt.BorderLayout.NORTH);
        tblReportMonthlyStock.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Product ID", "Product", "Units In", "Units Out", "Month-end"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        reportFlowScroll.setViewportView(tblReportMonthlyStock);
        reportFlowPanel.add(reportFlowScroll, java.awt.BorderLayout.CENTER);
        reportTablesPanel.add(reportFlowPanel);
        reportLowPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportLowPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        reportLowPanel.setLayout(new java.awt.BorderLayout(0, 5));
        lblReportLowHeading.setText("CURRENT LOW-STOCK ALERTS (AS OF GENERATION)");
        lblReportLowHeading.setForeground(new java.awt.Color(32, 74, 51));
        lblReportLowHeading.setFont(new java.awt.Font("Segoe UI", 1, 12));
        reportLowPanel.add(lblReportLowHeading, java.awt.BorderLayout.NORTH);
        tblReportLowStock.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"Product ID", "Product", "On hand", "Reorder level"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class};
            boolean[] canEdit = new boolean[] {false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        reportLowScroll.setViewportView(tblReportLowStock);
        reportLowPanel.add(reportLowScroll, java.awt.BorderLayout.CENTER);
        reportTablesPanel.add(reportLowPanel);
        reportTablesOuterScroll.setViewportView(reportTablesPanel);
        reportBodyPanel.add(reportTablesOuterScroll, java.awt.BorderLayout.CENTER);
        reportsTilesPanel.add(reportBodyPanel, java.awt.BorderLayout.CENTER);
        lblReportNotice.setText("Choose a month and year, then press GENERATE REPORT.");
        lblReportNotice.setForeground(new java.awt.Color(91, 119, 103));
        lblReportNotice.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblReportNotice.setPreferredSize(new java.awt.Dimension(800, 25));
        reportsTilesPanel.add(lblReportNotice, java.awt.BorderLayout.SOUTH);
        reportsDetailsPanel.add(reportsTilesPanel, java.awt.BorderLayout.CENTER);

        reportsModuleStatus.setText("Business reports | Sales trends, inventory movements and stock alerts");
        reportsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        reportsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 28));
        reportsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 3, 0));
        reportsDetailsPanel.add(reportsModuleStatus, java.awt.BorderLayout.SOUTH);


        reportsPage.add(reportsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(reportsPage, "reports");

        emailsPage.setBackground(new java.awt.Color(246, 249, 247));
        emailsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        emailsPage.setLayout(new java.awt.BorderLayout());

        emailsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        emailsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        emailsIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        emailsEyebrow.setText("ECONEST / EMAIL NOTIFICATIONS");
        emailsEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        emailsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        emailsIntroPanel.add(emailsEyebrow);

        emailsHeading.setText("Email Notifications");
        emailsHeading.setForeground(new java.awt.Color(35, 55, 44));
        emailsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        emailsIntroPanel.add(emailsHeading);

        emailsDescription.setText("Client dispatch and agent assignment emails, delivery status, and retries.");
        emailsDescription.setForeground(new java.awt.Color(110, 128, 117));
        emailsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsIntroPanel.add(emailsDescription);


        emailsPage.add(emailsIntroPanel, java.awt.BorderLayout.NORTH);

        emailsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        emailsDetailsPanel.setLayout(new java.awt.BorderLayout());

        emailsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        emailsTilesPanel.setLayout(new java.awt.BorderLayout(0, 10));
        emailToolbarPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailToolbarPanel.setPreferredSize(new java.awt.Dimension(790, 102));
        emailToolbarPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 13, 10, 13));
        emailToolbarPanel.setLayout(new java.awt.BorderLayout(0, 0));
        emailToolbarTitlePanel.setBackground(new java.awt.Color(255, 255, 255));
        emailToolbarTitlePanel.setPreferredSize(new java.awt.Dimension(280, 70));
        emailToolbarTitlePanel.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
        lblEmailHeading.setText("NOTIFICATION DELIVERY");
        lblEmailHeading.setForeground(new java.awt.Color(24, 64, 44));
        lblEmailHeading.setFont(new java.awt.Font("Segoe UI", 1, 14));
        emailToolbarTitlePanel.add(lblEmailHeading);
        lblEmailSubtitle.setText("Transactional outbox | Tasks 8 and 9");
        lblEmailSubtitle.setForeground(new java.awt.Color(93, 119, 106));
        lblEmailSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailToolbarTitlePanel.add(lblEmailSubtitle);
        emailToolbarPanel.add(emailToolbarTitlePanel, java.awt.BorderLayout.WEST);
        emailButtonsPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailButtonsPanel.setLayout(new java.awt.GridLayout(2, 2, 8, 6));
        cmbEmailFilter.setPreferredSize(new java.awt.Dimension(175, 32));
        cmbEmailFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All events", "Client dispatch", "Agent assignment", "Pending", "Sent", "Failed" }));
        cmbEmailFilter.addActionListener(evt -> onEmailFilterChanged(evt));
        emailButtonsPanel.add(cmbEmailFilter);
        btnEmailRefresh.setText("REFRESH");
        btnEmailRefresh.setBackground(new java.awt.Color(222, 241, 229));
        btnEmailRefresh.setForeground(new java.awt.Color(24, 72, 48));
        btnEmailRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEmailRefresh.setPreferredSize(new java.awt.Dimension(178, 36));
        btnEmailRefresh.addActionListener(evt -> onRefreshEmails(evt));
        emailButtonsPanel.add(btnEmailRefresh);
        btnEmailRetry.setText("RETRY CLIENT EMAILS");
        btnEmailRetry.setBackground(new java.awt.Color(222, 241, 229));
        btnEmailRetry.setForeground(new java.awt.Color(24, 72, 48));
        btnEmailRetry.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEmailRetry.setPreferredSize(new java.awt.Dimension(178, 36));
        btnEmailRetry.addActionListener(evt -> onRetryClientEmails(evt));
        emailButtonsPanel.add(btnEmailRetry);
        btnEmailRetryAgent.setText("RETRY AGENT EMAILS");
        btnEmailRetryAgent.setBackground(new java.awt.Color(222, 241, 229));
        btnEmailRetryAgent.setForeground(new java.awt.Color(24, 72, 48));
        btnEmailRetryAgent.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnEmailRetryAgent.setPreferredSize(new java.awt.Dimension(178, 36));
        btnEmailRetryAgent.addActionListener(evt -> onRetryAgentEmails(evt));
        emailButtonsPanel.add(btnEmailRetryAgent);
        emailToolbarPanel.add(emailButtonsPanel, java.awt.BorderLayout.EAST);
        emailsTilesPanel.add(emailToolbarPanel, java.awt.BorderLayout.NORTH);
        emailTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        emailTablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 10, 7, 10));
        emailTablePanel.setLayout(new java.awt.BorderLayout(0, 6));
        lblEmailHistoryHeading.setText("OUTGOING NOTIFICATION HISTORY");
        lblEmailHistoryHeading.setForeground(new java.awt.Color(32, 72, 50));
        lblEmailHistoryHeading.setFont(new java.awt.Font("Segoe UI", 1, 12));
        emailTablePanel.add(lblEmailHistoryHeading, java.awt.BorderLayout.NORTH);
        tblEmailNotifications.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {}, new String[] {"ID", "Delivery", "Recipient", "Type", "Status", "Attempts", "Created", "Sent at", "Failure detail"}) {
            Class[] types = new Class[] {java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false, false, false};
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit[columnIndex]; }
        });
        emailTableScroll.setViewportView(tblEmailNotifications);
        emailTablePanel.add(emailTableScroll, java.awt.BorderLayout.CENTER);
        emailsTilesPanel.add(emailTablePanel, java.awt.BorderLayout.CENTER);
        emailInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailInfoPanel.setPreferredSize(new java.awt.Dimension(790, 105));
        emailInfoPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 12, 9, 12));
        emailInfoPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 4));
        lblEmailConfig.setText("SMTP not configured");
        lblEmailConfig.setForeground(new java.awt.Color(37, 104, 76));
        lblEmailConfig.setFont(new java.awt.Font("Segoe UI", 1, 12));
        emailInfoPanel.add(lblEmailConfig);
        lblEmailStats.setText("Clients: P0 / S0 / F0     Agents: P0 / S0 / F0");
        lblEmailStats.setForeground(new java.awt.Color(70, 96, 78));
        lblEmailStats.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailInfoPanel.add(lblEmailStats);
        lblEmailNotice.setText("Client and agent email events are queued and retried independently.");
        lblEmailNotice.setForeground(new java.awt.Color(94, 119, 105));
        lblEmailNotice.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailInfoPanel.add(lblEmailNotice);
        emailsTilesPanel.add(emailInfoPanel, java.awt.BorderLayout.SOUTH);
        emailsDetailsPanel.add(emailsTilesPanel, java.awt.BorderLayout.CENTER);

        emailsModuleStatus.setText("Email delivery | Client dispatch alerts and agent assignment notifications");
        emailsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        emailsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        emailsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        emailsDetailsPanel.add(emailsModuleStatus, java.awt.BorderLayout.SOUTH);


        emailsPage.add(emailsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(emailsPage, "emails");



        // Context-sensitive action hints (editable in NetBeans Design > Properties).
        cmbInvProduct.setToolTipText("Choose the product for receiving, reorder settings, or write-off.");
        btnReceiveStock.setToolTipText("Adds supplier stock and records the receipt in movement history.");
        btnSetReorder.setToolTipText("Changes only the low-stock alert threshold, not stock quantity.");
        btnWriteOff.setToolTipText("Removes damaged or unusable units and records a permanent audit entry.");
        btnRegisterSupplier.setToolTipText("Creates a supplier that can be selected for future stock receipts.");
        cmbDelOrder.setToolTipText("Select a CONFIRMED order from the list.");
        cmbDelAgent.setToolTipText("Select an agent before assigning a delivery.");
        btnDelAssign.setToolTipText("Assigns an agent; reassignment is only possible before dispatch.");
        btnDelSchedule.setToolTipText("Select an ASSIGNED delivery and enter yyyy-MM-dd HH:mm in 24-hour local time.");
        btnDelDispatch.setToolTipText("Dispatches a scheduled delivery and queues a client email.");
        btnDelCancel.setToolTipText("Cancels an eligible delivery assignment; the order remains confirmed.");
        btnDelDelivered.setToolTipText("Mark the selected dispatched delivery as delivered.");
        btnDelFailed.setToolTipText("Provide a failure reason, then mark the selected delivery as failed.");
        txtDelReason.setToolTipText("Reason required when marking a delivery as failed.");
        btnCreateOrder.setToolTipText("Select a client, then create a new draft order.");
        btnAddOrderItem.setToolTipText("Select an existing DRAFT order, then choose product and quantity.");
        btnConfirmOrder.setToolTipText("Confirms a draft order and deducts available inventory.");
        btnCancelOrder.setToolTipText("Cancel the selected eligible order (before dispatch).");
        btnRemoveOrderItem.setToolTipText("Remove the selected line from a DRAFT order only.");

        workspacePanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        statusLabel.setText("EcoNest POS  |  Dashboard  |  Store operations");
        statusLabel.setForeground(new java.awt.Color(110, 128, 117));
        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 11));
        statusLabel.setPreferredSize(new java.awt.Dimension(700, 34));
        statusLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 28, 7, 8));
        statusLabel.setBackground(new java.awt.Color(255, 255, 255));
        statusLabel.setOpaque(true);
        workspacePanel.add(statusLabel, java.awt.BorderLayout.SOUTH);


        getContentPane().add(workspacePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // ===== Dashboard | current MariaDB totals (does not modify business data) =====
    // Every metric is loaded from live data on opening Dashboard. We never use
    // hard-coded values, and the slow JDBC queries run off the Swing event thread.
    private int dashboardRefreshSequence = 0;

    private static final class DashboardTotals {
        final long products;
        final long stockUnits;
        final long orders;
        final java.math.BigDecimal monthSales;

        DashboardTotals(long products, long stockUnits, long orders,
                        java.math.BigDecimal monthSales) {
            this.products = products;
            this.stockUnits = stockUnits;
            this.orders = orders;
            this.monthSales = monthSales;
        }
    }

    private static DashboardTotals loadDashboardTotals() throws java.sql.SQLException {
        java.time.YearMonth month = java.time.YearMonth.now();
        java.sql.Timestamp from = java.sql.Timestamp.valueOf(month.atDay(1).atStartOfDay());
        java.sql.Timestamp to = java.sql.Timestamp.valueOf(month.plusMonths(1).atDay(1).atStartOfDay());
        try (java.sql.Connection connection = com.econest.config.DatabaseConnection.getConnection()) {
            long products = readCount(connection, "SELECT COUNT(*) FROM products");
            long stockUnits = readCount(connection,
                    "SELECT COALESCE(SUM(quantity_on_hand), 0) FROM inventory");
            long orders = readCount(connection, "SELECT COUNT(*) FROM orders");

            // Exactly the Task 7 report rule: confirmed this month minus
            // cancellations recorded this month, including earlier-month orders.
            String sql = "SELECT "
                    + "COALESCE(SUM(CASE WHEN confirmed_at >= ? AND confirmed_at < ? "
                    + "THEN total_amount ELSE 0 END), 0) AS gross, "
                    + "COALESCE(SUM(CASE WHEN cancelled_at >= ? AND cancelled_at < ? "
                    + "AND confirmed_at IS NOT NULL THEN total_amount ELSE 0 END), 0) AS cancelled "
                    + "FROM orders";
            try (java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setTimestamp(1, from);
                statement.setTimestamp(2, to);
                statement.setTimestamp(3, from);
                statement.setTimestamp(4, to);
                try (java.sql.ResultSet rs = statement.executeQuery()) {
                    rs.next();
                    java.math.BigDecimal net = rs.getBigDecimal("gross")
                            .subtract(rs.getBigDecimal("cancelled"));
                    return new DashboardTotals(products, stockUnits, orders, net);
                }
            }
        }
    }

    private static long readCount(java.sql.Connection connection, String sql)
            throws java.sql.SQLException {
        try (java.sql.PreparedStatement ps = connection.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getLong(1);
        }
    }

    private void refreshDashboardMetrics() {
        final int sequence = ++dashboardRefreshSequence;
        metricProductsValue.setText("...");
        metricInventoryValue.setText("...");
        metricOrdersValue.setText("...");
        metricSalesValue.setText("...");
        metricsHeadingPanelCaption.setText("Loading live EcoNest totals from MariaDB...");

        new javax.swing.SwingWorker<DashboardTotals, Void>() {
            @Override protected DashboardTotals doInBackground() throws Exception {
                return loadDashboardTotals();
            }
            @Override protected void done() {
                if (sequence != dashboardRefreshSequence) return;
                try {
                    DashboardTotals result = get();
                    metricProductsValue.setText(Long.toString(result.products));
                    metricInventoryValue.setText(Long.toString(result.stockUnits));
                    metricOrdersValue.setText(Long.toString(result.orders));
                    metricSalesValue.setText(result.monthSales.toPlainString());
                    metricsHeadingPanelCaption.setText(
                        "Live counts and " + java.time.YearMonth.now()
                        + " net sales — refreshed on opening Dashboard.");
                } catch (Exception ex) {
                    // Never show made-up dashboard totals if the database is offline.
                    metricProductsValue.setText("—");
                    metricInventoryValue.setText("—");
                    metricOrdersValue.setText("—");
                    metricSalesValue.setText("—");
                    metricsHeadingPanelCaption.setText(
                        "Totals unavailable — check MariaDB, then reopen Dashboard.");
                }
            }
        }.execute();
    }

    // Set the mouse-wheel unit step on every existing GUI Builder scroll pane.
    // The Reports page already uses 20; use that speed everywhere else too.
    private void configureConsistentScrolling() {
        javax.swing.JScrollPane[] panes = {
            productDescriptionScroll, productTableScroll,
            invControlsScroll, invStockScroll, invHistoryScroll,
            clientAddressScroll, clientTableScroll,
            agentVehicleNumberScroll, agentTableScroll,
            ordControlsScroll, ordOrdersScroll, ordItemsScroll,
            delControlsScroll, delDeliveriesScroll, delOrdersScroll,
            reportTablesOuterScroll, reportFlowScroll, reportLowScroll,
            emailTableScroll
        };
        for (javax.swing.JScrollPane pane : panes) {
            pane.getVerticalScrollBar().setUnitIncrement(20);
            pane.getHorizontalScrollBar().setUnitIncrement(20);
        }
    }

    // ===== Task 7 | Reporting; no business logic inside initComponents() =====
    private final com.econest.reports.service.ReportService reportService =
            new com.econest.reports.service.ReportService();

    private void prepareReportTables() {
        java.time.YearMonth current = java.time.YearMonth.now();
        cmbReportMonth.setSelectedIndex(current.getMonthValue() - 1);
        txtReportYear.setText(Integer.toString(current.getYear()));
        tblReportMonthlyStock.setAutoCreateRowSorter(true);
        tblReportLowStock.setAutoCreateRowSorter(true);
        tblReportMonthlyStock.setRowHeight(25);
        tblReportLowStock.setRowHeight(25);
        reportTablesOuterScroll.getVerticalScrollBar().setUnitIncrement(20);
    }

    private void onGenerateReport(java.awt.event.ActionEvent evt) {
        final java.time.YearMonth month;
        try {
            int year = Integer.parseInt(txtReportYear.getText().trim());
            if (year < 2000 || year > 9999) throw new IllegalArgumentException("Choose a year between 2000 and 9999.");
            month = java.time.YearMonth.of(year, cmbReportMonth.getSelectedIndex() + 1);
        } catch (RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,"Enter a valid year (2000–9999).", "Report period", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        btnGenerateReport.setEnabled(false);
        lblReportNotice.setText("Generating " + month + " from MariaDB ...");
        // JDBC runs off the Swing event thread to keep the interface responsive.
        new javax.swing.SwingWorker<Object[],Void>() {
            @Override protected Object[] doInBackground() {
                com.econest.reports.model.SalesReport sales=reportService.generateMonthlySalesReport(month);
                com.econest.reports.model.InventoryReport inventory=reportService.generateMonthlyInventoryReport(month);
                java.util.List<Object[]> flow=reportService.getMonthlyStockRows(month);
                java.util.List<Object[]> low=reportService.getCurrentLowStockRows();
                return new Object[]{sales,inventory,flow,low};
            }
            @Override protected void done() {
                btnGenerateReport.setEnabled(true);
                try {
                    Object[] data=get();
                    com.econest.reports.model.SalesReport sales=(com.econest.reports.model.SalesReport)data[0];
                    com.econest.reports.model.InventoryReport inv=(com.econest.reports.model.InventoryReport)data[1];
                    lblReportGross.setText(sales.getGrossConfirmedRevenue().toPlainString());
                    lblReportCancelled.setText(sales.getCancellationAmount().toPlainString());
                    lblReportNet.setText(sales.getTotalRevenue().toPlainString());
                    lblReportOrderCount.setText(sales.getConfirmedOrderCount()+" / "+sales.getCancelledOrderCount());
                    lblReportEndUnits.setText(Integer.toString(inv.getMonthEndTotalUnits()));
                    lblReportStockIn.setText(Integer.toString(inv.getStockInUnits()));
                    lblReportStockOut.setText(Integer.toString(inv.getStockOutUnits()));
                    lblReportLowCount.setText(Integer.toString(inv.getCurrentLowStockCount()));
                    fillReportTable(tblReportMonthlyStock,(java.util.List<Object[]>)data[2]);
                    fillReportTable(tblReportLowStock,(java.util.List<Object[]>)data[3]);
                    lblReportNotice.setText("Report: "+month+" | Current low-stock is as of now; month-end is historical.");
                } catch (Exception ex) {
                    Throwable cause=ex.getCause()==null?ex:ex.getCause();
                    lblReportNotice.setText("Could not generate report — check MariaDB and try again.");
                    javax.swing.JOptionPane.showMessageDialog(MainDashboard.this,cause.getMessage(),
                            "Report error",javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }
    private static void fillReportTable(javax.swing.JTable target, java.util.List<Object[]> records) {
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel)target.getModel();
        model.setRowCount(0);
        for(Object[] record:records) model.addRow(record);
    }


    // ===== Task 8 | Email Notifications, with no Java-built visual components =====
    private final com.econest.emails.service.EmailService emailService =
            new com.econest.emails.service.EmailService();
    private java.util.List<com.econest.emails.model.EmailNotification> emailRows =
            java.util.Collections.emptyList();

    private void prepareEmailTable() {
        tblEmailNotifications.setAutoCreateRowSorter(true);
        tblEmailNotifications.setRowHeight(25);
        tblEmailNotifications.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        int[] sizes={55,70,215,145,85,75,145,145,240};
        for(int col=0;col<sizes.length;col++)tblEmailNotifications.getColumnModel().getColumn(col).setPreferredWidth(sizes[col]);
        lblEmailConfig.setText(com.econest.emails.service.EmailService.isSmtpConfigured()
                ? "SMTP configured from environment variables (TLS enabled)"
                : "SMTP not configured: emails remain PENDING until SMTP credentials are configured");
    }
    private void refreshEmailTable() {
        btnEmailRefresh.setEnabled(false);
        lblEmailNotice.setText("Loading notification history from MariaDB ...");
        new javax.swing.SwingWorker<java.util.List<com.econest.emails.model.EmailNotification>,Void>() {
            @Override protected java.util.List<com.econest.emails.model.EmailNotification> doInBackground() throws Exception {
                return emailService.listNotifications();
            }
            @Override protected void done() {
                btnEmailRefresh.setEnabled(true);
                try {
                    emailRows=get();applyEmailFilter();
                    lblEmailNotice.setText("Loaded client dispatch + agent assignment notification history.");
                } catch(Exception ex) {
                    Throwable cause=ex.getCause()==null?ex:ex.getCause();
                    lblEmailNotice.setText("Cannot load email history; check MariaDB connection.");
                    javax.swing.JOptionPane.showMessageDialog(MainDashboard.this,cause.getMessage(),"Email history",javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }
    private void applyEmailFilter() {
        javax.swing.table.DefaultTableModel m=(javax.swing.table.DefaultTableModel)tblEmailNotifications.getModel();
        m.setRowCount(0);
        int cPending=0,cSent=0,cFailed=0,aPending=0,aSent=0,aFailed=0;
        String filter=String.valueOf(cmbEmailFilter.getSelectedItem());
        for(com.econest.emails.model.EmailNotification n:emailRows) {
            if(n.getType()==com.econest.emails.model.NotificationType.CLIENT_DISPATCHED) {
                switch(n.getStatus()) {
                    case PENDING:cPending++;break;
                    case SENT:cSent++;break;
                    case FAILED:cFailed++;break;
                }
            } else if(n.getType()==com.econest.emails.model.NotificationType.AGENT_ASSIGNED) {
                switch(n.getStatus()) {
                    case PENDING:aPending++;break;
                    case SENT:aSent++;break;
                    case FAILED:aFailed++;break;
                }
            }
            if("Client dispatch".equals(filter)&&n.getType()!=com.econest.emails.model.NotificationType.CLIENT_DISPATCHED)continue;
            if("Agent assignment".equals(filter)&&n.getType()!=com.econest.emails.model.NotificationType.AGENT_ASSIGNED)continue;
            if("Pending".equals(filter)&&n.getStatus()!=com.econest.emails.model.NotificationStatus.PENDING)continue;
            if("Sent".equals(filter)&&n.getStatus()!=com.econest.emails.model.NotificationStatus.SENT)continue;
            if("Failed".equals(filter)&&n.getStatus()!=com.econest.emails.model.NotificationStatus.FAILED)continue;
            m.addRow(new Object[]{n.getNotificationId(),n.getDeliveryId(),n.getRecipientEmail(),
                    n.getType().name(),n.getStatus().name(),n.getAttemptCount(),
                    n.getCreatedAt()==null?"":n.getCreatedAt().toString(),
                    n.getSentAt()==null?"":n.getSentAt().toString(),n.getFailureReason()});
        }
        lblEmailStats.setText("Clients: P"+cPending+" / S"+cSent+" / F"+cFailed+
                "     Agents: P"+aPending+" / S"+aSent+" / F"+aFailed);
    }
    private void onEmailFilterChanged(java.awt.event.ActionEvent evt){applyEmailFilter();}
    private void onRefreshEmails(java.awt.event.ActionEvent evt){refreshEmailTable();}
    private void onRetryClientEmails(java.awt.event.ActionEvent evt) {
        if(!com.econest.emails.service.EmailService.isSmtpConfigured()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Configure the SMTP environment variables first. Passwords must NOT be placed in GitHub.",
                    "SMTP settings required",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        btnEmailRetry.setEnabled(false);
        lblEmailNotice.setText("Retrying pending / failed client emails in the background ...");
        new javax.swing.SwingWorker<Void,Void>() {
            @Override protected Void doInBackground(){emailService.retryUnsentClientNotifications();return null;}
            @Override protected void done(){
                btnEmailRetry.setEnabled(true);
                refreshEmailTable();
            }
        }.execute();
    }

    /** Task 9: agent retry runs off the Swing event dispatch thread. */
    private void onRetryAgentEmails(java.awt.event.ActionEvent evt) {
        if(!com.econest.emails.service.EmailService.isSmtpConfigured()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Configure the SMTP environment variables on this PC first. Do not store passwords in GitHub.",
                    "SMTP settings required",javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        btnEmailRetryAgent.setEnabled(false);
        lblEmailNotice.setText("Retrying pending / failed agent emails in the background ...");
        new javax.swing.SwingWorker<Void,Void>() {
            @Override protected Void doInBackground(){emailService.retryUnsentAgentNotifications();return null;}
            @Override protected void done(){
                btnEmailRetryAgent.setEnabled(true);
                refreshEmailTable();
            }
        }.execute();
    }

    private void onBtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("dashboard");
    }

    private void onBtnProductsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("products");
    }

    private void onBtnInventoryActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("inventory");
    }

    private void onBtnClientsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("clients");
    }

    private void onBtnDeliveryAgentsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("agents");
    }

    private void onBtnOrdersActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("orders");
    }

    private void onBtnDeliveriesActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("deliveries");
    }

    private void onBtnReportsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("reports");
    }

    private void onBtnEmailNotificationsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("emails");
    }

    private void onQuickProductsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("products");
    }

    private void onQuickInventoryActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("inventory");
    }

    private void onQuickOrdersActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("orders");
    }

    private void onQuickReportsActionPerformed(java.awt.event.ActionEvent evt) {
        showPage("reports");
    }

    // Controller code (not generated by GUI Builder)
    private final com.econest.catalog.service.ProductService productService =
            new com.econest.catalog.service.ProductService();
    // Task 3 logic. All Swing controls below exist in the NetBeans .form file.
    private final com.econest.catalog.service.InventoryService inventoryService =
            new com.econest.catalog.service.InventoryService();
    private boolean lowStockOnly = false;

    private void prepareInventoryTables() {
        invStockScroll.getViewport().setBackground(java.awt.Color.WHITE);
        tblInventory.setFillsViewportHeight(true);
        tblInventory.setBackground(java.awt.Color.WHITE);
        tblInventory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblInventory.setAutoCreateRowSorter(true);
        invHistoryScroll.getViewport().setBackground(java.awt.Color.WHITE);
        tblInvMovements.setFillsViewportHeight(true);
        tblInvMovements.setBackground(java.awt.Color.WHITE);
        tblInvMovements.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblInvMovements.setAutoCreateRowSorter(true);
        spnInvReceiveQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000000, 1));
        spnInvWriteOffQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000000, 1));
        spnInvReorder.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000000, 1));
        invControlsScroll.getVerticalScrollBar().setUnitIncrement(15);
        refreshInventoryData();
    }

    private void refreshInventoryData() {
        try {
            java.util.List<com.econest.catalog.model.InventoryRow> all =
                    inventoryService.listInventoryRows(false);
            java.util.List<com.econest.catalog.model.InventoryRow> display =
                    lowStockOnly ? inventoryService.listInventoryRows(true) : all;
            javax.swing.table.DefaultTableModel stock =
                    (javax.swing.table.DefaultTableModel) tblInventory.getModel();
            stock.setRowCount(0);
            for (com.econest.catalog.model.InventoryRow item : display) {
                stock.addRow(new Object[] {item.getProductId(), item.getProductName(),
                    item.getCategory(), item.getQuantityOnHand(), item.getReorderLevel(),
                    item.isLowStock() ? "LOW STOCK" : "OK"});
            }
            int previousId = selectedInvProductId();
            javax.swing.DefaultComboBoxModel<com.econest.catalog.model.InventoryRow> products =
                    new javax.swing.DefaultComboBoxModel<>();
            for (com.econest.catalog.model.InventoryRow p : all) products.addElement(p);
            cmbInvProduct.setModel(products);
            selectInventoryProduct(previousId > 0 ? previousId : selectedInvProductId());

            java.util.List<com.econest.catalog.model.Supplier> suppliers = inventoryService.listSuppliers();
            int prevSupplierId = selectedInvSupplierId();
            javax.swing.DefaultComboBoxModel<com.econest.catalog.model.Supplier> suppliersModel =
                    new javax.swing.DefaultComboBoxModel<>();
            for (com.econest.catalog.model.Supplier supplier : suppliers)
                suppliersModel.addElement(supplier);
            cmbInvSupplier.setModel(suppliersModel);
            for (int i=0; i<suppliersModel.getSize(); i++) {
                if (suppliersModel.getElementAt(i).getSupplierId()==prevSupplierId) {
                    cmbInvSupplier.setSelectedIndex(i); break;
                }
            }

            javax.swing.table.DefaultTableModel journal =
                    (javax.swing.table.DefaultTableModel) tblInvMovements.getModel();
            journal.setRowCount(0);
            for (com.econest.catalog.model.StockMovement m : inventoryService.listStockMovements()) {
                journal.addRow(new Object[] {m.getOccurredAt().toString().replace('T', ' '),
                    m.getType().name(), m.getProductNameAtMovement(), m.getQuantity(),
                    m.getSupplierId()==null ? "—" : m.getSupplierId().toString(),
                    m.getOrderId()==null ? "—" : m.getOrderId().toString(),
                    m.getReason()==null ? "" : m.getReason()});
            }
            long lowCount = all.stream().filter(com.econest.catalog.model.InventoryRow::isLowStock).count();
            long total = 0;
            for (com.econest.catalog.model.InventoryRow p : all) total+=p.getQuantityOnHand();
            inventoryModuleStatus.setText(all.size() + " products | "
                    + total + " units | " + lowCount + " low-stock items | "
                    + (lowStockOnly ? "Low-stock filter" : "All stock"));
            metricInventoryValue.setText(String.valueOf(total));
        } catch (java.sql.SQLException | RuntimeException ex) {
            inventoryModuleStatus.setText("Inventory database error: " + ex.getMessage());
        }
    }

    private int selectedInvProductId() {
        Object value = cmbInvProduct.getSelectedItem();
        return value instanceof com.econest.catalog.model.InventoryRow
                ? ((com.econest.catalog.model.InventoryRow)value).getProductId() : 0;
    }
    private int selectedInvSupplierId() {
        Object value = cmbInvSupplier.getSelectedItem();
        return value instanceof com.econest.catalog.model.Supplier
                ? ((com.econest.catalog.model.Supplier)value).getSupplierId() : 0;
    }
    private void selectInventoryProduct(int id) {
        if (id <= 0) return;
        for (int i=0; i<cmbInvProduct.getItemCount(); i++) {
            Object item = cmbInvProduct.getItemAt(i);
            if (item instanceof com.econest.catalog.model.InventoryRow
                    && ((com.econest.catalog.model.InventoryRow)item).getProductId() == id) {
                cmbInvProduct.setSelectedIndex(i);
                spnInvReorder.setValue(((com.econest.catalog.model.InventoryRow)item).getReorderLevel());
                break;
            }
        }
    }

    private void onInventoryRowClick(java.awt.event.MouseEvent evt) {
        int view = tblInventory.getSelectedRow();
        if (view < 0) return;
        int model = tblInventory.convertRowIndexToModel(view);
        int id = (Integer) tblInventory.getModel().getValueAt(model,0);
        selectInventoryProduct(id);
    }
    private void onRefreshInventory(java.awt.event.ActionEvent evt) { refreshInventoryData(); }
    private void onShowAllInventory(java.awt.event.ActionEvent evt) {
        lowStockOnly = false;
        refreshInventoryData();
    }
    private void onShowLowStock(java.awt.event.ActionEvent evt) {
        lowStockOnly = true;
        refreshInventoryData();
    }

    private void onReceiveStock(java.awt.event.ActionEvent evt) {
        int id = selectedInvProductId();
        int supplierId = selectedInvSupplierId();
        int qty = ((Number) spnInvReceiveQty.getValue()).intValue();
        if (id <= 0 || supplierId <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Select an existing product and supplier.");
            return;
        }
        try {
            inventoryService.receiveStock(id, supplierId, qty);
            refreshInventoryData();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Stock-in recorded. Quantity and movement history updated.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Stock-in failed", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onSetReorder(java.awt.event.ActionEvent evt) {
        int id = selectedInvProductId();
        int level = ((Number) spnInvReorder.getValue()).intValue();
        if (id <= 0) { javax.swing.JOptionPane.showMessageDialog(this,"Select a product."); return; }
        try {
            inventoryService.setReorderLevel(id,level);
            refreshInventoryData();
            javax.swing.JOptionPane.showMessageDialog(this,"Reorder level updated.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Update failed",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onWriteOffStock(java.awt.event.ActionEvent evt) {
        int id = selectedInvProductId();
        int qty = ((Number) spnInvWriteOffQty.getValue()).intValue();
        String reason = txtInvWriteOffReason.getText().trim();
        if (id <= 0 || reason.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Select a product and enter a write-off reason.");
            return;
        }
        int option = javax.swing.JOptionPane.showConfirmDialog(this,
                "Permanently write off " + qty + " units? This creates an immutable stock movement.",
                "Confirm stock write-off",javax.swing.JOptionPane.YES_NO_OPTION);
        if (option != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            inventoryService.writeOffStock(id, qty, reason);
            txtInvWriteOffReason.setText("");
            refreshInventoryData();
            javax.swing.JOptionPane.showMessageDialog(this,"Write-off recorded.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Write-off failed",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onRegisterSupplier(java.awt.event.ActionEvent evt) {
        try {
            com.econest.catalog.model.Supplier supplier =
                    new com.econest.catalog.model.Supplier(
                        txtInvSupplierName.getText(),
                        txtInvSupplierPhone.getText(),
                        txtInvSupplierEmail.getText());
            int newId = inventoryService.addSupplier(supplier);
            txtInvSupplierName.setText("");
            txtInvSupplierPhone.setText("");
            txtInvSupplierEmail.setText("");
            refreshInventoryData();
            for (int i=0; i<cmbInvSupplier.getItemCount(); i++) {
                Object item=cmbInvSupplier.getItemAt(i);
                if (item instanceof com.econest.catalog.model.Supplier &&
                    ((com.econest.catalog.model.Supplier)item).getSupplierId()==newId) {
                    cmbInvSupplier.setSelectedIndex(i); break;
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this,"Supplier registered (#" + newId + ").");
        } catch (java.sql.SQLException | RuntimeException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Supplier registration failed",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private Integer selectedProductId = null;
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> productSorter;

    private void prepareProductTable() {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblProducts.getModel();
        productSorter = new javax.swing.table.TableRowSorter<>(model);
        tblProducts.setRowSorter(productSorter);
        tblProducts.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) loadSelectedProductIntoForm();
        });
        tblProducts.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblProducts.getColumnModel().getColumn(1).setPreferredWidth(145);
        tblProducts.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblProducts.getColumnModel().getColumn(3).setPreferredWidth(82);
        tblProducts.getColumnModel().getColumn(4).setPreferredWidth(48);
        tblProducts.setRowHeight(27);
    }

    private void refreshProductTable() {
        if (productSorter == null) return;
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblProducts.getModel();
        try {
            java.util.List<com.econest.catalog.model.Product> products =
                    productService.listProducts();
            selectedProductId = null;
            lblSelectedProductId.setText("New product");
            model.setRowCount(0);
            for (com.econest.catalog.model.Product product : products) {
                model.addRow(new Object[] {
                    product.getProductId(), product.getName(),
                    product.getCategory().name(), product.getUnitPrice(),
                    product.getEcoRating(), product.getDescription()
                });
            }
            productsModuleStatus.setText(
                    "Products loaded: " + products.size() + "  |  Catalogue synchronized");
            applyProductSearch();
        } catch (java.sql.SQLException | RuntimeException ex) {
            productsModuleStatus.setText("Database unavailable: " + ex.getMessage());
        }
    }

    private com.econest.catalog.model.Product readProductForm() {
        String name = txtProductName.getText().trim();
        String category = (String) cmbProductCategory.getSelectedItem();
        String description = txtProductDescription.getText().trim();
        String priceString = txtProductPrice.getText().trim();
        if (priceString.isEmpty()) {
            throw new IllegalArgumentException("Enter a unit price.");
        }
        java.math.BigDecimal price;
        try {
            price = new java.math.BigDecimal(priceString);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Enter a valid price, e.g. 1250.00.");
        }
        return new com.econest.catalog.model.Product(
                name,
                com.econest.catalog.model.ProductCategory.valueOf(category),
                description.isEmpty() ? null : description,
                price,
                ((Number) spnEcoRating.getValue()).intValue()
        );
    }

    private void loadSelectedProductIntoForm() {
        int row = tblProducts.getSelectedRow();
        if (row < 0) return;
        int modelRow = tblProducts.convertRowIndexToModel(row);
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblProducts.getModel();
        selectedProductId = ((Number) model.getValueAt(modelRow, 0)).intValue();
        lblSelectedProductId.setText(String.valueOf(selectedProductId));
        txtProductName.setText((String) model.getValueAt(modelRow, 1));
        cmbProductCategory.setSelectedItem((String) model.getValueAt(modelRow, 2));
        txtProductPrice.setText(String.valueOf(model.getValueAt(modelRow, 3)));
        spnEcoRating.setValue(model.getValueAt(modelRow, 4));
        Object description = model.getValueAt(modelRow, 5);
        txtProductDescription.setText(description == null ? "" : description.toString());
    }

    private void showProductError(String action, Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this,
                action + ": " + ex.getMessage(), "EcoNest Product Catalogue",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    private void onAddProduct(java.awt.event.ActionEvent evt) {
        try {
            com.econest.catalog.model.Product p = readProductForm();
            int id = productService.addProduct(p);
            clearProductFields();
            refreshProductTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Product #" + id + " added.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            showProductError("Unable to add product", ex);
        }
    }

    private void onUpdateProduct(java.awt.event.ActionEvent evt) {
        if (selectedProductId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a product from the table first.");
            return;
        }
        try {
            com.econest.catalog.model.Product p = readProductForm();
            p.setProductId(selectedProductId);
            productService.updateProduct(p);
            clearProductFields();
            refreshProductTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Product updated.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            showProductError("Unable to update product", ex);
        }
    }

    private void onDeleteProduct(java.awt.event.ActionEvent evt) {
        if (selectedProductId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a product from the table first.");
            return;
        }
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
                "Permanently delete product #" + selectedProductId + "?\n"
                + "Existing stock and unfinished orders may prevent deletion.",
                "Confirm product deletion", javax.swing.JOptionPane.YES_NO_OPTION);
        if (choice != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            productService.deleteProduct(selectedProductId);
            clearProductFields();
            refreshProductTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Product deleted.");
        } catch (java.sql.SQLException | RuntimeException ex) {
            showProductError("Unable to delete product", ex);
        }
    }

    private void clearProductFields() {
        selectedProductId = null;
        lblSelectedProductId.setText("New product");
        txtProductName.setText("");
        cmbProductCategory.setSelectedIndex(0);
        txtProductDescription.setText("");
        txtProductPrice.setText("");
        spnEcoRating.setValue(0);
        tblProducts.clearSelection();
    }

    private void onClearProduct(java.awt.event.ActionEvent evt) {
        clearProductFields();
    }

    private void applyProductSearch() {
        if (productSorter == null) return;
        String keyword = txtProductSearch.getText().trim();
        if (keyword.isEmpty()) {
            productSorter.setRowFilter(null);
        } else {
            productSorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                    "(?i)" + java.util.regex.Pattern.quote(keyword)));
        }
    }

    private void onSearchProduct(java.awt.event.ActionEvent evt) {
        applyProductSearch();
    }

    private void onRefreshProducts(java.awt.event.ActionEvent evt) {
        refreshProductTable();
    }

    private void onProductTableClick(java.awt.event.MouseEvent evt) {
        loadSelectedProductIntoForm();
    }

    // ===== Task 2: Client Management. Business logic lives outside initComponents(). =====
    private final com.econest.clients.service.ClientService clientService =
            new com.econest.clients.service.ClientService();
    private Integer selectedClientId;
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> clientSorter;

    private void prepareClientTable() {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblClients.getModel();
        clientSorter = new javax.swing.table.TableRowSorter<>(model);
        tblClients.setRowSorter(clientSorter);
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClients.setRowHeight(27);
        tblClients.getColumnModel().getColumn(0).setPreferredWidth(45);
        tblClients.getColumnModel().getColumn(1).setPreferredWidth(140);
        tblClients.getColumnModel().getColumn(2).setPreferredWidth(95);
        tblClients.getColumnModel().getColumn(3).setPreferredWidth(170);
        tblClients.getColumnModel().getColumn(4).setPreferredWidth(110);
        tblClients.getColumnModel().getColumn(5).setPreferredWidth(175);
        tblClients.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) loadSelectedClientIntoForm();
        });
        txtClientSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { applyClientSearch(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { applyClientSearch(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { applyClientSearch(); }
        });
    }

    private void refreshClientTable() {
        if (clientSorter == null) return;
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblClients.getModel();
        try {
            java.util.List<com.econest.clients.model.Client> clients = clientService.listClients();
            tblClients.clearSelection();
            model.setRowCount(0);
            for (com.econest.clients.model.Client client : clients) {
                model.addRow(new Object[] {client.getClientId(), client.getName(),
                    client.getType().name(), client.getEmail(), client.getPhone(), client.getAddress()});
            }
            selectedClientId = null;
            lblSelectedClientId.setText("New client");
            clientsModuleStatus.setText("Clients loaded: " + clients.size()
                    + " | Customer directory updated");
            applyClientSearch();
        } catch (java.sql.SQLException | RuntimeException ex) {
            clientsModuleStatus.setText("Unable to load clients: " + ex.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Client database error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private com.econest.clients.model.Client readClientForm() {
        return new com.econest.clients.model.Client(
                txtClientName.getText(),
                com.econest.clients.model.ClientType.valueOf(
                        (String) cmbClientType.getSelectedItem()),
                txtClientEmail.getText(), txtClientPhone.getText(), txtClientAddress.getText());
    }

    private void loadSelectedClientIntoForm() {
        int row = tblClients.getSelectedRow();
        if (row < 0) return;
        int index = tblClients.convertRowIndexToModel(row); // Essential with table sorting/filtering.
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblClients.getModel();
        selectedClientId = ((Number) model.getValueAt(index, 0)).intValue();
        lblSelectedClientId.setText(String.valueOf(selectedClientId));
        txtClientName.setText((String) model.getValueAt(index, 1));
        cmbClientType.setSelectedItem((String) model.getValueAt(index, 2));
        txtClientEmail.setText((String) model.getValueAt(index, 3));
        txtClientPhone.setText((String) model.getValueAt(index, 4));
        txtClientAddress.setText((String) model.getValueAt(index, 5));
    }

    private void clearClientFields() {
        tblClients.clearSelection();
        selectedClientId = null;
        lblSelectedClientId.setText("New client");
        txtClientName.setText("");
        cmbClientType.setSelectedIndex(0);
        txtClientEmail.setText("");
        txtClientPhone.setText("");
        txtClientAddress.setText("");
    }

    private void applyClientSearch() {
        if (clientSorter == null) return;
        String keyword = txtClientSearch.getText().trim();
        if (keyword.isEmpty()) clientSorter.setRowFilter(null);
        else clientSorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                "(?i)" + java.util.regex.Pattern.quote(keyword)));
        // A filtered-out row must not remain the target for Update or Delete.
        tblClients.clearSelection();
        selectedClientId = null;
        lblSelectedClientId.setText("New client");
    }

    private void showClientError(String operation, Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, operation + ": " + ex.getMessage(),
                "EcoNest Clients", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    private void onAddClient(java.awt.event.ActionEvent evt) {
        try {
            int id = clientService.addClient(readClientForm());
            clearClientFields();
            refreshClientTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Client #" + id + " added.");
        } catch (java.sql.SQLException | RuntimeException ex) { showClientError("Add failed", ex); }
    }

    private void onUpdateClient(java.awt.event.ActionEvent evt) {
        if (selectedClientId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a client from the table first.");
            return;
        }
        try {
            com.econest.clients.model.Client client = readClientForm();
            client.setClientId(selectedClientId);
            clientService.updateClient(client);
            clearClientFields();
            refreshClientTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Client updated.");
        } catch (java.sql.SQLException | RuntimeException ex) { showClientError("Update failed", ex); }
    }

    private void onDeleteClient(java.awt.event.ActionEvent evt) {
        if (selectedClientId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a client from the table first.");
            return;
        }
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
                "Permanently delete client #" + selectedClientId + "?\n"
                + "Past orders keep their client snapshots; this record cannot be recovered.",
                "Confirm permanent deletion", javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE);
        if (choice != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            clientService.deleteClient(selectedClientId);
            clearClientFields();
            refreshClientTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Client permanently deleted.");
        } catch (java.sql.SQLException | RuntimeException ex) { showClientError("Delete failed", ex); }
    }

    private void onClearClient(java.awt.event.ActionEvent evt) { clearClientFields(); }
    private void onSearchClient(java.awt.event.ActionEvent evt) { applyClientSearch(); }
    private void onRefreshClients(java.awt.event.ActionEvent evt) { refreshClientTable(); }
    private void onClientTableClick(java.awt.event.MouseEvent evt) { loadSelectedClientIntoForm(); }

    // ===== Task 4: Delivery Agent Management (outside initComponents) =====
    private final com.econest.agents.service.DeliveryAgentService agentService =
            new com.econest.agents.service.DeliveryAgentService();
    private Integer selectedAgentId;
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> agentSorter;

    private void prepareAgentTable() {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblAgents.getModel();
        agentSorter = new javax.swing.table.TableRowSorter<>(model);
        tblAgents.setRowSorter(agentSorter);
        tblAgents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAgents.setRowHeight(27);
        int[] sizes = {50, 145, 175, 110, 125, 125};
        for (int i = 0; i < sizes.length; i++) {
            tblAgents.getColumnModel().getColumn(i).setPreferredWidth(sizes[i]);
        }
        tblAgents.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) loadSelectedAgentIntoForm();
        });
        txtAgentSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { applyAgentSearch(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { applyAgentSearch(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { applyAgentSearch(); }
        });
    }

    private void refreshAgentTable() {
        if (agentSorter == null) return;
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblAgents.getModel();
        try {
            java.util.List<com.econest.agents.model.DeliveryAgent> agents = agentService.listAgents();
            model.setRowCount(0);
            for (com.econest.agents.model.DeliveryAgent agent : agents) {
                model.addRow(new Object[] {agent.getAgentId(), agent.getName(),
                    agent.getEmail(), agent.getPhone(), agent.getVehicleType(),
                    agent.getVehicleNumber()});
            }
            selectedAgentId = null;
            lblSelectedAgentId.setText("New agent");
            agentsModuleStatus.setText("Delivery agents loaded: " + agents.size()
                    + " | Fleet directory updated");
            applyAgentSearch();
        } catch (java.sql.SQLException | RuntimeException ex) {
            agentsModuleStatus.setText("Could not load agents: " + ex.getMessage());
            showAgentError("Database load failed", ex);
        }
    }

    private com.econest.agents.model.DeliveryAgent readAgentForm() {
        Object vehicle = cmbAgentVehicleType.getSelectedItem();
        return new com.econest.agents.model.DeliveryAgent(
                txtAgentName.getText(), txtAgentEmail.getText(), txtAgentPhone.getText(),
                vehicle == null ? "" : vehicle.toString(),
                txtAgentVehicleNumber.getText());
    }

    private void loadSelectedAgentIntoForm() {
        int row = tblAgents.getSelectedRow();
        if (row < 0) return;
        int modelRow = tblAgents.convertRowIndexToModel(row);
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblAgents.getModel();
        selectedAgentId = ((Number) model.getValueAt(modelRow, 0)).intValue();
        lblSelectedAgentId.setText(String.valueOf(selectedAgentId));
        txtAgentName.setText((String) model.getValueAt(modelRow, 1));
        txtAgentEmail.setText((String) model.getValueAt(modelRow, 2));
        txtAgentPhone.setText((String) model.getValueAt(modelRow, 3));
        cmbAgentVehicleType.setSelectedItem((String) model.getValueAt(modelRow, 4));
        txtAgentVehicleNumber.setText((String) model.getValueAt(modelRow, 5));
    }

    private void clearAgentFields() {
        tblAgents.clearSelection();
        selectedAgentId = null;
        lblSelectedAgentId.setText("New agent");
        txtAgentName.setText("");
        txtAgentEmail.setText("");
        txtAgentPhone.setText("");
        cmbAgentVehicleType.setSelectedItem("Motorbike");
        txtAgentVehicleNumber.setText("");
    }

    private void applyAgentSearch() {
        if (agentSorter == null) return;
        // Clear previous selection before filtering so updates cannot target a hidden row.
        tblAgents.clearSelection();
        selectedAgentId = null;
        lblSelectedAgentId.setText("New agent");
        String query = txtAgentSearch.getText().trim();
        if (query.isEmpty()) agentSorter.setRowFilter(null);
        else agentSorter.setRowFilter(javax.swing.RowFilter.regexFilter(
                "(?i)" + java.util.regex.Pattern.quote(query)));
    }

    private void showAgentError(String action, Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, action + ": " + ex.getMessage(),
                "EcoNest Delivery Agents", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    private void onAddAgent(java.awt.event.ActionEvent evt) {
        try {
            int id = agentService.addAgent(readAgentForm());
            clearAgentFields(); refreshAgentTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Delivery agent #" + id + " registered.");
        } catch (java.sql.SQLException | RuntimeException ex) { showAgentError("Add failed", ex); }
    }

    private void onUpdateAgent(java.awt.event.ActionEvent evt) {
        if (selectedAgentId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select an agent from the table first.");
            return;
        }
        try {
            com.econest.agents.model.DeliveryAgent agent = readAgentForm();
            agent.setAgentId(selectedAgentId);
            agentService.updateAgent(agent);
            clearAgentFields(); refreshAgentTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Agent and vehicle details updated.");
        } catch (java.sql.SQLException | RuntimeException ex) { showAgentError("Update failed", ex); }
    }

    private void onDeleteAgent(java.awt.event.ActionEvent evt) {
        if (selectedAgentId == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select an agent from the table first.");
            return;
        }
        int decision = javax.swing.JOptionPane.showConfirmDialog(this,
                "Permanently delete delivery agent #" + selectedAgentId + "?\n"
                + "Any active delivery must first be reassigned or completed.\n"
                + "Past deliveries retain the agent/vehicle snapshot.",
                "Confirm permanent deletion", javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE);
        if (decision != javax.swing.JOptionPane.YES_OPTION) return;
        try {
            agentService.deleteAgent(selectedAgentId);
            clearAgentFields(); refreshAgentTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Delivery agent permanently deleted.");
        } catch (java.sql.SQLException | RuntimeException ex) { showAgentError("Delete failed", ex); }
    }

    private void onClearAgent(java.awt.event.ActionEvent evt) { clearAgentFields(); }
    private void onSearchAgent(java.awt.event.ActionEvent evt) { applyAgentSearch(); }
    private void onRefreshAgents(java.awt.event.ActionEvent evt) { refreshAgentTable(); }
    private void onAgentTableClick(java.awt.event.MouseEvent evt) { loadSelectedAgentIntoForm(); }

    // ===== TASK 5: Order Management — GUI event logic (never edit initComponents()) =====
    private final com.econest.orders.service.OrderService orderService = new com.econest.orders.service.OrderService();
    private final com.econest.clients.service.ClientService orderClients = new com.econest.clients.service.ClientService();
    private final com.econest.catalog.service.ProductService orderProducts = new com.econest.catalog.service.ProductService();
    private final com.econest.catalog.service.InventoryService orderInventory = new com.econest.catalog.service.InventoryService();
    private Integer selectedOrderId = null;
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> orderSorter;
    private static final class OrderChoice {
        final int id; final String title;
        OrderChoice(int id,String title){this.id=id;this.title=title;}
        @Override public String toString(){return title;}
    }
    private int selectedOrderChoice(javax.swing.JComboBox combo){
        Object v=combo.getSelectedItem();return v instanceof OrderChoice?((OrderChoice)v).id:0;
    }
    private void prepareOrderTables(){
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel)tblOrders.getModel();
        orderSorter=new javax.swing.table.TableRowSorter<>(model);tblOrders.setRowSorter(orderSorter);
        tblOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrderItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrders.setRowHeight(26);tblOrderItems.setRowHeight(26);
        txtOrdTotal.setEditable(false);txtOrdSelectedOrder.setEditable(false);txtOrdStatus.setEditable(false);
        spnOrdLineCount.setEnabled(false);spnOrdStock.setEnabled(false);
        spnOrdQty.setModel(new javax.swing.SpinnerNumberModel(1,1,999999,1));
        tblOrders.getSelectionModel().addListSelectionListener(e->{
            if(!e.getValueIsAdjusting()&&tblOrders.getSelectedRow()>=0)loadSelectedOrder();
        });
        txtOrdSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
            public void insertUpdate(javax.swing.event.DocumentEvent e){applyOrderSearch();}
            public void removeUpdate(javax.swing.event.DocumentEvent e){applyOrderSearch();}
            public void changedUpdate(javax.swing.event.DocumentEvent e){applyOrderSearch();}
        });
        cmbOrdProduct.addActionListener(e->refreshOrderSelectedStock());
        clearOrderSelection();
    }
    private void applyOrderSearch(){
        if(orderSorter==null)return;
        String search=txtOrdSearch.getText().trim();
        orderSorter.setRowFilter(search.isEmpty()?null:javax.swing.RowFilter.regexFilter("(?i)"+java.util.regex.Pattern.quote(search)));
    }
    private void refreshOrderChoices(){
        int clientId=selectedOrderChoice(cmbOrdClient),productId=selectedOrderChoice(cmbOrdProduct);
        try{
            cmbOrdClient.removeAllItems();cmbOrdClient.addItem(new OrderChoice(0,"Select a client"));
            for(com.econest.clients.model.Client c:orderClients.listClients())
                cmbOrdClient.addItem(new OrderChoice(c.getClientId(),"#"+c.getClientId()+"  "+c.getName()+" ("+c.getType()+")"));
            cmbOrdProduct.removeAllItems();cmbOrdProduct.addItem(new OrderChoice(0,"Select a product"));
            for(com.econest.catalog.model.Product p:orderProducts.listProducts())
                cmbOrdProduct.addItem(new OrderChoice(p.getProductId(),"#"+p.getProductId()+"  "+p.getName()+" — "+p.getUnitPrice()));
            for(int i=0;i<cmbOrdClient.getItemCount();i++)
                if(((OrderChoice)cmbOrdClient.getItemAt(i)).id==clientId)cmbOrdClient.setSelectedIndex(i);
            for(int i=0;i<cmbOrdProduct.getItemCount();i++)
                if(((OrderChoice)cmbOrdProduct.getItemAt(i)).id==productId)cmbOrdProduct.setSelectedIndex(i);
        }catch(Exception ex){showOrderError("Loading clients/products",ex);}
        refreshOrderSelectedStock();
    }
    private void refreshOrderSelectedStock(){
        int pid=selectedOrderChoice(cmbOrdProduct);
        try{spnOrdStock.setValue(pid>0?orderInventory.getAvailableStock(pid):0);}
        catch(Exception e){spnOrdStock.setValue(0);}
    }
    private void refreshOrdersData(){
        if(orderSorter==null)return;
        refreshOrderChoices();
        javax.swing.table.DefaultTableModel model=(javax.swing.table.DefaultTableModel)tblOrders.getModel();
        try{
            java.util.List<com.econest.orders.model.Order> orders=orderService.listOrders();
            model.setRowCount(0);
            for(com.econest.orders.model.Order o:orders)model.addRow(new Object[]{
                o.getOrderId(),o.getClientNameAtOrder(),o.getStatus().name(),o.getItems().size(),
                o.getTotalAmount(),o.getCreatedAt()==null?"":o.getCreatedAt().toString().replace('T',' ')});
            // Only DRAFT is editable; restored selection follows underlying order ID.
            if(selectedOrderId!=null){
                boolean found=false;
                for(int i=0;i<model.getRowCount();i++){
                    if(((Number)model.getValueAt(i,0)).intValue()==selectedOrderId){
                        int view=tblOrders.convertRowIndexToView(i);
                        if(view>=0){tblOrders.setRowSelectionInterval(view,view);found=true;}break;
                    }
                }
                if(!found){selectedOrderId=null;clearOrderFields();}
            }
            refreshOrderItems();
        }catch(Exception e){showOrderError("Loading orders",e);}
    }
    private void loadSelectedOrder(){
        int view=tblOrders.getSelectedRow();if(view<0)return;
        int modelRow=tblOrders.convertRowIndexToModel(view);
        selectedOrderId=((Number)tblOrders.getModel().getValueAt(modelRow,0)).intValue();
        refreshOrderItems();
    }
    private void refreshOrderItems(){
        javax.swing.table.DefaultTableModel items=(javax.swing.table.DefaultTableModel)tblOrderItems.getModel();
        items.setRowCount(0);
        if(selectedOrderId==null){clearOrderFields();return;}
        try{
            com.econest.orders.model.Order order=orderService.getOrder(selectedOrderId);
            if(order==null){selectedOrderId=null;clearOrderFields();return;}
            txtOrdSelectedOrder.setText("#"+order.getOrderId());txtOrdStatus.setText(order.getStatus().name());
            txtOrdTotal.setText(order.getTotalAmount().toPlainString());
            spnOrdLineCount.setValue(order.getItems().size());
            for(com.econest.orders.model.OrderItem item:order.getItems())items.addRow(new Object[]{
                item.getProductIdAtOrder(),item.getProductNameAtOrder(),item.getQuantity(),
                item.getUnitPriceAtOrder(),item.calculateSubtotal()});
        }catch(Exception ex){showOrderError("Loading order items",ex);}
    }
    private void clearOrderFields(){
        txtOrdSelectedOrder.setText("New order");txtOrdStatus.setText("DRAFT");txtOrdTotal.setText("0.00");
        spnOrdLineCount.setValue(0);((javax.swing.table.DefaultTableModel)tblOrderItems.getModel()).setRowCount(0);
    }
    private void clearOrderSelection(){
        selectedOrderId=null;tblOrders.clearSelection();clearOrderFields();spnOrdQty.setValue(1);
    }
    private void showOrderError(String title,Exception ex){
        javax.swing.JOptionPane.showMessageDialog(this,ex.getMessage(),title,javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    private void onCreateOrder(java.awt.event.ActionEvent evt){
        int clientId=selectedOrderChoice(cmbOrdClient);
        if(clientId<=0){javax.swing.JOptionPane.showMessageDialog(this,"Select a client first.");return;}
        try{
            com.econest.orders.model.Order created=orderService.createOrder(clientId);
            selectedOrderId=created.getOrderId();refreshOrdersData();
            javax.swing.JOptionPane.showMessageDialog(this,"Draft order #"+selectedOrderId+" created. Add products before confirming.");
        }catch(Exception ex){showOrderError("Create order failed",ex);}
    }
    private void onAddOrderItem(java.awt.event.ActionEvent evt){
        if(selectedOrderId==null){javax.swing.JOptionPane.showMessageDialog(this,"Create/select a DRAFT order first.");return;}
        int productId=selectedOrderChoice(cmbOrdProduct),qty=((Number)spnOrdQty.getValue()).intValue();
        if(productId<=0){javax.swing.JOptionPane.showMessageDialog(this,"Select a product.");return;}
        try{orderService.addOrderItem(selectedOrderId,productId,qty);refreshOrdersData();}
        catch(Exception ex){showOrderError("Add item failed",ex);}
    }
    private void onRemoveOrderItem(java.awt.event.ActionEvent evt){
        int row=tblOrderItems.getSelectedRow();
        if(selectedOrderId==null||row<0){javax.swing.JOptionPane.showMessageDialog(this,"Select an item row to remove.");return;}
        int pid=((Number)tblOrderItems.getValueAt(row,0)).intValue();
        try{orderService.removeOrderItem(selectedOrderId,pid);refreshOrdersData();}
        catch(Exception ex){showOrderError("Remove item failed",ex);}
    }
    private void onConfirmOrder(java.awt.event.ActionEvent evt){
        if(selectedOrderId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select an order.");return;}
        if(javax.swing.JOptionPane.showConfirmDialog(this,"Confirm order #"+selectedOrderId+" and deduct stock?",
                "Confirm order",javax.swing.JOptionPane.YES_NO_OPTION)!=javax.swing.JOptionPane.YES_OPTION)return;
        try{orderService.confirmOrder(selectedOrderId);refreshOrdersData();refreshInventoryData();
            javax.swing.JOptionPane.showMessageDialog(this,"Order confirmed. Stock deducted and journalled.");}
        catch(Exception ex){showOrderError("Confirmation failed",ex);}
    }
    private void onCancelOrder(java.awt.event.ActionEvent evt){
        if(selectedOrderId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select an order.");return;}
        if(javax.swing.JOptionPane.showConfirmDialog(this,"Cancel order #"+selectedOrderId+"? Confirmed orders will restore stock.",
                "Cancel order",javax.swing.JOptionPane.YES_NO_OPTION)!=javax.swing.JOptionPane.YES_OPTION)return;
        try{orderService.cancelOrder(selectedOrderId);refreshOrdersData();refreshInventoryData();
            javax.swing.JOptionPane.showMessageDialog(this,"Order cancelled successfully.");}
        catch(Exception ex){showOrderError("Cancel failed",ex);}
    }
    private void onCalculateOrderTotal(java.awt.event.ActionEvent evt){
        if(selectedOrderId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select an order first.");return;}
        try{
            java.math.BigDecimal total=orderService.calculateOrderTotal(selectedOrderId);
            txtOrdTotal.setText(total.toPlainString());
            javax.swing.JOptionPane.showMessageDialog(this,"Calculated total: "+total.toPlainString());
        }catch(Exception ex){showOrderError("Calculate total failed",ex);}
    }
    private void onRefreshOrders(java.awt.event.ActionEvent evt){refreshOrdersData();}
    private void onOrderRowClick(java.awt.event.MouseEvent evt){loadSelectedOrder();}

    // ---------- Task 6: Delivery assignment, scheduling and tracking ----------
    private final com.econest.deliveries.service.DeliveryService deliveryService =
            new com.econest.deliveries.service.DeliveryService();
    private final com.econest.agents.service.DeliveryAgentService deliveryAgents =
            new com.econest.agents.service.DeliveryAgentService();
    private final com.econest.orders.service.OrderService deliveryOrders =
            new com.econest.orders.service.OrderService();
    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> deliverySorter;
    private Integer selectedDeliveryId;
    private static final java.time.format.DateTimeFormatter DELIVERY_DATE =
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private void prepareDeliveryTables() {
        deliverySorter = new javax.swing.table.TableRowSorter<>(
                (javax.swing.table.DefaultTableModel) tblDeliveries.getModel());
        tblDeliveries.setRowSorter(deliverySorter);
        // Preserve readable table columns instead of squeezing eight columns into a small panel.
        int[] deliveryColumnWidths = {95, 90, 150, 110, 165, 165, 165, 200};
        for (int i = 0; i < deliveryColumnWidths.length; i++) {
            tblDeliveries.getColumnModel().getColumn(i).setPreferredWidth(deliveryColumnWidths[i]);
        }
        tblDeliveries.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDelOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDeliveries.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDeliveries.getSelectedRow() >= 0) loadSelectedDelivery();
        });
        tblDelOrders.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDelOrders.getSelectedRow() >= 0) {
                int id = ((Number) tblDelOrders.getValueAt(tblDelOrders.getSelectedRow(), 0)).intValue();
                selectDeliveryOrder(id);
            }
        });
        txtDelSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filterDeliveries(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filterDeliveries(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filterDeliveries(); }
        });
        cmbDelOrder.addActionListener(e -> {
            if (!loadingDeliveryChoices) findDeliveryForSelectedOrder();
        });
        clearDeliveryDetails();
    }
    private boolean loadingDeliveryChoices;
    private void filterDeliveries() {
        if (deliverySorter == null) return;
        String t = txtDelSearch.getText().trim();
        deliverySorter.setRowFilter(t.isEmpty() ? null
                : javax.swing.RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(t)));
    }
    private static String deliveryDate(java.time.LocalDateTime date) {
        return date == null ? "" : date.format(DELIVERY_DATE);
    }
    private void showDeliveryError(String operation, Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), operation,
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    private void refreshDeliveryChoices() {
        int selectedOrder = selectedOrderChoice(cmbDelOrder), selectedAgent = selectedOrderChoice(cmbDelAgent);
        loadingDeliveryChoices = true;
        try {
            cmbDelOrder.removeAllItems();
            cmbDelOrder.addItem(new OrderChoice(0, "Select confirmed order"));
            for (com.econest.orders.model.Order o : deliveryOrders.listOrders()) {
                if (o.getStatus() == com.econest.orders.model.OrderStatus.CONFIRMED) {
                    cmbDelOrder.addItem(new OrderChoice(o.getOrderId(),
                            "#" + o.getOrderId() + "  " + o.getClientNameAtOrder()));
                }
            }
            cmbDelAgent.removeAllItems();
            cmbDelAgent.addItem(new OrderChoice(0, "Select delivery agent"));
            for (com.econest.agents.model.DeliveryAgent a : deliveryAgents.listAgents()) {
                cmbDelAgent.addItem(new OrderChoice(a.getAgentId(),
                        "#" + a.getAgentId() + "  " + a.getName() + "  [" + a.getVehicleNumber() + "]"));
            }
            selectDeliveryChoice(cmbDelOrder, selectedOrder);
            selectDeliveryChoice(cmbDelAgent, selectedAgent);
        } catch(Exception ex) { showDeliveryError("Loading orders and delivery agents", ex); }
        finally { loadingDeliveryChoices = false; }
    }
    private static void selectDeliveryChoice(javax.swing.JComboBox<OrderChoice> box, int id) {
        for (int i = 0; i < box.getItemCount(); i++) {
            if (box.getItemAt(i).id == id) { box.setSelectedIndex(i); return; }
        }
        if (box.getItemCount() > 0) box.setSelectedIndex(0);
    }
    private void selectDeliveryOrder(int orderId) {
        selectDeliveryChoice(cmbDelOrder, orderId);
        findDeliveryForSelectedOrder();
    }
    private void findDeliveryForSelectedOrder() {
        int orderId = selectedOrderChoice(cmbDelOrder);
        if (orderId <= 0) { selectedDeliveryId = null; clearDeliveryDetails(); return; }
        try {
            java.util.Optional<com.econest.deliveries.model.Delivery> delivery =
                    deliveryService.getDeliveryByOrder(orderId);
            if (delivery.isPresent()) {
                selectedDeliveryId = delivery.get().getDeliveryId();
                renderDeliveryDetails(delivery.get());
                selectDeliveryRow(selectedDeliveryId);
            } else { selectedDeliveryId = null; clearDeliveryDetails(); }
        } catch(Exception ex) { showDeliveryError("Find delivery for order", ex); }
    }
    private void selectDeliveryRow(int deliveryId) {
        for (int i = 0; i < tblDeliveries.getModel().getRowCount(); i++) {
            if (((Number) tblDeliveries.getModel().getValueAt(i, 0)).intValue() == deliveryId) {
                int view = tblDeliveries.convertRowIndexToView(i);
                if (view >= 0) tblDeliveries.setRowSelectionInterval(view, view);
                return;
            }
        }
    }
    private void clearDeliveryDetails() {
        txtDelId.setText("Not assigned"); txtDelStatus.setText("—");
        txtDelAgentInfo.setText("—"); txtDelScheduleInfo.setText("—");
        txtDelSchedule.setText(""); txtDelReason.setText("");
    }
    private void renderDeliveryDetails(com.econest.deliveries.model.Delivery d) {
        txtDelId.setText("#" + d.getDeliveryId());
        txtDelStatus.setText(d.getStatus().name());
        txtDelAgentInfo.setText(d.getAgentNameAtAssignment());
        txtDelScheduleInfo.setText(deliveryDate(d.getScheduledFor()));
        // Suggest a future local time only for an unscheduled ASSIGNED delivery.
        // This is a UI suggestion, never an automatic database write.
        txtDelSchedule.setText(d.getScheduledFor() == null
                ? (d.getStatus() == com.econest.deliveries.model.DeliveryStatus.ASSIGNED
                    ? java.time.LocalDateTime.now().plusDays(1).withHour(9).withMinute(0)
                            .withSecond(0).withNano(0).format(DELIVERY_DATE)
                    : "")
                : deliveryDate(d.getScheduledFor()));
        txtDelReason.setText(d.getFailureReason() == null ? "" : d.getFailureReason());
        selectDeliveryChoice(cmbDelAgent, d.getAgentId() == null ? 0 : d.getAgentId());
    }
    private void refreshDeliveriesData() {
        if (deliverySorter == null) return;
        int wasSelected = selectedDeliveryId == null ? 0 : selectedDeliveryId;
        refreshDeliveryChoices();
        try {
            javax.swing.table.DefaultTableModel m =
                    (javax.swing.table.DefaultTableModel) tblDeliveries.getModel();
            m.setRowCount(0);
            for (com.econest.deliveries.model.Delivery d : deliveryService.listDeliveries()) {
                m.addRow(new Object[]{d.getDeliveryId(), d.getOrderId(), d.getAgentNameAtAssignment(),
                    d.getStatus().name(), deliveryDate(d.getScheduledFor()), deliveryDate(d.getDispatchedAt()),
                    deliveryDate(d.getDeliveredAt()), d.getFailureReason() == null ? "" : d.getFailureReason()});
            }
            javax.swing.table.DefaultTableModel queue =
                    (javax.swing.table.DefaultTableModel) tblDelOrders.getModel();
            queue.setRowCount(0);
            for (com.econest.orders.model.Order o : deliveryOrders.listOrders()) {
                if (o.getStatus() == com.econest.orders.model.OrderStatus.CONFIRMED) {
                    queue.addRow(new Object[]{o.getOrderId(), o.getClientNameAtOrder(),
                        o.getStatus().name(), o.getTotalAmount()});
                }
            }
            if (wasSelected > 0) selectDeliveryRow(wasSelected);
            if (selectedDeliveryId != null) findDeliveryForSelectedOrder();
        } catch(Exception ex) { showDeliveryError("Loading deliveries", ex); }
    }
    private void loadSelectedDelivery() {
        int view = tblDeliveries.getSelectedRow();
        if (view < 0) return;
        int row = tblDeliveries.convertRowIndexToModel(view);
        int id = ((Number) tblDeliveries.getModel().getValueAt(row, 0)).intValue();
        int oid = ((Number) tblDeliveries.getModel().getValueAt(row, 1)).intValue();
        try {
            java.util.Optional<com.econest.deliveries.model.Delivery> d = deliveryService.getDeliveryByOrder(oid);
            if (d.isPresent() && d.get().getDeliveryId() == id) {
                selectedDeliveryId = id;
                loadingDeliveryChoices = true;
                try {selectDeliveryChoice(cmbDelOrder, oid);} finally {loadingDeliveryChoices = false;}
                renderDeliveryDetails(d.get());
            }
        } catch(Exception ex) {showDeliveryError("Loading selected delivery", ex);}
    }
    private java.time.LocalDateTime parseDeliveryDate() {
        String input=txtDelSchedule.getText().trim();
        try{return java.time.LocalDateTime.parse(input,DELIVERY_DATE);}
        catch(java.time.format.DateTimeParseException ex) {
            throw new IllegalArgumentException("Enter local date/time as yyyy-MM-dd HH:mm (24-hour clock), e.g. "
                    + java.time.LocalDateTime.now().plusDays(1).withHour(9).withMinute(0)
                            .withSecond(0).withNano(0).format(DELIVERY_DATE));
        }
    }
    private void onAssignDelivery(java.awt.event.ActionEvent evt) {
        int oid=selectedOrderChoice(cmbDelOrder), aid=selectedOrderChoice(cmbDelAgent);
        if(oid<=0||aid<=0){javax.swing.JOptionPane.showMessageDialog(this,"Select a confirmed order and an agent.");return;}
        try {com.econest.deliveries.model.Delivery d=deliveryService.assignAgent(oid,aid);
            selectedDeliveryId=d.getDeliveryId();refreshDeliveriesData();
            javax.swing.JOptionPane.showMessageDialog(this,"Delivery #"+selectedDeliveryId+" assigned; pending agent-email event saved.");
        } catch(Exception ex) {showDeliveryError("Assign or reassign delivery",ex);}
    }
    private void onScheduleDelivery(java.awt.event.ActionEvent evt) {
        if (selectedDeliveryId == null) {
            javax.swing.JOptionPane.showMessageDialog(this,"Select an assigned delivery first.");
            return;
        }
        String status = txtDelStatus.getText().trim();
        if (!"ASSIGNED".equals(status) && !"SCHEDULED".equals(status)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Only ASSIGNED or SCHEDULED deliveries can be scheduled. Selected status: " + status,
                    "Schedule delivery", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try { deliveryService.scheduleDelivery(selectedDeliveryId, parseDeliveryDate()); refreshDeliveriesData(); }
        catch (Exception ex) { showDeliveryError("Schedule delivery", ex); }
    }
    private void onDispatchDelivery(java.awt.event.ActionEvent evt) {
        if(selectedDeliveryId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select a delivery first.");return;}
        if(javax.swing.JOptionPane.showConfirmDialog(this,"Dispatch delivery #"+selectedDeliveryId+"?",
                "Dispatch delivery",javax.swing.JOptionPane.YES_NO_OPTION)!=javax.swing.JOptionPane.YES_OPTION)return;
        try {deliveryService.dispatchDelivery(selectedDeliveryId);refreshDeliveriesData();
            javax.swing.JOptionPane.showMessageDialog(this,"Delivery dispatched. Client email was queued; check Email Notifications for SENT/FAILED status.");}
        catch(Exception ex) {showDeliveryError("Dispatch delivery",ex);}
    }
    private void onMarkDelivered(java.awt.event.ActionEvent evt) {
        if(selectedDeliveryId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select a delivery first.");return;}
        try {deliveryService.completeDelivery(selectedDeliveryId);refreshDeliveriesData();}
        catch(Exception ex) {showDeliveryError("Mark delivered",ex);}
    }
    private void onMarkFailed(java.awt.event.ActionEvent evt) {
        if(selectedDeliveryId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select a delivery first.");return;}
        try {deliveryService.failDelivery(selectedDeliveryId,txtDelReason.getText());refreshDeliveriesData();}
        catch(Exception ex) {showDeliveryError("Mark failed",ex);}
    }
    private void onCancelDelivery(java.awt.event.ActionEvent evt) {
        if(selectedDeliveryId==null){javax.swing.JOptionPane.showMessageDialog(this,"Select a delivery first.");return;}
        if(javax.swing.JOptionPane.showConfirmDialog(this,"Cancel this delivery assignment? The order will remain confirmed.",
                "Cancel assignment",javax.swing.JOptionPane.YES_NO_OPTION)!=javax.swing.JOptionPane.YES_OPTION)return;
        try {deliveryService.cancelDelivery(selectedDeliveryId);refreshDeliveriesData();}
        catch(Exception ex) {showDeliveryError("Cancel delivery",ex);}
    }
    private void onRefreshDeliveries(java.awt.event.ActionEvent evt){refreshDeliveriesData();}
    private void onDeliveryRowClick(java.awt.event.MouseEvent evt){loadSelectedDelivery();}
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { }
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblOrdFinalizeSection;
    private javax.swing.JLabel lblOrdItemsSection;
    private javax.swing.JLabel lblOrdStartSection;
    private javax.swing.JLabel lblDelScheduleSection;
    private javax.swing.JLabel lblDelAssignSection;
    private javax.swing.JLabel lblInvWriteOffSection;
    private javax.swing.JLabel lblInvReorderSection;
    private javax.swing.JLabel lblInvReceiveSection;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel brandPanel;
    private javax.swing.JLabel brandTitleLabel;
    private javax.swing.JLabel brandTaglineLabel;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnClients;
    private javax.swing.JButton btnDeliveryAgents;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnDeliveries;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnEmailNotifications;
    private javax.swing.JLabel sidebarFooterLabel;
    private javax.swing.JPanel workspacePanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerTitleBlock;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JLabel headerSubtitleLabel;
    private javax.swing.JLabel headerModeLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel dashboardPage;
    private javax.swing.JPanel heroPanel;
    private javax.swing.JPanel heroTextPanel;
    private javax.swing.JLabel heroEyebrowLabel;
    private javax.swing.JLabel heroHeadlineLabel;
    private javax.swing.JLabel heroDescriptionLabel;
    private javax.swing.JPanel homeBodyPanel;
    private javax.swing.JPanel metricsSectionPanel;
    private javax.swing.JPanel metricsHeadingPanel;
    private javax.swing.JLabel metricsHeadingPanelTitle;
    private javax.swing.JLabel metricsHeadingPanelCaption;
    private javax.swing.JPanel metricGridPanel;
    private javax.swing.JPanel metricProductsPanel;
    private javax.swing.JLabel metricProductsTitle;
    private javax.swing.JLabel metricProductsValue;
    private javax.swing.JLabel metricProductsCaption;
    private javax.swing.JPanel metricInventoryPanel;
    private javax.swing.JLabel metricInventoryTitle;
    private javax.swing.JLabel metricInventoryValue;
    private javax.swing.JLabel metricInventoryCaption;
    private javax.swing.JPanel metricOrdersPanel;
    private javax.swing.JLabel metricOrdersTitle;
    private javax.swing.JLabel metricOrdersValue;
    private javax.swing.JLabel metricOrdersCaption;
    private javax.swing.JPanel metricSalesPanel;
    private javax.swing.JLabel metricSalesTitle;
    private javax.swing.JLabel metricSalesValue;
    private javax.swing.JLabel metricSalesCaption;
    private javax.swing.JPanel quickSectionPanel;
    private javax.swing.JPanel quickHeadingPanel;
    private javax.swing.JLabel quickHeadingPanelTitle;
    private javax.swing.JLabel quickHeadingPanelCaption;
    private javax.swing.JPanel quickGridPanel;
    private javax.swing.JPanel quickProductsPanel;
    private javax.swing.JPanel quickProductsTextPanel;
    private javax.swing.JLabel quickProductsTitle;
    private javax.swing.JLabel quickProductsCaption;
    private javax.swing.JButton quickProductsButton;
    private javax.swing.JPanel quickInventoryPanel;
    private javax.swing.JPanel quickInventoryTextPanel;
    private javax.swing.JLabel quickInventoryTitle;
    private javax.swing.JLabel quickInventoryCaption;
    private javax.swing.JButton quickInventoryButton;
    private javax.swing.JPanel quickOrdersPanel;
    private javax.swing.JPanel quickOrdersTextPanel;
    private javax.swing.JLabel quickOrdersTitle;
    private javax.swing.JLabel quickOrdersCaption;
    private javax.swing.JButton quickOrdersButton;
    private javax.swing.JPanel quickReportsPanel;
    private javax.swing.JPanel quickReportsTextPanel;
    private javax.swing.JLabel quickReportsTitle;
    private javax.swing.JLabel quickReportsCaption;
    private javax.swing.JButton quickReportsButton;
    private javax.swing.JPanel productsPage;
    private javax.swing.JPanel productsIntroPanel;
    private javax.swing.JLabel productsEyebrow;
    private javax.swing.JLabel productsHeading;
    private javax.swing.JLabel productsDescription;
    private javax.swing.JPanel productsDetailsPanel;
    private javax.swing.JPanel productsTilesPanel;
    private javax.swing.JPanel productFormPanel;
    private javax.swing.JPanel productFormHeading;
    private javax.swing.JLabel productFormTitle;
    private javax.swing.JLabel productFormCaption;
    private javax.swing.JPanel productFieldsPanel;
    private javax.swing.JPanel productNameRow;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JPanel productCategoryRow;
    private javax.swing.JLabel lblProductCategory;
    private javax.swing.JComboBox<String> cmbProductCategory;
    private javax.swing.JPanel productDescriptionRow;
    private javax.swing.JLabel lblProductDescription;
    private javax.swing.JScrollPane productDescriptionScroll;
    private javax.swing.JTextArea txtProductDescription;
    private javax.swing.JPanel productPriceRow;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JPanel productRatingRow;
    private javax.swing.JLabel lblEcoRating;
    private javax.swing.JSpinner spnEcoRating;
    private javax.swing.JPanel productIdRow;
    private javax.swing.JLabel lblCurrentProduct;
    private javax.swing.JLabel lblSelectedProductId;
    private javax.swing.JPanel productActionsPanel;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnClearProduct;
    private javax.swing.JPanel productTablePanel;
    private javax.swing.JPanel productTableHeading;
    private javax.swing.JPanel productTableTitleArea;
    private javax.swing.JLabel productTableTitle;
    private javax.swing.JLabel productTableCaption;
    private javax.swing.JPanel productSearchPanel;
    private javax.swing.JTextField txtProductSearch;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnRefreshProducts;
    private javax.swing.JScrollPane productTableScroll;
    private javax.swing.JTable tblProducts;
    private javax.swing.JLabel productTableHint;
    private javax.swing.JLabel productsModuleStatus;
    private javax.swing.JPanel inventoryPage;
    private javax.swing.JPanel inventoryIntroPanel;
    private javax.swing.JLabel inventoryEyebrow;
    private javax.swing.JLabel inventoryHeading;
    private javax.swing.JLabel inventoryDescription;
    private javax.swing.JPanel inventoryDetailsPanel;
    private javax.swing.JPanel inventoryTilesPanel;
    private javax.swing.JPanel invControlsPanel;
    private javax.swing.JLabel invControlsHeading;
    private javax.swing.JScrollPane invControlsScroll;
    private javax.swing.JPanel invInputsPanel;
    private javax.swing.JPanel invProductRow;
    private javax.swing.JLabel lblInvProductRow;
    private javax.swing.JComboBox cmbInvProduct;
    private javax.swing.JPanel invSupplierRow;
    private javax.swing.JLabel lblInvSupplierRow;
    private javax.swing.JComboBox cmbInvSupplier;
    private javax.swing.JPanel invReceiveQtyRow;
    private javax.swing.JLabel lblInvReceiveQtyRow;
    private javax.swing.JSpinner spnInvReceiveQty;
    private javax.swing.JButton btnReceiveStock;
    private javax.swing.JPanel invReorderRow;
    private javax.swing.JLabel lblInvReorderRow;
    private javax.swing.JSpinner spnInvReorder;
    private javax.swing.JButton btnSetReorder;
    private javax.swing.JPanel invWriteOffQtyRow;
    private javax.swing.JLabel lblInvWriteOffQtyRow;
    private javax.swing.JSpinner spnInvWriteOffQty;
    private javax.swing.JPanel invReasonRow;
    private javax.swing.JLabel lblInvReasonRow;
    private javax.swing.JTextField txtInvWriteOffReason;
    private javax.swing.JButton btnWriteOff;
    private javax.swing.JLabel lblRegisterSupplier;
    private javax.swing.JPanel invSupplierNameRow;
    private javax.swing.JLabel lblInvSupplierNameRow;
    private javax.swing.JTextField txtInvSupplierName;
    private javax.swing.JPanel invSupplierPhoneRow;
    private javax.swing.JLabel lblInvSupplierPhoneRow;
    private javax.swing.JTextField txtInvSupplierPhone;
    private javax.swing.JPanel invSupplierEmailRow;
    private javax.swing.JLabel lblInvSupplierEmailRow;
    private javax.swing.JTextField txtInvSupplierEmail;
    private javax.swing.JButton btnRegisterSupplier;
    private javax.swing.JPanel invDataPanel;
    private javax.swing.JPanel invStockToolbar;
    private javax.swing.JLabel lblInventoryTable;
    private javax.swing.JButton btnShowAllStock;
    private javax.swing.JButton btnLowStock;
    private javax.swing.JButton btnReloadInventory;
    private javax.swing.JScrollPane invStockScroll;
    private javax.swing.JTable tblInventory;
    private javax.swing.JPanel invHistoryPanel;
    private javax.swing.JLabel lblStockHistory;
    private javax.swing.JScrollPane invHistoryScroll;
    private javax.swing.JTable tblInvMovements;
    private javax.swing.JLabel inventoryModuleStatus;
    private javax.swing.JPanel clientsPage;
    private javax.swing.JPanel clientsIntroPanel;
    private javax.swing.JLabel clientsEyebrow;
    private javax.swing.JLabel clientsHeading;
    private javax.swing.JLabel clientsDescription;
    private javax.swing.JPanel clientsDetailsPanel;
    private javax.swing.JPanel clientsTilesPanel;
    private javax.swing.JPanel clientFormPanel;
    private javax.swing.JPanel clientFormHeading;
    private javax.swing.JLabel clientFormTitle;
    private javax.swing.JLabel clientFormCaption;
    private javax.swing.JPanel clientFieldsPanel;
    private javax.swing.JPanel clientNameRow;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JPanel clientTypeRow;
    private javax.swing.JLabel lblClientType;
    private javax.swing.JComboBox<String> cmbClientType;
    private javax.swing.JPanel clientAddressRow;
    private javax.swing.JLabel lblClientAddress;
    private javax.swing.JScrollPane clientAddressScroll;
    private javax.swing.JTextArea txtClientAddress;
    private javax.swing.JPanel clientEmailRow;
    private javax.swing.JLabel lblClientEmail;
    private javax.swing.JTextField txtClientEmail;
    private javax.swing.JPanel clientPhoneRow;
    private javax.swing.JLabel lblClientPhone;
    private javax.swing.JTextField txtClientPhone;
    private javax.swing.JPanel clientIdRow;
    private javax.swing.JLabel lblCurrentClient;
    private javax.swing.JLabel lblSelectedClientId;
    private javax.swing.JPanel clientActionsPanel;
    private javax.swing.JButton btnAddClient;
    private javax.swing.JButton btnUpdateClient;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnClearClient;
    private javax.swing.JPanel clientTablePanel;
    private javax.swing.JPanel clientTableHeading;
    private javax.swing.JPanel clientTableTitleArea;
    private javax.swing.JLabel clientTableTitle;
    private javax.swing.JLabel clientTableCaption;
    private javax.swing.JPanel clientSearchPanel;
    private javax.swing.JTextField txtClientSearch;
    private javax.swing.JButton btnSearchClient;
    private javax.swing.JButton btnRefreshClients;
    private javax.swing.JScrollPane clientTableScroll;
    private javax.swing.JTable tblClients;
    private javax.swing.JLabel clientTableHint;
    private javax.swing.JLabel clientsModuleStatus;
    private javax.swing.JPanel agentsPage;
    private javax.swing.JPanel agentsIntroPanel;
    private javax.swing.JLabel agentsEyebrow;
    private javax.swing.JLabel agentsHeading;
    private javax.swing.JLabel agentsDescription;
    private javax.swing.JPanel agentsDetailsPanel;
    private javax.swing.JPanel agentsTilesPanel;
    private javax.swing.JPanel agentFormPanel;
    private javax.swing.JPanel agentFormHeading;
    private javax.swing.JLabel agentFormTitle;
    private javax.swing.JLabel agentFormCaption;
    private javax.swing.JPanel agentFieldsPanel;
    private javax.swing.JPanel agentNameRow;
    private javax.swing.JLabel lblAgentName;
    private javax.swing.JTextField txtAgentName;
    private javax.swing.JPanel agentVehicleTypeRow;
    private javax.swing.JLabel lblAgentVehicleType;
    private javax.swing.JComboBox<String> cmbAgentVehicleType;
    private javax.swing.JPanel agentVehicleNumberRow;
    private javax.swing.JLabel lblAgentVehicleNumber;
    private javax.swing.JScrollPane agentVehicleNumberScroll;
    private javax.swing.JTextArea txtAgentVehicleNumber;
    private javax.swing.JPanel agentEmailRow;
    private javax.swing.JLabel lblAgentEmail;
    private javax.swing.JTextField txtAgentEmail;
    private javax.swing.JPanel agentPhoneRow;
    private javax.swing.JLabel lblAgentPhone;
    private javax.swing.JTextField txtAgentPhone;
    private javax.swing.JPanel agentIdRow;
    private javax.swing.JLabel lblCurrentAgent;
    private javax.swing.JLabel lblSelectedAgentId;
    private javax.swing.JPanel agentActionsPanel;
    private javax.swing.JButton btnAddAgent;
    private javax.swing.JButton btnUpdateAgent;
    private javax.swing.JButton btnDeleteAgent;
    private javax.swing.JButton btnClearAgent;
    private javax.swing.JPanel agentTablePanel;
    private javax.swing.JPanel agentTableHeading;
    private javax.swing.JPanel agentTableTitleArea;
    private javax.swing.JLabel agentTableTitle;
    private javax.swing.JLabel agentTableCaption;
    private javax.swing.JPanel agentSearchPanel;
    private javax.swing.JTextField txtAgentSearch;
    private javax.swing.JButton btnSearchAgent;
    private javax.swing.JButton btnRefreshAgents;
    private javax.swing.JScrollPane agentTableScroll;
    private javax.swing.JTable tblAgents;
    private javax.swing.JLabel agentTableHint;
    private javax.swing.JLabel agentsModuleStatus;
    private javax.swing.JPanel ordersPage;
    private javax.swing.JPanel ordersIntroPanel;
    private javax.swing.JLabel ordersEyebrow;
    private javax.swing.JLabel ordersHeading;
    private javax.swing.JLabel ordersDescription;
    private javax.swing.JPanel ordersDetailsPanel;
    private javax.swing.JPanel ordersTilesPanel;
    private javax.swing.JPanel ordControlsPanel;
    private javax.swing.JLabel ordControlsHeading;
    private javax.swing.JScrollPane ordControlsScroll;
    private javax.swing.JPanel ordInputsPanel;
    private javax.swing.JPanel ordClientRow;
    private javax.swing.JLabel lblOrdClient;
    private javax.swing.JComboBox cmbOrdClient;
    private javax.swing.JPanel ordProductRow;
    private javax.swing.JLabel lblOrdProduct;
    private javax.swing.JComboBox cmbOrdProduct;
    private javax.swing.JPanel ordQtyRow;
    private javax.swing.JLabel lblOrdQty;
    private javax.swing.JSpinner spnOrdQty;
    private javax.swing.JButton btnAddOrderItem;
    private javax.swing.JPanel ordLineCountRow;
    private javax.swing.JLabel lblOrdLineCount;
    private javax.swing.JSpinner spnOrdLineCount;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JPanel ordStockRow;
    private javax.swing.JLabel lblOrdStock;
    private javax.swing.JSpinner spnOrdStock;
    private javax.swing.JPanel ordTotalRow;
    private javax.swing.JLabel lblOrdTotal;
    private javax.swing.JTextField txtOrdTotal;
    private javax.swing.JButton btnConfirmOrder;
    private javax.swing.JLabel lblOrdDetailsHeading;
    private javax.swing.JPanel ordSearchRow;
    private javax.swing.JLabel lblOrdSearch;
    private javax.swing.JTextField txtOrdSearch;
    private javax.swing.JPanel ordOrderIdRow;
    private javax.swing.JLabel lblOrdSelectedOrder;
    private javax.swing.JTextField txtOrdSelectedOrder;
    private javax.swing.JPanel ordOrderStatusRow;
    private javax.swing.JLabel lblOrdStatus;
    private javax.swing.JTextField txtOrdStatus;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JPanel ordDataPanel;
    private javax.swing.JPanel ordOrdersToolbar;
    private javax.swing.JLabel lblOrdersTable;
    private javax.swing.JButton btnCreateOrder;
    private javax.swing.JButton btnCalculateOrderTotal;
    private javax.swing.JButton btnRefreshOrders;
    private javax.swing.JScrollPane ordOrdersScroll;
    private javax.swing.JTable tblOrders;
    private javax.swing.JPanel ordItemsPanel;
    private javax.swing.JLabel lblOrderItems;
    private javax.swing.JScrollPane ordItemsScroll;
    private javax.swing.JTable tblOrderItems;
    private javax.swing.JLabel ordersModuleStatus;
    private javax.swing.JPanel deliveriesPage;
    private javax.swing.JPanel deliveriesIntroPanel;
    private javax.swing.JLabel deliveriesEyebrow;
    private javax.swing.JLabel deliveriesHeading;
    private javax.swing.JLabel deliveriesDescription;
    private javax.swing.JPanel deliveriesDetailsPanel;
    private javax.swing.JPanel deliveriesTilesPanel;
    private javax.swing.JPanel delControlsPanel;
    private javax.swing.JLabel delControlsHeading;
    private javax.swing.JScrollPane delControlsScroll;
    private javax.swing.JPanel delInputsPanel;
    private javax.swing.JPanel delOrderRow;
    private javax.swing.JLabel lblDelOrder;
    private javax.swing.JComboBox cmbDelOrder;
    private javax.swing.JPanel delAgentRow;
    private javax.swing.JLabel lblDelAgent;
    private javax.swing.JComboBox cmbDelAgent;
    private javax.swing.JPanel delScheduleRow;
    private javax.swing.JLabel lblDelSchedule;
    private javax.swing.JTextField txtDelSchedule;
    private javax.swing.JButton btnDelAssign;
    private javax.swing.JPanel delIdRow;
    private javax.swing.JLabel lblDelId;
    private javax.swing.JTextField txtDelId;
    private javax.swing.JButton btnDelSchedule;
    private javax.swing.JPanel delStatusRow;
    private javax.swing.JLabel lblDelStatus;
    private javax.swing.JTextField txtDelStatus;
    private javax.swing.JPanel delReasonRow;
    private javax.swing.JLabel lblDelReason;
    private javax.swing.JTextField txtDelReason;
    private javax.swing.JButton btnDelDispatch;
    private javax.swing.JLabel lblDelActionsHeading;
    private javax.swing.JPanel delSearchRow;
    private javax.swing.JLabel lblDelSearch;
    private javax.swing.JTextField txtDelSearch;
    private javax.swing.JPanel delAgentInfoRow;
    private javax.swing.JLabel lblDelAgentInfo;
    private javax.swing.JTextField txtDelAgentInfo;
    private javax.swing.JPanel delScheduleInfoRow;
    private javax.swing.JLabel lblDelScheduleInfo;
    private javax.swing.JTextField txtDelScheduleInfo;
    private javax.swing.JButton btnDelCancel;
    private javax.swing.JPanel delDataPanel;
    private javax.swing.JPanel delDeliveriesToolbar;
    private javax.swing.JLabel lblDeliveriesTable;
    private javax.swing.JButton btnDelDelivered;
    private javax.swing.JButton btnDelFailed;
    private javax.swing.JButton btnDelRefresh;
    private javax.swing.JScrollPane delDeliveriesScroll;
    private javax.swing.JTable tblDeliveries;
    private javax.swing.JPanel delOrdersPanel;
    private javax.swing.JLabel lblDelOrders;
    private javax.swing.JScrollPane delOrdersScroll;
    private javax.swing.JTable tblDelOrders;
    private javax.swing.JLabel deliveriesModuleStatus;
    private javax.swing.JPanel reportsPage;
    private javax.swing.JPanel reportsIntroPanel;
    private javax.swing.JLabel reportsEyebrow;
    private javax.swing.JLabel reportsHeading;
    private javax.swing.JLabel reportsDescription;
    private javax.swing.JPanel reportsDetailsPanel;
    private javax.swing.JPanel reportsTilesPanel;
    private javax.swing.JPanel reportToolbarPanel;
    private javax.swing.JPanel reportPickerPanel;
    private javax.swing.JLabel lblReportMonth;
    private javax.swing.JComboBox<String> cmbReportMonth;
    private javax.swing.JLabel lblReportYear;
    private javax.swing.JTextField txtReportYear;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JPanel reportBodyPanel;
    private javax.swing.JPanel reportMetricsPanel;
    private javax.swing.JPanel reportCardGross;
    private javax.swing.JLabel reportCardTitleGross;
    private javax.swing.JLabel lblReportGross;
    private javax.swing.JPanel reportCardCancelled;
    private javax.swing.JLabel reportCardTitleCancelled;
    private javax.swing.JLabel lblReportCancelled;
    private javax.swing.JPanel reportCardNet;
    private javax.swing.JLabel reportCardTitleNet;
    private javax.swing.JLabel lblReportNet;
    private javax.swing.JPanel reportCardOrderCount;
    private javax.swing.JLabel reportCardTitleOrderCount;
    private javax.swing.JLabel lblReportOrderCount;
    private javax.swing.JPanel reportCardEndUnits;
    private javax.swing.JLabel reportCardTitleEndUnits;
    private javax.swing.JLabel lblReportEndUnits;
    private javax.swing.JPanel reportCardStockIn;
    private javax.swing.JLabel reportCardTitleStockIn;
    private javax.swing.JLabel lblReportStockIn;
    private javax.swing.JPanel reportCardStockOut;
    private javax.swing.JLabel reportCardTitleStockOut;
    private javax.swing.JLabel lblReportStockOut;
    private javax.swing.JPanel reportCardLowCount;
    private javax.swing.JLabel reportCardTitleLowCount;
    private javax.swing.JLabel lblReportLowCount;
    private javax.swing.JScrollPane reportTablesOuterScroll;
    private javax.swing.JPanel reportTablesPanel;
    private javax.swing.JPanel reportFlowPanel;
    private javax.swing.JLabel lblReportFlowHeading;
    private javax.swing.JScrollPane reportFlowScroll;
    private javax.swing.JTable tblReportMonthlyStock;
    private javax.swing.JPanel reportLowPanel;
    private javax.swing.JLabel lblReportLowHeading;
    private javax.swing.JScrollPane reportLowScroll;
    private javax.swing.JTable tblReportLowStock;
    private javax.swing.JLabel lblReportNotice;
    private javax.swing.JLabel reportsModuleStatus;
    private javax.swing.JPanel emailsPage;
    private javax.swing.JPanel emailsIntroPanel;
    private javax.swing.JLabel emailsEyebrow;
    private javax.swing.JLabel emailsHeading;
    private javax.swing.JLabel emailsDescription;
    private javax.swing.JPanel emailsDetailsPanel;
    private javax.swing.JPanel emailsTilesPanel;
    private javax.swing.JPanel emailToolbarPanel;
    private javax.swing.JPanel emailToolbarTitlePanel;
    private javax.swing.JLabel lblEmailHeading;
    private javax.swing.JLabel lblEmailSubtitle;
    private javax.swing.JPanel emailButtonsPanel;
    private javax.swing.JComboBox<String> cmbEmailFilter;
    private javax.swing.JButton btnEmailRefresh;
    private javax.swing.JButton btnEmailRetry;
    private javax.swing.JButton btnEmailRetryAgent;
    private javax.swing.JPanel emailTablePanel;
    private javax.swing.JLabel lblEmailHistoryHeading;
    private javax.swing.JScrollPane emailTableScroll;
    private javax.swing.JTable tblEmailNotifications;
    private javax.swing.JPanel emailInfoPanel;
    private javax.swing.JLabel lblEmailConfig;
    private javax.swing.JLabel lblEmailStats;
    private javax.swing.JLabel lblEmailNotice;
    private javax.swing.JLabel emailsModuleStatus;
    // End of variables declaration//GEN-END:variables
}
