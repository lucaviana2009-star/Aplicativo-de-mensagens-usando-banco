/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Pessoa;
import Conexao.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaDAO {

    private Connection conn;

    public PessoaDAO() {
    }

    public int inserir(Pessoa pessoa) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        int idGerado = 0;
        if (pessoa == null) {
            throw new ErpDAOException("O objeto pessoa não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO pessoa (nome, sexo, dataNasc, Nacionalidade) "
                    + "values (?,?,?,?)";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL, java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, Character.toString(pessoa.getSexo()));
            java.util.Date dataJAVA = pessoa.getDataNasc();
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime());
            ps.setDate(3, dataSQL);
            ps.setString(4, pessoa.getNacionalidade_Pessoa());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            return idGerado;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma nova pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps, rs);
        }
    }

    public void atualizar(Pessoa pessoa) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (pessoa == null) {
            throw new ErpDAOException("O objeto pessoa não pode ser nulo.");
        }
        try {
            String SQL = "UPDATE pessoa set nome=?, sexo=?, dataNasc=?, Nacionalidade=? WHERE ID_pessoa=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, Character.toString(pessoa.getSexo()));
            java.util.Date dataJAVA = pessoa.getDataNasc();
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime());
            ps.setDate(3, dataSQL);
            ps.setString(4, pessoa.getNacionalidade_Pessoa());
            ps.setInt(5, pessoa.getID_pessoa());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar a pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public Pessoa procurar(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Pessoa pessoa = new Pessoa();
        try {
            String SQL = "SELECT ID_pessoa, nome, sexo, dataNasc, Nacionalidade FROM pessoa WHERE ID_pessoa = ?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID_pessoa = rs.getInt("ID_pessoa");
                String nome = rs.getString("nome");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                Date dataNasc = rs.getDate("dataNasc");
                String nacionalidade = rs.getString("Nacionalidade");

                pessoa = new Pessoa(ID_pessoa, nome, sexo, dataNasc, nacionalidade);
            }
            return pessoa;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar a pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList pessoas = new ArrayList();
        try {
            String SQL = "SELECT ID_pessoa, nome, sexo, dataNasc, Nacionalidade FROM pessoa ORDER BY ID_pessoa";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID_pessoa = rs.getInt("ID_pessoa");
                String nome = rs.getString("nome");
                char sexo;
                if (rs.getString("sexo") == null) {
                    sexo = ' ';
                } else {
                    sexo = (rs.getString("sexo")).charAt(0);
                }
                Date dataNasc = rs.getDate("dataNasc");
                String nacionalidade = rs.getString("Nacionalidade");

                pessoas.add(new Pessoa(ID_pessoa, nome, sexo, dataNasc, nacionalidade));
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            Conexao.close(connL, ps);
        }
        return pessoas;
    }

    public void excluir(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            String SQL = "DELETE FROM pessoa WHERE ID_pessoa=?";
            connL = Conexao.getConnection();
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir a pessoa " + sqle);
        } finally {
            Conexao.close(connL, ps);
        }
    }
}
