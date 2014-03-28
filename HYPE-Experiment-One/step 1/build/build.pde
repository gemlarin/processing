import processing.pdf.*;

HDrawablePool pool;
HColorPool colors;

boolean paused = false;
boolean record = false;
float ranScale = 1;
float strokeweight = 11;

void setup(){
	size(600,600);
	H.init(this).background(#202020);
	smooth();

	colors = new HColorPool(#FFFFFF, #F7F7F7, #ECECEC, #333333, #0095a8, #00616f, #FF3300, #FF6600);

	pool = new HDrawablePool(25);
	pool.autoAddToStage()
		.add(new HShape("circles2.svg"))

		.layout(
			new HGridLayout()
			.startX(75)
			.startY(75)
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
				}
			}
		)
		.requestAll();
}

void draw() {
	H.drawStage();
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
 
