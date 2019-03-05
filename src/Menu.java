
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class Menu {

    public void menu() {
        IElevadorService i = new IElevadorService();
        ArrayList<Elevador> arrayElevadores = new ArrayList<>();
        LerCriarJson lCJSON = new LerCriarJson();
        Scanner tec = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - cadastrar \n"
                    + "2 - adicionar um arquivo JSON\n"
                    + "3 - ver o andar menos usado\n"
                    + "4 - ver o elevador mais usado e o turno que ele é mais usado\n"
                    + "5 - ver o elevador menos usado e o turno que ele é menos usado\n"
                    + "6 - ver o periodo de maior utilização dos elevadores\n"
                    + "7 - ver a porcentegem total da utilização !versão beta!\n"
                    + "8 - Mostrar todos\n"
                    + "9 - gerar json !versão beta!\n"
                    + "0 - sair\n");

            opcao = tec.nextInt();
            switch (opcao) {
                case 1:
                    Elevador e = new Elevador();
                    System.out.println("Qual elevador?");
                    e.setElevador(tec.next());
                    System.out.println("Qual andar?");
                    e.setAndar(tec.nextInt());
                    System.out.println("Qual turno?");
                    e.setTurno(tec.next());
                    arrayElevadores.add(e);
                    break;
                case 2:
                    System.out.println("Digite o nome do arquivo json sem a estenção");
                    lCJSON.lerJson(arrayElevadores, tec.next());
                    break;
                case 3:
                    System.out.println(i.andarMenosUtilizado(arrayElevadores));
                    break;
                case 4:
                    System.out.println(i.elevadorMaisUtilizadoPorTurno(arrayElevadores));
                    break;
                case 5:
                    System.out.println(i.elevadorMenosUsadoPorTurno(arrayElevadores));
                    break;
                case 6:
                    System.out.println(i.periodoDeMaiorUtilizacao(arrayElevadores));
                    break;
                case 7:
                    System.out.println(i.percentualDeUsoDosElevadores(arrayElevadores));
                    break;
                case 8:
                    for (int x = 0; x < arrayElevadores.size(); x++) {
                        System.out.println(arrayElevadores.get(x));
                    }
                    break;
                case 9:
                    System.out.println("Digite o nome do novo arquivo json sem a extenção");
                    lCJSON.criarJson(arrayElevadores, tec.next());
                    break;
                case 0:
                    break;
            }

        } while (opcao != 0);

    }
}
