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
public class Parametro {
    
    private String name;
    private String value;
    private long valueNumber;
    private String tipoDato;
    private String tipoParametro;

    public Parametro() {
    }

    public Parametro(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(long valueNumber) {
        this.valueNumber = valueNumber;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }

    
    @Override
    public String toString() {
        return "Parametro{" + "name=" + name + ", value=" + value + ", tipoDato=" + tipoDato + ", tipoParametro=" + tipoParametro + '}';
    }
    
    
    
    
}
