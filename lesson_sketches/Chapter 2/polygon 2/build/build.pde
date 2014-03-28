void setup() {
	size(600, 600);
	background(255, 255, 255);
	noSmooth();
	plotRect(100,100,400,400);
}

void plotRect(float x, float y, float w, float h) {
	beginShape();
	vertex(x, y);
	vertex(x, y+h);
	vertex(x+w, y+h);
	vertex(x+w, y);
	endShape(CLOSE);
	
}