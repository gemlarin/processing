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

//global vars
float x, y, radius;

public void setup() {
  size(400, 400);
  background(255);
  x = width/2;
  y = height/2;
  radius = width*.5f;
  pushMatrix();
  translate(x, y);
  int pts = 600;
  int rots = 10;
  float fall_off = .992f;

  drawSpiral(pts, rots, radius, fall_off);
  popMatrix();

  drawFrame();
  
}//end setup

public void drawSpiral(float pts, int rots, float radius, float fallOff) {
  float x = 0;
  float y = 0;
  float theta = 0;
  beginShape();
  for(int i=0; i<pts; i++){
    x = cos(theta)*radius;
    y = sin(theta)*radius;
    vertex(x,y);
    radius *= fallOff;
    println("radius: "+radius);
    theta += TWO_PI*rots/pts;
  }
  endShape();
}//end drawSpiral

public void drawFrame(){
  noFill();
  strokeWeight(20);
  rect(x-radius-1, y-radius-1, radius*2, radius*2);
}//end drawFrame
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
