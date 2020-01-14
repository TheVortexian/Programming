public class Shape {

  /*
  
   */

  public int vertices;

  Shape(int verts) {
    this.vertices = verts;
  }

  private void makeShape() {
    beginShape();
    //centered around width/2, height/2, so 0, 0, 0
    float maxDist = 200;
    float minDist = 50;
    for (int i = 0; i < this.vertices; i++) {
      float x = 0, y = 0, z = 0;
      x = random(-maxDist, maxDist);
      y = random(-maxDist, maxDist);
      z = map(random(-maxDist, maxDist), -maxDist, maxDist, 1, maxDist);
      vertex(x, y, z);
    }
    endShape(CLOSE);
  }
  public void showShape(float rotX, float rotY) {
    background(255);
    lights();
    translate(width/2, height/2);
    pushMatrix();
    fill(100);
    rotateX(rotY);
    rotateY(-rotX);
    makeShape();
    popMatrix();
  }
}
