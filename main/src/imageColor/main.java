package imageColor;

/**
 * Created by loic on 09/10/15.
 */
public class main {

    public static void afficher(Integer[][] matrice)
    {
        for (int i = 0; i < matrice.length; ++i)
        {
            for (int j = 0; j < matrice[0].length; ++j)
            {
                System.out.println(matrice[i][j]);
            }
            System.out.println('\n');
        }
    }

    public static void main(String[] args) {
        Generator generator = new Generator("test.pbm");
        generator.generate(100,100);

        Reader reader = new Reader("test.pbm");

        Integer[][] matrice;
        matrice = reader.Read();
        System.out.println(matrice);

    }

}
