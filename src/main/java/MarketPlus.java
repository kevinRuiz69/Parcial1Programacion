import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarketPlus {
    private String nombreComercial;
    private String direccion;
    private String telefono;
    //Relaciones
    private List<Producto> listaProductos;
    private List<Cliente> listaClientes;
    private List<Factura> listaFacturas;

    public MarketPlus(String nombreComercial, String direccion, String telefono) {
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaFacturas = new ArrayList<>();
    }
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    // CRUD CLIENTE
    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getDocumentoIdentidad())==null){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public Cliente buscarCliente(String documentoIdentidad) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean actualizarCliente(String documentoIdentidad, String nombre, String telefono,
                                     String correoElectronico) {
        if(buscarCliente(documentoIdentidad)!=null){
            for (Cliente cliente : listaClientes) {
                if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setCorreoElectronico(correoElectronico);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarCliente(String documentoIdentidad) {
        if(buscarCliente(documentoIdentidad)!=null){
            for (Cliente cliente : listaClientes) {
                if (cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                    listaClientes.remove(cliente);
                    return true;
                }
            }
        }
        return false;
    }

    // CRUD PRODUCTO
    public boolean agregarProducto(Producto producto) {
        if  (buscarProducto(producto.getCodigoProducto())==null){
            listaProductos.add(producto);
            return true;
        }
        return false;
    }

    public Producto buscarProducto(String codigoProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigoProducto().equals(codigoProducto)) {
                return producto;
            }
        }
        return null;
    }

    public boolean actualizarProducto(String codigoProducto, String nombre, TipoProducto categoria,
                                      float precioUnitario, int cantidadDisponible) {
        if (buscarProducto(codigoProducto)!=null){
            for (Producto producto : listaProductos) {
                if (producto.getCodigoProducto().equals(codigoProducto)) {
                    producto.setNombre(nombre);
                    producto.setCategoria(categoria);
                    producto.setPrecioUnitario(precioUnitario);
                    producto.setCantidadDisponible(cantidadDisponible);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarProducto(String codigoProducto) {
        if(buscarProducto(codigoProducto)!=null){
            for (Producto producto : listaProductos) {
                if (producto.getCodigoProducto().equals(codigoProducto)) {
                    listaProductos.remove(producto);
                    return true;
                }
            }
        }
        return false;
    }

    // CRUD FACTURA
    public boolean agregarFactura(Factura factura) {
        if(buscarFactura(factura.getCodigoCompra())==null){
            listaFacturas.add(factura);
            return true;
        }
        return false;
    }

    public Factura buscarFactura(String codigoCompra) {
        for (Factura factura : listaFacturas) {
            if (factura.getCodigoCompra().equals(codigoCompra)) {
                return factura;
            }
        }
        return null;
    }

    public boolean eliminarFactura(String codigoCompra) {
        if(buscarFactura(codigoCompra)!=null){
            for (Factura factura : listaFacturas) {
                if (factura.getCodigoCompra().equals(codigoCompra)) {
                    listaFacturas.remove(factura);
                    return true;
                }
            }
        }
        return false;
    }

    // METODOS DE NEGOCIO
    public Factura registrarCompra(Cliente cliente, String codigoCompra, LocalDate fechaRealizacion,
                                   MetodoPago metodoPago, List<Producto> productos, List<Integer> cantidades) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidadPedida = cantidades.get(i);

            if (!producto.hayDisponibilidad(cantidadPedida)) {
                return null;
            }
        }

        Factura factura = new Factura(codigoCompra, fechaRealizacion, metodoPago);
        factura.setCliente(cliente);

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            factura.agregarDetalle(new DetalleFactura(cantidad, producto));
            producto.actualizarCantidadDisponible(cantidad);
        }

        agregarFactura(factura);
        cliente.agregarFactura(factura);
        return factura;
    }

    public float obtenerVentasPorFecha(LocalDate fecha) {
        float ventasPorFecha = 0;
        for (Factura factura : listaFacturas) {
            if (factura.getFechaRealizacion().equals(fecha)) {
                ventasPorFecha += factura.getValorTotal();
            }
        }
        return ventasPorFecha;
    }
}
