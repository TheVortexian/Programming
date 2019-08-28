/**
* Driver code for whatever this will turn out to be
* An exploration of both Swing and improving my Java abilities
* 
* @Date: 8/24/2019
* @Author: the owner of this repo
* @Description: Probably some calculators to start lol
*/

public class Main {

   public static void main(String[] args) {
      System.out.println(mystery6(5, 4));
   }
   public static int mystery6(int n, int k) {
    if (k == 0 || k == n) {
        return 1;
    } else if (k > n) {
        return 0;
    } else {
        return mystery6(n - 1, k - 1) + mystery6(n - 1, k);
    }
}
}