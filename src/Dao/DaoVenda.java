package Dao;

import Conexao.Banco;
import Model.Usuario;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoVenda {
    
    public Boolean salvarVenda(List<Venda> venda) {
        String sql = "INSERT INTO tbl_venda(codigo, nomeProduto, quantidade, valorTotal) VALUES (?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement pstm = null;
        
        try {
            int contando = venda.size();
            c = Banco.conectar();
            //Executar a query.
            
            for (int i = 0; i < contando; i++) {
                pstm = (PreparedStatement) c.prepareStatement(sql);
                pstm.setDouble(1, venda.get(i).getCodigo());
                pstm.setString(2, venda.get(i).getNomeProduto());
                pstm.setInt(3, venda.get(i).getQuantidade());
                pstm.setDouble(4, venda.get(i).getValor());
                
                pstm.execute();
            }
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar essa venda: " + e.getMessage());
            return null;
        }
        
    }
    
    public List<Venda> listarVenda(int codigo) {
        String sql = "SELECT *from tbl_venda WHERE codigo LIKE '%" + codigo + "%'";
        List<Venda> lista = new ArrayList<>();
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Venda v = new Venda();
                v.setCodigo(rs.getInt("codigo"));
                v.setNomeProduto(rs.getString("nomeProduto"));
                v.setQuantidade(rs.getInt("quantidade"));
                v.setValor(rs.getDouble("valorTotal"));
                
                lista.add(v);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
    public List<Venda> listarVenda() {
        String sql = "SELECT *from tbl_venda";
        List<Venda> lista = new ArrayList<>();
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Venda v = new Venda();
                v.setCodigo(rs.getInt("codigo"));
                v.setNomeProduto(rs.getString("nomeProduto"));
                v.setQuantidade(rs.getInt("quantidade"));
                v.setValor(rs.getDouble("valorTotal"));
                
                lista.add(v);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
}
