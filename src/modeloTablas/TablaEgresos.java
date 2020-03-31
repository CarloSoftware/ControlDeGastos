package modeloTablas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Egreso;
/**
 *
 * @author usuario
 */
public class TablaEgresos extends AbstractTableModel{
    private  Egreso egregSelect=null;
    private  List<Egreso> filaEgreso;
    private String[] titulos=null;
    private int indice;
    
    public TablaEgresos() {
        this.titulos =new String[] {"Concepto","Cantidad","Persona","Categoria"};
        filaEgreso=new ArrayList<>();
    }

    public Egreso getEgresoSeleccionada() {
        return egregSelect;
    }

    public void setpEgresoSeleccionada(Egreso egresoSeleccionada) {
        this.egregSelect = egresoSeleccionada;
    }

    public List<Egreso> getFilaEgreso() {
        return filaEgreso;
    }

    public void setFilaEgreso(List<Egreso> lapEgreso) {
        this.filaEgreso = lapEgreso;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaEgreso.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.egregSelect=filaEgreso.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return egregSelect.getConcepto();
          case 1: return egregSelect.getCantidad();
          case 2: return egregSelect.getIdPersona();
          case 3: return egregSelect.getIdCategoria();
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
   
    
    
     public void agregar(Egreso objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaEgreso.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Egreso objeto){
 if(objeto!=null){
 this.eliminar();
 filaEgreso.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaEgreso.remove(indice);
 
 fireTableDataChanged();
 
}
}
