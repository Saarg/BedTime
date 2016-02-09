# Plugin minecraft BedTime
BedTime est un plugin très basique devellopé pour les serveurs craftbukkit/spigot. Il permet de passer la nuit si X% des joueurs sont dans un lit avec X pouvant etre changé avec une comande.

##### Le code n'est plus mis a jours!

# Les commandes
## activer le plugin in game
'''/bedtime enable'''

## desactiver le plugin in game
'''/bedtime disable'''

## choisir le % de joueurs devant etre dans un lit
'''/bedtime percent x'''

## remettre le nombre de joueurs dans un lit a 0 (si jamais il y a eu un problème)
'''/bedtime reset'''

# Compiler
1. cloner le git
2. installer maven pour compiler le code
3. '''mvn clean compile package'''
4. recuperer le .jar BedTime-1.0 dans le dossier target
