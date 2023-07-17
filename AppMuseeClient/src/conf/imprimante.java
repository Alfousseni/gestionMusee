/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;


import com.itextpdf.text.Document;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.UUID;
import javax.swing.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;






 

/**
 *
 * @author Alfousseni
 */
public class imprimante {
    
//    public static void printRecord(JPanel panel){
//      PrinterJob printerJob = PrinterJob.getPrinterJob();
//      printerJob.setJobName("Print Record");
//      
//      printerJob.setPrintable(new Printable() {
//          @Override
//          public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//              if(pageIndex > 0){
//                  return Printable.NO_SUCH_PAGE;
//              }
//              
//              Graphics2D graphics2D = (Graphics2D)graphics;
//              
//              graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
//              
//              graphics2D.scale(0.5, 0.5);
//              
//              panel.paint(graphics2D);
//              
//              return Printable.PAGE_EXISTS;
//          }
//      });
//      
//      boolean returningResult = printerJob.printDialog();
//      
//      if(returningResult){
//          try{
//              printerJob.print();
//          
//          }catch(PrinterException printerException){
//          
//              JOptionPane.showMessageDialog(panel, "print Error : "+printerException.getMessage());
//          }
//      }
//      
//      
//      
//    }
    
    
    
    
  
public static void enregistrerPDF(JPanel panel, String filePath) {
    Document document = new Document();
    try {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
                


        Graphics2D g2 = cb.createGraphics(panel.getWidth(), panel.getHeight());
        
        panel.print(g2);
        g2.dispose();

        cb.saveState();
        cb.beginText();
        cb.moveText(30, 30);
        cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 12);
        cb.showText("Aucune anulation n'est accepter dans cette hotel soit tu viens ou tu laisse");
        cb.endText();
        cb.restoreState();
        
        cb.saveState();
        cb.beginText();
        cb.moveText(300, 800);
        cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 12);
        cb.showText(dateFormat.format(date));
        cb.endText();
        cb.restoreState();
        
        

    } catch (Exception e) {
        e.printStackTrace();
    }
    document.close();
}
    
}














    
   

    
   




            
    

