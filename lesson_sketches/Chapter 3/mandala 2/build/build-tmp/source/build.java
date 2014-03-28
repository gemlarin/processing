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
	background(255);
	//presets
	int rows = 4;
	int cols = 4;
	float outerRadius = width/cols;

	//randomly generated
	int pointCount;
	int steps;
	float innerRadius;
	float outerRadiusRatio;
	float innerRadiusRatio;
	float shadeRatio;
	float rotationRatio;

	translate(outerRadius/2, outerRadius/2);
	for (int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			pointCount = PApplet.parseInt(random(5,15));
			steps = PApplet.parseInt(random(3, 20));
			innerRadius = outerRadius*random(.3f, .9f);
			outerRadiusRatio = outerRadius/steps;
			innerRadiusRatio = innerRadius/steps;
			float randCol = random(225, 255);
			shadeRatio = randCol/steps;
			rotationRatio = random(90, 200)/steps;
			pushMatrix();
			translate(outerRadius*j, outerRadius*i);
			for(int k=0; k<steps; k++){
				fill(shadeRatio*k);
				stroke(randCol-shadeRatio*k, 100);
				pushMatrix();
				scale(.4f);
				rotate(rotationRatio*k*PI/180);
				star(pointCount, outerRadius-outerRadiusRatio*k, innerRadius-innerRadiusRatio*k);
				popMatrix();
			}
			popMatrix();
		}

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
		println("i: "+i + ", theta " + theta);
		for (int j=0; j<2; j++){
			tempRadius = innerRadius;
			println("j: "+j);
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
