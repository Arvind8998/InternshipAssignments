class LineInterSection
{
static class Point
{
    int x;
    int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
};
 
/* 3 collinear points x1, x2, x3, the function checks if
 point x2 lies on line segment 'pr' */

static boolean checkOnSegment(Point x1, Point x2, Point x3)
{
    if (x2.x <= Math.max(x1.x, x3.x) && x2.x >= Math.min(x1.x, x3.x) &&
        x2.y <= Math.max(x1.y, x3.y) && x2.y >= Math.min(x1.y, x3.y))
    return true;
 
    return false;
}
 
/* To find orientationBuilder of ordered triplet (x1, x2, x3).
 The function returns following values
 0 --> x1, x2 and x3 are collinear
 1 --> Clockwise
 2 --> Counterclockwise 
 */
static int orientationBuilder(Point x1, Point x2, Point x3)
{
    int val = (x2.y - x1.y) * (x3.x - x2.x) -
            (x2.x - x1.x) * (x3.y - x2.y);
 
    if (val == 0) return 0; // collinear
 
    return (val > 0)? 1: 2; // clockwise or counterclock-wise
}
 
/* returns true if line segment 'p1q1'
 and 'p2q2' intersect. */
static boolean checkIntersection(Point p1, Point q1, Point p2, Point q2)
{
    int or1 = orientationBuilder(p1, q1, p2);
    int or2 = orientationBuilder(p1, q1, q2);
    int or3 = orientationBuilder(p2, q2, p1);
    int or4 = orientationBuilder(p2, q2, q1);
 
    if (or1 != or2 && or3 != or4)
        return true;
 
    // p1, q1 and p2 are collinear and p2 lies on segment p1q1
    if (or1 == 0 && checkOnSegment(p1, p2, q1)) return true;
 
    // p1, q1 and q2 are collinear and q2 lies on segment p1q1
    if (or2 == 0 && checkOnSegment(p1, q2, q1)) return true;
 
    // p2, q2 and p1 are collinear and p1 lies on segment p2q2
    if (or3 == 0 && checkOnSegment(p2, p1, q2)) return true;
 
    // p2, q2 and q1 are collinear and q1 lies on segment p2q2
    if (or4 == 0 && checkOnSegment(p2, q1, q2)) return true;
 
    return false; 
}
 
public static void main(String[] args)
{
    Point p1 = new Point(1, 1);
    Point q1 = new Point(10, 1);
    Point p2 = new Point(1, 2);
    Point q2 = new Point(10, 2);
 
    if(checkIntersection(p1, q1, p2, q2))
        System.out.println("Yes");
    else
        System.out.println("No");
 
    p1 = new Point(10, 1); q1 = new Point(0, 10);
    p2 = new Point(0, 0); q2 = new Point(10, 10);
    if(checkIntersection(p1, q1, p2, q2))
            System.out.println("Yes");
    else
        System.out.println("No");
 
    p1 = new Point(-5, -5); q1 = new Point(0, 0);
    p2 = new Point(1, 1); q2 = new Point(10, 10);;
    if(checkIntersection(p1, q1, p2, q2))
        System.out.println("Yes");
    else
        System.out.println("No");
}
}