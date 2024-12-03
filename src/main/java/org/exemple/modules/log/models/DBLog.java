/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.exemple.modules.log.models;

import org.exemple.modules.log.interfaces.ILog;

public class DBLog implements ILog {
    
    @Override
    public void escreverMensagem(String mensagem){
        System.out.println("Log DB");
        public void gravarLog(String nomeUsuario, String data, String hora, String codigoPedido, String operacao, String nomeCliente) {
        String url = "jdbc:sqlite:logs.db";
        String sql = "INSERT INTO Log (nome_usuario, data, hora, codigo_pedido, operacao, nome_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.setString(1, nomeUsuario);
           pstmt.setString(2, data);
           pstmt.setString(3, hora);
           pstmt.setString(4, codigoPedido);
           pstmt.setString(5, operacao);
           pstmt.setString(6, nomeCliente);
           pstmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
