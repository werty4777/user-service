package com.sulluscocha.user_persistence.persistence;


import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "user")
public class UserDO implements Serializable {

    @Id
    private String id;

    @Column
    private String email;

    @ManyToOne(targetEntity = AlmacenDO.class)
    @JoinColumn(name = "id_almacen")
    private AlmacenDO almacen;


    @ManyToOne(targetEntity = RolesDO.class)
    @JoinColumn(name = "id_rol")
    private RolesDO rol;

    public UserDO() {


    }

    public UserDO(String email, AlmacenDO almacen, RolesDO rol) {
        this.email = email;
        this.almacen = almacen;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AlmacenDO getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenDO almacen) {
        this.almacen = almacen;
    }

    public RolesDO getRol() {
        return rol;
    }

    public void setRol(RolesDO rol) {
        this.rol = rol;
    }
}
