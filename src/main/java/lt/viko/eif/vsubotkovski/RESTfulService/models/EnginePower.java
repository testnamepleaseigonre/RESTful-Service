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
public class EnginePower {
    private Integer hpNumber;
    private String hpUnit;

    /**
     *
     * @return
     */
    public Integer getHpNumber() {
        return hpNumber;
    }
    
    /**
     *
     * @param hpNumber
     */
    @XmlElement(name = "power-number")
    public void setHpNumber(Integer hpNumber) {
        this.hpNumber = hpNumber;
    }

    /**
     *
     * @return
     */
    public String getHpUnit() {
        return hpUnit;
    }
    
    /**
     *
     * @param hpUnit
     */
    @XmlElement(name = "power-unit-short")
    public void setHpUnit(String hpUnit) {
        this.hpUnit = hpUnit;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", hpNumber, hpUnit);
    }
}
