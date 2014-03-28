void setup() {
	size(800, 800);
	background(0);
	noFill();
}

void draw() {
	stroke(255, random(255));
	rect(random(width), random(height), random(5, 20), random(5,20));
}
