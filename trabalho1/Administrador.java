import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador {
    // Nome do administrador
    private String nome;

    // ID único do administrador
    private int id;

    // Lista de hotéis gerenciados pelo administrador
    private List<Hotel> hoteis = new ArrayList<>();

    // Scanner para entrada de dados do usuário
    private Scanner in = new Scanner(System.in);

    // Construtor do administrador
    public Administrador() {
        // Inicializa o administrador sem atributos definidos
    }

    // Getter para obter o nome do administrador
    public String getNome() {
        return nome;
    }

    // Setter para definir o nome do administrador
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para obter o ID do administrador
    public int getId() {
        return id;
    }

    // Setter para definir o ID do administrador
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obter a lista de hotéis
    public List<Hotel> getHoteis() {
        return hoteis;
    }

    // Setter para definir a lista de hotéis
    public void setHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis; // Define a lista de hotéis do administrador
    }

    // Método para adicionar um novo hotel à lista de hotéis
    public void adicionarHotel() {
        System.out.print("Informe o nome do hotel: ");
        String nome = in.next(); // Solicita o nome do hotel
        System.out.print("Informe o endereço do hotel: ");
        String endereco = in.next(); // Solicita o endereço do hotel

        Hotel hotel = new Hotel(nome, endereco); // Cria uma nova instância de Hotel
        hoteis.add(hotel); // Adiciona o hotel à lista de hotéis
        System.out.println("Hotel cadastrado"); // Mensagem de confirmação
    }

    // Método para remover um hotel da lista de hotéis
    public void removerHotel() {
        System.out.print("Informe o nome do hotel a ser removido: ");
        String nomeHotel = in.next(); // Solicita o nome do hotel a ser removido

        // Remove o hotel da lista se o nome corresponder
        boolean removed = hoteis.removeIf(hotel -> hotel.getNome().equals(nomeHotel));
        if (removed) {
            System.out.println("Hotel removido"); // Mensagem de sucesso
        } else {
            System.out.println("Hotel não encontrado"); // Mensagem de erro
        }
    }
}
