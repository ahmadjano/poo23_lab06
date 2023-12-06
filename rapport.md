# Rapport Labo 6 - Calculatrice

Jano Ahmad
&
Richard Aurélien

## Introduction

Ce rapport présente notre projet de calculatrice en Java. L'objectif principal était de concevoir une calculatrice fonctionnelle en utilisant les principes de la programmation orientée objet. Inclus dans le rapport: le code source du projet, un diagramme UML de classes pour illustrer la structure du programme, ainsi que les détails des tests effectués pour assurer la fiabilité de notre application graphique et en mode CLI.

## Structure du code

### Diagramme de Classes UML

Le diagramme de classes UML ci-dessous illustre la structure des classes dans notre projet Calculatrice, offrant une vue claire sur les relations entre celles-ci.

![](uml.png)

### Fonctionalités

#### Classe `Jcalculatrice`

La classe principale, Matrix, offre deux constructeurs permettant de créer des matrices avec des spécifications particulières. La première prend des lignes spécifiées en argument, tandis que la seconde génère une matrice aléatoire en fonction du nombre de colonnes et de lignes souhaité.

La classe Matrix propose des méthodes pour effectuer les opérations matricielles de base telles que l'addition, la soustraction et la multiplication. Ces opérations sont effectuées en tenant compte d'un modulo spécifié, assurant la cohérence des résultats.

#### Interface `Operator`

L'interface `Operable` joue un rôle central dans notre conception, permettant d'abstraire les opérations matricielles. Cette interface définit une méthode `int perform(int v1, int v2)` qui prend deux valeurs en paramètres et retourne le résultat de l'opération appliquée à ces valeurs.

Cette abstraction permet une flexibilité considérable, car toute classe qui implémente cette interface peut être utilisée dans le contexte des opérations matricielles. Cela favorise une extension facile du code pour de nouvelles opérations.

Exemple d'implémentation :

```java
package org.example;

public class Addition implements Operable {
    @Override
    public int perform(int v1, int v2) {
        return v1 + v2;
    }
}
```

## Tests

### Fonction testProgram() dans main

Nous avons créé une fonction de test, testProgram(), conforme aux spécifications du laboratoire. Cette fonction prend en paramètres les dimensions (N1, M1, N2, M2) ainsi qu'un modulo. Elle génère ensuite deux matrices aléatoires de tailles respectives N1 x M1 et N2 x M2 avec un modulo commun. Les opérations entre ces matrices sont affichées à chaque étape du processus.

![testProgram() output](image-1.png)

### Tests unitaires

Pour garantir une évaluation complète de notre code, nous avons intégré des tests unitaires à l'aide de la bibliothèque JUnit. Ces tests couvrent différentes fonctionnalités de la classe Matrix :

![Alt text](image-3.png)

Les tests effectués sont :

- Subtract() : Soustrait une matrice à une autre
- Add() : Additionne une matrice à une autre
- Multiply(): Multiplie une matrice à une autre
- Equals() : compare deux matrices
- shouldThrowWhenModulusNotEquals() : Teste lorsque les modulo ne sont pas égaux
- shouldThrowWhenRowsNotEquals() : Teste lorsque les lignes n'ont pas la même longueur dans une matrice
