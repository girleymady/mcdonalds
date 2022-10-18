package Controller;

import Dao.DaoVenda;
import Model.Venda;
import java.util.List;

public class VendaController {
    
    DaoVenda dao = new DaoVenda();
    
    public Boolean salvarCompras(List<Venda> venda) {
        return dao.salvarVenda(venda);
    }
    
    public List<Venda> listar(int codigo) {
        return dao.listarVenda(codigo);
    }
    
    public List<Venda> listar() {
        return dao.listarVenda();
    }
    
}
