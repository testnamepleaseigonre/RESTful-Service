/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.viko.eif.vsubotkovski.RESTfulService.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valde
 */
@XmlRootElement
public class Emission {
    private Integer emissionNumber;
    private String emissionUnit;

    /**
     *
     * @return
     */
    public Integer getEmissionNumber() {
        return emissionNumber;
    }
    
    /**
     *
     * @param emissionNumber
     */
    @XmlElement(name = "emission-number")
    public void setEmissionNumber(Integer emissionNumber) {
        this.emissionNumber = emissionNumber;
    }

    /**
     *
     * @return
     */
    public String getEmissionUnit() {
        return emissionUnit;
    }
    
    /**
     *
     * @param emissionUnit
     */
    @XmlElement(name = "emission-unit")
    public void setEmissionUnit(String emissionUnit) {
        this.emissionUnit = emissionUnit;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", emissionNumber, emissionUnit);
    }
}
