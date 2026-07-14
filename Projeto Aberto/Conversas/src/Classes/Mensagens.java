
package Classes;

public class Mensagens {
    
    int ID_Mensagem;
    String Mensagem;
    int ID_destinatario;
    int ID_remetente;

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

    public Mensagens() {
    }

    public Mensagens(int ID_Mensagem, String Mensagem, int ID_destinatario, int ID_remetente) {
        this.ID_Mensagem = ID_Mensagem;
        this.Mensagem = Mensagem;
        this.ID_destinatario = ID_destinatario;
        this.ID_remetente = ID_remetente;
    }
    
    
}
