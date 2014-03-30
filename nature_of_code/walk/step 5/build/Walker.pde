class Walker {

int x;
int y;
color Color;

Walker() {
	x = width/2;
	y = height/2;
	Color = color(int(random(255)),int(random(150)),int(random(150)));

}

void display(){

	stroke(Color);
	point(x,y);
}

void step(){
	int stepx = int(random(3))-1;
	int stepy = int(random(3))-1;
	x += stepx;
	y += stepy;
	}
}