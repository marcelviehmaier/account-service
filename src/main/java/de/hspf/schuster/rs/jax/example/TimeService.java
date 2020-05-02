/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspf.schuster.rs.jax.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Marcel
 */
public class TimeService {
    
   public static String getCurrentTime(){
       return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
   }
}
