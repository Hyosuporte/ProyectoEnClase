package modelo.dto;

import java.io.Serializable;


public class ProductoDTO implements Serializable{
    private int id;
    private String nombre;
    private String descripcion;
    private int unidad;
    private long valor;

    public ProductoDTO() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.unidad = 0;
        this.valor = 0;
    }
    
    public ProductoDTO(int id, String nombre, String descripcion, int unidad, long valor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.valor = valor;
    }
    
    public ProductoDTO(String nombre, String descripcion, int unidad, Long valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }
 
}