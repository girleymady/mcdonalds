package Controller;

import Dao.UsuarioDao;
import Model.Usuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    
    UsuarioDao dao = new UsuarioDao();
    
    public Usuario cadastrar(Usuario usuario) {
        return dao.cadastrarUsuario(usuario);
    }
    
    public Usuario buscar(int id) {
        return dao.buscarUsuario(id);
    }
    
    public Usuario buscar(String login) {
        return dao.buscarUsuario(login);
    }
    
    public List<Usuario> listar() {
        return dao.listarUsuario();
    }
    
    public List<Usuario> listar(String nome) {
        return dao.listarUsuario(nome);
    }
    
    public Boolean deletar(int id) {
        return dao.deletarUsuario(id);
    }
    
    public Boolean atualizar(Usuario usuario) { 
        return dao.atualizarUsuario(usuario);
    }
    
    public Boolean verificaLoginUsuario(Usuario usuario) { 
        return dao.logar(usuario);
    }
    
    public Usuario adicionarUsuarioLogado(Usuario usuario) {
        return dao.usuarioLogado(usuario);
    }
    
    public Boolean temUsuarioLogado() throws SQLException { 
        return dao.isRegistro();
    }
    
}
