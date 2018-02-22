/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrand;

import java.util.Random;

/**
 *
 * @author Aziz
 */
public class Rand {
    public int rand()
    {
        Random dice= new Random();
        int x,y,z;
        String a;
  
            x= dice.nextInt(999999999);
            /*y= dice.nextInt(9);
            z= dice.nextInt(9);*/
            
           //System.out.println(x);
           return x;
    }
    
}
