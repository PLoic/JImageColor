package imageColor;

/**
 * Created by loic on 13/10/15.
 */
public class Pixel {

    private int x;
    private int y;
    private int[] color;

    public Pixel(int x, int y, int[] color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public int[] getColor() {
        return color;
    }
}
