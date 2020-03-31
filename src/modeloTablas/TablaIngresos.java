package modeloTablas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Ingreso;
import modelo.Persona;
import modelo.Categoria;
/**
 *
 * @author usuario
 */
public class TablaIngresos extends AbstractTableModel{
    private  Ingreso ingreSelect=null;
    private  List<Ingreso> filaIngreso;
    private String[] titulos=null;
    private int indice;
    
    public TablaIngresos() {
        this.titulos =new String[] {"Concepto","Cantidad","Persona","Categoria"};
        filaIngreso=new ArrayList<>();
    }

    public Ingreso getIngresoSeleccionada() {
        return ingreSelect;
    }

    public void setpIngresoSeleccionada(Ingreso ingresoSeleccionada) {
        this.ingreSelect = ingresoSeleccionada;
    }

    public List<Ingreso> getFilaIngreso() {
        return filaIngreso;
    }

    public void setFilaIngreso(List<Ingreso> lapIngreso) {
        this.filaIngreso = lapIngreso;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaIngreso.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.ingreSelect=filaIngreso.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return ingreSelect.getConcepto();
          case 1: return ingreSelect.getCantidad();
          case 2: return ingreSelect.getIdPersona();
          case 3: return ingreSelect.getIdCategoria();
//          case 2: return comboPersona(egregSelect.getIdPersona());
//          case 3: return comboCategoria(egregSelect.getIdCategoria());
          default: return null;
      
      }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
          case 0: return String.class;
          case 1: return String.class;
          case 2: return String.class;
          case 3: return String.class;
          default: return null;
      
      }
    }

    @Override
    public String getColumnName(int i) {
        return titulos[i];
    }
   
    
    
     public void agregar(Ingreso objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaIngreso.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Ingreso objeto){
 if(objeto!=null){
 this.eliminar();
 filaIngreso.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaIngreso.remove(indice);
 
 fireTableDataChanged();
 
}
}
