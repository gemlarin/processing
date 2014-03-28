HRect d;
HColorPool colors;

void setup() {
	size(600, 600);
	H.init(this).background(#202020);
	smooth();

	colors = new HColorPool()
		.add(#FFFFFF, 9)
		.add(#ECECEC, 9)
		.add(#CCCCCC, 9)
		.add(#333333, 3)
		.add(#0095A8, 2)
		.add(#00616F, 2)
		.add(#FF3300)
		.add(#FF6600)
	;

	for (int i = 0; i<200; i++){
		d = new HRect();
		d
			.strokeWeight(1)
			.stroke(#000000)
			.fill( colors.getColor() )
			.size((int)random(25,125))
			.rotation( (int)random(360) )
			.loc((int)random(width), (int)random(height))
			.anchorAt(H.CENTER)
		;
		H.add(d);	

	}

	H.drawStage();
}

