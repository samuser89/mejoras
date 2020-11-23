/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.domain;

/**
 *
 * @author samuel.serna
 */
public class PlanPago {
    private int NroCuota;
    private double AbonoIntereses;
    private double AbonoCapital;
    private double CuotaMensual;
    private double Saldo;
    
    public PlanPago(){}

    public PlanPago(int NroCuota, double AbonoIntereses, double AbonoCapital, double CuotaMensual, double Saldo) {
        this.NroCuota = NroCuota;
        this.AbonoIntereses = AbonoIntereses;
        this.AbonoCapital = AbonoCapital;
        this.CuotaMensual = CuotaMensual;
        this.Saldo = Saldo;
    }

    public int getNroCuota() {
        return NroCuota;
    }

    public void setNroCuota(int NroCuota) {
        this.NroCuota = NroCuota;
    }

    public double getAbonoIntereses() {
        return AbonoIntereses;
    }

    public void setAbonoIntereses(double AbonoIntereses) {
        this.AbonoIntereses = AbonoIntereses;
    }

    public double getAbonoCapital() {
        return AbonoCapital;
    }

    public void setAbonoCapital(double AbonoCapital) {
        this.AbonoCapital = AbonoCapital;
    }

    public double getCuotaMensual() {
        return CuotaMensual;
    }

    public void setCuotaMensual(double CuotaMensual) {
        this.CuotaMensual = CuotaMensual;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    
}
