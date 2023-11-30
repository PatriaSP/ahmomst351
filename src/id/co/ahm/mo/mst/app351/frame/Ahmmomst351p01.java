/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.frame;

import id.co.ahm.jx.common.constant.ConstantReport;
import id.co.ahm.jx.common.lov.DialogLov;
import id.co.ahm.jx.common.report.GenerateReport;
import id.co.ahm.jx.common.util.CheckBoxRenderer;
import id.co.ahm.jx.common.util.EachRowEditor;
import id.co.ahm.jx.common.util.EachRowRenderer;
import id.co.ahm.jx.common.util.ConverterUtil;
import id.co.ahm.jx.common.util.TextComponentUtils;
import id.co.ahm.mo.mst.app351.util.Mst351UtilRestTemplate;
import id.co.ahm.mo.mst.app351.vo.Mst351VoJson;
import id.co.ahm.mo.mst.app351.vo.Mst351VoParam;
import id.co.ahm.mo.mst.app351.model.Mst351SearchDataHeader;
import id.co.ahm.mo.mst.app351.tablemodel.LookupSearchDataTableFormatAdvance;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author patria
 */
public class Ahmmomst351p01 extends javax.swing.JPanel {

    ArrayList<Map<String, Object>> listStorLocation;

    ArrayList<Map<String, Object>> listShippingNomor;

    ArrayList<Map<String, Object>> listdataHeader;

    ArrayList<Map<String, Object>> listDataDetail;

    ArrayList<Map<String, Object>> listDataAccesories;

    ArrayList<Map<String, Object>> listDataDetailAccesories;

    Map<String, Object> listSLocbyPlant;

    Mst351SearchDataHeader dataToList = null;

    ArrayList<Mst351SearchDataHeader> listDataModel;

    String[] p_array_frame;

    String[] p_array_engine;

    String[] p_array_tipemotor;

    String[] p_array_kodewarna;

    String[] p_array_jeniskemasan;

    /**
     * Creates new form Ahmmomst351p01
     */
    String jxid = "";
    String txId = "";
    String hostPath = "";
    String profile = "";
    String mstPath = "/imo03/ahmsvmomst351-ahs/rest/mo/mst351/";

    public Ahmmomst351p01() {
        initComponents();
        initListener();
        try {
            hostPath = System.getProperty("jnlp.ahmmomst351.server");
            if (hostPath == null) {
                jxid = "CAw+fm0md7/DsLiNvbNtcyVdWmRmwqZNaBqJKHqVUcPc8AlKwRkoXBOKUOF8tBCoOM+tEiT5fjxiqqwHcJOUC/qHLj9uEXxbdrx9Vjz/AXtZ9tIW3WK9uDVlUKeI2SZADpIIKU2yTzcFQQS8OQkW+LgM/iV6v1wUPxNX+a5PUsVUTz0Tlq1LeWsn83SQNsGjtz5Okp2k3IMq2Z0fKK2nldGkecnDNEPSCgUrpmv0sdvKrsEjdaI/7VIhD+qhRxfcU24CspZFoit3J+BgD+9YyvUP/qaCAuOj9WVIy1R0gdwhwxpxA/vGhoN++fsg57Kn9Cn+g8pMXLlb5q4v9KRtcZG9N8sCJ0UdJerG6aPeUEnhY4GB9olg7IxGkemrxUNtVYlajcXF+2k2LfkE4i37MoAZ5FmyHXYbHrTQs3CpqxMTsiQabgJvhj2I3OYohXSoFZTCVsoMbfTX7MVMpVPcXGq6Z+o7WWzYq1+bcBZxxtlwX+VrNj1C1Ssmnvm4zfUac78p5gODEg5B7Y/keBMMsm1EBulD52+GZkebUspcngsUFcQl/Qq5m58V1Mu3DoCAd8Uh6/xpdzS6IZnQNC9clI+YCS305GmGhZh1SWQ2rpZ8erEbpZedaZRidILbis9/ummV/r9hcZ9MRi+waHTX44VeY2WFxEhGVpXTesrcU3CJ04llP6PkJvqpkMLnmCdbv7yin6nuwfKacvn8iW1A9MH8nnemXAeWXMaBoPbzRT86vziX6ZxqhoQui4qJLW1zK0O74ZVHcsouFuV4FyNqGs9h5FpMd1wSnlk9HY/K4n5VQSxySA4Ns3pjTij2/UJRhD5FRDTJSs0LxFdiP0pKvjY6D34HCR7UsinVEhA6JoNurIQVvpBxnBUvYeVgPLWO782TErESVx9l5SsE+lU3I8VYhOIMsb4fVUWw68EvmC8Mr5FBSA8K542ZD1+RYw1eMON1F93V0YsXDikSELin7qeRMG1a80eryobSEZITEcNirjQLqfSs4FdP8TeWq6tTIJs/QrXL6094Iwh4yQI3+CyS8xMHo/mAuRhft1pI70Sjll9fNwjgR4ZwZBow8OS+ApQnGqWfKtqPR7XEu+AVlWCYGKQJtZ0VJAxQ9wm7yQP3AcfafQ4J5fIL8QA0wxIYUTWBThN3sLkDOqY2vVW0uA==";
                txId = "28a6852b-8470-4b18-a507-8a7d6438acca";
                hostPath = "http://localhost:8080";
                profile = "Development";
            } else {
                jxid = System.getProperty("jnlp.ahmmomst351.JXID");
                txId = System.getProperty("jnlp.ahmmomst351.TKID");
                profile = System.getProperty("jnlp.ahmmomst351.profile");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setBounds(20, 0, 1000, 550);
        setBorder(BorderFactory.createTitledBorder(""));
        this.Mst351p01StorageLoc.requestFocus();
        listDataModel = new ArrayList<Mst351SearchDataHeader>();
        setTable();
        setButton(false);
        initFormatComponen();
    }

    public void initFocus() {
        this.Mst351p01StorageLoc.requestFocus();
    }

    public void initFormatComponen() {
        TextComponentUtils.setMaxLengthAndCaseStyle(this.Mst351p01StorageLoc, 4, true);
        TextComponentUtils.setNumericFormat(this.Mst351p01Nomor, true, 9);
        TextComponentUtils.setNumericFormat(this.Mst351p01Tahun, true, 4);
        TextComponentUtils.setMaxLength(this.Mst351p01NoEngine, 16);
    }

    public void setTable() {
        this.Mst351TableSearchData.setAutoResizeMode(0);
        this.Mst351TableSearchData.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.Mst351TableSearchData.getColumnModel().getColumn(1).setPreferredWidth(170);
        this.Mst351TableSearchData.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.Mst351TableSearchData.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.Mst351TableSearchData.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.Mst351TableSearchData.getColumnModel().getColumn(5).setPreferredWidth(146);
        this.Mst351TableSearchData.getColumnModel().getColumn(6).setPreferredWidth(30);
    }

    private void initialized() {
        TextComponentUtils.setMaxLengthAndCaseStyle(Mst351p01StorageLoc, 4, true);
    }

    private void initListener() {
        this.Mst351p01StorageLoc.registerKeyboardAction(this.Mst351p01StorageLoc.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01StorageLoc.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 9 || e.getKeyCode() == 10) {
                    Mst351p01errorMsg.setText("");
                    checkStorageLocation(0, null);
                }
            }
        });
        this.Mst351p01Tahun.registerKeyboardAction(this.Mst351p01Tahun.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01Tahun.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 9 || e.getKeyCode() == 10) {
                    Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                    if (Ahmmomst351p01.this.Mst351p01Tahun.getText().equalsIgnoreCase("")) {
                        Ahmmomst351p01.this.Mst351p01errorMsg.setForeground(Color.RED);
                        Ahmmomst351p01.this.Mst351p01errorMsg.setText("Tahun tidak boleh kosong");
                    } else {
                        Ahmmomst351p01.this.Mst351p01Nomor.requestFocus();
                    }
                }
            }
        });
        this.Mst351p01Nomor.registerKeyboardAction(this.Mst351p01Nomor.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01Nomor.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 9 || e.getKeyCode() == 10) {
                    Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                    if (Ahmmomst351p01.this.Mst351p01Tahun.getText().toString().equalsIgnoreCase("")) {
                        Ahmmomst351p01.this.Mst351p01errorMsg.setForeground(Color.RED);
                        Ahmmomst351p01.this.Mst351p01errorMsg.setText("Tahun tidak boleh kosong");
                        Ahmmomst351p01.this.Mst351p01Tahun.requestFocus();
                    } else {
                        Ahmmomst351p01.this.checkNomorShipping();
                    }
                }
            }
        });
        Mst351p01LovStorageLocBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

                Map<String, Object> mapGetSloc = new HashMap<>();
                mapGetSloc.put("VITEMCODE", Mst351p01StorageLoc.getText().toString());

                Mst351VoParam paramsGetSlocByNrp = new Mst351VoParam();
                paramsGetSlocByNrp.setSearch(mapGetSloc);

                Mst351VoJson voGetSloc = Mst351UtilRestTemplate.postService(paramsGetSlocByNrp, jxid, txId, hostPath + mstPath + "get-lov-storage-location");
                if (voGetSloc.getStatus().equals("1")) {
                    arrayList = (ArrayList<Map<String, Object>>) voGetSloc.getData();
                }

                Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                List<Map<String, Object>> listStorLocation = (new DialogLov(null, arrayList, 420, 375, true, new String[]{"Kode Stor Loc", "Kode Plant", "Desc Stor Loc"}, new String[]{"vitemcode", "vitemname", "vitemdesc"}, new Class[]{String.class, String.class, String.class, String.class}, "vitemcode", "dd-MMM-yyyy HH:mm:ss", "Lov Storage Location")).showLov();
                if (((Map) listStorLocation.get(0)).get("vitemcode").toString() != null && ((Map) listStorLocation.get(0)).get("vitemdesc").toString() != null) {
                    Mst351p01StorageLoc.setText(((Map) listStorLocation.get(0)).get("vitemcode").toString());
                    Mst351p01StorageLocDesc.setText(((Map) listStorLocation.get(0)).get("vitemdesc").toString());
                    Mst351p01PlantID.setText(((Map) listStorLocation.get(0)).get("vitemname").toString());
                    checkStorageLocation(listStorLocation.size(), listStorLocation);
                }
            }
        });
        Mst351p01BtnShow.registerKeyboardAction(Mst351p01BtnShow.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        Mst351p01BtnShow.registerKeyboardAction(Mst351p01BtnShow.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        Mst351p01BtnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mst351p01errorMsg.setText("");
                Mst351p01Check.setSelected(false);
                validatebtnshow();
            }
        });
        Mst351LovNomorBtn.registerKeyboardAction(Mst351LovNomorBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        Mst351LovNomorBtn.registerKeyboardAction(Mst351LovNomorBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        Mst351LovNomorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mst351p01errorMsg.setText("");
                ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

                Map<String, Object> mapGetShipNo = new HashMap<>();
                mapGetShipNo.put("ISHIPYEAR", Mst351p01Tahun.getText().toString());
                mapGetShipNo.put("VPLANID", Mst351p01PlantID.getText().toString());
                mapGetShipNo.put("VSLOCID", Mst351p01StorageLoc.getText().toString());
                Mst351VoParam paramsGetShipping = new Mst351VoParam();
                paramsGetShipping.setSearch(mapGetShipNo);

                Mst351VoJson voGetShipping = Mst351UtilRestTemplate.postService(paramsGetShipping, jxid, txId, hostPath + mstPath + "get-no-shipping");
                if (voGetShipping.getStatus().equals("1")) {
                    arrayList = (ArrayList<Map<String, Object>>) voGetShipping.getData();
                }

                Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                ArrayList<Map<String, Object>> listNomorShip = (ArrayList<Map<String, Object>>) (new DialogLov(null, arrayList, 750, 300, true, new String[]{"Ship No", "Tanggal", "Nomor Truk", "Nomor DO", "Expedisi"}, new String[]{"ishipno", "dshipact", "truckno", "vnodo", "vexpdesc"}, new Class[]{String.class, String.class, String.class, String.class}, "ishipno", "dd-MMM-yyyy HH:mm:ss", "LoV Shipping No.")).showLov();

                Mst351p01Nomor.setText(((Map) listNomorShip.get(0)).get("ishipno") == null ? "" : ((Map) listNomorShip.get(0)).get("ishipno").toString());
                Mst351p01Tanggal.setText(((Map) listNomorShip.get(0)).get("dshipact") == null ? "" : ((Map) listNomorShip.get(0)).get("dshipact").toString());
                Mst351p01NoTruk.setText(((Map) listNomorShip.get(0)).get("truckno") == null ? "" : ((Map) listNomorShip.get(0)).get("truckno").toString());
                Mst351p01NoDo.setText(((Map) listNomorShip.get(0)).get("vnodo") == null ? "" : ((Map) listNomorShip.get(0)).get("vnodo").toString());
                Mst351p01Exp.setText(((Map) listNomorShip.get(0)).get("vexpdesc") == null ? "" : ((Map) listNomorShip.get(0)).get("vexpdesc").toString());
                Mst351p01KodeDealer.setText(((Map) listNomorShip.get(0)).get("csarea_ID_CSAREA") == null ? "" : ((Map) listNomorShip.get(0)).get("csarea_ID_CSAREA").toString());

                Mst351p01BtnShow.requestFocus();
            }
        });
        Mst351p01NoEngine.registerKeyboardAction(this.Mst351p01NoEngine.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        Mst351p01NoEngine.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 9 || e.getKeyCode() == 10) {
                    Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                    if (Ahmmomst351p01.this.Mst351p01NoEngine.getText().equalsIgnoreCase("")) {
                        Ahmmomst351p01.this.Mst351p01errorMsg.setForeground(Color.RED);
                        Ahmmomst351p01.this.Mst351p01errorMsg.setText("Nomor Engine harus diisi");
                        Ahmmomst351p01.this.Mst351p01NoEngine.requestFocus();
                    } else {
                        callProcAhmmomst351();
                        Ahmmomst351p01.this.doSearchData(Mst351p01Nomor.getText().toString(), Ahmmomst351p01.this.Mst351p01Tahun.getText().toString(), Ahmmomst351p01.this.Mst351p01PlantID.getText().toString(), Ahmmomst351p01.this.Mst351p01StorageLoc.getText().toString(), false);
                    }
                }
            }
        });
        this.Mst351p01MaintainBtn.registerKeyboardAction(this.Mst351p01MaintainBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01MaintainBtn.registerKeyboardAction(this.Mst351p01MaintainBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p01MaintainBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ahmmomst351p01.this.Mst351p01errorMsg.setText("");
                Ahmmomst351p01.this.listDataAccesories = doSearchDataAccessories(Ahmmomst351p01.this.Mst351p01Nomor.getText(), Ahmmomst351p01.this.Mst351p01Tahun.getText(), Ahmmomst351p01.this.Mst351p01PlantID.getText(), Ahmmomst351p01.this.Mst351p01StorageLoc.getText());
                if(!listDataAccesories.isEmpty()){
                    MainFrame.getInstance().setForm2(true);
                    MainFrame.getInstance().addPanel02(Ahmmomst351p01.this.Mst351p01StorageLoc.getText(), Ahmmomst351p01.this.listDataAccesories);
                }
            }
        });
        this.Mst351p01DeleteBtn.registerKeyboardAction(this.Mst351p01DeleteBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01DeleteBtn.registerKeyboardAction(this.Mst351p01DeleteBtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p01DeleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menghapus data terpilih?", "Konfirmasi", 2, 3);
                if (confirmation == 0) {
                    Ahmmomst351p01.this.getDataDelete();
                    if (Ahmmomst351p01.this.Mst351p01Check.isSelected()) {
                        Ahmmomst351p01.this.doSearchData(Ahmmomst351p01.this.Mst351p01Nomor.getText().toString(), Ahmmomst351p01.this.Mst351p01Tahun.getText().toString(), Ahmmomst351p01.this.Mst351p01PlantID.getText().toString(), Ahmmomst351p01.this.Mst351p01StorageLoc.getText().toString(), true);
                    } else {
                        Ahmmomst351p01.this.doSearchData(Ahmmomst351p01.this.Mst351p01Nomor.getText().toString(), Ahmmomst351p01.this.Mst351p01Tahun.getText().toString(), Ahmmomst351p01.this.Mst351p01PlantID.getText().toString(), Ahmmomst351p01.this.Mst351p01StorageLoc.getText().toString(), false);
                    }
                }
            }
        });
        this.Mst351p01Check.registerKeyboardAction(this.Mst351p01Check.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Ahmmomst351p01.this.Mst351p01Check.isSelected()) {
                    for (int i = 0; i < Ahmmomst351p01.this.listDataModel.size(); i++) {
                        ((Mst351SearchDataHeader) Ahmmomst351p01.this.listDataModel.get(i)).setCheckbox(true);
                        Ahmmomst351p01.this.setTable();
                    }
                } else {
                    for (int i = 0; i < Ahmmomst351p01.this.listDataModel.size(); i++) {
                        ((Mst351SearchDataHeader) Ahmmomst351p01.this.listDataModel.get(i)).setCheckbox(false);
                        Ahmmomst351p01.this.setTable();
                    }
                }
            }
        });
    }

    public ArrayList<Map<String, Object>> callProcAhmmomst351() {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetProc = new HashMap<>();
        mapGetProc.put("1", Mst351p01NoEngine.getText().toString());
        mapGetProc.put("2", Mst351p01StorageLoc.getText().toString());
        mapGetProc.put("3", Mst351p01PlantID.getText().toString());
        mapGetProc.put("4", Mst351p01Tahun.getText().toString());
        mapGetProc.put("5", Mst351p01Nomor.getText().toString());
        mapGetProc.put("6", Mst351p01NoDo.getText().toString());
        mapGetProc.put("7", System.getProperty("nrp"));
        mapGetProc.put("8", "TRUE");
        mapGetProc.put("9", "FALSE");
        mapGetProc.put("10", "");
        Mst351VoParam paramsGetProc = new Mst351VoParam();
        paramsGetProc.setSearch(mapGetProc);

        Mst351VoJson voGetShipNo = Mst351UtilRestTemplate.postService(paramsGetProc, jxid, txId, hostPath + mstPath + "get-proc-input");
        if (voGetShipNo.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipNo.getData();
            String stat = arrayList.toString().replaceAll("\\[|\\]", "");
            if (stat.equalsIgnoreCase("ok")) {
                this.Mst351p01errorMsg.setForeground(Color.BLUE);
                this.Mst351p01errorMsg.setText("Data berhasil disimpan");
                this.Mst351p01NoEngine.setText("");
                this.Mst351p01NoEngine.requestFocus();
            } else if (stat.equalsIgnoreCase("SUCCESS_NOVOUCH")) {
                this.Mst351p01errorMsg.setForeground(Color.BLUE);
                this.Mst351p01errorMsg.setText("Data berhasil disimpan, lanjutkan dengan maintain voucher accessories");
                this.Mst351p01NoEngine.setText("");
                this.Mst351p01NoEngine.requestFocus();
            } else if (stat.contains("Silahkan coba kembali")) {
                try {
                    Thread.sleep(1000L);
                    if (stat.equalsIgnoreCase("1")) {
                        this.Mst351p01errorMsg.setForeground(Color.BLUE);
                        this.Mst351p01errorMsg.setText("Data berhasil disimpan");
                        this.Mst351p01NoEngine.setText("");
                        this.Mst351p01NoEngine.requestFocus();
                    } else if (stat.equalsIgnoreCase("SUCCESS_NOVOUCH")) {
                        this.Mst351p01errorMsg.setForeground(Color.BLUE);
                        this.Mst351p01errorMsg.setText("Data berhasil disimpan, lanjutkan dengan maintain voucher accessories");
                        this.Mst351p01NoEngine.setText("");
                        this.Mst351p01NoEngine.requestFocus();
                    } else {
                        this.Mst351p01errorMsg.setText("<html><center>" + stat + "</center></html>");
                        this.Mst351p01errorMsg.setForeground(Color.red);
                        this.Mst351p01NoEngine.requestFocus();
                        this.Mst351p01NoEngine.selectAll();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ahmmomst351p01.class.getName()).log(Level.SEVERE, (String) null, ex);
                }
            } else {
                this.Mst351p01errorMsg.setForeground(Color.RED);
                this.Mst351p01errorMsg.setText("<html><center>" + stat + "</center></html>");
                this.Mst351p01NoEngine.requestFocus();
                this.Mst351p01NoEngine.selectAll();
            }
            return arrayList;
        }
        this.Mst351p01NoEngine.requestFocus();
        this.Mst351p01NoEngine.selectAll();
        this.Mst351p01errorMsg.setForeground(Color.RED);
        this.Mst351p01errorMsg.setText("Gagal scan tag ");
        return null;
    }

    public void checkNomorShipping() {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetNoShip = new HashMap<>();
        mapGetNoShip.put("ISHIPYEAR", this.Mst351p01Tahun.getText());
        mapGetNoShip.put("VSLOCID", this.Mst351p01StorageLoc.getText());
        mapGetNoShip.put("VPLANTID", this.Mst351p01PlantID.getText());
        mapGetNoShip.put("ISHIPNO", this.Mst351p01Nomor.getText());
        Mst351VoParam paramsGetNoShip = new Mst351VoParam();
        paramsGetNoShip.setSearch(mapGetNoShip);

        Mst351VoJson voGetShipNo = Mst351UtilRestTemplate.postService(paramsGetNoShip, jxid, txId, hostPath + mstPath + "get-data-noship");
        if (voGetShipNo.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipNo.getData();
        }

        if (this.Mst351p01Nomor.getText().toString().equalsIgnoreCase("")) {
            this.Mst351p01Nomor.requestFocus();
            this.Mst351p01errorMsg.setText("Nomor Shipping tidak boleh kosong");
        } else {
            ArrayList<Map<String, Object>> listShippingNomor = arrayList;
            if (listShippingNomor.size() < 1) {
                this.Mst351p01Nomor.requestFocus();
                this.Mst351p01Nomor.selectAll();
                this.Mst351p01errorMsg.setText("Gagal ambil informasi shipping list!");
            } else {
                Mst351p01Nomor.setText(((Map) listShippingNomor.get(0)).get("ishipno") == null ? "" : ((Map) listShippingNomor.get(0)).get("ishipno").toString());
                Mst351p01Tanggal.setText(((Map) listShippingNomor.get(0)).get("dshipact") == null ? "" : ((Map) listShippingNomor.get(0)).get("dshipact").toString());
                Mst351p01NoTruk.setText(((Map) listShippingNomor.get(0)).get("truckno") == null ? "" : ((Map) listShippingNomor.get(0)).get("truckno").toString());
                Mst351p01NoDo.setText(((Map) listShippingNomor.get(0)).get("vnodo") == null ? "" : ((Map) listShippingNomor.get(0)).get("vnodo").toString());
                Mst351p01Exp.setText(((Map) listShippingNomor.get(0)).get("vexpdesc") == null ? "" : ((Map) listShippingNomor.get(0)).get("vexpdesc").toString());
                Mst351p01KodeDealer.setText(((Map) listShippingNomor.get(0)).get("csarea_ID_CSAREA") == null ? "" : ((Map) listShippingNomor.get(0)).get("csarea_ID_CSAREA").toString());
                this.Mst351p01BtnShow.requestFocus();
            }
        }
    }

    public ArrayList<Map<String, Object>> getSlocDesc(String plantId, String Sloc) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        try {
            Map<String, Object> mapGetSlocDesc = new HashMap<>();
            mapGetSlocDesc.put("plantid", plantId);
            mapGetSlocDesc.put("sloc", Sloc);
            Mst351VoParam paramsGetSlocDesc = new Mst351VoParam();
            paramsGetSlocDesc.setSearch(mapGetSlocDesc);

            Mst351VoJson voGetSlocDesc = Mst351UtilRestTemplate.postService(paramsGetSlocDesc, jxid, txId, hostPath + mstPath + "get-sloc-desc");
            if (voGetSlocDesc != null) {
                if (voGetSlocDesc.getStatus().equals("1")) {
                    arrayList = (ArrayList<Map<String, Object>>) voGetSlocDesc.getData();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error get plant by sloc", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error get plant by sloc", "Warning", JOptionPane.ERROR_MESSAGE);
        }

        return arrayList;
    }

    public void checkStorageLocation(int size, List<Map<String, Object>> listStorLocation) {
        if (this.Mst351p01StorageLoc.getText().toString().equalsIgnoreCase("")) {
            this.Mst351p01StorageLoc.requestFocus();
            this.Mst351p01errorMsg.setForeground(Color.RED);
            this.Mst351p01errorMsg.setText("Storage Loc. tidak boleh kosong");
        } else {
            ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

            Map<String, Object> mapGetSloc = new HashMap<>();
            mapGetSloc.put("VITEMCODE", Mst351p01StorageLoc.getText().toString());

            Mst351VoParam paramsGetSlocByNrp = new Mst351VoParam();
            paramsGetSlocByNrp.setSearch(mapGetSloc);

            Mst351VoJson voGetSloc = Mst351UtilRestTemplate.postService(paramsGetSlocByNrp, jxid, txId, hostPath + mstPath + "get-count-storage-location");
            if (voGetSloc.getStatus().equals("1")) {
                arrayList = (ArrayList<Map<String, Object>>) voGetSloc.getData();
            }

            if (arrayList.size() < 1) {
                this.Mst351p01StorageLoc.requestFocus();
                this.Mst351p01StorageLoc.selectAll();
                this.Mst351p01errorMsg.setForeground(Color.RED);
                this.Mst351p01errorMsg.setText("Gagal ambil informasi storage location!");
            } else {
                this.Mst351p01StorageLocDesc.setText(((Map) arrayList.get(0)).get("vitemdesc").toString());
                this.Mst351p01PlantID.setText(((Map) arrayList.get(0)).get("vitemname").toString());
                this.Mst351p01Tahun.requestFocus();
            }
        }
    }

    public void setButton(boolean flag) {
        this.Mst351p01DeleteBtn.setEnabled(flag);
        this.Mst351p01MaintainBtn.setEnabled(flag);
    }

    private void validatebtnshow() {
        String msg = "";
        if (Mst351p01errorMsg.getText().equals("")) {
            if (Mst351p01Tahun.getText().equalsIgnoreCase("")) {
                msg = msg + "Tahun tidak boleh kosong";
                Mst351p01Tahun.requestFocus();
            } else if (Mst351p01Nomor.getText().equalsIgnoreCase("")) {
                msg = msg + "Nomor Shipping tidak boleh kosong";
                Mst351p01Nomor.requestFocus();
            }
            if (msg.equals("")) {
                doSearchData(this.Mst351p01Nomor.getText().toString(), this.Mst351p01Tahun.getText().toString(), this.Mst351p01PlantID.getText().toString(), this.Mst351p01StorageLoc.getText().toString(), false);
            } else {
                this.Mst351p01errorMsg.setForeground(Color.RED);
                this.Mst351p01errorMsg.setText(msg);
            }
        }
    }

    public ArrayList<Map<String, Object>> doSearchDataHdrshpfuds(String vNomor, String vTahun, String vPlant, String vStorLoc) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetDataHdrShip = new HashMap<>();
        mapGetDataHdrShip.put("ISHIPYEAR", vTahun);
        mapGetDataHdrShip.put("VSLOCID", vStorLoc);
        mapGetDataHdrShip.put("VPLANTID", vPlant);
        mapGetDataHdrShip.put("ISHIPNO", vNomor);
        Mst351VoParam paramsGetDataHdrShip = new Mst351VoParam();
        paramsGetDataHdrShip.setSearch(mapGetDataHdrShip);

        Mst351VoJson voGetShipNo = Mst351UtilRestTemplate.postService(paramsGetDataHdrShip, jxid, txId, hostPath + mstPath + "get-search-data-hdrshp");
        if (voGetShipNo.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipNo.getData();
        }

        return arrayList;
    }

    public ArrayList<Map<String, Object>> doSearchDataShippingList(String vNomor, String vTahun, String vPlant, String vStorLoc) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetShipList = new HashMap<>();
        mapGetShipList.put("ISHIPYEAR", vTahun);
        mapGetShipList.put("VSLOCID", vStorLoc);
        mapGetShipList.put("VPLANTID", vPlant);
        mapGetShipList.put("ISHIPNO", vNomor);
        Mst351VoParam paramsGetShipList = new Mst351VoParam();
        paramsGetShipList.setSearch(mapGetShipList);

        Mst351VoJson voGetShipNo = Mst351UtilRestTemplate.postService(paramsGetShipList, jxid, txId, hostPath + mstPath + "get-search-data-hdrshp-list");
        if (voGetShipNo.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipNo.getData();
        }
        return arrayList;
    }

    public void doSearchData(String vNomor, String vTahun, String vPlant, String vStorLoc, boolean flag) {
        this.dataToList = null;
        this.listDataModel = new ArrayList<Mst351SearchDataHeader>();
        this.listdataHeader = doSearchDataHdrshpfuds(vNomor, vTahun, vPlant, vStorLoc);
        this.listDataDetail = doSearchDataShippingList(vNomor, vTahun, vPlant, vStorLoc);
        if (this.listdataHeader.size() <= 0) {
            this.Mst351p01errorMsg.setForeground(Color.RED);
            this.Mst351p01errorMsg.setText("Gagal ambil data header shipping list!");
        } else {
            for (int i = 0; i < this.listDataDetail.size(); i++) {
                this.dataToList = new Mst351SearchDataHeader();
                this.dataToList.setNo(i + 1);
                this.dataToList.setFrame(((Map) this.listDataDetail.get(i)).get("mframe_VFRMNO").toString());
                this.dataToList.setEngine(((Map) this.listDataDetail.get(i)).get("meng_VENGNO").toString());
                this.dataToList.setTipemotor(((Map) this.listDataDetail.get(i)).get("dshfud_MTPCOL_RTYPE_VMCTYPEID").toString());
                this.dataToList.setWarna(((Map) this.listDataDetail.get(i)).get("dshfud_MTPCOL_MCOL_VCOLORID").toString());
                this.dataToList.setKemasan(((Map) this.listDataDetail.get(i)).get("dset_VITEMCODE_DPKCODE").toString());
                this.dataToList.setCheckbox(flag);
                this.listDataModel.add(this.dataToList);
            }
            LookupSearchDataTableFormatAdvance tblModel = new LookupSearchDataTableFormatAdvance(this.listDataModel);
            this.Mst351TableSearchData.setModel((TableModel) tblModel);
            CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
            EachRowRenderer rowRenderer = new EachRowRenderer();
            if (this.listDataModel != null) {
                for (int j = 0; j < this.listDataModel.size(); j++) {
                    rowRenderer.add(j, (TableCellRenderer) checkBoxRenderer);
                }
                JCheckBox checkBox = new JCheckBox();
                checkBox.setHorizontalAlignment(0);
                DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
                EachRowEditor rowEditor = new EachRowEditor(this.Mst351TableSearchData);
                for (int k = 0; k < this.listDataModel.size(); k++) {
                    rowEditor.setEditorAt(k, checkBoxEditor);
                }
                this.Mst351TableSearchData.getColumnModel().getColumn(6).setCellRenderer((TableCellRenderer) rowRenderer);
                this.Mst351TableSearchData.getColumnModel().getColumn(6).setCellEditor((TableCellEditor) rowEditor);
            }
            this.Mst351TableSearchData.setAutoResizeMode(0);
            this.Mst351TableSearchData.getColumnModel().getColumn(0).setPreferredWidth(30);
            this.Mst351TableSearchData.getColumnModel().getColumn(1).setPreferredWidth(170);
            this.Mst351TableSearchData.getColumnModel().getColumn(2).setPreferredWidth(130);
            this.Mst351TableSearchData.getColumnModel().getColumn(3).setPreferredWidth(120);
            this.Mst351TableSearchData.getColumnModel().getColumn(4).setPreferredWidth(120);
            this.Mst351TableSearchData.getColumnModel().getColumn(5).setPreferredWidth(146);
            this.Mst351TableSearchData.getColumnModel().getColumn(6).setPreferredWidth(30);
            setButton(true);
        }
    }

    public ArrayList<Map<String, Object>> doSearchDataAccessories(String vNomor, String vTahun, String vPlant, String vStorLoc) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        Map<String, Object> mapGetDataAcc = new HashMap<>();
        mapGetDataAcc.put("ISHIPYEAR", vTahun);
        mapGetDataAcc.put("VSLOCID", vStorLoc);
        mapGetDataAcc.put("VPLANTID", vPlant);
        mapGetDataAcc.put("ISHIPNO", vNomor);
        Mst351VoParam paramsGetDataAcc = new Mst351VoParam();
        paramsGetDataAcc.setSearch(mapGetDataAcc);

        Mst351VoJson voGetShipping = Mst351UtilRestTemplate.postService(paramsGetDataAcc, jxid, txId, hostPath + mstPath + "get-data-acc");
        if (voGetShipping.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipping.getData();
        }
        return arrayList;
    }

    public ArrayList<Map<String, Object>> getDataDelete() {
        int j = 0;
        int arrSize = this.listDataModel.size();
        List<String> arrFrame = new ArrayList<String>();
        List<String> arrEngine = new ArrayList<String>();
        List<String> arrTipe = new ArrayList<String>();
        List<String> arrWarna = new ArrayList<String>();
        List<String> arrKemasan = new ArrayList<String>();
        this.p_array_frame = new String[this.listDataModel.size()];
        this.p_array_engine = new String[this.listDataModel.size()];
        this.p_array_tipemotor = new String[this.listDataModel.size()];
        this.p_array_kodewarna = new String[this.listDataModel.size()];
        this.p_array_jeniskemasan = new String[this.listDataModel.size()];
        for (int i = 0; i < arrSize; i++) {
            if (((Mst351SearchDataHeader) this.listDataModel.get(i)).isCheckbox()) {
                arrFrame.add(((Mst351SearchDataHeader) this.listDataModel.get(i)).getFrame());
                arrEngine.add(((Mst351SearchDataHeader) this.listDataModel.get(i)).getEngine());
                arrTipe.add(((Mst351SearchDataHeader) this.listDataModel.get(i)).getTipemotor());
                arrWarna.add(((Mst351SearchDataHeader) this.listDataModel.get(i)).getWarna());
                arrKemasan.add(((Mst351SearchDataHeader) this.listDataModel.get(i)).getKemasan());
            }
        }
        if (arrFrame.isEmpty()) {
            this.Mst351p01errorMsg.setForeground(Color.RED);
            this.Mst351p01errorMsg.setText("Tidak ada data yang dipilih");
            this.Mst351p01NoEngine.requestFocus();
            this.Mst351p01NoEngine.selectAll();
            return null;
        }

        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetParamDel = new HashMap<>();
        mapGetParamDel.put("1", Mst351p01StorageLoc.getText().toString());
        mapGetParamDel.put("2", Mst351p01PlantID.getText().toString());
        mapGetParamDel.put("3", Mst351p01Tahun.getText().toString());
        mapGetParamDel.put("4", Mst351p01Nomor.getText().toString());
        mapGetParamDel.put("5", Mst351p01NoDo.getText().toString());
        mapGetParamDel.put("6", arrFrame.toArray(new String[arrFrame.size()]));
        mapGetParamDel.put("7", arrEngine.toArray(new String[arrEngine.size()]));
        mapGetParamDel.put("8", arrTipe.toArray(new String[arrTipe.size()]));
        mapGetParamDel.put("9", arrWarna.toArray(new String[arrWarna.size()]));
        mapGetParamDel.put("10", arrKemasan.toArray(new String[arrKemasan.size()]));
        mapGetParamDel.put("11", System.getProperty("nrp"));
        mapGetParamDel.put("12", "FALSE");
        mapGetParamDel.put("13", "TRUE");
        mapGetParamDel.put("14", "");
        Mst351VoParam paramsDel = new Mst351VoParam();
        paramsDel.setSearch(mapGetParamDel);

        Mst351VoJson voGetShipNo = Mst351UtilRestTemplate.postService(paramsDel, jxid, txId, hostPath + mstPath + "get-proc-delete");
        if (voGetShipNo.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetShipNo.getData();
            String stat = arrayList.toString().replaceAll("\\[|\\]", "");
            if (stat.equalsIgnoreCase("ok")) {
                this.Mst351p01errorMsg.setForeground(Color.BLUE);
                this.Mst351p01errorMsg.setText("Data berhasil dihapus");
            } else if (stat.contains("Silahkan coba kembali")) {
                try {
                    Thread.sleep(1000L);
                    arrayList = getDataDelete();
                    stat = arrayList.toString();
                    if (stat.equalsIgnoreCase("ok")) {
                        this.Mst351p01errorMsg.setForeground(Color.BLUE);
                        this.Mst351p01errorMsg.setText("Data berhasil dihapus");
                        this.Mst351p01errorMsg.setText("");
                        this.Mst351p01errorMsg.requestFocus();
                    } else {
                        this.Mst351p01errorMsg.setText("<html><center>" + stat + "</center></html>");
                        this.Mst351p01errorMsg.setForeground(Color.red);
                        this.Mst351p01NoEngine.requestFocus();
                        this.Mst351p01NoEngine.selectAll();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ahmmomst351p01.class.getName()).log(Level.SEVERE, (String) null, ex);
                }
            } else {
                this.Mst351p01errorMsg.setText(stat);
                this.Mst351p01errorMsg.setForeground(Color.red);
                this.Mst351p01NoEngine.requestFocus();
                this.Mst351p01NoEngine.selectAll();
            }
            return arrayList;
        }
        this.Mst351p01errorMsg.setForeground(Color.RED);
        this.Mst351p01errorMsg.setText("Gagal melakukan proses delete : " + arrayList.toString());
        this.Mst351p01NoEngine.requestFocus();
        this.Mst351p01NoEngine.selectAll();
        return null;
    }

    public void clearScreen() {
        this.Mst351p01StorageLoc.setText("");
        this.Mst351p01StorageLocDesc.setText("");
        this.Mst351p01PlantID.setText("");
        this.Mst351p01Exp.setText("");
        this.Mst351p01Nomor.setText("");
        this.Mst351p01Tahun.setText("");
        this.Mst351p01Tanggal.setText("");
        this.Mst351p01NoDo.setText("");
        this.Mst351p01Exp.setText("");
        this.Mst351p01KodeDealer.setText("");
        this.Mst351p01NoTruk.setText("");
        this.Mst351p01StorageLoc.requestFocus();
        this.listDataModel = new ArrayList<Mst351SearchDataHeader>();
        LookupSearchDataTableFormatAdvance tblModel = new LookupSearchDataTableFormatAdvance(this.listDataModel);
        this.Mst351TableSearchData.setModel((TableModel) tblModel);
        setButton(false);
        this.Mst351p01errorMsg.setText("");
        this.Mst351p01NoEngine.setText("");
        this.Mst351p01Check.setSelected(false);
        setTable();
    }

    public void printReport() {
        try {
            this.Mst351p01errorMsg.setText("");
            if (this.Mst351p01Tahun.getText().toString().equalsIgnoreCase("")) {
                this.Mst351p01errorMsg.setForeground(Color.RED);
                this.Mst351p01errorMsg.setText("Tahun tidak boleh kosong");
                this.Mst351p01Tahun.requestFocus();
            } else {
                checkNomorShipping();
            }
            if (this.Mst351p01errorMsg.getText().isEmpty()) {
                String urlReport = "";
                String link = "";
                ArrayList<Map<String, Object>> resulSetting2 = VoListReport2();
                if (resulSetting2.size() > 0) {
                    urlReport = (hostPath + ((Map) resulSetting2.get(0)).get("vitemname").toString() + ((Map) resulSetting2.get(0)).get("vitemdesc").toString());
                }
                String urlParams = "SHPLST_NO=" + this.Mst351p01Nomor.getText() + " SHPLST_PLANT=" + this.Mst351p01PlantID.getText() + " SHPLST_SLOC=" + this.Mst351p01StorageLoc.getText() + " SHPLST_YEAR=" + this.Mst351p01Tahun.getText() + "'&tipeFile=honda1";
                link = urlReport + "report=ahmmomstr084&params='" + urlParams;
                ConverterUtil convertLink = new ConverterUtil();
                link = convertLink.encodeUrl(link);
                GenerateReport report = new GenerateReport();
                System.out.println("link " + link);
                report.callCmd(ConstantReport.HONDA1, link);
                System.out.println("Success call cmd");
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            this.Mst351p01errorMsg.setForeground(Color.red);
            this.Mst351p01errorMsg.setText("Gagal panggil report. " + ex.getMessage());
        }
    }

    public ArrayList<Map<String, Object>> VoListReport() {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        Map<String, Object> mapGetReport = new HashMap<>();

        Mst351VoParam paramsGetReport = new Mst351VoParam();
        paramsGetReport.setSearch(mapGetReport);

        Mst351VoJson voGetSloc = Mst351UtilRestTemplate.postService(paramsGetReport, jxid, txId, hostPath + mstPath + "get-report");
        if (voGetSloc.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetSloc.getData();
        }
        return arrayList;
    }

    public ArrayList<Map<String, Object>> VoListReport2() {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        Map<String, Object> mapGetReport = new HashMap<>();

        Mst351VoParam paramsGetReport = new Mst351VoParam();
        paramsGetReport.setSearch(mapGetReport);

        Mst351VoJson voGetSloc = Mst351UtilRestTemplate.postService(paramsGetReport, jxid, txId, hostPath + mstPath + "get-report2");
        if (voGetSloc.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetSloc.getData();
        }
        return arrayList;
    }

    public void callCmd(String url) throws IOException {
        System.setProperty("Path-Lib", "C:\\ProgramData\\AHMPrintHonda\\");
        String path = System.getProperty("Path-Lib", "C:\\ProgramData\\AHMPrintHonda\\");
        String runHonda1 = "java -jar " + path + "ahmitsys062.jar " + "\"" + url + "\"";
        Process p = Runtime.getRuntime().exec(runHonda1);
    }

    private void checkActionPerformed(ActionEvent evt) {
        if (this.Mst351p01Check.isSelected()) {
            doSearchData(this.Mst351p01Nomor.getText().toString(), this.Mst351p01Tahun.getText().toString(), this.Mst351p01PlantID.getText().toString(), this.Mst351p01StorageLoc.getText().toString(), true);
        } else {
            doSearchData(this.Mst351p01Nomor.getText().toString(), this.Mst351p01Tahun.getText().toString(), this.Mst351p01PlantID.getText().toString(), this.Mst351p01StorageLoc.getText().toString(), false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Mst351p01Panel = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        Mst351p01KodePlantlbl = new javax.swing.JLabel();
        Mst351p01StorageLoc = new javax.swing.JTextField();
        Mst351p01PlantID = new javax.swing.JTextField();
        Mst351p01StorageLocDesc = new javax.swing.JTextField();
        Mst351p01KodePlantlbl1 = new javax.swing.JLabel();
        Mst351p01KodePlantlbl2 = new javax.swing.JLabel();
        Mst351p01Tanggal = new javax.swing.JTextField();
        Mst351p01KodePlantlbl3 = new javax.swing.JLabel();
        Mst351p01NoTruk = new javax.swing.JTextField();
        Mst351p01KodePlantlbl4 = new javax.swing.JLabel();
        Mst351p01KodePlantlbl5 = new javax.swing.JLabel();
        Mst351p01NoDo = new javax.swing.JTextField();
        Mst351p01KodePlantlbl6 = new javax.swing.JLabel();
        Mst351p01KodePlantlbl7 = new javax.swing.JLabel();
        Mst351p01Exp = new javax.swing.JTextField();
        Mst351p01KodePlantlbl8 = new javax.swing.JLabel();
        Mst351p01KodeDealer = new javax.swing.JTextField();
        Mst351p01BtnShow = new javax.swing.JButton();
        Mst351p01NoEngine = new javax.swing.JTextField();
        Mst351p01Nomor = new javax.swing.JFormattedTextField();
        Mst351p01Tahun = new javax.swing.JFormattedTextField();
        Mst351p01LovStorageLocBtn = new javax.swing.JButton();
        Mst351LovNomorBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Mst351p01DeleteBtn = new javax.swing.JButton();
        Mst351p01MaintainBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mst351TableSearchData = new javax.swing.JTable();
        Mst351p01Check = new javax.swing.JCheckBox();
        Mst351p01errorMsg = new javax.swing.JLabel();

        Mst351p01Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlabel1.setText("Storage Location  :");

        Mst351p01KodePlantlbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl.setText("Plant  :");
        Mst351p01KodePlantlbl.setToolTipText("");

        Mst351p01StorageLoc.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01StorageLoc.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01PlantID.setEditable(false);
        Mst351p01PlantID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01PlantID.setEnabled(false);
        Mst351p01PlantID.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01PlantID.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01StorageLocDesc.setEditable(false);
        Mst351p01StorageLocDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01StorageLocDesc.setEnabled(false);
        Mst351p01StorageLocDesc.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01StorageLocDesc.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01KodePlantlbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl1.setText("Tahun  :");
        Mst351p01KodePlantlbl1.setToolTipText("");

        Mst351p01KodePlantlbl2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl2.setText("Nomor  :");
        Mst351p01KodePlantlbl2.setToolTipText("");

        Mst351p01Tanggal.setEditable(false);
        Mst351p01Tanggal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01Tanggal.setEnabled(false);
        Mst351p01Tanggal.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01Tanggal.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01KodePlantlbl3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl3.setText("Tanggal  :");
        Mst351p01KodePlantlbl3.setToolTipText("");

        Mst351p01NoTruk.setEditable(false);
        Mst351p01NoTruk.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01NoTruk.setEnabled(false);
        Mst351p01NoTruk.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01NoTruk.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01KodePlantlbl4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl4.setText("Nomor Truk  :");
        Mst351p01KodePlantlbl4.setToolTipText("");

        Mst351p01KodePlantlbl5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl5.setText("Nomor DO  :");
        Mst351p01KodePlantlbl5.setToolTipText("");

        Mst351p01NoDo.setEditable(false);
        Mst351p01NoDo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01NoDo.setEnabled(false);
        Mst351p01NoDo.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01NoDo.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01KodePlantlbl6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl6.setText("Nomor Engine  :");
        Mst351p01KodePlantlbl6.setToolTipText("");

        Mst351p01KodePlantlbl7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl7.setText("Ekspedisi  :");
        Mst351p01KodePlantlbl7.setToolTipText("");

        Mst351p01Exp.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01Exp.setEnabled(false);
        Mst351p01Exp.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01Exp.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01KodePlantlbl8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Mst351p01KodePlantlbl8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Mst351p01KodePlantlbl8.setText("Kode Dealer  :");
        Mst351p01KodePlantlbl8.setToolTipText("");

        Mst351p01KodeDealer.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p01KodeDealer.setEnabled(false);
        Mst351p01KodeDealer.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01KodeDealer.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01BtnShow.setText("Show");

        Mst351p01NoEngine.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01NoEngine.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01Nomor.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01Nomor.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01Tahun.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Mst351p01Tahun.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p01Tahun.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p01LovStorageLocBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/co/ahm/mo/mst/app351/image/Find16.png"))); // NOI18N
        Mst351p01LovStorageLocBtn.setPreferredSize(new java.awt.Dimension(49, 28));

        Mst351LovNomorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/co/ahm/mo/mst/app351/image/Find16.png"))); // NOI18N
        Mst351LovNomorBtn.setPreferredSize(new java.awt.Dimension(49, 28));

        javax.swing.GroupLayout Mst351p01PanelLayout = new javax.swing.GroupLayout(Mst351p01Panel);
        Mst351p01Panel.setLayout(Mst351p01PanelLayout);
        Mst351p01PanelLayout.setHorizontalGroup(
            Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Mst351p01KodePlantlbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mst351p01KodePlantlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mst351p01KodePlantlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                        .addComponent(Mst351p01StorageLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mst351p01LovStorageLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                .addComponent(Mst351p01Nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(Mst351LovNomorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mst351p01BtnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Mst351p01PlantID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mst351p01Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                        .addComponent(Mst351p01KodePlantlbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Mst351p01NoTruk, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                        .addComponent(Mst351p01KodePlantlbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Mst351p01Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                        .addComponent(Mst351p01KodePlantlbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(Mst351p01Exp, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                        .addComponent(Mst351p01KodePlantlbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(Mst351p01KodeDealer, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mst351p01KodePlantlbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01KodePlantlbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mst351p01NoDo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01NoEngine, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(Mst351p01StorageLocDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        Mst351p01PanelLayout.setVerticalGroup(
            Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Mst351p01StorageLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel1))
                        .addComponent(Mst351p01StorageLocDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Mst351p01LovStorageLocBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mst351p01KodePlantlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mst351p01PlantID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Mst351p01Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mst351p01KodePlantlbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Mst351p01BtnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Mst351p01Nomor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Mst351p01KodePlantlbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Mst351p01KodePlantlbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Mst351p01KodePlantlbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01NoTruk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Mst351p01PanelLayout.createSequentialGroup()
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Mst351p01KodePlantlbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01Exp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Mst351p01KodePlantlbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mst351p01KodeDealer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Mst351p01KodePlantlbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mst351p01NoDo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(Mst351p01PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Mst351p01KodePlantlbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mst351p01NoEngine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Mst351LovNomorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Mst351p01StorageLoc.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Mst351p01DeleteBtn.setText("Delete");

        Mst351p01MaintainBtn.setText("Maintain Voucher Accesories");

        Mst351TableSearchData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Frame", "Engine", "Tipe Motor", "Kode Warna", "Jenis Kemasan", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Mst351TableSearchData);

        Mst351p01Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mst351p01CheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Mst351p01DeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mst351p01MaintainBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mst351p01Check, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Mst351p01DeleteBtn)
                        .addComponent(Mst351p01MaintainBtn))
                    .addComponent(Mst351p01Check, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        Mst351p01errorMsg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Mst351p01errorMsg.setForeground(java.awt.Color.red);
        Mst351p01errorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Mst351p01errorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mst351p01Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mst351p01Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Mst351p01errorMsg)
                .addGap(115, 115, 115))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Mst351p01CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mst351p01CheckActionPerformed
        checkActionPerformed(evt);
    }//GEN-LAST:event_Mst351p01CheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mst351LovNomorBtn;
    private javax.swing.JTable Mst351TableSearchData;
    private javax.swing.JButton Mst351p01BtnShow;
    private javax.swing.JCheckBox Mst351p01Check;
    private javax.swing.JButton Mst351p01DeleteBtn;
    private javax.swing.JTextField Mst351p01Exp;
    private javax.swing.JTextField Mst351p01KodeDealer;
    private javax.swing.JLabel Mst351p01KodePlantlbl;
    private javax.swing.JLabel Mst351p01KodePlantlbl1;
    private javax.swing.JLabel Mst351p01KodePlantlbl2;
    private javax.swing.JLabel Mst351p01KodePlantlbl3;
    private javax.swing.JLabel Mst351p01KodePlantlbl4;
    private javax.swing.JLabel Mst351p01KodePlantlbl5;
    private javax.swing.JLabel Mst351p01KodePlantlbl6;
    private javax.swing.JLabel Mst351p01KodePlantlbl7;
    private javax.swing.JLabel Mst351p01KodePlantlbl8;
    private javax.swing.JButton Mst351p01LovStorageLocBtn;
    private javax.swing.JButton Mst351p01MaintainBtn;
    private javax.swing.JTextField Mst351p01NoDo;
    private javax.swing.JTextField Mst351p01NoEngine;
    private javax.swing.JTextField Mst351p01NoTruk;
    private javax.swing.JFormattedTextField Mst351p01Nomor;
    private javax.swing.JPanel Mst351p01Panel;
    private javax.swing.JTextField Mst351p01PlantID;
    private javax.swing.JTextField Mst351p01StorageLoc;
    private javax.swing.JTextField Mst351p01StorageLocDesc;
    private javax.swing.JFormattedTextField Mst351p01Tahun;
    private javax.swing.JTextField Mst351p01Tanggal;
    private javax.swing.JLabel Mst351p01errorMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel1;
    // End of variables declaration//GEN-END:variables
}
