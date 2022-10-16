/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.Ship;

import lapr.project.data.AVL;

/**
 *
 * @author kevin
 */
public class Ship implements Comparable<Ship> {

    //powerOutput é uma constante porque é igual para todos os barcos
    private static final double POWER_OUTPUT = 20.00;

    private int mmsi;
    private String vesselName;
    private String imo;
    private String callSign;
    private int vesselType;
    private int length;
    private int width;
    private float draft;
    private String cargo;
    private double numEnergyGen;
    private double powerOutput;


    public Ship(int mmsi, String vesselName, String imo, String callSign, int vesselType, int length, int width,
                float draft, String cargo) {
        this.mmsi = mmsi;
        this.vesselName = vesselName;
        this.imo = imo;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.draft = draft;
        this.cargo = cargo;
        this.numEnergyGen = 0.0;
        this.powerOutput = POWER_OUTPUT;
    }

    public Ship() {

    }

    public String printDetails() {
        return "Ship:" +
                "\n mmsi= " + mmsi +
                "\nvesselName= " + vesselName +
                "\nimo= " + imo +
                "\ncallSign= " + callSign +
                "\nvesselType= " + vesselType +
                "\nlength= " + length +
                "\nwidth= " + width +
                "\ndraft= " + draft +
                "\ncargo= " + cargo +
                "\nnumEnergyGen" + numEnergyGen +
                "\nPowerOutput= " + POWER_OUTPUT;
    }

    public static double getPowerOutput() {
        return POWER_OUTPUT;
    }

    public int getMmsi() {
        return mmsi;
    }

    public String getVesselName() {
        return vesselName;
    }

    public String getImo() {
        return imo;
    }

    public String getCallSign() {
        return callSign;
    }

    public int getVesselType() {
        return vesselType;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public float getDraft() {
        return draft;
    }

    public String getCargo() {
        return cargo;
    }

    public double getNumEnergyGen() {
        return numEnergyGen;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDraft(float draft) {
        this.draft = draft;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNumEnergyGen(double numEnergyGen) {
        this.numEnergyGen = numEnergyGen;
    }


    public static Ship findShip(AVL avl, int mmsi) {
        if (avl.isEmpty()) {
            return null;
        }
        Iterable<Ship> list = avl.preOrder();
        for (Ship ship : list) {
            if (mmsi == ship.getMmsi()) {
                return ship;
            }
        }
        return null;
    }


    @Override
    public int compareTo(Ship ship) {
        int resultado=0;
        if (this.mmsi<ship.getMmsi()) {
            resultado = -1;
        }else if (this.mmsi>ship.getMmsi()) {
            resultado = 1;
        }
        return resultado;
    }
}
