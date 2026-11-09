package mx.com.agenda.modelo;

import java.util.Objects;

public class Contacto extends Persona {
 private String telefono;

 public Contacto(String nombre, String apellido, String teléfono) {
  super(nombre, apellido);
  this.telefono = teléfono;
 }

 public String getTelefono() {
  return telefono;
 }

 public void setTelefono(String telefono) {
  this.telefono = telefono;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj) return true;
  if (obj == null || getClass() != obj.getClass()) return false;
  Contacto otro = (Contacto) obj;
  return this.nombre.equalsIgnoreCase(otro.nombre) &&
          this.apellido.equalsIgnoreCase(otro.apellido);
 }

 @Override
 public int hashCode() {
  return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
 }

 @Override
 public String toString() {
  return nombre + " " + apellido + " - " + telefono;
 }
}
