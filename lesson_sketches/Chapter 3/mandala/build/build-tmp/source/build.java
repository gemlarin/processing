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
	size(1000, 1000);
	background(0);
	noStroke();
	translate(width/2, height/2);

	int pointCount = 8;
	int steps = 60;
	float outerRadius = width*.5f;
	float innerRadiusFactor = 0.7f;
	float innerRadius = outerRadius*innerRadiusFactor;
	float outerRadiusRatio = outerRadius/steps;
	float innerRadiusRatio = innerRadius/steps;
	float shadeRatio = 255.0f/steps;
	float rotationRatio = 45.0f/steps;

	for (int i=0; i<steps; i++) {
		stroke(255-shadeRatio*i, 100);
		fill(shadeRatio*i);
		pushMatrix();
		rotate(rotationRatio*i*PI/180);
		star(pointCount, outerRadius-outerRadiusRatio*i, innerRadius-innerRadiusRatio*i);
		popMatrix();
	}
	
}




public void star(int pointCount, float innerRadius, float outerRadius){
	float theta = 0.0f;
	//point count is 1/2 of total vertex count
	int vertCount = pointCount*2;
	float thetaRot = TWO_PI/vertCount;
	float tempRadius = 0.0f;
	float x = 0.0f, y = 0.0f;

	beginShape();
	for (int i=0; i<pointCount; i++){
		for (int j=0; j<2; j++){
			tempRadius = innerRadius;
			// true if j is even
			if (j%2==0) {
				tempRadius = outerRadius;
			}
			x = cos(theta)*tempRadius;
			y = sin(theta)*tempRadius;
			vertex(x, y);
			theta += thetaRot;
		}
	}
	endShape(CLOSE);

}//end star
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
