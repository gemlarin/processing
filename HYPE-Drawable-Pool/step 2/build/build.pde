HDrawablePool pool;

void setup() {
  size(600, 600);
  H.init(this).background(#202020);
  smooth();

  pool = new HDrawablePool(100);
  pool.autoAddToStage()
    .add(new HRect())//object to create, in this case an HRect
    .onCreate( //each object created will have these properties and values
      new HCallback(){
        public void run(Object obj){
          HDrawable d = (HDrawable) obj; //Cast Object as an HDrawabe and then set to the var d
          d
            .strokeWeight(1)
            .stroke(#FF3300)
            .fill(#111111)
            .size((int)random(25,125))
            .rotate( (int)random(360) )
            .loc((int)random(width), (int)random(height))
            .anchorAt(H.CENTER)
            ;
        }
      }
    )
    .requestAll() //give me all of them at the same time

  ;

  H.drawStage();
}