
package Classes;

public class Telefone {
    
    int ID_fone;
    String fone;
    int Nacionalidade_fone;
    int ID_pessoa;

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

    public int getNacionalidade_fone() {
        return Nacionalidade_fone;
    }

    public void setNacionalidade_fone(int Nacionalidade_fone) {
        this.Nacionalidade_fone = Nacionalidade_fone;
    }

    public int getID_pessoa() {
        return ID_pessoa;
    }

    public void setID_pessoa(int ID_pessoa) {
        this.ID_pessoa = ID_pessoa;
    }

    public Telefone() {
    }

    public Telefone(int ID_fone, String fone, int Nacionalidade_fone, int ID_pessoa) {
        this.ID_fone = ID_fone;
        this.fone = fone;
        this.Nacionalidade_fone = Nacionalidade_fone;
        this.ID_pessoa = ID_pessoa;
    }

    
}
