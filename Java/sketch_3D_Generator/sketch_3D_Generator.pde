/*

 Generates random 3D shapes by vertex distribution
 
 */
Shape s;
void setup() {
  size(displayWidth, displayHeight, P3D);
  background(255);
  lights();
  s = new Shape(50);
}
float rotX = 0, rotY = 0;
void mouseDragged() {
  rotX += ((pmouseX - mouseX) * PI/180);
  rotY += ((pmouseY - mouseY) * PI/180);
}
void draw() {
  s.showShape(rotX, rotY);
}
