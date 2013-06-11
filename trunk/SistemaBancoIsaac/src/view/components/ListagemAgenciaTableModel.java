/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import collection.ICollection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Agencia;

/**
 *
 * @author Isaac
 */
public class ListagemAgenciaTableModel extends AbstractTableModel {

    private static final int COL_CODIGO = 0;
    private static final int COL_CIDADE = 1;
    private static final int COL_UF = 2;
    private List<Agencia> agencias;

    public ListagemAgenciaTableModel(ICollection agencias) {
        if (agencias != null) {
            this.agencias = new ArrayList<>(agencias.getAll());
        } else {
            this.agencias = new ArrayList<>();
        }
    }

    @Override
    public int getRowCount() {
        return this.agencias.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agencia ag = agencias.get(rowIndex);
        switch (columnIndex) {
            case COL_CODIGO:
                return ag.getCodigo();
            case COL_CIDADE:
                return ag.getCidade();
            case COL_UF:
                return ag.getUf();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Agencia getObject(int row) {
        return this.agencias.get(row);
    }
}
