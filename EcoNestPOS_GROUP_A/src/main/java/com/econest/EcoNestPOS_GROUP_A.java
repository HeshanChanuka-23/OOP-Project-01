package com.econest;

import com.econest.ui.MainDashboard;
import javax.swing.SwingUtilities;

/** Main entry point of EcoNest POS (NetBeans Maven Run Project). */
public class EcoNestPOS_GROUP_A {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}
