
package GUI;

import Classes.Pessoa;
import Classes.Telefone;
import DAO.PessoaDAO;
import DAO.TelefoneDAO;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarPerfis extends javax.swing.JFrame {

    public ListarPerfis() {
        setTitle("Todos os Perfis");
        setSize(400, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nome", "Número",}, 0);
        carregar(modelo);

        JTable tabela = new JTable(modelo);
        add(new JScrollPane(tabela));
    }

    private void carregar(DefaultTableModel modelo) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        ArrayList pessoas = pessoaDAO.listar();
        for (Object o : pessoas) {
            Pessoa p = (Pessoa) o;
            Telefone t = telefoneDAO.procurarPorPessoa(p.getID_pessoa());
            String numero;
            if (t == null || t.getFone() == null || t.getFone().isEmpty()) {
                numero = "(sem número)";
            } else {
                numero = t.getFone();
            }
            modelo.addRow(new Object[]{p.getNome(), numero});
        }
    }
}
