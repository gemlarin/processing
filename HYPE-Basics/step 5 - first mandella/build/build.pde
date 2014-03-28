HShape d;
HColorPool colors;

void setup() {
	size(600, 600);
	H.init(this).background(#ffffff);
	smooth();

	colors = new HColorPool(#FFFFFF, #F7F7F7, #ECECEC, #333333, #0095a8, #FF3300, #FF6600).fillOnly();

	for (int i = 0; i<15; i++){
		d = new HShape("mongol-a.svg");
		d
			.enableStyle(false)
			.stroke(#111111)
			.strokeJoin(ROUND)
			.strokeCap(ROUND)
			.fill( (int)random(255) )
			.rotation( (int)random(360) )

			.loc( (int)random(width), (int)random(height))
			.anchorAt(H.CENTER)
		;
		d.randomColors(colors.fillOnly() );
		H.add(d);	

	}

	H.drawStage();
}

