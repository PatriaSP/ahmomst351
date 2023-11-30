/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.frame;

import id.co.ahm.jx.common.frame.BaseFrame;
import id.co.ahm.mo.mst.app351.model.Mst351SearchDataHeader;
import id.co.ahm.mo.mst.app351.util.Mst351UtilRestTemplate;
import id.co.ahm.mo.mst.app351.vo.Mst351VoJson;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author patria
 */
public class MainFrame extends BaseFrame {

    /**
     * Creates new form MainFrame
     */
    private Ahmmomst351p01 Ahmmomst351panel01;
    private Ahmmomst351p02 Ahmmomst351panel02;

    ArrayList<Map<String, Object>> listStorLocation;

    ArrayList<Map<String, Object>> listShippingNomor;

    ArrayList<Map<String, Object>> listdataHeader;

    ArrayList<Map<String, Object>> listDataDetail;

    ArrayList<Map<String, Object>> listDataAccesories;

    ArrayList<Map<String, Object>> listDataDetailAccesories;

    ArrayList<Mst351SearchDataHeader> listDataModel;

    String jxid = "";
    String txId = "";
    String hostPath = "";
    String profile = "";
    String mstPath = "/imo03/ahmsvmomst351-ahs/rest/mo/mst351/";

    private static MainFrame instance;
    private boolean form2;
    private boolean exitOverride;

    public MainFrame() {
        initComponents();
        initialized();
        setTitleLbl("MAINTAIN SHIPPING LIST");
        try {
            hostPath = System.getProperty("jnlp.ahmmomst351.server");
            if (hostPath == null) {
                jxid = "CAw+fm0md7/DsLiNvbNtcyVdWmRmwqZNaBqJKHqVUcPc8AlKwRkoXBOKUOF8tBCoOM+tEiT5fjxiqqwHcJOUC/qHLj9uEXxbdrx9Vjz/AXtZ9tIW3WK9uDVlUKeI2SZADpIIKU2yTzcFQQS8OQkW+LgM/iV6v1wUPxNX+a5PUsVUTz0Tlq1LeWsn83SQNsGjtz5Okp2k3IMq2Z0fKK2nldGkecnDNEPSCgUrpmv0sdvKrsEjdaI/7VIhD+qhRxfcU24CspZFoit3J+BgD+9YyvUP/qaCAuOj9WVIy1R0gdwhwxpxA/vGhoN++fsg57Kn9Cn+g8pMXLlb5q4v9KRtcZG9N8sCJ0UdJerG6aPeUEnhY4GB9olg7IxGkemrxUNtVYlajcXF+2k2LfkE4i37MoAZ5FmyHXYbHrTQs3CpqxMTsiQabgJvhj2I3OYohXSoFZTCVsoMbfTX7MVMpVPcXGq6Z+o7WWzYq1+bcBZxxtlwX+VrNj1C1Ssmnvm4zfUac78p5gODEg5B7Y/keBMMsm1EBulD52+GZkebUspcngsUFcQl/Qq5m58V1Mu3DoCAd8Uh6/xpdzS6IZnQNC9clI+YCS305GmGhZh1SWQ2rpZ8erEbpZedaZRidILbis9/ummV/r9hcZ9MRi+waHTX44VeY2WFxEhGVpXTesrcU3CJ04llP6PkJvqpkMLnmCdbv7yin6nuwfKacvn8iW1A9MH8nnemXAeWXMaBoPbzRT86vziX6ZxqhoQui4qJLW1zK0O74ZVHcsouFuV4FyNqGs9h5FpMd1wSnlk9HY/K4n5VQSxySA4Ns3pjTij2/UJRhD5FRDTJSs0LxFdiP0pKvjY6D34HCR7UsinVEhA6JoNurIQVvpBxnBUvYeVgPLWO782TErESVx9l5SsE+lU3I8VYhOIMsb4fVUWw68EvmC8Mr5FBSA8K542ZD1+RYw1eMON1F93V0YsXDikSELin7qeRMG1a80eryobSEZITEcNirjQLqfSs4FdP8TeWq6tTIJs/QrXL6094Iwh4yQI3+CyS8xMHo/mAuRhft1pI70Sjll9fNwjgR4ZwZBow8OS+ApQnGqWfKtqPR7XEu+AVlWCYGKQJtZ0VJAxQ9wm7yQP3AcfafQ4J5fIL8QA0wxIYUTWBThN3sLkDOqY2vVW0uA==";
                txId = "28a6852b-8470-4b18-a507-8a7d6438acca";
                hostPath = "http://localhost:8080";
                this.setTitle("ahmmomst351 - Maintain Shipping List");
                profile = "Development";
            } else {
                jxid = System.getProperty("jnlp.ahmmomst351.JXID");
                txId = System.getProperty("jnlp.ahmmomst351.TKID");
                this.setTitle(System.getProperty("jnlp.ahmmomst351.kodeAplikasi") + " - " + System.getProperty("jnlp.ahmmomst351.judulAplikasi"));
                profile = System.getProperty("jnlp.ahmmomst351.profile");
            }
//            initTimer();
            instance = this;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mst351VoJson vo = Mst351UtilRestTemplate.postService(new Mst351VoJson(), jxid, txId, hostPath + mstPath + "get-user");
        if (vo != null) {
            if (vo.getStatus().equals("1")) {
                ArrayList<Map<String, Object>> data = new ArrayList<>();
                data = (ArrayList<Map<String, Object>>) vo.getData();
                if (data.size() > 0) {
                    setUser(((Map) data.get(0)).get("userName").toString(), ((Map) data.get(0)).get("userId").toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error get user login", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        this.form2 = false;
        initListener();
        instance = this;

    }

    private void initListener() {
        getBtnClear().registerKeyboardAction(getBtnClear().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        getBtnClear().registerKeyboardAction(getBtnClear().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        getBtnClear().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!MainFrame.this.form2) {
                    MainFrame.this.Ahmmomst351panel01.clearScreen();
                } else if (MainFrame.this.form2) {

                }
            }
        });
        getBtnClose().registerKeyboardAction(getBtnClose().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        getBtnClose().registerKeyboardAction(getBtnClose().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        getBtnClose().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.exitOverride = false;
            }
        });
        getBtnPrint().registerKeyboardAction(getBtnPrint().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        getBtnPrint().registerKeyboardAction(getBtnPrint().getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        getBtnPrint().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!MainFrame.this.form2) {
                    MainFrame.this.exitOverride = false;
                    MainFrame.this.Ahmmomst351panel01.printReport();
                }
            }
        });
    }

    private void initialized() {
        Ahmmomst351panel01 = new Ahmmomst351p01();
        addPanel(Ahmmomst351panel01);
        Ahmmomst351panel01.setVisible(true);
    }

    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "-";
        }
        return new SimpleDateFormat(format).format(date);
    }

    public static MainFrame getInstance() {
        return instance;
    }

    public void addPanel01() {
        getBtnClear().setEnabled(true);
        getBtnPrint().setEnabled(true);
        getBtnHelp().setEnabled(true);
        if (this.Ahmmomst351panel01 == null) {
            this.Ahmmomst351panel01 = new Ahmmomst351p01();
        } else {
            getContentPane().add((Component) this.Ahmmomst351panel01);
            this.Ahmmomst351panel01.repaint();
        }
        addPanel(Ahmmomst351panel01);
        Ahmmomst351panel01.setVisible(true);
        Ahmmomst351panel02.setVisible(false);
    }

    public void addPanel02(String txtSLocID, ArrayList<Map<String, Object>> listDataAccesories) {
        this.Ahmmomst351panel02 = new Ahmmomst351p02(txtSLocID, listDataAccesories);
        addPanel(Ahmmomst351panel02);
        Ahmmomst351panel02.setVisible(true);
        Ahmmomst351panel01.setVisible(false);
        getBtnClear().setEnabled(false);
        getBtnHelp().setEnabled(false);
        getBtnPrint().setEnabled(false);
    }

    public boolean getExitOverride() {
        return this.exitOverride;
    }

    public void setExitOverride(boolean b) {
        this.exitOverride = b;
    }

    public boolean isForm2() {
        return this.form2;
    }

    public void setForm2(boolean form2) {
        this.form2 = form2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
