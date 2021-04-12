public class CuoreSolitario {
  private static final int DIFFERENZA_MINIMA_ETA = 10;
  private String pseudonimo;
  private Character sesso;
  private int eta;
  private SegnoZodiacale segnoZodiacale;
  private SegnoZodiacale segnoZodiacalePartner;

  public CuoreSolitario(String pseudonimo, char sesso, int eta, SegnoZodiacale segnoZodiacale,
      SegnoZodiacale segnoZodiacalePartner) {
    this.pseudonimo = pseudonimo;
    this.sesso = sesso;
    this.eta = eta;
    this.segnoZodiacale = segnoZodiacale;
    this.segnoZodiacalePartner = segnoZodiacalePartner;
  }

  // Getters
  public String getPseudonimo() {
    return pseudonimo;
  }

  public char getSesso() {
    return sesso;
  }

  public int getEta() {
    return eta;
  }

  public SegnoZodiacale getSegnoZodiacale() {
    return segnoZodiacale;
  }

  public SegnoZodiacale getSegnoZodiacalePartner() {
    return segnoZodiacalePartner;
  }

  // Setters
  public void setPseudonimo(String pseudonimo) {
    this.pseudonimo = pseudonimo;
  }

  public void setSesso(char sesso) {
    this.sesso = sesso;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  public void setSegnoZodiacale(SegnoZodiacale segnoZodiacale) {
    this.segnoZodiacale = segnoZodiacale;
  }

  public void setSegnoZodiacalePartner(SegnoZodiacale segnoZodiacalePartner) {
    this.segnoZodiacalePartner = segnoZodiacalePartner;
  }

  // Methods
  public boolean sonoAffini(CuoreSolitario cs) {
    int differenzaEta;

    if (Character.toLowerCase(sesso) == Character.toLowerCase(cs.sesso))
      return false;

    if (eta >= cs.eta)
      differenzaEta = eta - cs.eta;
    else
      differenzaEta = cs.eta - eta;

    if (differenzaEta > DIFFERENZA_MINIMA_ETA)
      return false;

    return (segnoZodiacalePartner.getNome().equals(cs.segnoZodiacale.getNome())
        && cs.segnoZodiacalePartner.getNome().equals(segnoZodiacale.getNome()));
  }

  @Override
  public String toString() {
    return "Pseudonimo: " + pseudonimo;
  }
}
