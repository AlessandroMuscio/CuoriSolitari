import it.unibs.fp.mylib.InputDati;

public class GestoreProgramma {
  private static final String CHAR_ACCETTABILI_SESSO = "mMfF";
  private static final int ETA_MINIMA = 18;
  private static final int ETA_MASSIMA = 120;
  private static CuoreSolitario soggetoUno;
  private static CuoreSolitario soggetoDue;

  public static void setSoggetoUno(CuoreSolitario soggetoUno) {
    GestoreProgramma.soggetoUno = soggetoUno;
  }

  public static void setSoggetoDue(CuoreSolitario soggetoDue) {
    GestoreProgramma.soggetoDue = soggetoDue;
  }

  private static SegnoZodiacale trovaSegnoZodiacale(String nome) {
    SegnoZodiacale[] segniZodiacali = SegnoZodiacale.values();

    for (int i = 0; i < segniZodiacali.length; i++) {
      if (segniZodiacali[i].getNome().equals(nome))
        return segniZodiacali[i];
    }

    return null;
  }

  private static String formattaNome(String nome) {
    String stringa_formattata;

    stringa_formattata = nome.trim();
    stringa_formattata = stringa_formattata.toLowerCase();
    stringa_formattata = Character.toUpperCase(stringa_formattata.charAt(0)) + stringa_formattata.substring(1);

    return stringa_formattata;
  }

  public static CuoreSolitario inserimentoCuoreSolitario() {
    String nomeSegnoZodiacale, nomeSegnoZodiacalePartner;
    SegnoZodiacale segnoZodiacale, segnoZodiacalePartner;
    boolean segnoZodiacaleNotFound;

    String pseudonimo = InputDati.leggiStringaNonVuota(OutputStringhe.MSG_INSERT_PSEUDONIMO, true);
    char sesso = InputDati.leggiChar(String.format(OutputStringhe.MSG_INSERT_SESSO, pseudonimo),
        CHAR_ACCETTABILI_SESSO);
    int eta = InputDati.leggiInteroCompreso(String.format(OutputStringhe.MSG_INSERT_ETA, pseudonimo), ETA_MINIMA,
        ETA_MASSIMA);
    do {
      segnoZodiacaleNotFound = false;
      nomeSegnoZodiacale = InputDati
          .leggiStringaNonVuota(String.format(OutputStringhe.MSG_INSERT_SEGNO_ZODIACALE, pseudonimo), true);
      segnoZodiacale = trovaSegnoZodiacale(formattaNome(nomeSegnoZodiacale));

      if (segnoZodiacale == null) {
        segnoZodiacaleNotFound = true;
        System.out.println(OutputStringhe.MSH_ERROR_SEGNO_ZODIACALE_NOT_FOUND);
        for (SegnoZodiacale sz : SegnoZodiacale.values())
          System.out.println("-\t" + sz.getNome());
      }
    } while (segnoZodiacaleNotFound);
    do {
      segnoZodiacaleNotFound = false;
      nomeSegnoZodiacalePartner = InputDati
          .leggiStringaNonVuota(String.format(OutputStringhe.MSG_INSERT_SEGNO_ZODIACALE_PARTNER, pseudonimo), true);
      segnoZodiacalePartner = trovaSegnoZodiacale(formattaNome(nomeSegnoZodiacalePartner));

      if (segnoZodiacalePartner == null) {
        segnoZodiacaleNotFound = true;
        System.out.println(OutputStringhe.MSH_ERROR_SEGNO_ZODIACALE_NOT_FOUND);
        for (SegnoZodiacale sz : SegnoZodiacale.values())
          System.out.println("-\t" + sz.getNome());
      }
    } while (segnoZodiacaleNotFound);

    CuoreSolitario cs = new CuoreSolitario(pseudonimo, sesso, eta, segnoZodiacale, segnoZodiacalePartner);
    System.out.println(String.format(OutputStringhe.MSG_INSERT_SUCCESSO, pseudonimo));

    return cs;
  }

  public static void verificaAffinita() {
    if (soggetoUno.sonoAffini(soggetoDue))
      System.out.println(
          String.format(OutputStringhe.MSG_AFFINITA_POSITIVA, soggetoUno.getPseudonimo(), soggetoDue.getPseudonimo()));
    else
      System.out.println(
          String.format(OutputStringhe.MSG_AFFINITA_NEGATIVA, soggetoUno.getPseudonimo(), soggetoDue.getPseudonimo()));
  }
}
