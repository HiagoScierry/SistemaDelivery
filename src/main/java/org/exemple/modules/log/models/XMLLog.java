/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.exemple.modules.log.models;

import org.exemple.modules.log.interfaces.ILog;

public class XMLLog implements ILog{
    
    @Override
    public void escreverMensagem(String mensagem){
        System.out.println("Log XML");
        public void gravarLog(String nomeUsuario, String data, String hora, String codigoPedido, String operacao, String nomeCliente) {
        String logEntry = String.format("<log>\n" +
                "    <nome_usuario>%s</nome_usuario>\n" +
                "    <data>%s</data>\n" +
                "    <hora>%s</hora>\n" +
                "    <codigo_pedido>%s</codigo_pedido>\n" +
                "    <operacao>%s</operacao>\n" +
                "    <nome_cliente>%s</nome_cliente>\n" +
                "</log>\n", nomeUsuario, data, hora, codigoPedido, operacao, nomeCliente);

        try (FileWriter file = new FileWriter("logs.xml", true)) {
            file.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
