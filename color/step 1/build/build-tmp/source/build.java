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

int r1 = 0;
int r2 = 0;
int r3 = 0;
int r4 = 0;
int r5 = 0;

public void setup() {
	size(600, 600);
	rectMode(CENTER);
	
}

public void draw() {
	background(0xffcccccc);
	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(100, height/2);
		rotate(radians(++r1));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(200, height/2);
		rotate(radians(++r2));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(300, height/2);
		rotate(radians(++r3));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(400, height/2);
		rotate(radians(++r4));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(500, height/2);
		rotate(radians(++r5));
		rect(0, 0, 50, 50);
	popMatrix();

	ellipse(100, height/2, 5, 5);
	ellipse(200, height/2, 5, 5);
	ellipse(300, height/2, 5, 5);
	ellipse(400, height/2, 5, 5);
	ellipse(500, height/2, 5, 5);

	line(0, height/2, width, height/2);

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
