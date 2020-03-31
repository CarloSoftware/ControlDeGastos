package modeloTablas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Categoria;

/**
 *
 * @author usuario
 */
public class TablaCategoría extends AbstractTableModel{
    private  Categoria categSelect=null;
    private  List<Categoria> filaCateg;
    private String[] titulos=null;
    private int indice;

    public TablaCategoría() {
        this.titulos =new String[] {"Categoría","Descripción"};
        filaCateg=new ArrayList<>();
    }

    public Categoria getCategoriaSeleccionada() {
        return categSelect;
    }

    public void setpCategoriaSeleccionada(Categoria categSeleccionada) {
        this.categSelect = categSeleccionada;
    }

    public List<Categoria> getFilaCategoria() {
        return filaCateg;
    }

    public void setFilaCategoria(List<Categoria> lapPersona) {
        this.filaCateg = lapPersona;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaCateg.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.categSelect=filaCateg.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return categSelect.getCategoria();
          case 1: return categSelect.getDescripcion();
          default: return null;
      
      }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
          case 0: return String.class;
          case 1: return String.class;
          default: return null;
      
      }
    }

    @Override
    public String getColumnName(int i) {
        return titulos[i];
    }
   
    
    
     public void agregar(Categoria objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaCateg.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Categoria objeto){
 if(objeto!=null){
 this.eliminar();
 filaCateg.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaCateg.remove(indice);
 
 fireTableDataChanged();
 
}
        
}
