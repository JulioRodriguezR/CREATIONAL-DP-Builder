package org.formacion.builder;

public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	// No se puede instanciar objetos Persona sin pasar por Build
	private Persona() {}
	
	/*
	 * Builder genérico,
	 * iniciar la construcción de una Persona
	 * 
	 * */
	public static class Builder {
		
		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		
		
		/*
		 * Para guardar las propiedades comúnes
		 * 
		 * */
		
		public BuilderMayor setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;
			return new Persona.BuilderMayor(persona); // a datos específicos;
		}
		
		public BuilderMenor setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
			return new Persona.BuilderMenor(persona);
		}
	}
	
	
	public static class BuilderMayor {
	
		private Persona persona;
		
		// Al igual que el tipo Persona, 
		// el poder ingresar en un Builder mayor/menor ha de requirir el proceso de construcción estandar
		private BuilderMayor(Persona persona) {
			this.persona = persona;
		}
		
		public BuilderMayor setLugarTrabajo(String lugartrabajo) {
			persona.lugarTrabajo = lugartrabajo;
			return this;
		}
		
		public Persona build() {
			return persona;
		}
	}
	
	public static class BuilderMenor {
		
		private Persona persona;
		
		private BuilderMenor(Persona persona) {
			this.persona = persona;
		}
		
		public BuilderMenor setColegio(String trabajo) {
			persona.lugarTrabajo = trabajo;
			return this;
		}
		
		public Persona build() {
			return persona;
		}
	}
	
}
