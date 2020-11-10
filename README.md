# CS 5010 Homework 2
Homework requirement link: https://northeastern.instructure.com/courses/22319/assignments/614883

Built a backend role playing game which has two players. In many role-playing games (Links to an external site.), characters go into battle with some degree of attack and defense capabilities (represented as numerical values). These values can be modified by “wearing” different articles of clothing to either increase performance (attack) or minimize damage inflicted by other characters (defense). In this assignment, you are to represent the following types of clothing.

Head gear: These items go on the character’s head (hats/helmets/visors) and are only useful for defense.

Hand gear: These items go on the character’s hands (gloves/swords/shield) and are only used for attack. Since you have 2 hands, you can have 2 of these items.

Footwear: These items go on the character’s feet (boots/sneakers/hoverboard) and can be for attack or defense. Since you have 2 feet, you can have 2 of these items.

Each item has a name consisting of an adjective and a noun, in that order, and the amount that it modifies the character’s attack and defense values.

When the game starts out, the characters start with an attack power and a defense strength. As they go through the game, they can pick up new items to add to those two values. The following rules apply:

They cannot pick up more items that they can hold. This means that they are limited to:

One piece of head gear

Two pieces of footwear

Two pieces of hand gear

The character’s values do not change.

To be clever, when a character picks up two items of the same type, their names are combined, they make a new piece of footwear that combines the powers and name. The new name is the adjective from one item and the full name from the other. For instance, to combine

Scurrying Sandals -- defense strength: 1, attack strength 0

Happy HoverBoard -- defense strength: 3, attack strength 1

You get

Scurrying, Happy HoverBoard -- defense strength: 4, attack strength 1

Only items of the same type have their names combined.

Only two items may be combined; a combined item may not be combined with another item.
