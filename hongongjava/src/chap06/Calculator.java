package chap06;

public class Calculator {
	//메소드 오버로딩 p287
	double areaRectangle(double width) {
		return width * width;
	}
	
	double areaRectangle(double width, double height) {
		return width * height;
	}
}
