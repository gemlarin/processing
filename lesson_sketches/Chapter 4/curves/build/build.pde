void setup() {
	size(600, 600);
	background(255);
	noFill();
	strokeWeight(4);
	translate(width/2, 0);

	//draw quadratic curve
	float fx2Max = fx2(width/2);
	float fx2scale = height/fx2Max;

	stroke(0, 0, 255);
	beginShape();
	for (int i=-width/2; i<width/2; i++){
		vertex(i, fx2(i) *fx2scale);
	}
	endShape();

	//draw cubic curve
	stroke(255, 127, 0);
	float fx3Max = fx3(width/2);
	float fx3Scale = height/(fx3Max*2);

	beginShape();
	for (int i=-width/2; i<width/2; i++){
		vertex(i, height/2+fx3(i)*fx3Scale);
	}
	endShape();
}//end setup

//quadratic
float fx2(float x){
	return x*x;
} //end fx2

//cubic
float fx3(float x){
	return x*x*x;
}


