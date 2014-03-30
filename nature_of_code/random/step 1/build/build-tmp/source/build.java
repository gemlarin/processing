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

int[] randomCounts;

public void setup() {
	size(640,540);
	randomCounts = new int[20];
}

public void draw() {
	background(255);
	int index = PApplet.parseInt(random(randomCounts.length));
	randomCounts[index]++;
	stroke(0);
	fill(175);
	int w = width/randomCounts.length;
	for (int x = 0; x < randomCounts.length; x++){
		rect(x*w,height-randomCounts[x], w-1, randomCounts[x]);
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
