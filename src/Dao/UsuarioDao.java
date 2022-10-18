package Dao;

import Conexao.Banco;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao {
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO tbl_usuario(nome, login, senha, tipo) VALUES (?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement pstm = null;
        
        try {
            c = Banco.conectar();
            //Executar a query.
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setInt(4, usuario.getTipo());
            
            pstm.execute();
            return usuario;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar cadastrar esse usuário: " + e.getMessage());
            return null;
        }
        
    }
    
    public Usuario buscarUsuario(int id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT *from tbl_usuario WHERE id = " + id;
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
        
    }
    
    public Usuario buscarUsuario(String login) {
        Usuario usuario = new Usuario();
        String sql = "SELECT *from tbl_usuario WHERE login = ?";
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            while(rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
        
    }
    
    public List<Usuario> listarUsuario() {
        String sql = "SELECT *from tbl_usuario";
        List<Usuario> lista = new ArrayList<>();
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                
                lista.add(usuario);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
    public List<Usuario> listarUsuario(String nome) {
        String sql = "SELECT *from tbl_usuario WHERE  nome  LIKE '%" + nome +"%'"; 
        List<Usuario> lista = new ArrayList<>();
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
                
                lista.add(usuario);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
    public boolean deletarUsuario(int id) {
        String sql = "DELETE FROM tbl_usuario WHERE id = ?";
        Connection c = null;
        PreparedStatement pstm = null;
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }  
        return true;
    }
    
    public Boolean atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE tbl_usuario SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id = ?";
        Connection c = null;
        PreparedStatement pstm = null;
        try {
            c = Banco.conectar();
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setInt(4, usuario.getTipo());
            pstm.setInt(5, usuario.getId());
            
            pstm.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return true;
    }
    
    public Boolean logar(Usuario usuario) {
        String sql = "SELECT *FROM tbl_usuario WHERE login = ? AND senha = ?";
        Connection c = null;
        PreparedStatement pstm = null;
        try {
            c = Banco.conectar(); 
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin());
            pstm.setString(2, usuario.getSenha());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                return true;
            }
            pstm.execute();
        } catch (Exception e) {
        }
        return false;
    }
    
    public Usuario usuarioLogado(Usuario usuario) {
        String sql = "INSERT INTO tbl_usuario_logado(nome, login, tipo) VALUES (?, ?, ?)";
        Connection c = null;
        PreparedStatement pstm = null;
        
        try {
            c = Banco.conectar();
            //Executar a query.
            pstm = (PreparedStatement) c.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getLogin());
            pstm.setInt(3, usuario.getTipo());
            
            pstm.execute();
            return usuario;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar logar esse usuário: " + e.getMessage());
            return null;
        }
        
    }
    
    public boolean isRegistro() throws SQLException {
        String sql = "SELECT *FROM tbl_usuario WHERE login = ? AND senha = ?";
        Connection c = null;
        PreparedStatement pstm = null;
        boolean result = false; 
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            result = true;
        }
        pstm.close();
        return result;	
    }
    
}
