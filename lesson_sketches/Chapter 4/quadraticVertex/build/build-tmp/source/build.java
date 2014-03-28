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

float ax, ay, cx, cy;
boolean isOnControl, isOnAnchor;
float radius = 5;

public void setup() {
	size(600, 600);
	cx = random(100, width-100);
	cy = random(100, height-100);
	ax = random(100, width-100);
	ay = random(100, height-100);	
}//end setup

public void draw() {
	background(255);
	noFill();
	strokeWeight(4);
	stroke(0);

	//draw curve;
	beginShape();
	vertex(width/2, height/2);
	quadraticVertex(cx, cy, ax, ay);
	endShape();

	//draw centerpoint
	fill(200);
	strokeWeight(1);
	ellipse(width/2, height/2, radius*2, radius*2);

	//draw connecting handle
	line(cx, cy, ax, ay);

	//draw control point
	fill(0,0,255);
	rect(cx-radius, cy-radius, radius*2, radius*2);

	//draw anchor point
	fill(255, 127, 0);
	ellipse(ax, ay, radius*2, radius*2);

	//detect if mouse is on control/anchor point
	if(dist(mouseX, mouseY, ax, ay) < radius)
	{
		isOnAnchor = true;
	}
	else if(dist(mouseX, mouseY, cx, cy) < radius){
		isOnControl= true;
	}
	else {
		isOnAnchor = isOnControl = false;
	}

}//end draw

public void mouseDragged(){
	//move points
	if(isOnControl){
		cx = mouseX;
		cy = mouseY;
	}
	else if(isOnAnchor){
		ax = mouseX;
		ay = mouseY;
	}
	if(cx <= 0 ){
		cx = +radius;
	}
	else if(ax <= 0){
		ax = + radius;
	}
	if(ax >= width){
		ax = width -radius;
	}
	else if(cx >= width){
		cx = width - radius;
	}


	if(cy <= 0 ){
		cy = +radius;
	}
	else if(ay <= 0){
		ay = +radius;
	}
	if(ay >= height){
		ay = height -radius;
	}
	else if(cy >= height){
		cy = height -radius;
	}
}//end mouseDragged
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
