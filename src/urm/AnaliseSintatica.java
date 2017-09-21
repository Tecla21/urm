/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urm;

import java.util.ArrayList;

/**
 *
 * @author muatsoft
 */
public class AnaliseSintatica {
    
    private boolean verifica;
    private int contLinha;
    public ArrayList<Mensagem> msgList;
    private Mensagem ms;

    public AnaliseSintatica() {
        this.msgList = new ArrayList<>();
        this.contLinha = 0;
        this.verifica = false;
    }
    // retorna o valor da linha que estamos a executar
    public int getContLinha() {
        return contLinha;
    }
    // alterar o número de linha actual
    public void setContLinha() {
        this.contLinha += 1;
    }
    // retorna o valor que valida a nossa compilação, caso verdadeiro quer dizer que não tem erro algum
    public boolean isVerifica() {
        return this.verifica;
    }
    // alterarmos o valor que valida a nossa compilação
    public void setIsVerifica(boolean verifica) {
        this.verifica = verifica;
    }
    // função que faz a compilação e a verificação da sintaxe do simulador
    public boolean analiseSintatica(String codigo) {
        String linhas[] = codigo.replaceAll(Constantes.testos[0], Constantes.testos[2]).split(Constantes.testos[1]);
        for (String linha : linhas) {
            setContLinha();
            this.ms = new Mensagem();
            char token[] = linha.toUpperCase().toCharArray();
            for (int i = 0; i < token.length; i++) {
                if (token[i] == Constantes.instrucao[0]) {
                    if (token.length == 4) {
                        if (token[i + 1] == Constantes.valores[0]) {
                            if (token[i + 2] == Constantes.valores[3] 
                                    || token[i + 2] == Constantes.valores[4] || token[i + 2] == Constantes.valores[5]
                                    || token[i + 2] == Constantes.valores[6] || token[i + 2] == Constantes.valores[7] 
                                    || token[i + 2] == Constantes.valores[8] || token[i + 2] == Constantes.valores[9]
                                    || token[i + 2] == Constantes.valores[10] || token[i + 2] == Constantes.valores[11]) {
                                if (token[i + 3] == Constantes.valores[1]) {
                                    //System.err.println("Linha " + getContLinha() + " esta boua");
                                    break;
                                } else {
                                    ms.setMensagem(Constantes.msg[1] + token[i + 3] + Constantes.testos[3]);
                                    ms.setLinha(getContLinha());
                                    break;
                                }
                            } else {
                                ms.setMensagem(Constantes.msg[3] + token[i + 2] + Constantes.testos[3]);
                                ms.setLinha(getContLinha());
                                break;
                            }
                        } else {
                            ms.setMensagem(Constantes.msg[0] + token[i + 1] + Constantes.testos[3]);
                            ms.setLinha(getContLinha());
                            break;
                        }
                    } else {
                        ms.setMensagem(Constantes.msg[4]);
                        ms.setLinha(getContLinha());
                        break;
                    }
                } else if (token[i] == Constantes.instrucao[2]) {
                    if (token.length == 4) {
                        if (token[i + 1] == Constantes.valores[0]) {
                            if (token[i + 2] == Constantes.valores[3] 
                                    || token[i + 2] == Constantes.valores[4] || token[i + 2] == Constantes.valores[5]
                                    || token[i + 2] == Constantes.valores[6] || token[i + 2] == Constantes.valores[7]
                                    || token[i + 2] == Constantes.valores[8] || token[i + 2] == Constantes.valores[9]
                                    || token[i + 2] == Constantes.valores[10] || token[i + 2] == Constantes.valores[11]) {
                                if (token[i + 3] == Constantes.valores[1]) {
                                    //System.err.println("Linha " + getContLinha() + " esta boua");
                                    break;
                                } else {
                                    ms.setMensagem(Constantes.msg[1] + token[i + 3] + Constantes.testos[3]);
                                    ms.setLinha(getContLinha());
                                    break;
                                }
                            } else {
                                ms.setMensagem(Constantes.msg[3] + token[i + 2] + Constantes.testos[3]);
                                ms.setLinha(getContLinha());
                                break;
                            }
                        } else {
                            ms.setMensagem(Constantes.msg[0] + token[i + 1] + Constantes.testos[3]);
                            ms.setLinha(getContLinha());
                            break;
                        }
                    } else {
                        ms.setMensagem(Constantes.msg[4]);
                        ms.setLinha(getContLinha());
                        break;
                    }
                } else if (token[i] == Constantes.instrucao[3]) {
                    //j(1,2,10)
                    //JOptionPane.showMessageDialog(null,linha + " -> " + linha.length() + " -> " + token.length);
                    if (token.length == 8 || token.length == 9) {
                        if (token[i + 1] == Constantes.valores[0]) {
                            if (token[i + 2] == Constantes.valores[3] 
                                    || token[i + 2] == Constantes.valores[4] || token[i + 2] == Constantes.valores[5]
                                    || token[i + 2] == Constantes.valores[6] || token[i + 2] == Constantes.valores[7] 
                                    || token[i + 2] == Constantes.valores[8] || token[i + 2] == Constantes.valores[9]
                                    || token[i + 2] == Constantes.valores[10] || token[i + 2] == Constantes.valores[11]) {
                                if (token[3] == Constantes.valores[2]) {
                                    if (token[i + 4] == Constantes.valores[3] 
                                            || token[i + 4] == Constantes.valores[4] || token[i + 4] == Constantes.valores[5]
                                            || token[i + 4] == Constantes.valores[6] || token[i + 4] == Constantes.valores[7]
                                            || token[i + 4] == Constantes.valores[8] || token[i + 4] == Constantes.valores[9]
                                            || token[i + 4] == Constantes.valores[10] || token[i + 4] == Constantes.valores[11]) {
                                        if (token[5] == Constantes.valores[2]) {
                                            if (token[i + 6] == Constantes.valores[3] 
                                                    || token[i + 6] == Constantes.valores[4] || token[i + 6] == Constantes.valores[5]
                                                    || token[i + 6] == Constantes.valores[6] || token[i + 6] == Constantes.valores[7] 
                                                    || token[i + 6] == Constantes.valores[8] || token[i + 6] == Constantes.valores[9]
                                                    || token[i + 6] == Constantes.valores[10] || token[i + 6] == Constantes.valores[11]) {
                                                if (token.length == 8) {
                                                    if (token[i + 7] == Constantes.valores[1]) {
                                                        //System.err.println("Linha " + getContLinha() + " esta boua");
                                                        break;
                                                    } else {
                                                        ms.setMensagem(Constantes.msg[1] + token[i + 7] + Constantes.testos[3]);
                                                        ms.setLinha(getContLinha());
                                                        break;
                                                    }
                                                } else {
                                                    if (token[i + 7] == Constantes.valores[3] 
                                                            || token[i + 7] == Constantes.valores[4] || token[i + 7] == Constantes.valores[5]
                                                            || token[i + 7] == Constantes.valores[6] || token[i + 7] == Constantes.valores[7] 
                                                            || token[i + 7] == Constantes.valores[8] || token[i + 7] == Constantes.valores[9]
                                                            || token[i + 7] == Constantes.valores[10] || token[i + 7] == Constantes.valores[11]
                                                            || token[i + 7] == Constantes.valores[12]) {
                                                        if (token[i + 8] == Constantes.valores[1]) {
                                                            //System.err.println("Linha " + getContLinha() + " esta boua");
                                                            break;
                                                        } else {
                                                            ms.setMensagem(Constantes.msg[1] + token[i + 7] + Constantes.testos[3]);
                                                            ms.setLinha(getContLinha());
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else {
                                                ms.setMensagem(Constantes.msg[3] + token[i + 6] + Constantes.testos[3]);
                                                ms.setLinha(getContLinha());
                                                break;
                                            }
                                        } else {
                                            ms.setMensagem(Constantes.msg[2] + token[i + 5] + Constantes.testos[3]);
                                            ms.setLinha(getContLinha());
                                            break;
                                        }
                                    } else {
                                        ms.setMensagem(Constantes.msg[3] + token[i + 4] + Constantes.testos[3]);
                                        ms.setLinha(getContLinha());
                                        break;
                                    }
                                } else {
                                    ms.setMensagem(Constantes.msg[2] + token[i + 3] + Constantes.testos[3]);
                                    ms.setLinha(getContLinha());
                                    break;
                                }
                            } else {
                                ms.setMensagem(Constantes.msg[3] + token[i + 2] + Constantes.testos[3]);
                                ms.setLinha(getContLinha());
                                break;
                            }
                        } else {
                            ms.setMensagem(Constantes.msg[0] + token[i + 1] + Constantes.testos[3]);
                            ms.setLinha(getContLinha());
                            break;
                        }
                    } else {
                        ms.setMensagem(Constantes.msg[4]);
                        ms.setLinha(getContLinha());
                        break;
                    }
                } else if (token[i] == Constantes.instrucao[1]) {
                    if (token.length == 6) {
                        if (token[i + 1] == Constantes.valores[0]) {
                            if (token[i + 2] == Constantes.valores[3] 
                                    || token[i + 2] == Constantes.valores[4] || token[i + 2] == Constantes.valores[5]
                                    || token[i + 2] == Constantes.valores[6] || token[i + 2] == Constantes.valores[7] 
                                    || token[i + 2] == Constantes.valores[8] || token[i + 2] == Constantes.valores[9]
                                    || token[i + 2] == Constantes.valores[10] || token[i + 2] == Constantes.valores[11]) {
                                if (token[3] == Constantes.valores[2]) {
                                    if (token[i + 4] == Constantes.valores[3] 
                                            || token[i + 4] == Constantes.valores[4] || token[i + 4] == Constantes.valores[5]
                                            || token[i + 4] == Constantes.valores[6] || token[i + 4] == Constantes.valores[7] 
                                            || token[i + 4] == Constantes.valores[8] || token[i + 4] == Constantes.valores[9]
                                            || token[i + 4] == Constantes.valores[10] || token[i + 4] == Constantes.valores[11]) {
                                        if (token[i + 5] == Constantes.valores[1]) {
                                            //System.err.println("Linha " + getContLinha() + " esta boua");
                                            break;
                                        } else {
                                            ms.setMensagem(Constantes.msg[1] + token[i + 4] + Constantes.testos[3]);
                                            ms.setLinha(getContLinha());
                                            break;
                                        }
                                    } else {
                                        ms.setMensagem(Constantes.msg[3] + token[i + 3] + Constantes.testos[3]);
                                        ms.setLinha(getContLinha());
                                        break;
                                    }
                                } else {
                                    ms.setMensagem(Constantes.msg[2] + token[i + 2] + Constantes.testos[3]);
                                    ms.setLinha(getContLinha());
                                    break;
                                }
                            } else {
                                ms.setMensagem(Constantes.msg[3] + token[i + 1] + Constantes.testos[3]);
                                ms.setLinha(getContLinha());
                                break;
                            }
                        }
                    } else {
                        ms.setMensagem(Constantes.msg[3] + getContLinha() + Constantes.testos[3]);
                        ms.setLinha(getContLinha());
                        break;
                    }
                } else if (token[i] == Constantes.instrucao[4]) {
                    break;
                } else {
                    ms.setMensagem(Constantes.msg[4]);
                    ms.setLinha(getContLinha());
                    break;
                }
                //j(1,1,1)
            }
            if (ms.getMensagem() != null && ms.getLinha() > 0) {
                msgList.add(ms);
            }
        }
        if (msgList.isEmpty()) {
            ms.setMensagem(Constantes.msg[5]);
            ms.setLinha(0);
            msgList.add(ms);
            setIsVerifica(true);
        } else {
            setIsVerifica(false);
        }
        return isVerifica();
    }
}
