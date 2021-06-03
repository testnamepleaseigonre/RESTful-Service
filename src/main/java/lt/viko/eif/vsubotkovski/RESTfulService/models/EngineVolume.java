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
public class EngineVolume {
    private Double volumeNumber;
    private String volumeUnit;

    /**
     *
     * @return
     */
    public Double getVolumeNumber() {
        return volumeNumber;
    }
    
    /**
     *
     * @param volumeNumber
     */
    @XmlElement(name = "engine-volume-number")
    public void setVolumeNumber(Double volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    /**
     *
     * @return
     */
    public String getVolumeUnit() {
        return volumeUnit;
    }
    
    /**
     *
     * @param volumeUnitt
     */
    @XmlElement(name = "engine-volume-unit-short")
    public void setVolumeUnit(String volumeUnitt) {
        this.volumeUnit = volumeUnitt;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", volumeNumber, volumeUnit);
    }
    
}
