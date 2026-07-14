
package DAO;

import Classes.Contato;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDAO {

    private Connection conn;

    public ContatoDAO() {
    }

    public void inserir(Contato contato) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (contato == null) {
            throw new ErpDAOException("O objeto contato não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO contato (id_pessoa, id_telefone) values (?,?)";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, contato.getId_pessoa());
            ps.setInt(2, contato.getId_telefone());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao adicionar o contato " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public boolean existe(int idPessoa, int idTelefone) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        boolean achou = false;
        try {
            String SQL = "SELECT id_contato FROM contato WHERE id_pessoa = ? AND id_telefone = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idPessoa);
            ps.setInt(2, idTelefone);
            rs = ps.executeQuery();
            if (rs.next()) {
                achou = true;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return achou;
    }


    public ArrayList listarPorPessoa(int idPessoa) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList lista = new ArrayList();
        try {
            String SQL = "SELECT c.id_contato, c.id_pessoa, c.id_telefone, p.nome, t.fone, t.Nacionalidade_fone "
                    + "FROM contato c "
                    + "JOIN telefone t ON c.id_telefone = t.ID_fone "
                    + "JOIN pessoa p ON t.ID_pessoa = p.ID_pessoa "
                    + "WHERE c.id_pessoa = ? ORDER BY p.nome";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contato c = new Contato(rs.getInt("id_contato"),
                        rs.getInt("id_pessoa"), rs.getInt("id_telefone"));
                c.setNomeContato(rs.getString("nome"));
                c.setFoneContato("(" + rs.getInt("Nacionalidade_fone") + ") " + rs.getString("fone"));
                lista.add(c);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return lista;
    }

    public void atualizar(Contato contato) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (contato == null) {
            throw new ErpDAOException("O objeto contato não pode ser nulo.");
        }
        try {
            String SQL = "UPDATE contato SET id_telefone = ? WHERE id_contato = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, contato.getId_telefone());
            ps.setInt(2, contato.getId_contato());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar o contato " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void excluir(int idContato) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM contato WHERE id_contato = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idContato);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir o contato " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void excluirPorPessoa(int idPessoa) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM contato WHERE id_pessoa = ? "
                    + "OR id_telefone IN (SELECT ID_fone FROM telefone WHERE ID_pessoa = ?)";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idPessoa);
            ps.setInt(2, idPessoa);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir contatos da pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
