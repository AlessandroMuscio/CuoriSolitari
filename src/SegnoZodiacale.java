public enum SegnoZodiacale {
  ACQUARIO("Acquario", "Aria"), PESCI("Pesci", "Acqua"), ARIETE("Ariete", "Fuoco"), TORO("Toro", "Terra"),
  GEMELLI("Gemelli", "Aria"), CANCRO("Cancro", "Acqua"), LEONE("Leone", "Fuoco"), VERGINE("Vergine", "Terra"),
  BILANCIA("Bilancia", "Aria"), SCORPIONE("Scorpione", "Acqua"), SAGITTARIO("Sagittario", "Fuoco"),
  CAPRICORNO("Capricorno", "Terra");

  private final String nome;
  private final String tipo;

  private SegnoZodiacale(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  public String getNome() {
    return nome;
  }

  public String getTipo() {
    return tipo;
  }
}
