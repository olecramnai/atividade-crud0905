package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.crud;

public class Produto implements crud{
  int id;
  int group_Id;
  String name;
  double value;
  int quantity;
  
  public Produto(){}
  public Produto (int id) {
    if(id > 0){
      String sql = "SELECT * FROM produtos WHERE id = ?";

      try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registro = stmt.executeQuery();

        while(registro.next()){
          this.setId(registro.getInt("id"));
          this.setName(registro.getString("nome"));
          this.setValue(registro.getDouble("preco"));
          this.setQuantity(registro.getInt("quantidade"));
        }

      }catch(SQLException e){
        System.out.println("Error na consulta de Produtos: " + e.toString());

      }
    }
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getValue() {
    return value;
  }
  public void setValue(double value) {
    this.value = value;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getGroup_Id() {
    return group_Id;
  }
  public void setGroup_Id(int group_Id) {
    this.group_Id = group_Id;
  }


  @Override
  public void add() {
    String sql = "INSERT INTO produtos (categoria_id, nome, preco, quantidade) VALUES (?,?,?,?)";
    try{
      Connection con = DB.conexao();
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, this.getGroup_Id());
      stmt.setString(2, this.getName());
      stmt.setDouble(3, this.getValue());
      stmt.setInt(4, this.getQuantity());
      stmt.execute();

    }catch(SQLException e){
      System.out.println("Erro na consultsa de Produtos" +e.toString());
    }
  }

  @Override
  public void delete() {
    String sql = "DELETE FROM produtos WHERE id = ?";
    try{
      Connection con = DB.conexao();
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, this.getId());
      stmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("Erro no Excluir do Produto: " + e.toString());
    }
  }

  @Override
  public ArrayList<Produto> lista() {
    String sql = "SELECT * FROM produtos";
    ArrayList<Produto> produtos = new ArrayList<>();
    try{
      Connection con = DB.conexao();
      PreparedStatement stmt = con.prepareStatement(sql);
      ResultSet registros = stmt.executeQuery();

      while(registros.next()){
        Produto temp = new Produto();
        temp.setGroup_Id(registros.getInt("group_Id"));
        temp.setName(registros.getString("nome"));
        temp.setValue(registros.getDouble("9.99"));
        temp.setQuantity(registros.getInt("12"));

        produtos.add(temp);
      }
    }catch(SQLException e){
      System.out.println("Erro no Listar Produtos"+ e.toString());
    }
    return produtos;
  }

  @Override
  public void update() {
    String sql = "UPDATE produtos SET categoria_id = ?, nome = ?, preco = ?, quantidade = ? WHERE id = ?";
    try{
      Connection con = DB.conexao();
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, this.getGroup_Id());
      stmt.setString(2, this.getName());
      stmt.setDouble(3, this.getValue());
      stmt.setInt(4, this.getQuantity());
      stmt.setInt(5, this.getId());
      stmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("Erro no Atualizar Produto: "+ e.toString());
    }   
  }

  @Override
  public ArrayList<Categoria> list() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'list'");
  }
  @Override
  public ArrayList<clientes> listaa() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listaa'");
  }
  @Override
  public ArrayList<vendedores> listaa3() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listaa3'");
  }
  @Override
  public ArrayList<vendas> listaa4() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listaa4'");
  }
}
