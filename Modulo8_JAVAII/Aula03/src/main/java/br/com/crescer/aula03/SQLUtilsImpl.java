/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import br.com.crescer.lista02.*;
import java.io.File;

import java.sql.*;

/**
 *
 * @author lucas
 */
public class SQLUtilsImpl implements SQLUtils {

    @Override
    public void runFile(String filename) {
        ReaderUtils repoLeitura = new ReaderUtilsImpl();
        String query = repoLeitura.read(filename);
        
        try (final Connection connection = ConnectionUtils.retornaConexao()) {
            
            try (final Statement statement = connection.createStatement()) {
                for(String cadaComando : query.split(";")){
                    statement.executeQuery(cadaComando);
                }
                
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }

    @Override
    public String executeQuery(String query) {
          StringBuilder sb = new StringBuilder();
        try (final Connection connection = ConnectionUtils.retornaConexao()) {
            
          
            try (final Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int index = 1; index <= rsmd.getColumnCount(); index++){
                    sb.append(rsmd.getColumnName(index));
                    if(index != rsmd.getColumnCount()){
                    sb.append("--");
                    }
                    else{
                    sb.append("  ");
                    }
                    }
                sb.append("\n");
                
                while(rs.next()){
                    for(int x = 1; x <= rsmd.getColumnCount(); x++ ){
                    
                        Object valor = rs.getObject(x);
                        sb.append(valor.toString());
                        if(x < rsmd.getColumnCount()){
                        sb.append("--");
                        }
                        else{
                        sb.append("  ");
                        }
                        
                    }
                    
                    sb.append("\n");
                
                }
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        return sb.toString();
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File exportCSV(String query) {
        WriterUtils escreve = new WriterUtilsImpl();
        String resultado = executeQuery(query);
        escreve.write("exportacao.txt",resultado.replaceAll("--",", "));
        File arquivo = new File("exportacao.txt");
        return arquivo;
    }

}
