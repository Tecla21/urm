/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urm;

import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muatsoft
 */
public class Interpretador {
    // modelo da tabela de resultados

    private DefaultTableModel modelo;
    private int resultados;
    MaqURM mq;
    
    public Interpretador(DefaultTableModel modelo) {
        this.mq = new MaqURM(1);
        this.modelo = modelo;
        this.resultados = 0;
    }
    
    public DefaultTableModel getModelo() {
        return modelo;
    }
    
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    public int getResultados() {
        return resultados;
    }
    
    public void setResultados(int resultados) {
        this.resultados += resultados;
    }

    // método que faz a execução da simulação
    protected void ExecutarSimulacao(String codigo, int tempo) {
        int testeRep = 1000;
        String linhas[] = codigo.trim().toUpperCase().replaceAll(Constantes.testos[0], Constantes.testos[2]).split(Constantes.testos[1]);
        try {
            for (int i = 0; i < linhas.length; i++) {
                // System.err.println("CONTADOR: " + i);
                Exemplo.txtMensagemConsola.setText(listarElementos(linhas[i],i+1));
                
                espera(tempo);
                char token[] = linhas[i].toCharArray();
                if (linhas[i].isEmpty()) {
                    // System.err.println("EMPTY linha: " + i);
                } else if (token[0] == Constantes.instrucao[4]) {
                    // System.err.println("COMENT linha: " + i);
                } else if (token[0] == Constantes.instrucao[2]) {
                    zerarValor(Constantes.testos[2] + token[2]);
                    setResultados(1);
                    // System.err.println("ZIRO linha: " + i);
                } else if (token[0] == Constantes.instrucao[0]) {
                    incrementaValor(Constantes.testos[2] + token[2]);
                    setResultados(1);
                    // System.err.println("SUCESS linha: " + i);
                } else if (token[0] == Constantes.instrucao[1]) {
                    trocaValor(Constantes.testos[2] + token[4], Constantes.testos[2] + token[2]);
                    setResultados(1);
                    // System.err.println("TRANSFER linha: " + i);
                } else if (token[0] == Constantes.instrucao[3]) {
                    //j(1,2,3)
                    if (verificaIgualidade((Constantes.testos[2] + token[2]).trim(), (Constantes.testos[2] + token[4]).trim())) {
                        if (token.length == 8) {
                            i = Integer.parseInt((Constantes.testos[2] + token[6]).trim()) - 2;
                            // System.err.println("JUMP linha: " + i);
                        } else if (token.length == 9) {
                            i = Integer.parseInt((token[6] + Constantes.testos[2] + token[7]).trim()) - 2;
                            // System.err.println("JUMP linha: " + i);
                        }
                    }
                }
                if ((getResultados() == testeRep) || (getResultados() == testeRep) || (getResultados() == testeRep) || (getResultados() == testeRep)) {
                    testeRep += 1000;
                    if (textaContinuidade()) {
                    } else {
                        break;
                    }
                } else if (getResultados() > 5000) {
                    JOptionPane.showMessageDialog(null, Constantes.msg[14]);
                    break;
                }
            }
            
        } catch (NumberFormatException | HeadlessException exception) {
            JOptionPane.showMessageDialog(null, Constantes.msg[14]);
           // System.out.println("Exception: " + exception);
        }
    }

    // metodo que faz o teste da continuidade da simulacao, caso suspeita-se estar em um ciclo infinito
    private boolean textaContinuidade() {
        return (JOptionPane.showConfirmDialog(null, Constantes.msg[12] + getResultados() + Constantes.msg[13], Constantes.msg[11], JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    // metodo que adiciona uma linha nova na tabela de resultados a fim de ser manipuladas pelas instrunções

    private void adicionarLinha() {
        // Adiciona uma nova linha em branco no modelo 
        modelo.addRow(new String[]{
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 0)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 1)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 2)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 3)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 4)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 5)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 6)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 7)).toString()) + Constantes.testos[2],
            Constantes.testos[2] + Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), 8)).toString()) + Constantes.testos[2]
        });
    }
    // Método que faz a função da instrução SUSSEC "s"

    private void incrementaValor(String regito) {
        int coluna = Integer.parseInt(regito);
        adicionarLinha();
        int valor = Integer.parseInt((modelo.getValueAt((modelo.getRowCount() - 1), (coluna - 1))).toString());
        valor++;
        modelo.setValueAt(Constantes.testos[2] + valor, (modelo.getRowCount() - 1), (coluna - 1));
    }
    // Método que faz a função da instrução TRASNFER "t"

    private void trocaValor(String origem, String destino) {
        adicionarLinha();
        (modelo.getValueAt((modelo.getRowCount() - 1), (Integer.parseInt(origem) - 1))).toString();
        modelo.setValueAt((modelo.getValueAt((modelo.getRowCount() - 1), (Integer.parseInt(destino) - 1))).toString(),
                (modelo.getRowCount() - 1), (Integer.parseInt(origem) - 1));
    }
    // Método que faz a função da instrução ZERO "z"

    private void zerarValor(String registo) {
        adicionarLinha();
        modelo.setValueAt(Constantes.testos[6], (modelo.getRowCount() - 1), (Integer.parseInt(registo) - 1));
    }
    // Método que faz a o teste para a função JUMP "j"

    private boolean verificaIgualidade(String registo1, String registo2) {
        return (modelo.getValueAt((modelo.getRowCount() - 1), (Integer.parseInt(registo1) - 1)).toString().equalsIgnoreCase(
                modelo.getValueAt((modelo.getRowCount() - 1), (Integer.parseInt(registo2) - 1)).toString()));
    }

    // método que faz a execução da simulação passo a passo
    protected int passoApasso(String linhas, int contador) {
        try {
            // System.err.println("CONTADOR: " + i);
            Exemplo.txtMensagemConsola.setText(listarElementos(linhas, contador + 1));
            
            char token[] = linhas.toCharArray();
            if (linhas.isEmpty()) {
                // System.err.println("EMPTY linha: " + i);
            } else if (token[0] == Constantes.instrucao[4]) {
                // System.err.println("COMENT linha: " + i);
            } else if (token[0] == Constantes.instrucao[2]) {
                zerarValor(Constantes.testos[2] + token[2]);
                setResultados(1);
                // System.err.println("ZIRO linha: " + i);
            } else if (token[0] == Constantes.instrucao[0]) {
                incrementaValor(Constantes.testos[2] + token[2]);
                setResultados(1);
                // System.err.println("SUCESS linha: " + i);
            } else if (token[0] == Constantes.instrucao[1]) {
                trocaValor(Constantes.testos[2] + token[4], Constantes.testos[2] + token[2]);
                setResultados(1);
                // System.err.println("TRANSFER linha: " + i);
            } else if (token[0] == Constantes.instrucao[3]) {
                //j(1,2,3)
                if (verificaIgualidade((Constantes.testos[2] + token[2]).trim(), (Constantes.testos[2] + token[4]).trim())) {
                    if (token.length == 8) {
                        contador = Integer.parseInt((Constantes.testos[2] + token[6]).trim()) - 2;
                        // System.err.println("JUMP linha: " + i);
                    } else if (token.length == 9) {
                        contador = Integer.parseInt((token[6] + Constantes.testos[2] + token[7]).trim()) - 2;
                        // System.err.println("JUMP linha: " + i);
                    }
                }
            }
        } catch (NumberFormatException | HeadlessException exception) {
            JOptionPane.showMessageDialog(null, Constantes.msg[14]);
        }
        return contador;
    }
    
    private void espera(int num) {
        try {
            Thread.sleep(num * 10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interpretador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     // listar operacaos na consola
    protected String listarElementos(String token, int cont){
        switch(token.toLowerCase().charAt(0)){
            case 's':
                token = Constantes.testos[4] + Constantes.testos[0] + cont + Constantes.testos[13] + Constantes.testos[0] + Constantes.instrucoes[0] + token.substring(1,token.length());
                break;
            case 'z':
                token = Constantes.testos[4] + Constantes.testos[0] + cont + Constantes.testos[13] + Constantes.testos[0] + Constantes.instrucoes[1] + token.substring(1,token.length());
                break;
            case 'j':
                token = Constantes.testos[4] + Constantes.testos[0] + cont + Constantes.testos[13] + Constantes.testos[0] + Constantes.instrucoes[2] + token.substring(1,token.length());
                break;
            case 't':
                token = Constantes.testos[4] + Constantes.testos[0] + cont + Constantes.testos[13] + Constantes.testos[0] + Constantes.instrucoes[3] + token.substring(1,token.length());
                break;
        }
        
        return token;
    }
}
