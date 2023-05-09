package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.Override;

import interfaces.crud;

public class Categoria implements crud{
    private int id;
    private String name;
    
    public Categoria(){}
    public Categoria (int id){
      if(id > 0){
          String sql = "SELECT * FROM categoria Where id = ?";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registro = stmt.executeQuery();

        while(registro.next()){
          this.setId(registro.getInt("id"));
          this.setName(registro.getString("nome"));
        }

        }catch(SQLException e){
          System.out.println("Error na consulta de Categorias: " + e.toString());

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
  

    @Override
    public void add() {
      String sql = "INSERT INTO categorias (nome) VALUES (?)";
      try{
      Connection con = DB.conexao();
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, this.getName());
      stmt.execute();

      }catch(SQLException e){
      System.out.println("Error no adicionar Categoria: "+ e.toString());
      }
    }

    @Override
    public ArrayList<Categoria> list(){
      String sql =  "SELECT * FROM categorias";
      ArrayList<Categoria> categorias = new ArrayList<>();
      try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet registros = stmt.executeQuery();

        while(registros.next()){
          Categoria temp = new Categoria();
          temp.setId(registros.getInt("id"));
          temp.setName(registros.getString("nome"));

          categorias.add(temp);
        }
      }catch(SQLException e){
        System.out.println("Erro no Listar Categoria: "+ e.toString());
      }
      return categorias;
    }

    @Override
    public void update(){
      String sql = "UPDATE produtos SET nome = ?, WHERE id = ?";
      try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(2, this.getName());
        stmt.setInt(5, this.getId());
        stmt.executeUpdate();

      }catch(SQLException e){
        System.out.println("Erro no Atualizar Categoria: "+ e.toString());
      }
    }

    @Override
    public void delete(){
      String sql = "DELETE FROM categoria WHERE id = ?";
      try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, this.getId());
        stmt.executeUpdate();
      }catch(SQLException e){
        System.out.println("Erro no Excluir do Categoria: " + e.toString());
      }
    }

    @Override
    public ArrayList<Produto> lista() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'lista'");
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