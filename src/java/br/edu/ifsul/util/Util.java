/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author 201523260319
 */
public class Util {
    public static String getMensagemErro(Exception e){
        //aqui vou percorrer a exceçao ate achar ela de mais baixo nivel
        while(e.getCause() !=null){
            e=(Exception) e.getCause();
        }
        //aqui captura a mensagem de erro para tratar
        String retorno= e.getMessage();
        if(retorno.contains("foreign key")){
            retorno = "Registro não pode ser excluido por possuir referencia em outros objetos";
        }
        return retorno;
    }
    
    public static void mensagemInformacao(String msg){
        FacesContext contexto =  FacesContext.getCurrentInstance();
        contexto.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        contexto.addMessage(null, mensagem);
    }
    
    public static void mensagemErro(String msg){
        FacesContext contexto =  FacesContext.getCurrentInstance();
        contexto.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        contexto.addMessage(null, mensagem);
    }
    
}
