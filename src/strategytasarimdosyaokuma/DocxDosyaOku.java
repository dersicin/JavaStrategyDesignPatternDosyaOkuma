/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author lenovo
 */
public class DocxDosyaOku implements Strategy{

    @Override
    public void oku(String filePath, StrategyTasarimDosyaOkuma stdo) {
        filePath = filePath.replace("\\", "\\\\");
         try {
            FileInputStream fis = new FileInputStream(filePath);            
            XWPFWordExtractor oleTextExtractor =new XWPFWordExtractor(new XWPFDocument(fis));
            stdo.textArea.setText(oleTextExtractor.getText());            
        } catch (IOException e) {
        }    
    }
}
