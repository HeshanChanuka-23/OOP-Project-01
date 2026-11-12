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
    }

    /** Show a panel that ALREADY EXISTS in the GUI Builder CardLayout. */
    public final void showPage(String pageKey) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, pageKey);
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
        productsTile1Panel = new javax.swing.JPanel();
        productsTile1TextPanel = new javax.swing.JPanel();
        productsTile1Title = new javax.swing.JLabel();
        productsTile1Subtitle = new javax.swing.JLabel();
        productsTile1Status = new javax.swing.JLabel();
        productsTile2Panel = new javax.swing.JPanel();
        productsTile2TextPanel = new javax.swing.JPanel();
        productsTile2Title = new javax.swing.JLabel();
        productsTile2Subtitle = new javax.swing.JLabel();
        productsTile2Status = new javax.swing.JLabel();
        productsTile3Panel = new javax.swing.JPanel();
        productsTile3TextPanel = new javax.swing.JPanel();
        productsTile3Title = new javax.swing.JLabel();
        productsTile3Subtitle = new javax.swing.JLabel();
        productsTile3Status = new javax.swing.JLabel();
        productsTile4Panel = new javax.swing.JPanel();
        productsTile4TextPanel = new javax.swing.JPanel();
        productsTile4Title = new javax.swing.JLabel();
        productsTile4Subtitle = new javax.swing.JLabel();
        productsTile4Status = new javax.swing.JLabel();
        productsModuleStatus = new javax.swing.JLabel();
        inventoryPage = new javax.swing.JPanel();
        inventoryIntroPanel = new javax.swing.JPanel();
        inventoryEyebrow = new javax.swing.JLabel();
        inventoryHeading = new javax.swing.JLabel();
        inventoryDescription = new javax.swing.JLabel();
        inventoryDetailsPanel = new javax.swing.JPanel();
        inventoryTilesPanel = new javax.swing.JPanel();
        inventoryTile1Panel = new javax.swing.JPanel();
        inventoryTile1TextPanel = new javax.swing.JPanel();
        inventoryTile1Title = new javax.swing.JLabel();
        inventoryTile1Subtitle = new javax.swing.JLabel();
        inventoryTile1Status = new javax.swing.JLabel();
        inventoryTile2Panel = new javax.swing.JPanel();
        inventoryTile2TextPanel = new javax.swing.JPanel();
        inventoryTile2Title = new javax.swing.JLabel();
        inventoryTile2Subtitle = new javax.swing.JLabel();
        inventoryTile2Status = new javax.swing.JLabel();
        inventoryTile3Panel = new javax.swing.JPanel();
        inventoryTile3TextPanel = new javax.swing.JPanel();
        inventoryTile3Title = new javax.swing.JLabel();
        inventoryTile3Subtitle = new javax.swing.JLabel();
        inventoryTile3Status = new javax.swing.JLabel();
        inventoryTile4Panel = new javax.swing.JPanel();
        inventoryTile4TextPanel = new javax.swing.JPanel();
        inventoryTile4Title = new javax.swing.JLabel();
        inventoryTile4Subtitle = new javax.swing.JLabel();
        inventoryTile4Status = new javax.swing.JLabel();
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
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoNest POS | Management System");
        getContentPane().setLayout(new java.awt.BorderLayout());

        sidebarPanel.setBackground(new java.awt.Color(24, 55, 45));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(235, 700));
        sidebarPanel.setLayout(new java.awt.BorderLayout());

        brandPanel.setBackground(new java.awt.Color(24, 55, 45));
        brandPanel.setPreferredSize(new java.awt.Dimension(235, 98));
        brandPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 22, 7, 8));
        brandPanel.setLayout(new java.awt.GridLayout(2, 1));

        brandTitleLabel.setText("EcoNest  •");
        brandTitleLabel.setForeground(new java.awt.Color(239, 250, 241));
        brandTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        brandPanel.add(brandTitleLabel);

        brandTaglineLabel.setText("Sustainable retail POS");
        brandTaglineLabel.setForeground(new java.awt.Color(176, 213, 190));
        brandPanel.add(brandTaglineLabel);

        sidebarPanel.add(brandPanel, java.awt.BorderLayout.NORTH);

        navigationPanel.setBackground(new java.awt.Color(24, 55, 45));
        navigationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 10, 14));
        navigationPanel.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        btnDashboard.setText("   Dashboard");
        btnDashboard.setBackground(new java.awt.Color(40, 83, 65));
        btnDashboard.setForeground(new java.awt.Color(218, 243, 224));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnProducts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnInventory.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnClients.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnDeliveryAgents.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnOrders.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnDeliveries.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        btnEmailNotifications.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        sidebarFooterLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        headerTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        headerTitleBlock.add(headerTitleLabel);

        headerSubtitleLabel.setText("Your sustainable retail workspace");
        headerSubtitleLabel.setForeground(new java.awt.Color(110, 128, 117));
        headerTitleBlock.add(headerSubtitleLabel);

        headerPanel.add(headerTitleBlock, java.awt.BorderLayout.CENTER);

        headerModeLabel.setText("LOCAL WORKSPACE");
        headerModeLabel.setForeground(new java.awt.Color(30, 100, 59));
        headerModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
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
        heroEyebrowLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        heroTextPanel.add(heroEyebrowLabel);

        heroHeadlineLabel.setText("Grow a better business.");
        heroHeadlineLabel.setForeground(new java.awt.Color(255, 255, 255));
        heroHeadlineLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        heroTextPanel.add(heroHeadlineLabel);

        heroDescriptionLabel.setText("One place for products, inventory, orders and deliveries.");
        heroDescriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        heroDescriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        metricsHeadingPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        metricsHeadingPanel.add(metricsHeadingPanelTitle);

        metricsHeadingPanelCaption.setText("Values update when the module database services are connected.");
        metricsHeadingPanelCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricsHeadingPanelCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        metricsHeadingPanel.add(metricsHeadingPanelCaption);

        metricsSectionPanel.add(metricsHeadingPanel, java.awt.BorderLayout.NORTH);

        metricGridPanel.setBackground(new java.awt.Color(246, 249, 247));
        metricGridPanel.setLayout(new java.awt.GridLayout(1, 4, 13, 0));

        metricProductsPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricProductsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricProductsPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricProductsTitle.setText("PRODUCTS");
        metricProductsTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricProductsTitle.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        metricProductsPanel.add(metricProductsTitle);

        metricProductsValue.setText("—");
        metricProductsValue.setForeground(new java.awt.Color(35, 55, 44));
        metricProductsValue.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        metricProductsPanel.add(metricProductsValue);

        metricProductsCaption.setText("Catalogue items");
        metricProductsCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricProductsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        metricProductsPanel.add(metricProductsCaption);

        metricGridPanel.add(metricProductsPanel);

        metricInventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricInventoryPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricInventoryPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricInventoryTitle.setText("INVENTORY");
        metricInventoryTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricInventoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        metricInventoryPanel.add(metricInventoryTitle);

        metricInventoryValue.setText("—");
        metricInventoryValue.setForeground(new java.awt.Color(35, 55, 44));
        metricInventoryValue.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        metricInventoryPanel.add(metricInventoryValue);

        metricInventoryCaption.setText("Units available");
        metricInventoryCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricInventoryCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        metricInventoryPanel.add(metricInventoryCaption);

        metricGridPanel.add(metricInventoryPanel);

        metricOrdersPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricOrdersPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricOrdersPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricOrdersTitle.setText("ORDERS");
        metricOrdersTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricOrdersTitle.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        metricOrdersPanel.add(metricOrdersTitle);

        metricOrdersValue.setText("—");
        metricOrdersValue.setForeground(new java.awt.Color(35, 55, 44));
        metricOrdersValue.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        metricOrdersPanel.add(metricOrdersValue);

        metricOrdersCaption.setText("Orders recorded");
        metricOrdersCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricOrdersCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        metricOrdersPanel.add(metricOrdersCaption);

        metricGridPanel.add(metricOrdersPanel);

        metricSalesPanel.setBackground(new java.awt.Color(255, 255, 255));
        metricSalesPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(9, 15, 9, 14));
        metricSalesPanel.setLayout(new java.awt.GridLayout(3, 1, 0, 3));

        metricSalesTitle.setText("SALES");
        metricSalesTitle.setForeground(new java.awt.Color(110, 128, 117));
        metricSalesTitle.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        metricSalesPanel.add(metricSalesTitle);

        metricSalesValue.setText("—");
        metricSalesValue.setForeground(new java.awt.Color(35, 55, 44));
        metricSalesValue.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        metricSalesPanel.add(metricSalesValue);

        metricSalesCaption.setText("Monthly revenue");
        metricSalesCaption.setForeground(new java.awt.Color(110, 128, 117));
        metricSalesCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        quickHeadingPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        quickHeadingPanel.add(quickHeadingPanelTitle);

        quickHeadingPanelCaption.setText("Open a workspace to build and test a team module.");
        quickHeadingPanelCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickHeadingPanelCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        quickProductsTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        quickProductsTextPanel.add(quickProductsTitle);

        quickProductsCaption.setText("Manage plants, planters and kits");
        quickProductsCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickProductsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        quickProductsTextPanel.add(quickProductsCaption);

        quickProductsPanel.add(quickProductsTextPanel, java.awt.BorderLayout.CENTER);

        quickProductsButton.setText("Open  ›");
        quickProductsButton.setBackground(new java.awt.Color(225, 244, 231));
        quickProductsButton.setForeground(new java.awt.Color(30, 100, 59));
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
        quickInventoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        quickInventoryTextPanel.add(quickInventoryTitle);

        quickInventoryCaption.setText("Monitor stock and supplier entries");
        quickInventoryCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickInventoryCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        quickInventoryTextPanel.add(quickInventoryCaption);

        quickInventoryPanel.add(quickInventoryTextPanel, java.awt.BorderLayout.CENTER);

        quickInventoryButton.setText("Open  ›");
        quickInventoryButton.setBackground(new java.awt.Color(225, 244, 231));
        quickInventoryButton.setForeground(new java.awt.Color(30, 100, 59));
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
        quickOrdersTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        quickOrdersTextPanel.add(quickOrdersTitle);

        quickOrdersCaption.setText("Process and track client orders");
        quickOrdersCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickOrdersCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        quickOrdersTextPanel.add(quickOrdersCaption);

        quickOrdersPanel.add(quickOrdersTextPanel, java.awt.BorderLayout.CENTER);

        quickOrdersButton.setText("Open  ›");
        quickOrdersButton.setBackground(new java.awt.Color(225, 244, 231));
        quickOrdersButton.setForeground(new java.awt.Color(30, 100, 59));
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
        quickReportsTitle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        quickReportsTextPanel.add(quickReportsTitle);

        quickReportsCaption.setText("Review monthly performance");
        quickReportsCaption.setForeground(new java.awt.Color(110, 128, 117));
        quickReportsCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        quickReportsTextPanel.add(quickReportsCaption);

        quickReportsPanel.add(quickReportsTextPanel, java.awt.BorderLayout.CENTER);

        quickReportsButton.setText("Open  ›");
        quickReportsButton.setBackground(new java.awt.Color(225, 244, 231));
        quickReportsButton.setForeground(new java.awt.Color(30, 100, 59));
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
        productsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        productsIntroPanel.add(productsEyebrow);

        productsHeading.setText("Product Catalogue");
        productsHeading.setForeground(new java.awt.Color(35, 55, 44));
        productsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        productsIntroPanel.add(productsHeading);

        productsDescription.setText("Manage plants, planters, gardening kits, prices and eco-ratings.");
        productsDescription.setForeground(new java.awt.Color(110, 128, 117));
        productsIntroPanel.add(productsDescription);

        productsPage.add(productsIntroPanel, java.awt.BorderLayout.NORTH);

        productsDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        productsDetailsPanel.setLayout(new java.awt.BorderLayout());

        productsTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        productsTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        productsTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        productsTile1Panel.setLayout(new java.awt.BorderLayout());

        productsTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        productsTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        productsTile1Title.setText("Catalog items");
        productsTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        productsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productsTile1TextPanel.add(productsTile1Title);

        productsTile1Subtitle.setText("Add, update and remove products");
        productsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        productsTile1TextPanel.add(productsTile1Subtitle);

        productsTile1Panel.add(productsTile1TextPanel, java.awt.BorderLayout.NORTH);

        productsTile1Status.setText("Module interface will be integrated here.");
        productsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        productsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        productsTile1Panel.add(productsTile1Status, java.awt.BorderLayout.SOUTH);

        productsTilesPanel.add(productsTile1Panel);

        productsTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        productsTile2Panel.setLayout(new java.awt.BorderLayout());

        productsTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        productsTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        productsTile2Title.setText("Product categories");
        productsTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        productsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productsTile2TextPanel.add(productsTile2Title);

        productsTile2Subtitle.setText("Plants, planters and gardening kits");
        productsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        productsTile2TextPanel.add(productsTile2Subtitle);

        productsTile2Panel.add(productsTile2TextPanel, java.awt.BorderLayout.NORTH);

        productsTile2Status.setText("Module interface will be integrated here.");
        productsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        productsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        productsTile2Panel.add(productsTile2Status, java.awt.BorderLayout.SOUTH);

        productsTilesPanel.add(productsTile2Panel);

        productsTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        productsTile3Panel.setLayout(new java.awt.BorderLayout());

        productsTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        productsTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        productsTile3Title.setText("Pricing and eco-ratings");
        productsTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        productsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productsTile3TextPanel.add(productsTile3Title);

        productsTile3Subtitle.setText("Validate price and environmental score");
        productsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        productsTile3TextPanel.add(productsTile3Subtitle);

        productsTile3Panel.add(productsTile3TextPanel, java.awt.BorderLayout.NORTH);

        productsTile3Status.setText("Module interface will be integrated here.");
        productsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        productsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        productsTile3Panel.add(productsTile3Status, java.awt.BorderLayout.SOUTH);

        productsTilesPanel.add(productsTile3Panel);

        productsTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        productsTile4Panel.setLayout(new java.awt.BorderLayout());

        productsTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        productsTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        productsTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        productsTile4Title.setText("Historical records");
        productsTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        productsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productsTile4TextPanel.add(productsTile4Title);

        productsTile4Subtitle.setText("Keep past order product snapshots");
        productsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        productsTile4TextPanel.add(productsTile4Subtitle);

        productsTile4Panel.add(productsTile4TextPanel, java.awt.BorderLayout.NORTH);

        productsTile4Status.setText("Module interface will be integrated here.");
        productsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        productsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        productsTile4Panel.add(productsTile4Status, java.awt.BorderLayout.SOUTH);

        productsTilesPanel.add(productsTile4Panel);

        productsDetailsPanel.add(productsTilesPanel, java.awt.BorderLayout.CENTER);

        productsModuleStatus.setText("Assigned developer: Heshan   |   Placeholder screen - no database changes");
        productsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        productsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        inventoryEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        inventoryIntroPanel.add(inventoryEyebrow);

        inventoryHeading.setText("Inventory Management");
        inventoryHeading.setForeground(new java.awt.Color(35, 55, 44));
        inventoryHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        inventoryIntroPanel.add(inventoryHeading);

        inventoryDescription.setText("Track quantity on hand, reorder levels, suppliers and stock movement history.");
        inventoryDescription.setForeground(new java.awt.Color(110, 128, 117));
        inventoryIntroPanel.add(inventoryDescription);

        inventoryPage.add(inventoryIntroPanel, java.awt.BorderLayout.NORTH);

        inventoryDetailsPanel.setBackground(new java.awt.Color(246, 249, 247));
        inventoryDetailsPanel.setLayout(new java.awt.BorderLayout());

        inventoryTilesPanel.setBackground(new java.awt.Color(246, 249, 247));
        inventoryTilesPanel.setLayout(new java.awt.GridLayout(2, 2, 17, 17));

        inventoryTile1Panel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile1Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        inventoryTile1Panel.setLayout(new java.awt.BorderLayout());

        inventoryTile1TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile1TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        inventoryTile1TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        inventoryTile1Title.setText("Stock overview");
        inventoryTile1Title.setForeground(new java.awt.Color(35, 55, 44));
        inventoryTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inventoryTile1TextPanel.add(inventoryTile1Title);

        inventoryTile1Subtitle.setText("See available quantities by product");
        inventoryTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        inventoryTile1TextPanel.add(inventoryTile1Subtitle);

        inventoryTile1Panel.add(inventoryTile1TextPanel, java.awt.BorderLayout.NORTH);

        inventoryTile1Status.setText("Module interface will be integrated here.");
        inventoryTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        inventoryTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        inventoryTile1Panel.add(inventoryTile1Status, java.awt.BorderLayout.SOUTH);

        inventoryTilesPanel.add(inventoryTile1Panel);

        inventoryTile2Panel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile2Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        inventoryTile2Panel.setLayout(new java.awt.BorderLayout());

        inventoryTile2TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile2TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        inventoryTile2TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        inventoryTile2Title.setText("Stock-in from suppliers");
        inventoryTile2Title.setForeground(new java.awt.Color(35, 55, 44));
        inventoryTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inventoryTile2TextPanel.add(inventoryTile2Title);

        inventoryTile2Subtitle.setText("Receive and record supplier deliveries");
        inventoryTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        inventoryTile2TextPanel.add(inventoryTile2Subtitle);

        inventoryTile2Panel.add(inventoryTile2TextPanel, java.awt.BorderLayout.NORTH);

        inventoryTile2Status.setText("Module interface will be integrated here.");
        inventoryTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        inventoryTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        inventoryTile2Panel.add(inventoryTile2Status, java.awt.BorderLayout.SOUTH);

        inventoryTilesPanel.add(inventoryTile2Panel);

        inventoryTile3Panel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile3Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        inventoryTile3Panel.setLayout(new java.awt.BorderLayout());

        inventoryTile3TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile3TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        inventoryTile3TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        inventoryTile3Title.setText("Low-stock alerts");
        inventoryTile3Title.setForeground(new java.awt.Color(35, 55, 44));
        inventoryTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inventoryTile3TextPanel.add(inventoryTile3Title);

        inventoryTile3Subtitle.setText("Compare quantity with reorder levels");
        inventoryTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        inventoryTile3TextPanel.add(inventoryTile3Subtitle);

        inventoryTile3Panel.add(inventoryTile3TextPanel, java.awt.BorderLayout.NORTH);

        inventoryTile3Status.setText("Module interface will be integrated here.");
        inventoryTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        inventoryTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        inventoryTile3Panel.add(inventoryTile3Status, java.awt.BorderLayout.SOUTH);

        inventoryTilesPanel.add(inventoryTile3Panel);

        inventoryTile4Panel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile4Panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(17, 19, 17, 18));
        inventoryTile4Panel.setLayout(new java.awt.BorderLayout());

        inventoryTile4TextPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryTile4TextPanel.setPreferredSize(new java.awt.Dimension(330, 88));
        inventoryTile4TextPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        inventoryTile4Title.setText("Movement history");
        inventoryTile4Title.setForeground(new java.awt.Color(35, 55, 44));
        inventoryTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        inventoryTile4TextPanel.add(inventoryTile4Title);

        inventoryTile4Subtitle.setText("Record sales, restorations and write-offs");
        inventoryTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        inventoryTile4TextPanel.add(inventoryTile4Subtitle);

        inventoryTile4Panel.add(inventoryTile4TextPanel, java.awt.BorderLayout.NORTH);

        inventoryTile4Status.setText("Module interface will be integrated here.");
        inventoryTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        inventoryTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        inventoryTile4Panel.add(inventoryTile4Status, java.awt.BorderLayout.SOUTH);

        inventoryTilesPanel.add(inventoryTile4Panel);

        inventoryDetailsPanel.add(inventoryTilesPanel, java.awt.BorderLayout.CENTER);

        inventoryModuleStatus.setText("Assigned developer: Heshan   |   Placeholder screen - no database changes");
        inventoryModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        inventoryModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        clientsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        clientsIntroPanel.add(clientsEyebrow);

        clientsHeading.setText("Client Management");
        clientsHeading.setForeground(new java.awt.Color(35, 55, 44));
        clientsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        clientsIntroPanel.add(clientsHeading);

        clientsDescription.setText("Create and maintain household and office client information.");
        clientsDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        clientsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        clientsTile1TextPanel.add(clientsTile1Title);

        clientsTile1Subtitle.setText("Search and view customer records");
        clientsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile1TextPanel.add(clientsTile1Subtitle);

        clientsTile1Panel.add(clientsTile1TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile1Status.setText("Module interface will be integrated here.");
        clientsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        clientsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        clientsTile2TextPanel.add(clientsTile2Title);

        clientsTile2Subtitle.setText("Update email, phone and address");
        clientsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile2TextPanel.add(clientsTile2Subtitle);

        clientsTile2Panel.add(clientsTile2TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile2Status.setText("Module interface will be integrated here.");
        clientsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        clientsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        clientsTile3TextPanel.add(clientsTile3Title);

        clientsTile3Subtitle.setText("Household and office clients");
        clientsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile3TextPanel.add(clientsTile3Subtitle);

        clientsTile3Panel.add(clientsTile3TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile3Status.setText("Module interface will be integrated here.");
        clientsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        clientsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        clientsTile4TextPanel.add(clientsTile4Title);

        clientsTile4Subtitle.setText("Keep client snapshots on past orders");
        clientsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        clientsTile4TextPanel.add(clientsTile4Subtitle);

        clientsTile4Panel.add(clientsTile4TextPanel, java.awt.BorderLayout.NORTH);

        clientsTile4Status.setText("Module interface will be integrated here.");
        clientsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        clientsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        clientsTile4Panel.add(clientsTile4Status, java.awt.BorderLayout.SOUTH);

        clientsTilesPanel.add(clientsTile4Panel);

        clientsDetailsPanel.add(clientsTilesPanel, java.awt.BorderLayout.CENTER);

        clientsModuleStatus.setText("Assigned developer: Piyathissa   |   Placeholder screen - no database changes");
        clientsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        clientsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        agentsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        agentsIntroPanel.add(agentsEyebrow);

        agentsHeading.setText("Delivery Agent Management");
        agentsHeading.setForeground(new java.awt.Color(35, 55, 44));
        agentsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        agentsIntroPanel.add(agentsHeading);

        agentsDescription.setText("Maintain delivery agents and their assigned vehicle details.");
        agentsDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        agentsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        agentsTile1TextPanel.add(agentsTile1Title);

        agentsTile1Subtitle.setText("Add, update and remove agents");
        agentsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile1TextPanel.add(agentsTile1Subtitle);

        agentsTile1Panel.add(agentsTile1TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile1Status.setText("Module interface will be integrated here.");
        agentsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        agentsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        agentsTile2TextPanel.add(agentsTile2Title);

        agentsTile2Subtitle.setText("Vehicle type and registration number");
        agentsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile2TextPanel.add(agentsTile2Subtitle);

        agentsTile2Panel.add(agentsTile2TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile2Status.setText("Module interface will be integrated here.");
        agentsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        agentsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        agentsTile3TextPanel.add(agentsTile3Title);

        agentsTile3Subtitle.setText("Record current agent contact details");
        agentsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile3TextPanel.add(agentsTile3Subtitle);

        agentsTile3Panel.add(agentsTile3TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile3Status.setText("Module interface will be integrated here.");
        agentsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        agentsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        agentsTile4TextPanel.add(agentsTile4Title);

        agentsTile4Subtitle.setText("Keep past delivery agent snapshots");
        agentsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        agentsTile4TextPanel.add(agentsTile4Subtitle);

        agentsTile4Panel.add(agentsTile4TextPanel, java.awt.BorderLayout.NORTH);

        agentsTile4Status.setText("Module interface will be integrated here.");
        agentsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        agentsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        agentsTile4Panel.add(agentsTile4Status, java.awt.BorderLayout.SOUTH);

        agentsTilesPanel.add(agentsTile4Panel);

        agentsDetailsPanel.add(agentsTilesPanel, java.awt.BorderLayout.CENTER);

        agentsModuleStatus.setText("Assigned developer: Piyathissa   |   Placeholder screen - no database changes");
        agentsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        agentsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        ordersEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        ordersIntroPanel.add(ordersEyebrow);

        ordersHeading.setText("Client Order Processing");
        ordersHeading.setForeground(new java.awt.Color(35, 55, 44));
        ordersHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        ordersIntroPanel.add(ordersHeading);

        ordersDescription.setText("Create, confirm and cancel client orders with consistent inventory transactions.");
        ordersDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        ordersTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ordersTile1TextPanel.add(ordersTile1Title);

        ordersTile1Subtitle.setText("Choose customer and products");
        ordersTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile1TextPanel.add(ordersTile1Subtitle);

        ordersTile1Panel.add(ordersTile1TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile1Status.setText("Module interface will be integrated here.");
        ordersTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        ordersTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ordersTile2TextPanel.add(ordersTile2Title);

        ordersTile2Subtitle.setText("Quantity and captured selling price");
        ordersTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile2TextPanel.add(ordersTile2Subtitle);

        ordersTile2Panel.add(ordersTile2TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile2Status.setText("Module interface will be integrated here.");
        ordersTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        ordersTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ordersTile3TextPanel.add(ordersTile3Title);

        ordersTile3Subtitle.setText("Calculate and confirm order totals");
        ordersTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile3TextPanel.add(ordersTile3Subtitle);

        ordersTile3Panel.add(ordersTile3TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile3Status.setText("Module interface will be integrated here.");
        ordersTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        ordersTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ordersTile4TextPanel.add(ordersTile4Title);

        ordersTile4Subtitle.setText("Restore stock exactly once");
        ordersTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        ordersTile4TextPanel.add(ordersTile4Subtitle);

        ordersTile4Panel.add(ordersTile4TextPanel, java.awt.BorderLayout.NORTH);

        ordersTile4Status.setText("Module interface will be integrated here.");
        ordersTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        ordersTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ordersTile4Panel.add(ordersTile4Status, java.awt.BorderLayout.SOUTH);

        ordersTilesPanel.add(ordersTile4Panel);

        ordersDetailsPanel.add(ordersTilesPanel, java.awt.BorderLayout.CENTER);

        ordersModuleStatus.setText("Assigned developer: Shanika   |   Placeholder screen - no database changes");
        ordersModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        ordersModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        deliveriesEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        deliveriesIntroPanel.add(deliveriesEyebrow);

        deliveriesHeading.setText("Delivery Scheduling");
        deliveriesHeading.setForeground(new java.awt.Color(35, 55, 44));
        deliveriesHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        deliveriesIntroPanel.add(deliveriesHeading);

        deliveriesDescription.setText("Assign agents to orders and track delivery state changes.");
        deliveriesDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        deliveriesTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deliveriesTile1TextPanel.add(deliveriesTile1Title);

        deliveriesTile1Subtitle.setText("Assign or reassign delivery agents");
        deliveriesTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile1TextPanel.add(deliveriesTile1Subtitle);

        deliveriesTile1Panel.add(deliveriesTile1TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile1Status.setText("Module interface will be integrated here.");
        deliveriesTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        deliveriesTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deliveriesTile2TextPanel.add(deliveriesTile2Title);

        deliveriesTile2Subtitle.setText("Record planned dispatch and delivery");
        deliveriesTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile2TextPanel.add(deliveriesTile2Subtitle);

        deliveriesTile2Panel.add(deliveriesTile2TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile2Status.setText("Module interface will be integrated here.");
        deliveriesTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        deliveriesTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deliveriesTile3TextPanel.add(deliveriesTile3Title);

        deliveriesTile3Subtitle.setText("Assigned, scheduled, dispatched and more");
        deliveriesTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile3TextPanel.add(deliveriesTile3Subtitle);

        deliveriesTile3Panel.add(deliveriesTile3TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile3Status.setText("Module interface will be integrated here.");
        deliveriesTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        deliveriesTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deliveriesTile4TextPanel.add(deliveriesTile4Title);

        deliveriesTile4Subtitle.setText("Keep historical vehicle and agent data");
        deliveriesTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesTile4TextPanel.add(deliveriesTile4Subtitle);

        deliveriesTile4Panel.add(deliveriesTile4TextPanel, java.awt.BorderLayout.NORTH);

        deliveriesTile4Status.setText("Module interface will be integrated here.");
        deliveriesTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        deliveriesTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        deliveriesTile4Panel.add(deliveriesTile4Status, java.awt.BorderLayout.SOUTH);

        deliveriesTilesPanel.add(deliveriesTile4Panel);

        deliveriesDetailsPanel.add(deliveriesTilesPanel, java.awt.BorderLayout.CENTER);

        deliveriesModuleStatus.setText("Assigned developer: Shanika   |   Placeholder screen - no database changes");
        deliveriesModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        deliveriesModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        reportsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        reportsIntroPanel.add(reportsEyebrow);

        reportsHeading.setText("Monthly Reports");
        reportsHeading.setForeground(new java.awt.Color(35, 55, 44));
        reportsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        reportsIntroPanel.add(reportsHeading);

        reportsDescription.setText("Generate monthly sales, inventory and low-stock reports from live data.");
        reportsDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        reportsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reportsTile1TextPanel.add(reportsTile1Title);

        reportsTile1Subtitle.setText("Confirmed sales minus cancellations");
        reportsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile1TextPanel.add(reportsTile1Subtitle);

        reportsTile1Panel.add(reportsTile1TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile1Status.setText("Module interface will be integrated here.");
        reportsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        reportsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reportsTile2TextPanel.add(reportsTile2Title);

        reportsTile2Subtitle.setText("Compute month-end stock quantities");
        reportsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile2TextPanel.add(reportsTile2Subtitle);

        reportsTile2Panel.add(reportsTile2TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile2Status.setText("Module interface will be integrated here.");
        reportsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        reportsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reportsTile3TextPanel.add(reportsTile3Title);

        reportsTile3Subtitle.setText("Detect products at reorder level");
        reportsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile3TextPanel.add(reportsTile3Subtitle);

        reportsTile3Panel.add(reportsTile3TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile3Status.setText("Module interface will be integrated here.");
        reportsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        reportsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        reportsTile4TextPanel.add(reportsTile4Title);

        reportsTile4Subtitle.setText("Present generated report results");
        reportsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        reportsTile4TextPanel.add(reportsTile4Subtitle);

        reportsTile4Panel.add(reportsTile4TextPanel, java.awt.BorderLayout.NORTH);

        reportsTile4Status.setText("Module interface will be integrated here.");
        reportsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        reportsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reportsTile4Panel.add(reportsTile4Status, java.awt.BorderLayout.SOUTH);

        reportsTilesPanel.add(reportsTile4Panel);

        reportsDetailsPanel.add(reportsTilesPanel, java.awt.BorderLayout.CENTER);

        reportsModuleStatus.setText("Assigned developer: Methsindu   |   Placeholder screen - no database changes");
        reportsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        reportsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        emailsEyebrow.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        emailsIntroPanel.add(emailsEyebrow);

        emailsHeading.setText("Email Notification Center");
        emailsHeading.setForeground(new java.awt.Color(35, 55, 44));
        emailsHeading.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        emailsIntroPanel.add(emailsHeading);

        emailsDescription.setText("Track dispatch emails to clients and assignment emails to delivery agents.");
        emailsDescription.setForeground(new java.awt.Color(110, 128, 117));
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
        emailsTile1Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailsTile1TextPanel.add(emailsTile1Title);

        emailsTile1Subtitle.setText("Notify clients when an order dispatches");
        emailsTile1Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile1TextPanel.add(emailsTile1Subtitle);

        emailsTile1Panel.add(emailsTile1TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile1Status.setText("Module interface will be integrated here.");
        emailsTile1Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile1Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        emailsTile2Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailsTile2TextPanel.add(emailsTile2Title);

        emailsTile2Subtitle.setText("Notify assigned delivery agents");
        emailsTile2Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile2TextPanel.add(emailsTile2Subtitle);

        emailsTile2Panel.add(emailsTile2TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile2Status.setText("Module interface will be integrated here.");
        emailsTile2Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile2Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        emailsTile3Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailsTile3TextPanel.add(emailsTile3Title);

        emailsTile3Subtitle.setText("Pending, sent and failed attempts");
        emailsTile3Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile3TextPanel.add(emailsTile3Subtitle);

        emailsTile3Panel.add(emailsTile3TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile3Status.setText("Module interface will be integrated here.");
        emailsTile3Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile3Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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
        emailsTile4Title.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emailsTile4TextPanel.add(emailsTile4Title);

        emailsTile4Subtitle.setText("Record attempts and failure reasons");
        emailsTile4Subtitle.setForeground(new java.awt.Color(110, 128, 117));
        emailsTile4TextPanel.add(emailsTile4Subtitle);

        emailsTile4Panel.add(emailsTile4TextPanel, java.awt.BorderLayout.NORTH);

        emailsTile4Status.setText("Module interface will be integrated here.");
        emailsTile4Status.setForeground(new java.awt.Color(66, 130, 97));
        emailsTile4Status.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        emailsTile4Panel.add(emailsTile4Status, java.awt.BorderLayout.SOUTH);

        emailsTilesPanel.add(emailsTile4Panel);

        emailsDetailsPanel.add(emailsTilesPanel, java.awt.BorderLayout.CENTER);

        emailsModuleStatus.setText("Assigned developer: Methsindu   |   Placeholder screen - no database changes");
        emailsModuleStatus.setForeground(new java.awt.Color(110, 128, 117));
        emailsModuleStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        emailsModuleStatus.setPreferredSize(new java.awt.Dimension(700, 47));
        emailsModuleStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(13, 0, 5, 0));
        emailsDetailsPanel.add(emailsModuleStatus, java.awt.BorderLayout.SOUTH);

        emailsPage.add(emailsDetailsPanel, java.awt.BorderLayout.CENTER);

        contentPanel.add(emailsPage, "emails");

        workspacePanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        statusLabel.setText("EcoNest POS  |  Dashboard  |  Local workspace");
        statusLabel.setForeground(new java.awt.Color(110, 128, 117));
        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { }
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agentsDescription;
    private javax.swing.JPanel agentsDetailsPanel;
    private javax.swing.JLabel agentsEyebrow;
    private javax.swing.JLabel agentsHeading;
    private javax.swing.JPanel agentsIntroPanel;
    private javax.swing.JLabel agentsModuleStatus;
    private javax.swing.JPanel agentsPage;
    private javax.swing.JPanel agentsTile1Panel;
    private javax.swing.JLabel agentsTile1Status;
    private javax.swing.JLabel agentsTile1Subtitle;
    private javax.swing.JPanel agentsTile1TextPanel;
    private javax.swing.JLabel agentsTile1Title;
    private javax.swing.JPanel agentsTile2Panel;
    private javax.swing.JLabel agentsTile2Status;
    private javax.swing.JLabel agentsTile2Subtitle;
    private javax.swing.JPanel agentsTile2TextPanel;
    private javax.swing.JLabel agentsTile2Title;
    private javax.swing.JPanel agentsTile3Panel;
    private javax.swing.JLabel agentsTile3Status;
    private javax.swing.JLabel agentsTile3Subtitle;
    private javax.swing.JPanel agentsTile3TextPanel;
    private javax.swing.JLabel agentsTile3Title;
    private javax.swing.JPanel agentsTile4Panel;
    private javax.swing.JLabel agentsTile4Status;
    private javax.swing.JLabel agentsTile4Subtitle;
    private javax.swing.JPanel agentsTile4TextPanel;
    private javax.swing.JLabel agentsTile4Title;
    private javax.swing.JPanel agentsTilesPanel;
    private javax.swing.JPanel brandPanel;
    private javax.swing.JLabel brandTaglineLabel;
    private javax.swing.JLabel brandTitleLabel;
    private javax.swing.JButton btnClients;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDeliveries;
    private javax.swing.JButton btnDeliveryAgents;
    private javax.swing.JButton btnEmailNotifications;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnReports;
    private javax.swing.JLabel clientsDescription;
    private javax.swing.JPanel clientsDetailsPanel;
    private javax.swing.JLabel clientsEyebrow;
    private javax.swing.JLabel clientsHeading;
    private javax.swing.JPanel clientsIntroPanel;
    private javax.swing.JLabel clientsModuleStatus;
    private javax.swing.JPanel clientsPage;
    private javax.swing.JPanel clientsTile1Panel;
    private javax.swing.JLabel clientsTile1Status;
    private javax.swing.JLabel clientsTile1Subtitle;
    private javax.swing.JPanel clientsTile1TextPanel;
    private javax.swing.JLabel clientsTile1Title;
    private javax.swing.JPanel clientsTile2Panel;
    private javax.swing.JLabel clientsTile2Status;
    private javax.swing.JLabel clientsTile2Subtitle;
    private javax.swing.JPanel clientsTile2TextPanel;
    private javax.swing.JLabel clientsTile2Title;
    private javax.swing.JPanel clientsTile3Panel;
    private javax.swing.JLabel clientsTile3Status;
    private javax.swing.JLabel clientsTile3Subtitle;
    private javax.swing.JPanel clientsTile3TextPanel;
    private javax.swing.JLabel clientsTile3Title;
    private javax.swing.JPanel clientsTile4Panel;
    private javax.swing.JLabel clientsTile4Status;
    private javax.swing.JLabel clientsTile4Subtitle;
    private javax.swing.JPanel clientsTile4TextPanel;
    private javax.swing.JLabel clientsTile4Title;
    private javax.swing.JPanel clientsTilesPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel dashboardPage;
    private javax.swing.JLabel deliveriesDescription;
    private javax.swing.JPanel deliveriesDetailsPanel;
    private javax.swing.JLabel deliveriesEyebrow;
    private javax.swing.JLabel deliveriesHeading;
    private javax.swing.JPanel deliveriesIntroPanel;
    private javax.swing.JLabel deliveriesModuleStatus;
    private javax.swing.JPanel deliveriesPage;
    private javax.swing.JPanel deliveriesTile1Panel;
    private javax.swing.JLabel deliveriesTile1Status;
    private javax.swing.JLabel deliveriesTile1Subtitle;
    private javax.swing.JPanel deliveriesTile1TextPanel;
    private javax.swing.JLabel deliveriesTile1Title;
    private javax.swing.JPanel deliveriesTile2Panel;
    private javax.swing.JLabel deliveriesTile2Status;
    private javax.swing.JLabel deliveriesTile2Subtitle;
    private javax.swing.JPanel deliveriesTile2TextPanel;
    private javax.swing.JLabel deliveriesTile2Title;
    private javax.swing.JPanel deliveriesTile3Panel;
    private javax.swing.JLabel deliveriesTile3Status;
    private javax.swing.JLabel deliveriesTile3Subtitle;
    private javax.swing.JPanel deliveriesTile3TextPanel;
    private javax.swing.JLabel deliveriesTile3Title;
    private javax.swing.JPanel deliveriesTile4Panel;
    private javax.swing.JLabel deliveriesTile4Status;
    private javax.swing.JLabel deliveriesTile4Subtitle;
    private javax.swing.JPanel deliveriesTile4TextPanel;
    private javax.swing.JLabel deliveriesTile4Title;
    private javax.swing.JPanel deliveriesTilesPanel;
    private javax.swing.JLabel emailsDescription;
    private javax.swing.JPanel emailsDetailsPanel;
    private javax.swing.JLabel emailsEyebrow;
    private javax.swing.JLabel emailsHeading;
    private javax.swing.JPanel emailsIntroPanel;
    private javax.swing.JLabel emailsModuleStatus;
    private javax.swing.JPanel emailsPage;
    private javax.swing.JPanel emailsTile1Panel;
    private javax.swing.JLabel emailsTile1Status;
    private javax.swing.JLabel emailsTile1Subtitle;
    private javax.swing.JPanel emailsTile1TextPanel;
    private javax.swing.JLabel emailsTile1Title;
    private javax.swing.JPanel emailsTile2Panel;
    private javax.swing.JLabel emailsTile2Status;
    private javax.swing.JLabel emailsTile2Subtitle;
    private javax.swing.JPanel emailsTile2TextPanel;
    private javax.swing.JLabel emailsTile2Title;
    private javax.swing.JPanel emailsTile3Panel;
    private javax.swing.JLabel emailsTile3Status;
    private javax.swing.JLabel emailsTile3Subtitle;
    private javax.swing.JPanel emailsTile3TextPanel;
    private javax.swing.JLabel emailsTile3Title;
    private javax.swing.JPanel emailsTile4Panel;
    private javax.swing.JLabel emailsTile4Status;
    private javax.swing.JLabel emailsTile4Subtitle;
    private javax.swing.JPanel emailsTile4TextPanel;
    private javax.swing.JLabel emailsTile4Title;
    private javax.swing.JPanel emailsTilesPanel;
    private javax.swing.JLabel headerModeLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel headerSubtitleLabel;
    private javax.swing.JPanel headerTitleBlock;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JLabel heroDescriptionLabel;
    private javax.swing.JLabel heroEyebrowLabel;
    private javax.swing.JLabel heroHeadlineLabel;
    private javax.swing.JPanel heroPanel;
    private javax.swing.JPanel heroTextPanel;
    private javax.swing.JPanel homeBodyPanel;
    private javax.swing.JLabel inventoryDescription;
    private javax.swing.JPanel inventoryDetailsPanel;
    private javax.swing.JLabel inventoryEyebrow;
    private javax.swing.JLabel inventoryHeading;
    private javax.swing.JPanel inventoryIntroPanel;
    private javax.swing.JLabel inventoryModuleStatus;
    private javax.swing.JPanel inventoryPage;
    private javax.swing.JPanel inventoryTile1Panel;
    private javax.swing.JLabel inventoryTile1Status;
    private javax.swing.JLabel inventoryTile1Subtitle;
    private javax.swing.JPanel inventoryTile1TextPanel;
    private javax.swing.JLabel inventoryTile1Title;
    private javax.swing.JPanel inventoryTile2Panel;
    private javax.swing.JLabel inventoryTile2Status;
    private javax.swing.JLabel inventoryTile2Subtitle;
    private javax.swing.JPanel inventoryTile2TextPanel;
    private javax.swing.JLabel inventoryTile2Title;
    private javax.swing.JPanel inventoryTile3Panel;
    private javax.swing.JLabel inventoryTile3Status;
    private javax.swing.JLabel inventoryTile3Subtitle;
    private javax.swing.JPanel inventoryTile3TextPanel;
    private javax.swing.JLabel inventoryTile3Title;
    private javax.swing.JPanel inventoryTile4Panel;
    private javax.swing.JLabel inventoryTile4Status;
    private javax.swing.JLabel inventoryTile4Subtitle;
    private javax.swing.JPanel inventoryTile4TextPanel;
    private javax.swing.JLabel inventoryTile4Title;
    private javax.swing.JPanel inventoryTilesPanel;
    private javax.swing.JPanel metricGridPanel;
    private javax.swing.JLabel metricInventoryCaption;
    private javax.swing.JPanel metricInventoryPanel;
    private javax.swing.JLabel metricInventoryTitle;
    private javax.swing.JLabel metricInventoryValue;
    private javax.swing.JLabel metricOrdersCaption;
    private javax.swing.JPanel metricOrdersPanel;
    private javax.swing.JLabel metricOrdersTitle;
    private javax.swing.JLabel metricOrdersValue;
    private javax.swing.JLabel metricProductsCaption;
    private javax.swing.JPanel metricProductsPanel;
    private javax.swing.JLabel metricProductsTitle;
    private javax.swing.JLabel metricProductsValue;
    private javax.swing.JLabel metricSalesCaption;
    private javax.swing.JPanel metricSalesPanel;
    private javax.swing.JLabel metricSalesTitle;
    private javax.swing.JLabel metricSalesValue;
    private javax.swing.JPanel metricsHeadingPanel;
    private javax.swing.JLabel metricsHeadingPanelCaption;
    private javax.swing.JLabel metricsHeadingPanelTitle;
    private javax.swing.JPanel metricsSectionPanel;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JLabel ordersDescription;
    private javax.swing.JPanel ordersDetailsPanel;
    private javax.swing.JLabel ordersEyebrow;
    private javax.swing.JLabel ordersHeading;
    private javax.swing.JPanel ordersIntroPanel;
    private javax.swing.JLabel ordersModuleStatus;
    private javax.swing.JPanel ordersPage;
    private javax.swing.JPanel ordersTile1Panel;
    private javax.swing.JLabel ordersTile1Status;
    private javax.swing.JLabel ordersTile1Subtitle;
    private javax.swing.JPanel ordersTile1TextPanel;
    private javax.swing.JLabel ordersTile1Title;
    private javax.swing.JPanel ordersTile2Panel;
    private javax.swing.JLabel ordersTile2Status;
    private javax.swing.JLabel ordersTile2Subtitle;
    private javax.swing.JPanel ordersTile2TextPanel;
    private javax.swing.JLabel ordersTile2Title;
    private javax.swing.JPanel ordersTile3Panel;
    private javax.swing.JLabel ordersTile3Status;
    private javax.swing.JLabel ordersTile3Subtitle;
    private javax.swing.JPanel ordersTile3TextPanel;
    private javax.swing.JLabel ordersTile3Title;
    private javax.swing.JPanel ordersTile4Panel;
    private javax.swing.JLabel ordersTile4Status;
    private javax.swing.JLabel ordersTile4Subtitle;
    private javax.swing.JPanel ordersTile4TextPanel;
    private javax.swing.JLabel ordersTile4Title;
    private javax.swing.JPanel ordersTilesPanel;
    private javax.swing.JLabel productsDescription;
    private javax.swing.JPanel productsDetailsPanel;
    private javax.swing.JLabel productsEyebrow;
    private javax.swing.JLabel productsHeading;
    private javax.swing.JPanel productsIntroPanel;
    private javax.swing.JLabel productsModuleStatus;
    private javax.swing.JPanel productsPage;
    private javax.swing.JPanel productsTile1Panel;
    private javax.swing.JLabel productsTile1Status;
    private javax.swing.JLabel productsTile1Subtitle;
    private javax.swing.JPanel productsTile1TextPanel;
    private javax.swing.JLabel productsTile1Title;
    private javax.swing.JPanel productsTile2Panel;
    private javax.swing.JLabel productsTile2Status;
    private javax.swing.JLabel productsTile2Subtitle;
    private javax.swing.JPanel productsTile2TextPanel;
    private javax.swing.JLabel productsTile2Title;
    private javax.swing.JPanel productsTile3Panel;
    private javax.swing.JLabel productsTile3Status;
    private javax.swing.JLabel productsTile3Subtitle;
    private javax.swing.JPanel productsTile3TextPanel;
    private javax.swing.JLabel productsTile3Title;
    private javax.swing.JPanel productsTile4Panel;
    private javax.swing.JLabel productsTile4Status;
    private javax.swing.JLabel productsTile4Subtitle;
    private javax.swing.JPanel productsTile4TextPanel;
    private javax.swing.JLabel productsTile4Title;
    private javax.swing.JPanel productsTilesPanel;
    private javax.swing.JPanel quickGridPanel;
    private javax.swing.JPanel quickHeadingPanel;
    private javax.swing.JLabel quickHeadingPanelCaption;
    private javax.swing.JLabel quickHeadingPanelTitle;
    private javax.swing.JButton quickInventoryButton;
    private javax.swing.JLabel quickInventoryCaption;
    private javax.swing.JPanel quickInventoryPanel;
    private javax.swing.JPanel quickInventoryTextPanel;
    private javax.swing.JLabel quickInventoryTitle;
    private javax.swing.JButton quickOrdersButton;
    private javax.swing.JLabel quickOrdersCaption;
    private javax.swing.JPanel quickOrdersPanel;
    private javax.swing.JPanel quickOrdersTextPanel;
    private javax.swing.JLabel quickOrdersTitle;
    private javax.swing.JButton quickProductsButton;
    private javax.swing.JLabel quickProductsCaption;
    private javax.swing.JPanel quickProductsPanel;
    private javax.swing.JPanel quickProductsTextPanel;
    private javax.swing.JLabel quickProductsTitle;
    private javax.swing.JButton quickReportsButton;
    private javax.swing.JLabel quickReportsCaption;
    private javax.swing.JPanel quickReportsPanel;
    private javax.swing.JPanel quickReportsTextPanel;
    private javax.swing.JLabel quickReportsTitle;
    private javax.swing.JPanel quickSectionPanel;
    private javax.swing.JLabel reportsDescription;
    private javax.swing.JPanel reportsDetailsPanel;
    private javax.swing.JLabel reportsEyebrow;
    private javax.swing.JLabel reportsHeading;
    private javax.swing.JPanel reportsIntroPanel;
    private javax.swing.JLabel reportsModuleStatus;
    private javax.swing.JPanel reportsPage;
    private javax.swing.JPanel reportsTile1Panel;
    private javax.swing.JLabel reportsTile1Status;
    private javax.swing.JLabel reportsTile1Subtitle;
    private javax.swing.JPanel reportsTile1TextPanel;
    private javax.swing.JLabel reportsTile1Title;
    private javax.swing.JPanel reportsTile2Panel;
    private javax.swing.JLabel reportsTile2Status;
    private javax.swing.JLabel reportsTile2Subtitle;
    private javax.swing.JPanel reportsTile2TextPanel;
    private javax.swing.JLabel reportsTile2Title;
    private javax.swing.JPanel reportsTile3Panel;
    private javax.swing.JLabel reportsTile3Status;
    private javax.swing.JLabel reportsTile3Subtitle;
    private javax.swing.JPanel reportsTile3TextPanel;
    private javax.swing.JLabel reportsTile3Title;
    private javax.swing.JPanel reportsTile4Panel;
    private javax.swing.JLabel reportsTile4Status;
    private javax.swing.JLabel reportsTile4Subtitle;
    private javax.swing.JPanel reportsTile4TextPanel;
    private javax.swing.JLabel reportsTile4Title;
    private javax.swing.JPanel reportsTilesPanel;
    private javax.swing.JLabel sidebarFooterLabel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel workspacePanel;
    // End of variables declaration//GEN-END:variables
}
