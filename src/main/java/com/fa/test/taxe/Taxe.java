package com.fa.test.taxe;

public class Taxe {

    public static final Taxe ZERO = new Taxe(0d, 0d);

    private double vatTaxe;
    private double importationTaxe;

    public Taxe(double vatTaxe, double importationTaxe) {
        this.importationTaxe = importationTaxe;
        this.vatTaxe = vatTaxe;
    }

    public double getVatTaxe() {
        return vatTaxe;
    }

    public double getTotalTaxe() {
        return importationTaxe + vatTaxe;
    }

    public double getImportationTaxe() {
        return importationTaxe;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Taxe) {
            final Taxe taxe = (Taxe) obj;
            return taxe.getVatTaxe() == this.getVatTaxe()
                    && taxe.getImportationTaxe() == this.getImportationTaxe();
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
