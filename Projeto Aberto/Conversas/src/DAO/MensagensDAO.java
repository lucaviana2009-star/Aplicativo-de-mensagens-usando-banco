
package DAO;

import Classes.Mensagens;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensagensDAO {

    private Connection conn;

    public MensagensDAO() {
    }

    public void inserir(Mensagens mensagem) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (mensagem == null) {
            throw new ErpDAOException("O objeto mensagem não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO mensagens (Mensagem, ID_destinatario, ID_remetente) "
                    + "values (?,?,?)";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, mensagem.getMensagem());
            ps.setInt(2, mensagem.getID_destinatario());
            ps.setInt(3, mensagem.getID_remetente());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma nova mensagem " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void atualizar(Mensagens mensagem) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (mensagem == null) {
            throw new ErpDAOException("O objeto mensagem não pode ser nulo.");
        }
        try {
            String SQL = "UPDATE mensagens set Mensagem=?, ID_destinatario=?, ID_remetente=? WHERE ID_mensagem=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, mensagem.getMensagem());
            ps.setInt(2, mensagem.getID_destinatario());
            ps.setInt(3, mensagem.getID_remetente());
            ps.setInt(4, mensagem.getID_Mensagem());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar a mensagem " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public Mensagens procurar(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Mensagens mensagem = new Mensagens();
        try {
            String SQL = "SELECT ID_mensagem, Mensagem, ID_destinatario, ID_remetente FROM mensagens WHERE ID_mensagem = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID_mensagem = rs.getInt("ID_mensagem");
                String texto = rs.getString("Mensagem");
                int ID_destinatario = rs.getInt("ID_destinatario");
                int ID_remetente = rs.getInt("ID_remetente");

                mensagem = new Mensagens(ID_mensagem, texto, ID_destinatario, ID_remetente);
            }
            return mensagem;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar a mensagem " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList mensagens = new ArrayList();
        try {
            String SQL = "SELECT ID_mensagem, Mensagem, ID_destinatario, ID_remetente FROM mensagens ORDER BY ID_mensagem";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_mensagem = rs.getInt("ID_mensagem");
                String texto = rs.getString("Mensagem");
                int ID_destinatario = rs.getInt("ID_destinatario");
                int ID_remetente = rs.getInt("ID_remetente");

                mensagens.add(new Mensagens(ID_mensagem, texto, ID_destinatario, ID_remetente));
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }
        return mensagens;
    }

    public ArrayList listarConversa(int foneA, int foneB) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList mensagens = new ArrayList();
        try {
            String SQL = "SELECT ID_mensagem, Mensagem, ID_destinatario, ID_remetente FROM mensagens "
                    + "WHERE (ID_remetente = ? AND ID_destinatario = ?) "
                    + "OR (ID_remetente = ? AND ID_destinatario = ?) ORDER BY ID_mensagem";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, foneA);
            ps.setInt(2, foneB);
            ps.setInt(3, foneB);
            ps.setInt(4, foneA);
            rs = ps.executeQuery();
            while (rs.next()) {
                mensagens.add(new Mensagens(rs.getInt("ID_mensagem"), rs.getString("Mensagem"),
                        rs.getInt("ID_destinatario"), rs.getInt("ID_remetente")));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return mensagens;
    }

    public void excluir(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM mensagens WHERE ID_mensagem=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir a mensagem " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
