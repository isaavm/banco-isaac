/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import model.Agencia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author Isaac
 */
public class Agencias implements Serializable {

    private TreeSet<Agencia> agencias;

    public Agencias() {
        this.agencias = new TreeSet<>();
        verificaArquivo();
        if (!ler().getAgencias().isEmpty()) {
            this.agencias = (TreeSet<Agencia>) ler().getAgencias();
        }
    }

    private void gravar() {
        try {
            FileOutputStream fo = new FileOutputStream("Agencias.data");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(agencias);
            oo.close();
            System.out.println("Arquivo de Agencias Gravado");
        } catch (Exception e) {
            System.err.println("Erro ao gravar " + e.getMessage());
        }
    }

    private Agencias ler() {
        Agencias dados = new Agencias();
        try {
            File arq = new File("Agencias.data");
            FileInputStream fi = new FileInputStream(arq.getAbsolutePath());
            ObjectInputStream oi = new ObjectInputStream(fi);
            dados = (Agencias) oi.readObject();
            oi.close();
        } catch (Exception e) {
            System.err.println("Erro ao ler " + e.getMessage());
        }
        return dados;
    }

    private void verificaArquivo() { // verificar a existência de um arquivo
        File arquivo = new File("Agencias.data");
        if (!arquivo.exists()) {
            try {
                gravar();// Fazer instancia
            } catch (Exception e) {
                System.err.println("Erro ao criar " + e.getMessage());
            }
        }
    }

    public void incluir(Agencia a) {
        agencias.add(a);
        gravar();
    }

    public Collection<Agencia> getAgencias() {
        return agencias;
    }

    public void excluir(Agencia a) throws Exception {
        if (agencias.contains(a)) {
            agencias.remove(a);
        } else {
            throw new Exception("Agencia inexistente");
        }
        gravar();
    }
}
