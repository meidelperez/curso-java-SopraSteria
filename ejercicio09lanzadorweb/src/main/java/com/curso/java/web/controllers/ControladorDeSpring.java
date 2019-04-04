package com.curso.java.web.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

import ejercicio01negocio.LogicaAula;

@Controller
@Scope("request")
public class ControladorDeSpring {

	@Autowired
	private LogicaAula negocio;
	@Autowired
	private Estudiante alumno;
	@Autowired
	private Aula aula;
	@Autowired
	private Puesto puesto;
	// mvc/formularioSpringMVC

	@RequestMapping("verFormularioSpringMVC")
	public ModelAndView verFormulario() {
		return new ModelAndView("formularioSpringMVC");

	}

	@RequestMapping("aulasMapeo")
	public ModelAndView mirarAula(@RequestParam("nombreAula") String nombreAula) throws Exception {
		Collection<Aula> aulas = negocio.getAulaDao().getTodasLasAulas();
//		alumno.setName(nombreAlumno);
		if (aulas.toString().contains(nombreAula)) {
			negocio.asignarAlumnoAlAula(alumno, negocio.getAulaDao().getAulaById(nombreAula));
		} else {
			aula.setNombre(nombreAula);
			Collection<Puesto> puestos = new ArrayList();
			puestos.add(puesto);
			puestos.add(puesto);
			puestos.add(puesto);
			negocio.crearNuevaAula(aula);
			negocio.asignarAlumnoAlAula(alumno, aula);
		}

		ModelAndView modelAndView = new ModelAndView("aulas");
		modelAndView.addObject("aula", negocio.getAulaDao().getAulaById(nombreAula));
		modelAndView.addObject("persona", negocio.listaDeAlumnosPorAula(nombreAula));
		return modelAndView;

	}

}
