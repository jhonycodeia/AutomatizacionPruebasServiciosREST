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

import org.apache.poi.ss.usermodel.Sheet;
import org.jmeter.excel.Parametro;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jmeter.excel.Constantes;

public class SheetWork {
    private Sheet sheet;
    
    public SheetWork(String sheet,XSSFWorkbook wb){
        this.sheet = wb.getSheet(sheet);
    }
    
    public ArrayList<Parametro> getListPropiedades(){
        ArrayList<Parametro> lasPropiedades = new ArrayList<>();
        
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            
            Parametro parametro = new Parametro();
            
            parametro.setName(row.getCell(0).getStringCellValue());
            
            switch(row.getCell(1).getCellType().toString()){
             case Constantes.TYPE_TEXT:
                    parametro.setValue(row.getCell(1).getStringCellValue());
                    break;
             case Constantes.TYPE_NUMBER:
                    long num = (long)row.getCell(1).getNumericCellValue();
                    parametro.setValue(String.valueOf(num));
                    break;
                }
            
            lasPropiedades.add(parametro); 
            
        }
        
        return lasPropiedades;
        
    }
    
    public ArrayList<Parametro> getListParametros(int row){
        
        ArrayList<Parametro> losParametros = new ArrayList<>();
        
        String tipoParametro = "";
        String name = "";
        String tipoDato = "";
        
        for (int i = 0; i <sheet.getRow(row).getLastCellNum(); i++) {
            
            Parametro parametro = new Parametro();
            
            
            if(sheet.getRow(0).getCell(i)!=null && !sheet.getRow(0).getCell(i).getStringCellValue().equals("")){
                tipoParametro = sheet.getRow(0).getCell(i).getStringCellValue();
            }
            
            if(sheet.getRow(1).getCell(i)!=null){
                name = sheet.getRow(1).getCell(i).getStringCellValue();
            }
            
            if(sheet.getRow(row).getCell(i)!=null){
                tipoDato = sheet.getRow(row).getCell(i).getCellType().toString();
            }
            
            parametro.setTipoDato(tipoDato);
            parametro.setTipoParametro(tipoParametro);
            parametro.setName(name);
            
            switch(tipoDato){
                case Constantes.TYPE_TEXT:
                    parametro.setValue(sheet.getRow(row).getCell(i).getStringCellValue());
                    break;
                case Constantes.TYPE_NUMBER:
                    parametro.setValueNumber((long)sheet.getRow(row).getCell(i).getNumericCellValue());
                    parametro.setValue(String.valueOf((long)sheet.getRow(row).getCell(i).getNumericCellValue()));
                    break;
                }
            
            if(!tipoParametro.equals("")){
                losParametros.add(parametro);
            }
            if(tipoParametro.equals("Message")){
                tipoParametro = "";
            }  
        }       
        
        return losParametros;
    }
    
    public ArrayList<Parametro> getListParametrosHeader(int row){
        return getListParametros(row,Constantes.TIPO_HEADER);
    }
    
    public ArrayList<Parametro> getListParametrosBody(int row){
        return getListParametros(row,Constantes.TIPO_BODY);
    }
    
    public ArrayList<Parametro> getListParametrosPath(int row){
        return getListParametros(row,Constantes.TIPO_PATH);
    }
    
    public ArrayList<Parametro> getListParametrosQuery(int row){
        return getListParametros(row,Constantes.TIPO_QUERY);
    }
    
    public ArrayList<Parametro> getListParametrosCode(int row){
        return getListParametros(row,Constantes.TIPO_CODE);
    }
    
    public ArrayList<Parametro> getListParametrosMessage(int row){
        return getListParametros(row,Constantes.TIPO_MESSAGE);
    }
    
    private ArrayList<Parametro> getListParametros(int row,String tipoParametro){        
        ArrayList<Parametro> losParametros = getListParametros(row);
        ArrayList<Parametro> selecionados = new ArrayList<>();
        for (Parametro losParametro : losParametros) {
            if(losParametro.getTipoParametro().equals(tipoParametro)){
                selecionados.add(losParametro);
            }
        }
        return selecionados;
    }
}
