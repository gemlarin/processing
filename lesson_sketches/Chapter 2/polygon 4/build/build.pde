

void setup() {
	size(800, 800);
	background(255, 255, 255);
	int polyCount = 3000;
	noFill();
	int sideCount = 0;
	float radius = 0.0;
	float rotation = 0.0;

	for (int i=0; i<polyCount; i++){
		sideCount = int(random(3, 15));
		radius = random(2, 20);
		rotation = random(TWO_PI);
		pushMatrix();
		translate(random(width), random(height));
		rotate(rotation);
		polygon(sideCount, radius);
		popMatrix();
	}

}


