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

//primary creation
public void setup() {
  size(800, 800);
  background(0);
  float cols = 200;
  float rows = 200;
  float cellW = width/cols;
  float cellH = height/rows;
  noStroke();

  for(int i=0, k=0; i<rows; i++){
    for (int j=0; j<cols; j++){
      pushMatrix();
      translate(cellW/2+cellW*j, cellH/2+cellH*i);
      if (isPrime(k)){
        primeCell(cellW, cellH);
      }
      else {
        compositeCell(cellW, cellH);
      }
      popMatrix();
      k++;
    }
  }
}//end setup;

public void primeCell (float w, float h){
  fill(255, 0, 0);
  ellipse(0, 0, w, h);
}//end primeCell

public void compositeCell(float w, float h){
  fill(255);
  rect(-w/2, -h/2, w, h);
}//end compositeCell

//return true or false
public boolean isPrime(int n) {
  boolean checkPrime = false;
  for (int i=2;i<n;i++) {
    if (n%i== 0) {
      checkPrime=false;
      break;
    }
    else {
      checkPrime=true;
    }
  }
  return checkPrime;
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
