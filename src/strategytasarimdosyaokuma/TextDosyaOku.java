/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.Charsets;

/**
 *
 * @author lenovo
 */
public class TextDosyaOku implements Strategy{

    @Override
    public void oku(String filePath, StrategyTasarimDosyaOkuma stdo) {
        FileInputStream fis = null;
        try {
            stdo.textArea.setText("");
            File file = new File(filePath);
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,Charsets.ISO_8859_1);
            try (BufferedReader br = new BufferedReader(isr)) {
                String line;
                while((line = br.readLine()) != null){
                    //process the line
                    stdo.textArea.append(line);
                    stdo.textArea.append("\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(TextDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(TextDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            }
        } }
}
