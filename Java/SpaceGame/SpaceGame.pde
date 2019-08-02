/*
Some kind of space game, no idea where it's going yet.
 Developed with Processing (Java)
 */

public int GAMESTATE = 0;
public int SPACEVIEW = 1;
public int SHIPVIEW = 2;
public int PLANETVIEW = 3;

ArrayList<Planet> planets = new ArrayList<Planet>();
final int MAX_PLANETS = 100;
Player p;
void setup() {
  size(displayWidth, displayHeight); // dWidth and height are deprecated, not sure why
  for (int i = 0; i < MAX_PLANETS; i++) {
    planets.add(new Planet(random(width), random(height)));
  }
  p = new Player(400, 400);
}

// do screen drawing here
void draw() {
  background(0);
  for (Planet p : planets) {
    p.show();
  }
  p.show();
}
