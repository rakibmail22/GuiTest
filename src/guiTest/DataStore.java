/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiTest;

/**
 *
 * @author R_kib
 */
public  class DataStore {
    private int numberOfTeams;
    private String [] nameOfTeams;
    DataStore(int n, String[] s){
        numberOfTeams = n;
        nameOfTeams = s;
    }
    public String[] getTeams(){
        return nameOfTeams;
    }
}

