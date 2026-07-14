
package Classes;

public class TelefoneMensagem {
    
     int ID_fone;
    String fone;
    int Nacionalidade_fone;
    int ID_pessoa;
    int ID_Mensagem;
    String Mensagem;
    int ID_destinatario;
    int ID_remetente;

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

    public int getID_Mensagem() {
        return ID_Mensagem;
    }

    public void setID_Mensagem(int ID_Mensagem) {
        this.ID_Mensagem = ID_Mensagem;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public int getID_destinatario() {
        return ID_destinatario;
    }

    public void setID_destinatario(int ID_destinatario) {
        this.ID_destinatario = ID_destinatario;
    }

    public int getID_remetente() {
        return ID_remetente;
    }

    public void setID_remetente(int ID_remetente) {
        this.ID_remetente = ID_remetente;
    }

    public TelefoneMensagem() {
    }

    public TelefoneMensagem(int ID_fone, String fone, int Nacionalidade_fone, int ID_pessoa, int ID_Mensagem, String Mensagem, int ID_destinatario, int ID_remetente) {
        this.ID_fone = ID_fone;
        this.fone = fone;
        this.Nacionalidade_fone = Nacionalidade_fone;
        this.ID_pessoa = ID_pessoa;
        this.ID_Mensagem = ID_Mensagem;
        this.Mensagem = Mensagem;
        this.ID_destinatario = ID_destinatario;
        this.ID_remetente = ID_remetente;
    }
    
    
}
