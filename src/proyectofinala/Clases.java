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
public class Clases {
    private int horarios[][] = new int[2][30];
    private int ch7 =0;
    private int ch8 =0;
    
    
    public void initHorarios(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 30; j++) {
                horarios[i][j]=0;
            }
        }
    }
    
    public void setEmp(int h,int eID){
        if(h == 0 && ch7<30){
            horarios[h][ch7]=eID;
            ch7++;
        }else if(h == 1 && ch8<30){
            horarios[h][ch8]=eID;
            ch8++;
        }else{
            JOptionPane.showMessageDialog(null, "Horario lleno");
        }
    }
    
    public void delEmp(int h,int x){
        if(h==0){
            ch7--;
            for (int i = x; i < ch7; i++) {
                horarios[h][i]=horarios[h][i+1];
            }
            horarios[h][ch7]=0;
        }else{
            ch8--;
            for (int i = x; i < ch8; i++) {
                horarios[h][i]=horarios[h][i+1];
            }
            horarios[h][ch8]=0;
        }
    }
    
    public int getEmp(int h,int x){
        return horarios[h][x];
    }
}
