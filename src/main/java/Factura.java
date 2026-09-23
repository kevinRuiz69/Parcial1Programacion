import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    //atributos
    private String codigoCompra;
    private LocalDate fechaRealizacion;

    //RELACION DE FACTURA CON METODOPAGO
    private MetodoPago metodoPago;
    private Cliente cliente;

    //RELACION DE FACTURA CON DETALLEFACTURA
    private List<DetalleFactura> listaDetalleFactura;

    //constructor
    public Factura(String codigoCompra, LocalDate fechaRealizacion, MetodoPago metodoPago) {
        this.codigoCompra = codigoCompra;
        this.fechaRealizacion = fechaRealizacion;
        this.metodoPago = metodoPago;
        this.listaDetalleFactura = new ArrayList<>();
    }

    //getters y setters
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getValorTotal() {
        return calcularValorTotal();
    }

    public float calcularValorTotal() {
        float valorTotal = 0;

        for (DetalleFactura detalle : listaDetalleFactura) {
            valorTotal += detalle.getSubTotal();
        }

        return valorTotal;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void agregarDetalle(DetalleFactura detalleFactura) {
        listaDetalleFactura.add(detalleFactura);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "codigoCompra: " + codigoCompra +
                ", fechaRealizacion: " + fechaRealizacion +
                ", valorTotal: " + getValorTotal() +
                ", metodoPago: " + metodoPago +
                ", cliente: " + (cliente != null ? cliente.getNombre() : "sin cliente") +
                ", listaDetalleFactura: " + listaDetalleFactura;
    }
}
