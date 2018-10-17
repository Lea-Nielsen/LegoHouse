package FunctionLayer;

/**
 *
 * @author leage
 */
public class LegoHouseLayer {

    LegoHouseSide sideWest;
    LegoHouseSide sideEast;
    LegoHouseSide sideNorth;
    LegoHouseSide sideSouth;

    public LegoHouseLayer(LegoHouseSide sideWest, LegoHouseSide sideEast, LegoHouseSide sideNorth, LegoHouseSide sideSouth) {
        this.sideWest = sideWest;
        this.sideEast = sideEast;
        this.sideNorth = sideNorth;
        this.sideSouth = sideSouth;
    }

    public LegoHouseSide getSideWest() {
        return sideWest;
    }

    public LegoHouseSide getSideEast() {
        return sideEast;
    }

    public LegoHouseSide getSideNorth() {
        return sideNorth;
    }

    public LegoHouseSide getSideSouth() {
        return sideSouth;
    }

}
