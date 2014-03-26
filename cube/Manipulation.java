/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cube;

/**
 * Method class to hold manipulations
 * @author Mason Weber
 */
public class Manipulation {
    
    public Face twistLeft (Face preTwist) { // top face rotated counter-clockwise
        Face postTwist = new Face();
        
        postTwist.array[0][0] = preTwist.array[0][2];
        postTwist.array[0][1] = preTwist.array[1][2];
        postTwist.array[0][2] = preTwist.array[2][2];
        postTwist.array[1][0] = preTwist.array[0][1];
        postTwist.array[1][1] = preTwist.array[1][1];
        postTwist.array[1][2] = preTwist.array[2][1];
        postTwist.array[2][0] = preTwist.array[0][0];
        postTwist.array[2][1] = preTwist.array[1][0];
        postTwist.array[2][2] = preTwist.array[2][0]; // all old and new sides accounted for
        
        return postTwist;
    }
    public Face twistRight (Face preTwist) { // top face rotated clockwise
        Face postTwist = new Face();
        
        postTwist.array[0][0] = preTwist.array[2][0];
        postTwist.array[0][1] = preTwist.array[1][0];
        postTwist.array[0][2] = preTwist.array[0][0];
        postTwist.array[1][0] = preTwist.array[2][1];
        postTwist.array[1][1] = preTwist.array[1][1];
        postTwist.array[1][2] = preTwist.array[0][1];
        postTwist.array[2][0] = preTwist.array[2][2];
        postTwist.array[2][1] = preTwist.array[1][2];
        postTwist.array[2][2] = preTwist.array[0][2]; // all spaces accounted for
        
        return postTwist;
    }
    public void topRowRight() {
        // top.array +3 to index, rotate top face counter-clockwise
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15; // nifty trick I thought up.  REUSE!
            shift.array[j] = Cube.top.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.top = shift;
        Cube.d6[4] = twistLeft(Cube.d6[4]); // replaces side 5 with rotated side 5
        // implement a rowsToD6 method
    }
    public void topRowLeft() {
        // top.array -3 to index, rotate top face clockwise
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.top.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.top = shift;
        Cube.d6[4] = twistRight(Cube.d6[4]); // replaces side 5 with rotated side 5
        // implement a rowsToD6 method
    }
    public void botRowRight() {
        // bot.array +3 to index, rotate bottom face clockwise
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15;
            shift.array[j] = Cube.bot.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.bot = shift;
        Cube.d6[1] = twistRight(Cube.d6[1]); // replaces side 2 with rotated side 2
    }
    public void botRowLeft() {
        // bot.array -3 to index, rotate bottom face counter-clockwise
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.bot.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.bot = shift;
        Cube.d6[1] = twistLeft(Cube.d6[1]); // replaces side 2 with rotated side 2
    }
    public void leftColUp() {
        //left.array -3 to index, rotate left face counter-clockwise
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.left.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.left = shift;
        Cube.d6[2] = twistLeft(Cube.d6[2]); // side 3 counterclockwise
    }
    public void leftColDown() {
        //left.array +3 to index, rotate left face clockwise
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15;
            shift.array[j] = Cube.left.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.left = shift;
        Cube.d6[2] = twistRight(Cube.d6[2]); // side 3 clockwise        
    }
    public void rightColUp() {
        //right.array -3 to index, rotate right face clockwise
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.right.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.right = shift;
        Cube.d6[3] = twistRight(Cube.d6[3]); // side 4 clockwise
    }
    public void rightColDown() {
        //right.array +3 to index, rotate right face counter-clockwise
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15;
            shift.array[j] = Cube.right.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.right = shift;
        Cube.d6[3] = twistLeft(Cube.d6[3]); // side 4 counterclockwise
    }
    public void rotateDown() {
        //+3 index to left, right, and mid_col
        //right face counter-clockwise, left face clockwise
        leftColDown();
        rightColDown();
        
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15;
            shift.array[j] = Cube.mid_col.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.mid_col = shift;
        //d6: 1->2, 2->6, 6->5, 5->1
        Face swap = Cube.d6[0];
        Cube.d6[0] = Cube.d6[4]; 
        Cube.d6[4] = Cube.d6[5];
        Cube.d6[5] = Cube.d6[1];
        Cube.d6[1] = swap;        
    }
    public void rotateUp() {
        //-3 index to left, right, and mid_col
        //left face to counter-clockwise, right face clockwise
        leftColUp();
        rightColUp();
        
        Col shift = new Col();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.mid_col.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.mid_col = shift;
        //d6: 1->5, 5->6, 6->2, 2->1
        Face swap = Cube.d6[0];
        Cube.d6[0] = Cube.d6[1]; 
        Cube.d6[1] = Cube.d6[5];
        Cube.d6[5] = Cube.d6[4];
        Cube.d6[4] = swap; 
    }
    public void rotateLeft() {
        //-3 index to top, mid_row, and bot
        //top face clockwise, bot face counter-clockwise
        topRowLeft();
        botRowLeft();
        
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i-3) % 15;
            shift.array[j] = Cube.mid_row.array[i];
        }
        shift.array[0] = shift.array[12];
        shift.array[1] = shift.array[13];
        shift.array[2] = shift.array[14];
        Cube.mid_row = shift;
        //d6: 1->3, 3->6, 6->4, 4->1
        Face swap = Cube.d6[0];
        Cube.d6[0] = Cube.d6[3]; 
        Cube.d6[3] = Cube.d6[5];
        Cube.d6[5] = Cube.d6[2];
        Cube.d6[2] = swap;
    }
    public void rotateRight() {
        //+3 index to top, bot, and mid_row
        //top face counter-clockwise, bot face clockwise
        topRowRight();
        botRowRight();
        
        Row shift = new Row();
        for (int i=0; i<15; i++) {
            int j = (i+3) % 15;
            shift.array[j] = Cube.mid_row.array[i];
        }
        shift.array[12] = shift.array[0];
        shift.array[13] = shift.array[1];
        shift.array[14] = shift.array[2];
        Cube.mid_row = shift;
        //d6: 1->4, 4->6, 6->3, 3->1
        Face swap = Cube.d6[0];
        Cube.d6[0] = Cube.d6[2]; 
        Cube.d6[2] = Cube.d6[5];
        Cube.d6[5] = Cube.d6[3];
        Cube.d6[3] = swap;
    }
    
}