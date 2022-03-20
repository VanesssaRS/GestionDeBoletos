package Model.Usuarios;

public class Monto {

    private double subTotal;
    private double iva;
    private double total;

    public Monto( double subTotal, double iva, double total) {

        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public Monto() {
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
