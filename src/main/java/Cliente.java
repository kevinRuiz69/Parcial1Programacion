import java.util.list;


public class Cliente {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;

    // RELACION CON FACTURA
    private list<Factura>listaFactura;
    // RELACION CON MARKETPLUS
    private MarketPlus marketPlus;


    // CONSTRUCTOR
    public Cliente(String nombre, String documentoIdentidad, String telefono, String correoElectronico,MarketPlus marketPlus) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.listaFactura= new
        this.marketPlus= marketPlus;
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

    public list<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(list<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public MarketPlus getMarketPlus() {
        return marketPlus;
    }

    public void setMarketPlus(MarketPlus marketPlus) {
        this.marketPlus = marketPlus;
    }

    @java.lang.Override
    public String toString() {
        return
                "nombre='" + nombre +
                ", documentoIdentidad='" + documentoIdentidad +
                ", telefono='" + telefono +
                ", correoElectronico='" + correoElectronico +
                ", listaFactura='"+ listaFactura+
                ", marketPlus='"+marketPlus+
                '}';
    }
}
