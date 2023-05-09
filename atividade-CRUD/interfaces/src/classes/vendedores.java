package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.crud;

public class vendedores implements crud {
    private int id;
    private String nome;

    public vendedores(){}
    public vendedores(int id){
      if(id > 0){
        String sql = "SELECT * FROM vendedores Where id = ?";
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
        String sql = "INSERT INTO vendedores (nome) VALUES (?)";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, this.getNome());
        stmt.execute();

        }catch(SQLException e){
        System.out.println("Error no adicionar Vendedores: "+ e.toString());
        }
      }

    public ArrayList<vendedores> listaa3(){
        String sql =  "SELECT * FROM vendedores";
        ArrayList<vendedores> vendedores = new ArrayList<>();
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet registros = stmt.executeQuery();

            while(registros.next()){
            vendedores temp = new vendedores();
            temp.setId(registros.getInt("id"));
            temp.setNome(registros.getString("nome"));
            vendedores.add(temp);
            }
        }catch(SQLException e){
            System.out.println("Erro no Listar Vendedores: "+ e.toString());
        }
        return vendedores;
      }

      public void update(){
        String sql = "UPDATE Vendedores SET nome = ?, WHERE id = ?";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(2, this.getNome());
        stmt.setInt(5, this.getId());
        stmt.executeUpdate();
        }catch(SQLException e){
        System.out.println("Erro no Atualizar Vendedores: "+ e.toString());
        }
      }

      public void delete(){
        String sql = "DELETE FROM Vendedores WHERE id = ?";
        try{
            Connection con = DB.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, this.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erro no Excluir do Vendedores: " + e.toString());
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
    public ArrayList<clientes> listaa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaa'");
    }
    @Override
    public ArrayList<vendas> listaa4() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaa4'");
    }
}
