/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.tablemodel;

import id.co.ahm.mo.mst.app351.model.SearchDataAccessories;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author patria
 */
public class LookupSearchDataAccesoriesTableFormatAdvance extends AbstractTableModel {

    private List<SearchDataAccessories> list = new ArrayList<SearchDataAccessories>();

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 5) {
            return true;
        }
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        if (value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("false")) {
            ((SearchDataAccessories) this.list.get(row)).setCheckbox(((Boolean) value).booleanValue());
            fireTableCellUpdated(row, col);
        } else if (value.toString().equalsIgnoreCase("EDIT")) {

        }
    }

    public Class getColumnClass(int i) {
        switch (i) {
            case 0:
                return Number.class;
            case 3:
                return Number.class;
            case 4:
                return Number.class;
        }
        return String.class;
    }

    public void setData(List<SearchDataAccessories> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public int getColumnCount() {
        return 6;
    }

    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "No.";
            case 1:
                return "Nomor Part";
            case 2:
                return "Deskripsi Part";
            case 3:
                return "Qty Std Using";
            case 4:
                return "Qty";
            case 5:
                return "";
        }
        return "";
    }

    public int getRowCount() {
        return this.list.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchDataAccessories dataAccesories = this.list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Integer.valueOf(rowIndex + 1);
            case 1:
                return dataAccesories.getPartNumber();
            case 2:
                return dataAccesories.getPartDesc();
            case 3:
                return dataAccesories.getQtyStdUsing();
            case 4:
                return dataAccesories.getQty();
            case 5:
                return Boolean.valueOf(dataAccesories.isCheckbox());
        }
        return "";
    }
}
