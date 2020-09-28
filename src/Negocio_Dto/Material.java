/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Dto;

/**
 *
 * @author User
 */
public class Material {

    private int Id;
    private int Codigo;
    private int Codigo1;
    private int Codigo2;
    private int Codigo3;
    private int Codigo4;
    private int Codigo5;
    private String Nombre;
    private String Sigla;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getCodigo1() {
        return Codigo1;
    }

    public void setCodigo1(int Codigo1) {
        this.Codigo1 = Codigo1;
    }

    public int getCodigo2() {
        return Codigo2;
    }

    public void setCodigo2(int Codigo2) {
        this.Codigo2 = Codigo2;
    }

    public int getCodigo3() {
        return Codigo3;
    }

    public void setCodigo3(int Codigo3) {
        this.Codigo3 = Codigo3;
    }

    public int getCodigo4() {
        return Codigo4;
    }

    public void setCodigo4(int Codigo4) {
        this.Codigo4 = Codigo4;
    }

    public int getCodigo5() {
        return Codigo5;
    }

    public void setCodigo5(int Codigo5) {
        this.Codigo5 = Codigo5;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public void Material(int Id, int Codigo, int Codigo1, int Codigo2, int Codigo3, int Codigo4, int Codigo5, String Nombre, String Sigla) {
        this.Id = Id;
        this.Codigo = Codigo;
        this.Codigo1 = Codigo1;
        this.Codigo2 = Codigo2;
        this.Codigo3 = Codigo3;
        this.Codigo4 = Codigo4;
        this.Codigo5 = Codigo5;
    }

    public Material() {

    }
}
