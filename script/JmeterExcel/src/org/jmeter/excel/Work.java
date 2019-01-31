package org.jmeter.excel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GreenSQA
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Work {
    
    
    private SheetWork sheetParametros;
    private SheetWork sheetDatos;
    private XSSFWorkbook wb;
    private InputStream input;
    
    public Work(String ruta) throws IOException{        
        
        
        try {
            input = new FileInputStream(new File(ruta));
            wb = new XSSFWorkbook(input);
            
            sheetParametros = new SheetWork("parametros", wb);
            sheetDatos = new SheetWork("data", wb);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null,ex);
        } finally {            
                
                
            } 
    }

    public SheetWork getSheetParametros() {
        return sheetParametros;
    }

    public void setSheetParametros(SheetWork sheetParametros) {
        this.sheetParametros = sheetParametros;
    }

    public SheetWork getSheetDatos() {
        return sheetDatos;
    }

    public void setSheetDatos(SheetWork sheetDatos) {
        this.sheetDatos = sheetDatos;
    }
    
   public void close(){
        try {
            input.close();
            wb.close();
        } catch (IOException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
        
    
    
}
