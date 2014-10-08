package com.kryshyna.notebook;

import com.kryshyna.notebook.entity.Telephone;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class DataTableTelephones extends AbstractTableModel {
    private List<Telephone> data;
    private String[] COLUMN_NAMES = {"Number"};

    public DataTableTelephones(List<Telephone> data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object;
        object = data.get(rowIndex).getNumber();
        return object;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }




    public List<Telephone> getData(){
        return data;
    }
}

