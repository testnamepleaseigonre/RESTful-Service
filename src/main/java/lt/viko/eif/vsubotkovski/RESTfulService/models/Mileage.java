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
public class Mileage {
    private Integer mileageNumber;
    private String mileageUnit;

    /**
     *
     * @return
     */
    public Integer getMileageNumber() {
        return mileageNumber;
    }
    
    /**
     *
     * @param mileageNumber
     */
    @XmlElement(name = "mileage-number")
    public void setMileageNumber(Integer mileageNumber) {
        this.mileageNumber = mileageNumber;
    }

    /**
     *
     * @return
     */
    public String getMileageUnit() {
        return mileageUnit;
    }
    
    /**
     *
     * @param mileageUnit
     */
    @XmlElement(name = "mileage-unit-short")
    public void setMileageUnit(String mileageUnit) {
        this.mileageUnit = mileageUnit;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", mileageNumber, mileageUnit);
    }
}
