import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
  public double getPerimeter(Shape s) {
    // Start with totalPerim = 0
    double totalPerim = 0.0;
    // Start wth prevPt = the last point
    Point prevPt = s.getLastPoint();
    // For each point currPt in the shape,
    for (Point currPt : s.getPoints()) {
      // Find distance from prevPt point to currPt
      double currDist = prevPt.distance(currPt);
      // Update totalPerim by currDist
      totalPerim = totalPerim + currDist;
      // Update prevPt to be currPt
      prevPt = currPt;
    }
    // totalPerim is the answer
    return totalPerim;
  }

  public int getNumPoints(Shape s) {
    int numPoints = 0;
    for (Point point : s.getPoints()) {
      numPoints++;
    }
    return numPoints;
  }

  public double getAverageLength(Shape s) {
    double averageLength = getPerimeter(s) / getNumPoints(s);
    return averageLength;
  }

  public double getLargestSide(Shape s) {
    double largestSide = 0;
    Point prevPt = s.getLastPoint();
    for (Point currPt : s.getPoints()) {
      double currDist = prevPt.distance(currPt);
      prevPt = currPt;
      if (currDist > largestSide) {
        largestSide = currDist;
      }
    }
    return largestSide;
  }

  public double getLargestX(Shape s) {
    double largestX = Double.NEGATIVE_INFINITY;
    for (Point p : s.getPoints()) {
      double currX = p.getX();
      if (largestX < currX) {
        largestX = currX;
      }
    }
    return largestX;
  }

  public double getLargestPerimeterMultipleFiles() {
    double largestPerim = Double.NEGATIVE_INFINITY;
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
      FileResource fr = new FileResource(f);
      Shape s = new Shape(fr);
      double currPerim = getPerimeter(s);
      if (largestPerim < currPerim) {
        largestPerim = currPerim;
      }
    }
    return largestPerim;
  }

  public String getFileWithLargestPerimeter() {
    File temp = null;
    double largestPerim = Double.NEGATIVE_INFINITY;
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
      FileResource fr = new FileResource(f);
      Shape s = new Shape(fr);
      double currPerim = getPerimeter(s);
      if (largestPerim < currPerim) {
        largestPerim = currPerim;
        temp = f;
      }
    }
    return temp.getName();
  }

  public void testPerimeter() {
    FileResource fr = new FileResource();
    Shape s = new Shape(fr);
    double length = getPerimeter(s);
    System.out.println("perimeter = " + length);
  }

  public void testPerimeterMultipleFiles() {
    System.out.println(getLargestPerimeterMultipleFiles());
  }

  public void testFileWithLargestPerimeter() {
    System.out.println(getFileWithLargestPerimeter());
  }

  // This method creates a triangle that you can use to test your other methods
  public void triangle() {
    Shape triangle = new Shape();
    triangle.addPoint(new Point(0, 0));
    triangle.addPoint(new Point(6, 0));
    triangle.addPoint(new Point(3, 6));
    for (Point p : triangle.getPoints()) {
      System.out.println(p);
    }
    double peri = getPerimeter(triangle);
    System.out.println("perimeter = " + peri);
  }

  // This method prints names of all files in a chosen folder that you can use to
  // test your other methods
  public void printFileNames() {
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
      System.out.println(f);
    }
  }

  public void testAverageLength() {
    FileResource fr = new FileResource();
    Shape s = new Shape(fr);
    double length = getAverageLength(s);
    System.out.println("average length = " + length);
  }

  public void testLargestSide() {
    FileResource fr = new FileResource();
    Shape s = new Shape(fr);
    double length = getLargestSide(s);
    System.out.println("largest side = " + length);
  }

  public static void main(String[] args) {
    PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    // pr.testPerimeter();
    // pr.testAverageLength();
    // pr.testLargestSide();
    // pr.testPerimeterMultipleFiles();
    pr.testFileWithLargestPerimeter();
  }
}
