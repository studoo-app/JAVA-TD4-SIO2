![separe](https://github.com/studoo-app/.github/blob/main/profile/studoo-banner-logo.png)
# TD 4 Java : Implémentation de l'authentification
[![Version](https://img.shields.io/badge/Version-2024-blue)]()

## Objectifs

Finir d'implémenter une authentification persistante dans l'application dont les utilisateurs sont stockés dans une base de données MariaDB.

## Démarrage du conteneur MariaDB
- `docker compose up -d`

## Missions

- Retrouver l'utilisateur en base de données depuis le formulaire de connexion
- Trouver un moyen de stocker l'utilisateur connecté
- Implémenter un moyen de déconnecter l'utilisateur
- Trouver un moyen de sécuriser les mots de passes utilisateurs contenus pour le moment en clair dans la base de données