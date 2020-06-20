/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author lenovo
 */
public class DocDosyaOku implements Strategy{

    @Override
    public void oku(String filePath, StrategyTasarimDosyaOkuma stdo) {
        System.out.println("Doc Dosyası Okunuyor...");
        System.out.println(filePath);
        
        filePath = filePath.replace("\\", "\\\\");
         try {
            FileInputStream fis = new FileInputStream(filePath);            
            HWPFDocument doc = new HWPFDocument(fis);
             WordExtractor extractor = new WordExtractor(doc);
             stdo.textArea.setText(extractor.getText());            
        } catch (IOException e) {
        }    
    } 
}
