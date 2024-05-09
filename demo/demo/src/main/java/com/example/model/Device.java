package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer batteryPower;
    private Boolean blue;
    private Double clockSpeed;
    private Boolean dualSim;
    private Integer fc;
    private Boolean fourG;
    private Integer intMemory;
    private Double mDep;
    private Integer mobileWt;
    private Integer nCores;
    private Integer pc;
    private Integer pxHeight;
    private Integer pxWidth;
    private Integer ram;
    private Integer scH;
    private Integer scW;
    private Integer talkTime;
    private Boolean threeG;
    private Boolean touchScreen;
    private Boolean wifi;
    private Integer priceRange;  // This field can be set after prediction

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Include getters and setters for all other fields

    // Constructor, if necessary
    public Device() {
    }

    // Optionally, you can add a constructor to initialize your Device objects easily
    public Device(Integer batteryPower, Boolean blue, Double clockSpeed, Boolean dualSim, 
                  Integer fc, Boolean fourG, Integer intMemory, Double mDep, Integer mobileWt, 
                  Integer nCores, Integer pc, Integer pxHeight, Integer pxWidth, Integer ram, 
                  Integer scH, Integer scW, Integer talkTime, Boolean threeG, Boolean touchScreen, 
                  Boolean wifi) {
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
    }
}
