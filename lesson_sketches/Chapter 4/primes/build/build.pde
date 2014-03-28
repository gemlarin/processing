//primary creation
void setup() {
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

void primeCell (float w, float h){
  fill(255, 0, 0);
  ellipse(0, 0, w, h);
}//end primeCell

void compositeCell(float w, float h){
  fill(255);
  rect(-w/2, -h/2, w, h);
}//end compositeCell

//return true or false
boolean isPrime(int n) {
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



