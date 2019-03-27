package com.curso.java.oo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.curso.java.oo.model.CargoDePolicia;
import com.curso.java.oo.model.Persona;
import com.curso.java.oo.model.Policia;
import com.curso.java.oo.model.PoliciaDeLosDeLasPorras;

public class Ejemplo01HelloWorld {
	// java.com.curso.java.oo.Ejemplo01HelloWorld arg1 arg2 arg3
	public static void main(String[] args) {
		String miCadena = "Hola Mundo";
		System.out.println(miCadena);
		Persona.algoExplicito = "algo";
		Persona persona = new Persona();
		Persona persona2 = new Persona();
		persona.setNombre("Rubencillo");
		// persona.algoExplicito = "Es de rubencillo";
		persona2.setNombre("Otro nombre");
		Persona persona3 = new PoliciaDeLosDeLasPorras();
		PoliciaDeLosDeLasPorras poliPorrero = (PoliciaDeLosDeLasPorras) persona3;
		Policia policia = new Policia();
		policia.setCargo(CargoDePolicia.RASO);
		Set<Policia> setDePolicias = new HashSet<Policia>();
		setDePolicias.add(poliPorrero);
		setDePolicias.add((Policia) persona3);
		Map<String, Persona> mapa = new HashMap<String, Persona>();
		mapa.put("ROJO", policia);
		mapa.put("VERDE", poliPorrero);
		mapa.put("ROJO", poliPorrero);

	}
}
