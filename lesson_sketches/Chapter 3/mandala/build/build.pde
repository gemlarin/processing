void setup() {
	size(1000, 1000);
	background(0);
	noStroke();
	translate(width/2, height/2);

	int pointCount = 8;
	int steps = 60;
	float outerRadius = width*.5;
	float innerRadiusFactor = 0.7;
	float innerRadius = outerRadius*innerRadiusFactor;
	float outerRadiusRatio = outerRadius/steps;
	float innerRadiusRatio = innerRadius/steps;
	float shadeRatio = 255.0/steps;
	float rotationRatio = 45.0/steps;

	for (int i=0; i<steps; i++) {
		stroke(255-shadeRatio*i, 100);
		fill(shadeRatio*i);
		pushMatrix();
		rotate(rotationRatio*i*PI/180);
		star(pointCount, outerRadius-outerRadiusRatio*i, innerRadius-innerRadiusRatio*i);
		popMatrix();
	}
	
}




