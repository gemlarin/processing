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

Walker w;
Walker x;
Walker y;
Walker z;

public void setup() {
	size(640,360);
	w = new Walker();
	x = new Walker();
	y = new Walker();
	z = new Walker();
	background(255);
}

public void draw() {
	w.step();
	w.display();
	x.step();
	x.display();
	y.step();
	y.display();
	z.step();
	z.display();
}
class Walker {

int x;
int y;

Walker() {
	x = width/2;
	y = height/2;

}

public void display(){
	stroke(0);
	point(x,y);
}

public void step(){
	int stepx = PApplet.parseInt(random(3))-1;
	int stepy = PApplet.parseInt(random(3))-1;
	x += stepx;
	y += stepy;
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
