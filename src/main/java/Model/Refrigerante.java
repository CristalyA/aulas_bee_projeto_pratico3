package Model;

public class Refrigerante extends Produto{
    private boolean comAcucar;
    private boolean semAcucar;

    public boolean isComAcucar() {
        return comAcucar;
    }

    public boolean isSemAcucar() {
        return semAcucar;
    }

    public void setComAcucar(boolean comAcucar) {
        this.comAcucar = comAcucar;
    }

    public void setSemAcucar(boolean semAcucar) {
        this.semAcucar = semAcucar;
    }
}
