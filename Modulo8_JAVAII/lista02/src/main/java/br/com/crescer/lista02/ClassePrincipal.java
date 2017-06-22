/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista02;

/**
 *
 * @author lucas
 */
public class ClassePrincipal {
    
        public static void main (String[] args){
        FileUtilsImpl repo = new FileUtilsImpl();
        ReaderUtils reader = new ReaderUtilsImpl();
        WriterUtils writer = new WriterUtilsImpl();
            repo.mkDir("TestFolder");
            repo.mk("TestFolder\\Testando.txt");
            repo.mk("TestFolder\\Testando2.txt");
            repo.mk("TestFolder\\Testando3.txt");
            System.out.println(repo.ls("TestFolder\\Testando.txt"));
            System.out.println(repo.ls("TestFolder"));
            repo.rm("TestFolder\\Testando2.txt");
            repo.mv("TestFolder\\Testando.txt", "C:\\Users\\lucas.damaceno\\Documents\\lucas.damaceno\\lucas.damaceno\\Modulo8_JAVAII\\lista02\\TestMoveFile");
            
            System.out.println(reader.read("BlackParade.txt"));
            System.out.println(reader.read("MusicaMasTristeDoLinkPark.xml"));
            System.out.println(reader.read("pom.xml"));
            writer.write("CincoDeNovembro.txt", "Remember, remember.\n The Fifth of November.\n  The Gunpowder, treason and plot. \n I know of no reason, the Gunpowder treason \n SHALL EVER BE FORGOT.");
            
            writer.write("ArquivoQueNaoExiste.txt","deve falhar");
            writer.write("ArquivoNaoTxt.xml","falha de novo");
            
        }
    
}
