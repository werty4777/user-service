package com.sulluscocha.user_domain.domain;

import com.sulluscocha.types.exception.InvalidadRolException;
import com.sulluscocha.types.types.Profile;
import com.sulluscocha.types.types.Rol;
import com.sulluscocha.types.types.Store;


public class User {


    private Profile profile;
    private Store Almacen;
    private Rol rol;


    public User() {
    }

    public User(Profile profile, Store Almacen, Rol rol) {
        this.profile = profile;
        this.Almacen = Almacen;
        this.rol = rol;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Store getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(Store almacen) {
        this.Almacen = almacen;
    }

    public Rol getRol() {


        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public void establecerRol(Rol rol) throws InvalidadRolException {

        if (rol == null) {

            throw new InvalidadRolException("Error rol nulo");

        }

        this.rol = rol;


    }


}
