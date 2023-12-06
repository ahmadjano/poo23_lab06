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

#### Classe `Stack`

La class `Stack` est la classe permettant le stockage en pile des valeurs.

Elle contient une classe interne `Node` qui permet de stocker et chainer des valeurs. `Node` va stocker la valeur donnée ainsi que le noeud suivant, cela permet de créer une chaîne de noeuds.

`Stack` va donc interagir avec les noeuds et va proposer des outils pour le faire. Elle va stocker le point de départ de la chaîne dans l'attribut `top` qui va correspondre au haut de la pile (une `Node`).

La classe met donc à disposition des outils pour interragir avec la pile, comme push(), pop() ou encore toArray().

#### Classe `State`

La classe `State` est le coeur de la calculatrice, c'est ici que les états et valeur vont être stockés.
Elle comprend plusieurs attributs dont la valeur courante, le stack, un état ainsi qu'une valeur stockée en mémoire.

Elle implémente un `Stack` afin de pouvoir stocker sur une pile les valeurs dont elle n'a besoin de suite (très courant dans la méthode RPN).

La valeur courante représente la valeur en cours d'utilisation alors que la valeur en mémoire représente une valeur stockée pour plus tard.

#### Interface `Operator`

L'interface `Operator` joue un rôle central dans notre conception, permettant d'abstraire les opérateurs qui interviendront dans la calculatrice. Cette interface définit une méthode `void execute()` qui va manipuler le State (que cela soit en intéragissant avec le stack, la valeur courante, la valeur en mémoire, etc...)

Exemple d'implémentation :

```java
package calculator;

/**
 * Power class
 */
public class Power extends Operator{
    private final int exponent;

    /**
     * Power constructor
     * @param state - State
     * @param exponent - Exponent for the power
     */
    public Power(State state, int exponent) {
        super(state);
        this.exponent = exponent;
    }

    /**
     * Execute method
     * Applies power to the current value
     */
    @Override
    public void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            double number = this.state.getCurrentValueAsDouble();
            number = Math.pow(number, this.exponent);
            this.state.setCurrentValueFromDouble(number);
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }
    }
}

```

#### Classe `Jcalculatrice`

La classe principale de la calculatrice graphique. Elle va construire l'application graphique en implémentant des JButton qui vont appeler des `Operator` et des JTextField et JTextList afin de tout fournir à l'utilisateur.
Elle a aussi un `State` qui va être le state principal.

#### Classe `Calculator`

Est une classe implémentant des `Operator` et un `State` permettant d'effectuer des opérations de calcul en CLI.

## Tests
