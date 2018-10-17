
package FunctionLayer;

import java.util.List;

/**
 *
 * @author leage
 */
public class LegoHouse {
    List<LegoHouseLayer> listOfLayers; 

    public LegoHouse(List<LegoHouseLayer> house) {
        this.listOfLayers = house;
    }


    public List<LegoHouseLayer> getListOfLayers() {
        return listOfLayers;
    }

    
    
}
