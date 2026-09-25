import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args)

    {
        // Menú interactivo
        MarketPlus supermercado = new MarketPlus("MarketPlus Central", "Calle 10 #15-20", "3001234567");

        // CREAR PRODUCTO
        Producto producto1 = new Producto("PT32", "frijoles", TipoProducto.ALIMENTOS, 5000, 15);
        Producto producto2 = new Producto("PS67", "gaseosa", TipoProducto.BEBIDAS, 6500, 35);
        Producto producto3 = new Producto("PN45", "limpido",  TipoProducto.PRODUCTOSASEO, 5500, 12);
        Producto producto4 = new Producto("PS24", "shampoo", TipoProducto.CUIDADOPERSONAL, 13000, 20);
        // AGREGAR
        supermercado.agregarProducto(producto1);
        supermercado.agregarProducto(producto2);
        supermercado.agregarProducto(producto3);
        supermercado.agregarProducto(producto4);

        // CREAR CLIENTE
        Cliente cliente1 = new Cliente("Pedro Martinez", "1945485954", "3854935738", "pedrom@gmail.com");
        Cliente cliente2= new Cliente( "Carlos Perez","385673824","3747285392","carlosp@gmail.com");
        Cliente cliente3= new Cliente("Sara Guzman","28574826347","3657482943","sarag@gmail.com");
        Cliente cliente4= new Cliente("Daniela Gallego","41939312","34721325463","danielag@gmial.com");
        //AGREGA
    supermercado.agregarCliente(cliente1);
        supermercado.agregarCliente(cliente2);
        supermercado.agregarCliente(cliente3);
        supermercado.agregarCliente(cliente4);

        int opcion;
        do {
            String menu = "===== MENÚ MARKETPLUS =====\n" +
                    "---------- CLIENTES ----------\n" +
                    "1. Agregar cliente\n" +
                    "2. Buscar cliente\n" +
                    "3. Eliminar cliente\n" +
                    "---------- PRODUCTOS ----------\n" +
                    "4. Agregar producto\n" +
                    "5. Buscar producto\n" +
                    "6. Eliminar producto\n" +
                    "---------- COMPRAS Y REPORTES ----------\n" +
                    "7. Registrar compra\n" +
                    "8. Consultar compras de un cliente\n" +
                    "9. Reporte de ventas por fecha\n" +
                    "0. Salir\n\n" +
                    "Ingrese una opción:";

            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) break; // Si el usuario cierra o presiona cancelar

            opcion = Integer.parseInt(entrada);

            switch (opcion) {

                // ========== CLIENTES ==========
                case 1:
                    JOptionPane.showMessageDialog(null, "--------- Agregar Cliente ---------");

                    String docCliente = JOptionPane.showInputDialog("Documento de Identidad:");
                    String nombreCliente = JOptionPane.showInputDialog("Nombre completo:");
                    String telCliente = JOptionPane.showInputDialog("Teléfono:");
                    String correoCliente = JOptionPane.showInputDialog("Correo electrónico:");

                    Cliente cliente = new Cliente(nombreCliente, docCliente, telCliente, correoCliente);

                    if (supermercado.agregarCliente(cliente)) {
                        JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El cliente ya existe.");
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "--------- Buscar Cliente ---------");

                    String docBuscar = JOptionPane.showInputDialog("Documento del cliente:");
                    Cliente clienteEncontrado = supermercado.buscarCliente(docBuscar);

                    if (clienteEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Cliente encontrado:\n" +
                                "Nombre: " + clienteEncontrado.getNombre() + "\n" +
                                "Documento: " + clienteEncontrado.getDocumentoIdentidad() + "\n" +
                                "Teléfono: " + clienteEncontrado.getTelefono() + "\n" +
                                "Correo: " + clienteEncontrado.getCorreoElectronico());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "--------- Eliminar Cliente ---------");

                    String docEliminar = JOptionPane.showInputDialog("Documento del cliente a eliminar:");

                    if (supermercado.eliminarCliente(docEliminar)) {
                        JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                    break;

                // ========== PRODUCTOS ==========
                case 4:
                    JOptionPane.showMessageDialog(null, "--------- Agregar Producto ---------");

                    String codProducto = JOptionPane.showInputDialog("Código del producto:");
                    String nomProducto = JOptionPane.showInputDialog("Nombre del producto:");
                    float precio = Float.parseFloat(JOptionPane.showInputDialog("Precio unitario:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad disponible:"));
                    String catStr = JOptionPane.showInputDialog("Categoría (ALIMENTOS, BEBIDAS, PRODUCTOSASEO, CUIDADOPERSONAL):");
                    TipoProducto categoria = TipoProducto.valueOf(catStr.toUpperCase());

                    Producto producto = new Producto(codProducto, nomProducto, categoria, precio, cantidad );

                    if (supermercado.agregarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El producto ya existe.");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "--------- Buscar Producto ---------");

                    String codBuscar = JOptionPane.showInputDialog("Código del producto:");
                    Producto productoEncontrado = supermercado.buscarProducto(codBuscar);

                    if (productoEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Producto encontrado:\n" +
                                "Código: " + productoEncontrado.getCodigoProducto() + "\n" +
                                "Nombre: " + productoEncontrado.getNombre() + "\n" +
                                "Precio: $" + productoEncontrado.getPrecioUnitario() + "\n" +
                                "Stock: " + productoEncontrado.getCantidadDisponible() + "\n" +
                                "Categoría: " + productoEncontrado.getCategoria());
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "--------- Eliminar Producto ---------");

                    String codEliminar = JOptionPane.showInputDialog("Código del producto a eliminar:");

                    if (supermercado.eliminarProducto(codEliminar)) {
                        JOptionPane.showMessageDialog(null, "El producto ha sido eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                    }
                    break;

                // ========== COMPRAS Y REPORTES ==========
                case 7:
                    JOptionPane.showMessageDialog(null, "--------- Registrar Compra ---------");

                    String docClienteCompra = JOptionPane.showInputDialog("Documento del cliente:");
                    if (docClienteCompra == null) break; // usuario canceló

                    Cliente cliCompra = supermercado.buscarCliente(docClienteCompra);
                    if (cliCompra == null) {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado. Debe registrarlo primero.");
                        break;
                    }

                    // Listas para ir acumulando TODOS los productos de esta compra
                    List<Producto> prods = new ArrayList<>();
                    List<Integer> cants = new ArrayList<>();

                    boolean seguirAgregando = true;
                    while (seguirAgregando) {
                        String codProdCompra = JOptionPane.showInputDialog("Código del producto a comprar:");
                        if (codProdCompra == null) break; // canceló, se detiene de agregar más

                        Producto prodCompra = supermercado.buscarProducto(codProdCompra);
                        if (prodCompra == null) {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
                            continue; // vuelve a preguntar sin salir del ciclo
                        }

                        String cantStr = JOptionPane.showInputDialog("Cantidad de \"" + prodCompra.getNombre() + "\" a comprar:");
                        if (cantStr == null) break;

                        int cantCompra;
                        try {
                            cantCompra = Integer.parseInt(cantStr);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida, debe ser un número entero.");
                            continue;
                        }

                        if (cantCompra <= 0) {
                            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
                            continue;
                        }

                        if (!prodCompra.hayDisponibilidad(cantCompra)) {
                            JOptionPane.showMessageDialog(null, "No hay suficiente stock de \"" + prodCompra.getNombre() + "\".");
                            continue;
                        }

                        prods.add(prodCompra);
                        cants.add(cantCompra);

                        int otraOpcion = JOptionPane.showConfirmDialog(null, "¿Agregar otro producto a esta compra?",
                                "Agregar más", JOptionPane.YES_NO_OPTION);
                        seguirAgregando = (otraOpcion == JOptionPane.YES_OPTION);
                    }

                    if (prods.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se agregó ningún producto. Compra cancelada.");
                        break;
                    }

                    String metStr = JOptionPane.showInputDialog("Método de pago (EFECTIVO, TARJETA, TRANSFERENCIA):");
                    if (metStr == null) break;

                    MetodoPago metodoPago;
                    try {
                        metodoPago = MetodoPago.valueOf(metStr.trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Método de pago inválido.");
                        break;
                    }

                    String codFactura = "FAC-" + (supermercado.getListaFacturas().size() + 1);

                    Factura factura = supermercado.registrarCompra(cliCompra, codFactura, LocalDate.now(), metodoPago, prods, cants);

                    if (factura != null) {
                        String resumen = "¡Compra registrada exitosamente!\n" +
                                "Código Factura: " + factura.getCodigoCompra() + "\n" +
                                "Productos comprados:\n";
                        for (int i = 0; i < prods.size(); i++) {
                            resumen += " - " + prods.get(i).getNombre() + " x" + cants.get(i) + "\n";
                        }
                        resumen += "Total a pagar: $" + factura.getValorTotal();
                        JOptionPane.showMessageDialog(null, resumen);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar compra (verifique disponibilidad de stock).");
                    }
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "--------- Consultar Compras de un Cliente ---------");

                    String docHistorial = JOptionPane.showInputDialog("Documento del cliente:");
                    Cliente cliHistorial = supermercado.buscarCliente(docHistorial);

                    if (cliHistorial != null) {
                        String historialStr = "Compras realizadas por: " + cliHistorial.getNombre() + "\n";
                        for (Factura f : cliHistorial.getListaFactura()) {
                            historialStr += "- Código: " + f.getCodigoCompra() + " | Fecha: " + f.getFechaRealizacion() + " | Total: $" + f.getValorTotal() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, historialStr);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "--------- Reporte de Ventas por Fecha ---------");

                    String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha (AAAA-MM-DD):");
                    LocalDate fecha = LocalDate.parse(fechaStr);

                    float totalVentas = supermercado.obtenerVentasPorFecha(fecha);
                    JOptionPane.showMessageDialog(null, "Total vendido el día " + fecha + ": $" + totalVentas);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }

        } while (opcion != 0);
    }
}
