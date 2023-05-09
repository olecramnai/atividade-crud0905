package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.crud;

public class clientes implements crud {
    private int id;
    private String nome;

    public clientes(){}
    public clientes (int id){
      if(id > 0){
          String sql = "SELECT * FROM categoria Where id = ?";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registro = stmt.executeQuery();

        while(registro.next()){
          this.setId(registro.getInt("id"));
          this.setNome(registro.getString("nome"));
        }

        }catch(SQLException e){
          System.out.println("Error na consulta de Vendedores: " + e.toString());

        }
      }
    }

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
    
    public void add(){
        String sql = "INSERT INTO clientes (nome) VALUES (?)";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, this.getNome());
        stmt.execute();

        }catch(SQLException e){
        System.out.println("Error no adicionar Clientes: "+ e.toString());
        }
      }

    public ArrayList<clientes> listaa(){
        String sql =  "SELECT * FROM clientes";
        ArrayList<clientes> clientes = new ArrayList<>();
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while(registros.next()){
            clientes temp = new clientes();
            temp.setId(registros.getInt("id"));
            temp.setNome(registros.getString("nome"));
            clientes.add(temp);
            }
        }catch(SQLException e){
            System.out.println("Erro no Listar Categoria: "+ e.toString());
        }
        return clientes;
      }

      public void update(){
        String sql = "UPDATE clientes SET nome = ?, WHERE id = ?";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(2, this.getNome());
        stmt.setInt(5, this.getId());
        stmt.executeUpdate();
        }catch(SQLException e){
        System.out.println("Erro no Atualizar Clientes: "+ e.toString());
        }
      }

      public void delete(){
        String sql = "DELETE FROM clientes WHERE id = ?";
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro no Excluir do clientes: " + e.toString());
        }
      }

    public ArrayList<Categoria> list() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'list'");
    }
    @Override
    public ArrayList<Produto> lista() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'lista'");
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
