package com.example.appholamundo;

import android.widget.Spinner;

public class SpinnerData {
    private String textCategoria;
    private String textDescripcion;
    private int imageID;

    public SpinnerData() {
        this.textCategoria = "";
        this.textDescripcion = "";
        this.imageID = 0;
    }

    public SpinnerData(String textCategoria, String textDescripcion, int imageID) {
        this.textCategoria = textCategoria;
        this.textDescripcion = textDescripcion;
        this.imageID = imageID;
    }

    public SpinnerData(SpinnerData sp) {
        this.textCategoria = sp.textCategoria;
        this.textDescripcion = sp.textDescripcion;
        this.imageID = sp.imageID;
    }

    public String getTextCategoria() {
        return textCategoria;
    }

    public void setTextCategoria(String textCategoria) {
        this.textCategoria = textCategoria;
    }

    public String getTextDescripcion() {
        return textDescripcion;
    }

    public void setTextDescripcion(String textDescripcion) {
        this.textDescripcion = textDescripcion;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
