package interfaces;

import java.util.ArrayList;

import classes.Categoria;
import classes.Produto;
import classes.clientes;
import classes.vendas;
import classes.vendedores;

public interface crud {
  public void add();
  public ArrayList<Categoria> list();
  public ArrayList<Produto> lista();
  public ArrayList<clientes> listaa();
  public ArrayList<vendedores> listaa3();
  public ArrayList<vendas> listaa4();
  public void update();
  public void delete();
  
}
