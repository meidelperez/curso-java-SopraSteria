package ejemplo05beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lanzadorSpring {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
		MorcillaDeLeon morcilla = (MorcillaDeLeon)applicationContext.getBean("morcillaDeLeon");
		System.out.println(morcilla);
		morcilla.setColor("Esta que te mueres!!");
		morcilla.setSabor("Esta es de Villada");
		System.out.println(applicationContext.getBean("morcillaDeLeon"));
	}

}
