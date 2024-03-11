import java.io.*;
import java.util.*;

public class Main{
    static Scanner t = new Scanner(System.in);
    public static void main(String[] args) {
        //Menu
        String nomeFile,nome;

        int eta, scelta=0,num=0,nextCase=0;
        double peso;
        ArrayList<Animale> animali = new ArrayList<>();
        do {
            System.out.println("1.Scrivere in un file ");
            System.out.println("2.Leggere da un file ");
            System.out.println("3.Classifica dei animali");
            System.out.println("0.Uscire");
            scelta=t.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome del file ");
                    nomeFile = t.next();

                    ObjectOutputStream outputStream = null;
                    try {
                        outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
                    } catch (IOException e) {
                        System.out.println("Errore nell'apertura del file di output " + nomeFile + ".");
                        System.exit(0);
                    }
                    System.out.println("Inserisci un numero arbitrario di registrazioni ");
                    num = t.nextInt();
                    for (int i = 0; i < num; i++) {

                        System.out.println("Inserisci nome ");
                        nome = t.next();
                        System.out.println("Inserisci eta ");
                        eta = t.nextInt();
                        System.out.println("Inserisci peso");
                        peso = t.nextDouble();
                        Animale animal = new Animale(nome, eta, peso);
                        try {
                            outputStream.writeObject(animal);
                        } catch (IOException e) {
                            System.out.println("Errore nella scrittura del file " + nomeFile + ".");
                            System.exit(0);
                        }
                    }
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        System.out.println("Errore di chiusura file");
                    }


                    break;
                case 2:
                    System.out.println("Inserisci nome del file ");
                    nomeFile = t.next();
                    ObjectInputStream inputStream = null;
                    try {
                        inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
                    } catch (IOException e) {
                        System.out.println("Errore nell'apertura del file di output " + nomeFile + ".");
                        System.exit(0);
                    }
                    Animale outputFile = null;
                    while (true) {
                        try {
                            outputFile = (Animale) inputStream.readObject();
                        } catch (Exception e) {
                            break;
                        }
                        System.out.println("\n" + outputFile);
                        animali.add(outputFile);
                    }
                    nextCase=1;

                    break;
                case 3:
                    if(nextCase==1) {
                        Animale unoanimale, piuleggero = animali.get(0), piuvecchio = animali.get(0), piugiovane = animali.get(0), piupesante = animali.get(0);
                        for (int i = 0; i < animali.size(); i++) {
                            unoanimale = animali.get(i);
                            if (unoanimale.getEta() > piuvecchio.getEta())
                                piuvecchio = unoanimale;

                            if (unoanimale.getEta() < piugiovane.getEta())
                                piugiovane = unoanimale;

                            if (unoanimale.getPeso() < piuleggero.getPeso())
                                piuleggero = unoanimale;

                            if (unoanimale.getPeso() > piupesante.getPeso())
                                piupesante = unoanimale;
                        }

                        System.out.println("\nPiù vecchio : " + piuvecchio);
                        System.out.println("\nPiù giovane: " + piugiovane);
                        System.out.println("\nPiù pesante: " + piupesante);
                        System.out.println("\nPiù leggero: " + piuleggero);
                        System.out.println("\n");
                    }
                    else
                        System.out.println("Prima devi leggere file");
                    break;
            }

        }while (scelta!=0);
    }

}
