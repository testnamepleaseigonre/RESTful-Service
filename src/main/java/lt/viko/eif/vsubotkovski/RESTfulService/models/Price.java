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
public class Price {
    private Integer costNumber;
    private String costUnit;

    /**
     *
     * @return
     */
    public String getCostUnit() {
        return costUnit;
    }

    /**
     *
     * @param costUnit
     */
    @XmlElement(name = "cost-unit")
    public void setCostUnit(String costUnit) {
        this.costUnit = costUnit;
    }

    /**
     *
     * @return
     */
    public Integer getCostNumber() {
        return costNumber;
    }

    /**
     *
     * @param costNumber
     */
    @XmlElement(name = "cost-number")
    public void setCostNumber(Integer costNumber) {
        this.costNumber = costNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s", costNumber, costUnit);
    }
}
