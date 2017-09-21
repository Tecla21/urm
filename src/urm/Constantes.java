/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urm;

/**
 * Classe que tem como objectivo albergar tudo que seja constantes declaráveis
 *
 * @author muatsoft
 */
public class Constantes {

    protected static final char valores[] = {'(', ')', ',', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    protected static final char instrucao[] = {'S', 'T', 'Z', 'J', '\''};
    protected static final String testos[] = {" ", "\n", "", "'", "Linha: ", "\tMensagem: ", "0", "Resultado: ", "0","urm","URM",".urm","Ms","\t"};
    protected static final String registo[] = {"R 1", "R 2", "R 3", "R 4", "R 5", "R 6", "R 7", "R 8", "R 9", "R 10"};
    protected static final String msg[] = {
        "Erro de sintaxe, o caracter esperado é: \'" + Constantes.valores[0] + "\' e não \'",
        "Erro de sintaxe, o caracter esperado é: \'" + Constantes.valores[1] + "\' e não \'",
        "Erro de sintaxe, o caracter esperado é: \'" + Constantes.valores[2] + "\' e não \'",
        "Erro de sintaxe, o valor esperado é númerico: EX: \'1,2,3,4,5,6,7,8,9\' e não \'",
        "Erro de sintaxe, instrução não reconhecida.",
        "Código compilado com sucesso !!!", "Tem a certeza que pretende sair ?", "Pretende abandonar a simulação atual ?",
        "Ocorreu um erro de semântica ", "Executar a proxima instrução ?", "Simulação passo à passo", "Emulador URM",
        "A simulação está a ", " resultados. Prentende continuar ?",
        "Verifique o código, é possível que tenhas um ciclo infinito.\nA tabela de resultados atingio o limite.",
        "Estamos em um ciclo infinito, a simulação foi encerrada."
    };
    protected static final String template = "' Digite aqui as suas instruções\n"
            + "' na forma abreviada\n\n"
            + "";
    //public int registos [] = {0,0,0,0,0,0,0,0,0};
    protected static final String [] instrucoes = {"sucessor","zerar","saltar","transferir"}; 
    protected static final String textoLiceca = "\n\n\n\n\n\n\n\n\t\tDesenvolvido por: Muatsoft Developer\n\t\twebsite: http://www.muatsoft.eu5.org";
}
