package model;

import java.sql.Date;

public class Prestamo {

    private int id;
    private int libroId;
    private String usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    public Prestamo(int id, int libroId, String usuario,
                    Date fechaPrestamo, Date fechaDevolucion,
                    boolean devuelto) {

        this.id = id;
        this.libroId = libroId;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    public int getId() {
        return id;
    }

    public int getLibroId() {
        return libroId;
    }

    public String getUsuario() {
        return usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
}