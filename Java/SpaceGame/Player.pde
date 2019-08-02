/*
  
 Player Class
 
 */

public class Player {

  private long money;
  private PVector location;
  private int shipType;
  private PImage shipImage;

  public Player (float x, float y) {
    this.location = new PVector(x, y);
    this.money = 100;
    this.shipType = 0;
    this.shipImage = loadImage("s0.png");
    this.shipImage.resize(85, 115);
  }

  //updates current ship PNG
  public void updateShip() {
    String currShip = "s" + shipType + ".png";
    this.shipImage = loadImage(currShip);
  }
  // getters / setters
  public long getMoney() {
    return this.money;
  }
  public void setMoney(long n) {
    this.money = n;
  }
  public PVector getLocation() {
    return this.location;
  }
  public void setLocation(PVector newPos) {
    this.location = newPos;
  }
  
  public void show() {
    pushMatrix();
    translate(this.location.x, this.location.y);
    rotate((atan2(this.location.x - mouseX, this.location.y - mouseY)) - HALF_PI);
    image(shipImage, 0, 0);
    popMatrix();
  }
}
