import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // País
        Pais argentina = new Pais("Argentina");

        // Provincias
        Provincia bsas = new Provincia("Buenos Aires", argentina);
        Provincia cordoba = new Provincia("Córdoba", argentina);

        // Localidades y domicilios
        Localidad caba = new Localidad("CABA", bsas);
        Domicilio domCaba = new Domicilio("Av. Corrientes 1234", caba);

        Localidad laPlata = new Localidad("La Plata", bsas);
        Domicilio domLaPlata = new Domicilio("Calle 7 Nº 500", laPlata);

        Localidad cordobaCapital = new Localidad("Córdoba Capital", cordoba);
        Domicilio domCordobaCap = new Domicilio("San Martín 100", cordobaCapital);

        Localidad villaCarlosPaz = new Localidad("Villa Carlos Paz", cordoba);
        Domicilio domCarlosPaz = new Domicilio("Av. Libertad 55", villaCarlosPaz);

        // Sucursales
        Sucursal suc1 = new Sucursal("Sucursal 1", domCaba);
        Sucursal suc2 = new Sucursal("Sucursal 2", domLaPlata);
        Sucursal suc3 = new Sucursal("Sucursal 3", domCordobaCap);
        Sucursal suc4 = new Sucursal("Sucursal 4", domCarlosPaz);

        // Empresas
        Set<Empresa> empresas = new HashSet<>();

        Empresa emp1 = new Empresa(1, "Empresa1", "20-12345678-9");
        emp1.addSucursal(suc1);
        emp1.addSucursal(suc2);

        Empresa emp2 = new Empresa(2, "Empresa2", "30-87654321-0");
        emp2.addSucursal(suc3);
        emp2.addSucursal(suc4);

        empresas.add(emp1);
        empresas.add(emp2);

        // === MENÚ INTERACTIVO ===
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE EMPRESAS ===");
            System.out.println("1. Listar todas las empresas");
            System.out.println("2. Buscar empresa por ID");
            System.out.println("3. Buscar empresa por nombre");
            System.out.println("4. Actualizar CUIL de una empresa");
            System.out.println("5. Eliminar empresa por ID");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- LISTA DE EMPRESAS ---");
                    empresas.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Ingrese ID a buscar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    empresas.stream()
                            .filter(e -> e.getId() == id)
                            .findFirst()
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("No se encontró la empresa con ID " + id)
                            );
                }
                case 3 -> {
                    System.out.print("Ingrese nombre a buscar: ");
                    String nombre = sc.nextLine();
                    empresas.stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                            .findFirst()
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("No se encontró la empresa con nombre " + nombre)
                            );
                }
                case 4 -> {
                    System.out.print("Ingrese ID de la empresa a actualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    empresas.stream()
                            .filter(e -> e.getId() == id)
                            .findFirst()
                            .ifPresentOrElse(e -> {
                                System.out.print("Nuevo CUIL: ");
                                String nuevoCuil = sc.nextLine();
                                e.setCuil(nuevoCuil);
                                System.out.println("CUIL actualizado: " + e);
                            }, () -> System.out.println("Empresa no encontrada"));
                }
                case 5 -> {
                    System.out.print("Ingrese ID de la empresa a eliminar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    boolean eliminado = empresas.removeIf(e -> e.getId() == id);
                    if (eliminado) {
                        System.out.println("Empresa eliminada con éxito.");
                    } else {
                        System.out.println("No se encontró la empresa con ID " + id);
                    }
                }
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
