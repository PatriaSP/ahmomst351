/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.frame;

import id.co.ahm.jx.common.util.CheckBoxRenderer;
import id.co.ahm.jx.common.util.EachRowEditor;
import id.co.ahm.jx.common.util.EachRowRenderer;
import id.co.ahm.mo.mst.app351.model.SearchDataAccessories;
import id.co.ahm.mo.mst.app351.tablemodel.LookupSearchDataAccesoriesTableFormatAdvance;
import id.co.ahm.mo.mst.app351.util.Mst351UtilRestTemplate;
import id.co.ahm.mo.mst.app351.vo.Mst351VoJson;
import id.co.ahm.mo.mst.app351.vo.Mst351VoParam;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author patria
 */
public class Ahmmomst351p02 extends JPanel {

    private String txtVPlantID;

    private String txtVSLocID;

    private String txtVTipeMotor;

    private String txtVQty;

    private String txtVWarna;

    private String txtVtahun;

    private String txtvshipno;

    ArrayList<Map<String, Object>> listDataAccesoriesPanel2;

    ArrayList<Map<String, Object>> listDataAccesoriesDetailPanel2;

    ArrayList<SearchDataAccessories> listDataModel;

    SearchDataAccessories dataToList = null;

    private String pattern = "dd-MMM-yyyy";

    public int page = 0;

    String[] p_array_partnum;

    Number[] p_array_nqty;

    Number[] p_array_nqtystd;

    ArrayList<SearchDataAccessories> tempObjDelete;

    private LookupSearchDataAccesoriesTableFormatAdvance tblModel;

    private Map<String, String> tempEngine;

    private boolean isUsingBOMAcc = false;
    /**
     * Creates new form Ahmmomst351p02
     *
     * @param txtVplantID
     * @param txtvSLocID
     */
    String jxid = "";
    String txId = "";
    String hostPath = "";
    String profile = "";
    String mstPath = "/imo03/ahmsvmomst351-ahs/rest/mo/mst351/";

    //    url
    public Ahmmomst351p02(String txtvSLocID, ArrayList<Map<String, Object>> listDataAccesories) {
        initComponents();
        
        
        
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

        this.listDataAccesoriesPanel2 = listDataAccesories;
        this.txtVPlantID = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vplantid").toString();
        this.txtVSLocID = txtvSLocID;
        this.txtVTipeMotor = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vmctypeid").toString();
        this.txtVQty = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("qtyship").toString();
        this.txtVWarna = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vcolorid").toString();
        this.txtVtahun = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("ishipyear").toString();
        this.txtvshipno = ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("ishipno").toString();
        initListener();
        setParameter();
        this.tempEngine = new HashMap<String, String>();
        this.listDataModel = new ArrayList<SearchDataAccessories>();
        setBounds(20, 0, 1000, 550);
        setBorder(BorderFactory.createTitledBorder(""));
        isUsingBOMAcc = !check();
        for (int i = 0; i < listDataAccesories.size(); i++) {
            (listDataAccesories.get(i)).put("accessories", searchByTypeColorPlant(((Map) this.listDataAccesoriesPanel2.get(i)).get("qtyship").toString(), ((Map) this.listDataAccesoriesPanel2.get(i)).get("vmctypeid").toString(), ((Map) this.listDataAccesoriesPanel2.get(i)).get("vcolorid").toString(), ((Map) this.listDataAccesoriesPanel2.get(i)).get("vplantid").toString()));
        }
        setAccessoriesTbl((ArrayList<SearchDataAccessories>) ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("accessories"));
    }

    public ArrayList<Map<String, Object>> getDataDelete() {
        List<String> arrPartnum = new ArrayList<String>();
        List<String> arrNqty = new ArrayList<String>();
        List<String> arrNqtyStd = new ArrayList<String>();
        List<String> arrType = new ArrayList<String>();
        List<String> arrColor = new ArrayList<String>();
        for (Map<String, Object> map : this.listDataAccesoriesPanel2) {
            int arrSize = ((ArrayList) map.get("accessories")).size();
            for (int i = 0; i < arrSize; i++) {
                arrPartnum.add(((SearchDataAccessories) ((ArrayList<SearchDataAccessories>) map.get("accessories")).get(i)).getPartNumber());
                arrNqty.add(((SearchDataAccessories) ((ArrayList<SearchDataAccessories>) map.get("accessories")).get(i)).getQty());
                arrNqtyStd.add(((SearchDataAccessories) ((ArrayList<SearchDataAccessories>) map.get("accessories")).get(i)).getQtyStdUsing());
                arrType.add(map.get("vmctypeid").toString());
                arrColor.add(map.get("vcolorid").toString());
            }
        }
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> mapGetAccByNrp = new HashMap<>();
        mapGetAccByNrp.put("1", this.txtVSLocID.toString());
        mapGetAccByNrp.put("2", this.txtVPlantID.toString());
        mapGetAccByNrp.put("3", this.txtVtahun.toString());
        mapGetAccByNrp.put("4", this.txtvshipno.toString());
        mapGetAccByNrp.put("5", arrNqty.toArray(new String[arrNqty.size()]));
        mapGetAccByNrp.put("6", arrNqtyStd.toArray(new String[arrNqtyStd.size()]));
        mapGetAccByNrp.put("7", arrPartnum.toArray(new String[arrPartnum.size()]));
        mapGetAccByNrp.put("8", arrType.toArray(new String[arrType.size()]));
        mapGetAccByNrp.put("9", arrColor.toArray(new String[arrColor.size()]));
        mapGetAccByNrp.put("10", "nrp");
        mapGetAccByNrp.put("11", "FALSE");
        mapGetAccByNrp.put("12", "TRUE");
        mapGetAccByNrp.put("13", "");
        Mst351VoParam paramsGetShipNo = new Mst351VoParam();
        paramsGetShipNo.setSearch(mapGetAccByNrp);
        Mst351VoJson voGetDataDelete = Mst351UtilRestTemplate.postService(paramsGetShipNo, jxid, txId, hostPath + mstPath + "get-proc-del-acc");
        if (voGetDataDelete.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetDataDelete.getData();
            String stat = arrayList.toString().replaceAll("\\[|\\]", "");
            if (stat.equalsIgnoreCase("ok")) {
                this.Mst351p02errorMsg.setForeground(Color.BLUE);
                this.Mst351p02errorMsg.setText("Maintain voucher accesories berhasil");
            } else if (stat.contains("Silahkan coba kembali")) {
                try {
                    Thread.sleep(1000L);
                    arrayList = getDataDelete();
                    if (stat.equalsIgnoreCase("ok")) {
                        this.Mst351p02errorMsg.setForeground(Color.BLUE);
                        this.Mst351p02errorMsg.setText("Maintain voucher accesories berhasil");
                    } else {
                        this.Mst351p02errorMsg.setForeground(Color.RED);
                        this.Mst351p02errorMsg.setText("<html><center>" + stat + "</center></html>");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ahmmomst351p01.class.getName()).log(Level.SEVERE, (String) null, ex);
                }
            } else {
                this.Mst351p02errorMsg.setForeground(Color.RED);
                this.Mst351p02errorMsg.setText("<html><center>" + stat + "</center></html>");
            }
            return arrayList;
        }
        this.Mst351p02errorMsg.setForeground(Color.RED);
        this.Mst351p02errorMsg.setText("<center>Gagal maintain voucher aksesoris :  " + arrayList.toString() + "</center>");
        return null;
    }

    private void initListener() {
        this.Mst351p02Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setExitOverride(true);
                MainFrame.getInstance().addPanel01();
                MainFrame.getInstance().setForm2(false);
            }
        });
        this.Mst351p01Nextbtn.registerKeyboardAction(this.Mst351p01Nextbtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p01Nextbtn.registerKeyboardAction(this.Mst351p01Nextbtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p01Nextbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ahmmomst351p02.this.nextType();
            }
        });
        this.Mst351p02Deletebtn.registerKeyboardAction(this.Mst351p02Deletebtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p02Deletebtn.registerKeyboardAction(this.Mst351p02Deletebtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p02Deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ahmmomst351p02.this.Mst351p02errorMsg.setText("");
                int confirmation = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin untuk menghapus data terpilih?", "Konfirmasi", 2, 3);
                if (confirmation == 0) {
                    ArrayList<SearchDataAccessories> tempObjDelete = new ArrayList<SearchDataAccessories>();
                    for (int i = 0; i < Ahmmomst351p02.this.listDataModel.size(); i++) {
                        if (((SearchDataAccessories) Ahmmomst351p02.this.listDataModel.get(i)).isCheckbox()) {
                            tempObjDelete.add(Ahmmomst351p02.this.listDataModel.get(i));
                        }
                    }
                    for (int y = 0; y < tempObjDelete.size(); y++) {
                        Ahmmomst351p02.this.listDataModel.remove(tempObjDelete.get(y));
                    }
                    if (tempObjDelete.isEmpty()) {
                        Ahmmomst351p02.this.Mst351p02errorMsg.setForeground(Color.RED);
                        Ahmmomst351p02.this.Mst351p02errorMsg.setText("Tidak ada data yang dipilih");
                    } else {
                        Ahmmomst351p02.this.setTable3();
                        Ahmmomst351p02.this.Mst351p02Check.setSelected(false);
                        if (Ahmmomst351p02.this.listDataModel.isEmpty()) {
                            Ahmmomst351p02.this.Mst351p02Deletebtn.setEnabled(false);
                        }
                    }
                }
            }
        });
        this.Mst351p02Submitbtn.registerKeyboardAction(this.Mst351p02Submitbtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p02Submitbtn.registerKeyboardAction(this.Mst351p02Submitbtn.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p02Submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ahmmomst351p02.this.Mst351p02errorMsg.setText("");
                Ahmmomst351p02.this.getDataDelete();
            }
        });
        this.Mst351p02Check.registerKeyboardAction(this.Mst351p02Check.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, true)), KeyStroke.getKeyStroke(10, 0, true), 0);
        this.Mst351p02Check.registerKeyboardAction(this.Mst351p02Check.getActionForKeyStroke(KeyStroke.getKeyStroke(32, 0, false)), KeyStroke.getKeyStroke(10, 0, false), 0);
        this.Mst351p02Check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Ahmmomst351p02.this.Mst351p02Check.isSelected()) {
                    for (int i = 0; i < Ahmmomst351p02.this.listDataModel.size(); i++) {
                        ((SearchDataAccessories) Ahmmomst351p02.this.listDataModel.get(i)).setCheckbox(true);
                        Ahmmomst351p02.this.setTable3();
                    }
                } else {
                    for (int i = 0; i < Ahmmomst351p02.this.listDataModel.size(); i++) {
                        ((SearchDataAccessories) Ahmmomst351p02.this.listDataModel.get(i)).setCheckbox(false);
                        Ahmmomst351p02.this.setTable3();
                    }
                }
            }
        });
    }

    private void setTable3() {
        this.Mst351p02errorMsg.setText("");
        this.tblModel = new LookupSearchDataAccesoriesTableFormatAdvance();
        this.tblModel.setData(this.listDataModel);
        this.Mst351p02tblAccesories.setModel((TableModel) this.tblModel);
        this.Mst351p02tblAccesories.setAutoResizeMode(0);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(0).setPreferredWidth(35);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setPreferredWidth(40);
        CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
        EachRowRenderer rowRenderer = new EachRowRenderer();
        for (int i = 0; i < this.listDataModel.size(); i++) {
            rowRenderer.add(i, (TableCellRenderer) checkBoxRenderer);
        }
        JCheckBox checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(0);
        DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
        EachRowEditor rowEditor = new EachRowEditor(this.Mst351p02tblAccesories);
        for (int j = 0; j < this.listDataModel.size(); j++) {
            rowEditor.setEditorAt(j, checkBoxEditor);
        }
        this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setCellRenderer((TableCellRenderer) rowRenderer);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) rowEditor);
    }

    public void nextType() {
        this.Mst351p02errorMsg.setText("");
        int dataHeader = this.listDataAccesoriesPanel2.size();
        this.page++;
        if (this.page >= dataHeader) {
            this.page = 0;
        }
        this.Mst351p02Plant.setText(((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vplantid").toString());
        this.Mst351p02StorLoc.setText(this.txtVSLocID);
        this.Mst351p02TipeMotor.setText(((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vmctypeid").toString());
        this.Mst351p02Qty.setText(((Map) this.listDataAccesoriesPanel2.get(this.page)).get("qtyship").toString());
        this.Mst351p02Warna.setText(((Map) this.listDataAccesoriesPanel2.get(this.page)).get("vcolorid").toString());
        setAccessoriesTbl((ArrayList<SearchDataAccessories>) ((Map) this.listDataAccesoriesPanel2.get(this.page)).get("accessories"));
    }

    public void initFocus() {
    }

    private void setAccessoriesTbl(ArrayList<SearchDataAccessories> list) {
        this.Mst351p02Check.setSelected(false);
        for (SearchDataAccessories acc : list) {
            acc.setCheckbox(false);
        }
        LookupSearchDataAccesoriesTableFormatAdvance tblModel = new LookupSearchDataAccesoriesTableFormatAdvance();
        tblModel.setData(list);
        this.listDataModel = list;
        this.Mst351p02tblAccesories.setModel((TableModel) tblModel);
        CheckBoxRenderer checkBoxRenderer = new CheckBoxRenderer();
        EachRowRenderer rowRenderer = new EachRowRenderer();
        if (this.listDataModel != null) {
            for (int i = 0; i < this.listDataModel.size(); i++) {
                rowRenderer.add(i, (TableCellRenderer) checkBoxRenderer);
            }
            JCheckBox checkBox = new JCheckBox();
            checkBox.setHorizontalAlignment(0);
            DefaultCellEditor checkBoxEditor = new DefaultCellEditor(checkBox);
            EachRowEditor rowEditor = new EachRowEditor(this.Mst351p02tblAccesories);
            for (int j = 0; j < this.listDataModel.size(); j++) {
                rowEditor.setEditorAt(j, checkBoxEditor);
            }
            this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setCellRenderer((TableCellRenderer) rowRenderer);
            this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setCellEditor((TableCellEditor) rowEditor);
        }
        this.Mst351p02tblAccesories.getColumnModel().getColumn(0).setPreferredWidth(35);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.Mst351p02tblAccesories.getColumnModel().getColumn(5).setPreferredWidth(40);
        if (this.listDataModel.isEmpty()) {
            this.Mst351p02Deletebtn.setEnabled(false);
        } else {
            this.Mst351p02Deletebtn.setEnabled(true);
        }
    }

    public ArrayList<SearchDataAccessories> searchByTypeColorPlant(String jumlah, String mcType, String color, String Plant) {
        this.dataToList = null;
        this.listDataModel = new ArrayList<SearchDataAccessories>();
        this.listDataAccesoriesDetailPanel2 = doSearchDataDetailAccesories(jumlah, mcType, color, Plant);
        for (int i = 0; i < this.listDataAccesoriesDetailPanel2.size(); i++) {
            this.dataToList = new SearchDataAccessories();
            this.dataToList.setNo(i + 1);
            this.dataToList.setPartNumber(((Map) this.listDataAccesoriesDetailPanel2.get(i)).get("noPart").toString());
            this.dataToList.setPartDesc(((Map) this.listDataAccesoriesDetailPanel2.get(i)).get("descPart").toString());
            this.dataToList.setQtyStdUsing(((Map) this.listDataAccesoriesDetailPanel2.get(i)).get("useQTY").toString());
            this.dataToList.setQty(((Map) this.listDataAccesoriesDetailPanel2.get(i)).get("qty").toString());
            this.dataToList.setCheckbox(false);
            this.listDataModel.add(this.dataToList);
        }
        return this.listDataModel;
    }

    public boolean check() {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        Map<String, Object> mapGetCountBOM = new HashMap<>();

        Mst351VoParam paramsGetCountBOM = new Mst351VoParam();
        paramsGetCountBOM.setSearch(mapGetCountBOM);

        Mst351VoJson voGetSloc = Mst351UtilRestTemplate.postService(paramsGetCountBOM, jxid, txId, hostPath + mstPath + "get-count-BOM-Acc");
        if (voGetSloc.getStatus().equals("1")) {
            arrayList = (ArrayList<Map<String, Object>>) voGetSloc.getData();
        }else {
            this.Mst351p02errorMsg.setForeground(Color.RED);
            this.Mst351p02errorMsg.setText("Gagal cek setting BOM Accessories");
            return false;
        }
        return arrayList.get(0).get("total").toString().equals("0");
    }

    public ArrayList<Map<String, Object>> doSearchDataDetailAccesories(String jumlah, String mcType, String color, String plant) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();

        if (!this.isUsingBOMAcc) {
            Map<String, Object> mapGetParamAcc = new HashMap<>();
            mapGetParamAcc.put("JUMLAH", jumlah);
            mapGetParamAcc.put("PLANTID", plant);
            mapGetParamAcc.put("COLORID", color);
            mapGetParamAcc.put("TYPEID", mcType);
            mapGetParamAcc.put("JUMLAH1", jumlah);
            mapGetParamAcc.put("PLANTID1", plant);
            mapGetParamAcc.put("COLORID1", color);
            mapGetParamAcc.put("TYPEID1", mcType);
            Mst351VoParam paramsGetAcc = new Mst351VoParam();
            paramsGetAcc.setSearch(mapGetParamAcc);

            Mst351VoJson voGetDataAcc = Mst351UtilRestTemplate.postService(paramsGetAcc, jxid, txId, hostPath + mstPath + "get-search-dtl-acc");
            if (voGetDataAcc.getStatus().equals("1")) {
                arrayList = (ArrayList<Map<String, Object>>) voGetDataAcc.getData();
            }
        } else {
            Map<String, Object> mapGetParamAcc1 = new HashMap<>();
            mapGetParamAcc1.put("JUMLAH", jumlah);
            mapGetParamAcc1.put("PLANTID", plant);
            mapGetParamAcc1.put("COLORID", color);
            mapGetParamAcc1.put("TYPEID", mcType);

            Mst351VoParam paramsGetAcc1 = new Mst351VoParam();
            paramsGetAcc1.setSearch(mapGetParamAcc1);

            Mst351VoJson voGetDataAcc1 = Mst351UtilRestTemplate.postService(paramsGetAcc1, jxid, txId, hostPath + mstPath + "get-search-dtl-acc1");

            if (voGetDataAcc1.getStatus().equals("1")) {
                arrayList = (ArrayList<Map<String, Object>>) voGetDataAcc1.getData();
                if (arrayList.isEmpty()) {
                    Map<String, Object> mapGetParamAcc2 = new HashMap<>();
                    mapGetParamAcc2.put("JUMLAH", jumlah);
                    mapGetParamAcc2.put("COLORID", color);
                    mapGetParamAcc2.put("TYPEID", mcType);

                    Mst351VoParam paramsGetAcc2 = new Mst351VoParam();
                    paramsGetAcc2.setSearch(mapGetParamAcc2);

                    Mst351VoJson voGetDataAcc2 = Mst351UtilRestTemplate.postService(paramsGetAcc2, jxid, txId, hostPath + mstPath + "get-search-dtl-acc2");

                    if (voGetDataAcc2.getStatus().equals("1")) {
                        arrayList = (ArrayList<Map<String, Object>>) voGetDataAcc2.getData();
                    }
                }
            }
        }
        return arrayList;
    }

    private void setParameter() {
        this.Mst351p02Plant.setText(this.txtVPlantID);
        this.Mst351p02StorLoc.setText(this.txtVSLocID);
        this.Mst351p02TipeMotor.setText(this.txtVTipeMotor);
        this.Mst351p02Qty.setText(this.txtVQty);
        this.Mst351p02Warna.setText(this.txtVWarna);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Mst351p01Nextbtn = new javax.swing.JButton();
        Mst351p02Qty = new javax.swing.JTextField();
        Mst351p02Warna = new javax.swing.JTextField();
        Mst351p02Plant = new javax.swing.JTextField();
        Mst351p02StorLoc = new javax.swing.JTextField();
        Mst351p02TipeMotor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Mst351p02Deletebtn = new javax.swing.JButton();
        Mst351p02Submitbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mst351p02tblAccesories = new javax.swing.JTable();
        Mst351p02Backbtn = new javax.swing.JButton();
        Mst351p02Check = new javax.swing.JCheckBox();
        Mst351p02errorMsg = new javax.swing.JLabel();

        jLabel11.setText("jLabel11");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Plant Asal:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Storage Location Asal:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipe Motor:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Qty Shipping:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Warna:");

        Mst351p01Nextbtn.setText("Next Type");
        Mst351p01Nextbtn.setPreferredSize(new java.awt.Dimension(83, 28));

        Mst351p02Qty.setEditable(false);
        Mst351p02Qty.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p02Qty.setEnabled(false);
        Mst351p02Qty.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p02Qty.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p02Warna.setEditable(false);
        Mst351p02Warna.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p02Warna.setEnabled(false);
        Mst351p02Warna.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p02Warna.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p02Plant.setEditable(false);
        Mst351p02Plant.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p02Plant.setEnabled(false);
        Mst351p02Plant.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p02Plant.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p02StorLoc.setEditable(false);
        Mst351p02StorLoc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p02StorLoc.setEnabled(false);
        Mst351p02StorLoc.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p02StorLoc.setPreferredSize(new java.awt.Dimension(6, 28));

        Mst351p02TipeMotor.setEditable(false);
        Mst351p02TipeMotor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Mst351p02TipeMotor.setEnabled(false);
        Mst351p02TipeMotor.setMinimumSize(new java.awt.Dimension(6, 28));
        Mst351p02TipeMotor.setPreferredSize(new java.awt.Dimension(6, 28));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(67, 67, 67)
                        .addComponent(Mst351p02TipeMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Mst351p02Plant, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mst351p02StorLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(67, 67, 67)
                        .addComponent(Mst351p02Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(67, 67, 67)
                        .addComponent(Mst351p02Warna, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Mst351p01Nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(Mst351p02Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mst351p02Plant, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(Mst351p02Warna, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Mst351p02StorLoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Mst351p01Nextbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Mst351p02TipeMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Mst351p02Deletebtn.setText("Delete");
        Mst351p02Deletebtn.setMaximumSize(new java.awt.Dimension(65, 28));
        Mst351p02Deletebtn.setMinimumSize(new java.awt.Dimension(65, 28));
        Mst351p02Deletebtn.setPreferredSize(new java.awt.Dimension(65, 28));

        Mst351p02Submitbtn.setText("Submit");
        Mst351p02Submitbtn.setMaximumSize(new java.awt.Dimension(67, 28));
        Mst351p02Submitbtn.setMinimumSize(new java.awt.Dimension(67, 28));
        Mst351p02Submitbtn.setPreferredSize(new java.awt.Dimension(67, 28));

        Mst351p02tblAccesories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nomor Part", "Deskirpsi Part", "Qty Std Using", "Qty", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Mst351p02tblAccesories);

        Mst351p02Backbtn.setText("Back");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mst351p02Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 59, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Mst351p02Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mst351p02Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mst351p02Check)
                        .addGap(72, 72, 72))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Mst351p02Submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mst351p02Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Mst351p02Check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Mst351p02Backbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Mst351p02errorMsg.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Mst351p02errorMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mst351p02errorMsg.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Mst351p02errorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Mst351p02errorMsg)
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mst351p01Nextbtn;
    private javax.swing.JButton Mst351p02Backbtn;
    private javax.swing.JCheckBox Mst351p02Check;
    private javax.swing.JButton Mst351p02Deletebtn;
    private javax.swing.JTextField Mst351p02Plant;
    private javax.swing.JTextField Mst351p02Qty;
    private javax.swing.JTextField Mst351p02StorLoc;
    private javax.swing.JButton Mst351p02Submitbtn;
    private javax.swing.JTextField Mst351p02TipeMotor;
    private javax.swing.JTextField Mst351p02Warna;
    private javax.swing.JLabel Mst351p02errorMsg;
    private javax.swing.JTable Mst351p02tblAccesories;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
