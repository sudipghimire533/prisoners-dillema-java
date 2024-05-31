# Prisoners Dilemma
Simulation of unknown iteration of prisioners dillema.

## Structure
New models can be developed as long as it implement Playable interface.
Each player will be given the context of previous round and opponent move
Each player return one of Decision.Cooperate or Decision.Sniff.

We can configure how many iteration to play, but player won't have this information