package extratorcep;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RuaDAO {
    
    public static void save(Rua rua){
 
        /*
        * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
        * na base de dados
        */

        String sql = "INSERT INTO RUAS (NOME, TIPO, BAIRRO, CEP, CIDADE, ESTADO, AUTOMATICO)" +
        " VALUES(?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
        //Cria uma conexão com o banco
        conn = (Connection) ConnectionFactory.createConnectionToMySQL();

        //Cria um PreparedStatment, classe usada para executar a query
        pstm = (PreparedStatement) conn.prepareStatement(sql);
        
        
        pstm.setString(1, rua.getNome());
        pstm.setString(2, rua.getTipo());
        pstm.setString(3, rua.getBairro());
        pstm.setString(4, rua.getCep());
        pstm.setString(5, rua.getCidade());
        pstm.setString(6, rua.getEstado());
        pstm.setInt(7, 1);

        //Executa a sql para inserção dos dados
        pstm.execute();

        } catch (Exception e) {

        e.printStackTrace();
        }finally{
            
        //Fecha as conexões
        try{
            if(pstm != null){

                pstm.close();
            }

            if(conn != null){
                conn.close();
            }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }   
}
