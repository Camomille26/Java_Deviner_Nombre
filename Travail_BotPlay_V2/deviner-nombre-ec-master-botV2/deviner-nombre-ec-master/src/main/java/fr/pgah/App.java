package fr.pgah;

import java.util.Random;
import java.util.Scanner;

public final class App {

  public static void main(String[] args) {

    boolean onContinue = true;

    while (onContinue) {

      lancerJeu();

      onContinue = demanderSiOnContinue();
    }
  }

  private static boolean demanderSiOnContinue() {
    // Demander à l'utilisateur s'il veut continuer
    boolean onContinue = true;
    System.out.print("Voulez-vous continuer (O/N) ? ");
    Scanner sc = new Scanner(System.in);
    String reponse = sc.nextLine();

    reponse = reponse.toLowerCase();
    if (!reponse.equals("o")) {
      onContinue = false;
    }

    return onContinue;
  }

  public static void lancerJeu() {
    // 1. Générer le nombre à deviner

    boolean tentative = true; // création variable compteur d'essais
    int essais = 0; // nombre de tentative dans le jeu
    int test = 0;
    int save = 0;
    int savemax = 100;
    int savemin = 1;
    int NombreJoueur = 0;

    Random rand = new Random();
    int nombreADeviner = rand.nextInt(100) + 1;

    // 2. Afficher Message de bienvenue

    System.out.println("Vous devez deviner un nombre entre 1 et 100.");

    // 3. Proposer d'entrer un nombre

    while (tentative) {

      essais = essais + 1;

      System.out.print("Entrez votre nombre : ");

      // 4. Récupérer le nombre du joueur

      if (test == 0) {
        Random Bot = new Random();
        NombreJoueur = Bot.nextInt(100) + 1;
      }

      // random.nextInt(max - min + 1) + min

      if (test == 1) {
          Random Bot = new Random();
          NombreJoueur = Bot.nextInt(savemax - savemin + 1) + savemin;
        
      }

      // 5. Comparer le nombre du joueur avec le nombre à deviner
      // et afficher le résultat

      save = NombreJoueur;

      if (nombreADeviner == NombreJoueur) {
        System.out.println("Le bot a gagné !");
        System.out.println("Le nombre était " + nombreADeviner);
        tentative = false;
      } else {
        int difference = nombreADeviner - NombreJoueur;
        if (difference < 0) {
          System.out.println("Nombre jouer par le bot : " + NombreJoueur);
          System.out.println("Le nombre à deviner est plus petit");
          System.out.println("Le bot a joué " + essais + " tentative");
          test = 1;
          savemax = save;
        } else {
          System.out.println("Nombre jouer par le bot : " + NombreJoueur);
          System.out.println("Le nombre à deviner est plus grand");
          System.out.println("Le bot a joué " + essais + " tentavite");
          test = 1;
          savemin = save;
        }

      }

    }

  }

}
