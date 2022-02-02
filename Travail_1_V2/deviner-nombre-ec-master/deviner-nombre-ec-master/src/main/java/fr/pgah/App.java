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

    boolean tentative = true; //création variable compteur d'essais
    int vie = 6; //nombre de tentative dans le jeu

    Random rand = new Random();
    int nombreADeviner = rand.nextInt(100) + 1;

    // 2. Afficher Message de bienvenue

    System.out.println("Vous devez deviner un nombre entre 1 et 100.");

    // 3. Proposer d'entrer un nombre

    while (tentative) {
      
      vie = vie - 1;

    System.out.print("Entrez votre nombre : ");

    // 4. Récupérer le nombre du joueur

    Scanner sc = new Scanner(System.in);
    int nombreJoueur = sc.nextInt();

    // 5. Comparer le nombre du joueur avec le nombre à deviner
    // et afficher le résultat


    if (nombreADeviner == nombreJoueur) {
      System.out.println("Vous avez gagné !");
      tentative = false;
    } else {
      int difference = nombreADeviner - nombreJoueur;
      if (difference < 0) {
        System.out.println("Le nombre à deviner est plus petit");
        System.out.println("Vous avez encore " + vie + " chance");
      } else {
        System.out.println("Le nombre à deviner est plus grand");
        System.out.println("Vous avez encore " + vie + " chance");
      }

    }

    if (vie == 0) {
      tentative = false;
      int difference = nombreADeviner - nombreJoueur;
      difference = Math.abs(difference);
      System.out.println("Perdu ! Je pensais à : " + nombreADeviner);
      System.out.println("Vous étiez à " + difference + " de la bonne réponse.");

    }

    }
  

}

}
