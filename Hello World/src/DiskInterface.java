


class Disk{
	public int width=5;
	public Disk() {};
}

class Disk1 extends Disk{
	protected int height=6;
	public Disk1() {};
}
interface DiskAreaVol{
	int area();
	int vol();
}

interface NoDisk {
	int count=0; //public static final int count=0; 과 같은 의미
	int communication();
}

abstract class Disk2 extends Disk1 implements DiskAreaVol{
	public int depth=7;
	public Disk2() {};
	public int area() {
		return width*height;
	}
	public int vol() {
		return area()*depth;
	}
}
class Disk3 extends Disk2 implements NoDisk{
	public int noDisk;
	public Disk3(int noDisk) {
		this.noDisk=noDisk;
	}
	public int communication() {
		return noDisk;
	}
}

public class DiskInterface {
	public static void main(String argv[]) {
		Disk3 d=new Disk3(4);
		System.out.println("area = "+d.area());
		System.out.println("vol = "+d.vol());
		System.out.println("noDisk = "+d.communication());
		System.out.println("count = "+d.count);
	}
}
