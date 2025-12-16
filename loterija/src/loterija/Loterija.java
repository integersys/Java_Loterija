package loterija;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Loterija {
	static Calendar now = Calendar.getInstance();
	static Random rand = new Random();
	static LocalDate currentDate;	
	static LocalTime currentTime;
	static String laiks;
	static long laiksMS;
	static long tagadLaiksMS;
	static Date date = new Date();
	
	public static void main(String[] args) {
		String izvele;
		Stack<Integer> winbumb = new Stack<>();
		Stack<Integer> trauks = new Stack<>();
		//String darbibas, lai nākotnē varētu ieviest 60s waittime
		String[] darbibas = {"Sākt izlozi", "Apskatīt izlozes rezultātus", "Apturēt"};
		
		
		do {
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", 
						JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
				
		if(izvele == null)
			izvele = "Apturēt";
		
		
		// Pagaidām nav ieviesta loģika, ka skaitļi nevar atkārtoties.
		switch (izvele) {
		case "Sākt izlozi":
			if(!winbumb.empty()) {
				 tagadLaiksMS = date.getTime();
			 if(tagadLaiksMS < laiksMS + 60 * 1000) {
				 JOptionPane.showMessageDialog(null, "Jāgaida 1 minūte, līdz atkal vari darīt izlozi!");
				 break;
			 }
			}else
			winbumb.clear();
			for(int i = 0; i<3; i++) {
				for(int j= 0; j<10; j++) {
				trauks.push(rand.nextInt(10)+0);
					Collections.shuffle(trauks);
						}
				winbumb.push(trauks.peek());
			}
			
			
			
			currentDate = LocalDate.now();
			currentTime = LocalTime.now();
			laiksMS = date.getTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
			LocalTime time = LocalTime.now();
			laiks = formatter.format(time);
			
			JOptionPane.showMessageDialog(null, "Tavi laimīgais skaitlis:  "+winbumb+"\nApskaties papildus info izmantojot 2. metodi", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
			break;
			
		case "Apskatīt izlozes rezultātus":
			
			JOptionPane.showMessageDialog(null, "Tavi laimīgais skaitlis:  "+winbumb+
					"\nKad notika izloze: " +currentDate+" "+laiks, "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
			break;
			
		case  "Apturēt":
			JOptionPane.showMessageDialog(null, "Programma apturēta!");
			break;
		}
		}while(!izvele.equals("Apturēt"));
	
	}

}
