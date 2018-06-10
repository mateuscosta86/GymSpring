package br.com.mateuscosta.helpers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Helpers {
	public static boolean ChecaVarivavelSessao(HttpServletRequest request, String var) {
		
		Enumeration<String> listaValores = request.getSession().getAttributeNames();		
		List<String> valores = new ArrayList<String>();
		while (listaValores.hasMoreElements()) {
			valores.add(listaValores.nextElement());
		}
		
		if(valores.contains(var)) {
			return true;
		}
		else {
			return false;
		}				
	}
}
