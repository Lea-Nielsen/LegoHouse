
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leage
 */
public class Logic {

    boolean buildForbandter = false;

    public LegoHouse getHouse(int length, int width, int layers) {
        List<LegoHouseLayer> houseDone = new ArrayList();

        for (int i = 0; i < layers; i++) {
            houseDone.add(getLayers(length, width));
        }

        LegoHouse house = new LegoHouse(houseDone);
        return house;

    }

    public LegoHouseLayer getLayers(int length, int width) {

        if (buildForbandter == false) {
            width = width - 4;
        } else {
            length = length - 4;
        }

        LegoHouseSide sideWest = calculateASideLength(length);
        LegoHouseSide sideEast = calculateASideLength(length);
        LegoHouseSide sideNorth = calculateASideWitdth(width);
        LegoHouseSide sideSouth = calculateASideWitdth(width);

        LegoHouseLayer legoHouseLayer = new LegoHouseLayer(sideWest, sideEast, sideNorth, sideSouth);
        buildForbandter = true;
        return legoHouseLayer;

    }

    public LegoHouseSide calculateASideLength(int length) {

        int numberOfBricks1;

        if (length % 2 > 0) {
            numberOfBricks1 = 1;
        } else {
            numberOfBricks1 = 0;
        }

        int numberOfBricks4 = length / 4;
        int numberOfdotsLeft = length % 4;
        int numberOfBricks2 = numberOfdotsLeft / 2;

        LegoHouseSide side = new LegoHouseSide(numberOfBricks4, numberOfBricks2, numberOfBricks1);

        return side;
    }

    public LegoHouseSide calculateASideWitdth(int width) {
        int numberOfBricks1;
        if (width % 2 > 0) {
            numberOfBricks1 = 1;
        } else {
            numberOfBricks1 = 0;
        }
        int numberOfBricks4 = width / 4;
        int numberOfdotsLeft = width % 4;
        int numberOfBricks2 = numberOfdotsLeft / 2;

        LegoHouseSide side = new LegoHouseSide(numberOfBricks4, numberOfBricks2, numberOfBricks1);

        return side;
    }

    public int getAllBricksForLegoHouse(LegoHouseLayer layer, Order order) {
        int east = layer.getSideEast().getBrick1() + layer.getSideEast().getBrick2() + layer.getSideEast().getBrick4();
        int west = layer.getSideWest().getBrick1() + layer.getSideWest().getBrick2() + layer.getSideWest().getBrick4();
        int south = layer.getSideSouth().getBrick1() + layer.getSideSouth().getBrick2() + layer.getSideSouth().getBrick4();
        int north = layer.getSideNorth().getBrick1() + layer.getSideNorth().getBrick2() + layer.getSideNorth().getBrick4();

        int allBricks = (east + west + north + south) * (order.getLayers());
        return allBricks;

    }

    public LegoHouseLayer getSingleLayer(LegoHouse house) {

        LegoHouseSide sideEast = null;
        LegoHouseSide sideNorth = null;
        LegoHouseSide sideWest = null;
        LegoHouseSide sideSouth = null;

        for (LegoHouseLayer layer : house.getListOfLayers()) {
            sideEast = layer.getSideEast();
            sideNorth = layer.getSideNorth();
            sideWest = layer.getSideWest();
            sideSouth = layer.getSideSouth();
        }
        LegoHouseLayer layer = new LegoHouseLayer(sideWest, sideEast, sideNorth, sideSouth);

        return layer;
    }

}
