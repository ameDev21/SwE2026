package Poly;

public class Main {
  public static void main(String[] args) {
    Polygon poly = new Polygon(System.in);
    // printing the perimeter
    // System.out.println(poly.toString());
    // poly.sortVertices();
    // System.out.println(poly.toString());
    System.out.println("the perimeter of the given polygon " + poly.perimeter());
  }
}
