package com.example.alberto.smallb.Cartas;

import xyz.hanks.library.bang.SmallBangView;

/**
 * Created by alberto on 4/02/18.
 */

public class Carta {
Integer imagen;
SmallBangView sbv;

    public Carta() {
        super();
    }

    public Carta( Integer imagen, SmallBangView sbv) {
        super();
        this.sbv = sbv;
        this.imagen = imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public void setSbv(SmallBangView sbv) {
        this.sbv = sbv;
    }

    public Integer getImagen() {
        return imagen;
    }

    public SmallBangView getSbv() {
        return sbv;
    }
}
