package org.formacion.builder;

public class Main {

	public static void main (String[] args) {
		
		Persona madre = new Persona.Builder("Maria")
                .setMunicipio("Selva")
                .setMayor(37)
                .setLugarTrabajo("Google")
                .build();

		Persona hijo = new Persona.Builder("Pedro")
                .setMenor(4)
                .setColegio("Colegio de Selva")
                .build();
		
		System.out.print("Madre" + madre);
		System.out.print("Hijo" + hijo);
	}
	
}
