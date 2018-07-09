/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialapp;

/**
 *
 * @author ROHIT
 */

public class rowEntity {
   public String name,number,username,type = null;
    
    public rowEntity(String n, String no, String us, String t)
    {
        this.name=n;
        this.number=no;
        this.username=us;
        this.type=t;
    }
}
