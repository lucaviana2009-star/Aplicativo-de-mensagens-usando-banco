/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Telefone;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelefoneDAO {

    private Connection conn;

    public TelefoneDAO() {
    }

    public void inserir(Telefone telefone) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (telefone == null) {
            throw new ErpDAOException("O objeto telefone não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO telefone (fone, Nacionalidade_fone, ID_pessoa) "
                    + "values (?,?,?)";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, telefone.getFone());
            ps.setInt(2, telefone.getNacionalidade_fone());
            ps.setInt(3, telefone.getID_pessoa());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir um novo telefone " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public void atualizar(Telefone telefone) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (telefone == null) {
            throw new ErpDAOException("O objeto telefone não pode ser nulo.");
        }
        try {
            String SQL = "UPDATE telefone set fone=?, Nacionalidade_fone=?, ID_pessoa=? WHERE ID_fone=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, telefone.getFone());
            ps.setInt(2, telefone.getNacionalidade_fone());
            ps.setInt(3, telefone.getID_pessoa());
            ps.setInt(4, telefone.getID_fone());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar o telefone " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public Telefone procurar(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Telefone telefone = new Telefone();
        try {
            String SQL = "SELECT ID_fone, fone, Nacionalidade_fone, ID_pessoa FROM telefone WHERE ID_fone = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID_fone = rs.getInt("ID_fone");
                String fone = rs.getString("fone");
                int nacionalidade = rs.getInt("Nacionalidade_fone");
                int ID_pessoa = rs.getInt("ID_pessoa");

                telefone = new Telefone(ID_fone, fone, nacionalidade, ID_pessoa);
            }
            return telefone;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar o telefone " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList telefones = new ArrayList();
        try {
            String SQL = "SELECT ID_fone, fone, Nacionalidade_fone, ID_pessoa FROM telefone ORDER BY fone";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_fone = rs.getInt("ID_fone");
                String fone = rs.getString("fone");
                int nacionalidade = rs.getInt("Nacionalidade_fone");
                int ID_pessoa = rs.getInt("ID_pessoa");

                telefones.add(new Telefone(ID_fone, fone, nacionalidade, ID_pessoa));
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }
        return telefones;
    }

    public void excluir(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM telefone WHERE ID_fone=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir o telefone " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public Telefone procurarPorNumero(String fone, int ddd) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Telefone telefone = new Telefone();
        try {
            String SQL = "SELECT ID_fone, fone, Nacionalidade_fone, ID_pessoa FROM telefone WHERE fone = ? AND Nacionalidade_fone = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, fone);
            ps.setInt(2, ddd);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID_fone = rs.getInt("ID_fone");
                String numero = rs.getString("fone");
                int nacionalidade = rs.getInt("Nacionalidade_fone");
                int ID_pessoa = rs.getInt("ID_pessoa");
                telefone = new Telefone(ID_fone, numero, nacionalidade, ID_pessoa);
            }
        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar o telefone pelo número " + sqle);
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return telefone;
    }

    public Telefone procurarPorPessoa(int idPessoa) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Telefone telefone = new Telefone();
        try {
            String SQL = "SELECT ID_fone, fone, Nacionalidade_fone, ID_pessoa FROM telefone WHERE ID_pessoa = ? ORDER BY ID_fone";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();
            if (rs.next()) {
                telefone = new Telefone(rs.getInt("ID_fone"), rs.getString("fone"),
                        rs.getInt("Nacionalidade_fone"), rs.getInt("ID_pessoa"));
            }
        } catch (SQLException sqle) {
            System.out.println("Erro ao procurar o telefone da pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps, rs);
        }
        return telefone;
    }

    public void excluirPorPessoa(int idPessoa) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM telefone WHERE ID_pessoa=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, idPessoa);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir os telefones da pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
