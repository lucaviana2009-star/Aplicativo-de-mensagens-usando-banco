
package Classes;

import java.util.Date;

public class Pessoa {
    
    int ID_pessoa;
    String nome;
    char sexo;
    Date dataNasc;
    String Nacionalidade_Pessoa;

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

    public Pessoa() {
    }

    public Pessoa(int ID_pessoa, String nome, char sexo, Date dataNasc, String Nacionalidade_Pessoa) {
        this.ID_pessoa = ID_pessoa;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.Nacionalidade_Pessoa = Nacionalidade_Pessoa;
    }

    
}
