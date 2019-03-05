
import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class IElevadorService {

    public int andarMenosUtilizado(ArrayList<Elevador> arrayElevadores) {
        int menosUsado = 0;
        int[] andarMenosUsado = new int[16];

        //contar os votos de cada andar
        for (int i = 0; i < arrayElevadores.size(); i++) {

            switch (arrayElevadores.get(i).getAndar()) {

                case 0:
                    andarMenosUsado[0] = andarMenosUsado[0] + 1;
                    break;
                case 1:
                    andarMenosUsado[1] = andarMenosUsado[1] + 1;
                    break;
                case 2:
                    andarMenosUsado[2] = andarMenosUsado[2] + 1;
                    break;
                case 3:
                    andarMenosUsado[3] = andarMenosUsado[3] + 1;
                    break;
                case 4:
                    andarMenosUsado[4] = andarMenosUsado[4] + 1;
                    break;
                case 5:
                    andarMenosUsado[5] = andarMenosUsado[5] + 1;
                    break;
                case 6:
                    andarMenosUsado[6] = andarMenosUsado[6] + 1;
                    break;
                case 7:
                    andarMenosUsado[7] = andarMenosUsado[7] + 1;
                    break;
                case 8:
                    andarMenosUsado[8] = andarMenosUsado[8] + 1;
                    break;
                case 9:
                    andarMenosUsado[9] = andarMenosUsado[9] + 1;
                    break;
                case 10:
                    andarMenosUsado[10] = andarMenosUsado[10] + 1;
                    break;
                case 11:
                    andarMenosUsado[11] = andarMenosUsado[11] + 1;
                    break;
                case 12:
                    andarMenosUsado[12] = andarMenosUsado[12] + 1;
                    break;
                case 13:
                    andarMenosUsado[13] = andarMenosUsado[13] + 1;
                    break;
                case 14:
                    andarMenosUsado[14] = andarMenosUsado[14] + 1;
                    break;
                case 15:
                    andarMenosUsado[15] = andarMenosUsado[15] + 1;
                    break;
            }

        }

        //ver o andar menos votado
        for (int i = 0; i <= 15; i++) {
            for (int j = i + 1; j <= 15; j++) {

                if (andarMenosUsado[i] <= andarMenosUsado[j]
                        && andarMenosUsado[i] <= andarMenosUsado[menosUsado]) {
                    menosUsado = i;
                } else if (andarMenosUsado[i] >= andarMenosUsado[j]
                        && andarMenosUsado[j] <= andarMenosUsado[menosUsado]) {
                    menosUsado = j;
                }
            }
        }

        return menosUsado;

    }

    public String elevadorMaisUtilizadoPorTurno(ArrayList<Elevador> arrayElevadores) {
        int[] elevadorMaisUsado = new int[5];
        int[] maisUsadoPorTurno = new int[3];
        String turnoMaisUsado = "M";
        String elevador = "";
        int maisUsado = 0;

        //contabilizar os votos de cada elevador
        for (int i = 0; i < arrayElevadores.size(); i++) {

            switch (arrayElevadores.get(i).getElevador()) {
                case "A":
                    elevadorMaisUsado[0] = elevadorMaisUsado[0] + 1;
                    break;
                case "B":
                    elevadorMaisUsado[1] = elevadorMaisUsado[1] + 1;
                    break;
                case "C":
                    elevadorMaisUsado[2] = elevadorMaisUsado[2] + 1;
                    break;
                case "D":
                    elevadorMaisUsado[3] = elevadorMaisUsado[3] + 1;
                    break;
                case "E":
                    elevadorMaisUsado[4] = elevadorMaisUsado[4] + 1;
                    break;

            }

        }

        //ver qual elevador resebeu mais votos
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {

                if (elevadorMaisUsado[i] >= elevadorMaisUsado[j]
                        && elevadorMaisUsado[i] >= elevadorMaisUsado[maisUsado]) {
                    maisUsado = i;
                } else if (elevadorMaisUsado[i] <= elevadorMaisUsado[j]
                        && elevadorMaisUsado[j] >= elevadorMaisUsado[maisUsado]) {
                    maisUsado = j;
                }
            }
        }

        //ver qual foi o mais votado
        switch (maisUsado) {
            case 0:
                elevador = "A";
                break;
            case 1:
                elevador = "B";
                break;
            case 2:
                elevador = "C";
                break;
            case 3:
                elevador = "D";
                break;
            case 4:
                elevador = "E";
                break;
        }

        maisUsado = 0;

        //ver qual e o turno que mais utilizam o mais votado
        //contabilizado os votos dos turnos
        for (int i = 0; i < arrayElevadores.size(); i++) {

            if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("m")) {
                maisUsadoPorTurno[0] = maisUsadoPorTurno[0] + 1;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("v")) {
                maisUsadoPorTurno[1] = maisUsadoPorTurno[1] + 1;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("n")) {
                maisUsadoPorTurno[2] = maisUsadoPorTurno[2] + 1;
            }

        }
        //vendo qual o turno que recebeu mais votos
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {

                if (maisUsadoPorTurno[i] >= maisUsadoPorTurno[j]
                        && maisUsadoPorTurno[i] >= maisUsadoPorTurno[maisUsado]) {
                    maisUsado = i;
                } else if (maisUsadoPorTurno[i] <= maisUsadoPorTurno[j]
                        && maisUsadoPorTurno[j] >= maisUsadoPorTurno[maisUsado]) {
                    maisUsado = j;
                }
            }
        }
        //contabilizado os votos dos turnos
        if (maisUsado == 1) {
            turnoMaisUsado = "V";
        } else if (maisUsado == 2) {
            turnoMaisUsado = "N";
        }

        return "O elevador mais utilizado é: " + elevador + ", no turno  da: "
                + turnoMaisUsado;
    }

    public String elevadorMenosUsadoPorTurno(ArrayList<Elevador> arrayElevadores) {
        int[] elevadorMenosUsado = new int[5];
        int[] menosUsadoPorTurno = new int[3];
        String turnoMenosUsado = "M";
        String elevador = " ";
        int menosUsado = 0;

        //contabilizar os votos de cada elevador
        for (int i = 0; i < arrayElevadores.size(); i++) {

            switch (arrayElevadores.get(i).getElevador()) {

                case "A":
                    elevadorMenosUsado[0] = elevadorMenosUsado[0] + 1;
                    break;
                case "B":
                    elevadorMenosUsado[1] = elevadorMenosUsado[1] + 1;
                    break;
                case "C":
                    elevadorMenosUsado[2] = elevadorMenosUsado[2] + 1;
                    break;
                case "D":
                    elevadorMenosUsado[3] = elevadorMenosUsado[3] + 1;
                    break;
                case "E":
                    elevadorMenosUsado[4] = elevadorMenosUsado[4] + 1;
                    break;

            }

        }

        //vendo o elevador que recebeu menos votos
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {

                if (elevadorMenosUsado[i] <= elevadorMenosUsado[j]
                        && elevadorMenosUsado[i] <= elevadorMenosUsado[menosUsado]) {
                    menosUsado = i;
                } else if (elevadorMenosUsado[i] >= elevadorMenosUsado[j]
                        && elevadorMenosUsado[j] <= elevadorMenosUsado[menosUsado]) {
                    menosUsado = j;
                }
            }
        }

        //vendo qual elevador foi o menos votado
        switch (menosUsado) {
            case 0:
                elevador = "A";
                break;
            case 1:
                elevador = "B";
                break;
            case 2:
                elevador = "C";
                break;
            case 3:
                elevador = "D";
                break;
            case 4:
                elevador = "E";
                break;
        }

        //ver qual e o turno que menos utilizam o elevador menos votado
        //contabilizando os votos dos turnos
        for (int i = 0; i < arrayElevadores.size(); i++) {

            if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("M")) {
                menosUsadoPorTurno[0] = menosUsadoPorTurno[0] + 1;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("V")) {
                menosUsadoPorTurno[1] = menosUsadoPorTurno[1] + 1;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("N")) {
                menosUsadoPorTurno[2] = menosUsadoPorTurno[2] + 1;
            }

        }

        menosUsado = 0;

        //vendo qual turno recebeu menos votos
        for (int i = 0; i < menosUsadoPorTurno.length; i++) {
            for (int j = i + 1; j < menosUsadoPorTurno.length; j++) {

                if (menosUsadoPorTurno[i] <= menosUsadoPorTurno[j]
                        && menosUsadoPorTurno[i] <= menosUsadoPorTurno[menosUsado]) {
                    menosUsado = i;
                } else if (menosUsadoPorTurno[i] >= menosUsadoPorTurno[j]
                        && menosUsadoPorTurno[j] <= menosUsadoPorTurno[menosUsado]) {
                    menosUsado = j;
                }
            }
        }

        //vendo qual elevador foi menos votado
        if (menosUsado == 1) {
            turnoMenosUsado = "V";
        } else if (menosUsado == 2) {
            turnoMenosUsado = "N";
        }

        return "O elevador menos utilizado é: " + elevador + ", no turno  da: "
                + turnoMenosUsado;
    }

    public String periodoDeMaiorUtilizacao(ArrayList<Elevador> arrayElevadores) {
        int utilizacaoPorTurnos[] = new int[3];
        int somaTorioDosTurnos = 0;
        String turnoMaisUsado = "M";

        //contabilizado o turno mais votado
        for (int i = 0; i < arrayElevadores.size(); i++) {

            if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("m")) {
                utilizacaoPorTurnos[0]++;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("v")) {
                utilizacaoPorTurnos[1]++;
            } else if (arrayElevadores.get(i).getTurno().equalsIgnoreCase("n")) {
                utilizacaoPorTurnos[2]++;
            }
        }
        //contabilizando os votado
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {

                if (utilizacaoPorTurnos[i] >= utilizacaoPorTurnos[j]
                        && utilizacaoPorTurnos[i] >= utilizacaoPorTurnos[somaTorioDosTurnos]) {
                    somaTorioDosTurnos = i;
                } else if (utilizacaoPorTurnos[i] <= utilizacaoPorTurnos[j]
                        && utilizacaoPorTurnos[j] >= utilizacaoPorTurnos[somaTorioDosTurnos]) {
                    somaTorioDosTurnos = j;
                }
            }
        }
        //descobrindo qual o turno mais votado
        if (somaTorioDosTurnos == 1) {
            turnoMaisUsado = "V";
        } else if (somaTorioDosTurnos == 2) {
            turnoMaisUsado = "N";
        }
        return turnoMaisUsado;
    }

    public String percentualDeUsoDosElevadores(ArrayList<Elevador> arrayElevadores) {
        double[] elevadorMaisUsado = new double[5];
        double[] percentagemUso = new double[5];

        for (int i = 0; i < arrayElevadores.size(); i++) {

            //atribui os votos de cada elevador
            switch (arrayElevadores.get(i).getElevador()) {

                case "A":
                    elevadorMaisUsado[0] = elevadorMaisUsado[0] + 1;
                    break;
                case "B":
                    elevadorMaisUsado[1] = elevadorMaisUsado[1] + 1;
                    break;
                case "C":
                    elevadorMaisUsado[2] = elevadorMaisUsado[2] + 1;
                    break;
                case "D":
                    elevadorMaisUsado[3] = elevadorMaisUsado[3] + 1;
                    break;
                case "E":
                    elevadorMaisUsado[4] = elevadorMaisUsado[4] + 1;
                    break;

            }
        }

        //calcula a procentegam de uso de cada elevador
        //não consegui almentar a precisão do resultado
        for (int i = 0; i < percentagemUso.length; i++) {
            percentagemUso[i] = (100 / arrayElevadores.size()) * elevadorMaisUsado[i];
            System.out.println(percentagemUso[i]);

        }

        return "Elevador a: " + percentagemUso[0] + "%"
                + "\nElevador b: " + percentagemUso[1] + "%"
                + "\nElevador c: " + percentagemUso[2] + "%"
                + "\nElevador d: " + percentagemUso[3] + "%"
                + "\nElevador e: " + percentagemUso[4] + "%";
    }
}
