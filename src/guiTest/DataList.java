/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guiTest;

import java.util.ArrayList;

/**
 *
 * @author R_kib
 */
public class DataList {
    public static ArrayList<DataStore> a;
    DataList(int n, String[]s){
    	a = new ArrayList<DataStore>();
        DataStore data = new DataStore(n,s);
        a.add(data);
    }
    
}
