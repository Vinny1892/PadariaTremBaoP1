package conectionBD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Kaio
 */
public class ConexaoBD {

    public Statement stm; //responsavel por preparar e realizar pesquisas no BD
    public ResultSet rs;  //armazenar o resultado da pesquisa
    public String driver = "com.mysql.jdbc.Driver";  //identifica o serviço, mySQL postgreSQL ...
    private String caminho = "jdbc:mysql://localhost/clienteproduto"; //aonde o BD esta alocado
  //public String driver = "org.postgreesql.Driver";
  //private String camiho = "jdbc:postgresql://localhost:5432/projetoclinica"; 
    private String usuario = "root"; 
    private String senha = "";
    public Connection con;//realiza conexao com o BD
    
    
    public void conexao(){// metodo responsavel por conectar ao BD

        try {
            System.setProperty("jdbc.Drivers",driver);  //vai setar a propriedade do driver de conexao
            con=DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "conexão efetuada com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao se conectar com o Banco de Dados:\n  "+ex.getMessage());
        }
        
    }
    
    public void executaSql(String sql){
        try {
            //TYPE_SCROLL_INSENSITIVE faz diferenciação entre maiusculas e minusculas
            //CONCUR_READ_ONLY faz com que o rs/resultSet seja rolavel, percorrendo tanto do inicio para o fim e vice-versa
            // OU SEJA, PODEMOS SETAR TANTO O PRIMEIRO REGISTRO DO BANCO, COMO O ULTIMO
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro executaSql:\n"+ex.getMessage());

        }
        
    }
    
    
    
    
    
    
    public void desconecta(){ //metodo responsavel por desconectar do BD
        try {
        con.close();
        JOptionPane.showMessageDialog(null, "Desconectado com sucesso");
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "erro ao fechar conexao com Banco de dados:\n"+ex.getMessage());        }
    }
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
}//fim classe

