public class DetalleFactura {
        private int cantidad;
        private float precioUnitario;
        private float subTotal;
        // RELACION
        private Producto producto;

        // CONSTRUCTOR
        public DetalleFactura(int cantidad, Producto producto) {
            this.cantidad = cantidad;
            this.producto = producto;
            this.precioUnitario = producto.getPrecioUnitario();
            this.subTotal = calcularSubTotal();
        }

        // GETTERS Y SETTERS
        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
            this.subTotal = calcularSubTotal();
        }

        public float getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(float precioUnitario) {
            this.precioUnitario = precioUnitario;
            this.subTotal = calcularSubTotal();
        }

        public float getSubTotal() {
            return subTotal;
        }
        // No hay setSubTotal(): el subtotal siempre se deriva, nunca se asigna directo.

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
            this.precioUnitario = producto.getPrecioUnitario();
            this.subTotal = calcularSubTotal();
        }

        // METODO CALCULAR
        private float calcularSubTotal() {
            return cantidad * precioUnitario;
        }
}
