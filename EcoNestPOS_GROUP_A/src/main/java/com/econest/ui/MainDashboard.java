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
        showPage("dashboard");
        setMinimumSize(new Dimension(1020, 680));
        setSize(1220, 780);
        setLocationRelativeTo(null);
        prepareProductTable();
        prepareInventoryTables();
    }

    /** Show a panel that ALREADY EXISTS in the GUI Builder CardLayout. */
    public final void showPage(String pageKey) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, pageKey);
        if ("products".equals(pageKey)) refreshProductTable();
        if ("inventory".equals(pageKey)) refreshInventoryData();
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
        statusLabel.setText("EcoNest POS  |  " + headerTitleLabel.getText() + "  |  Local workspace");
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
        clientsTile1Panel = new javax.swing.JPanel();
        clientsTile1TextPanel = new javax.swing.JPanel();
        clientsTile1Title = new javax.swing.JLabel();
        clientsTile1Subtitle = new javax.swing.JLabel();
        clientsTile1Status = new javax.swing.JLabel();
        clientsTile2Panel = new javax.swing.JPanel();
        clientsTile2TextPanel = new javax.swing.JPanel();
        clientsTile2Title = new javax.swing.JLabel();
        clientsTile2Subtitle = new javax.swing.JLabel();
        clientsTile2Status = new javax.swing.JLabel();
        clientsTile3Panel = new javax.swing.JPanel();
        clientsTile3TextPanel = new javax.swing.JPanel();
        clientsTile3Title = new javax.swing.JLabel();
        clientsTile3Subtitle = new javax.swing.JLabel();
        clientsTile3Status = new javax.swing.JLabel();
        clientsTile4Panel = new javax.swing.JPanel();
        clientsTile4TextPanel = new javax.swing.JPanel();
        clientsTile4Title = new javax.swing.JLabel();
        clientsTile4Subtitle = new javax.swing.JLabel();
        clientsTile4Status = new javax.swing.JLabel();
        clientsModuleStatus = new javax.swing.JLabel();
        agentsPage = new javax.swing.JPanel();
        agentsIntroPanel = new javax.swing.JPanel();
        agentsEyebrow = new javax.swing.JLabel();
        agentsHeading = new javax.swing.JLabel();
        agentsDescription = new javax.swing.JLabel();
        agentsDetailsPanel = new javax.swing.JPanel();
        agentsTilesPanel = new javax.swing.JPanel();
        agentsTile1Panel = new javax.swing.JPanel();
        agentsTile1TextPanel = new javax.swing.JPanel();
        agentsTile1Title = new javax.swing.JLabel();
        agentsTile1Subtitle = new javax.swing.JLabel();
        agentsTile1Status = new javax.swing.JLabel();
        agentsTile2Panel = new javax.swing.JPanel();
        agentsTile2TextPanel = new javax.swing.JPanel();
        agentsTile2Title = new javax.swing.JLabel();
        agentsTile2Subtitle = new javax.swing.JLabel();
        agentsTile2Status = new javax.swing.JLabel();
        agentsTile3Panel = new javax.swing.JPanel();
        agentsTile3TextPanel = new javax.swing.JPanel();
        agentsTile3Title = new javax.swing.JLabel();
        agentsTile3Subtitle = new javax.swing.JLabel();
        agentsTile3Status = new javax.swing.JLabel();
        agentsTile4Panel = new javax.swing.JPanel();
        agentsTile4TextPanel = new javax.swing.JPanel();
        agentsTile4Title = new javax.swing.JLabel();
        agentsTile4Subtitle = new javax.swing.JLabel();
        agentsTile4Status = new javax.swing.JLabel();
        agentsModuleStatus = new javax.swing.JLabel();
        ordersPage = new javax.swing.JPanel();
        ordersIntroPanel = new javax.swing.JPanel();
        ordersEyebrow = new javax.swing.JLabel();
        ordersHeading = new javax.swing.JLabel();
        ordersDescription = new javax.swing.JLabel();
        ordersDetailsPanel = new javax.swing.JPanel();
        ordersTilesPanel = new javax.swing.JPanel();
        ordersTile1Panel = new javax.swing.JPanel();
        ordersTile1TextPanel = new javax.swing.JPanel();
        ordersTile1Title = new javax.swing.JLabel();
        ordersTile1Subtitle = new javax.swing.JLabel();
        ordersTile1Status = new javax.swing.JLabel();
        ordersTile2Panel = new javax.swing.JPanel();
        ordersTile2TextPanel = new javax.swing.JPanel();
        ordersTile2Title = new javax.swing.JLabel();
        ordersTile2Subtitle = new javax.swing.JLabel();
        ordersTile2Status = new javax.swing.JLabel();
        ordersTile3Panel = new javax.swing.JPanel();
        ordersTile3TextPanel = new javax.swing.JPanel();
        ordersTile3Title = new javax.swing.JLabel();
        ordersTile3Subtitle = new javax.swing.JLabel();
        ordersTile3Status = new javax.swing.JLabel();
        ordersTile4Panel = new javax.swing.JPanel();
        ordersTile4TextPanel = new javax.swing.JPanel();
        ordersTile4Title = new javax.swing.JLabel();
        ordersTile4Subtitle = new javax.swing.JLabel();
        ordersTile4Status = new javax.swing.JLabel();
        ordersModuleStatus = new javax.swing.JLabel();
        deliveriesPage = new javax.swing.JPanel();
        deliveriesIntroPanel = new javax.swing.JPanel();
        deliveriesEyebrow = new javax.swing.JLabel();
        deliveriesHeading = new javax.swing.JLabel();
        deliveriesDescription = new javax.swing.JLabel();
        deliveriesDetailsPanel = new javax.swing.JPanel();
        deliveriesTilesPanel = new javax.swing.JPanel();
        deliveriesTile1Panel = new javax.swing.JPanel();
        deliveriesTile1TextPanel = new javax.swing.JPanel();
        deliveriesTile1Title = new javax.swing.JLabel();
        deliveriesTile1Subtitle = new javax.swing.JLabel();
        deliveriesTile1Status = new javax.swing.JLabel();
        deliveriesTile2Panel = new javax.swing.JPanel();
        deliveriesTile2TextPanel = new javax.swing.JPanel();
        deliveriesTile2Title = new javax.swing.JLabel();
        deliveriesTile2Subtitle = new javax.swing.JLabel();
        deliveriesTile2Status = new javax.swing.JLabel();
        deliveriesTile3Panel = new javax.swing.JPanel();
        deliveriesTile3TextPanel = new javax.swing.JPanel();
        deliveriesTile3Title = new javax.swing.JLabel();
        deliveriesTile3Subtitle = new javax.swing.JLabel();
        deliveriesTile3Status = new javax.swing.JLabel();
        deliveriesTile4Panel = new javax.swing.JPanel();
        deliveriesTile4TextPanel = new javax.swing.JPanel();
        deliveriesTile4Title = new javax.swing.JLabel();
        deliveriesTile4Subtitle = new javax.swing.JLabel();
        deliveriesTile4Status = new javax.swing.JLabel();
        deliveriesModuleStatus = new javax.swing.JLabel();
        reportsPage = new javax.swing.JPanel();
        reportsIntroPanel = new javax.swing.JPanel();
        reportsEyebrow = new javax.swing.JLabel();
        reportsHeading = new javax.swing.JLabel();
        reportsDescription = new javax.swing.JLabel();
        reportsDetailsPanel = new javax.swing.JPanel();
        reportsTilesPanel = new javax.swing.JPanel();
        reportsTile1Panel = new javax.swing.JPanel();
        reportsTile1TextPanel = new javax.swing.JPanel();
        reportsTile1Title = new javax.swing.JLabel();
        reportsTile1Subtitle = new javax.swing.JLabel();
        reportsTile1Status = new javax.swing.JLabel();
        reportsTile2Panel = new javax.swing.JPanel();
        reportsTile2TextPanel = new javax.swing.JPanel();
        reportsTile2Title = new javax.swing.JLabel();
        reportsTile2Subtitle = new javax.swing.JLabel();
        reportsTile2Status = new javax.swing.JLabel();
        reportsTile3Panel = new javax.swing.JPanel();
        reportsTile3TextPanel = new javax.swing.JPanel();
        reportsTile3Title = new javax.swing.JLabel();
        reportsTile3Subtitle = new javax.swing.JLabel();
        reportsTile3Status = new javax.swing.JLabel();
        reportsTile4Panel = new javax.swing.JPanel();
        reportsTile4TextPanel = new javax.swing.JPanel();
        reportsTile4Title = new javax.swing.JLabel();
        reportsTile4Subtitle = new javax.swing.JLabel();
        reportsTile4Status = new javax.swing.JLabel();
        reportsModuleStatus = new javax.swing.JLabel();
        emailsPage = new javax.swing.JPanel();
        emailsIntroPanel = new javax.swing.JPanel();
        emailsEyebrow = new javax.swing.JLabel();
        emailsHeading = new javax.swing.JLabel();
        emailsDescription = new javax.swing.JLabel();
        emailsDetailsPanel = new javax.swing.JPanel();
        emailsTilesPanel = new javax.swing.JPanel();
        emailsTile1Panel = new javax.swing.JPanel();
        emailsTile1TextPanel = new javax.swing.JPanel();
        emailsTile1Title = new javax.swing.JLabel();
        emailsTile1Subtitle = new javax.swing.JLabel();
        emailsTile1Status = new javax.swing.JLabel();
        emailsTile2Panel = new javax.swing.JPanel();
        emailsTile2TextPanel = new javax.swing.JPanel();
        emailsTile2Title = new javax.swing.JLabel();
        emailsTile2Subtitle = new javax.swing.JLabel();
        emailsTile2Status = new javax.swing.JLabel();
        emailsTile3Panel = new javax.swing.JPanel();
        emailsTile3TextPanel = new javax.swing.JPanel();
        emailsTile3Title = new javax.swing.JLabel();
        emailsTile3Subtitle = new javax.swing.JLabel();
        emailsTile3Status = new javax.swing.JLabel();
        emailsTile4Panel = new javax.swing.JPanel();
        emailsTile4TextPanel = new javax.swing.JPanel();
        emailsTile4Title = new javax.swing.JLabel();
        emailsTile4Subtitle = new javax.swing.JLabel();
        emailsTile4Status = new javax.swing.JLabel();
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

        brandTitleLabel.setText("EcoNest  •");
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

        sidebarFooterLabel.setText("GROUP A  |  OOP PROJECT");
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

        headerModeLabel.setText("LOCAL WORKSPACE");
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

        metricsHeadingPanelCaption.setText("Values update when the module database services are connected.");
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

        productsModuleStatus.setText("Heshan | Products & Inventory  •  Catalogue ready");
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

        inventoryDescription.setText("Track quantity on hand, reorder levels, suppliers and stock movement history.");
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
        invControlsHeading.setText("Stock, suppliers and write-offs");
        invControlsHeading.setFont(new java.awt.Font("Segoe UI", 1, 15));
        invControlsHeading.setPreferredSize(new java.awt.Dimension(330, 38));
        invControlsPanel.add(invControlsHeading, java.awt.BorderLayout.NORTH);

        invInputsPanel.setBackground(new java.awt.Color(255, 255, 255));
        invInputsPanel.setLayout(new java.awt.GridLayout(14, 1, 0, 4));
        invProductRow.setBackground(new java.awt.Color(255, 255, 255));
        invProductRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invProductRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvProductRow.setText("Product");
        lblInvProductRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invProductRow.add(lblInvProductRow, java.awt.BorderLayout.WEST);

        invProductRow.add(cmbInvProduct, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invProductRow);
        invSupplierRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierRow.setText("Supplier");
        lblInvSupplierRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierRow.add(lblInvSupplierRow, java.awt.BorderLayout.WEST);

        invSupplierRow.add(cmbInvSupplier, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invSupplierRow);
        invReceiveQtyRow.setBackground(new java.awt.Color(255, 255, 255));
        invReceiveQtyRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReceiveQtyRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReceiveQtyRow.setText("Receive qty");
        lblInvReceiveQtyRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReceiveQtyRow.add(lblInvReceiveQtyRow, java.awt.BorderLayout.WEST);

        invReceiveQtyRow.add(spnInvReceiveQty, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invReceiveQtyRow);
        btnReceiveStock.setText("RECEIVE STOCK");
        btnReceiveStock.addActionListener(evt -> onReceiveStock(evt));
        invInputsPanel.add(btnReceiveStock);
        invReorderRow.setBackground(new java.awt.Color(255, 255, 255));
        invReorderRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReorderRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReorderRow.setText("Reorder level");
        lblInvReorderRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReorderRow.add(lblInvReorderRow, java.awt.BorderLayout.WEST);

        invReorderRow.add(spnInvReorder, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invReorderRow);
        btnSetReorder.setText("SAVE REORDER LEVEL");
        btnSetReorder.addActionListener(evt -> onSetReorder(evt));
        invInputsPanel.add(btnSetReorder);
        invWriteOffQtyRow.setBackground(new java.awt.Color(255, 255, 255));
        invWriteOffQtyRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invWriteOffQtyRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvWriteOffQtyRow.setText("Write-off qty");
        lblInvWriteOffQtyRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invWriteOffQtyRow.add(lblInvWriteOffQtyRow, java.awt.BorderLayout.WEST);

        invWriteOffQtyRow.add(spnInvWriteOffQty, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invWriteOffQtyRow);
        invReasonRow.setBackground(new java.awt.Color(255, 255, 255));
        invReasonRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invReasonRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvReasonRow.setText("Reason");
        lblInvReasonRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invReasonRow.add(lblInvReasonRow, java.awt.BorderLayout.WEST);

        invReasonRow.add(txtInvWriteOffReason, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invReasonRow);
        btnWriteOff.setText("RECORD WRITE-OFF");
        btnWriteOff.addActionListener(evt -> onWriteOffStock(evt));
        invInputsPanel.add(btnWriteOff);
        lblRegisterSupplier.setText("REGISTER SUPPLIER");
        lblRegisterSupplier.setFont(new java.awt.Font("Segoe UI", 1, 13));
        invInputsPanel.add(lblRegisterSupplier);
        invSupplierNameRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierNameRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierNameRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierNameRow.setText("Name");
        lblInvSupplierNameRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierNameRow.add(lblInvSupplierNameRow, java.awt.BorderLayout.WEST);

        invSupplierNameRow.add(txtInvSupplierName, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invSupplierNameRow);
        invSupplierPhoneRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierPhoneRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierPhoneRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierPhoneRow.setText("Phone");
        lblInvSupplierPhoneRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierPhoneRow.add(lblInvSupplierPhoneRow, java.awt.BorderLayout.WEST);

        invSupplierPhoneRow.add(txtInvSupplierPhone, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invSupplierPhoneRow);
        invSupplierEmailRow.setBackground(new java.awt.Color(255, 255, 255));
        invSupplierEmailRow.setPreferredSize(new java.awt.Dimension(270, 34));
        invSupplierEmailRow.setLayout(new java.awt.BorderLayout(5, 0));
        lblInvSupplierEmailRow.setText("Email");
        lblInvSupplierEmailRow.setPreferredSize(new java.awt.Dimension(105, 28));
        invSupplierEmailRow.add(lblInvSupplierEmailRow, java.awt.BorderLayout.WEST);

        invSupplierEmailRow.add(txtInvSupplierEmail, java.awt.BorderLayout.CENTER);
        invInputsPanel.add(invSupplierEmailRow);
        btnRegisterSupplier.setText("ADD SUPPLIER");
        btnRegisterSupplier.addActionListener(evt -> onRegisterSupplier(evt));
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
        lblStockHistory.setText("STOCK MOVEMENT HISTORY (latest 500)");
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

        inventoryModuleStatus.setText("Heshan | Inventory, suppliers and stock journal ready");
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
        clientsTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        clientsTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        clientsTile1Panel.setLayout(new java.awt.BorderLayout());

        clientsTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        clientsTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        clientsTile1Title.setText("Client directory");
        clientsTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        clientsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        clientsTile1TextPanel.add(clientsTile1Title);

        clientsTile1Subtitle.setText("Search and view customer records");
        clientsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        clientsTile1TextPanel.add(clientsTile1Subtitle);


        clientsTile1Panel.add(clientsTile1TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile1Status.setText("Module interface will be integrated here.");
        clientsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientsTile1Panel.add(clientsTile1Status, java.awt.BorderLayout.SOUTH);


        clientsTilesPanel.add(clientsTile1Panel);

        clientsTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        clientsTile2Panel.setLayout(new java.awt.BorderLayout());

        clientsTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        clientsTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        clientsTile2Title.setText("Contact details");
        clientsTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        clientsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        clientsTile2TextPanel.add(clientsTile2Title);

        clientsTile2Subtitle.setText("Update email, phone and address");
        clientsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        clientsTile2TextPanel.add(clientsTile2Subtitle);


        clientsTile2Panel.add(clientsTile2TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile2Status.setText("Module interface will be integrated here.");
        clientsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientsTile2Panel.add(clientsTile2Status, java.awt.BorderLayout.SOUTH);


        clientsTilesPanel.add(clientsTile2Panel);

        clientsTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        clientsTile3Panel.setLayout(new java.awt.BorderLayout());

        clientsTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        clientsTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        clientsTile3Title.setText("Customer types");
        clientsTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        clientsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        clientsTile3TextPanel.add(clientsTile3Title);

        clientsTile3Subtitle.setText("Household and office clients");
        clientsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        clientsTile3TextPanel.add(clientsTile3Subtitle);


        clientsTile3Panel.add(clientsTile3TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile3Status.setText("Module interface will be integrated here.");
        clientsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientsTile3Panel.add(clientsTile3Status, java.awt.BorderLayout.SOUTH);


        clientsTilesPanel.add(clientsTile3Panel);

        clientsTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        clientsTile4Panel.setLayout(new java.awt.BorderLayout());

        clientsTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        clientsTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        clientsTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        clientsTile4Title.setText("Order history");
        clientsTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        clientsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        clientsTile4TextPanel.add(clientsTile4Title);

        clientsTile4Subtitle.setText("Keep client snapshots on past orders");
        clientsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        clientsTile4TextPanel.add(clientsTile4Subtitle);


        clientsTile4Panel.add(clientsTile4TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile4Status.setText("Module interface will be integrated here.");
        clientsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        clientsTile4Panel.add(clientsTile4Status, java.awt.BorderLayout.SOUTH);


        clientsTilesPanel.add(clientsTile4Panel);


        clientsDetailsPanel.add(clientsTilesPanel, java.awt.BorderLayout.CENTER);

        clientsModuleStatus.setText("Assigned developer: Piyathissa   |   Placeholder screen - no database changes");
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
        agentsTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        agentsTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        agentsTile1Panel.setLayout(new java.awt.BorderLayout());

        agentsTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        agentsTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        agentsTile1Title.setText("Agent directory");
        agentsTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        agentsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        agentsTile1TextPanel.add(agentsTile1Title);

        agentsTile1Subtitle.setText("Add, update and remove agents");
        agentsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        agentsTile1TextPanel.add(agentsTile1Subtitle);


        agentsTile1Panel.add(agentsTile1TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile1Status.setText("Module interface will be integrated here.");
        agentsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentsTile1Panel.add(agentsTile1Status, java.awt.BorderLayout.SOUTH);


        agentsTilesPanel.add(agentsTile1Panel);

        agentsTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        agentsTile2Panel.setLayout(new java.awt.BorderLayout());

        agentsTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        agentsTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        agentsTile2Title.setText("Vehicle information");
        agentsTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        agentsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        agentsTile2TextPanel.add(agentsTile2Title);

        agentsTile2Subtitle.setText("Vehicle type and registration number");
        agentsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        agentsTile2TextPanel.add(agentsTile2Subtitle);


        agentsTile2Panel.add(agentsTile2TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile2Status.setText("Module interface will be integrated here.");
        agentsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentsTile2Panel.add(agentsTile2Status, java.awt.BorderLayout.SOUTH);


        agentsTilesPanel.add(agentsTile2Panel);

        agentsTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        agentsTile3Panel.setLayout(new java.awt.BorderLayout());

        agentsTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        agentsTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        agentsTile3Title.setText("Contact details");
        agentsTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        agentsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        agentsTile3TextPanel.add(agentsTile3Title);

        agentsTile3Subtitle.setText("Record current agent contact details");
        agentsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        agentsTile3TextPanel.add(agentsTile3Subtitle);


        agentsTile3Panel.add(agentsTile3TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile3Status.setText("Module interface will be integrated here.");
        agentsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentsTile3Panel.add(agentsTile3Status, java.awt.BorderLayout.SOUTH);


        agentsTilesPanel.add(agentsTile3Panel);

        agentsTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        agentsTile4Panel.setLayout(new java.awt.BorderLayout());

        agentsTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        agentsTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        agentsTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        agentsTile4Title.setText("History preservation");
        agentsTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        agentsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        agentsTile4TextPanel.add(agentsTile4Title);

        agentsTile4Subtitle.setText("Keep past delivery agent snapshots");
        agentsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        agentsTile4TextPanel.add(agentsTile4Subtitle);


        agentsTile4Panel.add(agentsTile4TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile4Status.setText("Module interface will be integrated here.");
        agentsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        agentsTile4Panel.add(agentsTile4Status, java.awt.BorderLayout.SOUTH);


        agentsTilesPanel.add(agentsTile4Panel);


        agentsDetailsPanel.add(agentsTilesPanel, java.awt.BorderLayout.CENTER);

        agentsModuleStatus.setText("Assigned developer: Piyathissa   |   Placeholder screen - no database changes");
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

        ordersHeading.setText("Client Order Processing");
        ordersHeading.setForeground(new java.awt.Color(35, 55, 44));
        ordersHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        ordersIntroPanel.add(ordersHeading);

        ordersDescription.setText("Create, confirm and cancel client orders with consistent inventory transactions.");
        ordersDescription.setForeground(new java.awt.Color(110, 128, 117));
        ordersDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersIntroPanel.add(ordersDescription);


        ordersPage.add(ordersIntroPanel, java.awt.BorderLayout.NORTH);

        ordersDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordersDetailsPanel.setLayout(new java.awt.BorderLayout());

        ordersTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        ordersTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        ordersTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        ordersTile1Panel.setLayout(new java.awt.BorderLayout());

        ordersTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        ordersTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        ordersTile1Title.setText("New client order");
        ordersTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        ordersTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ordersTile1TextPanel.add(ordersTile1Title);

        ordersTile1Subtitle.setText("Choose customer and products");
        ordersTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersTile1TextPanel.add(ordersTile1Subtitle);


        ordersTile1Panel.add(ordersTile1TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile1Status.setText("Module interface will be integrated here.");
        ordersTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersTile1Panel.add(ordersTile1Status, java.awt.BorderLayout.SOUTH);


        ordersTilesPanel.add(ordersTile1Panel);

        ordersTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        ordersTile2Panel.setLayout(new java.awt.BorderLayout());

        ordersTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        ordersTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        ordersTile2Title.setText("Order items");
        ordersTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        ordersTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ordersTile2TextPanel.add(ordersTile2Title);

        ordersTile2Subtitle.setText("Quantity and captured selling price");
        ordersTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersTile2TextPanel.add(ordersTile2Subtitle);


        ordersTile2Panel.add(ordersTile2TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile2Status.setText("Module interface will be integrated here.");
        ordersTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersTile2Panel.add(ordersTile2Status, java.awt.BorderLayout.SOUTH);


        ordersTilesPanel.add(ordersTile2Panel);

        ordersTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        ordersTile3Panel.setLayout(new java.awt.BorderLayout());

        ordersTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        ordersTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        ordersTile3Title.setText("Order totals");
        ordersTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        ordersTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ordersTile3TextPanel.add(ordersTile3Title);

        ordersTile3Subtitle.setText("Calculate and confirm order totals");
        ordersTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersTile3TextPanel.add(ordersTile3Subtitle);


        ordersTile3Panel.add(ordersTile3TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile3Status.setText("Module interface will be integrated here.");
        ordersTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersTile3Panel.add(ordersTile3Status, java.awt.BorderLayout.SOUTH);


        ordersTilesPanel.add(ordersTile3Panel);

        ordersTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        ordersTile4Panel.setLayout(new java.awt.BorderLayout());

        ordersTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        ordersTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        ordersTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        ordersTile4Title.setText("Cancel and restore");
        ordersTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        ordersTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ordersTile4TextPanel.add(ordersTile4Title);

        ordersTile4Subtitle.setText("Restore stock exactly once");
        ordersTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        ordersTile4TextPanel.add(ordersTile4Subtitle);


        ordersTile4Panel.add(ordersTile4TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile4Status.setText("Module interface will be integrated here.");
        ordersTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersTile4Panel.add(ordersTile4Status, java.awt.BorderLayout.SOUTH);


        ordersTilesPanel.add(ordersTile4Panel);


        ordersDetailsPanel.add(ordersTilesPanel, java.awt.BorderLayout.CENTER);

        ordersModuleStatus.setText("Assigned developer: Shanika   |   Placeholder screen - no database changes");
        ordersModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        ordersModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        ordersModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        ordersModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        ordersDetailsPanel.add(ordersModuleStatus, java.awt.BorderLayout.SOUTH);


        ordersPage.add(ordersDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(ordersPage, "orders");

        deliveriesPage.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        deliveriesPage.setLayout(new java.awt.BorderLayout());

        deliveriesIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
        deliveriesIntroPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        deliveriesEyebrow.setText("ECONEST / DELIVERIES");
        deliveriesEyebrow.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11));
        deliveriesIntroPanel.add(deliveriesEyebrow);

        deliveriesHeading.setText("Delivery Scheduling");
        deliveriesHeading.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        deliveriesIntroPanel.add(deliveriesHeading);

        deliveriesDescription.setText("Assign agents to orders and track delivery state changes.");
        deliveriesDescription.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesIntroPanel.add(deliveriesDescription);


        deliveriesPage.add(deliveriesIntroPanel, java.awt.BorderLayout.NORTH);

        deliveriesDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesDetailsPanel.setLayout(new java.awt.BorderLayout());

        deliveriesTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        deliveriesTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        deliveriesTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        deliveriesTile1Panel.setLayout(new java.awt.BorderLayout());

        deliveriesTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        deliveriesTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        deliveriesTile1Title.setText("Agent assignment");
        deliveriesTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        deliveriesTile1TextPanel.add(deliveriesTile1Title);

        deliveriesTile1Subtitle.setText("Assign or reassign delivery agents");
        deliveriesTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesTile1TextPanel.add(deliveriesTile1Subtitle);


        deliveriesTile1Panel.add(deliveriesTile1TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile1Status.setText("Module interface will be integrated here.");
        deliveriesTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesTile1Panel.add(deliveriesTile1Status, java.awt.BorderLayout.SOUTH);


        deliveriesTilesPanel.add(deliveriesTile1Panel);

        deliveriesTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        deliveriesTile2Panel.setLayout(new java.awt.BorderLayout());

        deliveriesTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        deliveriesTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        deliveriesTile2Title.setText("Delivery schedule");
        deliveriesTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        deliveriesTile2TextPanel.add(deliveriesTile2Title);

        deliveriesTile2Subtitle.setText("Record planned dispatch and delivery");
        deliveriesTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesTile2TextPanel.add(deliveriesTile2Subtitle);


        deliveriesTile2Panel.add(deliveriesTile2TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile2Status.setText("Module interface will be integrated here.");
        deliveriesTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesTile2Panel.add(deliveriesTile2Status, java.awt.BorderLayout.SOUTH);


        deliveriesTilesPanel.add(deliveriesTile2Panel);

        deliveriesTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        deliveriesTile3Panel.setLayout(new java.awt.BorderLayout());

        deliveriesTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        deliveriesTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        deliveriesTile3Title.setText("Delivery status");
        deliveriesTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        deliveriesTile3TextPanel.add(deliveriesTile3Title);

        deliveriesTile3Subtitle.setText("Assigned, scheduled, dispatched and more");
        deliveriesTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesTile3TextPanel.add(deliveriesTile3Subtitle);


        deliveriesTile3Panel.add(deliveriesTile3TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile3Status.setText("Module interface will be integrated here.");
        deliveriesTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesTile3Panel.add(deliveriesTile3Status, java.awt.BorderLayout.SOUTH);


        deliveriesTilesPanel.add(deliveriesTile3Panel);

        deliveriesTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        deliveriesTile4Panel.setLayout(new java.awt.BorderLayout());

        deliveriesTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        deliveriesTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        deliveriesTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        deliveriesTile4Title.setText("Dispatch tracking");
        deliveriesTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        deliveriesTile4TextPanel.add(deliveriesTile4Title);

        deliveriesTile4Subtitle.setText("Keep historical vehicle and agent data");
        deliveriesTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        deliveriesTile4TextPanel.add(deliveriesTile4Subtitle);


        deliveriesTile4Panel.add(deliveriesTile4TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile4Status.setText("Module interface will be integrated here.");
        deliveriesTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesTile4Panel.add(deliveriesTile4Status, java.awt.BorderLayout.SOUTH);


        deliveriesTilesPanel.add(deliveriesTile4Panel);


        deliveriesDetailsPanel.add(deliveriesTilesPanel, java.awt.BorderLayout.CENTER);

        deliveriesModuleStatus.setText("Assigned developer: Shanika   |   Placeholder screen - no database changes");
        deliveriesModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        deliveriesModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        deliveriesModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        deliveriesDetailsPanel.add(deliveriesModuleStatus, java.awt.BorderLayout.SOUTH);


        deliveriesPage.add(deliveriesDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(deliveriesPage, "deliveries");

        reportsPage.setBackground(new java.awt.Color(246, 249, 247));
        reportsPage.setBorder(javax.swing.BorderFactory.createEmptyBorder(21, 27, 20, 27));
        reportsPage.setLayout(new java.awt.BorderLayout());

        reportsIntroPanel.setBackground(new java.awt.Color(246, 249, 247));
        reportsIntroPanel.setPreferredSize(new java.awt.Dimension(820, 128));
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
        reportsTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        reportsTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        reportsTile1Panel.setLayout(new java.awt.BorderLayout());

        reportsTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        reportsTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        reportsTile1Title.setText("Monthly sales");
        reportsTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        reportsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        reportsTile1TextPanel.add(reportsTile1Title);

        reportsTile1Subtitle.setText("Confirmed sales minus cancellations");
        reportsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        reportsTile1TextPanel.add(reportsTile1Subtitle);


        reportsTile1Panel.add(reportsTile1TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile1Status.setText("Module interface will be integrated here.");
        reportsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsTile1Panel.add(reportsTile1Status, java.awt.BorderLayout.SOUTH);


        reportsTilesPanel.add(reportsTile1Panel);

        reportsTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        reportsTile2Panel.setLayout(new java.awt.BorderLayout());

        reportsTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        reportsTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        reportsTile2Title.setText("Inventory positions");
        reportsTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        reportsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        reportsTile2TextPanel.add(reportsTile2Title);

        reportsTile2Subtitle.setText("Compute month-end stock quantities");
        reportsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        reportsTile2TextPanel.add(reportsTile2Subtitle);


        reportsTile2Panel.add(reportsTile2TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile2Status.setText("Module interface will be integrated here.");
        reportsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsTile2Panel.add(reportsTile2Status, java.awt.BorderLayout.SOUTH);


        reportsTilesPanel.add(reportsTile2Panel);

        reportsTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        reportsTile3Panel.setLayout(new java.awt.BorderLayout());

        reportsTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        reportsTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        reportsTile3Title.setText("Low-stock listings");
        reportsTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        reportsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        reportsTile3TextPanel.add(reportsTile3Title);

        reportsTile3Subtitle.setText("Detect products at reorder level");
        reportsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        reportsTile3TextPanel.add(reportsTile3Subtitle);


        reportsTile3Panel.add(reportsTile3TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile3Status.setText("Module interface will be integrated here.");
        reportsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsTile3Panel.add(reportsTile3Status, java.awt.BorderLayout.SOUTH);


        reportsTilesPanel.add(reportsTile3Panel);

        reportsTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        reportsTile4Panel.setLayout(new java.awt.BorderLayout());

        reportsTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportsTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        reportsTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        reportsTile4Title.setText("Export and review");
        reportsTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        reportsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        reportsTile4TextPanel.add(reportsTile4Title);

        reportsTile4Subtitle.setText("Present generated report results");
        reportsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        reportsTile4TextPanel.add(reportsTile4Subtitle);


        reportsTile4Panel.add(reportsTile4TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile4Status.setText("Module interface will be integrated here.");
        reportsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsTile4Panel.add(reportsTile4Status, java.awt.BorderLayout.SOUTH);


        reportsTilesPanel.add(reportsTile4Panel);


        reportsDetailsPanel.add(reportsTilesPanel, java.awt.BorderLayout.CENTER);

        reportsModuleStatus.setText("Assigned developer: Methsindu   |   Placeholder screen - no database changes");
        reportsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        reportsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        reportsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        reportsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
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

        emailsHeading.setText("Email Notification Center");
        emailsHeading.setForeground(new java.awt.Color(35, 55, 44));
        emailsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25));
        emailsIntroPanel.add(emailsHeading);

        emailsDescription.setText("Track dispatch emails to clients and assignment emails to delivery agents.");
        emailsDescription.setForeground(new java.awt.Color(110, 128, 117));
        emailsDescription.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsIntroPanel.add(emailsDescription);


        emailsPage.add(emailsIntroPanel, java.awt.BorderLayout.NORTH);

        emailsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        emailsDetailsPanel.setLayout(new java.awt.BorderLayout());

        emailsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        emailsTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        emailsTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        emailsTile1Panel.setLayout(new java.awt.BorderLayout());

        emailsTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        emailsTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        emailsTile1Title.setText("Client dispatch email");
        emailsTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        emailsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        emailsTile1TextPanel.add(emailsTile1Title);

        emailsTile1Subtitle.setText("Notify clients when an order dispatches");
        emailsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile1Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsTile1TextPanel.add(emailsTile1Subtitle);


        emailsTile1Panel.add(emailsTile1TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile1Status.setText("Module interface will be integrated here.");
        emailsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsTile1Panel.add(emailsTile1Status, java.awt.BorderLayout.SOUTH);


        emailsTilesPanel.add(emailsTile1Panel);

        emailsTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        emailsTile2Panel.setLayout(new java.awt.BorderLayout());

        emailsTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        emailsTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        emailsTile2Title.setText("Agent assignment email");
        emailsTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        emailsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        emailsTile2TextPanel.add(emailsTile2Title);

        emailsTile2Subtitle.setText("Notify assigned delivery agents");
        emailsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile2Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsTile2TextPanel.add(emailsTile2Subtitle);


        emailsTile2Panel.add(emailsTile2TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile2Status.setText("Module interface will be integrated here.");
        emailsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsTile2Panel.add(emailsTile2Status, java.awt.BorderLayout.SOUTH);


        emailsTilesPanel.add(emailsTile2Panel);

        emailsTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        emailsTile3Panel.setLayout(new java.awt.BorderLayout());

        emailsTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        emailsTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        emailsTile3Title.setText("Outbox status");
        emailsTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        emailsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        emailsTile3TextPanel.add(emailsTile3Title);

        emailsTile3Subtitle.setText("Pending, sent and failed attempts");
        emailsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile3Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsTile3TextPanel.add(emailsTile3Subtitle);


        emailsTile3Panel.add(emailsTile3TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile3Status.setText("Module interface will be integrated here.");
        emailsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsTile3Panel.add(emailsTile3Status, java.awt.BorderLayout.SOUTH);


        emailsTilesPanel.add(emailsTile3Panel);

        emailsTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        emailsTile4Panel.setLayout(new java.awt.BorderLayout());

        emailsTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        emailsTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        emailsTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        emailsTile4Title.setText("Retry history");
        emailsTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        emailsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16));
        emailsTile4TextPanel.add(emailsTile4Title);

        emailsTile4Subtitle.setText("Record attempts and failure reasons");
        emailsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile4Subtitle.setFont(new java.awt.Font("Segoe UI", 0, 12));
        emailsTile4TextPanel.add(emailsTile4Subtitle);


        emailsTile4Panel.add(emailsTile4TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile4Status.setText("Module interface will be integrated here.");
        emailsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsTile4Panel.add(emailsTile4Status, java.awt.BorderLayout.SOUTH);


        emailsTilesPanel.add(emailsTile4Panel);


        emailsDetailsPanel.add(emailsTilesPanel, java.awt.BorderLayout.CENTER);

        emailsModuleStatus.setText("Assigned developer: Methsindu   |   Placeholder screen - no database changes");
        emailsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        emailsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11));
        emailsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        emailsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        emailsDetailsPanel.add(emailsModuleStatus, java.awt.BorderLayout.SOUTH);


        emailsPage.add(emailsDetailsPanel, java.awt.BorderLayout.CENTER);


        contentPanel.add(emailsPage, "emails");


        workspacePanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        statusLabel.setText("EcoNest POS  |  Dashboard  |  Local workspace");
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
            inventoryModuleStatus.setText("Heshan | " + all.size() + " products | "
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
                    "Products loaded: " + products.size() + "  |  Heshan's catalogue module");
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { }
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel clientsTile1Panel;
    private javax.swing.JPanel clientsTile1TextPanel;
    private javax.swing.JLabel clientsTile1Title;
    private javax.swing.JLabel clientsTile1Subtitle;
    private javax.swing.JLabel clientsTile1Status;
    private javax.swing.JPanel clientsTile2Panel;
    private javax.swing.JPanel clientsTile2TextPanel;
    private javax.swing.JLabel clientsTile2Title;
    private javax.swing.JLabel clientsTile2Subtitle;
    private javax.swing.JLabel clientsTile2Status;
    private javax.swing.JPanel clientsTile3Panel;
    private javax.swing.JPanel clientsTile3TextPanel;
    private javax.swing.JLabel clientsTile3Title;
    private javax.swing.JLabel clientsTile3Subtitle;
    private javax.swing.JLabel clientsTile3Status;
    private javax.swing.JPanel clientsTile4Panel;
    private javax.swing.JPanel clientsTile4TextPanel;
    private javax.swing.JLabel clientsTile4Title;
    private javax.swing.JLabel clientsTile4Subtitle;
    private javax.swing.JLabel clientsTile4Status;
    private javax.swing.JLabel clientsModuleStatus;
    private javax.swing.JPanel agentsPage;
    private javax.swing.JPanel agentsIntroPanel;
    private javax.swing.JLabel agentsEyebrow;
    private javax.swing.JLabel agentsHeading;
    private javax.swing.JLabel agentsDescription;
    private javax.swing.JPanel agentsDetailsPanel;
    private javax.swing.JPanel agentsTilesPanel;
    private javax.swing.JPanel agentsTile1Panel;
    private javax.swing.JPanel agentsTile1TextPanel;
    private javax.swing.JLabel agentsTile1Title;
    private javax.swing.JLabel agentsTile1Subtitle;
    private javax.swing.JLabel agentsTile1Status;
    private javax.swing.JPanel agentsTile2Panel;
    private javax.swing.JPanel agentsTile2TextPanel;
    private javax.swing.JLabel agentsTile2Title;
    private javax.swing.JLabel agentsTile2Subtitle;
    private javax.swing.JLabel agentsTile2Status;
    private javax.swing.JPanel agentsTile3Panel;
    private javax.swing.JPanel agentsTile3TextPanel;
    private javax.swing.JLabel agentsTile3Title;
    private javax.swing.JLabel agentsTile3Subtitle;
    private javax.swing.JLabel agentsTile3Status;
    private javax.swing.JPanel agentsTile4Panel;
    private javax.swing.JPanel agentsTile4TextPanel;
    private javax.swing.JLabel agentsTile4Title;
    private javax.swing.JLabel agentsTile4Subtitle;
    private javax.swing.JLabel agentsTile4Status;
    private javax.swing.JLabel agentsModuleStatus;
    private javax.swing.JPanel ordersPage;
    private javax.swing.JPanel ordersIntroPanel;
    private javax.swing.JLabel ordersEyebrow;
    private javax.swing.JLabel ordersHeading;
    private javax.swing.JLabel ordersDescription;
    private javax.swing.JPanel ordersDetailsPanel;
    private javax.swing.JPanel ordersTilesPanel;
    private javax.swing.JPanel ordersTile1Panel;
    private javax.swing.JPanel ordersTile1TextPanel;
    private javax.swing.JLabel ordersTile1Title;
    private javax.swing.JLabel ordersTile1Subtitle;
    private javax.swing.JLabel ordersTile1Status;
    private javax.swing.JPanel ordersTile2Panel;
    private javax.swing.JPanel ordersTile2TextPanel;
    private javax.swing.JLabel ordersTile2Title;
    private javax.swing.JLabel ordersTile2Subtitle;
    private javax.swing.JLabel ordersTile2Status;
    private javax.swing.JPanel ordersTile3Panel;
    private javax.swing.JPanel ordersTile3TextPanel;
    private javax.swing.JLabel ordersTile3Title;
    private javax.swing.JLabel ordersTile3Subtitle;
    private javax.swing.JLabel ordersTile3Status;
    private javax.swing.JPanel ordersTile4Panel;
    private javax.swing.JPanel ordersTile4TextPanel;
    private javax.swing.JLabel ordersTile4Title;
    private javax.swing.JLabel ordersTile4Subtitle;
    private javax.swing.JLabel ordersTile4Status;
    private javax.swing.JLabel ordersModuleStatus;
    private javax.swing.JPanel deliveriesPage;
    private javax.swing.JPanel deliveriesIntroPanel;
    private javax.swing.JLabel deliveriesEyebrow;
    private javax.swing.JLabel deliveriesHeading;
    private javax.swing.JLabel deliveriesDescription;
    private javax.swing.JPanel deliveriesDetailsPanel;
    private javax.swing.JPanel deliveriesTilesPanel;
    private javax.swing.JPanel deliveriesTile1Panel;
    private javax.swing.JPanel deliveriesTile1TextPanel;
    private javax.swing.JLabel deliveriesTile1Title;
    private javax.swing.JLabel deliveriesTile1Subtitle;
    private javax.swing.JLabel deliveriesTile1Status;
    private javax.swing.JPanel deliveriesTile2Panel;
    private javax.swing.JPanel deliveriesTile2TextPanel;
    private javax.swing.JLabel deliveriesTile2Title;
    private javax.swing.JLabel deliveriesTile2Subtitle;
    private javax.swing.JLabel deliveriesTile2Status;
    private javax.swing.JPanel deliveriesTile3Panel;
    private javax.swing.JPanel deliveriesTile3TextPanel;
    private javax.swing.JLabel deliveriesTile3Title;
    private javax.swing.JLabel deliveriesTile3Subtitle;
    private javax.swing.JLabel deliveriesTile3Status;
    private javax.swing.JPanel deliveriesTile4Panel;
    private javax.swing.JPanel deliveriesTile4TextPanel;
    private javax.swing.JLabel deliveriesTile4Title;
    private javax.swing.JLabel deliveriesTile4Subtitle;
    private javax.swing.JLabel deliveriesTile4Status;
    private javax.swing.JLabel deliveriesModuleStatus;
    private javax.swing.JPanel reportsPage;
    private javax.swing.JPanel reportsIntroPanel;
    private javax.swing.JLabel reportsEyebrow;
    private javax.swing.JLabel reportsHeading;
    private javax.swing.JLabel reportsDescription;
    private javax.swing.JPanel reportsDetailsPanel;
    private javax.swing.JPanel reportsTilesPanel;
    private javax.swing.JPanel reportsTile1Panel;
    private javax.swing.JPanel reportsTile1TextPanel;
    private javax.swing.JLabel reportsTile1Title;
    private javax.swing.JLabel reportsTile1Subtitle;
    private javax.swing.JLabel reportsTile1Status;
    private javax.swing.JPanel reportsTile2Panel;
    private javax.swing.JPanel reportsTile2TextPanel;
    private javax.swing.JLabel reportsTile2Title;
    private javax.swing.JLabel reportsTile2Subtitle;
    private javax.swing.JLabel reportsTile2Status;
    private javax.swing.JPanel reportsTile3Panel;
    private javax.swing.JPanel reportsTile3TextPanel;
    private javax.swing.JLabel reportsTile3Title;
    private javax.swing.JLabel reportsTile3Subtitle;
    private javax.swing.JLabel reportsTile3Status;
    private javax.swing.JPanel reportsTile4Panel;
    private javax.swing.JPanel reportsTile4TextPanel;
    private javax.swing.JLabel reportsTile4Title;
    private javax.swing.JLabel reportsTile4Subtitle;
    private javax.swing.JLabel reportsTile4Status;
    private javax.swing.JLabel reportsModuleStatus;
    private javax.swing.JPanel emailsPage;
    private javax.swing.JPanel emailsIntroPanel;
    private javax.swing.JLabel emailsEyebrow;
    private javax.swing.JLabel emailsHeading;
    private javax.swing.JLabel emailsDescription;
    private javax.swing.JPanel emailsDetailsPanel;
    private javax.swing.JPanel emailsTilesPanel;
    private javax.swing.JPanel emailsTile1Panel;
    private javax.swing.JPanel emailsTile1TextPanel;
    private javax.swing.JLabel emailsTile1Title;
    private javax.swing.JLabel emailsTile1Subtitle;
    private javax.swing.JLabel emailsTile1Status;
    private javax.swing.JPanel emailsTile2Panel;
    private javax.swing.JPanel emailsTile2TextPanel;
    private javax.swing.JLabel emailsTile2Title;
    private javax.swing.JLabel emailsTile2Subtitle;
    private javax.swing.JLabel emailsTile2Status;
    private javax.swing.JPanel emailsTile3Panel;
    private javax.swing.JPanel emailsTile3TextPanel;
    private javax.swing.JLabel emailsTile3Title;
    private javax.swing.JLabel emailsTile3Subtitle;
    private javax.swing.JLabel emailsTile3Status;
    private javax.swing.JPanel emailsTile4Panel;
    private javax.swing.JPanel emailsTile4TextPanel;
    private javax.swing.JLabel emailsTile4Title;
    private javax.swing.JLabel emailsTile4Subtitle;
    private javax.swing.JLabel emailsTile4Status;
    private javax.swing.JLabel emailsModuleStatus;
    // End of variables declaration//GEN-END:variables
}
