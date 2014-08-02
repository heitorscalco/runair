package projetotao;



public class ComboItem {
    
    String codigo;
    String jobTitle;
 
    public ComboItem(String codigo, String jobTitle) {
        this.jobTitle = jobTitle;
        this.codigo = codigo;
    }
 
    public String getValue() {
        return this.codigo;
    }

    public String getLabel() {
        return this.jobTitle;
    }

    @Override
    public String toString() {
        return jobTitle;
    }
    
}
