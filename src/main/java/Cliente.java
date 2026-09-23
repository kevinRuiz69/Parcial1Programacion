import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    private List<Factura> listaFactura;

    // CONSTRUCTOR
    public Cliente(String nombre, String documentoIdentidad, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.listaFactura = new ArrayList<>();
    }

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public void agregarFactura(Factura factura) {
        listaFactura.add(factura);
    }

    @java.lang.Override
    public String toString() {
        return
                "nombre='" + nombre +
                ", documentoIdentidad='" + documentoIdentidad +
                ", telefono='" + telefono +
                ", correoElectronico='" + correoElectronico +
                ", cantidadFacturas=" + listaFactura.size() +
                '}';
    }
}
