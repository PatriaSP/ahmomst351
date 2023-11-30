/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.tablemodel;

import id.co.ahm.mo.mst.app351.model.Mst351SearchDataHeader;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patria
 */
public class LookupSearchDataTableFormatAdvance extends AbstractTableModel{

    private List<Mst351SearchDataHeader> list;

    public Class getColumnClass(int i) {
        switch (i) {
            case 0:
                return Number.class;
        }
        return String.class;
    }

    public LookupSearchDataTableFormatAdvance(List<Mst351SearchDataHeader> list) {
        this.list = list;
    }

    public void setData(List<Mst351SearchDataHeader> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public int getColumnCount() {
        return 7;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 6) {
            return true;
        }
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        if (value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("false")) {
            ((Mst351SearchDataHeader) this.list.get(row)).setCheckbox(((Boolean) value).booleanValue());
            fireTableCellUpdated(row, col);
        } else if (value.toString().equalsIgnoreCase("EDIT")) {

        }
    }

    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "No.";
            case 1:
                return "Frame";
            case 2:
                return "Engine";
            case 3:
                return "Tipe Motor";
            case 4:
                return "Kode Warna";
            case 5:
                return "Jenis Kemasan";
            case 6:
                return "";
        }
        return "";
    }

    public int getRowCount() {
        return this.list.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Mst351SearchDataHeader dataHeader = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Integer.valueOf(dataHeader.getNo());
            case 1:
                return dataHeader.getFrame();
            case 2:
                return dataHeader.getEngine();
            case 3:
                return dataHeader.getTipemotor();
            case 4:
                return dataHeader.getWarna();
            case 5:
                return dataHeader.getKemasan();
            case 6:
                return Boolean.valueOf(dataHeader.isCheckbox());
        }
        return "";
    }
}
