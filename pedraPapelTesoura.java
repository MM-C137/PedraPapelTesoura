import java.util.Random;
import java.util.Scanner;

public class pedraPapelTesoura {
	
	static final int PEDRA = 0;
	static final int PAPEL = 1;
	static final int TESOURA = 2;

    static Scanner sc = new Scanner(System.in);

    static int vitoriaUsuario = 0;
    static int vitoriaCpu = 0;
 
	static public void main(String[] args){
        int c = 1;
        System.out.println("Vamos jogar Pedra, Papel, Tesoura!");
		
        while(c == 1){
            int jogadaUsuario = recebeJogadaUsuario();
		    int jogadaCpu = geraJogadaCpu();
		    int resultado = executaJogada(jogadaUsuario, jogadaCpu);
	    	exibeResultado(jogadaUsuario, jogadaCpu, resultado);
            exibePlacar(vitoriaUsuario, vitoriaCpu);

            c = jogarDeNovo();
        };
        sc.close();
	}

	static public int recebeJogadaUsuario(){
        // Scanner read = new Scanner(System.in);

        System.out.printf("Realize sua Jogada: ");

        int jogadaUsuario = sc.nextInt();
        while(jogadaUsuario < 0 || jogadaUsuario > 2){
            System.out.printf("Esse numero não representa uma jogada, tente novamente: ");
            jogadaUsuario = sc.nextInt();
        }
        // read.close();

		return jogadaUsuario;
	}
        
	static public int geraJogadaCpu(){
		Random rnd = new Random();
		long semente = System.currentTimeMillis();
		rnd.setSeed(semente);
		return rnd.nextInt(3); // retorna aleatorio entre 0 e 2
	}
	
	static public int executaJogada(int jogadaUsuario, int jogadaCpu){
		if(jogadaUsuario == jogadaCpu) return 0;
        else if((jogadaUsuario == PEDRA && jogadaCpu == TESOURA) || (jogadaUsuario == PAPEL && jogadaCpu == PEDRA) || (jogadaUsuario == TESOURA && jogadaCpu == PAPEL)) return 1;
        else return 2;
	}
	
    static public String jogadaEmString(int jogada){
        if(jogada == 0) return "PEDRA";
        else if(jogada == 1) return "PAPEL";
        else return "TESOURA";
        
    } 

	static public void exibeResultado(int jogadaUsuario, int jogadaCpu, int resultado){
		System.out.printf("\nVoce jogou %s, a CPU jogou %s\n", jogadaEmString((jogadaUsuario)), jogadaEmString(jogadaCpu));

        if(resultado == 0) System.out.println("Empate!\n");
        else if(resultado == 1){
            System.out.println("Voce Venceu!\n");
            vitoriaUsuario++;  
        } 
        else{
            System.out.println("Voce Perdeu!\n");
            vitoriaCpu++;
        }
	}

    static public int incrementarValor(int valor){
        return valor++;
    }    

    static public int jogarDeNovo(){
        // Scanner sc = new Scanner(System.in);

        System.out.printf("Deseja Jogar Novamente (Sim: 1, Nao: 0)?: ");
        int resposta = sc.nextInt();
        // sc.close();

        if(resposta == 1) return 1;
        else return 0;
    }

    static public void exibePlacar(int usuario, int cpu){
        System.out.printf("Usuario: %d\nCPU: %d\n\n", usuario, cpu);
    }
}
