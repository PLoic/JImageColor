package imageColor;

/**
 * Classe dédié à stocker toutes les données d'un pixel.
 *
 * @author Loic Mickael
 * @version 1.0
 */
public class Pixel {

    /**
     * La position de la ligne dans la matrice
     *
     * @see Pixel#Pixel(int, int, int[])
     */
    private int x;
    
    /**
     * La position de la colonne dans la matrice
     *
     * @see Pixel#Pixel(int, int, int[])
     */
    private int y;

    /**
     * Le tableau de couleur du pixel
     *
     * @see Pixel#Pixel(int, int, int[]) 
     * @see Pixel#setColor(int[]) 
     * @see Pixel#getColor() 
     */
    private int[] color;

    /**
     * Le constructeur du Pixel, il initialise toutes les valeurs
     *
     * @param x
     *          La valeur de la ligne dans la matrice 
     * @param y
     *          La valeur de la colonne dans la matrice
     * @param color
     *          Le tableau de couleur du pixel
     *
     * @see Pixel#x
     * @see Pixel#y
     * @see Pixel#color
     */
    public Pixel(int x, int y, int[] color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Met à jour la color du pixel
     *
     * @param color
     *          La nouvelle couleur du pixel
     * @see Pixel#color
     */
    public void setColor(int[] color) {
        this.color = color;
    }

    /**
     * Retourne la couleur du pixel
     *
     * @return La couleur du pixel
     *
     * @see Pixel#color
     */
    public int[] getColor() {
        return color;
    }
    
    public String toString() {
        return "" + x + " " + y;
    }
}
