package projetotao;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreadTroco implements Runnable {
    
    Produto[] produtos;
    double valor_total_venda = 0;
    
    public ThreadTroco(Produto[] produtos) {
        this.produtos = produtos;
        
        for(int cont = 0; cont < produtos.length; cont++) {
            this.valor_total_venda += produtos[cont].valor_venda * produtos[cont].quantidade;
        }
    }
    
    public void run () {
        
        DecimalFormat d = new DecimalFormat("####,##0.00");
            
        String[] options = {"OK"};
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("TOTAL: " + d.format(this.valor_total_venda) + ". Valor recebido: ");
        JTextField txt = new JTextField(20);
        panel.add(lbl);
        panel.add(txt);
        txt.requestFocus();
        
        

        //informa o valor total e solicita o valor que o cliente deu
        JOptionPane.showOptionDialog(null, panel, "Valor total da venda", JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        txt.requestFocus();
        
        
            try {
                double valor_recebido = Double.parseDouble(txt.getText().replace(",", "."));
                if (valor_recebido > this.valor_total_venda) {
                    JOptionPane.showMessageDialog(null, "Troco: " + d.format(valor_recebido - this.valor_total_venda));
                } else {
                    JOptionPane.showMessageDialog(null, "Você informou um valor menor que o custo total dos produtos");
                }
            } catch (Exception n) { //Se o cara apertar ok sem digitar nada (troco em branco)
                JOptionPane.showMessageDialog(null, "Você informou um valor errado para o troco");
            }
    }
}