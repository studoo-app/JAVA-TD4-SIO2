package com.sio.javatd4sio2.tools;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswhordHasher {

    private final Argon2 argon2 = Argon2Factory.create();

    public String hashPassword(String password) {

        String hash = null;

        try {
            // Définir les paramètres d'Argon2
            int iterations = 3; //Nombre d'itérations (plus il est élevé, plus le hachage est lent et sécurisé, 2 ou 3 et ajustez en fonction des performances.).
            int memory = 65536; // Quantité de mémoire en KB utilisée par l'algorithme. (Plus la mémoire est élevée, plus le hachage est sécurisé mais nécessite plus de ressources.)
            int parallelism = 1; // Nombre de threads utilisés. (entre 1 et le nombre de cœurs CPU disponibles.)

            // Hacher le mot de passe
            hash = argon2.hash(iterations, memory, parallelism, password.toCharArray());
        } finally {
            // Effacer les données sensibles de la mémoire
            argon2.wipeArray(password.toCharArray());
        }
        return hash;
    }

    public boolean verifyPassword(String hash, String password) {
        boolean valid = false;
        try {
            valid = argon2.verify(hash, password.toCharArray());
        } finally {
            // Effacer les données sensibles de la mémoire
            argon2.wipeArray(password.toCharArray());
        }
        return valid;
    }
}
