int r1 = 0;
int r2 = 0;
int r3 = 0;
int r4 = 0;
int r5 = 0;

void setup() {
	size(600, 600);
	rectMode(CENTER);
	
}

void draw() {
	background(#cccccc);
	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(100, height/2);
		rotate(radians(++r1));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(200, height/2);
		rotate(radians(++r2));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(300, height/2);
		rotate(radians(++r3));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(400, height/2);
		rotate(radians(++r4));
		rect(0, 0, 50, 50);
	popMatrix();

	pushMatrix();
		fill(color (random(255), random(255), random(255)) );
		translate(500, height/2);
		rotate(radians(++r5));
		rect(0, 0, 50, 50);
	popMatrix();

	ellipse(100, height/2, 5, 5);
	ellipse(200, height/2, 5, 5);
	ellipse(300, height/2, 5, 5);
	ellipse(400, height/2, 5, 5);
	ellipse(500, height/2, 5, 5);

	line(0, height/2, width, height/2);

}
