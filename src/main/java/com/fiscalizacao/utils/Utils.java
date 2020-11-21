package com.fiscalizacao.utils;

import java.text.Normalizer;
import java.util.InputMismatchException;

public class Utils {
		
	public static String stringNormalize(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	//Validador de CPF retorna true/false
	public static boolean isCPF(String CPF) {
		String cpfReplace = CPF.replaceAll("[.-]", "");
		if (cpfReplace.equals("00000000000") 
				|| cpfReplace.equals("11111111111") || cpfReplace.equals("22222222222")
				|| cpfReplace.equals("33333333333") || cpfReplace.equals("44444444444")
				|| cpfReplace.equals("55555555555") || cpfReplace.equals("66666666666")
				|| cpfReplace.equals("77777777777") || cpfReplace.equals("88888888888")
				|| cpfReplace.equals("99999999999") || (cpfReplace.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpfReplace.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpfReplace.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpfReplace.charAt(9)) && (dig11 == cpfReplace.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
}
