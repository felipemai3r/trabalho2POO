import java.util.Random;
import java.util.Scanner;

public class atividade01 {

	
	public static void main(String[] args) {
		//Definindo a contante para  o valoe aleatorio 
		final int maximoAle = 20; // Valor maximo 
		

		// definicndo variavel de entrada 
		Scanner entrada= new Scanner(System.in);
		//Definido variavel de aleatorio 
		Random gerador = new Random();
		
		// variaveis para o menu
		int menu =  0, acao= 0;
		
		
		//Variaveis para calculos e gradar informação 
		int		
				quantNumero = 0, // valor da quantidade de numeros que o usuario informar 
				maiorNumero = 0, // maior numero do vetor
				menorNumero = 0, // menor numero do vetor
				auxPrimo 	= 0, // Variavel de auxiliar  
				soma 		= 0, // valor de soma de todo o vetor 
				moda 		= 0, // Numero da moda do vetor
				quantModa 	= 0, // quantidade de vezes que se repete
				auxModa 	= 0; // Auxiliar para a verificar 
        float 
        		media 		= 0, // Valor de media dos numeros 
        		mediana		= 0, // Valor da mediana 
        		variancia 	= 0, // Variancia dos numeros
        		desvioPadrao= 0; //	Valor do desvio Padrao
        String
        		listaNumImpar	= "",// Lista dos numeros Impares 
        		listaNumPar  	= "", // Lista dos numeros Pares 
        		listaNumPrimos	= "";// Lista dos numerosPrimos
		
		//Criando a variavel vetor
		int vetorNumeros[] = null;
		
		
		System.out.println("Bem vindo  ao sistema de Numeros");
		
		
		while (menu != -1){
			
			if(menu == 0 && acao == 0 ) {
				
				System.out.println("_____MENU_____\n"
						+ "1 - Informe a quantidade de numero\n"
						+ "2 - Mostrar vetor \n"
						+ "3 - Ver os resultados\n"
						+ "4 - sair ");
				System.out.println("Digite o que deseja realizar: ");
				menu = entrada.nextInt();
				
				while (menu  <= 0  || menu >= 5) {
					System.out.println("Opição invalida! Digite uma opição valida!");
					System.out.println("_____MENU_____\n"
							+ "1 - Informe a quantidade de numero\n"
							+ "2 - Mostrar vetor \n"
							+ "3 - Ver os resultados\n"
							+ "4 - sair ");
					System.out.println("Digite o que deseja realizar: ");
					menu = entrada.nextInt();
					
					
				}
				
			}
			//Populando e criando o vetor e calculando
			else if(menu == 0 && acao == -1 ) {
				
			  
				vetorNumeros= new int[quantNumero];
		        for (int x = 0; x < quantNumero; x++) {
		            vetorNumeros[x] = gerador.nextInt(maximoAle);
		        }
			
		        
		        //Realizando a ordenação 
		        for (int i = 1; i <  vetorNumeros.length; i++) {
		            for (int j = 0; j < i; j++) {
		                if (vetorNumeros[i] < vetorNumeros[j]) {
		                    int temp = vetorNumeros[i];
		                    vetorNumeros[i] = vetorNumeros[j];
		                    vetorNumeros[j] = temp;
		                }
		            }
		        }
		        
		        
			
		        for (int x = 0; x < quantNumero; x++) {
		            
		            //--------------------
		            //Maior e menor numero
		            if (x == 0) {
		                maiorNumero = vetorNumeros[x];
		                menorNumero = vetorNumeros[x];
		            } else {
		                if (maiorNumero < vetorNumeros[x]) {
		                    maiorNumero = vetorNumeros[x];
		                }
		                if (menorNumero > vetorNumeros[x]) {
		                    menorNumero = vetorNumeros[x];
		                }
		            }
		            //--------------------
		            //lista  do impar
		            if (vetorNumeros[x] % 2 != 0) {
		                listaNumImpar = listaNumImpar + "  " + vetorNumeros[x] + "  - ";
		            } 
		            //--------------------
		            //lista do Par
		            else if (vetorNumeros[x] % 2 == 0) {
		                listaNumPar = listaNumPar + "  " + vetorNumeros[x] + "  - ";
		            }
		            //--------------------
		            //lista dos numeros primos
		            for (int j = 2; j < vetorNumeros[x]; j++) {
		                if (vetorNumeros[x] % j == 0) {
		                    auxPrimo++;
		                }
		            }
		            if (auxPrimo == 0) {
		                listaNumPrimos = listaNumPrimos + " " + vetorNumeros[x] + " - ";
		            }
		            auxPrimo = 0;
		            //--------------------
		            //--------------------
		            //Soma
		            soma = soma + vetorNumeros[x];
		            //--------------------
		            //Moda
		            for (int i = 0; i < quantNumero; i++) {
		                if (vetorNumeros[x] == vetorNumeros[i]) {
		                    auxModa++;
		                }
		            }
		            if (auxModa > 1 && auxModa > quantModa) {
		                quantModa = auxModa;
		                moda = vetorNumeros[x];
		            }
		            auxModa = 0;
			          //--------------------
			        }
			        
			        //Mediana para par
			        if (vetorNumeros.length %2 ==0){
			              mediana=(vetorNumeros[(vetorNumeros.length/2)-1]+ vetorNumeros[(vetorNumeros.length/2)])/2;
			        }
			         //Mediana para impar
			        else{
			            mediana=vetorNumeros[(vetorNumeros.length/2)];
			        }
			        
			        //--------------------
			        //Media 
			         media = (float)soma/quantNumero;
			        //--------------------
			        // para calcular a variancai lendo todo o vetor novamente
			        for (int x = 0; x < quantNumero; x++) {
			           variancia= variancia + ((media -vetorNumeros[x])*(media -vetorNumeros[x] ));
			          
			          }
			        
			        variancia=(float)variancia/vetorNumeros.length;
			        //----------------------
			        //Desvio padrão 
			        desvioPadrao= (float) Math.sqrt(variancia);
			        //----------------------
			        acao = 0;
			        
			}
			
			// Definindo o tamanho do vetor
			else if(menu == 1) {
				System.out.println("Digite a quantidade de numeros que deseja : ");
		        quantNumero = entrada.nextInt();

		        while (quantNumero <= 0) {
		            System.out.println("Esse valor não pode ser executado!\n"
		                    + "Digite um numero valido acima de 0");
		            quantNumero = entrada.nextInt();
		        }
		        
		        System.out.println("Definido a quantidade em : " + quantNumero);
		        
		       
		        
		        menu =  0;
		        acao = -1;
			}
			// Mostrando o vetor
			else if(menu == 2) {
				if(quantNumero == 0) {
					System.out.println("Não foi definido o tamanho do vetor!\n");
					menu = 0;
				}
				else {
				      //mostrar vetor linh a linha 
				       System.out.println("____Vetor____");
				       for (int i = 0; i < vetorNumeros.length; i++) {
				       System.out.println(vetorNumeros[i]);
				       }	
				       
				}
				menu=0;
			}
			//Mostrando os calculos
			else if(menu == 3 ) {
				if(quantNumero == 0) {
					System.out.println("Não foi definido o tamanho do vetor!\n");
					menu = 0;
				}
				
				else {
				
				// Menu para os resultados
				acao = 0;	
				while (acao != 12) {
					switch (acao) {
					case 0 :{
						System.out.println("_____MENU DOS CALCULOS/LISTAS_____\n"
								+ "1 - 	Maior numero\n"
								+ "2 - 	Menor numero \n"
								+ "3 - 	Soma dos Numeros\n"
								+ "4 - 	Media dos Numeros\n"
								+ "5 - 	Lista dos numeros Pares\n"
								+ "6 - 	Lista dos numeros Impares\n"
								+ "7 -	Lista dos numeros Primos\n"
								+ "8 -	Mediana dos numeros\n"
								+ "9 -	Variancia dos Numeros\n"
								+ "10 - Desvio padrao dos Numeros\n"
								+ "11 - Todas as informaçoes\n"
								+ "12 - sair ");
						System.out.println("Digite o que deseja realizar: ");
						acao = entrada.nextInt();
						System.out.println(acao);
						
						while (acao  <= 0  || menu > 12 ) {
							System.out.println("Opição invalida! Digite uma opição valida!");
							System.out.println("_____MENU DOS CALCULOS/LISTAS_____\n"
									+ "1 - 	Maior numero\n"
									+ "2 - 	Menor numero \n"
									+ "3 - 	Soma dos Numeros\n"
									+ "4 - 	Media dos Numeros\n"
									+ "5 - 	Lista dos numeros Pares\n"
									+ "6 - 	Lista dos numeros Impares\n"
									+ "7 -	Lista dos numeros Primos\n"
									+ "8 -	Mediana dos numeros\n"
									+ "9 -	Variancia dos Numeros\n"
									+ "10 - Desvio padrao dos Numeros\n"
									+ "11 - Todas as informaçoes\n"
									+ "12 - sair ");
							System.out.println("Digite o que deseja realizar: ");
							acao = entrada.nextInt();
						
						}
						break;
					}
					case 1: {
						System.out.println("------------");
						System.out.println("Maior numero: " + maiorNumero);
						acao=0;
						break;
					}
					case 2: {
						System.out.println("------------");
						System.out.println("Menor numero: " + menorNumero);
						acao=0;
						break;
					}
					case 3: {
						System.out.println("------------");
						System.out.println("Soma numero: " + soma);
						acao=0;
						break;
					}
					case 4:{
						System.out.println("------------");
						System.out.println("Media numero: " + media);
						acao=0;
						break;
					}
					case 5:{
						System.out.println("------------");
						System.out.println("Lista dos numeros par: " + listaNumPar);
						acao=0;
						break;
					}
					case 6:{
						System.out.println("------------");
						System.out.println("Lista dos numeros impar: " + listaNumImpar);
						acao=0;
						break;
					}
					case 7:{
						System.out.println("------------");
						System.out.println("Lista dos numeros primos: " + listaNumPrimos);
						acao=0;
						break;
					}
					case 8:{
						System.out.println("------------");
						System.out.println("Mediana numero: " + mediana);
						acao=0;
						break;
					}
					case 9:{
						System.out.println("------------");
						System.out.println("Variância numero: " + variancia);
						acao=0;
						break;
					}
					case 10:{
						System.out.println("------------");
						System.out.println("Desvio padrao numero: " + desvioPadrao);
						acao=0;
						break;
					}
					case 11:{
						System.out.println("____Resultados: ____");
						System.out.println("Maior numero: " + maiorNumero);
					    System.out.println("Menor numero: " + menorNumero);
				        System.out.println("Soma numero: " + soma);
				        System.out.println("Media numero: " + media);
				        System.out.println("Mediana numero: " + mediana);
				        System.out.println("Moda numero: " + moda);
				       
				        System.out.println("Lista dos numeros impar: " + listaNumImpar);
				        System.out.println("Lista dos numeros par: " + listaNumPar);
				        System.out.println("Lista dos numeros primos:  " + listaNumPrimos);
				        System.out.println("Variância numero: " + variancia);
				        System.out.println("Desvio padrao numero: " + desvioPadrao);
				        System.out.println("____Vetor____");
					       for (int i = 0; i < vetorNumeros.length; i++) {
					       System.out.print(vetorNumeros[i] + " - ");
					       }	
				        System.out.println();
					    acao = 0;
				        break;
				        
					}
					case 12:{
						menu = 0;
						acao=12;
						break;
					}
					 default:{
						 acao=0;
					 	break;
					 }
					}
				
				}
				menu = 0;
				acao = 0;
				
			}
				
		}
			else if(menu == 4) {
				System.out.println("_____SAIR_____\n"
						+ "Deseja realmente sair do sistema?");
						
				System.out.println("Digite Sim ou Não ");
				String sair= entrada.next();
				System.out.println(sair);
				if(sair.equals("sim") || sair.equals("Sim") || sair.equals("SIM")) {
					menu = -1;
					System.out.println("Agradeço a utilização\n"
									+ "Tenha uma ótima semana");
				}
				else {
					System.out.println("Voltando ao menu inicial");
					menu = 0;
				}
				
			}
		
		
		}
		

		
		entrada.close();
	}

}
