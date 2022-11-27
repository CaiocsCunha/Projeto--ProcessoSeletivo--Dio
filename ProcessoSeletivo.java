import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    selecionarCandidato();
  }

  static void selecionarCandidato() {
    String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA",
        "JONAS" };

    ArrayList<String> candidatosSelecionados = new ArrayList<String>();
    double salarioBase = 2000.0;

    for (int i = 0; i < candidatos.length && candidatosSelecionados.size() != 5; i++) {
      String candidato = candidatos[i];
      double salarioPretendido = gerarValorPretendido();

      if (salarioPretendido <= salarioBase) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
        candidatosSelecionados.add(candidato);
      }
    }
    imprimirSelecionados(candidatosSelecionados);
    for (String candidato : candidatosSelecionados) {
      entrarEmContato(candidato);
    }
  }

  static void imprimirSelecionados(ArrayList<String> candidatosSelecionados) {
    System.out.println(candidatosSelecionados);
  }

  static double gerarValorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void entrarEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if (continuarTentando) {
        tentativasRealizadas++;
      } else {
        System.out.println("CONTATO REALIZADO COM SUCESSO");
      }
    } while (continuarTentando && tentativasRealizadas < 3);

    if (atendeu) {
      System.out
          .println("Conseguimos entrar em contato com " + candidato + " na " + tentativasRealizadas + " Tentativa");
    } else {
      System.out.println("Não Conseguimos entrar em contato com " + candidato + " ,número máximo de tentativas: "
          + tentativasRealizadas);
    }
  }

  static boolean atender() {
    return new Random().nextInt(3) == 1;
  }
}
