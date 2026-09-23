import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    //atributos
    private String codigoProducto;
    private LocalDate fechaRealizacion;
    private double valorTotal;

    //RELACION DE FACTURA CON METODOPAGO
    private MetodoPago metodoPago;

    //RELACION DE FACTURA CON DETALLEFACTURA
    private List<DetalleFactura> listaDetalleFactura;

    //constructor
    public Factura(String codigoProducto, LocalDate fechaRealizacion, double valorTotal, MetodoPago metodoPago) {
        this.codigoProducto = codigoProducto;
        this.fechaRealizacion = fechaRealizacion;
        this.valorTotal = valorTotal;
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public List<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }


    //override


    @Override
    public String toString() {
        return "codigoProducto: " + codigoProducto +
                ", fechaRealizacion: " + fechaRealizacion +
                ", valorTotal: " + valorTotal +
                ", metodoPago: " + metodoPago +
                ", listaDetalleFactura: " + listaDetalleFactura;
    }
}
