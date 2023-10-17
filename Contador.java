import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        int parametroUm = obterParametro("Digite o primeiro parâmetro:");
        int parametroDois = obterParametro("Digite o segundo parâmetro:");

        try {
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }

    static int obterParametro(String mensagem) {
        Scanner terminal = new Scanner(System.in);
        System.out.println(mensagem);
        while (true) {
            try {
                return Integer.parseInt(terminal.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro válido:");
            }
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        if (contagem > 0) {
            for (int i = 1; i <= contagem; i++) {
                System.out.println("Imprimindo o número " + i);
            }
        } else {
            System.out.println("Não há números para imprimir, pois o primeiro parâmetro é maior ou igual ao segundo.");
        }
    }
}

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
