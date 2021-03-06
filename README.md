**Project in early development**

# Ecosystem simulation project info
1. [Project info](#project-info)
    * [Technology](#technology)
    * [Aim](#aim)
2. [Board](#meadow-board)
3. [Animals](#animals)
    * [General concept](#general-concept)
    * [Carnivorous concept](#carnivorous-animal)
        * [Wolf](#wolf)
    * [Herbivorous concept](#herbivorous-animal)
        * [Sheep](#sheep)
4. [Plants](#plants)
    * [General concept](#general-concept-plants)
    * [Grass](#grass)

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

## Examples

Meadow can look like this after placing three grasses and one sheep:
```text
🌿	🌿	🌿	🐑	🟩	
🟩	🟩	🟩	🟩	🟩	
🟩	🟩	🟩	🟩	🟩	
🟩	🟩	🟩	🟩	🟩	
🟩	🟩	🟩	🟩	🟩
```


# Animals

## General concept

Animal - asbtract class for animals.

Properties:
* timesAteToReproduce - how many times need to eat in order to reproduce
* ate - how many times it ate without reproducing
* endurance - how many rounds can go without eating before reducing health
* roundsStarving - number of rounds animal haven't eat
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

### Wolf
Wolf details:
* timesAteToReproduce: 2
* endurance: 5
* health: 6
* emoji: 🐺
* reproduce(): new Wolf, but parent times needed to reproduce is raised to the power of two

## Herbivorous animal
Herbivorous - abstract class for Herbivorous animals

Methods:
* eatPlant - abstract eating method only pre-defining that Plant is what have to be eaten
* eat - is implemented to use eatPlant, throws exception otherwise

### Sheep
Sheep details:
* timesAteToReproduce: 6
* endurance: 2
* health: 2
* emoji: 🐑
* reproduce(): new Sheep has one more health point

# Plants

## General concept plants

Plant  - abstract class for plants.

Properties:
* roundsToReproduce - round without being eaten needed in order to force reproduce
* rounds - counts rounds without being eaten
* reproduceChange - change to reproduce in each turn in %

Method:
* reproduce - abstract reproduction that creates new identical Plant


## Grass
Grass details:
* roundsToReproduce: 4
* reproduceChange: 20%
* emoji: 🌿
