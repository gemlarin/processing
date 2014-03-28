import processing.pdf.*;

HDrawablePool pool;
HDrawablePool pool2;
HDrawablePool pool3;
HColorPool colors;

boolean paused = false;
boolean record = false;
float ranScale = 1;
float strokeweight = 8;
float aDirection;

void setup(){
	size(600,600);
	H.init(this).background(#202020);
	smooth();

	colors = new HColorPool(#FFFFFF, #F7F7F7, #ECECEC, #333333, #0095a8, #00616f, #FF3300, #FF6600);

	pool = new HDrawablePool(25);
	pool.autoAddToStage()
		.add(new HShape("circles3.svg"), 4)
		.add(new HShape("circles4.svg"), 4)
		.add(new HShape("circles5.svg"), 4)
		.add(new HShape("circles6.svg"), 4)
		.add(new HShape("circles7.svg"))

		.layout(
			new HGridLayout()
			.startX(83)
			.startY(83)
			.spacing(100+strokeweight,100+strokeweight)
			.cols(5)
		)

		.onCreate(
			new HCallback() {
				public void run(Object obj) {
					//float ranScale = 1 + ( (int)random(16)*0.3 );
					HShape d = (HShape) obj;
					d
						.enableStyle(false)
						.anchorAt(H.CENTER)
						//.loc( width/2, height/2 )
						.scale( ranScale )
						.noFill()
						.strokeWeight(strokeweight)
						.strokeJoin(SQUARE)
						.strokeCap(SQUARE)
					;
					d.randomColors(colors.strokeOnly());
					float ranDirection = getDirection();
					new HRotate(d, 3*ranDirection );
					new HOscillator()
					.target(d)
					.property(H.SCALE)
					.range(.5, 1.5)
					.speed(1)
					.freq(2)
					.currentStep( pool.currentIndex())
					;
				}
			}
		)
		.requestAll();

	pool2 = new HDrawablePool(25);
	pool2.autoAddToStage()

		.add(new HShape("circles3.svg"), 4)
		.add(new HShape("circles4.svg"), 2)
		.add(new HShape("circles5.svg"), 2)
		.add(new HShape("circles6.svg"), 2)

		.layout(
			new HGridLayout()
			.startX(83)
			.startY(83)
			.spacing(100+strokeweight,100+strokeweight)
			.cols(5)
		)

		.onCreate(
			new HCallback() {
				public void run(Object obj) {
					//float ranScale = 1 + ( (int)random(16)*0.3 );
					HShape d = (HShape) obj;
					d
						.enableStyle(false)
						.anchorAt(H.CENTER)
						//.loc( width/2, height/2 )
						.scale( ranScale*.66 )
						.noFill()
						.strokeWeight(strokeweight * 1.5)
						.strokeJoin(SQUARE)
						.strokeCap(SQUARE)
					;
					d.randomColors(colors.strokeOnly());
					float ranDirection = getDirection();
					new HRotate(d, 3*ranDirection );
						new HOscillator()
					.target(d)
					.property(H.SCALE)
					.range(.5, 1.5)
					.speed(1)
					.freq(2)
					.currentStep( pool.currentIndex()*2)
					;
				}
			}
		)
		.requestAll();

		pool3 = new HDrawablePool(25);
		pool3.autoAddToStage()
		.add(new HShape("circles3.svg"), 2)
		.add(new HShape("circles4.svg"), 2)
		.add(new HShape("circles5.svg"), 3)
		.add(new HShape("circles6.svg"), 2)
		.add(new HShape("circles7.svg"), 4)

		.layout(
			new HGridLayout()
			.startX(83)
			.startY(83)
			.spacing(100+strokeweight,100+strokeweight)
			.cols(5)
		)

		.onCreate(
			new HCallback() {
				public void run(Object obj) {
					//float ranScale = 1 + ( (int)random(16)*0.3 );
					HShape d = (HShape) obj;
					d
						.enableStyle(false)
						.anchorAt(H.CENTER)
						//.loc( width/2, height/2 )
						.scale( ranScale * .33)
						.noFill()
						.strokeWeight(strokeweight * 3)
						.strokeJoin(SQUARE)
						.strokeCap(SQUARE)
					;
					d.randomColors(colors.strokeOnly());
					// rotation	
					float ranDirection = getDirection();
					new HRotate(d, 3*ranDirection );
						new HOscillator()
					.target(d)
					.property(H.SCALE)
					.range(.5, 1.5)
					.speed(1)
					.freq(2)
					.currentStep( pool.currentIndex()*3)
					;
				}
			}
		)
		.requestAll();
}

void draw() {
	H.drawStage();
}

float getDirection(){
	aDirection = round(random(-1, 1));
	println("ranDirection: "+aDirection);
	if (aDirection == 0) getDirection();
	return aDirection;
}

// pause, restart, advance 1 / with key presses

// spacebar = pause and restart animation
// +        = redraw() advances 1 iteration in the animation
// r        = render to PDF

void keyPressed() {
	if (key == ' ') {
		if (paused) {
			loop();
			paused = false;
		} else {
			noLoop();
			paused = true;
		}
	}

	if (key == '+') {
		redraw();
	}

	if (key == 'r') {
		record = true;
		saveVector();
	}
}

void saveVector() {
	PGraphics tmp = null;
	tmp = beginRecord(PDF, "render_#####.pdf");

	if (tmp == null) {
		H.drawStage();
	} else {
		H.stage().paintAll(tmp, false, 1); // PGraphics, uses3D, alpha
	}

	endRecord();
}
 
