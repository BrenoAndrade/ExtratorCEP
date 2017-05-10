package extratorcep;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RuaRepositoryMysql {
    public static void InserirRua(Rua rua){
        try {
            //Registra JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
 
            //Abrindo a conexão: ATENÇÃO OS DOIS PARÂMETROS VAZIOS("") SÃO USUÁRIO E SENHA, RESPECTIVAMENTE.
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/novagasdb", "root", "102569br");
 
            //Executa a query de inserção
            java.sql.Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO RUAS (NOME, TIPO, BAIRRO, CEP, CIDADE, ESTADO) VALUES ("
                    + rua.getNome()     + ",'"
                    + rua.getTipo()     + "','"
                    + rua.getBairro()   + "','"
                    + rua.getCep()      + "','"
                    + rua.getCidade()   + "','"
                    + rua.getEstado()   + "')");

        } catch (SQLException | ClassNotFoundException e) {
            
        }//Fim try

    }
}
