/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private String country;
    private String price;

    public Product(int id, String name, String manufacturer, String country,String price ) {
        this.id = id;
        this.name = name;
        this.manufacturer= manufacturer;
        this.country = country;
        this.price = price; 
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id; 
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name; 
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacture){
        this.manufacturer = manufacturer; 
    }
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country){
        this.country = country; 
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String price){
        this.price = price; 
    }
}
