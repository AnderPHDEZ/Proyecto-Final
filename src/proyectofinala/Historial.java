/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinala;

/**
 *
 * 
 */
public class Historial {
    private int historialControl = 0;
    private String historial[]= new String[40];
    
    
    
    
    public void setHistorial(String s){
        if(historialControl<40){
            historial[historialControl]=s;
            historialControl++;
        }else{
            for (int i = 0; i < 39; i++) {
                historial[i]=historial[i+1];
            }
            historial[39]=s;
        }
    }
    
    
    public String getHistorial(int x){
        String tempS ="";
        if(x<historialControl){
            tempS = ""+(x+1)+" "+historial[x];
        }
        return tempS;
    }
}
