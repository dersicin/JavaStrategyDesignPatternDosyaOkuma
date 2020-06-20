/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategytasarimdosyaokuma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lenovo
 */
public class StrategyTasarimDosyaOkuma extends JFrame implements ActionListener{

    JButton button = new JButton();
    JTextArea textArea = new JTextArea();
    String filePath = "";
    public static StrategyTasarimDosyaOkuma stdo;
    JScrollPane jsp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    public StrategyTasarimDosyaOkuma(){
        textArea.setVisible(true);
        textArea.setText("Bir Dosya Seçmek İçin Dosya Aç Butonuna Tıklayınız.");
        add(jsp);
        
        
        setSize(500, 500);
        setTitle("Dosya Okuma Programı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        add(BorderLayout.NORTH, button);
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(30,30));
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setText("Dosya Aç");
        
        setVisible(true);
    }
    
        public String dosyaSec(){
        String path = "";
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "pdf,doc,docx,xml,txt", "pdf","doc","docx","xml","txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Bu dosyayı açmak istedin: " +
                    selectedFile.getAbsolutePath());
            path = selectedFile.getAbsolutePath();
    }

        return path;
}
     public String dosyaUzantısınıAl(String dosyaUzantısı){
        int index = dosyaUzantısı.lastIndexOf(".") + 1;
        dosyaUzantısı = dosyaUzantısı.substring(index);
        System.out.println(dosyaUzantısı);
        System.out.println("uzantı yazdırıldı.");
        return dosyaUzantısı;
    }
    
    public static void main(String[] args) {
        // Client-Test sınıfı olacak.
        stdo = new StrategyTasarimDosyaOkuma();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       //butona basıldıysa..
        if(ae.getSource() == button)
        {
            //dosya seçme işlemini yapıyor.
            filePath = dosyaSec();
            //dosya sonu uzantısını alıyor.
            String dosyaUzantısı = dosyaUzantısınıAl(filePath);
            
            Context context = new Context();
            //aldığı dosya sonu uzantısına karşılık gelen Strategyi seçerek dosya okumayı başlatıyor.
            switch(dosyaUzantısı){
                case "pdf" :{
                    context.setStrategy(new PdfDosyaOku());
                    //filePath dosya yolunu algoritmamızda kullandığımız için gerekliydi.
                    //Client referansımız ise text areaya okunan dosyanın textlerini yazdırmak için methoda girildi.
                    context.dosya_oku(filePath,stdo);
                    break;
                }      
                case "doc" :{
                    context.setStrategy(new DocDosyaOku());
                    context.dosya_oku(filePath,stdo);
                    break;
                }
                case "docx" : {
                    context.setStrategy(new DocxDosyaOku());
                    context.dosya_oku(filePath,stdo);
                    break;
                }
                 case "xml" : {
                    context.setStrategy(new XmlDosyaOku());
                    context.dosya_oku(filePath,stdo);
                    break;
                }
                 case "txt" : {
                    context.setStrategy(new TextDosyaOku());
                    context.dosya_oku(filePath,stdo);
                    break;
                 }
            }   
        }
    }
    
}
