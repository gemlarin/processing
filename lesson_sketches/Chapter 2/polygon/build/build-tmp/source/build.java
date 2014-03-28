import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

public void setup() {
  size(600, 600);
  background(0);
  rect(175, 175, 350, 350, false);
  rect(300, 300, 300, 300, true);

}

public void rect(float x, float y, float w, float h, boolean isRect) {
    if (isRect){
      rect(x, y, w, h);
    }

    if (!isRect){
      ellipse(x, y, w, h);
    }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
