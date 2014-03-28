float x, y, w;
float spdX, spdY, theta, rotSpd;
float cornerRadiusOffset, dynamicRadius, collisionTheta;

void setup() {
	size(800, 800);	
	x = width/2;
	y = height/2;
	w = 150;
	spdX = 2.1;
	spdY = 1.5;
	rotSpd = PI/180;
	fill(0, 175, 175);
	noStroke();
}

void draw() {
	background(255, 127, 0);
	pushMatrix();
	translate(x, y);
	rotate(theta);
	rect(-w/2, -w/2, w, w);
	popMatrix();
	x+= spdX;
	y+= spdY;
	theta += rotSpd;
	collide();
}
