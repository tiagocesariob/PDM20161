package pdm.ifpb.edu.br.projetotiago;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiago on 21/06/2016.
 */
public class Local {
    private List<Lugar> lugar;

    public Local() {
        this.lugar = new ArrayList<Lugar>();
    }

    public void add(Lugar sh){this.lugar.add(sh);
    }

    public int getQuantidade(){
        return this.lugar.size();
    }

    public void delete(int index){
        this.lugar.remove(index);
    }

    public List<Lugar> get(){
        return this.lugar;
    }

    public Lugar get(int index){
        return this.lugar.get(index);
    }
}

