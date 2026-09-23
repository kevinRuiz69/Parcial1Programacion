public class Producto {

    //atributos
    private String codigoProducto;
    private String nombre;
    private double precioUnitario;
    private int cantidadDisponible;


    //Constructor
    public Producto(String codigoProducto, double precioUnitario, String nombre, int cantidadDisponible) {
        this.codigoProducto = codigoProducto;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }



    //override
    @Override
    public String toString() {
        return "codigoProducto='" + codigoProducto +
                ", nombre='" + nombre +
                ", precioUnitario=" + precioUnitario +
                ", cantidadDisponible=" + cantidadDisponible;
    }
}
