/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class XmlDosyaOku implements Strategy{

    @Override
    public void oku(String filePath, StrategyTasarimDosyaOkuma sto3) {
        Reader fileReader = null;
        try {
            filePath = filePath.replace("\\", "\\\\");
            File xmlFile = new File (filePath);
            // Let's get XML file as String using BufferedReader
            // FileReader uses platform's default character encoding
            // if you need to specify a different encoding, use InputStreamReader
            fileReader = new FileReader(xmlFile);
            BufferedReader bufReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while( line != null){
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }   String xml2String = sb.toString();
            sto3.textArea.setText(xml2String);
            bufReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(XmlDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 }


}
