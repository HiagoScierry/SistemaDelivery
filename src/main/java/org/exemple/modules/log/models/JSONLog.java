/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.exemple.modules.log.models;

import org.exemple.modules.log.interfaces.ILog;

public class JSONLog implements ILog{
    
    @Override
    public void escreverMensagem(String mensagem){
        System.out.println("Log JSON");
        public void gravarLog(String nomeUsuario, String data, String hora, String codigoPedido, String operacao, String nomeCliente) {
        JSONObject logEntry = new JSONObject();
        logEntry.put("nome_usuario", nomeUsuario);
        logEntry.put("data", data);
        logEntry.put("hora", hora);
        logEntry.put("codigo_pedido", codigoPedido);
        logEntry.put("operacao", operacao);
        logEntry.put("nome_cliente", nomeCliente);

        try (FileWriter file = new FileWriter("logs.json", true)) {
            file.write(logEntry.toString() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
