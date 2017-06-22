/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista02;

import java.io.*;

/**
 *
 * @author lucas
 */
public class FileUtilsImpl implements FileUtils {
    
    //mk deve criar arquivo ou diretório. mk criará arquivo, mkdir criará diretório.
    @Override
     public boolean mk(String string){
         
         File file = new File(string);
         try{
             final boolean b = file.createNewFile();
             return b;
         }
         catch(IOException e){
             return false;
         }
         
     }
     
     
      public boolean mkDir(String string){
         
         File file = new File(string);
         try{
             final boolean b = file.mkdir();
             return b;
         }
         catch(Exception e){
             return false;
         }
         
     }
    @Override
    public boolean rm(String string){
        File file = new File(string);
        try{
                boolean b;
                if(file.isFile()){
                     b = file.delete();
                     return b;
                }   
                System.out.println("Pastas não podem ser deletadas.");
                return false;
        }catch(Exception e){
                System.out.println("Arquivo não existe.");
                return false;
        }
    }
    @Override
    public String ls(String string){
    
        return "Ainda não implementado";
    }
    @Override
    public boolean mv(String in, String out){
   
        return false;
    }
    
    
    
}
