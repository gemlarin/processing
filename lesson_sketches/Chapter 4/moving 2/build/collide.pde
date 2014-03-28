void collide(){
	//calculate dynamicRadius for more accurate wall collisions
	cornerRadiusOffset = w/2/cos(PI/4) - w/2;
	//calculate difference between corner and side
	dynamicRadius = abs(sin(collisionTheta)*cornerRadiusOffset);

	if (x > width-w/2 - dynamicRadius){
		spdX *= -1;
		rotSpd *= -1;
	}

	else if (x< w/2 + dynamicRadius){
		spdX *= -1;
		rotSpd *= -1;
	}

	if (y > height-w/2 - dynamicRadius){
		spdY *= -1;
		rotSpd *= -1;
	}

	else if(y < w/2 + dynamicRadius){
		spdY *= -1;
		rotSpd *= -1;
	}
	collisionTheta += rotSpd*2;
}