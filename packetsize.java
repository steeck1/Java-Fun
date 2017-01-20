
package bandwidthcalculator;

import javax.persistence.Entity;

@Entity
public class packetsize {

    private float band;

    public packetsize(float band) {
        this.band = band;
    }

    public Float getBand() {
        return band;
    }
}
