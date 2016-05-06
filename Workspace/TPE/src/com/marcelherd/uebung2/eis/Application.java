package com.marcelherd.uebung2.eis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.marcelherd.uebung2.eis.vendor.BerlinerEisdiele;
import com.marcelherd.uebung2.eis.vendor.Eisdiele;
import com.marcelherd.uebung2.eis.vendor.KoelnerEisdiele;
import com.marcelherd.uebung2.eis.vendor.MannheimerEisdiele;

/**
 * Application entry-point.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Application {
	
	public static void main(String[] args) {
		Eisdiele mannheimerEisDiele = new MannheimerEisdiele();
		Eisdiele koelnerEisDiele = new KoelnerEisdiele();
		Eisdiele berlinerEisDiele = new BerlinerEisdiele();
		
		List<String> alleGerichte = new ArrayList<String>();
		alleGerichte.addAll(Arrays.asList(mannheimerEisDiele.getEiskarte()));
		alleGerichte.addAll(Arrays.asList(koelnerEisDiele.getEiskarte()));
		alleGerichte.addAll(Arrays.asList(berlinerEisDiele.getEiskarte()));
		
		for (String typ : alleGerichte) {
			System.out.println("Wir probieren nun das Gericht: " + typ);
			System.out.println("\nZuerst probieren wir das Gericht in Mannheim:\n");
			mannheimerEisDiele.bestellen(typ);
			System.out.println("\nNun probieren wir das Gericht in Köln:\n");
			koelnerEisDiele.bestellen(typ);
			System.out.println("\nUnd zuletzt probieren wir das Gericht in Berlin:\n");
			berlinerEisDiele.bestellen(typ);
			System.out.println("\n\n");
		}
	}

}
