class Walker {

int x;
int y;
color Color;


Walker() {
	x = width/2;
	y = height/2;
	Color = color(int(random(255)),int(random(255)),int(random(255)));

}

void display(){

	stroke(Color);
	point(x,y);
}

void step(){
	
	int followMouse = int(random(2));

	if (followMouse == 0){
		float r = random(1);
		if (r < 0.4){
			x++;
		} else if (r < 0.6){
			x--;
		} else if (r < 0.8){
			y++;
		} else {
			y--;
		}	
	}else if (followMouse == 1){
		if (x < mouseX){
			x++;
		}else if (x > mouseX){
			x--;
		}
		if (y < mouseY){
			y++;
		}else if (y > mouseY){
			y--;
		}
		
	}


	

	}
}