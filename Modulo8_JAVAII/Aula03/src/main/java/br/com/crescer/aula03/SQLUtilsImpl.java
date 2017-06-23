/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import br.com.crescer.lista02.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
                statement.executeQuery(query);
            } catch (SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }

    @Override
    public String executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
