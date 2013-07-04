/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipi.myservlet.bean;

/**
 *
 * @author glassfish
 */
public class Siswa {
    
    private String id;
    
    private String nama;

    public Siswa() {
    
    }
    
    public Siswa(String id, String nama) {
        this.id = id;
        this. nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
