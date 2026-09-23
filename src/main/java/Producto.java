public class Producto {

    //atributos
    private String codigoProducto;
    private String nombre;
    private float precioUnitario;
    private int cantidadDisponible;

    //RELACION DE CURSO CON MODALIDAD
    private TipoProducto tipoProducto;


    //Constructor
    public Producto(String codigoProducto, String nombre, float precioUnitario, int cantidadDisponible, TipoProducto tipoProducto) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.tipoProducto = tipoProducto;
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

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    //override

    @Override
    public String toString() {
        return "codigoProducto='" + codigoProducto +
                ", nombre: " + nombre +
                ", precioUnitario: " + precioUnitario +
                ", cantidadDisponible: " + cantidadDisponible +
                ", tipoProducto: " + tipoProducto;
    }
}
