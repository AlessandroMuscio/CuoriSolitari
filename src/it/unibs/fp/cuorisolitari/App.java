package it.unibs.fp.cuorisolitari;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println(OutputStringhe.MSG_BENVENUTO);
    GestoreProgramma.setSoggetoUno(GestoreProgramma.inserimentoCuoreSolitario());
    GestoreProgramma.setSoggetoDue(GestoreProgramma.inserimentoCuoreSolitario());
    GestoreProgramma.verificaAffinita();
  }
}