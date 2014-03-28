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
	size(400, 400);
	background(255, 255, 255);
	fill(100);
	translate(width/2, height/2);
	rotate(PI/7);
	polygon(600, 100);
}


public void polygon(int sideCount, float radius){

	float theta = 0.0f;
	float x = 0.0f;
	float y = 0.0f;

	beginShape();

	for (int i=0; i<sideCount; i++){

	x = cos(theta)*radius;
	y = sin(theta)*radius;
	vertex(x, y);
	theta += TWO_PI/sideCount;
	}
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
