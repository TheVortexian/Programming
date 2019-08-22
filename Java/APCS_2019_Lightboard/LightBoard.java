public class LightBoard
{
 /** The lights on the board, where true represents on and false represents off.
 */
 private boolean[][] lights;
 /** Constructs a LightBoard object having numRows rows and numCols columns.
 * Precondition: numRows > 0, numCols > 0
 * Postcondition: each light has a 40% probability of being set to on.
 */
 public LightBoard(int numRows, int numCols)
 {
   
   lights = new boolean[numRows][numCols];
   
   for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
         if (Math.random() <= .4) {
            lights[c][r] = true;
         }
      }
   }
 }
 public boolean evaluateLight(int row, int col)
 {
   /*
   1. If the light is on, return false if the number of lights in its column that are on is even, including
the current light.
2. If the light is off, return true if the number of lights in its column that are on is divisible by three.
3. Otherwise, return the light’s current status. 
   */
   int lightsInCol = 0;
   for (int i = 0; i < lights.length; i++) {
      if (lights[r][col]) {
         lightsInCol++;
      }
   }
 }
}