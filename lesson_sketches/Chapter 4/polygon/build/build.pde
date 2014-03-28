//global vars
float x, y, radius;

void setup() {
  size(400, 400);
  background(255);
  x = width/2;
  y = height/2;
  radius = width*.5;
  pushMatrix();
  translate(x, y);
  int pts = 600;
  int rots = 10;
  float fall_off = .992;

  drawSpiral(pts, rots, radius, fall_off);
  popMatrix();

  drawFrame();
  
}//end setup

void drawSpiral(float pts, int rots, float radius, float fallOff) {
  float x = 0;
  float y = 0;
  float theta = 0;
  beginShape();
  for(int i=0; i<pts; i++){
    x = cos(theta)*radius;
    y = sin(theta)*radius;
    vertex(x,y);
    radius *= fallOff;
    theta += TWO_PI*rots/pts;
  }
  endShape();
}//end drawSpiral

void drawFrame(){
  noFill();
  strokeWeight(20);
  rect(x-radius-1, y-radius-1, radius*2, radius*2);
}//end drawFrame