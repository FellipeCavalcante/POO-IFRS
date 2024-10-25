import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
  // Scanner para entrada de dados do usuário
  Scanner in = new Scanner(System.in);

  // Lista de reservas feitas pelo cliente
  private List<Reserva> reservas = new ArrayList<>();

  // Nome do cliente
  private String nome;

  // Endereço do cliente
  private String endereco;

  // Telefone do cliente
  private String telefone;

  // Construtor principal que inicializa os atributos do cliente
  public Cliente(String nome, String endereco, String telefone) {
    this.nome = nome; // Inicializa o nome do cliente
    this.endereco = endereco; // Inicializa o endereço do cliente
    this.telefone = telefone; // Inicializa o telefone do cliente
  }

  // Construtor padrão
  public Cliente() {
    // Inicializa um cliente sem atributos definidos
  }

  // Getter para obter o nome do cliente
  public String getNome() {
    return nome;
  }

  // Setter para definir o nome do cliente
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Getter para obter o endereço do cliente
  public String getEndereco() {
    return endereco;
  }

  // Setter para definir o endereço do cliente
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  // Getter para obter o telefone do cliente
  public String getTelefone() {
    return telefone;
  }

  // Setter para definir o telefone do cliente
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  // Método para obter as reservas do cliente
  public List<Reserva> getReservas() {
    return reservas; // Retorna a lista de reservas
  }

  // Método para fazer uma nova reserva
  void fazerReserva(Administrador administrador) {
    System.out.println("------------------------");
    System.out.println("HOTEIS DISPONÍVEIS"); // Mensagem de título
    System.out.println("------------------------");

    List<Hotel> hoteis = administrador.getHoteis(); // Obtém a lista de hotéis do administrador
    for (int i = 0; i < hoteis.size(); i++) {
      Hotel hotel = hoteis.get(i); // Acessa cada hotel da lista
      System.out.println((i + 1) + ": Hotel " + hotel.getNome() + " - " + hotel.getEndereco()); // Exibe o nome e
                                                                                                // endereço do hotel
    }
    System.out.println("------------------------");

    System.out.print("Escolha o número do hotel: ");
    int indiceHotel = in.nextInt() - 1; // Obtém o índice do hotel selecionado

    if (indiceHotel >= 0 && indiceHotel < hoteis.size()) { // Verifica se o índice é válido
      Hotel hotelSelecionado = hoteis.get(indiceHotel); // Seleciona o hotel
      List<Quarto> quartos = hotelSelecionado.getQuartos(); // Obtém os quartos do hotel selecionado
      System.out.println("Quartos disponíveis:");
      for (int i = 0; i < quartos.size(); i++) { // Lista os quartos disponíveis
        if (quartos.get(i).isEstaDisponivel()) { // Verifica se o quarto está disponível
          System.out.println(i + 1 + ": Quarto " + quartos.get(i).getNumero()); // Exibe o número do quarto
        }
      }

      System.out.print("Informe o número do quarto: ");
      int indiceQuarto = in.nextInt() - 1; // Obtém o índice do quarto selecionado

      if (indiceQuarto >= 0 && indiceQuarto < quartos.size()) { // Verifica se o índice é válido
        Quarto quartoSelecionado = quartos.get(indiceQuarto); // Seleciona o quarto
        System.out.println("Digite a data de check-in: ");
        String dataCheckIn = in.next(); // Solicita a data de check-in
        System.out.println("Digite a data de check-out: ");
        String dataCheckOut = in.next(); // Solicita a data de check-out

        // Cria uma nova reserva com os dados fornecidos
        Reserva reserva = new Reserva(this, quartoSelecionado, dataCheckIn, dataCheckOut);
        reserva.confirmarReserva(); // Confirma a reserva
        reservas.add(reserva); // Adiciona a reserva à lista de reservas do cliente
        System.out.println("Reserva feita com sucesso!"); // Mensagem de sucesso
      } else {
        System.out.println("Quarto inválido."); // Mensagem de erro se o quarto não for válido
      }
    } else {
      System.out.println("Hotel inválido."); // Mensagem de erro se o hotel não for válido
    }
  }
}
