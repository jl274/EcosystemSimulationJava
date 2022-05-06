**Project in early development**

# Ecosystem simulation project info
1. [Project info](#project-info)
    * [Technology](#technology)
    * [Aim](#aim)
2. [Board](#meadow-board)
3. [Animals](#animals)
    * [General concept](#general-concept)
    * [Carnivorous concept](#carnivorous-animal)
4. [Plants](#plants)
    * [General concept](#general-concept-plants)

# Project info

## Technology
* @Author : [jl274](https://github.com/jl274)
* @JavaVersion : 17
* @Libraries:
    * lombok
    * junit

## Aim
Simulation of small ecosystem with meadow-board, some animals and plants that can reproduce etc. in Java,
visualised using emojis.

# Meadow-Board
Board is 2 dimension matrix in Meadow class.

Info:
* emoji: 🟩


# Animals

## General concept

Animal - asbtract class for animals.

Properties:
* timesAteToReproduce - how many times need to eat in order to reproduce
* ate - how many times it ate without reproducing
* endurance - how many rounds can go without eating before dying
* health - currenct health level, if 0 - it dies

Methods:
* reproduce - abstract reproduction which result is new Animal of the same type
* eat - abstract eating method of some MeadowBoard object that should 
  affect some other properties and may result in reproducing

## Carnivorous animal
Carnivorous - abstract class for carnivorous animals

Methods:
* eatAnimal - abstract eating method only pre-defining that other Animal is what have to be eaten
* eat - is implemented to use eatAnimal, throws exception otherwise

## Herbivorous animal
Herbivorous - abstract class for Herbivorous animals

Methods:
* eatPlant - abstract eating method only pre-defining that Plant is what have to be eaten
* eat - is implemented to use eatPlant, throws exception otherwise

# Plants

## General concept plants

Plant  - abstract class for plants.

Properties:
* roundsToReproduce - round without being eaten needed in order to force reproduce
* rounds - counts rounds without being eaten
* reproduceChange - change to reproduce in each turn in %

Method:
* reproduce - abstract reproduction that creates new identical Plant
