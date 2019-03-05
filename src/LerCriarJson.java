
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.api.scripting.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class LerCriarJson {

    public void lerJson(ArrayList<Elevador> arrayElevadores, String arquivo) {
        JSONParser parser = new JSONParser();

        try {
            ArrayList<JSONObject> jSonElevador = new ArrayList<>();
            Object obj = parser.parse(new FileReader(arquivo + ".json"));
            JSONArray jsonArray = (JSONArray) obj;
            jSonElevador.addAll(jsonArray);
            JSONObject jSonObject;
            for (int i = 0; i < jSonElevador.size(); i++) {
                Elevador e = new Elevador();
                jSonObject = ((JSONObject) jSonElevador.get(i));
                e.setElevador((String) jSonObject.get("elevador"));
                e.setAndar(Integer.parseInt("" + (Long) jSonObject.get("andar")));
                e.setTurno((String) jSonObject.get("turno"));
                arrayElevadores.add(e);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(LerCriarJson.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void criarJson(ArrayList<Elevador> arrayElevadores, String novo) {

        JSONArray jSONArray = new JSONArray();
        jSONArray.add(arrayElevadores);
        System.out.println(jSONArray.toString());
        try {
            FileWriter escrever = new FileWriter(novo + ".json");
            escrever.write(jSONArray.toJSONString());
            escrever.close();
        } catch (IOException e) {
        }

    }

}
