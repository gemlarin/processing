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
int Color;


Walker() {
	x = width/2;
	y = height/2;
	Color = color(PApplet.parseInt(random(255)),PApplet.parseInt(random(255)),PApplet.parseInt(random(255)));

}

public void display(){

	stroke(Color);
	point(x,y);
}

public void step(){
	
	int followMouse = PApplet.parseInt(random(2));

	if (followMouse == 0){
		float r = random(1);
		if (r < 0.4f){
			x++;
		} else if (r < 0.6f){
			x--;
		} else if (r < 0.8f){
			y++;
		} else {
			y--;
		}	
	}else if (followMouse == 1){
		if (x < mouseX){
			x++;
		}else if (x > mouseX){
			x--;
		}
		if (y < mouseY){
			y++;
		}else if (y > mouseY){
			y--;
		}
		
	}


	

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
