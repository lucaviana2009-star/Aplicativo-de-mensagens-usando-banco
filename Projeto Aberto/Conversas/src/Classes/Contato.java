
package Classes;

public class Contato {

    int id_contato;
    int id_pessoa;
    int id_telefone;
    String nomeContato;
    String foneContato;

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(int id_telefone) {
        this.id_telefone = id_telefone;
    }

    public Contato() {
    }

    public Contato(int id_contato, int id_pessoa, int id_telefone) {
        this.id_contato = id_contato;
        this.id_pessoa = id_pessoa;
        this.id_telefone = id_telefone;
    }
}
