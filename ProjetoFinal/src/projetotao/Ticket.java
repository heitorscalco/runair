package projetotao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ParseConversionEvent;

public class Ticket {
    int codigo;
    int evento_id;
    String data_geracao;
    Produto produto;
    double valor_compra;
    double valor_venda; 
    private Usuario u = new Usuario();
    private String[][] retorno;
    boolean contabilizado;
    boolean excluido;
    
    public Ticket(){
        
       //retorno = u.getUsuarioLogado();
        
    }
    
    public boolean criar(Produto produto) throws ProjetoException {
       
        if(produto.verificaLiberacaoParaVenda() == false) {
            throw new ProjetoException("O produto não pode ser vendido, pois sua venda foi bloqueada!");
        }        

        if(ProdutoEmEstoque(produto.codigo) == true) {
            
            
            
            produto.descontarEstoque();
            CoreSql c = new CoreSql();
            try {
                String sql = "INSERT INTO b_ticket (evento_id,  data_geracao, produto_id, valor_venda, usuario_id, produto_estoque_id) VALUES  " +
                            "( (SELECT id FROM b_eventos order by id desc limit 1), CURDATE(), " + produto.codigo + ", " + produto.valor_venda + ", (SELECT id FROM b_usuarios WHERE login = '" + new Usuario().usuario + "' limit 1), "+produto.getCodigoEstoque(produto.codigo)+");";
                c.executarQuery(sql, false, null);
            } catch (Exception ex) {
               throw new ProjetoException("Ocorreu um erro inesperado na criação do Ticket!");
            }    
        } else {
            throw new ProjetoException("O produto " + produto.descricao + " não está mais em estoque!");
        }
        return true;
    }
    
    
    private boolean ProdutoEmEstoque(int codigo) throws ProjetoException {       
       // Verifica se tem produto em estoque, caso tenha, subtrai 1 da quantidade. 
       //Caso não tenha, retorna false.
        CoreSql c = new CoreSql(); 

        String sql = "SELECT * FROM b_produto_estoques WHERE produto_id = " + codigo + " AND quantidade > 0;";
        String[][] retorno = c.executarQuery(sql, true, new String[]{"id","produto_id", "quantidade"});
        if(retorno != null) {
            return true;
        } else {
            return false;
        }
        
//        int id = Integer.parseInt(retorno[0][0]);
//        int qtd = Integer.parseInt(retorno[0][2]);
//        qtd = qtd - 1;
//        
//        if(qtd >= 0){
//            try {               
//                String sql_update = "UPDATE b_produto_estoques SET quantidade = " + qtd + " WHERE id = " + id + ";";            
//                String[][] retorno_update = c.executarQuery(sql_update, false, null);             
//                return true;
//            } catch (Exception ex) {
//                throw new ProjetoException("Ocorreu um erro inesperado na verificação do estoque");
//            }
//        } else {
//            return false;
//        };
        
        

    }
    
    public boolean getTicket() throws ProjetoException {
        
        try {
            System.out.println(this.codigo);
            
            CoreSql c = new CoreSql();
            String sql = "SELECT * FROM b_ticket WHERE id = " + this.codigo + ";";
            String[][] retorno = c.executarQuery(sql, true, new String[]{"id", "data_geracao", "data_contabilizacao", "produto_id", "valor_venda", "evento_id", "excluido"});

            if(retorno == null) {
                throw new ProjetoException("O ticket não existe");
            }
            
            this.codigo = codigo;
            this.data_geracao = retorno[0][1];
            
            if(retorno[0][2] == null) {
                this.contabilizado = false;
            } else {
                this.contabilizado = true;
            }
            
            
            this.produto = new Produto(Integer.parseInt(retorno[0][3]));
            
            
//            this.valor_compra = Double.parseDouble(retorno[0][4]);
            this.valor_venda = Double.parseDouble(retorno[0][4]);
            this.evento_id = Integer.parseInt(retorno[0][5]);
            this.excluido = (Integer.parseInt(retorno[0][6]) == 0 ? false : true );
            
        } catch(ProjetoException er) {
            throw new ProjetoException(er.getMessage());
        } catch(Exception er) {
            throw new ProjetoException("Ocorreu um erro inesperado na classe Ticket: " + er.getMessage());
        } 
        return true;
    }
    

    public boolean contabilizar(int codigo) throws ProjetoException {
        
            CoreSql c = new CoreSql();
            this.setTicket(codigo);
            this.getTicket();
            
            if(this.contabilizado == true) {
                throw new ProjetoException("O Ticket já foi Contabilizado!");
            }
            if(this.excluido == true) {
                throw new ProjetoException("O Ticket foi excluído!");
            }
            
            String sql = "UPDATE b_ticket SET data_contabilizacao = CURDATE() WHERE id = " + this.codigo + ";";

            String[][] retorno = c.executarQuery(sql, false, null);

        return true;
    }
    
    public boolean excluir() {
        
        try {
            CoreSql c = new CoreSql();

            String sql = "SELECT id FROM b_ticket " +
                            "WHERE id = " + this.codigo + " AND data_contabilizacao is null;";

            String[][] retorno = c.executarQuery(sql, true, new String[]{"id"});

            if(retorno == null) {
                System.out.println("O ticket não pode ser excluido pois ja foi contabilizado");
                return false;
            }

            sql = "UPDATE b_ticket SET excluido = 1 WHERE id = " + this.codigo + ";";
            c.executarQuery(sql, false, null);
                        
            
        } catch(Exception er) {
            System.out.println(er.getMessage());
        }
        return true;
    }
    
    public void setTicket(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigo(Produto produto){
        
//        System.out.println("produto.codigo: "+produto.codigo);//+", produto.valor_venda: "+produto.valor_venda+", usuario: "+new Usuario().usuario+" produto.getCodigoEstoque(produto.codigo): "+produto.getCodigoEstoque(produto.codigo));
//        return "";
        CoreSql c = new CoreSql();
        String sql = "SELECT id FROM b_ticket WHERE evento_id = (SELECT id FROM b_eventos order by id desc limit 1) AND produto_id = "+produto.codigo+" AND usuario_id = (SELECT id FROM b_usuarios WHERE login = '" + new Usuario().usuario + "' order by id desc limit 1) order by id desc limit 1";
//        String sql = "SELECT id FROM b_ticket WHERE evento_id = (SELECT id FROM b_eventos order by id desc limit 1)"
//                + " AND produto_id = "+produto.codigo+" AND valor_venda = "+produto.valor_venda+""
//                + " AND usuario_id = (SELECT id FROM b_usuarios WHERE login = '" + new Usuario().usuario + "' limit 1)"
//                + " AND produto_estoque_id = "+produto.getCodigoEstoque(produto.codigo)+";";
        String cod[][] = c.executarQuery(sql, true, new String[]{"id"});
        
        return cod[0][0];
    }
    
}
