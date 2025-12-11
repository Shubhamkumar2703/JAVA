package circle1;
class circle{
    public double radius;
    public double aera(){
        return Math.PI*radius*radius;
    }
    public double circumference(){
        return 2*Math.PI*radius;
    }
    public double perimeter(){
        return circumference();
    }
}


public class circle1{
    public static void main(String[] args){
        circle c1 = new circle();
       // circle c2 = new circle();
        c1.radius = 7;
        //c2.radius = 9;
        System.out.println("Aera : " + c1.aera());
        System.out.println("circumference : " + c1.circumference());
        System.out.println("perimeter : " + c1.perimeter());

        /*System.out.println("Aera2 : " + c2.aera());
        System.out.println("circumference2 : " + c2.circumference());
        System.out.println("perimeter2 : " + c2.perimeter()); */ 
    }

    
}