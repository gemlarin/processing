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
	background(255, 255, 255);
	noSmooth();
	plotRect(100,100,400,400);
}

public void plotRect(float x, float y, float w, float h) {
	beginShape();
	vertex(x, y);
	vertex(x, y+h);
	vertex(x+w, y+h);
	vertex(x+w, y);
	endShape(CLOSE);
	
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
