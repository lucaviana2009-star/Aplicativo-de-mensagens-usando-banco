
package Classes;

import java.util.Date;

public class PessoaTelefone {
    
    int ID_pessoa;
    String nome;
    char sexo;
    Date dataNasc;
    String Nacionalidade_Pessoa;
    int ID_fone;
    String fone;
    int Nacionalidade;
    int id_pessoa;

    public int getID_pessoa() {
        return ID_pessoa;
    }

    public void setID_pessoa(int ID_pessoa) {
        this.ID_pessoa = ID_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNacionalidade_Pessoa() {
        return Nacionalidade_Pessoa;
    }

    public void setNacionalidade_Pessoa(String Nacionalidade_Pessoa) {
        this.Nacionalidade_Pessoa = Nacionalidade_Pessoa;
    }

    public int getID_fone() {
        return ID_fone;
    }

    public void setID_fone(int ID_fone) {
        this.ID_fone = ID_fone;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(int Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public PessoaTelefone() {
    }

    public PessoaTelefone(int ID_pessoa, String nome, char sexo, Date dataNasc, String Nacionalidade_Pessoa, int ID_fone, String fone, int Nacionalidade, int id_pessoa) {
        this.ID_pessoa = ID_pessoa;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.Nacionalidade_Pessoa = Nacionalidade_Pessoa;
        this.ID_fone = ID_fone;
        this.fone = fone;
        this.Nacionalidade = Nacionalidade;
        this.id_pessoa = id_pessoa;
    }
    
    
    
}
