package annotations;

public class AnnotationHandler {

	public static void main(String[] args) {
		Annotations a=new Annotations();
		if (a.getClass().isAnnotationPresent(VeryImportant.class)) {
			for (int i=0;i<a.getClass().getAnnotation(VeryImportant.class).tries();i++) {
				System.out.print(i);
			}
		}

	}

}
