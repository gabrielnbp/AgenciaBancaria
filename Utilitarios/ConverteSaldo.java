package Utilitarios;

/*
 * Esta atividade foi realizada com base em uma aula online, no YouTube, com auxílio do canal Zé codes"
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ConverteSaldo {
	
	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(double valor) {
		return formatandoValores.format(valor);
	}
}
