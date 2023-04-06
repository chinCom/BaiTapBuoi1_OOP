
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int ans = new App().fib();
		System.out.println(ans);
	}

	// get input from user
	private String getScanner() {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		return str;

	}

	// bt 1
	public String isLeapYear() {
		/*
		 * (Năm nhuận: chia hết cho 4 và không chia hết cho 100; hoặc chia hết cho 400)
		 */

		boolean check = false;
		int ans;
		try {
			System.out.println("Nhap so nam: ");
			ans = Integer.parseInt(getScanner());
		} catch (InputMismatchException e) {
			return "Invalid value";
		}
		if ((ans % 4 == 0) && (ans % 100 != 0) || ans % 400 == 0 && ans > 0) {
			check = true;
		}
		return check ? ans + " is a leap year" : ans + " is not a leap year";
	}

	// bt 2
	public int computeOperation() {
		int a = 0, b = 0;
		char kt = 'o';
		try {
			System.out.println("Nhap gia tri a: ");
			a = Integer.parseInt(getScanner());

			System.out.println("Nhap gia tri b: ");
			b = Integer.parseInt(getScanner());

			System.out.println("Nhap phep tinh can thuc hien voi hai so a va b: <+ - * />");
			kt = getScanner().trim().charAt(0);

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

		int ans = 0;
		switch (kt) {
		case '+': {
			ans = a + b;
			break;
		}
		case '-': {
			ans = a - b;
			break;
		}
		case '*': {
			ans = a * b;
			break;
		}
		case '/': {
			if (b == 0) {
				System.out.println("cannot divide by zero");
				break;
			}
			ans = a / b;
			break;
		}
		default: {
			System.out.println("Try valid value");
			break;
		}
		}
		return ans;
	}

	// bt 3
	public long computeSum() {
		int n = 0;
		try {
			n = Integer.parseInt(getScanner());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("invalid value, try again...");
		}
		// S = 1 + 1/2 + 1/3 + … + 1/n

		long sum = 1;
		for (int i = 2; i <= n; i++) {
			sum += (1 / i);
		}
		return sum;
	}

	// bt 4
	// Viết chương trình tính tổng S = 1 /1! + 2 /2! + ….+ n / n!
	public long computeFac(int n) {
		if (n == 0)
			return 1;
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}

	public long computeSumFac() {
		int n = 0;

		try {
			n = Integer.parseInt(getScanner());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("invalid value, try again...");
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (i / computeFac(i));
		}
		return sum;
	}

	// bt 5
	// Viết chương trình giải phương trình bậc nhất
	public int equationCompute1() {
		// ax + b = 0
		int a = 0, b = 0;
		char kt = 'o';
		int ans = 0;
		try {

			System.out.println("Nhap gia tri cua a: ");
			a = Integer.parseInt(getScanner());

			System.out.println("Nhap gia tri cua b: ");
			b = Integer.parseInt(getScanner());

			System.out.println("Nhap phep tinh can thuc hien: +, -");
			kt = getScanner().trim().charAt(0);

			if (a == 0 && b == 0) {
				System.out.println("Phuong trinh co vo so nghiem");
				return 0;
			}
			if (a == 0 && b != 0) {
				System.out.println("Phuong trinh vo nghiem");
				return 0;
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("invalid value, try again...");
		}
		ans = 0;
		switch (kt) {
		case '+': {
			ans = -b / a;
			break;
		}
		case '-': {
			ans = b / a;
			break;
		}

		default: {
			System.out.println("Try valid value");
			break;
		}
		}
		return ans;
	}

	// bt 6
	/*
	 * Viết chương trình giải phương trình bậc hai. Trường hợp a=0 sẽ gọi phương
	 * thức giải phương trình bậc nhất.
	 */
	public float equationCompute2() {
		// ax + b = 0
		float a = 0, b = 0, c = 0;
		float ans = 0;
		float ans1 = 0;
		float delta = 0;
		try {

			System.out.println("Nhap gia tri cua a: ");
			a = Float.parseFloat(getScanner());

			System.out.println("Nhap gia tri cua b: ");
			b = Float.parseFloat(getScanner());

			System.out.println("Nhap gia tri cua c: ");
			c = Float.parseFloat(getScanner());

			if (a == 0) {
				return equationCompute1();
			}

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("invalid value, try again...");
		}

		// compute delta
		if (delta < 0) {
			System.out.println("Phuong trinh vo nghiem");
			return 0;
		} else if (delta == 0) {
			ans = (-b / 2 * a);
			return ans;
		} else {
			// delta > 0
			ans = (-b + (float) Math.sqrt(delta) / (2 * a));
			ans1 = (-b - (float) Math.sqrt(delta) / (2 * a));
			System.out.println("Phuong trinh co hai nghiem phan biet la " + ans + " va " + ans1);
		}

		return ans;
	}

	// bt 7
	// tổng các số lẻ từ 1 đến n
	public int sumOdd() {
		int n = Integer.parseInt(getScanner());
		int sum = 1;
		for (int i = 1; i <= n; i += 2) {
			sum += i;
		}
		return sum;
	}

	// bt 8
	// kiem tra co phai la so nguyen to hay khong
	public boolean isPrime() {
		int n = Integer.parseInt(getScanner());
		if (n < 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}

	/*
	 * Viết chương trình cho phép nhập vào 3 số thực. Chương trình này sẽ kiểm tra 3
	 * số này có phải là 3 cạnh của một tam giác hay không.
	 */

	public String isTriangle() {
		// default value
		float a = 0, b = 0, c = 0;
		try {

			System.out.println("Nhap gia tri cua canh tam giac a: ");
			a = Float.parseFloat(getScanner());

			System.out.println("Nhap gia tri cua canh tam giac b: ");
			b = Float.parseFloat(getScanner());

			System.out.println("Nhap gia tri cua canh tam giac c: ");
			c = Float.parseFloat(getScanner());

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("invalid value, try again...");
		}

		// tam giac: vuong, can, deu, tu, nhon
		if (a + b > c || a + c > b || b + c > a) {
			// tam giac vuong a*a==b*b+c*c hoặc b*b==a*a+c*c hoặc c*c== a*a+b*b
			if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b) {
				// tam giác tù là tam giác có một góc lớn hơn 90 độ. Từ điều kiện kiểm tra tam
				// giác vuông, ta suy ra điều kiện để là tam giác tù là: a*a>b*b+c*c hoặc
				// b*b>a*a+c*c hoặc c*c >a*a+b*b
				if (a * a > b * b + c * c || b * b > a * a + c * c || c * c > a * a + b * b) {
					return "La tam giac tu";
				}
				return "La tam giac vuong";
			}

			// tam giác đều là tam giác có ba cạnh bằng nhau. Ta kiểm tra điều kiện a==b và
			// b==c
			else if (a == b && b == c) {
				return "La tam giac deu";
			}
			// tam giác cân là tam giác có hai cạnh bằng nhau. Ta kiểm tra điều kiện: a==b
			// hoặc a==c hoặc b==c

			else if (a == b || a == c || b == c) {
				return "La tam giac can";
			}

			else {
				return "La tam giac nhon";
			}
		} else {
			return "gia tri nhap vao khong hop le, vui long thu lai...";
		}
	}

	// bt 10
	/*
	 * 10. Dãy số Fibonacci được định nghĩa như sau: F0 =1, F1 = 1; Fn = Fn-1 + Fn-2
	 * với n&gt;=2. Hãy viết chương trình tìm số Fibonacci thứ n.
	 */

	public int fib() {
		System.out.println("nhap so thu tu Fibonacci can tim: ");
		int n = Integer.parseInt(getScanner());
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		int a = 0;
		int b = 1;
		int c = 1;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

}

