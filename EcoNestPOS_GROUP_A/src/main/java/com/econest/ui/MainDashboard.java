package com.econest.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * EcoNest shared dashboard. The outer shell is editable using NetBeans GUI Builder.
 * Each module is added to the center content area using CardLayout.
 * No database writes or sample records are performed by this class.
 */
public class MainDashboard extends javax.swing.JFrame {

    private static final Color FOREST = new Color(24, 55, 45);
    private static final Color FOREST_LIGHT = new Color(40, 83, 65);
    private static final Color SOFT_GREEN = new Color(225, 244, 231);
    private static final Color CANVAS = new Color(246, 249, 247);
    private static final Color INK = new Color(35, 55, 44);
    private static final Color MUTED = new Color(110, 128, 117);
    private static final Color WHITE = Color.WHITE;

    private final CardLayout cards = new CardLayout();
    private final JPanel cardContainer = new ScrollableCards(cards);
    private final Map<String, JButton> navigationButtons = new LinkedHashMap<>();

    /** Creates the EcoNest shared interface. */
    public MainDashboard() {
        initComponents();
        configureAppearance();
        installNavigation();
        installDefaultPages();
        showPage("Dashboard");
        setMinimumSize(new Dimension(960, 640));
        setSize(1220, 780);
        setLocationRelativeTo(null);
    }

    /**
     * Connect a teammate's complete JPanel to this dashboard later.
     * Example: dashboard.registerModule("Products", new ProductPanel());
     */
    public void registerModule(String pageName, JPanel modulePanel) {
        if (pageName == null || modulePanel == null || !navigationButtons.containsKey(pageName)) {
            throw new IllegalArgumentException("Unknown page or null panel: " + pageName);
        }
        cardContainer.add(modulePanel, pageName);
        cardContainer.revalidate();
        cardContainer.repaint();
    }

    /** Display an existing page in the central workspace. */
    public void showPage(String pageName) {
        JButton activeButton = navigationButtons.get(pageName);
        if (activeButton == null) {
            throw new IllegalArgumentException("Unknown page: " + pageName);
        }
        cards.show(cardContainer, pageName);
        headerTitleLabel.setText(pageName.equals("Dashboard") ? "Overview Dashboard" : pageName);
        headerSubtitleLabel.setText(pageName.equals("Dashboard")
                ? "Your sustainable retail workspace"
                : "EcoNest POS / " + pageName);
        for (Map.Entry<String, JButton> entry : navigationButtons.entrySet()) {
            boolean selected = entry.getKey().equals(pageName);
            JButton button = entry.getValue();
            button.setBackground(selected ? FOREST_LIGHT : FOREST);
            button.setForeground(selected ? WHITE : new Color(211, 230, 218));
            button.setFont(new Font("Segoe UI", selected ? Font.BOLD : Font.PLAIN, 13));
        }
        statusLabel.setText("EcoNest POS  |  " + pageName + "  |  Local workspace");
    }

    private void configureAppearance() {
        sidebarPanel.setBackground(FOREST);
        brandPanel.setBackground(FOREST);
        navigationPanel.setBackground(FOREST);
        sidebarFooterLabel.setOpaque(true);
        sidebarFooterLabel.setBackground(FOREST);
        sidebarFooterLabel.setBorder(new EmptyBorder(0, 22, 18, 0));
        brandPanel.setBorder(new EmptyBorder(25, 23, 22, 12));
        navigationPanel.setBorder(new EmptyBorder(10, 14, 10, 14));
        headerPanel.setBorder(new EmptyBorder(15, 28, 15, 27));
        headerPanel.setBackground(WHITE);
        headerTitleBlock.setBackground(WHITE);
        headerModeLabel.setOpaque(true);
        headerModeLabel.setBackground(SOFT_GREEN);
        headerModeLabel.setForeground(new Color(30, 100, 59));
        headerModeLabel.setBorder(new EmptyBorder(9, 15, 9, 15));
        headerModeLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentPanel.setBackground(CANVAS);
        statusLabel.setOpaque(true);
        statusLabel.setBackground(WHITE);
        statusLabel.setBorder(new EmptyBorder(10, 28, 10, 10));
        for (JButton button : new JButton[] {btnDashboard, btnProducts, btnInventory,
                btnClients, btnDeliveryAgents, btnOrders, btnDeliveries,
                btnReports, btnEmailNotifications}) {
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setContentAreaFilled(true);
            button.setOpaque(true);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setMargin(new Insets(8, 18, 8, 4));
            button.setBorder(BorderFactory.createEmptyBorder(9, 18, 9, 6));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    private void installNavigation() {
        addNavigation("Dashboard", btnDashboard);
        addNavigation("Products", btnProducts);
        addNavigation("Inventory", btnInventory);
        addNavigation("Clients", btnClients);
        addNavigation("Delivery Agents", btnDeliveryAgents);
        addNavigation("Orders", btnOrders);
        addNavigation("Deliveries", btnDeliveries);
        addNavigation("Reports", btnReports);
        addNavigation("Email Notifications", btnEmailNotifications);
    }

    private void addNavigation(String pageName, JButton button) {
        navigationButtons.put(pageName, button);
        button.addActionListener(e -> showPage(pageName));
    }

    private void installDefaultPages() {
        cardContainer.setBackground(CANVAS);
        cardContainer.add(createDashboardPage(), "Dashboard");
        cardContainer.add(createPlaceholderPage("Products", "Product Catalogue", "Heshan",
                "Add, update and remove plants, planters and gardening kits.",
                "Pricing and eco-ratings", "Product search and validation", "Historical product snapshots"), "Products");
        cardContainer.add(createPlaceholderPage("Inventory", "Inventory Management", "Heshan",
                "Track stock quantities, suppliers and stock-in transactions.",
                "Reorder thresholds", "Stock movement history", "Stock-in and write-off rules"), "Inventory");
        cardContainer.add(createPlaceholderPage("Clients", "Client Management", "Piyathissa",
                "Manage household and office clients and their contact details.",
                "Register and update clients", "Customer history", "Safe client removal"), "Clients");
        cardContainer.add(createPlaceholderPage("Delivery Agents", "Delivery Agent Management", "Piyathissa",
                "Maintain agent contact information and vehicle details.",
                "Agent profiles", "Vehicle identification", "Historical assignments"), "Delivery Agents");
        cardContainer.add(createPlaceholderPage("Orders", "Client Order Processing", "Shanika",
                "Create orders, choose products and calculate totals.",
                "Order items and price snapshots", "Atomic inventory deduction", "Order confirmation and cancellation"), "Orders");
        cardContainer.add(createPlaceholderPage("Deliveries", "Delivery Scheduling", "Shanika",
                "Assign agents, schedule dispatches and update delivery statuses.",
                "Assignment and reassignment", "Delivery lifecycle", "Dispatch and completion history"), "Deliveries");
        cardContainer.add(createPlaceholderPage("Reports", "Monthly Reporting", "Methsindu",
                "Generate monthly sales, inventory and low-stock reports.",
                "Net monthly revenue", "Month-end stock calculations", "Low-stock alerts"), "Reports");
        cardContainer.add(createPlaceholderPage("Email Notifications", "Email Notification Center", "Methsindu",
                "Email clients when orders dispatch and agents on assignment.",
                "Pending/sent/failed status", "Durable retry queue", "Notification history"), "Email Notifications");

        JScrollPane mainScroll = new JScrollPane(cardContainer);
        mainScroll.setBorder(BorderFactory.createEmptyBorder());
        mainScroll.getViewport().setBackground(CANVAS);
        mainScroll.getVerticalScrollBar().setUnitIncrement(15);
        contentPanel.add(mainScroll, BorderLayout.CENTER);
    }

    private JPanel createDashboardPage() {
        JPanel outer = pageColumn();
        outer.add(welcomeCard(), row(0, 23));
        outer.add(sectionHeading("At a glance", "Values will update when the real module DAOs are connected."), row(1, 13));
        JPanel metrics = new JPanel(new GridLayout(1, 4, 14, 0));
        metrics.setOpaque(false);
        metrics.setPreferredSize(new Dimension(740, 128));
        metrics.add(metricCard("PRODUCTS", "—", "Catalogue items"));
        metrics.add(metricCard("INVENTORY", "—", "Units available"));
        metrics.add(metricCard("ORDERS", "—", "Orders recorded"));
        metrics.add(metricCard("SALES", "—", "Monthly revenue"));
        outer.add(metrics, row(2, 25));
        outer.add(sectionHeading("Quick access", "Open any workspace below to begin integrating your team's module."), row(3, 13));
        JPanel shortcuts = new JPanel(new GridLayout(2, 2, 14, 14));
        shortcuts.setOpaque(false);
        shortcuts.setPreferredSize(new Dimension(740, 180));
        shortcuts.add(shortcut("Product catalogue", "Manage plants, planters and kits", "Products"));
        shortcuts.add(shortcut("Inventory control", "Monitor stock and supplier entries", "Inventory"));
        shortcuts.add(shortcut("Order management", "Process and track customer orders", "Orders"));
        shortcuts.add(shortcut("Sales reporting", "Review monthly performance", "Reports"));
        outer.add(shortcuts, row(4, 0));
        GridBagConstraints fill = row(5, 0);
        fill.weighty = 1;
        outer.add(new JPanel() {{setOpaque(false);}}, fill);
        return outer;
    }

    private JPanel createPlaceholderPage(String pageName, String title, String owner,
            String description, String f1, String f2, String f3) {
        JPanel page = pageColumn();
        JPanel heading = new JPanel(new GridLayout(2, 1, 0, 6));
        heading.setOpaque(false);
        heading.setPreferredSize(new Dimension(700, 82));
        JLabel kicker = label("MODULE WORKSPACE   /   " + owner.toUpperCase(), 12, Font.BOLD, new Color(50, 126, 76));
        JLabel name = label(title, 27, Font.BOLD, INK);
        heading.add(kicker);
        heading.add(name);
        page.add(heading, row(0, 20));
        JPanel box = new RoundedPanel(WHITE, 18);
        box.setLayout(new BorderLayout(0, 20));
        box.setBorder(new EmptyBorder(26, 26, 26, 26));
        box.setPreferredSize(new Dimension(700, 290));
        JLabel descriptionLabel = label("<html><body style='width:470px'>" + escapeHtml(description)
                + "</body></html>", 15, Font.PLAIN, MUTED);
        box.add(descriptionLabel, BorderLayout.NORTH);
        JPanel features = new JPanel(new GridLayout(3, 1, 0, 12));
        features.setOpaque(false);
        for (String feature : new String[]{f1, f2, f3}) {
            JPanel featureRow = new JPanel(new BorderLayout(12, 0));
            featureRow.setOpaque(false);
            featureRow.add(label("  ✓", 15, Font.BOLD, new Color(48, 123, 74)), BorderLayout.WEST);
            featureRow.add(label(feature, 14, Font.PLAIN, INK), BorderLayout.CENTER);
            features.add(featureRow);
        }
        box.add(features, BorderLayout.CENTER);
        JLabel note = label("UI placeholder  •  No database action is performed here yet", 12, Font.PLAIN, MUTED);
        box.add(note, BorderLayout.SOUTH);
        page.add(box, row(1, 0));
        GridBagConstraints fill = row(2, 0);
        fill.weighty = 1;
        page.add(new JPanel() {{setOpaque(false);}}, fill);
        return page;
    }

    private JPanel pageColumn() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(CANVAS);
        panel.setBorder(new EmptyBorder(28, 30, 34, 30));
        return panel;
    }

    private GridBagConstraints row(int y, int bottomGap) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = y;
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, bottomGap, 0);
        return c;
    }

    private JPanel welcomeCard() {
        JPanel hero = new RoundedPanel(FOREST_LIGHT, 18);
        hero.setLayout(new BorderLayout());
        hero.setBorder(new EmptyBorder(23, 27, 24, 27));
        hero.setAlignmentX(LEFT_ALIGNMENT);
        hero.setPreferredSize(new Dimension(740, 145));
        JPanel words = new JPanel();
        words.setLayout(new BoxLayout(words, BoxLayout.Y_AXIS));
        words.setOpaque(false);
        words.add(label("ECONEST  /  MANAGEMENT SYSTEM", 11, Font.BOLD, new Color(181, 223, 189)));
        words.add(Box.createVerticalStrut(11));
        words.add(label("Grow a better business.", 27, Font.BOLD, WHITE));
        words.add(Box.createVerticalStrut(7));
        words.add(label("One place for products, inventory, orders and deliveries.", 14, Font.PLAIN, new Color(222, 239, 226)));
        hero.add(words, BorderLayout.CENTER);
        JLabel tag = label("  ECO-FRIENDLY POS  ", 11, Font.BOLD, new Color(196, 240, 205));
        tag.setVerticalAlignment(SwingConstants.TOP);
        hero.add(tag, BorderLayout.EAST);
        return hero;
    }

    private JPanel sectionHeading(String heading, String sub) {
        JPanel section = new JPanel(new GridLayout(2, 1, 0, 6));
        section.setOpaque(false);
        section.setAlignmentX(LEFT_ALIGNMENT);
        section.setPreferredSize(new Dimension(740, 53));
        section.add(label(heading, 19, Font.BOLD, INK));
        section.add(label(sub, 12, Font.PLAIN, MUTED));
        return section;
    }

    private JPanel metricCard(String name, String value, String detail) {
        JPanel card = new RoundedPanel(WHITE, 15);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(17, 18, 16, 13));
        card.add(label(name, 11, Font.BOLD, MUTED));
        card.add(Box.createVerticalStrut(9));
        card.add(label(value, 27, Font.BOLD, INK));
        card.add(Box.createVerticalStrut(3));
        card.add(label(detail, 11, Font.PLAIN, MUTED));
        return card;
    }

    private JPanel shortcut(String name, String detail, String destination) {
        JPanel card = new RoundedPanel(WHITE, 15);
        card.setLayout(new BorderLayout());
        card.setBorder(new EmptyBorder(15, 19, 15, 15));
        JPanel text = new JPanel(new GridLayout(2, 1, 0, 3));
        text.setOpaque(false);
        text.add(label(name, 14, Font.BOLD, INK));
        text.add(label(detail, 11, Font.PLAIN, MUTED));
        card.add(text, BorderLayout.CENTER);
        JButton go = new JButton("Open ›");
        go.setBackground(SOFT_GREEN);
        go.setForeground(new Color(39, 102, 63));
        go.setFocusPainted(false);
        go.setBorderPainted(false);
        go.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        go.addActionListener(e -> showPage(destination));
        card.add(go, BorderLayout.EAST);
        return card;
    }

    private JLabel label(String text, int size, int weight, Color color) {
        JLabel result = new JLabel(text);
        result.setFont(new Font("Segoe UI", weight, size));
        result.setForeground(color);
        result.setAlignmentX(LEFT_ALIGNMENT);
        return result;
    }

    private static String escapeHtml(String input) {
        return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    /** Tracks the viewport width, so the main dashboard never needs a horizontal scrollbar. */
    private static class ScrollableCards extends JPanel implements Scrollable {
        ScrollableCards(CardLayout layout) { super(layout); }
        @Override public Dimension getPreferredScrollableViewportSize() { return getPreferredSize(); }
        @Override public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) { return 18; }
        @Override public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) { return 160; }
        @Override public boolean getScrollableTracksViewportWidth() { return true; }
        @Override public boolean getScrollableTracksViewportHeight() { return false; }
    }

    private static class RoundedPanel extends JPanel {
        private final Color fill;
        private final int radius;
        RoundedPanel(Color fill, int radius) {
            this.fill = fill;
            this.radius = radius;
            setOpaque(false);
        }
        @Override
        protected void paintComponent(java.awt.Graphics g) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
            g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(fill);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    /** NetBeans GUI Builder manages this generated section. */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoNest POS | Management System");
        getContentPane().setLayout(new java.awt.BorderLayout());

        sidebarPanel.setBackground(new java.awt.Color(24, 55, 45));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(235, 700));
        sidebarPanel.setLayout(new java.awt.BorderLayout());

        brandPanel.setBackground(new java.awt.Color(24, 55, 45));
        brandPanel.setPreferredSize(new java.awt.Dimension(235, 115));
        brandPanel.setLayout(new java.awt.GridLayout(2, 1));

        brandTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        brandTitleLabel.setForeground(new java.awt.Color(239, 250, 241));
        brandTitleLabel.setText("EcoNest  •");
        brandPanel.add(brandTitleLabel);

        brandTaglineLabel.setForeground(new java.awt.Color(176, 213, 190));
        brandTaglineLabel.setText("Sustainable retail POS");
        brandPanel.add(brandTaglineLabel);

        sidebarPanel.add(brandPanel, java.awt.BorderLayout.NORTH);

        navigationPanel.setBackground(new java.awt.Color(24, 55, 45));
        navigationPanel.setLayout(new java.awt.GridLayout(9, 1, 0, 5));

        btnDashboard.setBackground(new java.awt.Color(24, 55, 45));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(228, 238, 229));
        btnDashboard.setText("   Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        navigationPanel.add(btnDashboard);

        btnProducts.setBackground(new java.awt.Color(24, 55, 45));
        btnProducts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(228, 238, 229));
        btnProducts.setText("   Products");
        navigationPanel.add(btnProducts);

        btnInventory.setBackground(new java.awt.Color(24, 55, 45));
        btnInventory.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(228, 238, 229));
        btnInventory.setText("   Inventory");
        navigationPanel.add(btnInventory);

        btnClients.setBackground(new java.awt.Color(24, 55, 45));
        btnClients.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnClients.setForeground(new java.awt.Color(228, 238, 229));
        btnClients.setText("   Clients");
        navigationPanel.add(btnClients);

        btnDeliveryAgents.setBackground(new java.awt.Color(24, 55, 45));
        btnDeliveryAgents.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeliveryAgents.setForeground(new java.awt.Color(228, 238, 229));
        btnDeliveryAgents.setText("   Delivery Agents");
        navigationPanel.add(btnDeliveryAgents);

        btnOrders.setBackground(new java.awt.Color(24, 55, 45));
        btnOrders.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnOrders.setForeground(new java.awt.Color(228, 238, 229));
        btnOrders.setText("   Orders");
        navigationPanel.add(btnOrders);

        btnDeliveries.setBackground(new java.awt.Color(24, 55, 45));
        btnDeliveries.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnDeliveries.setForeground(new java.awt.Color(228, 238, 229));
        btnDeliveries.setText("   Deliveries");
        navigationPanel.add(btnDeliveries);

        btnReports.setBackground(new java.awt.Color(24, 55, 45));
        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnReports.setForeground(new java.awt.Color(228, 238, 229));
        btnReports.setText("   Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        navigationPanel.add(btnReports);

        btnEmailNotifications.setBackground(new java.awt.Color(24, 55, 45));
        btnEmailNotifications.setForeground(new java.awt.Color(228, 238, 229));
        btnEmailNotifications.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEmailNotifications.setText("   Email Notifications");
        navigationPanel.add(btnEmailNotifications);

        sidebarPanel.add(navigationPanel, java.awt.BorderLayout.CENTER);

        sidebarFooterLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        sidebarFooterLabel.setForeground(new java.awt.Color(176, 213, 190));
        sidebarFooterLabel.setText("Support - +94823228288");
        sidebarFooterLabel.setPreferredSize(new java.awt.Dimension(235, 47));
        sidebarPanel.add(sidebarFooterLabel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);

        workspacePanel.setBackground(new java.awt.Color(255, 255, 255));
        workspacePanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setPreferredSize(new java.awt.Dimension(700, 90));
        headerPanel.setLayout(new java.awt.BorderLayout());

        headerTitleBlock.setBackground(new java.awt.Color(255, 255, 255));
        headerTitleBlock.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        headerTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        headerTitleLabel.setForeground(new java.awt.Color(35, 55, 44));
        headerTitleLabel.setText("Overview Dashboard");
        headerTitleBlock.add(headerTitleLabel);

        headerSubtitleLabel.setForeground(new java.awt.Color(110, 128, 117));
        headerSubtitleLabel.setText("Your sustainable retail workspace");
        headerTitleBlock.add(headerSubtitleLabel);

        headerPanel.add(headerTitleBlock, java.awt.BorderLayout.CENTER);

        headerModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        headerModeLabel.setText("LOCAL WORKSPACE");
        headerPanel.add(headerModeLabel, java.awt.BorderLayout.EAST);

        workspacePanel.add(headerPanel, java.awt.BorderLayout.NORTH);

        contentPanel.setBackground(new java.awt.Color(246, 249, 247));
        contentPanel.setLayout(new java.awt.BorderLayout());
        workspacePanel.add(contentPanel, java.awt.BorderLayout.CENTER);

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(110, 128, 117));
        statusLabel.setText("EcoNest POS  |  Shared workspace");
        statusLabel.setPreferredSize(new java.awt.Dimension(700, 36));
        workspacePanel.add(statusLabel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(workspacePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDashboardActionPerformed

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Swing default look and feel is sufficient.
        }
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel headerModeLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel headerSubtitleLabel;
    private javax.swing.JPanel headerTitleBlock;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JLabel sidebarFooterLabel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel workspacePanel;
    // End of variables declaration//GEN-END:variables
}
