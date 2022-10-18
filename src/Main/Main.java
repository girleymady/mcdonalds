package Main;

import Dao.UsuarioDao;
import Model.Usuario;

public class Main {
    
    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = new Usuario();
//        usuario.setLogin("EDIT");
//        usuario.setNome("Gabriel Filipy da Silva Correa EDITADO");
//        usuario.setSenha("EDIT");
//        usuario.setTipo(2);
//        usuario.setId(2);

        usuario = usuarioDao.buscarUsuario(2);
        
        System.out.println(">>> " + usuario.getLogin());
        
    
        
    }
    
}
