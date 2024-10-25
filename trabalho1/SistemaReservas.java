import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReservas {
  // Scanner para entrada de dados do usuário
  Scanner in = new Scanner(System.in);

  // Lista que armazena todas as reservas feitas
  List<Reserva> reservas = new ArrayList<>();

  // Instância do administrador que gerencia os hotéis e quartos
  Administrador administrador = new Administrador();

  // Método para listar todos os hotéis disponíveis
  void listarHoteis() {
    System.out.println("------------------------");
    List<Hotel> hoteis = administrador.getHoteis(); // Chama os hoteis da lista
    for (int i = 0; i < hoteis.size(); i++) {
      Hotel hotel = hoteis.get(i);
      System.out.println((i + 1) + ": Hotel " + hotel.getNome() + " - " + hotel.getEndereco());
    }
    System.out.println("------------------------");
  }

  // Método para adicionar um novo hotel à lista de hotéis
  void adicionarHotel() {
    administrador.adicionarHotel(); // Chama o método adicionar hotel
  }

  // Método para remover um hotel da lista de hotéis
  void removerHotel() {
    administrador.removerHotel(); // Chama o método remover hotel
  }

  // Método para adicionar um novo quarto a um hotel existente
  void adicionarQuarto() {
    System.out.println("------------------------");
    listarHoteis(); // Lista os hoteis disponíveis
    System.out.print("Escolha o número do hotel para adicionar um quarto: ");
    int indiceHotel = in.nextInt() - 1; // Seleciona o hotel escolhido pelo usuário
    if (indiceHotel >= 0 && indiceHotel < administrador.getHoteis().size()) {
      administrador.getHoteis().get(indiceHotel).adicionarQuarto(); // Adiciona quarto ao hotel selecionado
    } else {
      System.out.println("Hotel inválido. Tente novamente.");
    }
    System.out.println("------------------------");
  }

  // Método para listar os quartos disponíveis em um hotel selecionado
  void listarQuartosDisponiveis() {
    System.out.println("------------------------");
    listarHoteis(); // Lista os hoteis
    System.out.print("Escolha o número do hotel para listar os quartos: ");
    int indiceHotel = in.nextInt() - 1; // Seleciona o hotel escolhido pelo usuário
    if (indiceHotel >= 0 && indiceHotel < administrador.getHoteis().size()) {
      administrador.getHoteis().get(indiceHotel).listarQuartos(); // Mostra os quartos disponíveis do hotel selecionado
    } else {
      System.out.println("Hotel inválido. Tente novamente.");
    }
    System.out.println("------------------------");
  }

  // Método para fazer uma nova reserva para um cliente
  void fazerReserva() {
    // Cadastro do cliente
    System.out.print("Informe o nome do cliente: ");
    String nomeCliente = in.next();
    System.out.print("Informe o endereço do cliente: ");
    String enderecoCliente = in.next();
    System.out.print("Informe o telefone do cliente: ");
    String telefoneCliente = in.next();

    Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente); // Cria novo cliente
    cliente.fazerReserva(administrador); // Chama o método fazerReserva do cliente, passando o administrador
    reservas.add(cliente.getReservas().get(cliente.getReservas().size() - 1)); // Adiciona a reserva à lista global
  }

  // Método para cancelar uma reserva existente
  void cancelarReserva() {
    System.out.println("------------------------");
    System.out.print("Digite o número da reserva a ser cancelada: ");
    int numeroReserva = in.nextInt(); // Solicita o número da reserva

    Reserva reservaParaCancelar = null;

    // Procura a reserva com o número fornecido
    for (Reserva reserva : reservas) {
      if (reserva.getNumeroReserva() == numeroReserva) {
        reservaParaCancelar = reserva; // Se encontrada, armazena a reserva
        break;
      }
    }

    if (reservaParaCancelar != null) {
      reservaParaCancelar.cancelarReserva(); // Chama o método de cancelamento da reserva
      reservas.remove(reservaParaCancelar); // Remove a reserva da lista de reservas
      System.out.println("Reserva cancelada com sucesso.");
    } else {
      System.out.println("Reserva não encontrada.");
    }
    System.out.println("------------------------");
  }

  // Método para listar todas as reservas de um cliente específico
  void listarReservasCliente() {
    System.out.println("------------------------");
    System.out.print("Informe o nome do cliente para listar suas reservas: ");
    String nomeCliente = in.next(); // Solicita o nome do cliente

    boolean encontrouReservas = false; // Flag para verificar se reservas foram encontradas

    // Procura por reservas associadas ao cliente
    for (Reserva reserva : reservas) {
      if (reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
        // Exibe detalhes da reserva
        System.out
            .println("Reserva número: " + reserva.getNumeroReserva() + ", Quarto: " + reserva.getQuarto().getNumero() +
                ", Data Check-In: " + reserva.getDataCheckIn() +
                ", Data Check-Out: " + reserva.getDataCheckOut());
        encontrouReservas = true; // Marca que pelo menos uma reserva foi encontrada
      }
    }

    if (!encontrouReservas) {
      System.out.println("Nenhuma reserva encontrada para o cliente " + nomeCliente + "."); // Mensagem caso não haja
                                                                                            // reservas
    }
    System.out.println("------------------------");
  }
}
