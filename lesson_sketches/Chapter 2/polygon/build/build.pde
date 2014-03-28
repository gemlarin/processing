void setup() {
  size(600, 600);
  background(0);
  rect(175, 175, 350, 350, false);
  rect(300, 300, 300, 300, true);

}

void rect(float x, float y, float w, float h, boolean isRect) {
    if (isRect){
      rect(x, y, w, h);
    }

    if (!isRect){
      ellipse(x, y, w, h);
    }
}
