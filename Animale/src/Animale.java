import java.io.Serializable;
public class Animale  implements Serializable,Comparable<Animale>{
    private String nome;
    private int eta; //in anni
    private double peso; //in Kg
    public Animale() {
        nome = "Nessun nome";
        eta = 0;
        peso = 0;
    }
    public Animale (String nomeIniziale, int etaIniziale , double pesoIniziale) {
        nome = nomeIniziale;
        if ((etaIniziale < 0) || (pesoIniziale < 0)) {
            System.out.println("E rrore; età o peso negativi.");
            System.exit(0);
        } else {
            eta = etaIniziale;
            peso = pesoIniziale;
        }
    }
public Animale (String nomeIniziale){
    nome = nomeIniziale;
    eta = 0;
    peso = 0;
     }
public void setNome(String nuovoNome) {
    nome = nuovoNome;
}

public Animale(int etaIniziale ) {
    nome = "Nessun nome";
    peso = 0;
    if (etaIniziale < 0) {
        System.out.println("Errore: età' negativa.");
        System.exit(0);
    } else {
        eta=etaIniziale ;
    }
}



public Animale (double pesoIniziale) {
    nome = "Nessun nome";
    eta = 0;
    if (pesoIniziale < 0) {
        System.out.println("Errore: peso negativo.");
        System.exit(0);
    } else {
        peso = pesoIniziale;
    }
}
public void setPeso( double nuovoPeso) {
    if (nuovoPeso < 0) {
        System.out.println("Errore: peso negativo.");
        System.exit(0);
    } else {
        peso = nuovoPeso;
    }
}

public String getNome() {
    return nome;
}
public int getEta() {
    return eta;
}

public double getPeso() {
        return peso;
    }

@Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Nome: ").append(nome).append("\nEtà: ").append(eta).append(" anni").append("\nPeso: ").append(peso).append(" Kg");
    return sb.toString();
    }
@Override
public int compareTo(Animale o) {
    int i = o.getEta();
    return (int) (i - this.eta);
}

public int compareToPeso(Animale o) {
        double i = o.getEta();
        return (int) (i-this.eta);
    }

}