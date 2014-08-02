
package projetotao;

import javax.swing.JOptionPane;

/**
 *
 * @author guiarrd
 */
public class Usuario {

    public int codigo, tipo_usuario;
    public String login, senha;
    private CoreSql c = new CoreSql();
    private String sql = "";
    private Boolean logado;
    Boolean login_correto;
    static String usuario;

    public Usuario(String login, String senha) {

        this.login = login;
        this.senha = senha;
        getInformacoesUsuario();

    }
    
    public Usuario(int codigo){
        
        this.codigo = codigo;
        getInformacoesUsuarioPorCodigo();
    }
    
    public Usuario(){
        
        
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isLogin_correto() {
        
        return login_correto;
        
    }

    public boolean getInformacoesUsuario() {

        sql = "SELECT * FROM b_usuarios WHERE login like '" + login + "' AND senha like '" + senha + "';";

        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "tipo_usuario", "logado"});

        if (retorno == null) {

            System.out.println("O usuario não existe");
            login_correto = false;
            return false;

        } else {

            this.codigo = Integer.parseInt(retorno[0][0]);
            this.tipo_usuario = Integer.parseInt(retorno[0][1]);
            usuario = login;
            if (Integer.parseInt(retorno[0][2]) == 0) {

                logado = false;

            } else {

                logado = true;

            }

            System.out.println("senha: " + senha);
            System.out.println("tipo_usuario: " + tipo_usuario);
            System.out.println("logado: " + logado);
            login_correto = true;
            return true;
        }
    }
    
    public boolean getInformacoesUsuarioPorCodigo() {

        sql = "SELECT * FROM b_usuarios WHERE id = "+this.codigo;

        String[][] retorno = c.executarQuery(sql, true, new String[]{"login", "senha" ,"tipo_usuario"});

        if (retorno == null) {

            System.out.println("O usuario não existe");
            login_correto = false;
            return false;

        } else {

            this.login = retorno[0][0];
            this.senha = retorno[0][1];
            this.tipo_usuario = Integer.parseInt(retorno[0][2]);
            System.out.println("Login: " + login);
            System.out.println("senha: " + senha);
            System.out.println("tipo_usuario: " + tipo_usuario);
            login_correto = true;
            return true;
        }
    }
    
    public String[][] getUsuarioLogado(){
        
        sql = "SELECT * FROM b_usuarios WHERE login = '"+usuario+"';";

        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "login", "senha", "tipo_usuario"});

        if (retorno == null) {

            System.out.println("Não há usuário logado!");
            return null;

        } else {

            this.codigo = Integer.parseInt(retorno[0][0]);
            this.login = retorno[0][1];
            this.senha = retorno[0][2];
            this.tipo_usuario = Integer.parseInt(retorno[0][3]);
            return retorno;
        }
        
    }
    
    public String[][] getUsuario(String login){
        
        sql = "SELECT * FROM b_usuarios WHERE login = '"+login+"';";
        System.out.println("LOGIN : " + login);
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "login", "senha", "tipo_usuario"});

        if (retorno == null) {
            
            System.out.println("Não há usuário logado!");
            return null;

        } else {

            this.codigo = Integer.parseInt(retorno[0][0]);
            this.login = retorno[0][1];
            this.senha = retorno[0][2];
            this.tipo_usuario = Integer.parseInt(retorno[0][3]);
            return retorno;
        }
        
    }

    public void addUsuario() {

        sql = "INSERT INTO b_usuarios (login, senha, tipo_usuario) VALUES ('" + login + "', '" + senha + "', " + tipo_usuario + "); ";
        c.executarQuery(sql, false, null);

    }

    public Boolean existe(String login) {

        sql = "SELECT id FROM b_usuarios WHERE login like '" + login + "';";
        String retorno[][] = c.executarQuery(sql, true, new String[]{"id"});
        if (retorno != null) {

            return true;

        } else {

            return false;

        }

    }

    public Boolean isLogado() {

        return this.logado;

    }
    
    public String[][] getListaUsuarios() throws ProjetoException {
        
        CoreSql c = new CoreSql();
        
        String sql = "SELECT * FROM b_usuarios ORDER BY id;";
        
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "login", "senha", "tipo_usuario"});
        
        if(retorno == null) {
            throw new ProjetoException("não existem usuarios");
        }
        
        return retorno;
    }
    
    public boolean atualizaInformacoesDB() {
        
        CoreSql c = new CoreSql();
        
        //String sql = "UPDATE FROM b_produtos WHERE SET (descricao = '" + this.descricao + "', valor_compra = " + this.valor_compra + ", valor_venda = " + this.valor_venda + ", liberar_venda = " + this.liberar_venda + " WHERE id = " + this.codigo + ";";
        String sql = "UPDATE b_usuarios SET login = '" + this.login + "', senha = '" + this.senha + "', tipo_usuario = " + this.tipo_usuario + " WHERE id = " + this.codigo + ";" ;
        c.executarQuery(sql, false, null);
        
        return true;
    }
    
    public void setLogado(Boolean logado){
        
        this.logado = logado;
        CoreSql c = new CoreSql();
        
        String sql = "UPDATE b_usuarios SET logado = "+(this.logado ? "1" : "0")+" WHERE login LIKE '"+this.usuario+"';";
        
        c.executarQuery(sql, false, null);
        
        
    }
    
    public void zerarLogado(Boolean logado){
        this.logado = logado;
        CoreSql c = new CoreSql();
        
        String sql = "UPDATE b_usuarios SET logado = "+(this.logado ? "1" : "0")+" WHERE login LIKE '"+this.login+"';";
        c.executarQuery(sql, false, null);
    }
    
}
