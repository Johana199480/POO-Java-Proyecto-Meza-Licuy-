/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.*;
public class BuggyActividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // LISTA de nombres
        List<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Acceder a índice válido 
        System.out.println("Elemento en posición 2: " + nombres.get(2));

        // Comparar correctamente Strings 
        String buscado = new String("Ana");

        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();

        telefonos.putIfAbsent("Ana", "0991111111");// no sobrescribe
        telefonos.put("Luis", "0992222222");
        

        // Validación antes de acceder a clave inexistente 
        String telefonoBea = telefonos.get("Bea");
        if (telefonoBea != null) {
            System.out.println("Bea: " + telefonoBea);
        } else {
            System.out.println("Bea no tiene teléfono registrado");
        }
        // SET de inscritos (debería no permitir duplicados lógicos)
        Set<Alumno> inscritos = new HashSet<>();

        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado detectado correctamente

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

class Alumno {
    int id;
    String nombre;

   Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return id == alumno.id && nombre.equals(alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}

    