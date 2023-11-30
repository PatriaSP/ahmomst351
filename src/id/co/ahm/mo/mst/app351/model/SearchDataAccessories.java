/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.model;

/**
 *
 * @author patria
 */
public class SearchDataAccessories {

    private int no;

    private String partNumber;

    private String partDesc;

    private String qtyStdUsing;

    private String qty;

    private boolean checkbox;

    public int getNo() {
        return this.no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDesc() {
        return this.partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    public String getQtyStdUsing() {
        return this.qtyStdUsing;
    }

    public void setQtyStdUsing(String qtyStdUsing) {
        this.qtyStdUsing = qtyStdUsing;
    }

    public String getQty() {
        return this.qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public boolean isCheckbox() {
        return this.checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}
