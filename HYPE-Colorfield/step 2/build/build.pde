HRect d;
HColorField colors;

void setup(){
	size(600,600);
	H.init(this).background(#202020);
	smooth();

	colors = new HColorField(width, height)
		.addPoint( 0, height/2, #FF3300, 0.3 )
		.addPoint( width, height/2, #0095A8, 0.3 )
		.fillOnly()
	;

	for (int i = 0; i<100; i++){
		d = new HRect();
		d
			.noStroke()
			.fill(#000000)
			.size( (int)random(25,125) )
			.rotate( (int)random(360) )
			.loc( (int)random(width), (int)random(height) )
			.anchorAt(H.CENTER)
		;
		colors.applyColor(d);
		H.add(d);
	}

	H.drawStage();
}
