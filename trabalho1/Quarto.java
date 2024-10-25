public class Quarto {
  // Atributos do quarto
  private int numero; // Número do quarto
  private String tipo; // Tipo do quarto (ex: solteiro, casal, etc.)
  private double preco; // Preço do quarto
  private boolean estaDisponivel = true; // Indica se o quarto está disponível

  // Construtor que inicializa o número, tipo e preço do quarto
  public Quarto(int numero, String tipo, double preco) {
    this.numero = numero; // Atribui o número do quarto
    this.tipo = tipo; // Atribui o tipo do quarto
    this.preco = preco; // Atribui o preço do quarto
  }

  // Getter para obter o número do quarto
  public int getNumero() {
    return numero;
  }

  // Setter para definir o número do quarto
  public void setNumero(int numero) {
    this.numero = numero;
  }

  // Getter para obter o tipo do quarto
  public String getTipo() {
    return tipo;
  }

  // Setter para definir o tipo do quarto
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  // Getter para obter o preço do quarto
  public double getPreco() {
    return preco;
  }

  // Setter para definir o preço do quarto
  public void setPreco(double preco) {
    this.preco = preco;
  }

  // Getter para verificar se o quarto está disponível
  public boolean isEstaDisponivel() {
    return estaDisponivel; // Retorna o status de disponibilidade do quarto
  }

  // Setter para definir a disponibilidade do quarto
  public void setEstaDisponivel(boolean estaDisponivel) {
    this.estaDisponivel = estaDisponivel; // Define a disponibilidade do quarto
  }

  // Método que libera o quarto (torna-o disponível)
  void liberar() {
    this.estaDisponivel = true; // Define o quarto como disponível
  }

  // Método que reserva o quarto (torna-o ocupado)
  void reservar() {
    this.estaDisponivel = false; // Define o quarto como não disponível
  }
}
