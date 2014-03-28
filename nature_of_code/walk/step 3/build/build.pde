Walker w;
Walker x;
Walker y;
Walker z;

void setup() {
	size(640,360);
	w = new Walker();
	x = new Walker();
	y = new Walker();
	z = new Walker();
	background(255);
}

void draw() {
	w.step();
	w.display();
	x.step();
	x.display();
	y.step();
	y.display();
	z.step();
	z.display();
}