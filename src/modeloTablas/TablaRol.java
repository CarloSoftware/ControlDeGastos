package modeloTablas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Rol;

/**
 *
 * @author usuario
 */
public class TablaRol extends AbstractTableModel{
    private  Rol rolSelect=null;
    private  List<Rol> filaRol;
    private String[] titulos=null;
    private int indice;

    public TablaRol() {
        this.titulos =new String[] {"Rol","Descripción"};
        filaRol=new ArrayList<>();
    }

    public Rol getRolSeleccionada() {
        return rolSelect;
    }

    public void setpRolSeleccionada(Rol rolSeleccionada) {
        this.rolSelect = rolSeleccionada;
    }

    public List<Rol> getFilaRol() {
        return filaRol;
    }

    public void setFilaRol(List<Rol> lapRol) {
        this.filaRol = lapRol;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaRol.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.rolSelect=filaRol.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return rolSelect.getRol();
          case 1: return rolSelect.getDescripcion();
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
   
    
    
     public void agregar(Rol objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaRol.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Rol objeto){
 if(objeto!=null){
 this.eliminar();
 filaRol.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaRol.remove(indice);
 
 fireTableDataChanged();
 
}
        
}
