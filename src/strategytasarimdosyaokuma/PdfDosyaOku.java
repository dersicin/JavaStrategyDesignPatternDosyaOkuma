/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfDosyaOku implements Strategy{

    @Override
    public void oku(String filePath, StrategyTasarimDosyaOkuma stdo) {
        try {
            System.out.println("Pdf Dosyası Okunuyor...");
            System.out.println(filePath);
            
            //Loading an existing document
            File file = new File(filePath);
            PDDocument document = PDDocument.load(file);
            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);
            stdo.textArea.setText(text);
            System.out.println("TextArea'ya aktarılıyor...");
            //Closing the document
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(PdfDosyaOku.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    
}
