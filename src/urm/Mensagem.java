/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urm;

/**
 * Classe modelo para as mensagens dos resultados da compilação
 * @author muatsoft
 */
public class Mensagem {
    private String mensagem;
    private int linha;
     
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    
}
