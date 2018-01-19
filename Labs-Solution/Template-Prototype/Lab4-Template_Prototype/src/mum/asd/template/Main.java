package mum.asd.template;

public class Main {
	public static void main(String[] args) {
		TemplateClass t = new ProcessPrint();
		t.printLetter("src/mum/asd/template/A.txt");
		System.out.println();
		System.out.println();
		t.printLetter("src/mum/asd/template/B.txt");
		System.out.println();
        System.out.println();
		t.printLetter("src/mum/asd/template/C.txt");
	}
}
