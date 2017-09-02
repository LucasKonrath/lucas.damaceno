/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista02;

import java.io.BufferedReader;
import java.io.FileReader;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author lucas
 */
public class ReaderUtilsImpl implements ReaderUtils {

   @Override
    public String read(String string) {
        try (final BufferedReader b = new BufferedReader(new FileReader(string))) {
            return String.join("\n", b.lines().collect(toList()));
        } catch (Exception e) {
            // ...
        }
        return null;
    }

}
