package Poly;

import java.math.*;

public class Point {
  private float x;
  private float y;

  public Point(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this.x = 0;
    this.y = 0;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public double distance(Point p) {
    return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
  }

  public static double distance(Point P, Point Q) {
    return Math.sqrt(Math.pow(P.getX() - Q.getX(), 2) + Math.pow(P.getY() - Q.getY(), 2));
  }
}
