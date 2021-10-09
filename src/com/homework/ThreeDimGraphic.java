package com.homework;
//计算立体图形表面积和体积的立体图形类
public class ThreeDimGraphic {
    double superficial_area;
    double volume;
    public double getSuperficial_area(){return -1;}
    public double getVolume(){return  -1;}

}
class TestThreeDimGraph{
    public static void main(String[] args) {
        ThreeDimGraphic threeDimGraphic = new ThreeDimGraphic();

        Cylinder cylinder = new Cylinder(1, 1);
        Cuboid cuboid = new Cuboid(1, 1, 1);
        //多态特性
        threeDimGraphic = cylinder;
        System.out.println("圆柱体表面积：" + threeDimGraphic.getSuperficial_area());
        System.out.println("圆柱体体积：" + threeDimGraphic.getVolume());
        threeDimGraphic = cuboid;
        System.out.println("长方体表面积：" + threeDimGraphic.getSuperficial_area());
        System.out.println("长方体体积：" + threeDimGraphic.getVolume());
    }
}
class Cylinder extends ThreeDimGraphic{
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    public Cylinder(){}//构造方法重载
    public double getSuperficial_area(){
        superficial_area =Math.PI * Math.pow(radius,2)*2 + 2*Math.PI*radius*height;
        return superficial_area;
    }
    public double getVolume(){
        volume =Math.PI * Math.pow(radius,2) * height;
        return volume;
    }
}
class Cuboid extends ThreeDimGraphic{
    private double length;
    private double width;
    private double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public Cuboid(){}//构造方法重载

    public double getSuperficial_area(){
    superficial_area = 2*(length * width+
                        length * height+
                        width * height);
        return superficial_area;
    }
    public double getVolume(){
        volume =length * width * height;
        return volume;
    }

}