**Project in early development**

# Ecosystem simulation project info
1. [Project info](#project-info)
    * [Technology](#technology)
    * [Aim](#aim)
2. [Board](#meadow-board)
3. [Animals](#animals)
    * [General concept](#general-concept)

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

