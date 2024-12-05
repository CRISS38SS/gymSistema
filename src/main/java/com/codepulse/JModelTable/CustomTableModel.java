package com.codepulse.JModelTable;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = super.getValueAt(row, column);
    
        // Formatear las fechas para las columnas de fecha (por ejemplo, columnas 3 y 4)
        if ((column == 3 || column == 4) && value instanceof Date) {
            try {
                // Si es un objeto Date, formateamos la fecha
                SimpleDateFormat outputFormat = new SimpleDateFormat("d 'de' MMMM 'del' yyyy");
                return outputFormat.format((Date) value); // Formateamos la fecha
            } catch (Exception e) {
                // Si algo falla, retornamos el valor original
                return value;
            }
        }
    
        return value; // Retornamos el valor original si no es una fecha
    }
    
}
