/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import collection.ICollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.funcionario.DiretorRegional;
import model.funcionario.Funcionario;

/**
 *
 * @author Isaac
 */
public class ListagemDiretorRegionalTableModel extends AbstractTableModel {

    private static final int COL_DIRETOR = 0;
    private static final int COL_REGIAO = 1;
    private List<Funcionario> funcionarios;

    public ListagemDiretorRegionalTableModel(ICollection funcionarios) {
        if (funcionarios != null) {
            Iterator<Funcionario> it = funcionarios.getAll().iterator();
            ArrayList<Funcionario> listaDirReg = new ArrayList<>();
            Funcionario f;
            while (it.hasNext()) {
                f = it.next();
                if (f instanceof DiretorRegional) {
                    listaDirReg.add(f);
                }
            }
            this.funcionarios = new ArrayList<>(listaDirReg);
        } else {
            this.funcionarios = new ArrayList<>();
        }
    }

    @Override
    public int getRowCount() {
        return this.funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DiretorRegional fun = (DiretorRegional) funcionarios.get(rowIndex);
        switch (columnIndex) {
            case COL_DIRETOR:
                return fun.getNome();
            case COL_REGIAO:
                return fun.getRegiao();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Funcionario getObject(int row){
        return this.funcionarios.get(row);
    }
}
