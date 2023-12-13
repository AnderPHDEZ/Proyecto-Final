/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinala;

import javax.swing.JOptionPane;

/**
 *
 * @author Venta PC
 */
public class Gimnasio {
                         //2 3 4 5 6 7
    private int horas[] = {0,0,0,0,0,0};
    
    
    public void setEmp(int pos, int entry){
        if(horas[pos]==0){
            horas[pos]=entry;
        }else{
            JOptionPane.showMessageDialog(null, "Horario ocupado");
        }
    }
    
    public int getEmp(int x){
        return horas[x];
    }
    
    public void delEmp(int x){
        horas[x]=0;
    }
}
