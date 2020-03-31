package modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;
/**
 *
 * @author usuario
 */
public class TablaPersona extends AbstractTableModel{
    private  Persona personSelect=null;
    private  List<Persona> filaPersona;
    private String[] titulos=null;
    private int indice;

    public TablaPersona() {
        this.titulos =new String[] {"Nombre","Apellido","Cédula","Dirección","Correo","Edad","Género"};
        filaPersona=new ArrayList<>();
    }

    public Persona getPersonaSeleccionada() {
        return personSelect;
    }

    public void setPersonaSeleccionada(Persona personSeleccionada) {
        this.personSelect = personSeleccionada;
    }

    public List<Persona> getFilaPersona() {
        return filaPersona;
    }

    public void setFilaPersona(List<Persona> lapPersona) {
        this.filaPersona = lapPersona;
    }

    
    
    
    
   
    
    @Override
    public int getRowCount() {
     return filaPersona.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      this.personSelect=filaPersona.get(rowIndex);
      this.indice=rowIndex;
      switch(columnIndex){
          case 0: return personSelect.getNombre();
          case 1: return personSelect.getApellido();
          case 2: return personSelect.getCedula();
          case 3: return personSelect.getDireccion();
          case 4: return personSelect.getCorreo();
          case 5: return personSelect.getEdad();
          case 6: return personSelect.getGenero();
          //case 6: return datoCombo(Integer.parseInt(personSelect.getGenero()));
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
          case 4: return String.class;
          case 5: return String.class;
          case 6: return String.class;
          default: return null;
      
      }
    }

    @Override
    public String getColumnName(int i) {
        return titulos[i];
    }
   
    
    
     public void agregar(Persona objeto){
       if(objeto!=null){//verifico que objeto exixta..!
        filaPersona.add(objeto);
        fireTableDataChanged();
       }
     
    }
     
 public void editar(Persona objeto){
 if(objeto!=null){
 this.eliminar();
 filaPersona.add(indice, objeto);
 fireTableDataChanged();
}
 
 }
public void eliminar(){
 
 filaPersona.remove(indice);
 
 fireTableDataChanged();
 
}
         
}
