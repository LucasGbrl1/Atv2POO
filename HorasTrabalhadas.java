public class HorasTrabalhadas {
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSaida;
    private int minutoSaida;

    public HorasTrabalhadas(int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida) {
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.horaSaida = horaSaida;
        this.minutoSaida = minutoSaida;
    }

    public double calcularHoras() {
        int totalMinutosEntrada = horaEntrada * 60 + minutoEntrada;
        int totalMinutosSaida = horaSaida * 60 + minutoSaida;
        return (totalMinutosSaida - totalMinutosEntrada) / 60.0;
    }
}