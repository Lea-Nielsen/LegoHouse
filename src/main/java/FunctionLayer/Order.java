
package FunctionLayer;

/**
 *
 * @author leage
 */
public class Order {

    int id;
    int length, width, layers, userid;
    boolean shipped;

    public Order(int length, int width, int layers) {
        this.length = length;
        this.width = width;
        this.layers = layers;

    }

    public Order(int length, int width, int layers, boolean shipped) {

        this.length = length;
        this.width = width;
        this.layers = layers;
        this.shipped = shipped;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getLayers() {
        return layers;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

}
