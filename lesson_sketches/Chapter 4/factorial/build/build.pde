void setup() {
  println(getFactorial(20));
}

int getFactorial(int val){
    int fact = 1;
    while (val > 0){
      fact*=val;
      val--;
    }
    return fact;
  }
