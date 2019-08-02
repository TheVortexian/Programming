/*
  Public class that each planet will be instantiated according to
 */
import java.util.*;
import java.awt.Color;

public class Planet {

  private PVector location;
  private String pName;
  private Map biomePercents;

  //biomes and colors
  private final String[] biomes = {"sand", "ocean", "grass", "jungle", "forest", "mountain"};
  private final HashMap<String, Color> colors = new HashMap<String, Color>()
  {
    {
      put("sand", Color.decode("#BCBC1E"));
      put("ocean", Color.decode("#1E54BC"));
      put("grass", Color.decode("#0BA21B"));
      put("jungle", Color.decode("#0F6C19"));
      put("forest", Color.decode("#5A9343"));
      put("mountain", Color.decode("#7B8975"));
    }
  };

  // Constructor for planet object
  public Planet (float x, float y) {
    this.location = new PVector(x, y);
    this.biomePercents = new HashMap<String, Float>();
    float percent1 = random(100);
    biomePercents.put(biomes[(int)random(biomes.length)], percent1);
    float percent2 = 100-percent1;
    biomePercents.put(biomes[(int)random(biomes.length)], percent2);
    this.pName = makeRandomName();
  }

  // generates a random planet name
  private String makeRandomName() {
    String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru", 
      "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol", 
      "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro", 
      "Mar", "Luk" };
    String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo", 
      "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer", 
      "marac", "zoir", "slamar", "salmar", "urak" };
    String[] End = { "d", "ed", "ark", "arc", "es", "er", "der", 
      "tron", "med", "ure", "zur", "cred", "mur" };

    String potentialSuffix = "-";
    int randSuffix = (int)random(-2000, 1000);
    if (randSuffix > 0) {
      potentialSuffix += randSuffix;
    }

    return (Beginning[(int)random(Beginning.length)] +
      Middle[(int)random(Middle.length)] +
      End[(int)random(End.length)] + potentialSuffix);
  }

  //gets name
  public String getPlanetName() {
    return this.pName;
  }

  // get/set for location
  public PVector getLoc() {
    return this.location;
  }
  public void setLoc(float x, float y) {
    this.location.set(x, y);
  }

  //shows the planet in "space". for now all planets
  //will have a predestined size.
  //the display color will be based on whichever biome is majorly present
  public void show() {
    //thanks stack overflow
    String b = Collections.max(biomePercents.keySet());
    Color c = colors.get(b);
    noStroke();
    fill(c.getRGB());
    ellipse(this.location.x, this.location.y, 20, 20);
  }
}
