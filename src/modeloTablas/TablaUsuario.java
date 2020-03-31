package modeloTablas;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;

/**
 *
 * @author usuario
 */
public class TablaUsuario extends AbstractTableModel{
    private  Usuario userSelect=null;
    private  List<Usuario> filaUser;
    private String[] titulos=null;
    private int indice;

    public TablaUsuario() {
        this.titulos =new String[] {"Rol","Persona","Usuario","Contraseña"};
        filaUser=new ArrayList<>();
    }

    public Usuario getUserSeleccionada() {
        return userSelect;
    }

    public void setpUserSeleccionada(Usuario userSeleccionada) {
        this.userSelect = userSeleccionada;
    }

    public List<Usuario> getFilaUser() {
        return filaUser;
    }

    public void setFilaUser(List<Usuario> lapUser) {
        this.filaUser = lapUser;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaUser.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.userSelect=filaUser.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return userSelect.getIdRol();
          case 1: return userSelect.getIdPersona();
          case 2: return userSelect.getUsuario();
          case 3: return userSelect.getClave();
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
   
    
    
     public void agregar(Usuario objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaUser.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Usuario objeto){
 if(objeto!=null){
 this.eliminar();
 filaUser.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaUser.remove(indice);
 
 fireTableDataChanged();
 
}
        
}
