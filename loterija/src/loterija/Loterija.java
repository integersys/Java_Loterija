package loterija;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Loterija {
	static Random rand = new Random();
	public static void main(String[] args) {
		String izvele;
		Stack<Integer> winbumb = new Stack<>();
		Stack<Integer> trauks = new Stack<>();
		//String darbibas, lai nākotnē varētu ieviest 60s waittime
		String[] darbibas = {"Sākt izlozi", "Apturēt"};
		
		
		do {
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", 
						JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
				
		if(izvele == null)
			izvele = "Apturēt";
		
		switch (izvele) {
		case "Sākt izlozi":
			winbumb.clear();
			for(int i = 0; i<3; i++) {
				for(int j= 0; j<10; j++) {
				trauks.push(rand.nextInt(10)+0);
					Collections.shuffle(trauks);
						}
				winbumb.push(trauks.peek());
			}
		
			JOptionPane.showMessageDialog(null, "Tavi laimīgais skaitlis:  "+winbumb, "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
			break;
			
		case  "Apturēt":
			JOptionPane.showMessageDialog(null, "Programma apturēta!");
			break;
		}
		}while(!izvele.equals("Apturēt"));
	
	}

}
