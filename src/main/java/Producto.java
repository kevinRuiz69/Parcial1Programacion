public class Producto {

    //atributos
    private String codigoProducto;
    private String nombre;
    private TipoProducto categoria;
    private float precioUnitario;
    private int cantidadDisponible;

    //Constructor
    public Producto(String codigoProducto, String nombre, TipoProducto categoria, float precioUnitario,
                    int cantidadDisponible) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
    }

    //getters y setters
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoProducto categoria) {
        this.categoria = categoria;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean hayDisponibilidad(int cantidad) {
        if(cantidad > 0 && cantidad <= cantidadDisponible) {
            return true;
        }
        return false;
    }

    public void actualizarCantidadDisponible(int cantidad) {
        if (hayDisponibilidad(cantidad)) {
            cantidadDisponible -= cantidad;
        }
    }

    //override

    @Override
    public String toString() {
        return "codigoProducto='" + codigoProducto +
                ", nombre: " + nombre +
                ", categoria: " + categoria +
                ", precioUnitario: " + precioUnitario +
                ", cantidadDisponible: " + cantidadDisponible;
    }
}
