package com.sd.dao.v2;

public class PersonV0{
  private int id;
  private String name;
  private String address;
  
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name=name;
  }
  public void setAddress(String address){
    this.address=address;
  }
  public String getAddress(){
    return address;
  }
  public int getId(){
    return id;
  }
  public void setId(int id){
    this.id=id;
  }
  public String toString(){
        return "ID: "+id+" Name: "+name+" Address: "+address;
    }
}