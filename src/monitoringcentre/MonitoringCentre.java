/**************************************
 * Matricola    Cognome     Nome
 * 754530       Galimberti  Riccardo
 * 755152       Paredi      Giacomo
 * 753252       Radice      Lorenzo
 * Sede: Como
***************************************/

package src.monitoringcentre;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;

import src.common.*;

/**
 * Classe che contiene il centro di monitoraggio.
 * @author Riccardo Galimberti
 * @version 0.10.3
 */
public class MonitoringCentre {
    // private String via, civico, cap, comune, provincia;
    private String nome;
    private String [] indirizzo = new String[5];
    private String [] areeInteresse;
    private short userid;
    private final static String header = "nome, via/piazza, numero civico, cap, comune, provincia, userID, areeInteresse";

    private final static File f = FileSystems.getDefault().getPath("data", "CentroMonitoraggio.dati.csv").toFile();

    public MonitoringCentre(String nome, String [] indirizzo, String [] areeInteresse, short userid){
        if(CenterExistence(nome))
            registraCentroAree(nome, indirizzo, areeInteresse, userid);
    }

    //costruttore vuoto
    public MonitoringCentre(){
    }

    public void registraCentroAree(String nome, String [] indirizzo, String [] areeInteresse, short userid){
        this.nome = nome;
        if(indirizzo.length == this.indirizzo.length){
            this.indirizzo = indirizzo;
        }else{
            //TODO exception wrong array input length
        }
        if(areeInteresse.length > 0){
            this.areeInteresse = areeInteresse;
        }else{
            //TODO exception empty list
        }
        this.userid = userid;
        memorizzaCentroAree(nome, indirizzo, areeInteresse, userid);
    }
    /**
     * Ritorna un array di stringhe dei nomi dei Centri di Monitoraggio.
     * Se non ci sono Centri ritorna null.
     * @return nomi dei centri
     */
    public String[] getCentri(){
        return Research.getColArray(f,0);
    }

    //aggiunge un'area ad un centro già esistente
    public void addArea(String area, String nome){

        if(CenterExistence(nome)){
            //TODO aggiunta area 
        }
        
    }

    private void memorizzaCentroAree(String nome, String [] indirizzo, String [] areeInteresse, short userid){
        String s = nome + ",";
        for (int i = 0; i < indirizzo.length; i++) {
            s = s + indirizzo[i] + ",";
        }
        s = s + userid;
        for (int i = 0; i < areeInteresse.length; i++) {
            s = s + areeInteresse[i] + ",";
        }
        
        
    }

    private boolean CenterExistence(String nome){
        boolean exists = false;
        if(Research.isStringInCol(f,0,nome))
            exists = true;
        else
            exists = false;

        return exists;
    }
}
