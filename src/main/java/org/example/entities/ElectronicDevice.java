package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ElectronicDevice
        extends Product2
{

    private int voltage;

    public int getVoltage(){
        return voltage;
    };

    public void setVoltage(int voltage){
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "voltage=" + voltage +
//                ", id=" + id +
                '}';
    }
}
