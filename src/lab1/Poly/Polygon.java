package Poly;

import java.io.InputStream;
import java.util.Scanner;

public class Polygon {
  private Point vertices[];
  // final since once assigned the number of vertices cannot be changed
  private final int NUMBER_OF_VERTICES;

  public Polygon(Point[] vertices) {
    // assigning the final attribute
    this.NUMBER_OF_VERTICES = vertices.length;
    this.vertices = vertices;
  }

  public Polygon(InputStream input) {
    // assigning the final attribute
    System.out.print("the number of vertices of the polygon are: ");
    // creating the scanner for stdin
    Scanner scanner = new Scanner(input);

    this.NUMBER_OF_VERTICES = scanner.nextInt();
    // inizializing the vertices
    this.vertices = new Point[NUMBER_OF_VERTICES];
    for (int i = 0; i < this.NUMBER_OF_VERTICES; i++) {
      System.out.print("\n x_" + i + " = ");
      float x = scanner.nextFloat();
      System.out.print("\n y_" + i + " = ");
      float y = scanner.nextFloat();
      this.vertices[i] = new Point(x, y);
    }
    // closing the scanner when finished reading the vertices
    scanner.close();
    this.sortVertices();
  }

  @Override
  public String toString() {
    String res = "[";
    for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
      res += "(" + vertices[i].getX() + "," + vertices[i].getY() + ")" + ",";
    }
    // TODO: this should be fixed: does not remove the last ','
    // res.substring(0, res.length() - 2);
    res += "]";
    return res;
  }

  public double perimeter() {
    double perimeter = 0;
    for (int i = 0; i < this.NUMBER_OF_VERTICES; i++) {
      perimeter += Point.distance(this.vertices[i], this.vertices[(i + 1) % this.NUMBER_OF_VERTICES]);
    }
    return perimeter;
  }

  // method that sorts vertices using the distance as confrontation method
  public void sortVertices() {
    double min_dist = -1;
    for (int i = 0; i < vertices.length; i++) {
      min_dist = -1;
      for (int j = i + 1; j < vertices.length; j++) {
        double dist = this.vertices[i].distance(this.vertices[j]);
        if (min_dist == -1) {
          min_dist = dist;
        } else if (min_dist > dist) {
          min_dist = dist;
          this.swapVertices(i + 1, j);
        }
      }
    }
  }

  private void swapVertices(int i, int j) {
    if (this.vertices.length < j - 1 || this.vertices.length < i - 1) {
      // should trow an exeption here
      return;
    }
    Point temp = this.vertices[i];
    this.vertices[i] = this.vertices[j];
    this.vertices[j] = temp;
    return;
  }

}
