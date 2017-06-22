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
public class WriterUtilsImpl implements WriterUtils {
        
    
        @Override
        public void write(String file, String conteudo){
       
        try{
             File fileEscrever = new File(file);
             String extensao = FileExtensionRepo.getFileExtension(fileEscrever);
             if(!extensao.equalsIgnoreCase("txt")){
                 throw new Exception("Cara, isso ai num é um txt não.");
             }
             if(!fileEscrever.exists()){
                 throw new Exception("Cara, esse arquivo ai num existe não.");
             }
             
             final Writer writer = new FileWriter(fileEscrever);
             final BufferedWriter bWriter = new BufferedWriter(writer);
             bWriter.write(conteudo);
             bWriter.close();
        }
        catch(Exception e){
        e.printStackTrace();
        }
        }

    
}
