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
public class ACCIONES {
    //crear objetos
    Historial hist = new Historial();
    DatosEmpleados eData = new DatosEmpleados();
    Cines mov[] = new Cines[50];
    Gimnasio gym = new Gimnasio();
    Clases yoga = new Clases();
    Clases dance = new Clases();
    
    
    //iniciar objetos
    public void startAll(){
        eData.loadDataID();
        yoga.initHorarios();
        dance.initHorarios();
    }
    
    //VARIABLES SALA DE CINE
    int eCine;
    int tempSala;
    int tempID;
    int movQuant = 0;
    
    public int getMovSize(int S){
        if(mov[S].getSize()==0){
            return 1;
        }else{
            return 2;
        }
    }
    
    
    
    //crear sala de cine
    public void makeMov(String name, int size){
        if(movQuant<19){
            mov[movQuant] = new Cines(name,movQuant+1,size);
            movQuant = movQuant+1;
        }else{
            JOptionPane.showMessageDialog(null, "Limite de peliculas alcanzado");
        }
        
    }
    
    //eliminar sala
    public void eliminarSala(int del){
        movQuant--;
        for (int i = del; i < movQuant; i++) {
            mov[i].setMovName(mov[i+1].getMovName());
            mov[i].setSize(mov[i+1].getSize());
            
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 6; k++) {
                    mov[i].setSeatOver(j, k, mov[i+1].getSeat(j, k));
                }
            }
            
        }
    }
    
    //consultar emplado cine
    public void consEmpCine(int id){
        String temp = ""+getEmpleado(id) + " ID: "+id+"\nAsientos:\n";
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if(mov[tempSala-1].getSeat(i, j)==id){
                    switch (j) {
                        case 0:
                            temp = temp+"A"+i+1+"\n";
                            break;
                        case 1:
                            temp= temp+"B"+i+1+"\n";
                            break;
                        case 2:
                            temp= temp+"C"+i+1+"\n";
                            break;
                        case 3:
                            temp= temp+"D"+i+1+"\n";
                            break;
                        case 4:
                            temp= temp+"E"+i+1+"\n";
                            break;
                        case 5:
                            temp= temp+"F"+i+1+"\n";
                            break;
                        default:
                            break;
                    }
                }
            }
            
        }
        
        JOptionPane.showMessageDialog(null, temp);
        
    }
    
    
    //cambiar tamaño sala de cine
    public void chMovSize(int sizeTemp){
        if(sizeTemp==0){
            for (int i = 0; i < 5; i++) {
                mov[tempSala-1].setSeatOver(i, 5, 0);
            }
        }
        mov[tempSala-1].setSize(sizeTemp); 
    }
    
    //cambiar nombre pelicula
    public void chMovName(String nameTemp){
        mov[tempSala-1].setMovName(nameTemp);
        
    }
    
    public int getMovQuant(){
        return movQuant;
    }
    
    //revisar nombre pelicula
    public String getMovNombre(){
        return mov[tempSala-1].getMovName();
    }
    
    //añadir empleado a asiento   
    public void setMovSeat(int row,int col){
        mov[tempSala-1].setSeat(row, col, tempID);
    }
    
    //remover empleado de asiento
    public void delMovSeat(int row,int col){
        mov[tempSala-1].delSeat(row, col);
    }
    
    
    public int getOcupado(int movSala,int row, int col){
        if(mov[tempSala-1].getSeat(col, row)==0){
            return 1;
        }else{
            return 0;
        }
    }
    
    
    public String getLP(int x){
        String tempStr = "";
        
        if(x<movQuant) {
            tempStr = tempStr + (x+1) + ". " + mov[x].getMovName()+"\n\n";
        }
        
        
        
        return tempStr;
    }
    
    
    public int geteCine() {
        return eCine;
    }

    //setter getters de vars temp
    public void seteCine(int eCine) {
        this.eCine = eCine;
    }

    public int getTempSala() {
        return tempSala;
    }

    public void setTempSala(int tempSala) {
        this.tempSala = tempSala;
    }

    public int getTempID() {
        return tempID;
    }

    public void setTempID(int tempID) {
        this.tempID = tempID;
    }
    
    
    
    //obtener nombres de empleados usando ID
    
    public String getEmpleado(int id){
        String tempS = "";
        
        for (int i = 0; i < 50; i++) {
            if(eData.getEmpID(i)==id){
                tempS = eData.getEmployeeName(i);
            }
        }
        
        
        
        return tempS;
    }
    
    
    
    //gym
    public void addEmpGym(int x,int entryID){
        gym.setEmp(x, entryID);
    }
    
    public void delEmpGym(int x){
        gym.delEmp(x);
    }
    
    public int getEmpIdGym(int x){
        return gym.getEmp(x);
    }
    
    public String labelsGym(int x){
        String tempS = "" + (x+2)+"PM: ";
        
        if(gym.getEmp(x)==0){
            tempS= tempS +"Disponible";
        }else{
            tempS= tempS+getEmpleado(gym.getEmp(x))+" ID: "+gym.getEmp(x);
        }
        
        return tempS;
    }
    
    
    
    //Yoga
    public void addEmpYoga(int h,int ID){
        yoga.setEmp(h, ID);
    }
    
    public void delEmpYoga(int h,int x){
        yoga.delEmp(h, x);
    }
    
    public int getEmpIdYoga(int h,int x){
        return yoga.getEmp(h, x);
    }
    
    
    public String labelsYoga(int h,int x){
        String tempS = "";
        
        if(yoga.getEmp(h,x)==0){
            tempS= tempS;
        }else{
            tempS= tempS+ (x+1)+": "+getEmpleado(yoga.getEmp(h,x))+" ID: "+yoga.getEmp(h,x);
        }
        
        return tempS;
    }
    
    
    //baile
    public void addEmpBaile(int h,int ID){
        dance.setEmp(h, ID);
    }
    
    public void delEmpBaile(int h,int x){
        dance.delEmp(h, x);
    }
    
    public int getEmpIdBaile(int h,int x){
        return dance.getEmp(h, x);
    }
    
    
    public String labelsBaile(int h,int x){
        String tempS = "";
        
        if(dance.getEmp(h,x)==0){
            tempS= tempS;
        }else{
            tempS= tempS+ (x+1)+": "+getEmpleado(dance.getEmp(h,x))+" ID: "+dance.getEmp(h,x);
        }
        
        return tempS;
    }
    
    
    //historial
    public void addHistorial(String temp){
        
        hist.setHistorial(temp);
        
    }
    
    public String labelHist(int x){
        return hist.getHistorial(x);
    }
    
}
