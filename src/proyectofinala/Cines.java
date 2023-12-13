/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinala;

import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class Cines {
    //variables 
    private String movName;
    private int movRoom;
    private int size;
    
    private int seats[][] = {
        {0,0,0,0,0,0},
        {0,0,0,0,0,0},
        {0,0,0,0,0,0},
        {0,0,0,0,0,0},
        {0,0,0,0,0,0}
    };

    //CONSTRUCTOR

    public Cines(String movName, int movRoom, int size) {
        this.movName = movName;
        this.movRoom = movRoom;
        this.size = size;
    }
    
    

    //SETTERS
    public void setMovName(String movName) {
        this.movName = movName;
    }

    public void setMovRoom(int movRoom) {
        this.movRoom = movRoom;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void setSeatOver(int row, int col, int entry){
        this.seats[row][col] = entry;
    }
    
    public void setSeat(int row, int col, int entry){
        if(seats[row][col] == 0){
            this.seats[row][col] = entry;
        }else{
            JOptionPane.showMessageDialog(null, "Asiento ocupado");
        }
    }
    
    public void delSeat(int row, int col){
        seats[row][col] = 0;
    }
    
    
    //GETTERS

    public String getMovName() {
        return movName;
    }

    public int getMovRoom() {
        return movRoom;
    }

    public int getSize() {
        return size;
    }
    
    public int getSeat(int row, int col){
        return seats[row][col];
    }
    
}
