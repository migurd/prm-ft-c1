package com.example.appholamundo;

import java.io.Serializable;
import java.util.Random;

public class Cotizacion implements Serializable {
    private int folio;
    private String name;
    private String description;
    private double carValue;
    private double firstPaymentPer;
    private int periods;

    public Cotizacion(int folio, String name, String description, double carValue, double firstPaymentPer, int periods) {
        this.folio = folio;
        this.name = name;
        this.description = description;
        this.carValue = carValue;
        this.firstPaymentPer = firstPaymentPer;
        this.periods = periods;
    }

    public Cotizacion() {
        this.folio = 0;
        this.name = "";
        this.description = "";
        this.carValue = 0f;
        this.firstPaymentPer = 0f;
        this.periods = 0;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCarValue() {
        return carValue;
    }

    public void setCarValue(double carValue) {
        this.carValue = carValue;
    }

    public double getFirstPaymentPer() {
        return firstPaymentPer;
    }

    public void setFirstPaymentPer(double firstPaymentPer) {
        this.firstPaymentPer = firstPaymentPer;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    // métodos de comportamiento
    public int generateId() {
        Random rand = new Random();
        return rand.nextInt(999) + 1;
    }
    public double calculateFirstPayment() {
        return this.carValue * (this.firstPaymentPer / 100);
    }
   public double calculateMonthlyPayment() {
        return (this.carValue - this.calculateFirstPayment()) / this.periods;
   }
}
