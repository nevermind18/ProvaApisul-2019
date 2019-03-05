/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno
 */
public class Elevador {
    
    private String Elevador;
    private int andar;
    private String turno;

    public String getElevador() {
        return Elevador;
    }

    public void setElevador(String Elevador) {
        this.Elevador = Elevador;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Elevador{" + "Elevador=" + Elevador + ", andar=" + andar + ", turno=" + turno + '}';
    }

    
}
