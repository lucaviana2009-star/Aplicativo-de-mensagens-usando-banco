
package Conexao.util;

import Classes.Pessoa;
import DAO.PessoaDAO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class salvarPerfil {

    public static void grava(int id) {
        try {
            FileOutputStream arquivo = new FileOutputStream("perfil.dat");
            DataOutputStream fluxo = new DataOutputStream(arquivo);
            fluxo.writeInt(id);
            fluxo.flush();
            System.out.println("Perfil gravado com sucesso no arquivo perfil.dat");
        } catch (Exception e) {
            System.out.println("Falha na gravação do arquivo" + (e));
        }
    }

    public static Pessoa le() {
        try {
            FileInputStream arquivo = new FileInputStream("perfil.dat");
            DataInputStream fluxo = new DataInputStream(arquivo);
            int id = fluxo.readInt();
            Pessoa p = new PessoaDAO().procurar(id);
            if (p == null || p.getID_pessoa() == 0) {
                return null;
            }
            return p;
        } catch (Exception e) {
            System.out.println("Falha na leitura do arquivo" + (e));
            return null;
        }
    }

    public static void apaga() {
        new File("perfil.dat").delete();
    }
}
