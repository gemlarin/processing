HPath d;

void setup(){
	size(600,600);
	H.init(this).background(#202020);
	smooth();

	for (int i = 0; i<100; i++){
		d = new HPath();
		d
			.triangle( H.ISOCELES, H.TOP )
			.strokeWeight(1)
			.stroke(#FF3300)
			.fill(#111111)
			.size( (int)random(50,150), (int)random(75,175) )
			.loc( (int)random(width), (int)random(height) )
			.anchorAt(H.CENTER)
		;
		H.add(d);
	}

	H.drawStage();
}
