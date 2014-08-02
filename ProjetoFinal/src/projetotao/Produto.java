package projetotao;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {
    int codigo;
    String descricao;
    double valor_compra;
    double valor_venda;
    boolean liberar_venda;
    int quantidade;
    
    public Produto(int codigo) {
        
        this.codigo = codigo;
        
        getInformacoesProduto();
    }
    
    public boolean getInformacoesProduto() {
        
        CoreSql c = new CoreSql();
        
        String sql = "SELECT * FROM b_produtos WHERE id = " + codigo + ";";
        
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "descricao", "valor_compra", "valor_venda", "liberar_venda"});
        
        if(retorno == null) {
            System.out.println("O produto não existe");
            
        } else {
            this.descricao = retorno[0][1];
            this.valor_compra = Double.parseDouble(retorno[0][2]);
            this.valor_venda = Double.parseDouble(retorno[0][3]);
            this.liberar_venda = (retorno[0][4].equals("1") ? true : false);
        
            sql = "SELECT SUM(quantidade) FROM b_produto_estoques WHERE produto_id = " + this.codigo + ";";

            retorno = c.executarQuery(sql, true, new String[]{"SUM(quantidade)"});
            if(retorno[0][0] != null) {
                this.quantidade = Integer.parseInt(retorno[0][0]);
            }
        }
        return true;
    }
    
    public boolean atualizaInformacoesDB() {
        
        CoreSql c = new CoreSql();
        
        //String sql = "UPDATE FROM b_produtos WHERE SET (descricao = '" + this.descricao + "', valor_compra = " + this.valor_compra + ", valor_venda = " + this.valor_venda + ", liberar_venda = " + this.liberar_venda + " WHERE id = " + this.codigo + ";";
        String sql = "UPDATE b_produtos SET descricao = '" + this.descricao + "', valor_compra = " + this.valor_compra + ", valor_venda = " + this.valor_venda + ", liberar_venda = " + this.liberar_venda + " WHERE id = " + this.codigo + ";" ;
        c.executarQuery(sql, false, null);
        
        return true;
    }
    
    public boolean verificaLiberacaoParaVenda() {
        if(this.liberar_venda) {
            return true;
        } else {
            return false;
        }
    }
    
    public String[][] getListaProdutos() throws ProjetoException {
        
        CoreSql c = new CoreSql();
        
        String sql = "SELECT * FROM b_produtos ORDER BY id;";
        
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "descricao", "valor_compra", "valor_venda", "liberar_venda"});
        
        if(retorno == null) {
            throw new ProjetoException("não existem produtos");
        }
        
        return retorno;
//        this.descricao = retorno[0][1];
//        this.valor_compra = Double.parseDouble(retorno[0][2]);
//        this.valor_venda = Double.parseDouble(retorno[0][3]);
//        this.liberar_venda = (retorno[0][4].equals("1") ? true : false);
//        
//        return true;
    }
    
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        
        return this.quantidade;
        
    }
    
    public int getCodigoEstoque(int id){
        
        CoreSql c = new CoreSql();
        String sql = "SELECT id from b_produto_estoques WHERE produto_id = "+id+";";
        String[][] resultado = c.executarQuery(sql, true, new String[]{"id"});
        
        if (resultado == null) {
            
            return 0;
            
        }
        
        System.out.println("Produto_Estoque_ID: "+Integer.parseInt(resultado[0][0]));
        return Integer.parseInt(resultado[0][0]);
        
    }
    
    public void descontarEstoque() throws ProjetoException {
        
        getInformacoesProduto();
        if(quantidade > 0) {
            String sql = "UPDATE b_produto_estoques SET quantidade = quantidade - 1 WHERE produto_id = " + this.codigo + " ORDER BY data_hora_lancamento ASC LIMIT 1;";

            CoreSql c = new CoreSql();
            String[][] retorno = c.executarQuery(sql, false, null);
        } else {
            throw new ProjetoException("Não existe estoque para descontar do produto " + this.descricao);
        }
        getInformacoesProduto();
    }
    
    public boolean EstaEmEstoque() throws ProjetoException {       
       // Verifica se tem produto em estoque, caso tenha 
       //Caso não tenha, retorna false.
        CoreSql c = new CoreSql(); 

        String sql = "SELECT * FROM b_produto_estoques WHERE produto_id = " + this.codigo + " AND quantidade > 0;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id","produto_id", "quantidade"});
        if(retorno != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean possuiRegistroNaTabelaDeEstoque() throws ProjetoException {       
       // Verifica se tem produto em estoque, caso tenha 
       //Caso não tenha, retorna false.
        CoreSql c = new CoreSql(); 

        String sql = "SELECT * FROM b_produto_estoques WHERE produto_id = " + this.codigo + ";";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id","produto_id", "quantidade"});
        if(retorno != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
