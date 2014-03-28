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
	background(255);
	noFill();
	strokeWeight(4);
	translate(width/2, 0);

	//draw quadratic curve
	float fx2Max = fx2(width/2);
	float fx2scale = height/fx2Max;

	stroke(0, 0, 255);
	beginShape();
	for (int i=-width/2; i<width/2; i++){
		vertex(i, fx2(i) *fx2scale);
	}
	endShape();

	//draw cubic curve
	stroke(255, 127, 0);
	float fx3Max = fx3(width/2);
	float fx3Scale = height/(fx3Max*2);

	beginShape();
	for (int i=-width/2; i<width/2; i++){
		vertex(i, height/2+fx3(i)*fx3Scale);
	}
	endShape();
}//end setup

//quadratic
public float fx2(float x){
	return x*x;
} //end fx2

//cubic
public float fx3(float x){
	return x*x*x;
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
