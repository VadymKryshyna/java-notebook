package com.kryshyna.notebook;

import com.kryshyna.notebook.entity.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class DataTablePersons extends AbstractTableModel {
    private List<Person> data;
    private String[] COLUMN_NAMES = {"ID","FirstName","LastName"};

    public DataTablePersons(List<Person> data){
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
        if(columnIndex==0){
            object = data.get(rowIndex).getId();
        }else if(columnIndex==1){
            object = data.get(rowIndex).getFirstname();
        } else {
            object = data.get(rowIndex).getLastname();
        }
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

    public void update(){
        fireTableDataChanged();
    }

    public void setData(List<Person> data){
        this.data = data;
    }

    public List<Person> getData(){
        return data;
    }
}
