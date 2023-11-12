package org.example.model;

import javax.xml.bind.annotation.XmlElement;

public class Empleado {

    private String nombre;
    private String apellido;
    private String dni;
    private String depto;

    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @XmlElement
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    @XmlElement
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDepto() {
        return depto;
    }

    @XmlElement
    public void setDepto(String depto) {
        this.depto = depto;
    }
}
