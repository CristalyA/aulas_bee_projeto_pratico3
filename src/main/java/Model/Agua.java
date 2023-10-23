package Model;




public class Agua extends Produto{

    private boolean comGas;
    private boolean semGas;

    public boolean isComGas(){
        return comGas;
    }

    public boolean isSemGas(){
        return semGas;
    }

    public void setComGas(boolean comGas) {
        this.comGas = comGas;
    }

    public void setSemGas(boolean semGas) {
        this.semGas = semGas;
    }


}
