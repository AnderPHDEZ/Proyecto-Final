/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinala;

/**
 *
 * @author Venta PC
 */
public class DatosEmpleados {
    String employee[] = {
        "Marius de Miguel","Jesus Maria Galera","Xavier Calvo","Luis Carlos Chen","Irina Medina","Victoria Boix","Ruben Valls","Miguel Angel Calatayud","Mohamed Trigo","Julio Giraldo",
        "Sebastian Nevado","Pablo Goñi","Jamal Arribas","Borja Rebollo","Leticia Diallo","Eloy Calero","Maria Vilar","Anton Rebollo","Mauricio Carrascosa","Julio Coca",
        "Gemma Arnau","Nicolae Maestre","Leopoldo Amador","Maria Antonia Maestre","Vega Ali","Maria Olga Arenas","Lucas Padron","Rosa Maria Rosa","Josu Aragon","Cecilio Portillo",
        "Cecilio Puerta","Paola Silva","Xabier Pacheco","Felisa Vilches","Raimundo Puente","Eloisa Quiros","Juan Dios Peral","Miquel Echevarria","Carolina Villanueva","Ibrahim Cordon",
        "Cecilio Pulido","Eulalia Ripoll","Hugo Valdivia","Jose Luis Urbano","Arturo Quiros","Abdellah Martín","Roberto Carlos Dominguez","Andoni Zamora","Damian Borrego","Carlos Alberto Moreno" 
    };
    int empID[] = new int[50];
    
    void loadDataID(){
        
        //Numeros de identificación de empleado
        for (int i = 0; i < 50; i++) {
            empID[i] = i+1;
        }
    }

    public String getEmployeeName(int p) {
        return employee[p];
    }

    public int getEmpID(int p) {
        return empID[p];
    }
    
}
