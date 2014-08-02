package projetotao;

import java.io.IOException;
import java.net.*;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class CoreSql {
    
    private String CONFIRMACAO_SQL = "OK";
    //Meu banco [Heitor] 
   public static String db_conexao = "jdbc:mysql://0.0.0.0:3306/tickets?user=administrador&password=admin";
    
    public CoreSql() {
//        Licenciamento lic = new Licenciamento();
//        if(lic.validarLicenca("b6fbf8c7c45ee9a34e76b6a8a4145c938ea7a03f") == false) {
//            System.out.println("Este computador não esta licenciado");
//            System.exit(0);
//        }
    }

    public String[][] executarQuery(String sql, boolean obter_retorno, String[] atributosARetornar) { 
        
        if(atributosARetornar == null) {
            atributosARetornar = new String[]{};
        }
        
        String[][] retorno = new String[999999][atributosARetornar.length];
        int cont_linhas = 0;
        
        try {   
            Class.forName("com.mysql.jdbc.Driver");   
                Connection con = DriverManager.getConnection(new CoreSql().db_conexao);
            Statement st = con.createStatement();   
            ResultSet rs = null;

            if(obter_retorno) {
                
                rs = st.executeQuery(sql);
                while (rs.next()){
                    for(int i = 0; i < atributosARetornar.length; i++) {
                        retorno[cont_linhas][i] = rs.getString(atributosARetornar[i]);
                    }
                    cont_linhas++;
                }
            } else {
                st.executeUpdate(sql);
            }
            
            st.close();   
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
        
        String[][] resultado_final = null;
        if(obter_retorno && cont_linhas > 0) {
            resultado_final = new String[cont_linhas][atributosARetornar.length];
            for(int c = 0; c < cont_linhas; c++) {
                resultado_final[c] = retorno[c];
            }
        }
        return resultado_final;
        
    }
    
    
    
    
    
    
    /*
    public static void main(String[] args) {
        ProjetoTao a1 = new ProjetoTao();
        //a1.verificarLicenca();
        try {
            
            a1.contabilizar(1);
            
            
        } catch (ProjetoException ex) {
            System.out.println(ex.getMessage());
        }
    }
    */
}
