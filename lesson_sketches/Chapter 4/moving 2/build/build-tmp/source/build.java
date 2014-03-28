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

float x, y, w;
float spdX, spdY, theta, rotSpd;
float cornerRadiusOffset, dynamicRadius, collisionTheta;

public void setup() {
	size(800, 800);	
	x = width/2;
	y = height/2;
	w = 150;
	spdX = 2.1f;
	spdY = 1.5f;
	rotSpd = PI/180;
	fill(0, 175, 175);
	noStroke();
}

public void draw() {
	background(255, 127, 0);
	pushMatrix();
	translate(x, y);
	rotate(theta);
	rect(-w/2, -w/2, w, w);
	popMatrix();
	x+= spdX;
	y+= spdY;
	theta += rotSpd;
	collide();
}
public void collide(){
	//calculate dynamicRadius for more accurate wall collisions
	cornerRadiusOffset = w/2/cos(PI/4) - w/2;
	//calculate difference between corner and side
	dynamicRadius = abs(sin(collisionTheta)*cornerRadiusOffset);

	if (x > width-w/2 - dynamicRadius){
		spdX *= -1;
		rotSpd *= -1;
	}

	else if (x< w/2 + dynamicRadius){
		spdX *= -1;
		rotSpd *= -1;
	}

	if (y > height-w/2 - dynamicRadius){
		spdY *= -1;
		rotSpd *= -1;
	}

	else if(y < w/2 + dynamicRadius){
		spdY *= -1;
		rotSpd *= -1;
	}
	collisionTheta += rotSpd*2;
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
