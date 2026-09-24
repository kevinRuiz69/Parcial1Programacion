public class Aplicacion {
     static voin main() {

         // CREAR SUPERMERCADO
         MarketPlus = marketPlus = new MarketPlus("MarketPlus", "carrera 14 #20-30", "3005849345");

         // CREAR PRODUCTO
         Producto producto1 = new Producto("PT32", "frijoles", TipoProducto.ALIMENTOS, 5000, 15);
         Producto producto2 = new Producto("PS67", "gaseosa", "TipoProducto.BEBIDAS", 6500, 35);
         Producto producto3 = new Producto("PN45", "limpido", " tipoProducto.PRODUCTOASEO", 5500, 12);
         Producto producto4 = new Producto("PS24", "shampoo", "tipoProducto.CUIDADOPERSONAL", 13000, 20);

         // CREAR CLIENTE
         Cliente cliente1 = new Cliente("Pedro Martinez", "1945485954", "3854935738", "pedrom@gmail.com");

         //CREAR FACTURA
         Factura factura = new Factura("F948", LocalDate.of(2026, 09, 22), "MetodoPago.EFECTIVO", cliente1);

         //  CREAR DETALLES FACTURA
         DetalleFactura datalle1 = new DetalleFactura(producto1, 2);
         DetalleFactura datalle2 = new DetalleFactura(producto2, 3);
         DetalleFactura datalle3 = new DetalleFactura(producto4, 1);

         //  AGREGAR PRODUCTOS A LA FACTURA
         factura1.agregarDetalle(detalle1);
         factura1.agregarDetalle(detalle2);
         factura1.agregarDetalle(detalle3);

         // AGREGAR CLIENTE Y PRODUCTOS AL MARKETPLUS
         marketPlus.agregarCliente(cliente1);

         marketPlus.agregarProducto(producto1);
         marketPlus.agregarProducto(producto2);
         marketPlus.agregarProducto(producto3);
         marketPlus.agregarProducto(producto4);

         // AGREGAR LA FACTURA AL SUPERMERCADO
         marketPlus.agregarFactura(factura1)

         // MOSTRAR INFORMACION
         System.out.println("-----MARKETPLUS-----");
         System.out.println("cliente:" + cliente1.getNombreCompleto());
         System.out.println("factura:" + factura1.getCodigoCompra());
         System.out.println(" fecha:" + factura1.getFecha());
         System.out.println("valor total:$" + factura1.calcularTotal());


     }
    }


