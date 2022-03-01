package modelo.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable{
    private int id;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String n_identificacion;
    private String correo;
    private String clave;
    private char sexo;
    private Date fecha;
    private boolean estado;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    public UsuarioDTO(int id, String nombre, String nombre2, String apellido, String apellido2, String n_identificacion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.n_identificacion = n_identificacion;
        this.correo = correo;
    }
    
    public UsuarioDTO(String nombre, String nombre2, String apellido, String apellido2, String n_identificacion, String correo, String clave, char sexo, Date fecha, boolean estado) {
        this.id = 0;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.n_identificacion = n_identificacion;
        this.correo = correo;
        this.clave = clave;
        this.sexo = sexo;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    public UsuarioDTO(int id, String nombre, String nombre2, String apellido, String apellido2, String n_identificacion, String correo, String clave, char sexo, Date fecha, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.n_identificacion = n_identificacion;
        this.correo = correo;
        this.clave = clave;
        this.sexo = sexo;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getN_identificacion() {
        return n_identificacion;
    }

    public void setN_identificacion(String n_identificacion) {
        this.n_identificacion = n_identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     
}