import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
  // Scanner para entrada de dados do usuário
  Scanner in = new Scanner(System.in);

  // Atributos do hotel
  private String nome; // Nome do hotel
  private String endereco; // Endereço do hotel

  // Lista de quartos do hotel
  List<Quarto> quartos = new ArrayList<>();

  // Construtor que inicializa o nome e o endereço do hotel
  public Hotel(String nome, String endereco) {
    this.nome = nome; // Atribui o nome do hotel
    this.endereco = endereco; // Atribui o endereço do hotel
  }

  // Getter para obter o nome do hotel
  public String getNome() {
    return nome;
  }

  // Setter para definir o nome do hotel
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Getter para obter o endereço do hotel
  public String getEndereco() {
    return endereco;
  }

  // Setter para definir o endereço do hotel
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  // Getter para obter a lista de quartos
  public List<Quarto> getQuartos() {
    return quartos;
  }

  // Método para adicionar um novo quarto ao hotel
  void adicionarQuarto() {
    System.out.print("Informe o numero do quarto: ");
    int numeroQuarto = in.nextInt(); // Lê o número do quarto
    System.out.print("Informe o tipo do quarto: ");
    String tipoQuarto = in.next(); // Lê o tipo do quarto
    System.out.print("Informe o preço do quarto: ");
    double precoQuarto = in.nextDouble(); // Lê o preço do quarto

    // Verifica se o quarto já existe na lista
    for (Quarto quarto : quartos) {
      if (quarto.getNumero() == numeroQuarto) {
        System.out.println("Quarto já existe. Tente novamente."); // Mensagem de erro se o quarto já existir
        return; // Retorna sem adicionar o quarto
      }
    }

    // Cria um novo quarto e adiciona à lista
    Quarto novoQuarto = new Quarto(numeroQuarto, tipoQuarto, precoQuarto);
    quartos.add(novoQuarto); // Adiciona o quarto à lista de quartos do hotel
    System.out.println("Quarto " + numeroQuarto + " adicionado com sucesso ao hotel " + nome + ".");
  }

  // Método para remover um quarto do hotel
  void removerQuarto() {
    System.out.print("Informe o numero do quarto que deseja remover: ");
    int numeroQuarto = in.nextInt(); // Lê o número do quarto a ser removido

    // Procura o quarto na lista e remove se encontrado
    for (Quarto quarto : quartos) {
      if (quarto.getNumero() == numeroQuarto) {
        quartos.remove(quarto); // Remove o quarto da lista
        System.out.println("Quarto removido"); // Mensagem de confirmação
        return; // Retorna após a remoção
      }
    }
    System.out.println("Quarto não encontrado."); // Mensagem se o quarto não for encontrado
  }

  // Método para listar os quartos disponíveis
  void listarQuartos() {
    for (Quarto quarto : quartos) {
      // Verifica se o quarto está disponível
      if (quarto.isEstaDisponivel()) {
        System.out.println("Quarto número: " + quarto.getNumero() + " tipo: " + quarto.getTipo() + " R$"
            + quarto.getPreco() + " está disponível"); // Exibe informações do quarto disponível
      }
    }
  }
}
