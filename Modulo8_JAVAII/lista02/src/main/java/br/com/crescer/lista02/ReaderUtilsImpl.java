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
public class ReaderUtilsImpl implements ReaderUtils {

    @Override
    public String read(String string) {

        try {
            File file = new File(string);

            if (!file.exists()) {
                throw new Exception("Esse arquivo ai nao existe man.");
            }
            String extensao = FileExtensionRepo.getFileExtension(file);
            if (!(extensao.equalsIgnoreCase("txt"))) {
                System.out.println("Arquivo mandado não foi txt.");
                throw new Exception("Manda txt amigao");
            }
            StringBuilder sb = new StringBuilder();
            final Reader reader = new FileReader(string);
            final BufferedReader bufferReader = new BufferedReader(reader);
            String linha;
            while ((linha = bufferReader.readLine()) != null) {
                if (linha != null) { sb.append("\n");
                    sb.append(bufferReader.readLine());
                     sb.append("\n");
                }
            }
            reader.close();
            bufferReader.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Não foi possivel ler o arquivo.";
    }

}
