 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cube;

/**
 *
 * @author Mason Weber
 */
public class Cube {
    
    static Face f_1 = new Face(1);
    static Face f_2 = new Face(2);
    static Face f_3 = new Face(3);
    static Face f_4 = new Face(4);
    static Face f_5 = new Face(5);
    static Face f_6 = new Face(6); // all six side initialized, no numbers in arrays yet.
    
    static Face d6[] = new Face[6]; // to keep track of locations reletive to one another
    
    /* the die variable keeps track of the location of the faces, for reference.
     * front face is 1, or [0]; bottom is 2 or [1]; left is 3 or [2]; right is 4 or [3]
     * top is 5 or [4]; and back is 6 or [5]; refer to d6 as needed
     *              6
     *              5 
     *          6 3 1 4 6
     *              2
     *              6
     */
    
    static Row top = new Row();
    static Row bot = new Row();
    static Row mid_row = new Row();
    static Col left = new Col();
    static Col right = new Col();
    static Col mid_col = new Col();
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // call randomizer method, both for number of moves and what moves to use
        //establish sides to d6
        d6[0] = f_1;
        d6[1] = f_2;
        d6[2] = f_3;
        d6[3] = f_4;
        d6[4] = f_5;
        d6[5] = f_6;
        
        // call set up for rows and cols
        d6ToRow();
        d6ToCol();
        
        
    }
    public static void d6ToRow () {
        // 45 lines of matching array indexes with face, and array indexes
        top.array[0] = d6[5].array[0][0];
        top.array[1] = d6[5].array[0][1];
        top.array[2] = d6[5].array[0][2];
        top.array[3] = d6[2].array[0][0];
        top.array[4] = d6[2].array[0][1];
        top.array[5] = d6[2].array[0][2];
        top.array[6] = d6[0].array[0][0];
        top.array[7] = d6[0].array[0][1];
        top.array[8] = d6[0].array[0][2];
        top.array[9] = d6[3].array[0][0];
        top.array[10] = d6[3].array[0][1];
        top.array[11] = d6[3].array[0][2];
        top.array[12] = d6[5].array[0][0];
        top.array[13] = d6[5].array[0][1];
        top.array[14] = d6[5].array[0][2]; // top row done
        
        mid_row.array[0] = d6[5].array[1][0];
        mid_row.array[1] = d6[5].array[1][1];
        mid_row.array[2] = d6[5].array[1][2];
        mid_row.array[3] = d6[2].array[1][0];
        mid_row.array[4] = d6[2].array[1][1];
        mid_row.array[5] = d6[2].array[1][2];
        mid_row.array[6] = d6[0].array[1][0];
        mid_row.array[7] = d6[0].array[1][1];
        mid_row.array[8] = d6[0].array[1][2];
        mid_row.array[9] = d6[3].array[1][0];
        mid_row.array[10] = d6[3].array[1][1];
        mid_row.array[11] = d6[3].array[1][2];
        mid_row.array[12] = d6[5].array[1][0];
        mid_row.array[13] = d6[5].array[1][1];
        mid_row.array[14] = d6[5].array[1][2]; // middle row done
        
        bot.array[0] = d6[5].array[2][0];
        bot.array[1] = d6[5].array[2][1];
        bot.array[2] = d6[5].array[2][2];
        bot.array[3] = d6[2].array[2][0];
        bot.array[4] = d6[2].array[2][1];
        bot.array[5] = d6[2].array[2][2];
        bot.array[6] = d6[0].array[2][0];
        bot.array[7] = d6[0].array[2][1];
        bot.array[8] = d6[0].array[2][2];
        bot.array[9] = d6[3].array[2][0];
        bot.array[10] = d6[3].array[2][1];
        bot.array[11] = d6[3].array[2][2];
        bot.array[12] = d6[5].array[2][0];
        bot.array[13] = d6[5].array[2][1];
        bot.array[14] = d6[5].array[2][2]; // bot row done        
    }
    public static void d6ToCol () {
        // 45 lines to assign array vars
        left.array[0] = d6[5].array[0][0];
        left.array[1] = d6[5].array[1][0];
        left.array[2] = d6[5].array[2][0];
        left.array[3] = d6[4].array[0][0];
        left.array[4] = d6[4].array[1][0];
        left.array[5] = d6[4].array[2][0];
        left.array[6] = d6[0].array[0][0];
        left.array[7] = d6[0].array[1][0];
        left.array[8] = d6[0].array[2][0];
        left.array[9] = d6[1].array[0][0];
        left.array[10] = d6[1].array[1][0];
        left.array[11] = d6[1].array[2][0];
        left.array[12] = d6[5].array[0][0];
        left.array[13] = d6[5].array[1][0];
        left.array[14] = d6[5].array[2][0]; // left col top to bot
        
        mid_col.array[0] = d6[5].array[0][1];
        mid_col.array[1] = d6[5].array[1][1];
        mid_col.array[2] = d6[5].array[2][1];
        mid_col.array[3] = d6[4].array[0][1];
        mid_col.array[4] = d6[4].array[1][1];
        mid_col.array[5] = d6[4].array[2][1];
        mid_col.array[6] = d6[0].array[0][1];
        mid_col.array[7] = d6[0].array[1][1];
        mid_col.array[8] = d6[0].array[2][1];
        mid_col.array[9] = d6[1].array[0][1];
        mid_col.array[10] = d6[1].array[1][1];
        mid_col.array[11] = d6[1].array[2][1];
        mid_col.array[12] = d6[5].array[0][1];
        mid_col.array[13] = d6[5].array[1][1];
        mid_col.array[14] = d6[5].array[2][1]; // mid col top to bot
        
        right.array[0] = d6[5].array[0][2];
        right.array[1] = d6[5].array[1][2];
        right.array[2] = d6[5].array[2][2];
        right.array[3] = d6[4].array[0][2];
        right.array[4] = d6[4].array[1][2];
        right.array[5] = d6[4].array[2][2];
        right.array[6] = d6[0].array[0][2];
        right.array[7] = d6[0].array[1][2];
        right.array[8] = d6[0].array[2][2];
        right.array[9] = d6[1].array[0][2];
        right.array[10] = d6[1].array[1][2];
        right.array[11] = d6[1].array[2][2];
        right.array[12] = d6[5].array[0][2];
        right.array[13] = d6[5].array[1][2];
        right.array[14] = d6[5].array[2][2]; // right col top to bot. all done assigning now
    }
    
    public void rowToD6() {        
        d6[5].array[0][0] = top.array[0];
        d6[5].array[0][1] = top.array[1];
        d6[5].array[0][2] = top.array[2];
        d6[2].array[0][0] = top.array[3];
        d6[2].array[0][1] = top.array[4];
        d6[2].array[0][2] = top.array[5];
        d6[0].array[0][0] = top.array[6];
        d6[0].array[0][1] = top.array[7];
        d6[0].array[0][2] = top.array[8];
        d6[3].array[0][0] = top.array[9];
        d6[3].array[0][1] = top.array[10];
        d6[3].array[0][2] = top.array[11];
        d6[5].array[0][0] = top.array[12];
        d6[5].array[0][1] = top.array[13];
        d6[5].array[0][2] = top.array[14];
        
        d6[5].array[1][0] = mid_row.array[0];
        d6[5].array[1][1] = mid_row.array[1];
        d6[5].array[1][2] = mid_row.array[2];
        d6[2].array[1][0] = mid_row.array[3];
        d6[2].array[1][1] = mid_row.array[4];
        d6[2].array[1][2] = mid_row.array[5];
        d6[0].array[1][0] = mid_row.array[6];
        d6[0].array[1][1] = mid_row.array[7];
        d6[0].array[1][2] = mid_row.array[8];
        d6[3].array[1][0] = mid_row.array[9];
        d6[3].array[1][1] = mid_row.array[10];
        d6[3].array[1][2] = mid_row.array[11];
        d6[5].array[1][0] = mid_row.array[12];
        d6[5].array[1][1] = mid_row.array[13];
        d6[5].array[1][2] = mid_row.array[14];
        
        d6[5].array[2][0] = bot.array[0];
        d6[5].array[2][1] = bot.array[1];
        d6[5].array[2][2] = bot.array[2];
        d6[2].array[2][0] = bot.array[3];
        d6[2].array[2][1] = bot.array[4];
        d6[2].array[2][2] = bot.array[5];
        d6[0].array[2][0] = bot.array[6];
        d6[0].array[2][1] = bot.array[7];
        d6[0].array[2][2] = bot.array[8];
        d6[3].array[2][0] = bot.array[9];
        d6[3].array[2][1] = bot.array[10];
        d6[3].array[2][2] = bot.array[11];
        d6[5].array[2][0] = bot.array[12];
        d6[5].array[2][1] = bot.array[13];
        d6[5].array[2][2] = bot.array[14];
    }
    
    public void colToD6 () {
        d6[5].array[0][0] = top.array[0];
        d6[5].array[0][1] = top.array[1];
        d6[5].array[0][2] = top.array[2];
        d6[2].array[0][0] = top.array[3];
        d6[2].array[0][1] = top.array[4];
        d6[2].array[0][2] = top.array[5];
        d6[0].array[0][0] = top.array[6];
        d6[0].array[0][1] = top.array[7];
        d6[0].array[0][2] = top.array[8];
        d6[3].array[0][0] = top.array[9];
        d6[3].array[0][1] = top.array[10];
        d6[3].array[0][2] = top.array[11];
        d6[5].array[0][0] = top.array[12];
        d6[5].array[0][1] = top.array[13];
        d6[5].array[0][2] = top.array[14];
        
        d6[5].array[1][0] = mid_row.array[0];
        d6[5].array[1][1] = mid_row.array[1];
        d6[5].array[1][2] = mid_row.array[2];
        d6[2].array[1][0] = mid_row.array[3];
        d6[2].array[1][1] = mid_row.array[4];
        d6[2].array[1][2] = mid_row.array[5];
        d6[0].array[1][0] = mid_row.array[6];
        d6[0].array[1][1] = mid_row.array[7];
        d6[0].array[1][2] = mid_row.array[8];
        d6[3].array[1][0] = mid_row.array[9];
        d6[3].array[1][1] = mid_row.array[10];
        d6[3].array[1][2] = mid_row.array[11];
        d6[5].array[1][0] = mid_row.array[12];
        d6[5].array[1][1] = mid_row.array[13];
        d6[5].array[1][2] = mid_row.array[14];
        
        d6[5].array[2][0] = bot.array[0];
        d6[5].array[2][1] = bot.array[0];
        d6[5].array[2][2] = bot.array[0];
        d6[2].array[2][0] = bot.array[0];
        d6[2].array[2][1] = bot.array[0];
        d6[2].array[2][2] = bot.array[0];
        d6[0].array[2][0] = bot.array[0];
        d6[0].array[2][1] = bot.array[0];
        d6[0].array[2][2] = bot.array[0];
        d6[3].array[2][0] = bot.array[0];
        d6[3].array[2][1] = bot.array[0];
        d6[3].array[2][2] = bot.array[0];
        d6[5].array[2][0] = bot.array[0];
        d6[5].array[2][1] = bot.array[0];
        d6[5].array[2][2] = bot.array[0];   
    }
}
