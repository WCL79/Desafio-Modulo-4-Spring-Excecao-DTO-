package br.com.zup.desafiocatalisa100321.exceptions;
/**
 * @author Weslley.candido
 * @version 0.01
 * Classe responsavel pela criação de objetos de ERROS
 * As mensagem serão encaminhadas ao usuário no formato JSON
 */
public class ObjetoDeErro {
    private String notificacao;
    private String campo;

    /**
     * Construtor com parametro vazio
     */
    public ObjetoDeErro() {
    }
    /**
     * Construtor com parametro vazio
     */
    public ObjetoDeErro(String notificacao, String campo) {
        this.notificacao = notificacao;
        this.campo = campo;
    }
    /**
     * Os geteres e seteres devem ser aplicados respeitando padrão JavaBean
     * @return
     */
    public String getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}