package Fraction;

public class Fraction {
  private int num;
  private int den;

  public Fraction(int num, int den) {
    this.num = num;
    this.den = den;
  }

  public Fraction(int x) {
    // this.num = x;
    // this.den = 1;
    this(x, 1);
  }

  public Fraction() {
    this(0, 1);
  }

  public int getNum() {
    return num;
  }

  public int getDen() {
    return den;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public void setDen(int den) {
    this.den = den;
  }
}
