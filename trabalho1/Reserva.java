import java.util.Scanner;

public class Reserva {
  // Scanner para entrada de dados do usuário
  Scanner in = new Scanner(System.in);

  // Atributos da reserva
  private Cliente cliente; // Cliente que fez a reserva
  private Quarto quarto; // Quarto reservado
  private String dataCheckIn; // Data de check-in
  private String dataCheckOut; // Data de check-out

  private static int contadorReservas = 0; // Contador para rastrear o número de reservas
  private int numeroReserva; // Número único da reserva

  // Construtor que inicializa os atributos da reserva
  public Reserva(Cliente cliente, Quarto quarto, String dataCheckIn, String dataCheckOut) {
    this.cliente = cliente; // Atribui o cliente à reserva
    this.quarto = quarto; // Atribui o quarto à reserva
    this.dataCheckIn = dataCheckIn; // Atribui a data de check-in
    this.dataCheckOut = dataCheckOut; // Atribui a data de check-out
    this.numeroReserva = ++contadorReservas; // Incrementa o contador e atribui um número único à reserva
  }

  // Getter para obter o cliente da reserva
  public Cliente getCliente() {
    return cliente;
  }

  // Setter para definir o cliente da reserva
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  // Getter para obter o quarto da reserva
  public Quarto getQuarto() {
    return quarto;
  }

  // Setter para definir o quarto da reserva
  public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
  }

  // Getter para obter a data de check-in
  public String getDataCheckIn() {
    return dataCheckIn;
  }

  // Setter para definir a data de check-in
  public void setDataCheckIn(String dataCheckIn) {
    this.dataCheckIn = dataCheckIn;
  }

  // Getter para obter a data de check-out
  public String getDataCheckOut() {
    return dataCheckOut;
  }

  // Setter para definir a data de check-out
  public void setDataCheckOut(String dataCheckOut) {
    this.dataCheckOut = dataCheckOut;
  }

  // Getter para obter o número da reserva
  public int getNumeroReserva() {
    return numeroReserva; // Retorna o número único da reserva
  }

  // Método para cancelar a reserva
  public void cancelarReserva() {
    quarto.setEstaDisponivel(true); // Libera o quarto, tornando-o disponível novamente
    System.out.println("Reserva número " + numeroReserva + " cancelada."); // Mensagem de confirmação
  }

  // Método para confirmar a reserva
  void confirmarReserva() {
    quarto.setEstaDisponivel(false); // Marca o quarto como indisponível
    System.out.println("Reserva confirmada: número " + numeroReserva); // Mensagem de confirmação
  }
}
