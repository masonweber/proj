/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cube;

/**
 *
 * @author Mason Weber
 */
public class Face {
    int array[][] = new int[3][3];
   
    public Face(int side) { // constructor, changed from method 'blank'
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                array[i][j]=side;
            }
        }
    }    
    
    public Face() {
        // no changes to array[][]
    }
}
